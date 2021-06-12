import java.awt.*;
import java.awt.List;
import java.awt.event.*;
import java.awt.geom.Rectangle2D;
import java.awt.geom.RoundRectangle2D;
import java.awt.geom.Rectangle2D.Double;
import java.util.*;
import javax.swing.*;
import javax.swing.border.LineBorder;

public class Alphabet extends JPanel implements KeyListener {
	private StartFrame f; // 시작 frame
	private JButton btn_home, btn_title, btn_prof; // 홈버튼, 제목
	private JPanel panel_prof, panel_username;
	private JTextField tf_userInput; // 사용자 입력 텍스트 필드
	private ArrayList<Character> list_whole = new ArrayList<Character>(); // 전체 알파벳 리스트
	private ArrayList<Character> list_choice = new ArrayList<Character>(); // 랜덤하게 뽑은 20개 알파벳 리스트
	private ArrayList<Character> list_user = new ArrayList<Character>();	//사용자 입력 문자 리스트
	private int maxCount; // 입력할 알파벳 개수(20개)
	private int count = 0, ranNum; // 사용자가 입력한 알파벳 개수 count, 랜덤하게 알파벳 뽑을 때 사용하는 변수
	private JLabel AlphaOne, AlphaTwo, AlphaThree, AlphaFour; // 입력할 알파벳들이 뜨는 label 4개
	private JLabel UserType;
	private JButton btn_keyboard;
	private JLabel UserTypo, UserAccuracy;
	int usercnt = 0;
	int rightcnt = 0, wrongcnt = 0;
	private Font font;
	
	public void setFocus() {
		tf_userInput.requestFocus();
	}

