import java.awt.*;
import java.awt.event.*;
import java.util.*;

import javax.swing.*;

public class Alphabet extends JPanel implements KeyListener{
	private StartFrame f;
	private Button btn_main;
	private TextField tf;
	private ArrayList<Character> list = new ArrayList<>(Arrays.asList('t', 'e', 'x', 't'));
	private int maxCount = list.size();
	private int count = 0;

	public Alphabet(StartFrame f) {
		this.f = f;
		setLayout(null);
		
		btn_main = new Button("돌아가기");
		add(btn_main);
		btn_main.setBounds(30, 30, 100, 20);
		
		tf = f.getAlphabet();
		tf.setBounds(10, 50, 400, 40);
		add(tf);
		
		tf.addKeyListener(this);
		
		btn_main.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				f.changePanel("Main");
			}
		});
	}
	
	public void keyTyped(KeyEvent e) {
		//System.out.println("keyTyped:" + e.getKeyChar());
		//System.out.println("keyTyped:" + e.);
//		switch(e.getKeyChar()) {
//		case 't':System.out.println('t'); break;
//		case 'e':System.out.println('e'); break;
//		case 'x':System.out.println('x'); break;
//		case 'ㅅ':System.out.println('ㅅ'); break;
//		}
		
		if(count < maxCount) {
			if(list.get(count++).equals(e.getKeyChar())) {
				System.out.println("right");
			}else
				System.out.println("false");
		}
	}
	public void keyReleased(KeyEvent e) {}
	public void keyPressed(KeyEvent e) {}
}
