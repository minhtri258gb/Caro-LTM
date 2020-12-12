package ltm.caro.client;

import ltm.caro.server.entity.Player;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Point;
import java.awt.RenderingHints;
import java.awt.Toolkit;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;
import javax.swing.ImageIcon;
import javax.swing.border.LineBorder;


public class GameScreenGUI extends javax.swing.JFrame {
	private ImageIcon img = null, imgx = null, imgo = null;
	private int X0 = 12;
	private int Y0 = 20;
	private int Width = 26;
	private int Size = 18;
	private int currentRow = -1;
	private int currentColumn = -1;
	/**
	 * Vị trí chẵn lưu các điểm đã đánh của user 1
	 * Vị trí lẻ lưu các điểm đã đánh của user 2
	 */
	private Vector<Point> checked = new Vector<Point>();
	/**
	 * true : quân đen đi trước
	 * false  quân đỏ đi trước
	 */
	boolean startUser = false;//quân đen đi trước

	public GameScreenGUI() {
		imgx = new javax.swing.ImageIcon(getClass().getClassLoader().getResource("./image/X.png"));
		imgo = new javax.swing.ImageIcon(getClass().getClassLoader().getResource("./image/O.png"));
		initComponents();
		setSize(830,685);
		this.setLocationRelativeTo(null);

		init();
	}

	@SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPMain = new javax.swing.JPanel();
        jP_Roomnumber = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jP_PlayerX = new javax.swing.JPanel();
        jLb_PlayerX = new javax.swing.JLabel();
        jLb_IconX = new javax.swing.JLabel();
        jP_PlayerO = new javax.swing.JPanel();
        jLb_PlayerO = new javax.swing.JLabel();
        jLb_IconO = new javax.swing.JLabel();
        jP_Option = new javax.swing.JPanel();
        jBt_StartMatch = new javax.swing.JLabel();
        jBt_OutMatch = new javax.swing.JLabel();
        jP_TimeMatch = new javax.swing.JPanel();
        jLb_TimeTurn1 = new javax.swing.JLabel();
        jP_Timeturn = new javax.swing.JPanel();
        jLb_TimeTurn = new javax.swing.JLabel();
        jP_Chatbox = new javax.swing.JPanel();
        jTF_Writechat = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTA_Box = new javax.swing.JTextArea();
        jBt_Send = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel(){
            public void paintComponent(Graphics g){
                this.setOpaque(false);
                Graphics2D g2 = (Graphics2D) g;
                g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
                //Vẽ bàn cờ
                //g.setColor(Color.GRAY);
                for(int r = 0;r<=Size;r++){
                    g.drawLine(X0, Y0+r*Width, X0+Size*Width, Y0+r*Width);
                }
                for(int c = 0;c<=Size;c++){
                    g.drawLine(X0+c*Width, Y0, X0+c*Width, Y0+Size*Width);
                }

                //Vẽ ô có chuột qua

                if(currentColumn<Size&&currentColumn>=0&&currentRow<Size&&currentRow>=0){
                    g.drawImage(isCross?imgx.getImage():imgo.getImage(),X0+currentColumn*Width+Width/6-2, Y0+ currentRow*Width+Width/6-2, null);
                    //g2.fillOval(X0+currentColumn*Width+Width/6+1,Y0+ currentRow*Width+Width/6+1, 2*Width/3, 2*Width/3);
                }
                //Vẽ các vị trí đã đánh
                if(checked.size()==0) return;
                for(int p = 0;p<checked.size();p++){
                    if(startUser){
                        if(p%2==0) img = imgo;
                        else img = imgx;
                    }else{
                        if(p%2!=0) img = imgo;
                        else img = imgx;
                    }
                    g2.drawImage(img.getImage(),X0+checked.get(p).x*Width+Width/6-2, Y0+ checked.get(p).y*Width+Width/6-2, null);
                    //g2.fillOval(X0+checked.get(p).x*Width+Width/6+1,Y0+ checked.get(p).y*Width+Width/6+1, 2*Width/3, 2*Width/3);
                    //g2.drawString(String.valueOf(p),X0+checked.get(p).x*Width+12,Y0+ checked.get(p).y*Width+20);
                }
                //Đánh dấu ô mới đánh
                g.setColor(Color.RED);
                g.drawRect(checked.get(checked.size()-1).x*Width+X0, checked.get(checked.size()-1).y*Width+Y0, Width, Width);
                super.paintComponent(g);
            }
        };

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Cờ Caro");
        setBackground(new java.awt.Color(19, 59, 84));
        setBounds(new java.awt.Rectangle(0, 0, 0, 0));
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setResizable(false);
        setSize(new java.awt.Dimension(800, 630));

