package taja.main;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Main extends JPanel implements ActionListener{
	private StartFrame f;
	private Panel menupanel;
	private Panel textpanel;
	private Label menulabel, textlabel;
	private Button btn_alphabet, btn_word, btn_line, btn_game, btn_setting;
	private TextField tf_main = new TextField(500);

	public Main(StartFrame f) {
		this.f = f;		
		setLayout(new BorderLayout());
		menupanel = new Panel();		
		
		GridLayout grid1 = new GridLayout(6,1);
		menupanel.setLayout(grid1);
		
		Label menulabel = new Label(" 아래에서 메뉴를 선택하세요. ");
		menupanel.add(menulabel);
		
		btn_alphabet = new Button("낱말연습");
		menupanel.add(btn_alphabet);
		btn_alphabet.addActionListener(this);
		
		btn_word = new Button("단어연습");
		btn_word.setBounds(20, 20, 20, 20);
		menupanel.add(btn_word);
		btn_word.addActionListener(this);
		
		btn_line = new Button("긴글연습");
		menupanel.add(btn_line);
		btn_line.addActionListener(this);
		
		btn_game = new Button("게임");
		menupanel.add(btn_game);
		btn_game.addActionListener(this);
		
		btn_setting = new Button("환경설정");
		menupanel.add(btn_setting);
		btn_setting.addActionListener(this);
		
		textpanel = new Panel();
		GridLayout grid2 = new GridLayout(2,1);
		textpanel.setLayout(grid2);
		
		Label textlabel = new Label(" 아래에서 메뉴를 선택하세요. ");
		
		textpanel.add(tf_main);
		
		add("West", menupanel);
		add("East", textpanel);
		
	}

	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == btn_alphabet)
			f.changePanel("Alphabet");
		else if(e.getSource() == btn_word)
			f.changePanel("Word");
		else if(e.getSource() == btn_line)
			f.changePanel("Line");
		else if(e.getSource() == btn_game)
			f.changePanel("Game");
		else if(e.getSource() == btn_setting)
			f.changePanel("Setting");
	}

}
