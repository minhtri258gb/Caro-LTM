package ltm.caro.client;

import ltm.caro.server.entity.Player;

import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import java.util.StringTokenizer;

public class AchievementsGUI extends javax.swing.JFrame {

    public AchievementsGUI() {
        init();
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jP_Main = new javax.swing.JPanel();
        jP_PersonalAchievements = new javax.swing.JPanel();
        jLb_NumWinLost = new javax.swing.JLabel();
        jLb_TxtNumWinLost = new javax.swing.JLabel();
        jLb_NumWinLost1 = new javax.swing.JLabel();
        jLb_TxtWinRate = new javax.swing.JLabel();
        jLb_NumWinLost2 = new javax.swing.JLabel();
        jLb_TxtWinLostStreak = new javax.swing.JLabel();
        jLb_NumWinLost3 = new javax.swing.JLabel();
        jLb_TxtTotalScore = new javax.swing.JLabel();
        jCbB_Select = new javax.swing.JComboBox<>();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTb_ListSelect = new javax.swing.JTable();
        jBt_Back = new javax.swing.JLabel();

        setTitle("Cờ Caro");
        setPreferredSize(new java.awt.Dimension(500, 480));
        setResizable(false);
        setSize(new java.awt.Dimension(500, 430));

        jP_Main.setBackground(new java.awt.Color(19, 59, 84));
        jP_Main.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Thành Tích Tổng Thể", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 1, 18), new java.awt.Color(255, 255, 255))); // NOI18N

        jP_PersonalAchievements.setBackground(new java.awt.Color(19, 59, 84));
        jP_PersonalAchievements.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Thành tích cá nhân", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 1, 13), new java.awt.Color(255, 255, 255))); // NOI18N

        jLb_NumWinLost.setFont(new java.awt.Font("Arial", 1, 13)); // NOI18N
        jLb_NumWinLost.setForeground(new java.awt.Color(255, 255, 255));
        jLb_NumWinLost.setText("Số trận thắng/thua:");

        jLb_TxtNumWinLost.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLb_TxtNumWinLost.setForeground(new java.awt.Color(255, 255, 255));
        jLb_TxtNumWinLost.setText("10 / 5 (Trận)");

        jLb_NumWinLost1.setFont(new java.awt.Font("Arial", 1, 13)); // NOI18N
        jLb_NumWinLost1.setForeground(new java.awt.Color(255, 255, 255));
        jLb_NumWinLost1.setText("Tỉ lệ thắng:");

        jLb_TxtWinRate.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLb_TxtWinRate.setForeground(new java.awt.Color(255, 255, 255));
        jLb_TxtWinRate.setText("85%");

        jLb_NumWinLost2.setFont(new java.awt.Font("Arial", 1, 13)); // NOI18N
        jLb_NumWinLost2.setForeground(new java.awt.Color(255, 255, 255));
        jLb_NumWinLost2.setText("Số trận thắng/thua dài nhất:");

        jLb_TxtWinLostStreak.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLb_TxtWinLostStreak.setForeground(new java.awt.Color(255, 255, 255));
        jLb_TxtWinLostStreak.setText("10 / 5 (Trận)");

        jLb_NumWinLost3.setFont(new java.awt.Font("Arial", 1, 13)); // NOI18N
        jLb_NumWinLost3.setForeground(new java.awt.Color(255, 255, 255));
        jLb_NumWinLost3.setText("Tổng số điểm:");

        jLb_TxtTotalScore.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLb_TxtTotalScore.setForeground(new java.awt.Color(255, 255, 255));
        jLb_TxtTotalScore.setText("3500 điểm");

        javax.swing.GroupLayout jP_PersonalAchievementsLayout = new javax.swing.GroupLayout(jP_PersonalAchievements);
        jP_PersonalAchievements.setLayout(jP_PersonalAchievementsLayout);
        jP_PersonalAchievementsLayout.setHorizontalGroup(
            jP_PersonalAchievementsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jP_PersonalAchievementsLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jP_PersonalAchievementsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jP_PersonalAchievementsLayout.createSequentialGroup()
                        .addComponent(jLb_NumWinLost)
                        .addGap(18, 18, 18)
                        .addComponent(jLb_TxtNumWinLost))
                    .addGroup(jP_PersonalAchievementsLayout.createSequentialGroup()
                        .addComponent(jLb_NumWinLost2)
                        .addGap(18, 18, 18)
                        .addComponent(jLb_TxtWinLostStreak))
                    .addGroup(jP_PersonalAchievementsLayout.createSequentialGroup()
                        .addComponent(jLb_NumWinLost1)
                        .addGap(18, 18, 18)
                        .addComponent(jLb_TxtWinRate))
                    .addGroup(jP_PersonalAchievementsLayout.createSequentialGroup()
                        .addComponent(jLb_NumWinLost3)
                        .addGap(18, 18, 18)
                        .addComponent(jLb_TxtTotalScore)))
                .addContainerGap())
        );
        jP_PersonalAchievementsLayout.setVerticalGroup(
            jP_PersonalAchievementsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jP_PersonalAchievementsLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jP_PersonalAchievementsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLb_NumWinLost)
                    .addComponent(jLb_TxtNumWinLost))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jP_PersonalAchievementsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLb_NumWinLost1)
                    .addComponent(jLb_TxtWinRate))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jP_PersonalAchievementsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLb_NumWinLost2)
                    .addComponent(jLb_TxtWinLostStreak))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jP_PersonalAchievementsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLb_NumWinLost3)
                    .addComponent(jLb_TxtTotalScore))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jCbB_Select.setBackground(new java.awt.Color(108, 122, 137));
        jCbB_Select.setFont(new java.awt.Font("Arial", 1, 13)); // NOI18N
        jCbB_Select.setForeground(new java.awt.Color(255, 255, 255));
        jCbB_Select.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Điểm thành tích", "Số trận thắng", "Chuỗi trận thắng", "Tỉ lệ thắng" }));
        jCbB_Select.setPreferredSize(new java.awt.Dimension(134, 34));
        jCbB_Select.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCbB_SelectActionPerformed(evt);
            }
        });

        jScrollPane2.setBackground(new java.awt.Color(19, 59, 84));

        jTb_ListSelect.setBackground(new java.awt.Color(108, 122, 137));
        jTb_ListSelect.setFont(new java.awt.Font("Arial", 0, 13)); // NOI18N
        jTb_ListSelect.setForeground(new java.awt.Color(255, 255, 255));
        jTb_ListSelect.setModel(rankMmodel);
        jScrollPane2.setViewportView(jTb_ListSelect);

        jBt_Back.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/bt_Back.png"))); // NOI18N
        jBt_Back.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jBt_BackMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jP_MainLayout = new javax.swing.GroupLayout(jP_Main);
        jP_Main.setLayout(jP_MainLayout);
        jP_MainLayout.setHorizontalGroup(
            jP_MainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jP_PersonalAchievements, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jP_MainLayout.createSequentialGroup()
                .addComponent(jBt_Back)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jCbB_Select, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 488, Short.MAX_VALUE)
        );
        jP_MainLayout.setVerticalGroup(
            jP_MainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jP_MainLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jP_PersonalAchievements, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jP_MainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jBt_Back)
                    .addComponent(jCbB_Select, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(6, 6, 6)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 203, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jP_Main, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jP_Main, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jCbB_SelectActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCbB_SelectActionPerformed
        SendMessage.send("rank "+jCbB_Select.getSelectedIndex());
    }//GEN-LAST:event_jCbB_SelectActionPerformed

    private void jBt_BackMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jBt_BackMouseClicked
        SoundPack.clickb();
        this.setVisible(false);
    }//GEN-LAST:event_jBt_BackMouseClicked

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AchievementsGUI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jBt_Back;
    private javax.swing.JComboBox<String> jCbB_Select;
    private javax.swing.JLabel jLb_NumWinLost;
    private javax.swing.JLabel jLb_NumWinLost1;
    private javax.swing.JLabel jLb_NumWinLost2;
    private javax.swing.JLabel jLb_NumWinLost3;
    private javax.swing.JLabel jLb_TxtNumWinLost;
    private javax.swing.JLabel jLb_TxtTotalScore;
    private javax.swing.JLabel jLb_TxtWinLostStreak;
    private javax.swing.JLabel jLb_TxtWinRate;
    private javax.swing.JPanel jP_Main;
    private javax.swing.JPanel jP_PersonalAchievements;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTb_ListSelect;
    // End of variables declaration//GEN-END:variables


    // Massan code
    public static AchievementsGUI ins = new AchievementsGUI();

    private DefaultTableModel rankMmodel;

    private void init() {
        rankMmodel = new DefaultTableModel();
        rankMmodel.addColumn("Thứ hạng");
        rankMmodel.addColumn("Tên người chơi");
        rankMmodel.addColumn("Điểm số");
    }

	public void setInfo() {
	    Player p = Client.player;
        jLb_TxtNumWinLost.setText(p.getWinNum()+" / "+p.getLostNum()+" Trận");
        jLb_TxtWinRate.setText((int)(p.getWinNum() * 100.0 / (p.getWinNum() + p.getLostNum())) + "%");
        jLb_TxtWinLostStreak.setText(p.getWinStreakMax()+" / "+p.getLostStreakMax()+" Trận");
        jLb_TxtTotalScore.setText(Client.player.getScore()+" điểm");
	}

	public void setRank(String list) {

        while (rankMmodel.getRowCount() != 0) // Xoa bang
            rankMmodel.removeRow(0);

        rankMmodel.setColumnCount(2); // Doi ten cot cuoi
        int ranktype = jCbB_Select.getSelectedIndex();
        switch (ranktype) {
            case 0: rankMmodel.addColumn("Điểm số"); break;
            case 1: rankMmodel.addColumn("Số trận thắng"); break;
            case 2: rankMmodel.addColumn("Chuỗi trận thắng"); break;
            case 3: rankMmodel.addColumn("Tỷ lệ thắng"); break;
        }
        String[] units = {" điểm", " trận", " trận", "%"};

        StringTokenizer stk = new StringTokenizer(list); // Them data vao bang
        int rank = 1;
        while (stk.hasMoreElements()) {
            String name = stk.nextToken();
            int data = Integer.parseInt(stk.nextToken());
            Object[] row = {rank++, name, data+units[ranktype]};
            rankMmodel.addRow(row);
        }
    }

}
