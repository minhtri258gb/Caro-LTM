package ltm.caro.client;

import ltm.caro.util.DateTimeUtil;

import java.awt.CardLayout;
import java.util.Date;

public class InfoUpdateGUI extends javax.swing.JFrame {
	CardLayout cardLayout;
	public InfoUpdateGUI() {
		initComponents();
		cardLayout = (CardLayout)(jP_Main.getLayout());
		this.setLocationRelativeTo(null);
	}

	@SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btG_Sex = new javax.swing.ButtonGroup();
        jP_Main = new javax.swing.JPanel();
        jP_InfoUpdate = new javax.swing.JPanel();
        jTF_AccName = new javax.swing.JTextField();
        jLb_Username = new javax.swing.JLabel();
        jLb_Mail = new javax.swing.JLabel();
        jTF_Mail = new javax.swing.JTextField();
        jLb_Sex = new javax.swing.JLabel();
        jRbt_Male = new javax.swing.JRadioButton();
        jRbt_Female = new javax.swing.JRadioButton();
        jLb_Birthday = new javax.swing.JLabel();
        jDC_Date = new com.toedter.calendar.JDateChooser();
        jBt_Back = new javax.swing.JLabel();
        jBt_Update = new javax.swing.JLabel();
        jP_ResetPass = new javax.swing.JPanel();
        jPF_OldPassword = new javax.swing.JPasswordField();
        jLb_Password = new javax.swing.JLabel();
        jLb_RePassword = new javax.swing.JLabel();
        jPF_RePassword = new javax.swing.JPasswordField();
        jLb_Password1 = new javax.swing.JLabel();
        jPF_NewPassword = new javax.swing.JPasswordField();
        jBt_Back2 = new javax.swing.JLabel();
        jBt_UpdatePass = new javax.swing.JLabel();
        jMB_RegisLog = new javax.swing.JMenuBar();
        jM_Update = new javax.swing.JMenu();
        jM_ResetPass = new javax.swing.JMenu();

        setTitle("Cờ Caro");
        setPreferredSize(new java.awt.Dimension(415, 370));
        setResizable(false);
        setSize(new java.awt.Dimension(415, 370));

        jP_Main.setBackground(new java.awt.Color(19, 59, 84));
        jP_Main.setLayout(new java.awt.CardLayout());

        jP_InfoUpdate.setBackground(new java.awt.Color(19, 59, 84));
        jP_InfoUpdate.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Cập nhật thông tin ", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 1, 18), new java.awt.Color(255, 255, 255))); // NOI18N
        jP_InfoUpdate.setPreferredSize(new java.awt.Dimension(415, 310));

        jTF_AccName.setEditable(false);
        jTF_AccName.setBackground(new java.awt.Color(108, 122, 137));
        jTF_AccName.setFont(new java.awt.Font("Arial", 0, 13)); // NOI18N
        jTF_AccName.setForeground(new java.awt.Color(255, 255, 255));
        jTF_AccName.setPreferredSize(new java.awt.Dimension(170, 25));

        jLb_Username.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        jLb_Username.setForeground(new java.awt.Color(255, 255, 255));
        jLb_Username.setText("Tên tài khoản:");

        jLb_Mail.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        jLb_Mail.setForeground(new java.awt.Color(255, 255, 255));
        jLb_Mail.setText("Mail:");

        jTF_Mail.setBackground(new java.awt.Color(108, 122, 137));
        jTF_Mail.setFont(new java.awt.Font("Arial", 0, 13)); // NOI18N
        jTF_Mail.setForeground(new java.awt.Color(255, 255, 255));
        jTF_Mail.setPreferredSize(new java.awt.Dimension(170, 25));

        jLb_Sex.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        jLb_Sex.setForeground(new java.awt.Color(255, 255, 255));
        jLb_Sex.setText("Giới Tính:");

