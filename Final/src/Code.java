
import java.awt.*;
import java.awt.List;
import java.awt.event.*;
import java.awt.geom.Rectangle2D;
import java.awt.geom.RoundRectangle2D;
import java.awt.geom.Rectangle2D.Double;
import java.util.*;
import javax.swing.*;
import javax.swing.border.LineBorder;

public class Code extends JPanel implements KeyListener {
	private StartFrame f; // 시작 frame
	private JButton btn_home, btn_title, btn_prof; // 홈버튼, 제목
	private JPanel panel_prof, panel_username;
	private JTextField tf_userInput; // 사용자 입력 텍스트 필드
//	private ArrayList<String> list_whole = new ArrayList<String>(); // 전체 알파벳 리스트
	private ArrayList<Character> list_user = new ArrayList<Character>(); // 사용자 입력 문자 리스트
	private int maxCount; // 입력할 알파벳 개수(20개)
	private JLabel CodeOne, CodeTwo, CodeThree, CodeFour; // 입력할 알파벳들이 뜨는 label 4개
	private JLabel UserOne, UserTwo, UserThree, UserFour;
	private JLabel UserTypo, UserAccuracy;
	int usercnt = 0, rowcnt = 0, colcnt = 0;
	int rightcnt = 0, wrongcnt = 0;
	private Font font;
	private char[][] list_compare;
	private String[] list_whole;

	public void setFocus() {
		tf_userInput.requestFocus();
	}

	/**** 생성자 ****/
	public Code(StartFrame f) {
		/**** 배경 설정 ****/
		this.f = f;
		setLayout(null);
		setBackground(new Color(239, 239, 143));
		font = new Font(("ELAND 나이스 Medium"), Font.PLAIN, 20);

		String[] list_whole = { "public static void main(String[] args) {", "System.out.print(\"Hello \");",
				"if (args.length > 0) {", "System.out.println(args[1]);", "} else {", "System.out.println(\"?????\");",
				"}", "}" };

		maxCount = list_whole.length;
		list_compare = new char[maxCount][100];

		for (int i = 0; i < maxCount; i++) {
			int strlen = list_whole[i].toCharArray().length;

			for (int j = 0; j < strlen; j++) {
				list_compare[i][j] = list_whole[i].toCharArray()[j];
			}
		}

		/**** 홈 버튼 설정 ****/
		btn_home = new JButton("홈");
		add(btn_home);
		btn_home.setBounds(700, 20, 50, 40);

		/**** 게임 제목 버튼 설정 ****/
		btn_title = new JButton(new ImageIcon("Final/images/btn_long.png"));
		btn_title.setBounds(280, 15, 220, 60);
		btn_title.setBorderPainted(false);
		btn_title.setContentAreaFilled(false);
		btn_title.setFocusPainted(false);
		add(btn_title);

		/**** 교수님 이미지 및 패널 설정 ****/
		Image img_prof = new ImageIcon("Final/images/prof.png").getImage().getScaledInstance(160, 160,
				Image.SCALE_SMOOTH);
		btn_prof = new JButton(new ImageIcon(img_prof));
		btn_prof.setBounds(585, 355, 170, 170);
		btn_prof.setBorderPainted(false);
		btn_prof.setContentAreaFilled(false);
		btn_prof.setFocusPainted(false);
		add(btn_prof);
		panel_prof = new JPanel();
		panel_prof.setBackground(Color.white);
		panel_prof.setBounds(580, 350, 180, 190);
		add(panel_prof);

		panel_username = new JPanel();
		panel_username.setBackground(Color.white);
		panel_username.setBounds(580, 90, 180, 50);
		add(panel_username);

		/**** 게임 패널 ****/
		CodeOne = new JLabel();
		CodeOne.setFont(font);
		CodeTwo = new JLabel();
		CodeTwo.setFont(font);
		CodeThree = new JLabel();
		CodeThree.setFont(font);
		CodeFour = new JLabel();
		CodeFour.setFont(font);

		CodeOne.setText(list_whole[0].toString());
		CodeTwo.setText(list_whole[1].toString());
		CodeThree.setText(list_whole[2].toString());
		CodeFour.setText(list_whole[3].toString());

		CodeOne.setBounds(60, 150, 470, 40);
		CodeTwo.setBounds(60, 240, 470, 40);
		CodeThree.setBounds(60, 330, 470, 40);
		CodeFour.setBounds(60, 420, 470, 40);

		add(CodeOne);
		add(CodeTwo);
		add(CodeThree);
		add(CodeFour);

		//// 입력문자 출력
		UserOne = new JLabel("");
		UserOne.setFont(font);
		UserOne.setBounds(60, 200, 470, 40);

		add(UserOne);

		UserTwo = new JLabel("");
		UserTwo.setFont(font);
		UserTwo.setBounds(60, 290, 470, 40);
		add(UserTwo);

		UserThree = new JLabel("");
		UserThree.setFont(font);
		UserThree.setBounds(60, 380, 470, 40);
		add(UserThree);

		UserFour = new JLabel("");
		UserFour.setFont(font);
		UserFour.setBounds(60, 470, 470, 40);
		add(UserFour);

		/**** 사용자 입력 필드 ****/
		tf_userInput = new JTextField();
		tf_userInput.setBounds(-10, 10, 10, 10);
		add(tf_userInput);
		tf_userInput.addKeyListener(this);

		btn_home.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				f.changePanel("Main");
			}
		});

		UserTypo = new JLabel();
		UserTypo.setFont(new Font("Serif", Font.BOLD, 20));
		UserTypo.setText("오타 수: ");
		UserTypo.setBounds(600, 170, 300, 100);
		add(UserTypo);

		UserAccuracy = new JLabel();
		UserAccuracy.setFont(new Font("Serif", Font.BOLD, 20));
		UserAccuracy.setText("정확도: ");
		UserAccuracy.setBounds(600, 220, 300, 100);
		add(UserAccuracy);
	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D) g;

		// paenl_game background
		g2.setColor(Color.white);
		g2.fill(new Rectangle2D.Double(20, 90, 540, 450));

		// panel_score background
		g2.setColor(Color.white);
		g2.fill(new Rectangle2D.Double(580, 150, 180, 190));

		// CodeOne
		g2.setColor(Color.white);
		g2.fill(new RoundRectangle2D.Double(55, 150, 470, 40, 30, 30)); // 배경
