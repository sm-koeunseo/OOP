import java.awt.*;
import java.awt.event.*;
import java.util.*;

import javax.swing.*;

public class Alphabet extends JPanel implements KeyListener {
	private StartFrame f;
	private Button btn_main;
	private TextField tf;
	private ArrayList<Character> list = new ArrayList<>(Arrays.asList('t', 'e', 'x', 't', 'g', 'a', 'm', 'e'));
	private int maxCount = list.size();
	private int count = 0;
	private String str = "";
	private Label label;
	private Label AlphaOne, AlphaTwo, AlphaThree, AlphaFour;
	Queue<String> queue = new LinkedList<String>();
	int front = 0;

	public Alphabet(StartFrame f) {
		this.f = f;
		setLayout(null);

		btn_main = new Button("돌아가기");
		add(btn_main);
		btn_main.setBounds(30, 30, 100, 20);

		for (int i = 0; i < list.size(); i++) {
			str += list.get(i);
		}
		label = new Label(str);
		label.setBounds(10, 100, 400, 60);
		add(label);

		tf = f.getAlphabet();
		tf.setBounds(10, 200, 400, 40);
		add(tf);

		tf.addKeyListener(this);

		btn_main.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				f.changePanel("Main");
			}
		});

		AlphaOne = new Label();
		AlphaTwo = new Label();
		AlphaThree = new Label();
		AlphaFour = new Label();

		AlphaOne.setText("");
		AlphaTwo.setText(list.get(0).toString());
		AlphaThree.setText(list.get(1).toString());
		AlphaFour.setText(list.get(2).toString());

		for (int j = 0; j < list.size(); j++) {
			queue.add(list.get(j).toString());
		}

		AlphaOne.setBounds(140, 50, 20, 50);
		AlphaTwo.setBounds(200, 50, 20, 50);
		AlphaThree.setBounds(260, 50, 20, 50);
		AlphaFour.setBounds(320, 50, 20, 50);

		add(AlphaOne);
		add(AlphaTwo);
		add(AlphaThree);
		add(AlphaFour);
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
			if (list.get(count++).equals(e.getKeyChar())) {
				System.out.println("right");
				
				queue.poll();

				if (list.size() - front == 3) {
					AlphaOne.setText(list.get(front).toString());
					AlphaTwo.setText(list.get(front + 1).toString());
					AlphaThree.setText(list.get(front + 2).toString());
					AlphaFour.setText("");
				}
				else if (list.size() - front == 2) {
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
				
				if(count == maxCount) {
					JOptionPane.showMessageDialog(null, "게임 종료!");
				}
					
				
				
				front++;
				
			} else
				System.out.println("false");
		}
	}

	public void keyReleased(KeyEvent e) {
	}

	public void keyPressed(KeyEvent e) {
	}
}