        jRbt_Male.setBackground(new java.awt.Color(19, 59, 84));
        btG_Sex.add(jRbt_Male);
        jRbt_Male.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jRbt_Male.setForeground(new java.awt.Color(255, 255, 255));
        jRbt_Male.setText("Nam");

        jRbt_Female.setBackground(new java.awt.Color(19, 59, 84));
        btG_Sex.add(jRbt_Female);
        jRbt_Female.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jRbt_Female.setForeground(new java.awt.Color(255, 255, 255));
        jRbt_Female.setText("Nữ");

        jLb_Birthday.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        jLb_Birthday.setForeground(new java.awt.Color(255, 255, 255));
        jLb_Birthday.setText("Ngày sinh:");

        jDC_Date.setPreferredSize(new java.awt.Dimension(170, 25));

        jBt_Back.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/bt_Back.png"))); // NOI18N
        jBt_Back.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jBt_BackMouseClicked(evt);
            }
        });

        jBt_Update.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/bt_updateinfo.png"))); // NOI18N
        jBt_Update.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jBt_UpdateMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jP_InfoUpdateLayout = new javax.swing.GroupLayout(jP_InfoUpdate);
        jP_InfoUpdate.setLayout(jP_InfoUpdateLayout);
        jP_InfoUpdateLayout.setHorizontalGroup(
            jP_InfoUpdateLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jP_InfoUpdateLayout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(jP_InfoUpdateLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLb_Username)
                    .addComponent(jLb_Sex)
                    .addComponent(jLb_Mail)
                    .addComponent(jLb_Birthday))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jP_InfoUpdateLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jDC_Date, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jTF_AccName, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jTF_Mail, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jP_InfoUpdateLayout.createSequentialGroup()
                        .addComponent(jRbt_Male)
                        .addGap(18, 18, 18)
                        .addComponent(jRbt_Female)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jP_InfoUpdateLayout.createSequentialGroup()
                        .addComponent(jBt_Back)
                        .addGap(23, 23, 23)
                        .addComponent(jBt_Update)))
                .addGap(80, 80, 80))
        );
        jP_InfoUpdateLayout.setVerticalGroup(
            jP_InfoUpdateLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jP_InfoUpdateLayout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addGroup(jP_InfoUpdateLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jTF_AccName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLb_Username))
                .addGap(18, 18, 18)
                .addGroup(jP_InfoUpdateLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jTF_Mail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLb_Mail))
                .addGap(18, 18, 18)
                .addGroup(jP_InfoUpdateLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLb_Sex)
                    .addComponent(jRbt_Male)
                    .addComponent(jRbt_Female))
                .addGap(18, 18, 18)
                .addGroup(jP_InfoUpdateLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLb_Birthday)
                    .addComponent(jDC_Date, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27)
                .addGroup(jP_InfoUpdateLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jBt_Back)
                    .addComponent(jBt_Update))
                .addContainerGap(26, Short.MAX_VALUE))
        );

        jP_Main.add(jP_InfoUpdate, "jP_InfoUpdate");

        jP_ResetPass.setBackground(new java.awt.Color(19, 59, 84));
        jP_ResetPass.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Đổi mật khẩu ", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 1, 18), new java.awt.Color(255, 255, 255))); // NOI18N
        jP_ResetPass.setPreferredSize(new java.awt.Dimension(415, 310));

        jPF_OldPassword.setBackground(new java.awt.Color(108, 122, 137));
        jPF_OldPassword.setForeground(new java.awt.Color(255, 255, 255));
        jPF_OldPassword.setPreferredSize(new java.awt.Dimension(170, 25));

        jLb_Password.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        jLb_Password.setForeground(new java.awt.Color(255, 255, 255));
        jLb_Password.setText("Mật khẩu cũ:");

        jLb_RePassword.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        jLb_RePassword.setForeground(new java.awt.Color(255, 255, 255));
        jLb_RePassword.setText("Nhập lại mật khẩu:");

        jPF_RePassword.setBackground(new java.awt.Color(108, 122, 137));
        jPF_RePassword.setForeground(new java.awt.Color(255, 255, 255));
        jPF_RePassword.setPreferredSize(new java.awt.Dimension(170, 25));

        jLb_Password1.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        jLb_Password1.setForeground(new java.awt.Color(255, 255, 255));
        jLb_Password1.setText("Mật khẩu mới:");

        jPF_NewPassword.setBackground(new java.awt.Color(108, 122, 137));
        jPF_NewPassword.setForeground(new java.awt.Color(255, 255, 255));
        jPF_NewPassword.setPreferredSize(new java.awt.Dimension(170, 25));

        jBt_Back2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/bt_Back.png"))); // NOI18N
        jBt_Back2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jBt_Back2MouseClicked(evt);
            }
        });

        jBt_UpdatePass.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/bt_updatenewpass.png"))); // NOI18N
        jBt_UpdatePass.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jBt_UpdatePassMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jP_ResetPassLayout = new javax.swing.GroupLayout(jP_ResetPass);
        jP_ResetPass.setLayout(jP_ResetPassLayout);
        jP_ResetPassLayout.setHorizontalGroup(
            jP_ResetPassLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jP_ResetPassLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jP_ResetPassLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLb_Password)
                    .addComponent(jLb_RePassword)
                    .addComponent(jLb_Password1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jP_ResetPassLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jP_ResetPassLayout.createSequentialGroup()
                        .addComponent(jBt_Back2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jBt_UpdatePass))
                    .addComponent(jPF_NewPassword, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPF_OldPassword, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPF_RePassword, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(39, Short.MAX_VALUE))
        );
        jP_ResetPassLayout.setVerticalGroup(
            jP_ResetPassLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jP_ResetPassLayout.createSequentialGroup()
                .addGap(60, 60, 60)
                .addGroup(jP_ResetPassLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLb_Password)
                    .addComponent(jPF_OldPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(25, 25, 25)
                .addGroup(jP_ResetPassLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jPF_NewPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLb_Password1))
                .addGap(25, 25, 25)
                .addGroup(jP_ResetPassLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPF_RePassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLb_RePassword))
                .addGap(18, 18, 18)
                .addGroup(jP_ResetPassLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jBt_Back2)
                    .addComponent(jBt_UpdatePass))
                .addContainerGap(44, Short.MAX_VALUE))
        );

        jP_Main.add(jP_ResetPass, "jP_ResetPass");

        jMB_RegisLog.setPreferredSize(new java.awt.Dimension(400, 21));

        jM_Update.setText("Cập nhật");
        jM_Update.setFont(new java.awt.Font("Arial", 0, 13)); // NOI18N
        jM_Update.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jM_UpdateMouseClicked(evt);
            }
        });
        jMB_RegisLog.add(jM_Update);

        jM_ResetPass.setText("Đổi mật khẩu");
        jM_ResetPass.setFont(new java.awt.Font("Arial", 0, 13)); // NOI18N
        jM_ResetPass.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jM_ResetPassMouseClicked(evt);
            }
        });
        jMB_RegisLog.add(jM_ResetPass);

        setJMenuBar(jMB_RegisLog);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jP_Main, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jP_Main, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 1, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

	private void jM_ResetPassMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jM_ResetPassMouseClicked
		cardLayout.show(jP_Main, "jP_ResetPass");
	}//GEN-LAST:event_jM_ResetPassMouseClicked

	private void jM_UpdateMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jM_UpdateMouseClicked
		cardLayout.show(jP_Main, "jP_InfoUpdate");
	}//GEN-LAST:event_jM_UpdateMouseClicked

    private void jBt_BackMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jBt_BackMouseClicked
        this.setVisible(false);
    }//GEN-LAST:event_jBt_BackMouseClicked

    private void jBt_Back2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jBt_Back2MouseClicked
        this.setVisible(false);
    }//GEN-LAST:event_jBt_Back2MouseClicked

    private void jBt_UpdateMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jBt_UpdateMouseClicked
        String email = jTF_Mail.getText();
		if (!ValidateField.email(email)) {
			Client.notice("Email không hợp lệ");
			return;
		}

		boolean gender = false;
		if (jRbt_Male.isSelected())
			gender = true;

		Date birthday = jDC_Date.getDate();
		if (!ValidateField.birthday(birthday)) {
			Client.notice("Ngày sinh không hợp lệ");
			return;
		}
		String birthdayStr = DateTimeUtil.covDateToString(birthday);

		SoundPack.clickb();
		SendMessage.send("updateinfo "+email+' '+(gender?"nam ":"nu ")+birthdayStr);

		Client.player.setEmail(email);
		Client.player.setGender(gender);
		Client.player.setBirthday(birthdayStr);
		WaitRoomGUI.ins.setPlayer();

		this.setVisible(false);
    }//GEN-LAST:event_jBt_UpdateMouseClicked

    private void jBt_UpdatePassMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jBt_UpdatePassMouseClicked
        String olsPassword = new String(jPF_OldPassword.getPassword());
		String newPassword = new String(jPF_NewPassword.getPassword());
		String rePassword = new String(jPF_RePassword.getPassword());
		SoundPack.clickb();
		if (ValidateField.password(newPassword, rePassword))
			SendMessage.send("resetpassword2 "+olsPassword+' '+newPassword);
		else
			Client.notice("Mật khâu ko khớp");
		this.setVisible(false);
    }//GEN-LAST:event_jBt_UpdatePassMouseClicked

	public static void main(String args[]) {
		java.awt.EventQueue.invokeLater(new Runnable() {
			public void run() {
				new InfoUpdateGUI().setVisible(true);
			}
		});
	}

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup btG_Sex;
    private javax.swing.JLabel jBt_Back;
    private javax.swing.JLabel jBt_Back2;
    private javax.swing.JLabel jBt_Update;
    private javax.swing.JLabel jBt_UpdatePass;
    private com.toedter.calendar.JDateChooser jDC_Date;
    private javax.swing.JLabel jLb_Birthday;
    private javax.swing.JLabel jLb_Mail;
    private javax.swing.JLabel jLb_Password;
    private javax.swing.JLabel jLb_Password1;
    private javax.swing.JLabel jLb_RePassword;
    private javax.swing.JLabel jLb_Sex;
    private javax.swing.JLabel jLb_Username;
    private javax.swing.JMenuBar jMB_RegisLog;
    private javax.swing.JMenu jM_ResetPass;
    private javax.swing.JMenu jM_Update;
    private javax.swing.JPasswordField jPF_NewPassword;
    private javax.swing.JPasswordField jPF_OldPassword;
    private javax.swing.JPasswordField jPF_RePassword;
    private javax.swing.JPanel jP_InfoUpdate;
    private javax.swing.JPanel jP_Main;
    private javax.swing.JPanel jP_ResetPass;
    private javax.swing.JRadioButton jRbt_Female;
    private javax.swing.JRadioButton jRbt_Male;
    private javax.swing.JTextField jTF_AccName;
    private javax.swing.JTextField jTF_Mail;
    // End of variables declaration//GEN-END:variables


	// Massan code
	public static InfoUpdateGUI ins = new InfoUpdateGUI();

	public void setPlayer() {
		jTF_AccName.setText(Client.player.getAccount());
		jTF_Mail.setText(Client.player.getEmail());
		if (Client.player.getGender()) {
			jRbt_Male.setSelected(true);
			jRbt_Female.setSelected(false);
		} else {
			jRbt_Male.setSelected(false);
			jRbt_Female.setSelected(true);
		}
		jDC_Date.setDate(DateTimeUtil.covStringToDate(Client.player.getBirthday()));
	}

}