//		g2.setColor(Color.red);
//		g2.setStroke(new BasicStroke(5));
//		g2.draw(new RoundRectangle2D.Double(55, 150, 470, 40, 30, 30)); // 테두리

		// UserOne
		g2.setColor(Color.white);
		g2.fill(new Rectangle2D.Double(56, 200, 467, 40)); // 배경
		g2.setColor(Color.LIGHT_GRAY);
		g2.setStroke(new BasicStroke(3));
		g2.draw(new Rectangle2D.Double(56, 200, 467, 30)); // 테두리

		// CodeTwo
		g2.setColor(Color.white);
		g2.fill(new RoundRectangle2D.Double(55, 240, 470, 40, 30, 30)); // 배경
//		g2.setColor(Color.red);
//		g2.setStroke(new BasicStroke(5));
//		g2.draw(new RoundRectangle2D.Double(55, 240, 470, 40, 30, 30)); // 테두리

		// UserTwo
		g2.setColor(Color.white);
		g2.fill(new Rectangle2D.Double(56, 290, 467, 40)); // 배경
		g2.setColor(Color.LIGHT_GRAY);
		g2.setStroke(new BasicStroke(3));
		g2.draw(new Rectangle2D.Double(56, 290, 467, 30)); // 테두리

		// CodeThree
		g2.setColor(Color.white);
		g2.fill(new RoundRectangle2D.Double(55, 330, 470, 40, 30, 30)); // 배경
//		g2.setColor(Color.red);
//		g2.setStroke(new BasicStroke(5));
//		g2.draw(new RoundRectangle2D.Double(55, 330, 470, 40, 30, 30)); // 테두리

		// UserThree
		g2.setColor(Color.white);
		g2.fill(new Rectangle2D.Double(56, 380, 467, 40)); // 배경
		g2.setColor(Color.LIGHT_GRAY);
		g2.setStroke(new BasicStroke(3));
		g2.draw(new Rectangle2D.Double(56, 380, 467, 30)); // 테두리

		// CodeFour
		g2.setColor(Color.white);
		g2.fill(new RoundRectangle2D.Double(55, 420, 470, 40, 30, 30)); // 배경
//		g2.setColor(Color.red);
//		g2.setStroke(new BasicStroke(5));
//		g2.draw(new RoundRectangle2D.Double(55, 420, 470, 40, 30, 30)); // 테두리

		// UserFour
		g2.setColor(Color.white);
		g2.fill(new Rectangle2D.Double(56, 470, 467, 40)); // 배경
		g2.setColor(Color.LIGHT_GRAY);
		g2.setStroke(new BasicStroke(3));
		g2.draw(new Rectangle2D.Double(56, 470, 467, 30)); // 테두리

		// user typing background
//		g2.setColor(Color.yellow);
//		g2.fill(new Rectangle2D.Double(55, 220, 470, 60));
	}

	public void keyTyped(KeyEvent e) {
		System.out.println(e.getKeyChar());
		if (e.getKeyChar() == ' ') {
			colcnt++;
		} else if(e.getKeyChar() == '\n') {
			rowcnt++;
			colcnt = 0;
			tf_userInput.setText("");
		}else if(e.getKeyChar() == KeyEvent.VK_BACK_SPACE){
			if(colcnt == 0) {
				colcnt = 0;
			}
			else {
				colcnt--;
			}
			
		}else {
			list_user.add(e.getKeyChar());
			usercnt = list_user.size();

			if (list_compare[rowcnt][colcnt] == list_user.get(usercnt - 1)) {
				colcnt++;
				rightcnt++;

				if (colcnt == list_compare[rowcnt].length || e.getKeyChar() == '\n') {
					rowcnt++;
				}

			} else {
				colcnt++;
				wrongcnt++;

			}

		}

	}

	public void keyReleased(KeyEvent e) {
		switch (rowcnt) {
		case 0:
			UserOne.setForeground(Color.black);
			UserOne.setText(tf_userInput.getText());
			break;
		case 1:
			UserTwo.setForeground(Color.black);
			UserTwo.setText(tf_userInput.getText());
			break;
		case 2:
			UserThree.setForeground(Color.black);
			UserThree.setText(tf_userInput.getText());
			break;
		case 3:
			UserFour.setForeground(Color.black);
			UserFour.setText(tf_userInput.getText());
			break;
		}
	}

	public void keyPressed(KeyEvent e) {

	}

}
