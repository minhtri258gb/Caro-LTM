package ltm.caro.client;

import java.awt.CardLayout;
import java.util.Date;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import ltm.caro.server.entity.Player;
import ltm.caro.util.DateTimeUtil;


public class RegisLogMissGUI extends javax.swing.JFrame {
	CardLayout cardLayout;
	public RegisLogMissGUI() {
		init();

		initComponents();
		//setSize(430, 455);
		cardLayout = (CardLayout)(jP_Main.getLayout());
		this.setLocationRelativeTo(null);
	}
	@SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btG_Sex = new javax.swing.ButtonGroup();
        jP_Main = new javax.swing.JPanel();
        jP_Login = new javax.swing.JPanel();
        jTF_LG_AccName = new javax.swing.JTextField();
        jLb_Mail1 = new javax.swing.JLabel();
        jLb_Password1 = new javax.swing.JLabel();
        jPF_LG_ResetPass = new javax.swing.JPasswordField();
        jLb_MissPass = new javax.swing.JLabel();
        jLb_bt_Login = new javax.swing.JLabel();
        jP_Reigister = new javax.swing.JPanel();
        jLb_Username = new javax.swing.JLabel();
        jTF_AccName = new javax.swing.JTextField();
        jLb_Mail = new javax.swing.JLabel();
        jTF_Mail = new javax.swing.JTextField();
        jLb_Sex = new javax.swing.JLabel();
        jRbt_Male = new javax.swing.JRadioButton();
        jRbt_Female = new javax.swing.JRadioButton();
        jLb_Birthday = new javax.swing.JLabel();
        jLb_Password = new javax.swing.JLabel();
        jPF_Password = new javax.swing.JPasswordField();
        jPF_RePassword = new javax.swing.JPasswordField();
        jLb_RePassword = new javax.swing.JLabel();
        jDC_Date = new com.toedter.calendar.JDateChooser();
        jLb_bt_Register = new javax.swing.JLabel();
        jP_ResetPassword = new javax.swing.JPanel();
        jTF_RSP_AccName = new javax.swing.JTextField();
        jLb_Mail2 = new javax.swing.JLabel();
        jPF_RSP_newPassword = new javax.swing.JPasswordField();
        jLb_newPassword = new javax.swing.JLabel();
        jLb_RenewPassword = new javax.swing.JLabel();
        jPF_RSP_RenewPassword = new javax.swing.JPasswordField();
        jTF_RSP_Mail = new javax.swing.JTextField();
        jLb_Mail3 = new javax.swing.JLabel();
        jLb_bt_Update = new javax.swing.JLabel();
        jMB_RegisLog = new javax.swing.JMenuBar();
        jM_Register = new javax.swing.JMenu();
        jM_Login = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Cờ Caro");
        setBackground(new java.awt.Color(19, 59, 84));
        setResizable(false);
        setSize(new java.awt.Dimension(400, 421));