	/**** 생성자 ****/
	public Alphabet(StartFrame f) {
		/**** 배경 설정 ****/
		this.f = f;
		setLayout(null);
		setBackground(new Color(239, 239, 143));
		font = new Font(("ELAND 나이스 Medium"), Font.PLAIN, 35);

		list_choice = MakeList();
		maxCount = list_choice.size();

		/**** 홈 버튼 설정 ****/
		Image img_home = new ImageIcon("Final/images/home.png").getImage().getScaledInstance(40, 40, Image.SCALE_SMOOTH);
		btn_home = new JButton(new ImageIcon(img_home));
		add(btn_home);
		btn_home.setBounds(700, 20, 50, 40);

		/**** 게임 제목 버튼 설정 ****/
		btn_title = new JButton(new ImageIcon("Final/images/btn_alpha.png"));
		btn_title.setBounds(280, 15, 220, 60);
		btn_title.setBorderPainted(false);
		btn_title.setContentAreaFilled(false);
		btn_title.setFocusPainted(false);
		add(btn_title);

		/**** 비율을 고려하여 이미지 리사이즈(참고) ****/
//		Image img_prof =  new ImageIcon("Final/images/prof.png").getImage();
//		double img_prof_width = img_prof.getWidth(null);
//		double img_prof_height = img_prof.getHeight(null);
//		double img_prof_ratio = img_prof_height/img_prof_width;
//		System.out.println(img_prof_width + "," +  img_prof_height+ ","+ img_prof_ratio);
//		Image re_img_prof = img_prof.getScaledInstance(150*img_prof_ratio, 150, Image.SCALE_SMOOTH);

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
		AlphaOne = new JLabel();
		AlphaOne.setFont(font);
		AlphaTwo = new JLabel();
		AlphaTwo.setFont(font);
		AlphaThree = new JLabel();
		AlphaThree.setFont(font);
		AlphaFour = new JLabel();
		AlphaFour.setFont(font);

		AlphaOne.setText("");
		AlphaTwo.setText(list_choice.get(0).toString());
		AlphaThree.setText(list_choice.get(1).toString());
		AlphaFour.setText(list_choice.get(2).toString());

		AlphaOne.setBounds(95, 120, 40, 90);
		AlphaTwo.setBounds(210, 120, 40, 90);
		AlphaThree.setBounds(335, 120, 40, 90);
		AlphaFour.setBounds(455, 120, 40, 90);

		add(AlphaOne);
		add(AlphaTwo);
		add(AlphaThree);
		add(AlphaFour);
		
		////입력문자 출력
		UserType = new JLabel();
		UserType.setFont(font);
		UserType.setBounds(275, 220, 50, 100);
		add(UserType);

		/**** 사용자 입력 필드 ****/
		tf_userInput = new JTextField();
		tf_userInput.setBounds(1000, 800, 5, 5);
		add(tf_userInput);
		

		tf_userInput.addKeyListener(this);

		btn_home.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				f.changePanel("Main");
			}
		});

		UserTypo = new JLabel();
		UserTypo.setFont(new Font(("ELAND 나이스 Medium"), Font.PLAIN, 20));
		UserTypo.setText("오타 수: ");
		UserTypo.setBounds(600, 170, 300, 100);
		add(UserTypo);

		UserAccuracy = new JLabel();
		UserAccuracy.setFont(new Font(("ELAND 나이스 Medium"), Font.PLAIN, 20));
		UserAccuracy.setText("정확도: ");
		UserAccuracy.setBounds(600, 220, 300, 100);
		add(UserAccuracy);
		
		
		/****키보드****/
		Image img_keyboard = new ImageIcon("Final/images/key.png").getImage().getScaledInstance(472, 164,Image.SCALE_SMOOTH);
		btn_keyboard = new JButton(new ImageIcon(img_keyboard));
		btn_keyboard.setBounds(20, 260, 540, 300);
		btn_keyboard.setBorderPainted(false);
		btn_keyboard.setContentAreaFilled(false);
		btn_keyboard.setFocusPainted(false);
		add(btn_keyboard);
	}

	public ArrayList<Character> MakeList() {
		for (int num = 65; num < 123; num++) {
			if (num == 91)
				num = 97;
			char ch = (char) num;
			list_whole.add(ch);
		}

		for (int i = 0; i < 20; i++) {
			ranNum = (int) (Math.random() * 52);
			list_choice.add(list_whole.get(ranNum));
		}

		return list_choice;
	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D) g;
		
		//paenl_game background
		g2.setColor(Color.white);
		g2.fill(new Rectangle2D.Double(20, 90, 540, 450));
		
		//panel_score background
		g2.setColor(Color.white);
		g2.fill(new Rectangle2D.Double(580, 150, 180, 190));
		
		// AlphaOne
		g2.setColor(Color.white);
		g2.fill(new RoundRectangle2D.Double(65, 120, 85, 95, 30, 30)); // 배경
		g2.setColor(Color.red);
		g2.setStroke(new BasicStroke(5));
		g2.draw(new RoundRectangle2D.Double(65, 120, 85, 95, 30, 30)); // 테두리

		// AlphaTwo
		g2.setColor(Color.DARK_GRAY);
		g2.fill(new RoundRectangle2D.Double(185, 120, 90, 100, 30, 30)); // 그림자
		g2.setColor(Color.white);
		g2.fill(new RoundRectangle2D.Double(180, 115, 85, 95, 30, 30)); // 배경
		g2.setColor(Color.red);
		g2.setStroke(new BasicStroke(5));
		g2.draw(new RoundRectangle2D.Double(180, 115, 85, 95, 30, 30)); // 테두리

		// AlphaThree
		g2.setColor(Color.white);
		g2.fill(new RoundRectangle2D.Double(305, 120, 85, 95, 30, 30)); // 배경
		g2.setColor(Color.red);
		g2.setStroke(new BasicStroke(5));
		g2.draw(new RoundRectangle2D.Double(305, 120, 85, 95, 30, 30)); // 테두리

		// AlphaFour
		g2.setColor(Color.white);
		g2.fill(new RoundRectangle2D.Double(425, 120, 85, 95, 30, 30)); // 배경
		g2.setColor(Color.red);
		g2.setStroke(new BasicStroke(5));
		g2.draw(new RoundRectangle2D.Double(425, 120, 85, 95, 30, 30)); // 테두리
		
		//user typing background
		g2.setColor(Color.white);
		g2.fill(new Rectangle2D.Double(55, 240, 470, 60));
		g2.setColor(Color.LIGHT_GRAY);
		g2.setStroke(new BasicStroke(5));
		g2.draw(new Rectangle2D.Double(55, 240, 470, 60));
	}

	public void keyTyped(KeyEvent e) {
		
		list_user.add(e.getKeyChar());
		usercnt = list_user.size();

		
		if (list_choice.get(rightcnt).equals(e.getKeyChar())) {
			if (rightcnt == maxCount-1) {
				UserTypo.setText("오타 수 : " + wrongcnt + "개");
				UserAccuracy.setText("정확도: " + Math.round((double)rightcnt / ((double)wrongcnt + (double)rightcnt) * 10000)/100.0 + "%");
				JOptionPane.showMessageDialog(null, "게임 종료!");
			} else {
				if (list_choice.size() - rightcnt == 3) {
					AlphaOne.setText(list_choice.get(rightcnt).toString());
					AlphaTwo.setText(list_choice.get(rightcnt + 1).toString());
					AlphaThree.setText(list_choice.get(rightcnt + 2).toString());
					AlphaFour.setText("");
				} else if (list_choice.size() - rightcnt == 2) {
					AlphaOne.setText(list_choice.get(rightcnt).toString());
					AlphaTwo.setText(list_choice.get(rightcnt + 1).toString());
					AlphaThree.setText("");
					AlphaFour.setText("");
				} else if (list_choice.size() - rightcnt == 1) {
					AlphaOne.setText(list_choice.get(rightcnt).toString());
					AlphaTwo.setText("");
					AlphaThree.setText("");
					AlphaFour.setText("");
				} else if (list_choice.size() - rightcnt == 0) {
					AlphaOne.setText("");
					AlphaTwo.setText("");
					AlphaThree.setText("");
					AlphaFour.setText("");
				} else {
					AlphaOne.setText(list_choice.get(rightcnt).toString());
					AlphaTwo.setText(list_choice.get(rightcnt + 1).toString());
					AlphaThree.setText(list_choice.get(rightcnt + 2).toString());
					AlphaFour.setText(list_choice.get(rightcnt + 3).toString());

				}
			}
			UserType.setForeground(Color.black);
			UserType.setText(list_user.get(usercnt-1).toString());
		
			rightcnt++;
		} else {
			wrongcnt++;
			UserType.setForeground(Color.red);
			UserType.setText(list_user.get(usercnt-1).toString());
			
		}

	}

	public void keyReleased(KeyEvent e) {
	}

	public void keyPressed(KeyEvent e) {

	}

}
