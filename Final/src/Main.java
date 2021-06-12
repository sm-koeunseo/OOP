import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Main extends JPanel implements ActionListener{
	private StartFrame f;
	private Panel titlepanel,menupanel,textpanel;
	private JLabel titlelabel, menulabel, textlabel;
	private JButton btn_alphabet, btn_word, btn_line, btn_game, btn_setting;
	private ImageIcon btn_alpha, btn_wd, btn_long, btn_g, btn_settings;
	private JButton imgbtn, start, prof;
	private TextField tf_main = new TextField(300);
	private String tmpPanel = "";

	public Main(StartFrame f) {
		this.f = f;		
		setLayout(new BorderLayout());
		
		
		//Ÿ��Ʋ �г�
		titlepanel = new Panel();
		Color color = new Color(239, 239, 143);
        setBackground(color);
		JLabel titlelabel = new JLabel("������ �����԰� �Բ��ϴ� ��ü Ÿ�ڿ���");
		titlelabel.setFont(new Font("ELAND ���̽�", Font.BOLD, 20));
//		BufferedImage image;
//		File imageFile = new File("������.png");
//		image = ImageIO.read(imageFile);
		
		titlepanel.add(titlelabel);
		
		//�޴��г�
		menupanel = new Panel();		
		Color color2 = new Color(238, 203, 224);
		menupanel.setBackground(color2);
		
		GridLayout grid1 = new GridLayout(6,1);
		menupanel.setLayout(grid1);
		
		Label menulabel = new Label(" �Ʒ����� �޴��� �����ϼ���. ");
		menupanel.add(menulabel);
		
		btn_alphabet = new JButton();
		btn_alphabet.setBorderPainted(false);
		btn_alphabet.setContentAreaFilled(false);
		ImageIcon btn_alpha = new ImageIcon("Final/images/btn_alpha.png");
		btn_alphabet.setIcon(btn_alpha);
		menupanel.add(btn_alphabet);
		btn_alphabet.addActionListener(this);
		
		btn_word = new JButton();
		btn_word.setBorderPainted(false);
		btn_word.setContentAreaFilled(false);
		ImageIcon btn_wd = new ImageIcon("Final/images/btn_word.png");
		btn_word.setIcon(btn_wd);
		menupanel.add(btn_word);
		btn_word.addActionListener(this);
		
		btn_line = new JButton();
		btn_line.setBorderPainted(false);
		btn_line.setContentAreaFilled(false);
		ImageIcon btn_long = new ImageIcon("Final/images/btn_long.png");
		btn_line.setIcon(btn_long);
		menupanel.add(btn_line);
		btn_line.addActionListener(this);
		
		btn_game = new JButton();
		btn_game.setBorderPainted(false);
		btn_game.setContentAreaFilled(false);
		ImageIcon btn_g = new ImageIcon("Final/images/btn_game.png");
		btn_game.setIcon(btn_g);
		menupanel.add(btn_game);
		btn_game.addActionListener(this);
		
		btn_setting = new JButton();
		btn_setting.setBorderPainted(false);
		btn_setting.setContentAreaFilled(false);		
		ImageIcon btn_settings = new ImageIcon("Final/images/btn_settings.png");
		btn_setting.setIcon(btn_settings);
		menupanel.add(btn_setting);
		btn_setting.addActionListener(this);
		
		textpanel = new Panel();
		
		textpanel.setLayout(new BorderLayout());
		JLabel textlabel = new JLabel("    ** �޴� ���� **");
		prof = new JButton();
		prof.setBorderPainted(false);
		prof.setContentAreaFilled(false);	
		ImageIcon btn_prof = new ImageIcon("Final/images/prof.png");
		prof.setIcon(btn_prof);
		prof.addActionListener(this);
		
		start = new JButton();
		start.setBorderPainted(false);
		start.setContentAreaFilled(false);		
		ImageIcon btn_start = new ImageIcon("Final/images/btn_start.png");
		start.setIcon(btn_start);
		start.addActionListener(this);
		
		textpanel.add("North",prof);
		textpanel.add("South",start);
		textpanel.add("Center",textlabel);
		textpanel.add("Center",tf_main);
		
		add("North", titlepanel);
		add("West", menupanel);
		add("Center", textpanel);
		
	}

	public void actionPerformed(ActionEvent e) {
		tf_main.setFont(new Font("serif", Font.BOLD, 15));
		if(e.getSource() == btn_alphabet) {
			tmpPanel = "Alphabet";
			tf_main.setText("    �ڸ�����: �� ���ھ� �ڸ��� ����������!");
		} else if(e.getSource() == btn_word) {
			tmpPanel = "Word";
			tf_main.setText("    �ܾ��: �ڹ� ���α׷��ֿ� �ʿ��� ���� �ܾ���� �н��մϴ�!");
		}else if(e.getSource() == btn_line) {
			tmpPanel = "Line";
			tf_main.setText("    ��ۿ���: ������ ���α׷����� �ϴ� ��ó�� �ٱ۷� ������!");
		}else if(e.getSource() == btn_game) {
			tmpPanel = "Game";
			tf_main.setText("    ����: ������ �������� �ܾ���� �����ּ���!");
		}else if(e.getSource() == btn_setting) {
			f.changePanel("Setting");
		}else if (e.getSource() == start) {
			if (tmpPanel.equals(""))
				System.out.println("�޴��� �����ϼ���.");
			else {
				f.changePanel(tmpPanel);
			}
		}
	}
}