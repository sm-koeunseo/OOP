package taja.word;
import taja.main.*;

import java.awt.*;
import java.awt.event.*;
import java.awt.geom.RoundRectangle2D;
import java.util.*;
import javax.swing.*;
import javax.swing.border.*;

public class Word extends JPanel{
	private StartFrame f;
	private JPanel main, title, user, professor;
	private JButton btn_main, btn_title, btn_bg;
	private JTextField tf;
	private ArrayList<String> list = new ArrayList<>(Arrays.asList("ComponentListener", "EventListener", "word", "oop", "time", "hi"));
	private JLabel[] label = new JLabel[4];
	//private JLabel[] label = new JLabel[3];
	String tmp = "";
	
	private Font font;
	private Border border;
	
	public Word(StartFrame f) {
		// panel settings
		this.f = f;
		setLayout(null);
        setBackground(new Color(239, 239, 143));

        // basic settings
		font = new Font(("ELAND 나이스 Medium"), Font.PLAIN, 20);
		border = BorderFactory.createLineBorder(Color.BLUE, 3);
		
		// title
		btn_title = new JButton(new ImageIcon("./images/btn_word.png"));
		btn_title.setBounds(280, 10, 220, 60);
		btn_title.setBorderPainted(false);
		btn_title.setContentAreaFilled(false);
		btn_title.setFocusPainted(false);
		add(btn_title);
		
        // home button
		btn_main = new JButton("돌아가기");
		btn_main.setBounds(700, 10, 100, 20);
		add(btn_main);
		btn_main.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				f.changePanel("Main");
			}
		});
		
		// word label
		for (int i = 0; i < label.length; i++) {
			if (i == 0) {
				label[0] = new JLabel("");
			}else {
				label[i] = new JLabel(list.get(0));
				list.remove(0);
			}
			label[i].setFont(font);
			label[i].setHorizontalAlignment(JLabel.CENTER);
			label[i].setBounds(150 * (i+1), 200, 100, 50);
			add(label[i], new Integer(1));
		}
		label[1].setBorder(border);
		
		// input field
		tf = f.getWord();
		tf.setBounds(10, 300, 400, 30);
		tf.setFocusTraversalKeysEnabled(false);
		add(tf, 1);
		tf.addKeyListener(new KeyListener() {
			public void keyTyped(KeyEvent e) {}
			public void keyPressed(KeyEvent e) {}
			public void keyReleased(KeyEvent e) {
				if (e.getKeyChar() == ' ' || e.getKeyChar() == '\n') {
					tmp = tf.getText();
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
		});

		// panel
		main = new JPanel();
		main.setBackground(Color.white);
		main.setBounds(20, 90, 540, 450);
		add(main);
		
		title = new JPanel();
		title.setBackground(Color.white);
		title.setBounds(580, 90, 180, 50);
		add(title);
		
		user = new JPanel();
		user.setBackground(Color.white);
		user.setBounds(580, 150, 180, 190);
		add(user);
		
		professor = new JPanel();
		professor.setBackground(Color.white);
		professor.setBounds(580, 350, 180, 190);
		add(professor);
	}
}