        jPMain.setBackground(new java.awt.Color(206, 188, 151));
        jPMain.setPreferredSize(new java.awt.Dimension(800, 647));

        jP_Roomnumber.setBackground(new java.awt.Color(206, 188, 151));
        jP_Roomnumber.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Số phòng", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 1, 15))); // NOI18N
        jP_Roomnumber.setPreferredSize(new java.awt.Dimension(780, 41));

        jLabel1.setBackground(new java.awt.Color(166, 228, 249));
        jLabel1.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("01");

        javax.swing.GroupLayout jP_RoomnumberLayout = new javax.swing.GroupLayout(jP_Roomnumber);
        jP_Roomnumber.setLayout(jP_RoomnumberLayout);
        jP_RoomnumberLayout.setHorizontalGroup(
            jP_RoomnumberLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 770, Short.MAX_VALUE)
        );
        jP_RoomnumberLayout.setVerticalGroup(
            jP_RoomnumberLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING)
        );

        jP_PlayerX.setBackground(new java.awt.Color(206, 188, 151));
        jP_PlayerX.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Người chơi 1:", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 1, 13))); // NOI18N
        jP_PlayerX.setPreferredSize(new java.awt.Dimension(203, 77));

        jLb_PlayerX.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLb_PlayerX.setText("Trung Ngo:");

        jLb_IconX.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/X.png"))); // NOI18N
        jLb_IconX.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        javax.swing.GroupLayout jP_PlayerXLayout = new javax.swing.GroupLayout(jP_PlayerX);
        jP_PlayerX.setLayout(jP_PlayerXLayout);
        jP_PlayerXLayout.setHorizontalGroup(
            jP_PlayerXLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jP_PlayerXLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLb_PlayerX, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(83, 83, 83))
            .addGroup(jP_PlayerXLayout.createSequentialGroup()
                .addGap(60, 60, 60)
                .addComponent(jLb_IconX)
                .addContainerGap())
        );
        jP_PlayerXLayout.setVerticalGroup(
            jP_PlayerXLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jP_PlayerXLayout.createSequentialGroup()
                .addComponent(jLb_IconX)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLb_PlayerX)
                .addContainerGap())
        );

        jP_PlayerO.setBackground(new java.awt.Color(206, 188, 151));
        jP_PlayerO.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Người chơi 2:", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 1, 13))); // NOI18N
        jP_PlayerO.setPreferredSize(new java.awt.Dimension(203, 77));

        jLb_PlayerO.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLb_PlayerO.setText("Tri Nguyen:");

        jLb_IconO.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/O.png"))); // NOI18N
        jLb_IconO.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        javax.swing.GroupLayout jP_PlayerOLayout = new javax.swing.GroupLayout(jP_PlayerO);
        jP_PlayerO.setLayout(jP_PlayerOLayout);
        jP_PlayerOLayout.setHorizontalGroup(
            jP_PlayerOLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jP_PlayerOLayout.createSequentialGroup()
                .addGroup(jP_PlayerOLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jP_PlayerOLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLb_PlayerO))
                    .addGroup(jP_PlayerOLayout.createSequentialGroup()
                        .addGap(60, 60, 60)
                        .addComponent(jLb_IconO)))
                .addGap(0, 78, Short.MAX_VALUE))
        );
        jP_PlayerOLayout.setVerticalGroup(
            jP_PlayerOLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jP_PlayerOLayout.createSequentialGroup()
                .addComponent(jLb_IconO)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 8, Short.MAX_VALUE)
                .addComponent(jLb_PlayerO))
        );

        jP_Option.setBackground(new java.awt.Color(206, 188, 151));
        jP_Option.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Tùy chọn:", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 1, 12))); // NOI18N
        jP_Option.setPreferredSize(new java.awt.Dimension(278, 77));

        jBt_StartMatch.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/bt_Ready.png"))); // NOI18N
        jBt_StartMatch.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jBt_StartMatchMouseClicked(evt);
            }
        });

        jBt_OutMatch.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/bt_outMatch.png"))); // NOI18N
        jBt_OutMatch.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jBt_OutMatchMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jP_OptionLayout = new javax.swing.GroupLayout(jP_Option);
        jP_Option.setLayout(jP_OptionLayout);
        jP_OptionLayout.setHorizontalGroup(
            jP_OptionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jP_OptionLayout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addComponent(jBt_StartMatch)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 48, Short.MAX_VALUE)
                .addComponent(jBt_OutMatch)
                .addGap(28, 28, 28))
        );
        jP_OptionLayout.setVerticalGroup(
            jP_OptionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jP_OptionLayout.createSequentialGroup()
                .addContainerGap(15, Short.MAX_VALUE)
                .addGroup(jP_OptionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jBt_OutMatch)
                    .addComponent(jBt_StartMatch))
                .addContainerGap(14, Short.MAX_VALUE))
        );

        jP_TimeMatch.setBackground(new java.awt.Color(206, 188, 151));
        jP_TimeMatch.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Thời gian trận đấu:", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 1, 12))); // NOI18N
        jP_TimeMatch.setPreferredSize(new java.awt.Dimension(129, 58));
        jP_TimeMatch.setRequestFocusEnabled(false);

        jLb_TimeTurn1.setFont(new java.awt.Font("Arial", 1, 15)); // NOI18N
        jLb_TimeTurn1.setForeground(new java.awt.Color(0, 0, 102));
        jLb_TimeTurn1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLb_TimeTurn1.setText("10:00");

        javax.swing.GroupLayout jP_TimeMatchLayout = new javax.swing.GroupLayout(jP_TimeMatch);
        jP_TimeMatch.setLayout(jP_TimeMatchLayout);
        jP_TimeMatchLayout.setHorizontalGroup(
            jP_TimeMatchLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLb_TimeTurn1, javax.swing.GroupLayout.DEFAULT_SIZE, 119, Short.MAX_VALUE)
        );
        jP_TimeMatchLayout.setVerticalGroup(
            jP_TimeMatchLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jP_TimeMatchLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLb_TimeTurn1)
                .addContainerGap())
        );

        jP_Timeturn.setBackground(new java.awt.Color(206, 188, 151));
        jP_Timeturn.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Thời gian đánh:", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 1, 12))); // NOI18N
        jP_Timeturn.setPreferredSize(new java.awt.Dimension(129, 58));
        jP_Timeturn.setRequestFocusEnabled(false);

        jLb_TimeTurn.setFont(new java.awt.Font("Arial", 1, 15)); // NOI18N
        jLb_TimeTurn.setForeground(new java.awt.Color(204, 0, 0));
        jLb_TimeTurn.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLb_TimeTurn.setText("30");

        javax.swing.GroupLayout jP_TimeturnLayout = new javax.swing.GroupLayout(jP_Timeturn);
        jP_Timeturn.setLayout(jP_TimeturnLayout);
        jP_TimeturnLayout.setHorizontalGroup(
            jP_TimeturnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLb_TimeTurn, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 119, Short.MAX_VALUE)
        );
        jP_TimeturnLayout.setVerticalGroup(
            jP_TimeturnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jP_TimeturnLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLb_TimeTurn)
                .addContainerGap())
        );

        jP_Chatbox.setBackground(new java.awt.Color(206, 188, 151));
        jP_Chatbox.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Trò chuyện:", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 1, 12))); // NOI18N
        jP_Chatbox.setPreferredSize(new java.awt.Dimension(278, 428));

        jTF_Writechat.setBackground(new java.awt.Color(235, 228, 214));
        jTF_Writechat.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jTF_Writechat.setPreferredSize(new java.awt.Dimension(196, 27));

        jTA_Box.setEditable(false);
        jTA_Box.setBackground(new java.awt.Color(235, 228, 214));
        jTA_Box.setColumns(20);
        jTA_Box.setRows(5);
        jTA_Box.setPreferredSize(new java.awt.Dimension(266, 500));
        jScrollPane2.setViewportView(jTA_Box);

        jBt_Send.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/bt_Send.png"))); // NOI18N
        jBt_Send.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jBt_SendMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jP_ChatboxLayout = new javax.swing.GroupLayout(jP_Chatbox);
        jP_Chatbox.setLayout(jP_ChatboxLayout);
        jP_ChatboxLayout.setHorizontalGroup(
            jP_ChatboxLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jP_ChatboxLayout.createSequentialGroup()
                .addGap(13, 13, 13)
                .addComponent(jTF_Writechat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jBt_Send)
                .addContainerGap())
            .addComponent(jScrollPane2)
        );
        jP_ChatboxLayout.setVerticalGroup(
            jP_ChatboxLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jP_ChatboxLayout.createSequentialGroup()
                .addComponent(jScrollPane2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jP_ChatboxLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jBt_Send)
                    .addComponent(jTF_Writechat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(6, 6, 6))
        );

        jPanel1.setBackground(new java.awt.Color(206, 188, 151));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Bàn cờ", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 1, 13))); // NOI18N
        jPanel1.setPreferredSize(new java.awt.Dimension(492, 492));
        jPanel1.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                jPanel1MouseMoved(evt);
            }
        });
        jPanel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel1MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 482, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 469, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPMainLayout = new javax.swing.GroupLayout(jPMain);
        jPMain.setLayout(jPMainLayout);
        jPMainLayout.setHorizontalGroup(
            jPMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPMainLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPMainLayout.createSequentialGroup()
                        .addComponent(jP_Roomnumber, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPMainLayout.createSequentialGroup()
                        .addGroup(jPMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPMainLayout.createSequentialGroup()
                                .addComponent(jP_PlayerX, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jP_PlayerO, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPMainLayout.createSequentialGroup()
                                .addComponent(jP_Timeturn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jP_TimeMatch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jP_Option, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jP_Chatbox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap())
        );
        jPMainLayout.setVerticalGroup(
            jPMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPMainLayout.createSequentialGroup()
                .addComponent(jP_Roomnumber, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jP_PlayerX, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jP_PlayerO, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jP_Option, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(8, 8, 8)
                .addGroup(jPMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPMainLayout.createSequentialGroup()
                        .addGroup(jPMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jP_Timeturn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jP_TimeMatch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jP_Chatbox, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPMain, javax.swing.GroupLayout.DEFAULT_SIZE, 804, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPMain, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jPanel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel1MouseClicked
        if (!turnFlag)
			return;

		if (currentColumn < 0 || currentColumn >= 18 || currentRow < 0 || currentRow >= 18)
			return;

		turnFlag = false;
		turnPlay(false, currentColumn, currentRow);

		SendMessage.play(currentColumn, currentRow);

		currentColumn = -1;
		currentRow = -1;
    }//GEN-LAST:event_jPanel1MouseClicked

    private void jPanel1MouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel1MouseMoved
        if (!turnFlag)
			return;

		int CX = evt.getX();
		int CY = evt.getY();
		if (CY - Y0 < 0) {
			currentColumn = (CX - X0) / Width;
			currentRow = -1 + (CY - Y0) / Width;
			return;
		}
		if (CX - X0 < 0) {
			currentColumn = -1 + (CX - X0) / Width;
			currentRow = (CY - Y0) / Width;
			return;
		}
		currentColumn = (CX - X0) / Width;
		currentRow = (CY - Y0) / Width;
		Point p = new Point(currentColumn, currentRow);
		if (checked.contains(p)) {
			currentColumn = -1;
			currentRow = -1;
		}
		jPanel1.repaint();
		jPanel1.validate();
    }//GEN-LAST:event_jPanel1MouseMoved

    private void jBt_StartMatchMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jBt_StartMatchMouseClicked
		SoundPack.clickb();
        SendMessage.send("ready");
		jBt_StartMatch.setEnabled(false);
    }//GEN-LAST:event_jBt_StartMatchMouseClicked

    private void jBt_OutMatchMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jBt_OutMatchMouseClicked
		SoundPack.clickb();
        if (endFlag || Client.confirm("Bạn có muốn thoát khỏi trận đấu?") == 0) {
			outFlag = true;
			SendMessage.send("outroom");
		}
		if (specFlag) {
			endFlag = true;
		}
    }//GEN-LAST:event_jBt_OutMatchMouseClicked

    private void jBt_SendMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jBt_SendMouseClicked
        String mes = jTF_Writechat.getText();
		jTF_Writechat.setText("");
		SendMessage.chat(mes);
    }//GEN-LAST:event_jBt_SendMouseClicked

    public static void main(String[] args) {
		java.awt.EventQueue.invokeLater(new Runnable() {
			public void run() {
				new GameScreenGUI().setVisible(true);
			}
		});
	}
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jBt_OutMatch;
    private javax.swing.JLabel jBt_Send;
    private javax.swing.JLabel jBt_StartMatch;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLb_IconO;
    private javax.swing.JLabel jLb_IconX;
    private javax.swing.JLabel jLb_PlayerO;
    private javax.swing.JLabel jLb_PlayerX;
    private javax.swing.JLabel jLb_TimeTurn;
    private javax.swing.JLabel jLb_TimeTurn1;
    private javax.swing.JPanel jPMain;
    private javax.swing.JPanel jP_Chatbox;
    private javax.swing.JPanel jP_Option;
    private javax.swing.JPanel jP_PlayerO;
    private javax.swing.JPanel jP_PlayerX;
    private javax.swing.JPanel jP_Roomnumber;
    private javax.swing.JPanel jP_TimeMatch;
    private javax.swing.JPanel jP_Timeturn;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextArea jTA_Box;
    private javax.swing.JTextField jTF_Writechat;
    // End of variables declaration//GEN-END:variables


	// Massan code
	public static GameScreenGUI ins = new GameScreenGUI();
    public int roomNum;
	public String namePlayer1, namePlayer2;
    public boolean turnFlag, endFlag, outFlag, specFlag, isCross;
	public int[][] mat;

	public void init() {
		roomNum = 0;
		namePlayer1 = namePlayer2 = "";
		turnFlag = endFlag = outFlag = specFlag = isCross = false;
		mat = null;

        // Set cursor
		Image i = Toolkit.getDefaultToolkit().getImage(getClass().getClassLoader().getResource("./image/pen.png"));
		Cursor c = Toolkit.getDefaultToolkit().createCustomCursor(i, new Point(0, 0), "cursorPen");
		jPanel1.setCursor(c);
    }

	public void newSession() {
		jBt_StartMatch.setEnabled(true);
		jTF_Writechat.setEnabled(true);
		jBt_Send.setEnabled(true);
		checked.removeAllElements();
		jTA_Box.setText("");

		jLabel1.setText(String.valueOf(roomNum));
		jLb_PlayerX.setText(namePlayer1);
		jLb_PlayerO.setText(namePlayer2);
	}

	public void setMatrix() {
		jBt_StartMatch.setEnabled(false);

		List<Point> pX = new ArrayList<>();
		List<Point> pO = new ArrayList<>();
		for (int x=0; x <18; x++)
			for (int y=0; y <18; y++)
				if (mat[x][y] == 1)
					pX.add(new Point(x, y));
				else if (mat[x][y] == 2)
					pO.add(new Point(x, y));

		int loop = pO.size();
		for (int i=0; i<loop; i++) {
			checked.add(pX.get(i));
			checked.add(pO.get(i));
		}
		if (pX.size() > pO.size())
			checked.add(pX.get(pX.size()-1));


		mat = null;
		jPanel1.repaint();
	}

	public void turnPlay(boolean turn, int x, int y) {

		if (mat != null)
			setMatrix();

		turnFlag = turn;

		if (turn)
			jPanel1.setBorder(new LineBorder(Color.BLACK));
		else
			jPanel1.setBorder(new LineBorder(Color.WHITE));

		if (x == 666 && y == 666) {
			checked.add(new Point(666, 666));
			return;
		}

		if (x < 0 || x >= 18 || y < 0 || y >= 18)
			return;

		Point p = new Point(x, y);
		if (!checked.contains(p))
			checked.add(p);

		jPanel1.repaint();
	}

	public void endSession() {
		jBt_StartMatch.setEnabled(false);
		jTF_Writechat.setEnabled(false);
		jBt_Send.setEnabled(false);
	}

	public void addChat(String mes) {
		String totalMes = jTA_Box.getText();
		totalMes = totalMes+'\n'+mes;
		int len = totalMes.length();
		if (len > 512)
			totalMes = totalMes.substring(len - 512);
		jTA_Box.setText(totalMes);
	}

	public void setCD(int roundCD, int turnCD) {
		jLb_TimeTurn.setText(turnCD +" giây");

		String MStr = String.valueOf((int)Math.floor(roundCD/60.0));
		String SStr = String.valueOf(roundCD%60);
		jLb_TimeTurn1.setText(MStr+':'+SStr);
	}

}
