package ltm.caro.client;

import ltm.caro.server.entity.Player;

import javax.swing.*;
import java.util.StringTokenizer;

public class WaitRoomGUI extends javax.swing.JFrame {

	public WaitRoomGUI() {
		init();
		initComponents();
		this.setLocationRelativeTo(null);
	}

	@SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jP_Lobby = new javax.swing.JPanel();
        jP_InfoAccount = new javax.swing.JPanel();
        jLb_Name = new javax.swing.JLabel();
        jLb_Mail = new javax.swing.JLabel();
        jLb_Sex = new javax.swing.JLabel();
        jLb_Date = new javax.swing.JLabel();
        jLb_txtName = new javax.swing.JLabel();
        jLb_txtMail = new javax.swing.JLabel();
        jLb_txtSex = new javax.swing.JLabel();
        jLb_txtDate = new javax.swing.JLabel();
        jBt_Achievement = new javax.swing.JLabel();
        jBt_Logout = new javax.swing.JLabel();
        jBt_Refesh = new javax.swing.JLabel();
        jBt_Update = new javax.swing.JLabel();
        jP_ListRoom = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jList_Rooms = new javax.swing.JList<>();
        jP_ListPlayer = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jList_Players = new javax.swing.JList<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Cờ Caro");
        setBackground(new java.awt.Color(19, 59, 84));
        setPreferredSize(new java.awt.Dimension(635, 420));
        setResizable(false);
        setSize(new java.awt.Dimension(635, 420));

        jP_Lobby.setBackground(new java.awt.Color(19, 59, 84));
        jP_Lobby.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Phòng chờ", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 1, 18), new java.awt.Color(255, 255, 255))); // NOI18N
        jP_Lobby.setForeground(new java.awt.Color(255, 255, 255));
        jP_Lobby.setPreferredSize(new java.awt.Dimension(620, 384));

        jP_InfoAccount.setBackground(new java.awt.Color(19, 59, 84));
        jP_InfoAccount.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Thông tin tài khoản", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 0, 13), new java.awt.Color(255, 255, 255))); // NOI18N
        jP_InfoAccount.setPreferredSize(new java.awt.Dimension(588, 127));

        jLb_Name.setFont(new java.awt.Font("Arial", 1, 13)); // NOI18N
        jLb_Name.setForeground(new java.awt.Color(255, 255, 255));
        jLb_Name.setText("Tên tài khoản:");

        jLb_Mail.setFont(new java.awt.Font("Arial", 1, 13)); // NOI18N
        jLb_Mail.setForeground(new java.awt.Color(255, 255, 255));
        jLb_Mail.setText("Mail:");

        jLb_Sex.setFont(new java.awt.Font("Arial", 1, 13)); // NOI18N
        jLb_Sex.setForeground(new java.awt.Color(255, 255, 255));
        jLb_Sex.setText("Giới tính:");

        jLb_Date.setFont(new java.awt.Font("Arial", 1, 13)); // NOI18N
        jLb_Date.setForeground(new java.awt.Color(255, 255, 255));
        jLb_Date.setText("Ngày sinh:");

        jLb_txtName.setFont(new java.awt.Font("Arial", 0, 13)); // NOI18N
        jLb_txtName.setForeground(new java.awt.Color(255, 255, 255));
        jLb_txtName.setText("Trần Quốc Trung");

        jLb_txtMail.setFont(new java.awt.Font("Arial", 0, 13)); // NOI18N
        jLb_txtMail.setForeground(new java.awt.Color(255, 255, 255));
        jLb_txtMail.setText("tranquoctrung20071999@gmail.com");

        jLb_txtSex.setFont(new java.awt.Font("Arial", 0, 13)); // NOI18N
        jLb_txtSex.setForeground(new java.awt.Color(255, 255, 255));
        jLb_txtSex.setText("Nam");

        jLb_txtDate.setFont(new java.awt.Font("Arial", 0, 13)); // NOI18N
        jLb_txtDate.setForeground(new java.awt.Color(255, 255, 255));
        jLb_txtDate.setText("20-07-1999");

