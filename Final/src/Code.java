
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
	private StartFrame f; // ���� frame
	private JButton btn_home, btn_title, btn_prof; // Ȩ��ư, ����
	private JPanel panel_prof, panel_username;
	private JTextField tf_userInput; // ����� �Է� �ؽ�Ʈ �ʵ�
	private ArrayList<String> list_whole = new ArrayList<String>(); // ��ü ���ĺ� ����Ʈ
	private ArrayList<String> list_choice = new ArrayList<String>(); // �����ϰ� ���� 20�� ���ĺ� ����Ʈ
	private ArrayList<Character> list_user = new ArrayList<Character>(); // ����� �Է� ���� ����Ʈ
	private int maxCount; // �Է��� ���ĺ� ����(20��)
	private int count = 0, ranNum; // ����ڰ� �Է��� ���ĺ� ���� count, �����ϰ� ���ĺ� ���� �� ����ϴ� ����
	private JLabel CodeOne, CodeTwo, CodeThree, CodeFour; // �Է��� ���ĺ����� �ߴ� label 4��
	private JLabel UserOne, UserTwo, UserThree, UserFour;
	private JLabel UserTypo, UserAccuracy;
	int usercnt = 0;
	int rightcnt = 0, wrongcnt = 0;

	/**** ������ ****/
	public Code(StartFrame f) {
		/**** ��� ���� ****/
		this.f = f;
		setLayout(null);
		setBackground(new Color(239, 239, 143));

		list_whole.add("test�Դϴ�");
		list_whole.add("test2");
		list_whole.add("test3");
		list_whole.add("test4");
		list_whole.add("test5");
		list_whole.add("test6");
		list_whole.add("test7");
		list_whole.add("test8");
		list_whole.add("test9");
		list_whole.add("test10");
		System.out.println(list_whole);
		list_choice = MakeList();
		System.out.println(list_choice);
		maxCount = list_choice.size();

		/**** Ȩ ��ư ���� ****/
		btn_home = new JButton("Ȩ");
		add(btn_home);
		btn_home.setBounds(700, 20, 50, 40);

		/**** ���� ���� ��ư ���� ****/
		btn_title = new JButton(new ImageIcon("Final/images/btn_long.png"));
		btn_title.setBounds(280, 30, 220, 60);
		btn_title.setBorderPainted(false);
		btn_title.setContentAreaFilled(false);
		btn_title.setFocusPainted(false);
		add(btn_title);

		/**** ������ �̹��� �� �г� ���� ****/
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

		/**** ���� �г� ****/
		CodeOne = new JLabel();
		CodeOne.setFont(new Font("Serif", Font.BOLD, 20));
		// CodeOne.setFont(new Font(("ELAND ���̽� Medium"), Font.PLAIN, 20));
		CodeTwo = new JLabel();
		CodeTwo.setFont(new Font("Serif", Font.BOLD, 20));
		CodeThree = new JLabel();
		CodeThree.setFont(new Font("Serif", Font.BOLD, 20));
		CodeFour = new JLabel();
		CodeFour.setFont(new Font("Serif", Font.BOLD, 20));

		CodeOne.setText(list_choice.get(0).toString());
		CodeTwo.setText(list_choice.get(1).toString());
		CodeThree.setText(list_choice.get(2).toString());
		CodeFour.setText(list_choice.get(3).toString());

		CodeOne.setBounds(70, 150, 470, 40);
		CodeTwo.setBounds(70, 240, 470, 40);
		CodeThree.setBounds(70, 330, 470, 40);
		CodeFour.setBounds(70, 420, 470, 40);

		add(CodeOne);
		add(CodeTwo);
		add(CodeThree);
		add(CodeFour);

		//// �Է¹��� ���
		UserOne = new JLabel();
		UserOne.setFont(new Font("Serif", Font.BOLD, 40));
		UserOne.setBounds(70, 150, 470, 40);
		add(UserOne);
		
		UserTwo = new JLabel();
		UserTwo.setFont(new Font("Serif", Font.BOLD, 40));
		UserTwo.setBounds(70, 240, 470, 40);
		add(UserTwo);
		
		UserThree = new JLabel();
		UserThree.setFont(new Font("Serif", Font.BOLD, 40));
		UserThree.setBounds(70, 330, 470, 40);
		add(UserThree);
		
		UserFour = new JLabel();
		UserFour.setFont(new Font("Serif", Font.BOLD, 40));
		UserFour.setBounds(70, 420, 470, 40);
		add(UserFour);

		/**** ����� �Է� �ʵ� ****/
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
		UserTypo.setFont(new Font("Serif", Font.BOLD, 20));
		UserTypo.setText("��Ÿ ��: ");
		UserTypo.setBounds(600, 170, 300, 100);
		add(UserTypo);

		UserAccuracy = new JLabel();
		UserAccuracy.setFont(new Font("Serif", Font.BOLD, 20));
		UserAccuracy.setText("��Ȯ��: ");
		UserAccuracy.setBounds(600, 220, 300, 100);
		add(UserAccuracy);
	}
	
	public ArrayList<String> MakeList() {

		for (int i = 0; i <5; i++) {
			ranNum = (int) (Math.random() * 10);
			list_choice.add(list_whole.get(ranNum));
		}

		return list_choice;
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
		g2.fill(new RoundRectangle2D.Double(55, 150, 470, 40, 30, 30)); // ���
		g2.setColor(Color.red);
		g2.setStroke(new BasicStroke(5));
		g2.draw(new RoundRectangle2D.Double(55, 150, 470, 40, 30, 30)); // �׵θ�

		// CodeTwo
		g2.setColor(Color.white);
		g2.fill(new RoundRectangle2D.Double(55, 240, 470, 40, 30, 30)); // ���
		g2.setColor(Color.red);
		g2.setStroke(new BasicStroke(5));
		g2.draw(new RoundRectangle2D.Double(55, 240, 470, 40, 30, 30)); // �׵θ�

		// CodeThree
		g2.setColor(Color.white);
		g2.fill(new RoundRectangle2D.Double(55, 330, 470, 40, 30, 30)); // ���
		g2.setColor(Color.red);
		g2.setStroke(new BasicStroke(5));
		g2.draw(new RoundRectangle2D.Double(55, 330, 470, 40, 30, 30)); // �׵θ�

		// CodeFour
		g2.setColor(Color.white);
		g2.fill(new RoundRectangle2D.Double(55, 420,470, 40, 30, 30)); // ���
		g2.setColor(Color.red);
		g2.setStroke(new BasicStroke(5));
		g2.draw(new RoundRectangle2D.Double(55, 420, 470, 40, 30, 30)); // �׵θ�

		// user typing background
//		g2.setColor(Color.yellow);
//		g2.fill(new Rectangle2D.Double(55, 220, 470, 60));
	}

	public void keyTyped(KeyEvent e) {

		list_user.add(e.getKeyChar());
		usercnt = list_user.size();
		UserOne.setText(list_user.get(usercnt - 1).toString());

		if (list_choice.get(rightcnt).equals(e.getKeyChar())) {
			if (rightcnt == maxCount - 1) {
				UserTypo.setText("��Ÿ �� : " + wrongcnt + "��");
				UserAccuracy.setText("��Ȯ��: "
						+ Math.round((double) rightcnt / ((double) wrongcnt + (double) rightcnt) * 10000) / 100.0
						+ "%");
				JOptionPane.showMessageDialog(null, "���� ����!");
			} else {

			}
			UserOne.setForeground(Color.black);
			UserOne.setText(list_user.get(usercnt - 1).toString());

			rightcnt++;
		} else {
			wrongcnt++;
			UserOne.setForeground(Color.red);
			UserOne.setText(list_user.get(usercnt - 1).toString());

		}

	}

	public void keyReleased(KeyEvent e) {
	}

	public void keyPressed(KeyEvent e) {

	}

}