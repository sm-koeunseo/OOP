package taja.alphabet;

import taja.main.*;

import java.awt.*;
import java.awt.event.*;
import java.awt.geom.Rectangle2D;
import java.awt.geom.RoundRectangle2D;
import java.awt.geom.Rectangle2D.Double;
import java.util.*;
import javax.swing.*;
import javax.swing.border.LineBorder;

public class Alphabet extends JPanel implements KeyListener {
	private StartFrame f;		//시작 frame
	private Button btn_back;	//홈버튼
	private TextField tf;		//사용자 입력 텍스트 필드
	private ArrayList<Character> alphalist = new ArrayList<Character>();	//전체 알파벳 리스트
	private ArrayList<Character> list = new ArrayList<Character>();			//랜덤하게 뽑은 20개 알파벳 리스트
	private int maxCount;				// 입력할 알파벳 개수(20개)
	private int count = 0, ranNum;		// 사용자가 입력한 알파벳 개수 count, 랜덤하게 알파벳 뽑을 때 사용하는 변수
	private JLabel AlphaOne, AlphaTwo, AlphaThree, AlphaFour;		//입력할 알파벳들이 뜨는 label 4개 
	private JLabel Title;				//게임 제목
	Queue<String> queue = new LinkedList<String>();	//사용자가 알파벳 하나를 입력할 때마다 순차적으로 뒤에 것을 출력해주기 위해 FIFO 형식의 queue를 사용
	int front = 0;				//alphalist에서 사용자 입력에 따라 front 하나씩 뒤로 가게끔	

	public Alphabet(StartFrame f) {			//생성자
		this.f = f;
		setLayout(null);
		
		Color color = new Color(239, 239, 143);
        setBackground(color);

		list = MakeList();
		maxCount = list.size();

		btn_back = new Button("홈");
		add(btn_back);
		btn_back.setBounds(700, 20, 40, 40);

		Title = new JLabel("자리 연습");
		Title.setBounds(330, 20, 300, 50);
		Title.setFont(new Font("Serif", Font.BOLD, 30));
		add(Title);

		tf = f.getAlphabet();
		tf.setBounds(100, 280, 600, 40);
		add(tf);

		tf.addKeyListener(this);

		btn_back.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				f.changePanel("Main");
			}
		});

		AlphaOne = new JLabel();
		AlphaOne.setFont(new Font("Serif", Font.BOLD, 38));
		AlphaTwo = new JLabel();
		AlphaTwo.setFont(new Font("Serif", Font.BOLD, 38));
		AlphaThree = new JLabel();
		AlphaThree.setFont(new Font("Serif", Font.BOLD, 38));
		AlphaFour = new JLabel();
		AlphaFour.setFont(new Font("Serif", Font.BOLD, 38));

		AlphaOne.setText("");
		AlphaTwo.setText(list.get(0).toString());
		AlphaThree.setText(list.get(1).toString());
		AlphaFour.setText(list.get(2).toString());

		for (int j = 0; j < list.size(); j++) {
			queue.add(list.get(j).toString());
		}

		AlphaOne.setBounds(200, 100, 40, 100);
		AlphaTwo.setBounds(315, 95, 40, 100);
		AlphaThree.setBounds(440, 100, 40, 100);
		AlphaFour.setBounds(560, 100, 40, 100);

		add(AlphaOne);
		add(AlphaTwo);
		add(AlphaThree);
		add(AlphaFour);
	}

	public ArrayList<Character> MakeList() {
		for (int num = 65; num < 123; num++) {
			if (num == 91)
				num = 97;
			char ch = (char) num;
			alphalist.add(ch);
		}

		for (int i = 0; i < 20; i++) {
			ranNum = (int) (Math.random() * 52);
			list.add(alphalist.get(ranNum));
		}

		return list;
	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2= (Graphics2D)g;
		//AlphaOne
		g2.setColor(Color.white);
		g2.fill(new RoundRectangle2D.Double(170, 100, 85, 105, 30, 30)); //배경
		g2.setColor(Color.red);
		g2.setStroke(new BasicStroke(5));
		g2.draw(new RoundRectangle2D.Double(170, 100, 85, 105, 30, 30)); //테두리
		
		//AlphaTwo
		g2.setColor(Color.DARK_GRAY);
		g2.fill(new RoundRectangle2D.Double(290, 100, 90, 110, 30, 30)); //그림자
		g2.setColor(Color.white);
		g2.fill(new RoundRectangle2D.Double(285, 95, 85, 105, 30, 30)); //배경
		g2.setColor(Color.red);
		g2.setStroke(new BasicStroke(5));
		g2.draw(new RoundRectangle2D.Double(285, 95, 85, 105, 30, 30)); //테두리
		
		//AlphaThree
		g2.setColor(Color.white);
		g2.fill(new RoundRectangle2D.Double(410, 100, 85, 105, 30, 30)); //배경
		g2.setColor(Color.red);
		g2.setStroke(new BasicStroke(5));
		g2.draw(new RoundRectangle2D.Double(410, 100, 85, 105, 30, 30)); //테두리
		
		//AlphaFour
		g2.setColor(Color.white);
		g2.fill(new RoundRectangle2D.Double(530, 100, 85, 105, 30, 30)); //배경
		g2.setColor(Color.red);
		g2.setStroke(new BasicStroke(5));
		g2.draw(new RoundRectangle2D.Double(530, 100, 85, 105, 30, 30)); //테두리
	}
	
	public void keyTyped(KeyEvent e) {
		if (count < maxCount) {

			if (list.get(count++).equals(e.getKeyChar())) {
				System.out.println("right");

				queue.poll();

				if (list.size() - front == 3) {
					AlphaOne.setText(list.get(front).toString());
					AlphaTwo.setText(list.get(front + 1).toString());
					AlphaThree.setText(list.get(front + 2).toString());
					AlphaFour.setText("");
				} else if (list.size() - front == 2) {
					AlphaOne.setText(list.get(front).toString());
					AlphaTwo.setText(list.get(front + 1).toString());
					AlphaThree.setText("");
					AlphaFour.setText("");
				} else if (list.size() - front == 1) {
					AlphaOne.setText(list.get(front).toString());
					AlphaTwo.setText("");
					AlphaThree.setText("");
					AlphaFour.setText("");
				} else if (list.size() - front == 0) {
					AlphaOne.setText("");
					AlphaTwo.setText("");
					AlphaThree.setText("");
					AlphaFour.setText("");
				} else {
					AlphaOne.setText(list.get(front).toString());
					AlphaTwo.setText(list.get(front + 1).toString());
					AlphaThree.setText(list.get(front + 2).toString());
					AlphaFour.setText(list.get(front + 3).toString());
				}

				if (count == maxCount) {
					JOptionPane.showMessageDialog(null, "게임 종료!");
				}

				front++;

			} else {
				System.out.println("false");
				count--;
			}

		}
	}

	public void keyReleased(KeyEvent e) {
	}

	public void keyPressed(KeyEvent e) {
	}
	

	
}
