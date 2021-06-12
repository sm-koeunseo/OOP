import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Main extends JPanel implements ActionListener{
	private StartFrame f;
	private Panel titlepanel,menupanel,textpanel,startpanel;
	private JLabel titlelabel, menulabel, textlabel;
	private JButton btn_alphabet, btn_word, btn_code, btn_game, btn_setting;
	private ImageIcon btn_alpha, btn_wd, btn_long, btn_g, btn_settings, btn_start, btn_exit, btn_prof;
	private JButton start, prof, exit;
	private JTextField tf_main = new JTextField(300);
	private String tmpPanel = "";
	private Font font, font2, font3;

	public Main(StartFrame f) {
		this.f = f;		
		setLayout(new BorderLayout());
		
		font = new Font(("ELAND 나이스 Medium"), Font.PLAIN, 30);
		font2 = new Font(("ELAND 나이스 Medium"), Font.PLAIN, 15);
		
		//타이틀 패널
		titlepanel = new Panel();
		Color color = new Color(239, 239, 143);
        setBackground(color);
		titlelabel = new JLabel("윤용익 교수님과 함께하는 \"객체 타자연습\"");
		
		titlelabel.setFont(font);
		titlepanel.add(titlelabel);
		//메뉴패널
		menupanel = new Panel();		
		Color color2 = new Color(238, 203, 224);
		menupanel.setBackground(color2);
		
		GridLayout grid1 = new GridLayout(6,1);
		menupanel.setLayout(grid1);
		
		menulabel = new JLabel(" **    아래에서 메뉴를 선택하세요.   **");
		
		menulabel.setFont(font2);
		menupanel.add(menulabel);
		
		btn_alphabet = new JButton();
		btn_alphabet.setBorderPainted(false);
		btn_alphabet.setContentAreaFilled(false);
		btn_alpha = new ImageIcon("Final/images/btn_alpha.png");
			
		btn_alphabet.setIcon(btn_alpha);
		menupanel.add(btn_alphabet);
		btn_alphabet.addActionListener(this);
		
		btn_word = new JButton();
		btn_word.setBorderPainted(false);
		btn_word.setContentAreaFilled(false);
		btn_wd = new ImageIcon("Final/images/btn_word.png");
		btn_word.setIcon(btn_wd);
		menupanel.add(btn_word);
		btn_word.addActionListener(this);
		
		btn_code = new JButton();
		btn_code.setBorderPainted(false);
		btn_code.setContentAreaFilled(false);
		ImageIcon btn_long = new ImageIcon("Final/images/btn_long.png");
		btn_code.setIcon(btn_long);
		menupanel.add(btn_code);
		btn_code.addActionListener(this);
		
		btn_game = new JButton();
		btn_game.setBorderPainted(false);
		btn_game.setContentAreaFilled(false);
		btn_g = new ImageIcon("Final/images/btn_game.png");
		btn_game.setIcon(btn_g);
		menupanel.add(btn_game);
		btn_game.addActionListener(this);
		
		btn_setting = new JButton();
		btn_setting.setBorderPainted(false);
		btn_setting.setContentAreaFilled(false);		
		btn_settings = new ImageIcon("Final/images/btn_settings.png");
		btn_setting.setIcon(btn_settings);
		menupanel.add(btn_setting);
		btn_setting.addActionListener(this);
		
		textpanel = new Panel();
		textpanel.setLayout(new BorderLayout());
		textlabel = new JLabel("    ** 메뉴 설명 **");
		prof = new JButton();
		prof.setBorderPainted(false);
		prof.setContentAreaFilled(false);	
		btn_prof = new ImageIcon("Final/images/prof.png");
		prof.setIcon(btn_prof);
		prof.addActionListener(this);
		
		startpanel = new Panel();
		start = new JButton();
		start.setBorderPainted(false);
		start.setContentAreaFilled(false);		
		btn_start = new ImageIcon("Final/images/btn_start.png");
		start.setIcon(btn_start);
		start.addActionListener(this);
		startpanel.add(start);
		
		exit = new JButton();
		exit.setBorderPainted(false);
		exit.setContentAreaFilled(false);		
		btn_exit = new ImageIcon("Final/images/btn_exit.png");
		exit.setIcon(btn_exit);
		exit.addActionListener(this);
		startpanel.add(exit);
		
		textpanel.add("North",prof);
		textpanel.add("South",startpanel);;
		textpanel.add("Center",textlabel);
		textpanel.add("Center",tf_main);
		
		add("North", titlepanel);
		add("West", menupanel);
		add("Center", textpanel);
		
	}

	public void actionPerformed(ActionEvent e) {
		font3 = new Font(("ELAND 나이스 Medium"), Font.PLAIN, 20);
		tf_main.setFont(font3);
		if(e.getSource() == btn_alphabet) {
			tmpPanel = "Alphabet";
			tf_main.setText("    자리연습: 한 글자씩 자리를 익혀보세요!");
		} else if(e.getSource() == btn_word) {
			tmpPanel = "Word";
			tf_main.setText("    단어연습: 자바 프로그래밍에 필요한 여러 단어들을 학습합니다!");
		}else if(e.getSource() == btn_code) {
			tmpPanel = "Code";
			tf_main.setText("    긴글연습: 실제로 프로그래밍을 하는 것처럼 줄글로 마스터!");
		}else if(e.getSource() == btn_game) {
			tmpPanel = "Game";
			tf_main.setText("    게임: 위에서 떨어지는 단어들을 없애주세요!");
		}else if(e.getSource() == btn_setting) {
			f.changePanel("Setting");
		}else if (e.getSource() == start) {
			if (tmpPanel.equals(""))
				System.out.println("메뉴를 선택하세요.");
			else {
				f.changePanel(tmpPanel);
			}
		}else if (e.getSource() == exit) {
			System.exit(0);
		}
	}
}
