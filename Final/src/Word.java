import java.awt.*;
import java.awt.event.*;
import java.util.*;

import javax.swing.*;

public class Word extends JPanel implements KeyListener {
	private StartFrame f;
	private Button btn_main;
	private JTextField tf;
	private ArrayList<String> list = new ArrayList<>(Arrays.asList("test", "text", "word", "oop", "time", "hi"));
	private Label[] label = new Label[4];
	private String tmp;

	public Word(StartFrame f) {
		this.f = f;
		setLayout(null);
		
		btn_main = new Button("돌아가기");
		add(btn_main);
		btn_main.setBounds(30, 30, 100, 20);
		
		tf = f.getWord();
		tf.setBounds(10, 300, 400, 30);
		tf.setFocusTraversalKeysEnabled(false);
		add(tf);
		
		label[0] = new Label("");
		label[0].setBounds(50, 200, 50, 100);
		add(label[0]);
		for (int i = 1; i < label.length; i++) {
			label[i] = new Label(list.get(0));
			list.remove(0);
			label[i].setBounds(50*(i+1), 200, 50, 100);
			add(label[i]);
		}
		
		tf.addKeyListener(this);
		tf.requestFocus();
		
		btn_main.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				f.changePanel("Main");
			}
		});
	}

	
	public void keyTyped(KeyEvent e) {}
	public void keyPressed(KeyEvent e) {}
	public void keyReleased(KeyEvent e) {
		if (e.getKeyChar() == ' ' || e.getKeyChar() == '\n') {
			tmp = tf.getText();
			System.out.println(tmp);
			tf.setText("");
			
			for(int i = 0; i < label.length - 1; i++) 
				label[i].setText(label[i+1].getText());
			
			if (list.isEmpty()) {
				label[3].setText("");
			}else {
				label[3].setText(list.get(0));
				list.remove(0);
			}
		}
	}
}
