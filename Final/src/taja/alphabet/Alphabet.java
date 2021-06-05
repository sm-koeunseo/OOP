package taja.alphabet;

import taja.main.*;

import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;

public class Alphabet extends JPanel implements KeyListener {
	private StartFrame f;
	private Button btn_back, btn_next;
	private TextField tf;
	private ArrayList<Character> alphalist = new ArrayList<Character>();
	private ArrayList<Character> list = new ArrayList<Character>();
	private int maxCount;
	private int count = 0, ranNum;
	// private String str = "";
	// private Label label;
	private JLabel AlphaOne, AlphaTwo, AlphaThree, AlphaFour;
	private JLabel Title;
	Queue<String> queue = new LinkedList<String>();
	int front = 0;

	public Alphabet(StartFrame f) {
		this.f = f;
		setLayout(null);

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
		AlphaOne.setFont(new Font("Serif", Font.BOLD, 30));
		AlphaTwo = new JLabel();
		AlphaTwo.setFont(new Font("Serif", Font.BOLD, 30));
		AlphaThree = new JLabel();
		AlphaThree.setFont(new Font("Serif", Font.BOLD, 30));
		AlphaFour = new JLabel();
		AlphaFour.setFont(new Font("Serif", Font.BOLD, 30));

		AlphaOne.setText("");
		AlphaTwo.setText(list.get(0).toString());
		AlphaThree.setText(list.get(1).toString());
		AlphaFour.setText(list.get(2).toString());

		for (int j = 0; j < list.size(); j++) {
			queue.add(list.get(j).toString());
		}

		AlphaOne.setBounds(200, 150, 40, 100);
		AlphaTwo.setBounds(320, 150, 40, 100);
		AlphaThree.setBounds(440, 150, 40, 100);
		AlphaFour.setBounds(560, 150, 40, 100);

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

	public void keyTyped(KeyEvent e) {
		// System.out.println("keyTyped:" + e.getKeyChar());
		// System.out.println("keyTyped:" + e.);
//		switch(e.getKeyChar()) {
//		case 't':System.out.println('t'); break;
//		case 'e':System.out.println('e'); break;
//		case 'x':System.out.println('x'); break;
//		case 'ㅅ':System.out.println('ㅅ'); break;
//		}
		if (count < maxCount) {
			String tfstring = "";

			if (list.get(count++).equals(e.getKeyChar())) {
				System.out.println("right");
				
				tfstring += list.get(count++);

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
				tf.setText(tfstring);
				count--;
			}

		}
	}

	public void keyReleased(KeyEvent e) {
	}

	public void keyPressed(KeyEvent e) {
	}
}
