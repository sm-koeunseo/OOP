package taja.main;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Main extends JPanel implements ActionListener{
	private StartFrame f;
	private Panel titlepanel,menupanel,textpanel;
	private JLabel titlelabel, menulabel, textlabel;
	private Button btn_alphabet, btn_word, btn_line, btn_game, btn_setting;
	private ImageIcon icon;
	private JButton imgbtn, start;
	private TextField tf_main = new TextField(500);
	private String tmpPanel = "";

	public Main(StartFrame f) {
		this.f = f;		
		setLayout(new BorderLayout());
		titlepanel = new Panel();
		
        Color color = new Color(239, 239, 143);
        setBackground(color);
		
		JLabel titlelabel = new JLabel("윤용익 교수님과 함께하는 객체 타자연습");
//		BufferedImage image;
//		File imageFile = new File("교수님.png");
//		image = ImageIO.read(imageFile);
		
		titlepanel.add(titlelabel);
		
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
		
		textpanel.setLayout(new BorderLayout());
		JLabel textlabel = new JLabel("    ** 메뉴 설명 **");
		start = new JButton("시작");
		start.addActionListener(this);
		textpanel.add("South",start);
		textpanel.add("North",textlabel);
		textpanel.add("Center",tf_main);
		
		//JLabel textlabel = new JLabel("    ** 메뉴 설명 **");
//		JLabel alphabetlabel = new JLabel("    낱말연습: 한 글자씩 자리를 익혀보세요!");
//		JLabel wordlabel = new JLabel("    단어연습: 자바 프로그래밍에 필요한 여러 단어들을 학습합니다!");
//		JLabel linelabel = new JLabel("    긴글연습: 실제로 프로그래밍을 하는 것처럼 줄글로 마스터!");
//		JLabel gamelabel = new JLabel("    게임: 위에서 떨어지는 단어들을 없애주세요!");
		
		//textpanel.add("East",textlabel);
		
		add("North", titlepanel);
		add("West", menupanel);
		add("Center", textpanel);
		
	}

	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == btn_alphabet) {
			tmpPanel = "Alphabet";
			tf_main.setText("Alphabet");
		} else if(e.getSource() == btn_word) {
			tmpPanel = "Word";
			tf_main.setText("Word");
		}else if(e.getSource() == btn_line) {
			tmpPanel = "Line";
			tf_main.setText("Line");
		}else if(e.getSource() == btn_game) {
			tmpPanel = "Game";
			tf_main.setText("Game");
		}else if(e.getSource() == btn_setting) {
			f.changePanel("Setting");
		}else if (e.getSource() == start) {
			if (tmpPanel.equals(""))
				System.out.println("메뉴 선택");
			else {
				f.changePanel(tmpPanel);
			}
		}
	}
}
