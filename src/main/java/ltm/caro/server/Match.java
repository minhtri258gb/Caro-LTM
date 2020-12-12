package ltm.caro.server;

import ltm.caro.server.database.impl.PlayerDAO;
import ltm.caro.server.database.impl.RoomDAO;
import ltm.caro.server.entity.Player;
import ltm.caro.server.entity.Room;
import ltm.caro.util.DateTimeUtil;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


public class Match {
	// CONST
	public static final int WIN_SCORE = 60;
	public static final int LOST_SCORE = 20;
	public static final int DRAW_SCORE = 30;
	public static final int MAX_ROUNDTIME = 600; // 10 phut
	public static final int MAX_TURNTIME = 30; // 30 giay

	private static int totalIndex = 0;

	private final int index;
	private final Room room;
	public Caro caro;
	public List<Worker> workerList;
	private LocalTime timeturn;
	private boolean isTurnP1, isEnd;

	// Game process
	private boolean isReady1, isReady2;

	public Match() {
		index = totalIndex++;
		room = new Room();
		caro = new Caro();
		workerList = new ArrayList<>();
		isReady1 = isReady2 = false;
		isTurnP1 = true;
		isEnd = false;
	}

	public int getIndex() {
		return index;
	}

	public Room getRoom() {
		return room;
	}

	public void setReady(Player p, boolean ready) {
		if (p.getID() == room.getPlayer1().getID())
			isReady1 = true;
		else if (p.getID() == room.getPlayer2().getID())
			isReady2 = true;
	}

	public boolean getReady() {
		return (isReady1 && isReady2);
	}

	public LocalTime getTimeTurn() {
		return timeturn;
	}

	public void start() {
		room.setTimeBegin(DateTimeUtil.covDateTimeToString(null));

		changeturn(-1, -1);

		timeturn = LocalTime.now();
		isTurnP1 = true;

		workerList.get(0).send("start yes");

		int loop = workerList.size();
		for (int i = 1; i < loop; i++)
			workerList.get(i).send("start no");
	}

	public void update(Player p, int x, int y) {
		// Kiem tra luot
		if (p.getID() == workerList.get(0).player.getID() && !isTurnP1 ||
				p.getID() == workerList.get(1).player.getID() && isTurnP1)
			return;

		// Kiem tra thoi gian toan bo tran dau
		int win = 0;

		// Update caro
		if (p.getID() == room.getPlayer1().getID())
			caro.update(true, x, y);
		else if (p.getID() == room.getPlayer2().getID())
			caro.update(false, x, y);

		win = caro.getWin(); // Lay ket qua: 0: chua co, 1: p1 thang, 2: p2 thang

		if (win != 0) {
			end(win, x, y);
			return;
		}

		changeturn(x, y);
	}

	public void changeturn(int x, int y) {
		if (isTurnP1) {
			workerList.get(0).send("turn no " + x + ' ' + y);
			workerList.get(1).send("turn yes " + x + ' ' + y);
		} else {
			workerList.get(0).send("turn yes " + x + ' ' + y);
			workerList.get(1).send("turn no " + x + ' ' + y);
		}

		int loop = workerList.size();
		for (int i = 2; i < loop; i++)
			workerList.get(i).send("turn no " + x + ' ' + y);

		timeturn = LocalTime.now();
		isTurnP1 = !isTurnP1;
	}

	public void end(int win, int x, int y) {
		if (win <= 0 || win > 3) // Kiem tra ket qua hop le
			return;

		if (isEnd) // Skip spam end
			return;
		isEnd = true;

		isReady1 = isReady2 = false;

		int duration = 0; // get duration
		if (room.getTimeBegin() == null || room.getTimeBegin().isEmpty()) { // truong hop chua start
			room.setTimeBegin(DateTimeUtil.covDateTimeToString(null));
		} else { // truong hop da start
			Date starttime = DateTimeUtil.covStringToDateTime(room.getTimeBegin());
			duration = (int)((new Date()).getTime()-starttime.getTime())/1000;
		}

		// Luu database
		RoomDAO dao = new RoomDAO();
		room.setResult(win);
		room.setDuration(duration);
		dao.save(room);

		// Thiet lap diem cho nguoi choi va luu database
		Player p1 = workerList.get(0).player;
		Player p2 = workerList.get(1).player;

		switch (win) {
			case 1:
				p1.setScore(p1.getScore() + WIN_SCORE);
				p2.setScore(p2.getScore() + LOST_SCORE);
				p1.setWinNum(p1.getWinNum() + 1);
				p2.setLostNum(p2.getLostNum() + 1);
				p1.setWinStreak(p1.getWinStreak() + 1);
				p1.setLostStreak(0);
				if (p1.getWinStreak() > p1.getWinStreakMax())
					p1.setWinStreakMax(p1.getWinStreak());
				p2.setLostStreak(p2.getLostStreak() + 1);
				p2.setWinStreak(0);
				if (p2.getLostStreak() > p2.getLostStreakMax())
					p2.setLostStreakMax(p2.getLostStreak());
				break;
			case 2:
				p2.setScore(p2.getScore() + WIN_SCORE);
				p1.setScore(p1.getScore() + LOST_SCORE);
				p2.setWinNum(p2.getWinNum() + 1);
				p1.setLostNum(p1.getLostNum() + 1);
				p2.setWinStreak(p2.getWinStreak() + 1);
				p2.setLostStreak(0);
				if (p2.getWinStreak() > p2.getWinStreakMax())
					p2.setWinStreakMax(p2.getWinStreak());
				p1.setLostStreak(p1.getLostStreak() + 1);
				p1.setWinStreak(0);
				if (p1.getLostStreak() > p1.getLostStreakMax())
					p1.setLostStreakMax(p1.getLostStreak());
				break;
			case 3:
				p1.setScore(p1.getScore() + DRAW_SCORE);
				p1.setWinStreak(0);
				p1.setLostStreak(0);
				p2.setScore(p2.getScore() + DRAW_SCORE);
				p1.setWinStreak(0);
				p1.setLostStreak(0);
				break;
		}

		PlayerDAO pDAO = new PlayerDAO();
		pDAO.update(p1);
		pDAO.update(p2);

		Server.matchs.remove(workerList.get(0).match); // Xoa tran dau khoi danh sach cac tran dau

		for (Worker w : workerList) { // Gui ket qua tran dau
			w.send("end "+win+' '+x+' '+y);
			w.match = null;
		}
	}

}
