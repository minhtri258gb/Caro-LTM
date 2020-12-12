package ltm.caro.server;

import ltm.caro.server.database.impl.PlayerDAO;
import ltm.caro.server.database.impl.RoomDAO;
import ltm.caro.server.entity.Player;
import ltm.caro.server.entity.Room;

import java.io.*;
import java.util.List;
import java.util.StringTokenizer;


public class AdminCMD implements Runnable {

	@Override
	public void run() {
		try {
			BufferedReader stdIn = new BufferedReader(new InputStreamReader(System.in));
			label1:
			while (true) {
				String input = stdIn.readLine();
				if (input == null || input.isEmpty())
					continue;
				StringTokenizer stk = new StringTokenizer(input);
				String cmd = stk.nextToken();
				String param1, param2, param3;

				PlayerDAO pDao = new PlayerDAO();
				RoomDAO rDao = new RoomDAO();
				List<Player> listPlayer = null;
				List<Room> listRoom = null;
				Player player = null;
				Room room = null;

				label2:
				switch (cmd) {
					case "bye":
						break label1;
					case "user":
						if (stk.hasMoreTokens()) {
							param1 = stk.nextToken();
							switch (param1) {
								case "list": // Danh sách player
									listPlayer = pDao.findAll();
									for (Player p : listPlayer)
										System.out.println(p.getID()+". "+p.getAccount());
									break;
								case "block": case "unblock": // Chan tai khoan
									if (!stk.hasMoreTokens()) {
										System.out.println("Thiếu user ID");
										break label2;
									}
									param2 = stk.nextToken();
									player = null;
									try {
										int idplayer = Integer.parseInt(param2);
										player = pDao.findById(idplayer);
									} catch (NumberFormatException e) {
										System.out.println("ID không hợp lệ");
										break label2;
									}
									if (player == null)
										System.out.println("Không tìm thấy user");
									else {
										if (param1.equals("block")) {
											player.setBlock(true);
											pDao.update(player);
											System.out.println("user "+player.getAccount()+" đã bị chặn");
										} else {
											player.setBlock(false);
											pDao.update(player);
											System.out.println("user "+player.getAccount()+" đã bỏ chặn");
										}
									}
									break;
								case "top":
									if (!stk.hasMoreTokens()) {
										System.out.println("Thiếu tiêu chí (score, win, winstreak)");
										break label2;
									}
									param2 = stk.nextToken();
									switch (param2) {
										case "score":
											listPlayer = pDao.findAll();
											player = listPlayer.get(0);
											for (Player p : listPlayer)
												if (p.getScore() > player.getScore())
													player = p;
											System.out.println("Người chơi có diểm cao nhất là "+player.getAccount()+
													" với số diểm là "+player.getScore());
											break;
										case "winnum":
											listPlayer = pDao.findAll();
											player = listPlayer.get(0);
											for (Player p : listPlayer)
												if (player.getWinNum() > player.getWinNum())
													player = p;
											System.out.println("Người chơi có số lần thắng cao nhất là "+
													player.getAccount()+" với số lần thắng là "+player.getWinNum());
											break;
										case "winstreak":
											listPlayer = pDao.findAll();
											player = listPlayer.get(0);
											for (Player p : listPlayer)
												if (player.getWinStreak() > player.getWinStreak())
													player = p;
											System.out.println("Người chơi có chuỗi lần thắng cao nhất là "+
													player.getAccount()+" với chuỗi lần thắng là "+
													player.getWinStreak());
											break;
									}
									break;
							}
						} else { // Xem user online trên tổng user
							int totalUser = pDao.findAll().size(); // Get total user
							int onlineUser = 0;
							for (Worker w : Server.workers) // Get user online
								if (w.player != null)
									onlineUser++;
							System.out.println("User: "+onlineUser+'/'+totalUser);
						}
						break;
					case "room":
						if (stk.hasMoreTokens()) {
							param1 = stk.nextToken();
							switch (param1) {
								case "list": // Danh sach phong
									listRoom = rDao.findAll();
									for (Room r : listRoom)
										System.out.println(r.getId()+". "+r.getPlayer1().getAccount()+" vs "+
												r.getPlayer2().getAccount());
									break;
								case "show": // Xem thong tin phong
									if (!stk.hasMoreTokens()) {
										System.out.println("Thiếu id room");
										break label2;
									}
									param3 = stk.nextToken();

									room = null;
									try {
										int idroom = Integer.parseInt(param3);
										room = rDao.findById(idroom);
									} catch (NumberFormatException e) {
										System.out.println("id room phải là số");
										break label2;
									}

									if (room == null) {
										System.out.println("id room không hợp lệ");
										break label2;
									}

									System.out.println("Người chơi 1: "+room.getPlayer1().getAccount());
									System.out.println("Người chơi 2: "+room.getPlayer2().getAccount());
									System.out.print("Kết quả: ");
									switch (room.getResult()) {
										case 1: System.out.println("Người chơi 1 thắng"); break;
										case 2: System.out.println("Người chơi 2 thắng"); break;
										case 3: System.out.println("Hòa"); break;
									}
									System.out.println("Thời gian bắt đầu: "+room.getTimeBegin());
									System.out.println("Thời gian chơi: "+room.getDuration()+" giây");
									break;
								case "top":
									listRoom = rDao.findAll();
									room = listRoom.get(0);
									for (Room r : listRoom) {
										if (r.getDuration() < room.getDuration())
											room = r;
									}
									System.out.println("Trân đấu ngắn nhất là trận "+room.getId()+". "+
											room.getPlayer1().getAccount()+" vs "+room.getPlayer2().getAccount()+
											" với thời gian là: "+room.getDuration()+" giây");
									break;
							}
						}
						break;
				}

			}

			Server.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
