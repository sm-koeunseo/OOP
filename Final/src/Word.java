import java.awt.Button;
import java.awt.TextField;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.Arrays;

import javax.swing.*;

public class Word extends JPanel implements KeyListener {
	private StartFrame f;
	private Button btn_main;
	private TextField tf;
	private ArrayList<String> list = new ArrayList<>(Arrays.asList("test", "text", "word", "oop"));

	public Word(StartFrame f) {
		this.f = f;
		setLayout(null);
		
		btn_main = new Button("돌아가기");
		add(btn_main);
		btn_main.setBounds(30, 30, 100, 20);
		
		tf = f.getWord();
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
		//System.out.println(e.getKeyChar());
		if (e.getKeyChar() == ' ')
			System.out.println("space");
		if (e.getKeyChar() == '\n')
			System.out.println("enter");
		
//		if(count < maxCount) {
//			if(list.get(count++).equals(e.getKeyChar())) {
//				System.out.println("right");
//			}else
//				System.out.println("false");
//		}
	}
	public void keyReleased(KeyEvent e) {}
	public void keyPressed(KeyEvent e) {}
}
