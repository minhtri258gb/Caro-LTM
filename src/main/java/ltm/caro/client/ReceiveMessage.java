package ltm.caro.client;

import ltm.caro.server.Engine;
import ltm.caro.util.DateTimeUtil;

import java.io.BufferedReader;
import java.io.IOException;
import java.net.Socket;
import java.time.LocalTime;
import java.util.Date;
import java.util.StringTokenizer;


class ReceiveMessage implements Runnable {
	private BufferedReader in;
	private Socket socket;

	public ReceiveMessage(Socket s, BufferedReader i) {
		this.socket = s;
		this.in = i;
	}

	private String receive() throws IOException {
		String input = in.readLine();
		if (input == null)
			return "";

		return Client.crypto.decrypt(input); // giai ma hoa
	}

	private void result(String res, String reason) {
		if (res.equals("yes"))
			Client.notice("Thành công");
		else {
			SoundPack.error();
			Client.notice("Thất bại: " + reason);
		}
	}

	private void list(String input) {
		int pos = input.indexOf('|');
		String listPlayerStr = input.substring(5, pos);
		String listMatchStr = input.substring(pos + 2);

		WaitRoomGUI.ins.refresh(listPlayerStr, listMatchStr);
	}

	private void start(boolean turn) {
		CountDown.setRoundTime(LocalTime.now());
		SoundPack.turn();
		GameScreenGUI.ins.turnPlay(turn, -1, -1);
	}

	private void turn(boolean turn, int x, int y) {
		CountDown.turn();
		SoundPack.turn();
		GameScreenGUI.ins.turnPlay(turn, x, y);
	}

	private void end(int winner, int x, int y) {
		GameScreenGUI.ins.turnPlay(false, x, y);

		if (!GameScreenGUI.ins.specFlag) {
			if (winner == 3)
				SoundPack.draw();
			else if (GameScreenGUI.ins.isCross && winner == 1 ||
					!GameScreenGUI.ins.isCross && winner == 2)
				SoundPack.win();
			else
				SoundPack.lost();
		} else SoundPack.draw();

		switch (winner) {
			case 1: Client.notice(GameScreenGUI.ins.namePlayer1+" chiến thắng"); break;
			case 2: Client.notice(GameScreenGUI.ins.namePlayer2+" chiến thắng"); break;
			case 3: Client.notice("Hòa"); break;
		}
		CountDown.end();
		GameScreenGUI.ins.endSession();
		GameScreenGUI.ins.namePlayer1 = GameScreenGUI.ins.namePlayer2 = "";
		GameScreenGUI.ins.endFlag = true;
	}

	private void chat(String mes) {
		GameScreenGUI.ins.addChat(mes);
	}

	public void run() {
		try {
			while (true) {
				String input = receive();
				if (input.isEmpty())
					continue;

				Engine.log("[Server] " + input);
				StringTokenizer stk = new StringTokenizer(input);
				String cmd = stk.nextToken();

				// Variable TMP
				int x, y, winner;
				boolean turn;

				switch (cmd) {
					case "login":
						if(stk.nextToken().equals("yes")) {
							RegisLogMissGUI.ins.loginFlag = true;
							Client.player.setID(Integer.parseInt(stk.nextToken()));
							Client.player.setEmail(stk.nextToken());
							Client.player.setGender(stk.nextToken().equals("nam"));
							Client.player.setBirthday(stk.nextToken());
						} else {
							Client.notice(input.substring(9));
						}
						break;
					case "result":
						result(stk.nextToken(), (stk.hasMoreTokens() ? input.substring(10) : ""));
						break;
					case "info":
						Client.player.setScore(Integer.parseInt(stk.nextToken()));
						Client.player.setWinNum(Integer.parseInt(stk.nextToken()));
						Client.player.setLostNum(Integer.parseInt(stk.nextToken()));
						Client.player.setWinStreakMax(Integer.parseInt(stk.nextToken()));
						Client.player.setLostStreakMax(Integer.parseInt(stk.nextToken()));
						AchievementsGUI.ins.setInfo();
						break;
					case "rank":
						AchievementsGUI.ins.setRank(input.substring(5));
						break;
					case "list":
						list(input);
						break;
					case "join":
						int cross = Integer.parseInt(stk.nextToken());
						GameScreenGUI.ins.roomNum = Integer.parseInt(stk.nextToken());
						if (cross == 1) {
							GameScreenGUI.ins.isCross = true;
							GameScreenGUI.ins.namePlayer1 = Client.player.getAccount();
							GameScreenGUI.ins.namePlayer2 = stk.nextToken();
						} else {
							GameScreenGUI.ins.isCross = false;
							GameScreenGUI.ins.namePlayer1 = stk.nextToken();
							GameScreenGUI.ins.namePlayer2 = Client.player.getAccount();
						}
						GameScreenGUI.ins.specFlag = false;
						WaitRoomGUI.ins.joinFlag = true;
						break;
					case "joinspec":
						GameScreenGUI.ins.roomNum = Integer.parseInt(stk.nextToken());
						GameScreenGUI.ins.namePlayer1 = stk.nextToken();
						GameScreenGUI.ins.namePlayer2 = stk.nextToken();
						GameScreenGUI.ins.specFlag = true;
						WaitRoomGUI.ins.joinFlag = true;

						String starttimeStr = stk.nextToken();
						if (!starttimeStr.equals("null")) {
							Date starttimeDat = DateTimeUtil.covStringToDateTime(starttimeStr.replace(',', ' '));
							LocalTime starttimeLoc = DateTimeUtil.covDateToLocalTime(starttimeDat);
							CountDown.setRoundTime(starttimeLoc);
						}

						int[][] mat = new int[18][18];
						for (int i=0; i<18; i++)
							for (int j=0; j<18; j++)
								mat[i][j] = Integer.parseInt(stk.nextToken());
						GameScreenGUI.ins.mat = mat;
						break;
					case "request":
						int idplayer = Integer.parseInt(stk.nextToken());
						String nameEnemy = stk.nextToken();
						if (Client.confirm(nameEnemy+" thách đấu!") == 0)
							SendMessage.send("request yes "+idplayer);
						break;
					case "start":
						turn = stk.nextToken().equals("yes");
						start(turn);
						break;
					case "turn":
						turn = stk.nextToken().equals("yes");
						x = Integer.parseInt(stk.nextToken());
						y = Integer.parseInt(stk.nextToken());
						turn(turn, x, y);
						break;
					case "end":
						winner = Integer.parseInt(stk.nextToken());
						x = Integer.parseInt(stk.nextToken());
						y = Integer.parseInt(stk.nextToken());
						end(winner, x, y);
						break;
					case "chat":
						chat(input.substring(5));
						break;
				}
			}
		} catch (IOException e) {

		}
	}
}
