import java.awt.*;
import java.awt.event.*;
import java.awt.geom.RoundRectangle2D;
import java.util.*;
import javax.swing.*;
import javax.swing.border.*;

public class Word extends JPanel{
	private StartFrame f;
	private Word p;
	private JPanel main, title, user, professor;
	private JButton btn_main, btn_title, btn_prof, key;
	private JButton[] circle;
	private JTextField tf;
	private IOWord iw;
	private IOName in;
	private String[] words;
	private int count = 2, score = 0;
	private JLabel[] label = new JLabel[3];
	private JLabel name, ratingG, ratingB, userInput;
	String tmp = "";
	private Font font;
	private Border border;
	
	public void setFocus() {
		userInput.setText("");
		tf.setText("");
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
		btn_title = new JButton(new ImageIcon("Final/images/btn_word.png"));
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
		
		// word
		iw = new IOWord();
		words = iw.getWords();
		
		// label
		in = new IOName();
		name = new JLabel(in.getName());
		name.setFont(font);
		name.setHorizontalAlignment(JLabel.CENTER);
		name.setBounds(580, 90, 180, 50);
		add(name);
		
		// prof Good
		ratingG = new JLabel("잘했어요~");
		ratingG.setBounds(580, 450, 130, 30);
		ratingG.setFont(new Font(("ELAND 나이스 Medium"), Font.PLAIN, 18));
		//ratingG.setBorder(border);
		ratingG.setVisible(false);
		add(ratingG);
		
		// prof Bad
		ratingB = new JLabel("분발해요!");
		ratingB.setBounds(690, 450, 130, 30);
		ratingB.setFont(new Font(("ELAND 나이스 Medium"), Font.PLAIN, 18));
		//ratingB.setBorder(border);
		ratingB.setVisible(false);
		add(ratingB);
		
		// btn_prof
		btn_prof = new JButton(new ImageIcon("Final/images/prof.png"));
		btn_prof.setBounds(580, 350, 180, 190);
		btn_prof.setBorderPainted(false);
		btn_prof.setContentAreaFilled(false);
		btn_prof.setFocusPainted(false);
		add(btn_prof);
		
		label[0] = new JLabel("");
		label[0].setFont(font);
		label[0].setHorizontalAlignment(JLabel.CENTER);
		label[0].setBounds(20, 140, 140, 50);
		add(label[0]);
		
		circle = new JButton[26];
		int x = 80, y = 345;
		for(int i = 0; i < 26; i++) {
			circle[i] = new JButton(new ImageIcon("Final/images/circle.png"));
			circle[i].setBounds(x, y, 10, 10);
			circle[i].setBorderPainted(false);
			circle[i].setContentAreaFilled(false);
			circle[i].setFocusPainted(false);
			circle[i].setVisible(false);
			add(circle[i]);
			
			if (x == 404) {
				x = 90;
				y = 380;
			}else if(x == 378) {
				x = 100;
				y = 415;
			}else
				x += 36;
		}
		
		label[1] = new JLabel(words[0]);
		label[1].setFont(font);
		label[1].setHorizontalAlignment(JLabel.CENTER);
		label[1].setBounds(160, 140, 260, 50);
		label[1].setBorder(border);
		add(label[1]);
		
		for (int i = 0; i < words[0].length(); i++) {
			switch(words[0].charAt(i)) {
			case 'q': case 'Q': circle[0].setVisible(true); break;
			case 'w': case 'W': circle[1].setVisible(true); break;
			case 'e': case 'E': circle[2].setVisible(true); break;
			case 'r': case 'R': circle[3].setVisible(true); break;
			case 't': case 'T': circle[4].setVisible(true); break;
			case 'y': case 'Y': circle[5].setVisible(true); break;
			case 'u': case 'U': circle[6].setVisible(true); break;
			case 'i': case 'I': circle[7].setVisible(true); break;
			case 'o': case 'O': circle[8].setVisible(true); break;
			case 'p': case 'P': circle[9].setVisible(true); break;
			case 'a': case 'A': circle[10].setVisible(true); break;
			case 's': case 'S': circle[11].setVisible(true); break;
			case 'd': case 'D': circle[12].setVisible(true); break;
			case 'f': case 'F': circle[13].setVisible(true); break;
			case 'g': case 'G': circle[14].setVisible(true); break;
			case 'h': case 'H': circle[15].setVisible(true); break;
			case 'j': case 'J': circle[16].setVisible(true); break;
			case 'k': case 'K': circle[17].setVisible(true); break;
			case 'l': case 'L': circle[18].setVisible(true); break;
			case 'z': case 'Z': circle[19].setVisible(true); break;
			case 'x': case 'X': circle[20].setVisible(true); break;
			case 'c': case 'C': circle[21].setVisible(true); break;
			case 'v': case 'V': circle[22].setVisible(true); break;
			case 'b': case 'B': circle[23].setVisible(true); break;
			case 'n': case 'N': circle[24].setVisible(true); break;
			case 'm': case 'M': circle[25].setVisible(true); break;
			}
		}
		
		label[2] = new JLabel(words[1]);
		label[2].setFont(font);
		label[2].setHorizontalAlignment(JLabel.CENTER);
		label[2].setBounds(420, 140, 140, 50);
		add(label[2]);
		
		// keyboard
		key = new JButton(new ImageIcon("Final/images/key.png"));
		key.setBounds(20, 240, 540, 300);
		key.setBorderPainted(false);
		key.setContentAreaFilled(false);
		key.setFocusPainted(false);
		add(key);
		
		// userInput
		userInput = new JLabel("");
		userInput.setSize(100, 30);
		userInput.setBounds(120, 230, 340, 50);
		userInput.setHorizontalAlignment(JLabel.CENTER);
		userInput.setFont(font);
		userInput.setBorder(border);
		add(userInput);
		
		// input field
		tf = new JTextField();
		tf.setBounds(-60, 60, 40, 50);
		tf.setFocusTraversalKeysEnabled(false);
		add(tf);
		tf.addKeyListener(new KeyListener() {
			public void keyTyped(KeyEvent e) {}
			public void keyPressed(KeyEvent e) {}
			public void keyReleased(KeyEvent e) {
				userInput.setText(tf.getText());
				if (e.getKeyChar() == ' ' || e.getKeyChar() == '\n') {
					userInput.setText("");
					tmp = tf.getText();
					tf.setText("");
					if(tmp.equals(label[1].getText())) {
						score++;
						new Prof(p, ratingG).start();
					}else {
						new Prof(p, ratingB).start();
					}
					
					label[0].setText(label[1].getText());
					label[1].setText(label[2].getText());
					for (int i = 0; i < 26; i++)
						circle[i].setVisible(false);
					for (int i = 0; i < words[count-1].length(); i++) {
						switch(words[count-1].charAt(i)) {
						case 'q': case 'Q': circle[0].setVisible(true); break;
						case 'w': case 'W': circle[1].setVisible(true); break;
						case 'e': case 'E': circle[2].setVisible(true); break;
						case 'r': case 'R': circle[3].setVisible(true); break;
						case 't': case 'T': circle[4].setVisible(true); break;
						case 'y': case 'Y': circle[5].setVisible(true); break;
						case 'u': case 'U': circle[6].setVisible(true); break;
						case 'i': case 'I': circle[7].setVisible(true); break;
						case 'o': case 'O': circle[8].setVisible(true); break;
						case 'p': case 'P': circle[9].setVisible(true); break;
						case 'a': case 'A': circle[10].setVisible(true); break;
						case 's': case 'S': circle[11].setVisible(true); break;
						case 'd': case 'D': circle[12].setVisible(true); break;
						case 'f': case 'F': circle[13].setVisible(true); break;
						case 'g': case 'G': circle[14].setVisible(true); break;
						case 'h': case 'H': circle[15].setVisible(true); break;
						case 'j': case 'J': circle[16].setVisible(true); break;
						case 'k': case 'K': circle[17].setVisible(true); break;
						case 'l': case 'L': circle[18].setVisible(true); break;
						case 'z': case 'Z': circle[19].setVisible(true); break;
						case 'x': case 'X': circle[20].setVisible(true); break;
						case 'c': case 'C': circle[21].setVisible(true); break;
						case 'v': case 'V': circle[22].setVisible(true); break;
						case 'b': case 'B': circle[23].setVisible(true); break;
						case 'n': case 'N': circle[24].setVisible(true); break;
						case 'm': case 'M': circle[25].setVisible(true); break;
						}
					}
					if (count < words.length) {
						label[2].setText(words[count++]);
					}else
						label[2].setText("");
					
					if (label[1].getText().equals("")) {
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