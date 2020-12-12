package ltm.caro.server;

import ltm.caro.server.database.impl.PlayerDAO;
import ltm.caro.server.entity.Player;
import ltm.caro.util.Crypto;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.net.SocketException;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;


public class Worker implements Runnable {
	private int id;
	private Socket socket;
	private BufferedReader in;
	private BufferedWriter out;
	public Player player;
	public Match match;
	private Crypto crypto;

	public Worker(int index, Socket sk) {
		try {
			id = index;
			socket = sk;
			in = new BufferedReader(new InputStreamReader(sk.getInputStream()));
			out = new BufferedWriter(new OutputStreamWriter(sk.getOutputStream()));
			player = null;
			match = null;
			crypto = new Crypto();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	// Network

	private void connect() {
		Engine.log("Client ["+id+"]: "+getIP()+" connect.");
	}

	private void disconnect() {
		Engine.log("Client ["+getId()+"]: "+getIP()+" disconnect.");

		if (match != null) {
			int slotid = -1;
			int loop = match.workerList.size();
			for (int i=0; i<loop; i++) {
				if (match.workerList.get(i).player.getID() == player.getID()) {
					slotid = i;
					break;
				}
			}
			if (slotid > 1) {
				match.workerList.remove(this);
			} else if (slotid == 0) {
				match.end(2, -1, -1);
			} else if (slotid == 1) {
				match.end(1, -1, -1);
			}
		}
		Server.workers.remove(this);
	}

	public int getId() {
		return id;
	}

	public String getIP() {
		return socket.getInetAddress().getHostAddress();
	}

	public String receive() throws IOException {
		String input = in.readLine();
		if (input == null)
			return "";

		input = crypto.decrypt(input); // Giai ma
		return input;
	}

	public void send(String mes) {
		mes = crypto.encrypt(mes); // Ma hoa
		try {
			out.write(mes);
			out.newLine();
			out.flush();
		} catch (IOException e) {
			disconnect();
		}
	}

	public void sendResult(boolean result, String reason) {
		if (result)
			send("result yes");
		else
			send("result no " + reason);
	}

	private void close() throws IOException {
		Engine.log("Closed socket for client [" + id + "] " + socket.toString());
		in.close();
		out.close();
		socket.close();
	}

	// Command
	private void register(String account, String password, String email, boolean gender, String birthday) {
		boolean res = Engine.register(account, password, email, gender, birthday);
		if (res) sendResult(true, "");
		else sendResult(false, "register no Đăng ký thất bại");
	}

	private void resetpassword(String account, String email, String password) {
		PlayerDAO dao = new PlayerDAO();

		for (Worker w : Server.workers) // Tai khoan dang dang nhap
			if (w.player != null && w.player.getAccount().equals(account)) {
				sendResult(false, "Tài khoản đang đăng nhập");
				return;
			}

		Player p = dao.findByAccount(account);
		if (p == null || !p.getEmail().equals(email)) {
			sendResult(false, "Tài khoản hoặc email không đúng");
			return;
		}

		// kiem tra block
		if (p.getBlock()) {
			sendResult(false, "Tài khoản hoặc email không đúng");
			return;
		}

		p.setPassword(Engine.hashMD5(password));
		dao.update(p);

		sendResult(true, "");
		return;
	}

	private void resetpassword2(String oldPassword, String newPassword) {

		oldPassword = Engine.hashMD5(oldPassword);
		newPassword = Engine.hashMD5(newPassword);

		if (player.getPassword().equals(oldPassword)) {
			player.setPassword(newPassword);

			PlayerDAO dao = new PlayerDAO();
			dao.update(player);

			sendResult(true, "");
		} else sendResult(false, "Mật khẩu không khớp");
	}

	private void login(String account, String password) {
		Player tmpplayer = Engine.login(this, account, password);
		if (tmpplayer != null) {
			player = tmpplayer;
			send("login yes " + player.getID() + ' ' + player.getEmail() + ' ' +
					(player.getGender() ? "nam" : "nu") + ' ' + player.getBirthday());
		}
		else
			send("login no Tai khoan hoac mat khau khong dung");
	}

	private void logout() {
		player = null;
	}

	private void info() {
		if (player != null)
			send("info " +
					player.getScore() + ' ' +
					player.getWinNum() + ' ' +
					player.getLostNum() + ' ' +
					player.getWinStreakMax() + ' ' +
					player.getLostStreakMax());
		else
			sendResult(false, "Chua dang nhap tai khoan");
	}

	private void rank(int i) {

		String mes = "rank ";

		PlayerDAO dao = new PlayerDAO();
		List<Player> listPlayer = dao.findAll();

		switch (i) {
			case 0: // Diem
				listPlayer.sort((o1, o2) -> {
					if (o1.getScore() > o2.getScore()) return -1;
					else return 1;
				});
				while (listPlayer.size() > 10)
					listPlayer.remove(listPlayer.size()-1);
				for (Player p : listPlayer) {
					mes += p.getAccount()+' '+p.getScore()+' ';
				}
				break;
			case 1: // Winnum
				listPlayer.sort((o1, o2) -> {
					if (o1.getWinNum() > o2.getWinNum()) return -1;
					else return 1;
				});
				while (listPlayer.size() > 10)
					listPlayer.remove(listPlayer.size()-1);
				for (Player p : listPlayer) {
					mes += p.getAccount()+' '+p.getWinNum()+' ';
				}
				break;
			case 2: // Win streak
				listPlayer.sort((o1, o2) -> {
					if (o1.getWinStreakMax() > o2.getWinStreakMax()) return -1;
					else return 1;
				});
				while (listPlayer.size() > 10)
					listPlayer.remove(listPlayer.size()-1);
				for (Player p : listPlayer) {
					mes += p.getAccount()+' '+p.getWinStreakMax()+' ';
				}
				break;
			case 3: // Win rate
				listPlayer.sort((o1, o2) -> {
					if (o1.getWinRate() > o2.getWinRate()) return -1;
					else return 1;
				});
				List<Player> toRemove = new ArrayList<>();
				for (Player p : listPlayer) {
					if (p.getWinNum()+p.getLostNum() < 10)
						toRemove.add(p);
				}
				for (Player p : toRemove)
					listPlayer.remove(p);
				while (listPlayer.size() > 10)
					listPlayer.remove(listPlayer.size()-1);
				for (Player p : listPlayer) {
					mes += p.getAccount()+' '+p.getWinRate()+' ';
				}
				break;
		}
		send(mes);
	}

	private void refresh() {
		String data = "list ";
		for (Worker w : Server.workers) {
			if (w.match != null)
				continue;
			Player p = w.player;
			if (p != null && p.getID() != player.getID())
				data = data + p.getID() + ' ' + p.getAccount() + ' ';
		}
		data += "| ";
		for (Match m : Server.matchs) {
			String duelP = "["+m.getRoom().getPlayer1().getAccount()+"]vs["+m.getRoom().getPlayer2().getAccount()+']';
			data = data+(m.getIndex()+1)+' '+duelP+' ';
		}
		send(data);
	}

	private void request(String input) {
		if (player == null)
			return;

		StringTokenizer stk = new StringTokenizer(input);
		stk.nextToken(); // skip request
		String res = stk.nextToken();

		if (res.equals("yes")) { // Dong y
			int idplayer1 = Integer.parseInt(stk.nextToken());
			Worker w = findClient(idplayer1);
			if (w != null && w.match == null && match == null) { // nguoi choi con dang nhap, chua co tran dau
				match = w.match = Engine.createMatch(w, this);
				send("join 2 "+(match.getIndex()+1)+' '+w.player.getAccount());
				w.send("join 1 "+(match.getIndex()+1)+' '+player.getAccount());
			} else sendResult(false, "người chơi đã thoát hoặc đã vào trận khác");
		} else { // Gui yeu cau
			if (match != null) // Dang choi ko the moi !
				return;
			int idplayer2 = Integer.parseInt(res);
			Worker w2 = findClient(idplayer2);
			if (w2 != null && w2.match == null) { // Neu ton tai player va chua choi
				w2.send("request "+player.getID()+' '+player.getAccount());
			}
		}
	}

	private void spec(int idmatch) {
		idmatch--;
		if (match != null) // Khong the gui spec khi dang tham gia tran hoac xem tran khac
			return;

		for (Match m : Server.matchs) // Tim Tran bang id tran
			if (m.getIndex() == idmatch) {
				match = m;
				break;
			}

		if (match != null) { // Tim ko ra thi skip
			match.workerList.add(this); // Them player vao danh sach player trong phong

			String matStr = ""; // Chuyen ma tran caro thanh string
			int[][] mat = match.caro.getMatrix();
			for (int x=1; x<19; x++)
				for (int y=1; y<19; y++)
					matStr += String.valueOf(mat[x][y]) + ' ';

			String starttime = match.getRoom().getTimeBegin();
			if (starttime == null || starttime.isEmpty())
				starttime = "null";
			else
				starttime = starttime.replace(' ', ',');

			send("joinspec "+(match.getIndex()+1)+' '+match.getRoom().getPlayer1().getAccount()+' '+
					match.getRoom().getPlayer2().getAccount()+' '+starttime+' '+matStr); // Gui du lieu xem tran

			for (Worker w : match.workerList) // Thong bao cho tat ca player
				w.send("chat " + player.getAccount()+" đang xem");
		}
	}

	private void ready() {
		if (match != null) {
			match.setReady(player, true);
			for (Worker w : match.workerList)
				w.send("chat " + player.getAccount()+" đã sẵn sàng");

			if (match.getReady())
				match.start();
		}
	}

	private void play(int x, int y) {
		match.update(player, x, y);
	}

	private void outroom() {
		if (match.workerList.get(0).player.getID() == player.getID()) {
			for (Worker w : match.workerList)
				if (w.getId() != id)
					w.send("chat "+player.getAccount()+ " đã thoát");
			match.end(2, -1, -1);
		}
		else if (match.workerList.get(1).player.getID() == player.getID()) {
			for (Worker w : match.workerList)
				if (w.getId() != id)
					w.send("chat "+player.getAccount()+ " đã thoát");
			match.end(1, -1, -1);
		}
		else {
			match.workerList.remove(this); // spector
			for (Worker w : match.workerList)
				w.send("chat "+player.getAccount()+ " đã thoát");
			match = null;
		}
	}

	private void chat(String mes) {
		for (Worker w : match.workerList)
			w.send("chat [" + player.getAccount() + "]: " + mes);
	}

	public void run() {
		connect();
		try {
			String input = receive();
			while (true) {
				input = receive();
				if (input.isEmpty())
					continue;

				Engine.log("[" + ((player == null) ? "guest" : player.getAccount()) + "] " + input);
				StringTokenizer stk = new StringTokenizer(input);
				String cmd = stk.nextToken();

				if (cmd.equals("bye"))
					break;

				if (match != null) { // in game
					switch (cmd) {
						case "ready":
							ready();
							break;
						case "play":
							play(Integer.parseInt(stk.nextToken()), Integer.parseInt(stk.nextToken()));
							break;
						case "outroom":
							outroom();
							break;
						case "chat":
							chat(input.substring(5));
					}
				} else { // in lobby
					switch (cmd) {
						case "register":
							String account = stk.nextToken();
							String password = stk.nextToken();
							String email = stk.nextToken();
							boolean gender = stk.nextToken().equals("nam") ? true : false;
							String birthday = stk.nextToken();
							register(account, password, email, gender, birthday);
							break;
						case "resetpassword":
							resetpassword(stk.nextToken(), stk.nextToken(), stk.nextToken());
							break;
						case "resetpassword2":
							resetpassword2(stk.nextToken(), stk.nextToken());
							break;
						case "login":
							login(stk.nextToken(), stk.nextToken());
							break;
						case "logout":
							logout();
							break;
						case "info":
							info();
							break;
						case "rank":
							rank(Integer.parseInt(stk.nextToken()));
							break;
						case "updateinfo":
							PlayerDAO pDao = new PlayerDAO();
							player.setEmail(stk.nextToken());
							player.setGender(stk.nextToken().equals("nam"));
							player.setBirthday(stk.nextToken());
							pDao.update(player);
							sendResult(true, "");
							break;
						case "refresh":
							refresh();
							break;
						case "request":
							request(input);
							break;
						case "spec":
							spec(Integer.parseInt(stk.nextToken()));
							break;
					}
				}
			}
			close();
		} catch (IOException e) {
			if (e instanceof SocketException) {
				disconnect();
			}
		}
	}

	private Worker findClient(int idplayer) {
		for (Worker w : Server.workers)
			if (w.player != null && w.player.getID() == idplayer)
				return w;

		return null;
	}

}
