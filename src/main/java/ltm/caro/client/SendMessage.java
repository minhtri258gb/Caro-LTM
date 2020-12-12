package ltm.caro.client;

import java.io.BufferedWriter;
import java.io.IOException;
import java.net.Socket;


class SendMessage implements Runnable {
	private static Socket socket;
	private static BufferedWriter out;

	private int state;

	public SendMessage(Socket s, BufferedWriter o) {
		socket = s;
		out = o;

		state = 0;
	}

	// Network
	public static void send(String data) {
		try {
			data = Client.crypto.encrypt(data);
			out.write(data + '\n');
			out.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private void sendKey() throws IOException {
		out.write(Client.crypto.getKey());
		out.newLine();
		out.flush();
	}

	// Command
	public static void register(String account, String password, String email, boolean gender, String birthday) {
		send("register " + account + ' ' + password + ' ' + email + ' ' + (gender ? "nam" : "nu") + ' ' + birthday);
	}

	public static void login(String account, String password) {
		send("login " + account + ' ' + password);
	}

	public static void request(String idplayer) {
		send("request " + idplayer);
	}

	public static void request(boolean confirm, int idplayer) {
		if (confirm)
			send("request yes " + idplayer);
	}

	public static void play(int x, int y) {
		send("play " + x + ' ' + y);
	}

	public static void chat(String mes) {
		send("chat " + mes);
	}

	// State
	private boolean stateLogin() {
		RegisLogMissGUI.ins.setVisible(true);
		RegisLogMissGUI.ins.loginFlag = false;
		while (RegisLogMissGUI.ins.isVisible()) {
			if (RegisLogMissGUI.ins.loginFlag) {
				RegisLogMissGUI.ins.setVisible(false);
				state++;
				return true;
			}
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
			}
		}
		state = -1;
		return false;
	}

	private boolean stateLobby() {
		WaitRoomGUI.ins.setVisible(true);
		WaitRoomGUI.ins.setPlayer();
		send("refresh");
		while (WaitRoomGUI.ins.isVisible()) {
			if (WaitRoomGUI.ins.logoutFlag) {
				WaitRoomGUI.ins.logoutFlag = false;
				send("logout");
				WaitRoomGUI.ins.setVisible(false);
				InfoUpdateGUI.ins.setVisible(false);
				AchievementsGUI.ins.setVisible(false);
				state = 0;
				return true;
			} else if (WaitRoomGUI.ins.joinFlag) {
				WaitRoomGUI.ins.joinFlag = false;
				WaitRoomGUI.ins.setVisible(false);
				InfoUpdateGUI.ins.setVisible(false);
				AchievementsGUI.ins.setVisible(false);
				state = 2;
				return true;
			}
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
			}
		}
		state = -1;
		return false;
	}

	private boolean stateGame() {
		GameScreenGUI.ins.setVisible(true);
		GameScreenGUI.ins.newSession();

		while (GameScreenGUI.ins.isVisible()) {
			if (GameScreenGUI.ins.outFlag && GameScreenGUI.ins.endFlag) {
				GameScreenGUI.ins.outFlag = GameScreenGUI.ins.endFlag = false;
				GameScreenGUI.ins.setVisible(false);
				state = 1;
				return true;
			}
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
			}
		}
		state = -1;
		return false;
	}

	public void run() {
		try {
			sendKey();

			// GUI
			statelabel:
			while (true) {
				switch (state) {
					case 0:
						if (!stateLogin())
							break statelabel;
						break;
					case 1:
						if (!stateLobby())
							break statelabel;
						break;
					case 2:
						if (!stateGame())
							break statelabel;
						break;
					default:
						break statelabel;
				}
			}

			// CONSOLE
//			BufferedReader stdIn = new BufferedReader(new InputStreamReader(System.in));
//			label:
//			while (true) {
//				String input = stdIn.readLine();
//				switch (input) {
//					case "bye":
//						break label;
//					case "login1":
//						login("minhtri@gmail.com", "123456");
//						break;
//					case "login2":
//						login("quoctrung@gmail.com", "123456");
//						break;
//					case "login3":
//						login("chitrung@gmail.com", "123456");
//						break;
//					case "register":
//						register("minhtri", "123456", "minhtri@gmail.com", "", true, "1999-1-1");
//						register("quoctrung", "123456", "quoctrung@gmail.com", "", true, "1999-1-1");
//						register("chitrung", "123456", "chitrung@gmail.com", "", true, "1999-1-1");
//						break;
//					case "request":
//						request(1);
//						break;
//					default:
//						send(input);
//				}
//			}

			Client.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
