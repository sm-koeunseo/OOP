package taja.word;
import taja.main.*;

import java.awt.*;
import java.awt.event.*;
import java.awt.geom.RoundRectangle2D;
import java.util.*;
import javax.swing.*;
import javax.swing.border.*;

import IO.IOWord;

public class Word extends JPanel{
	private StartFrame f;
	private JPanel main, title, user, professor;
	private JButton btn_main, btn_title, btn_bg;
	private JTextField tf;
	private IOWord iw;
	private String[] words;
	private int count = 2, score = 0;
	private JLabel[] label = new JLabel[3];
	String tmp = "";
	private Font font;
	private Border border;
	
	public void setFocus() {
		tf.requestFocus();
		words = iw.getWords();
		count = 2; score = 0;
		label[0].setText("");
		label[1].setText(words[0]);
		label[2].setText(words[1]);
	}
	
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
		
		iw = new IOWord();
		words = iw.getWords();
		System.out.println(iw.getName());
		
		label[0] = new JLabel("");
		label[0].setFont(font);
		label[0].setHorizontalAlignment(JLabel.CENTER);
		label[0].setBounds(20, 200, 140, 50);
		add(label[0]);
		
		label[1] = new JLabel(words[0]);
		label[1].setFont(font);
		label[1].setHorizontalAlignment(JLabel.CENTER);
		label[1].setBounds(160, 200, 260, 50);
		label[1].setBorder(border);
		add(label[1]);
		
		label[2] = new JLabel(words[1]);
		label[2].setFont(font);
		label[2].setHorizontalAlignment(JLabel.CENTER);
		label[2].setBounds(420, 200, 140, 50);
		add(label[2]);
		
		// input field
		tf = f.getWord();
		tf.setBounds(10, 300, 400, 30);
		tf.setFocusTraversalKeysEnabled(false);
		add(tf);
		tf.addKeyListener(new KeyListener() {
			public void keyTyped(KeyEvent e) {}
			public void keyPressed(KeyEvent e) {}
			public void keyReleased(KeyEvent e) {
				if (e.getKeyChar() == ' ' || e.getKeyChar() == '\n') {
					tmp = tf.getText();
					tf.setText("");

					if(tmp.equals(label[1].getText())) {
						score++;
						System.out.println("T");
						// 정답 리액션
					}else {
						// 오답 리액션
					}
					
					label[0].setText(label[1].getText());
					label[1].setText(label[2].getText());
					if (count < words.length)
						label[2].setText(words[count++]);
					else
						label[2].setText("");
					
					if (label[1].getText().equals("")) {
						//System.out.println("끝! " + score + "/" + words.length);
						iw.setScore(score);
						btn_main.doClick();
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