        jP_Main.setBackground(new java.awt.Color(19, 59, 84));
        jP_Main.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 0, 18))); // NOI18N
        jP_Main.setLayout(new java.awt.CardLayout());

        jP_Login.setBackground(new java.awt.Color(19, 59, 84));
        jP_Login.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Đăng nhập tài khoản", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 0, 18), new java.awt.Color(255, 255, 255))); // NOI18N

        jTF_LG_AccName.setBackground(new java.awt.Color(108, 122, 137));
        jTF_LG_AccName.setFont(new java.awt.Font("Arial", 0, 13)); // NOI18N
        jTF_LG_AccName.setForeground(new java.awt.Color(255, 255, 255));
        jTF_LG_AccName.setPreferredSize(new java.awt.Dimension(170, 25));

        jLb_Mail1.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        jLb_Mail1.setForeground(new java.awt.Color(255, 255, 255));
        jLb_Mail1.setText("Tên tài khoản:");

        jLb_Password1.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        jLb_Password1.setForeground(new java.awt.Color(255, 255, 255));
        jLb_Password1.setText("Mật khẩu:");

        jPF_LG_ResetPass.setBackground(new java.awt.Color(108, 122, 137));
        jPF_LG_ResetPass.setForeground(new java.awt.Color(255, 255, 255));
        jPF_LG_ResetPass.setPreferredSize(new java.awt.Dimension(170, 25));

        jLb_MissPass.setFont(new java.awt.Font("Arial", 1, 13)); // NOI18N
        jLb_MissPass.setForeground(new java.awt.Color(235, 0, 0));
        jLb_MissPass.setText("Quên mật khẩu?");
        jLb_MissPass.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLb_MissPassMouseClicked(evt);
            }
        });

        jLb_bt_Login.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/bt_login.png"))); // NOI18N
        jLb_bt_Login.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLb_bt_LoginMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jP_LoginLayout = new javax.swing.GroupLayout(jP_Login);
        jP_Login.setLayout(jP_LoginLayout);
        jP_LoginLayout.setHorizontalGroup(
            jP_LoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jP_LoginLayout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(jP_LoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLb_bt_Login)
                    .addGroup(jP_LoginLayout.createSequentialGroup()
                        .addGroup(jP_LoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLb_Password1)
                            .addComponent(jLb_Mail1))
                        .addGap(18, 18, 18)
                        .addGroup(jP_LoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jTF_LG_AccName, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPF_LG_ResetPass, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addComponent(jLb_MissPass))
                .addContainerGap(73, Short.MAX_VALUE))
        );
        jP_LoginLayout.setVerticalGroup(
            jP_LoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jP_LoginLayout.createSequentialGroup()
                .addGap(90, 90, 90)
                .addGroup(jP_LoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jTF_LG_AccName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLb_Mail1))
                .addGap(30, 30, 30)
                .addGroup(jP_LoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLb_Password1)
                    .addComponent(jPF_LG_ResetPass, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLb_MissPass)
                .addGap(18, 18, 18)
                .addComponent(jLb_bt_Login)
                .addContainerGap(92, Short.MAX_VALUE))
        );

        jP_Main.add(jP_Login, "jP_Login");

        jP_Reigister.setBackground(new java.awt.Color(19, 59, 84));
        jP_Reigister.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Đăng ký tài khoản", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 0, 18), new java.awt.Color(255, 255, 255))); // NOI18N
        jP_Reigister.setForeground(new java.awt.Color(255, 255, 255));

        jLb_Username.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        jLb_Username.setForeground(new java.awt.Color(255, 255, 255));
        jLb_Username.setText("Tên tài khoản:");

        jTF_AccName.setBackground(new java.awt.Color(108, 122, 137));
        jTF_AccName.setFont(new java.awt.Font("Arial", 0, 13)); // NOI18N
        jTF_AccName.setForeground(new java.awt.Color(255, 255, 255));
        jTF_AccName.setPreferredSize(new java.awt.Dimension(170, 25));

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

        jLb_Password.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        jLb_Password.setForeground(new java.awt.Color(255, 255, 255));
        jLb_Password.setText("Mật khẩu:");

        jPF_Password.setBackground(new java.awt.Color(108, 122, 137));
        jPF_Password.setForeground(new java.awt.Color(255, 255, 255));
        jPF_Password.setPreferredSize(new java.awt.Dimension(170, 25));

        jPF_RePassword.setBackground(new java.awt.Color(108, 122, 137));
        jPF_RePassword.setForeground(new java.awt.Color(255, 255, 255));
        jPF_RePassword.setPreferredSize(new java.awt.Dimension(170, 25));

        jLb_RePassword.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        jLb_RePassword.setForeground(new java.awt.Color(255, 255, 255));
        jLb_RePassword.setText("Nhập lại mật khẩu:");

        jDC_Date.setBackground(new java.awt.Color(108, 122, 137));
        jDC_Date.setPreferredSize(new java.awt.Dimension(170, 25));

        jLb_bt_Register.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/bt_register.png"))); // NOI18N
        jLb_bt_Register.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLb_bt_RegisterMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jP_ReigisterLayout = new javax.swing.GroupLayout(jP_Reigister);
        jP_Reigister.setLayout(jP_ReigisterLayout);
        jP_ReigisterLayout.setHorizontalGroup(
            jP_ReigisterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jP_ReigisterLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jP_ReigisterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLb_Username)
                    .addComponent(jLb_Sex)
                    .addComponent(jLb_Mail)
                    .addComponent(jLb_Birthday)
                    .addComponent(jLb_Password)
                    .addComponent(jLb_RePassword))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jP_ReigisterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jP_ReigisterLayout.createSequentialGroup()
                        .addGroup(jP_ReigisterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jDC_Date, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
                            .addComponent(jTF_AccName, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPF_Password, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jTF_Mail, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPF_RePassword, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(jP_ReigisterLayout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(jLb_bt_Register)))
                        .addGap(42, 42, 42))
                    .addGroup(jP_ReigisterLayout.createSequentialGroup()
                        .addComponent(jRbt_Male)
                        .addGap(18, 18, 18)
                        .addComponent(jRbt_Female)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        jP_ReigisterLayout.setVerticalGroup(
            jP_ReigisterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jP_ReigisterLayout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(jP_ReigisterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jTF_AccName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLb_Username))
                .addGap(18, 18, 18)
                .addGroup(jP_ReigisterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jTF_Mail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLb_Mail))
                .addGap(18, 18, 18)
                .addGroup(jP_ReigisterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLb_Sex)
                    .addComponent(jRbt_Male)
                    .addComponent(jRbt_Female))
                .addGap(18, 18, 18)
                .addGroup(jP_ReigisterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLb_Birthday)
                    .addComponent(jDC_Date, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jP_ReigisterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLb_Password)
                    .addComponent(jPF_Password, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jP_ReigisterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPF_RePassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLb_RePassword))
                .addGap(18, 18, 18)
                .addComponent(jLb_bt_Register)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jP_Main.add(jP_Reigister, "jP_Reigister");

        jP_ResetPassword.setBackground(new java.awt.Color(19, 59, 84));
        jP_ResetPassword.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Đặt lại mật khẩu", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 0, 18), new java.awt.Color(255, 255, 255))); // NOI18N

        jTF_RSP_AccName.setBackground(new java.awt.Color(108, 122, 137));
        jTF_RSP_AccName.setFont(new java.awt.Font("Arial", 0, 13)); // NOI18N
        jTF_RSP_AccName.setForeground(new java.awt.Color(255, 255, 255));
        jTF_RSP_AccName.setPreferredSize(new java.awt.Dimension(170, 25));

        jLb_Mail2.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        jLb_Mail2.setForeground(new java.awt.Color(255, 255, 255));
        jLb_Mail2.setText("Tên tài khoản:");

        jPF_RSP_newPassword.setBackground(new java.awt.Color(108, 122, 137));
        jPF_RSP_newPassword.setForeground(new java.awt.Color(255, 255, 255));
        jPF_RSP_newPassword.setPreferredSize(new java.awt.Dimension(170, 25));

        jLb_newPassword.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        jLb_newPassword.setForeground(new java.awt.Color(255, 255, 255));
        jLb_newPassword.setText("Mật khẩu mới:");

        jLb_RenewPassword.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        jLb_RenewPassword.setForeground(new java.awt.Color(255, 255, 255));
        jLb_RenewPassword.setText("Nhập lại mật khẩu:");

        jPF_RSP_RenewPassword.setBackground(new java.awt.Color(108, 122, 137));
        jPF_RSP_RenewPassword.setForeground(new java.awt.Color(255, 255, 255));
        jPF_RSP_RenewPassword.setPreferredSize(new java.awt.Dimension(170, 25));

        jTF_RSP_Mail.setBackground(new java.awt.Color(108, 122, 137));
        jTF_RSP_Mail.setFont(new java.awt.Font("Arial", 0, 13)); // NOI18N
        jTF_RSP_Mail.setForeground(new java.awt.Color(255, 255, 255));
        jTF_RSP_Mail.setPreferredSize(new java.awt.Dimension(170, 25));

        jLb_Mail3.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        jLb_Mail3.setForeground(new java.awt.Color(255, 255, 255));
        jLb_Mail3.setText("Mail:");

        jLb_bt_Update.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/bt_updatenewpass.png"))); // NOI18N
        jLb_bt_Update.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLb_bt_UpdateMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jP_ResetPasswordLayout = new javax.swing.GroupLayout(jP_ResetPassword);
        jP_ResetPassword.setLayout(jP_ResetPasswordLayout);
        jP_ResetPasswordLayout.setHorizontalGroup(
            jP_ResetPasswordLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jP_ResetPasswordLayout.createSequentialGroup()
                .addGroup(jP_ResetPasswordLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLb_bt_Update)
                    .addGroup(jP_ResetPasswordLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jP_ResetPasswordLayout.createSequentialGroup()
                            .addGap(5, 5, 5)
                            .addGroup(jP_ResetPasswordLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addGroup(jP_ResetPasswordLayout.createSequentialGroup()
                                    .addComponent(jLb_RenewPassword)
                                    .addGap(18, 18, 18)
                                    .addComponent(jPF_RSP_RenewPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(jP_ResetPasswordLayout.createSequentialGroup()
                                    .addComponent(jLb_Mail2)
                                    .addGap(18, 18, 18)
                                    .addComponent(jTF_RSP_AccName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jP_ResetPasswordLayout.createSequentialGroup()
                            .addContainerGap()
                            .addGroup(jP_ResetPasswordLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jP_ResetPasswordLayout.createSequentialGroup()
                                    .addComponent(jLb_Mail3)
                                    .addGap(18, 18, 18)
                                    .addComponent(jTF_RSP_Mail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jP_ResetPasswordLayout.createSequentialGroup()
                                    .addComponent(jLb_newPassword)
                                    .addGap(18, 18, 18)
                                    .addComponent(jPF_RSP_newPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                .addContainerGap(63, Short.MAX_VALUE))
        );
        jP_ResetPasswordLayout.setVerticalGroup(
            jP_ResetPasswordLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jP_ResetPasswordLayout.createSequentialGroup()
                .addGap(60, 60, 60)
                .addGroup(jP_ResetPasswordLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jTF_RSP_AccName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLb_Mail2))
                .addGap(18, 18, 18)
                .addGroup(jP_ResetPasswordLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTF_RSP_Mail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLb_Mail3))
                .addGap(20, 20, 20)
                .addGroup(jP_ResetPasswordLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLb_newPassword)
                    .addComponent(jPF_RSP_newPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addGroup(jP_ResetPasswordLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLb_RenewPassword)
                    .addComponent(jPF_RSP_RenewPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27)
                .addComponent(jLb_bt_Update)
                .addContainerGap(57, Short.MAX_VALUE))
        );

        jP_Main.add(jP_ResetPassword, "jP_ResetPassword");

        jMB_RegisLog.setPreferredSize(new java.awt.Dimension(400, 21));

        jM_Register.setText("Đăng ký");
        jM_Register.setFont(new java.awt.Font("Arial", 0, 13)); // NOI18N
        jM_Register.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jM_RegisterMouseClicked(evt);
            }
        });
        jMB_RegisLog.add(jM_Register);

        jM_Login.setText("Đăng nhập");
        jM_Login.setFont(new java.awt.Font("Arial", 0, 13)); // NOI18N
        jM_Login.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jM_LoginMouseClicked(evt);
            }
        });
        jMB_RegisLog.add(jM_Login);

        setJMenuBar(jMB_RegisLog);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jP_Main, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jP_Main, javax.swing.GroupLayout.DEFAULT_SIZE, 364, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

	private void jM_RegisterMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jM_RegisterMouseClicked
		cardLayout.show(jP_Main, "jP_Reigister");
	}//GEN-LAST:event_jM_RegisterMouseClicked

	private void jM_LoginMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jM_LoginMouseClicked
		cardLayout.show(jP_Main, "jP_Login");
	}//GEN-LAST:event_jM_LoginMouseClicked

	private void jLb_MissPassMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLb_MissPassMouseClicked
		cardLayout.show(jP_Main, "jP_ResetPassword");
	}//GEN-LAST:event_jLb_MissPassMouseClicked

    private void jLb_bt_RegisterMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLb_bt_RegisterMouseClicked
        
        // Validate Account
		String account = jTF_AccName.getText();
		if (!ValidateField.account(account)) {
			Client.notice("Tên tài khoản không hợp lệ");
			return;
		}

		// Validate Email
		String email = jTF_Mail.getText();
		if (!ValidateField.email(email)) {
			Client.notice("Định dạng email không hợp lệ");
			return;
		}

		// Validate Gender
		if (!jRbt_Female.isSelected() && !jRbt_Male.isSelected()) {
			Client.notice("Chưa chọn giới tính");
			return;
		}
		boolean gender = jRbt_Male.isSelected();

		// Validate birthday
		Date birthday = jDC_Date.getDate();
		if (!ValidateField.birthday(birthday)) {
			Client.notice("Ngày sinh không hợp lệ");
			return;
		}
		String birthdayStr = DateTimeUtil.covDateToString(birthday);

		// Validate password
		String password = new String(jPF_Password.getPassword()); // Kiem tra mat khau dai hon 6
		if (!ValidateField.password(password, new String(jPF_RePassword.getPassword()))) {
			Client.notice("Mật khẩu không hợp lệ");
			return;
		}

		SoundPack.clickb();
		SendMessage.register(account, password, email, gender, birthdayStr);
    }//GEN-LAST:event_jLb_bt_RegisterMouseClicked

    private void jLb_bt_LoginMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLb_bt_LoginMouseClicked
        String acc = jTF_LG_AccName.getText();
		char[] tmp = jPF_LG_ResetPass.getPassword();
		String pass = String.valueOf(tmp);
		if(acc.isEmpty() || pass.isEmpty()){
		    Client.notice("Bạn không được để trống");
		}else{
            SoundPack.clickb();
			Client.player = new Player();
			Client.player.setAccount(acc);
			Client.player.setPassword(pass);
			SendMessage.login(acc, pass);
		}
    }//GEN-LAST:event_jLb_bt_LoginMouseClicked

    private void jLb_bt_UpdateMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLb_bt_UpdateMouseClicked
        // Validate name
        String account = jTF_RSP_AccName.getText();
        if (!ValidateField.account(account)) {
            Client.notice("Tên tài khoản không hợp lệ");
            return;
        }

        // Validate Email
        String email = jTF_RSP_Mail.getText();
        if (!ValidateField.email(email)) {
            Client.notice("Định dạng email không hợp lệ");
            return;
        }

        // Validate password
        String password = new String(jPF_RSP_newPassword.getPassword());
        if (!ValidateField.password(password, new String(jPF_RSP_RenewPassword.getPassword()))) {
            Client.notice("Mật khẩu không hợp lệ");
            return;
        }

        SoundPack.clickb();
        SendMessage.send("resetpassword "+account+' '+email+' '+password);
    }//GEN-LAST:event_jLb_bt_UpdateMouseClicked

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup btG_Sex;
    private com.toedter.calendar.JDateChooser jDC_Date;
    private javax.swing.JLabel jLb_Birthday;
    private javax.swing.JLabel jLb_Mail;
    private javax.swing.JLabel jLb_Mail1;
    private javax.swing.JLabel jLb_Mail2;
    private javax.swing.JLabel jLb_Mail3;
    private javax.swing.JLabel jLb_MissPass;
    private javax.swing.JLabel jLb_Password;
    private javax.swing.JLabel jLb_Password1;
    private javax.swing.JLabel jLb_RePassword;
    private javax.swing.JLabel jLb_RenewPassword;
    private javax.swing.JLabel jLb_Sex;
    private javax.swing.JLabel jLb_Username;
    private javax.swing.JLabel jLb_bt_Login;
    private javax.swing.JLabel jLb_bt_Register;
    private javax.swing.JLabel jLb_bt_Update;
    private javax.swing.JLabel jLb_newPassword;
    private javax.swing.JMenuBar jMB_RegisLog;
    private javax.swing.JMenu jM_Login;
    private javax.swing.JMenu jM_Register;
    private javax.swing.JPasswordField jPF_LG_ResetPass;
    private javax.swing.JPasswordField jPF_Password;
    private javax.swing.JPasswordField jPF_RSP_RenewPassword;
    private javax.swing.JPasswordField jPF_RSP_newPassword;
    private javax.swing.JPasswordField jPF_RePassword;
    private javax.swing.JPanel jP_Login;
    private javax.swing.JPanel jP_Main;
    private javax.swing.JPanel jP_Reigister;
    private javax.swing.JPanel jP_ResetPassword;
    private javax.swing.JRadioButton jRbt_Female;
    private javax.swing.JRadioButton jRbt_Male;
    private javax.swing.JTextField jTF_AccName;
    private javax.swing.JTextField jTF_LG_AccName;
    private javax.swing.JTextField jTF_Mail;
    private javax.swing.JTextField jTF_RSP_AccName;
    private javax.swing.JTextField jTF_RSP_Mail;
    // End of variables declaration//GEN-END:variables


	// Massan code
	public static RegisLogMissGUI ins = new RegisLogMissGUI();

	public boolean loginFlag;

	private void init() {
		loginFlag = false;
	}
}