        jBt_Achievement.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/bt_Achieve.png"))); // NOI18N
        jBt_Achievement.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jBt_AchievementMouseClicked(evt);
            }
        });

        jBt_Logout.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/bt_Logout.png"))); // NOI18N
        jBt_Logout.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jBt_LogoutMouseClicked(evt);
            }
        });

        jBt_Refesh.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/bt_refesh.png"))); // NOI18N
        jBt_Refesh.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jBt_RefeshMouseClicked(evt);
            }
        });

        jBt_Update.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/bt_updateinfo.png"))); // NOI18N
        jBt_Update.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jBt_UpdateMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jP_InfoAccountLayout = new javax.swing.GroupLayout(jP_InfoAccount);
        jP_InfoAccount.setLayout(jP_InfoAccountLayout);
        jP_InfoAccountLayout.setHorizontalGroup(
            jP_InfoAccountLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jP_InfoAccountLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jP_InfoAccountLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jP_InfoAccountLayout.createSequentialGroup()
                        .addComponent(jLb_Name)
                        .addGap(18, 18, 18)
                        .addComponent(jLb_txtName))
                    .addGroup(jP_InfoAccountLayout.createSequentialGroup()
                        .addComponent(jLb_Mail)
                        .addGap(18, 18, 18)
                        .addComponent(jLb_txtMail))
                    .addGroup(jP_InfoAccountLayout.createSequentialGroup()
                        .addComponent(jLb_Sex)
                        .addGap(18, 18, 18)
                        .addComponent(jLb_txtSex))
                    .addGroup(jP_InfoAccountLayout.createSequentialGroup()
                        .addComponent(jLb_Date)
                        .addGap(18, 18, 18)
                        .addComponent(jLb_txtDate)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jP_InfoAccountLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jBt_Achievement)
                    .addComponent(jBt_Refesh))
                .addGap(18, 18, 18)
                .addGroup(jP_InfoAccountLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jBt_Logout, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jBt_Update, javax.swing.GroupLayout.Alignment.TRAILING))
                .addGap(18, 18, 18))
        );
        jP_InfoAccountLayout.setVerticalGroup(
            jP_InfoAccountLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jP_InfoAccountLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jP_InfoAccountLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jP_InfoAccountLayout.createSequentialGroup()
                        .addGroup(jP_InfoAccountLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jBt_Achievement)
                            .addComponent(jBt_Logout))
                        .addGap(18, 18, 18)
                        .addGroup(jP_InfoAccountLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jBt_Refesh)
                            .addComponent(jBt_Update)))
                    .addGroup(jP_InfoAccountLayout.createSequentialGroup()
                        .addGroup(jP_InfoAccountLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLb_Name)
                            .addComponent(jLb_txtName))
                        .addGap(6, 6, 6)
                        .addGroup(jP_InfoAccountLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLb_Mail)
                            .addComponent(jLb_txtMail))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jP_InfoAccountLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLb_Sex)
                            .addComponent(jLb_txtSex))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jP_InfoAccountLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLb_Date)
                            .addComponent(jLb_txtDate))))
                .addGap(261, 261, 261))
        );

        jP_ListRoom.setBackground(new java.awt.Color(19, 59, 84));
        jP_ListRoom.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Danh sách phòng:", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 0, 13), new java.awt.Color(255, 255, 255))); // NOI18N
        jP_ListRoom.setPreferredSize(new java.awt.Dimension(290, 210));

        jList_Rooms.setBackground(new java.awt.Color(108, 122, 137));
        jList_Rooms.setFont(new java.awt.Font("Arial", 0, 13)); // NOI18N
        jList_Rooms.setForeground(new java.awt.Color(255, 255, 255));
        jList_Rooms.setModel(listRoom);
        jList_Rooms.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jList_RoomsMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(jList_Rooms);

        javax.swing.GroupLayout jP_ListRoomLayout = new javax.swing.GroupLayout(jP_ListRoom);
        jP_ListRoom.setLayout(jP_ListRoomLayout);
        jP_ListRoomLayout.setHorizontalGroup(
            jP_ListRoomLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 280, Short.MAX_VALUE)
        );
        jP_ListRoomLayout.setVerticalGroup(
            jP_ListRoomLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 187, Short.MAX_VALUE)
        );

        jP_ListPlayer.setBackground(new java.awt.Color(19, 59, 84));
        jP_ListPlayer.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Phòng chờ:", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 0, 13), new java.awt.Color(255, 255, 255))); // NOI18N
        jP_ListPlayer.setPreferredSize(new java.awt.Dimension(290, 210));

        jList_Players.setBackground(new java.awt.Color(108, 122, 137));
        jList_Players.setFont(new java.awt.Font("Arial", 0, 13)); // NOI18N
        jList_Players.setForeground(new java.awt.Color(255, 255, 255));
        jList_Players.setModel(listPlayer);
        jList_Players.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jList_PlayersMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jList_Players);

        javax.swing.GroupLayout jP_ListPlayerLayout = new javax.swing.GroupLayout(jP_ListPlayer);
        jP_ListPlayer.setLayout(jP_ListPlayerLayout);
        jP_ListPlayerLayout.setHorizontalGroup(
            jP_ListPlayerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 280, Short.MAX_VALUE)
        );
        jP_ListPlayerLayout.setVerticalGroup(
            jP_ListPlayerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 187, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jP_LobbyLayout = new javax.swing.GroupLayout(jP_Lobby);
        jP_Lobby.setLayout(jP_LobbyLayout);
        jP_LobbyLayout.setHorizontalGroup(
            jP_LobbyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jP_LobbyLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jP_LobbyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jP_InfoAccount, javax.swing.GroupLayout.DEFAULT_SIZE, 586, Short.MAX_VALUE)
                    .addGroup(jP_LobbyLayout.createSequentialGroup()
                        .addComponent(jP_ListPlayer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jP_ListRoom, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jP_LobbyLayout.setVerticalGroup(
            jP_LobbyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jP_LobbyLayout.createSequentialGroup()
                .addComponent(jP_InfoAccount, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jP_LobbyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jP_ListPlayer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jP_ListRoom, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 12, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jP_Lobby, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jP_Lobby, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

	private void jList_RoomsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jList_RoomsMouseClicked
		String name = jList_Rooms.getSelectedValue();
		if (name == null || name.equals("trống"))
			return;
		String idStr = name.substring(0, name.indexOf(' '));
		SoundPack.clicka();
		if (Client.confirm("Có muốn xem trận đấu "+idStr+'?') == 0)
			SendMessage.send("spec "+idStr);
	}//GEN-LAST:event_jList_RoomsMouseClicked

	private void jList_PlayersMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jList_PlayersMouseClicked
		String name = jList_Players.getSelectedValue();
		if (name == null || name.equals("trống"))
			return;

		int pos = name.indexOf(' ');
		String nameTar = name.substring(pos+1);
		SoundPack.clicka();
		if (Client.confirm("Gửi yêu cầu đến "+nameTar+'?') == 0)
			SendMessage.request(name.substring(0, pos));

	}//GEN-LAST:event_jList_PlayersMouseClicked

    private void jBt_LogoutMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jBt_LogoutMouseClicked
		SoundPack.clickb();
		if (Client.confirm("Có muốn đăng xuất không?") == 0) {
			logoutFlag = true;
			Client.player = null;
		}
    }//GEN-LAST:event_jBt_LogoutMouseClicked

    private void jBt_AchievementMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jBt_AchievementMouseClicked
		SoundPack.clickb();
		AchievementsGUI.ins.setVisible(true);
        SendMessage.send("info");
        SendMessage.send("rank 0");
    }//GEN-LAST:event_jBt_AchievementMouseClicked

    private void jBt_RefeshMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jBt_RefeshMouseClicked
		SoundPack.clickb();
		SendMessage.send("refresh");
    }//GEN-LAST:event_jBt_RefeshMouseClicked

    private void jBt_UpdateMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jBt_UpdateMouseClicked
		SoundPack.clickb();
		InfoUpdateGUI.ins.setVisible(true);
		InfoUpdateGUI.ins.setPlayer();
    }//GEN-LAST:event_jBt_UpdateMouseClicked

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jBt_Achievement;
    private javax.swing.JLabel jBt_Logout;
    private javax.swing.JLabel jBt_Refesh;
    private javax.swing.JLabel jBt_Update;
    private javax.swing.JLabel jLb_Date;
    private javax.swing.JLabel jLb_Mail;
    private javax.swing.JLabel jLb_Name;
    private javax.swing.JLabel jLb_Sex;
    private javax.swing.JLabel jLb_txtDate;
    private javax.swing.JLabel jLb_txtMail;
    private javax.swing.JLabel jLb_txtName;
    private javax.swing.JLabel jLb_txtSex;
    private javax.swing.JList<String> jList_Players;
    private javax.swing.JList<String> jList_Rooms;
    private javax.swing.JPanel jP_InfoAccount;
    private javax.swing.JPanel jP_ListPlayer;
    private javax.swing.JPanel jP_ListRoom;
    private javax.swing.JPanel jP_Lobby;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    // End of variables declaration//GEN-END:variables


	// Massan code
	public static WaitRoomGUI ins = new WaitRoomGUI();

	public DefaultListModel<String> listPlayer;
	public DefaultListModel<String> listRoom;

	public boolean logoutFlag, joinFlag;


	private void init() {
		listPlayer = new DefaultListModel<>();
		listRoom = new DefaultListModel<>();
		listPlayer.addElement("trống");
		listRoom.addElement("trống");

		logoutFlag = joinFlag = false;
	}

	public void setPlayer() {
		Player p = Client.player;
		jLb_txtName.setText(p.getAccount());
		jLb_txtMail.setText(p.getEmail());
		jLb_txtSex.setText(p.getGender()?"nam":"nữ");
		jLb_txtDate.setText(p.getBirthday());
	}

	public void refresh(String listPlayerStr, String listMatchStr) {
		listPlayer.removeAllElements();
		if (!listPlayerStr.isEmpty()) {
			StringTokenizer stk = new StringTokenizer(listPlayerStr);
			while (stk.hasMoreTokens())
				listPlayer.addElement(stk.nextToken()+' '+stk.nextToken());
		} else {
			listPlayer.addElement("trống");
		}

		listRoom.removeAllElements();
		if (!listMatchStr.isEmpty()) {
			StringTokenizer stk = new StringTokenizer(listMatchStr);
			while (stk.hasMoreTokens())
				listRoom.addElement(stk.nextToken()+' '+stk.nextToken());
		} else {
			listRoom.addElement("trống");
		}
	}

}
