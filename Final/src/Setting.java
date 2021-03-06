import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.border.Border;


public class Setting extends JPanel implements ActionListener{
	private Main f;
	private JPanel userP, userI, score1, score2, score3, score4, score5, score6, score7, score8;
	private JButton btn_main, btn_title, btn_change;
	private TextField userNameT;
	private String userName;
	private JLabel userNameL, label1, label2;
	private IOName in;
	private IOAlph ia;
	private IOWord iw;
	private IOCode ic;
	private IOGame ig;
	private Font font;
	private Border border;
	private boolean change = false;
	String columnName[] = {"번호", "날짜", "점수"};
	String wordScore1[][], wordScore2[][];
	JTable table1, table2;
	JScrollPane sp1, sp2, sp3, sp4, sp5, sp6, sp7, sp8;
	JRadioButton check1, check2, check3, check4;
	ButtonGroup cbg;
	
	public void setFocus() {
		sp1.hide();
		sp2.hide();		
		sp3.hide();
		sp4.hide();
		sp5.hide();
		sp6.hide();
		sp7.hide();
		sp8.hide();

		wordScore1 = ia.getScore1();
		wordScore2 = ia.getScore2();
		table1 = new JTable(wordScore1, columnName);
		table2 = new JTable(wordScore2, columnName);
		sp1 = new JScrollPane(table1);
		sp2 = new JScrollPane(table2);
		sp1.setPreferredSize(new Dimension(350, 210));
		sp2.setPreferredSize(new Dimension(350, 210));
		score1.add(sp1);
		score2.add(sp2);

		wordScore1 = iw.getScore1();
		wordScore2 = iw.getScore2();
		table1 = new JTable(wordScore1, columnName);
		table2 = new JTable(wordScore2, columnName);
		sp3 = new JScrollPane(table1);
		sp4 = new JScrollPane(table2);
		sp3.setPreferredSize(new Dimension(350, 210));
		sp4.setPreferredSize(new Dimension(350, 210));
		score3.add(sp3);
		score4.add(sp4);

		wordScore1 = ic.getScore1();
		wordScore2 = ic.getScore2();
		table1 = new JTable(wordScore1, columnName);
		table2 = new JTable(wordScore2, columnName);
		sp5 = new JScrollPane(table1);
		sp6 = new JScrollPane(table2);
		sp5.setPreferredSize(new Dimension(350, 210));
		sp6.setPreferredSize(new Dimension(350, 210));
		score5.add(sp5);
		score6.add(sp6);

		wordScore1 = ig.getScore1();
		wordScore2 = ig.getScore2();
		table1 = new JTable(wordScore1, columnName);
		table2 = new JTable(wordScore2, columnName);
		sp7 = new JScrollPane(table1);
		sp8 = new JScrollPane(table2);
		sp7.setPreferredSize(new Dimension(350, 210));
		sp8.setPreferredSize(new Dimension(350, 210));
		score7.add(sp7);
		score8.add(sp8);
		
		check1.setSelected(true);
		score3.hide();
		score4.hide();
		score5.hide();
		score6.hide();
		score7.hide();
		score8.hide();
		score1.show();
		score2.show();
	}

	public Setting(Main f) {
		// panel settings
		this.f = f;
		setLayout(null);
        setBackground(new Color(239, 239, 143));

        // basic settings
		font = new Font(("ELAND 나이스 Medium"), Font.PLAIN, 20);
		border = BorderFactory.createLineBorder(Color.BLUE, 3);
        
        // title
 		btn_title = new JButton(new ImageIcon("Final/images/btn_settings.png"));
 		btn_title.setBounds(280, 10, 220, 60);
 		btn_title.setBorderPainted(false);
 		btn_title.setContentAreaFilled(false);
 		btn_title.setFocusPainted(false);
 		add(btn_title);
 		
 		// home button
		btn_main = new JButton(new ImageIcon("Final/images/home.png"));
		btn_main.setBorderPainted(false);
		btn_main.setContentAreaFilled(false);
		btn_main.setFocusPainted(false);
		btn_main.setBounds(700, 10, 60, 60);
		add(btn_main);
		btn_main.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				f.changePanel("Main");
			}
		});
        
        // user
 		btn_title = new JButton(new ImageIcon("Final/images/game_student.png"));
 		btn_title.setBounds(20, 90, 180, 190);
 		btn_title.setBorderPainted(false);
 		btn_title.setContentAreaFilled(false);
 		btn_title.setFocusPainted(false);
 		add(btn_title);
 		
 		// user name
 		in = new IOName();
 		userName = in.getName();
 		userNameL = new JLabel(userName);
 		userNameL.setHorizontalAlignment(JLabel.CENTER);
 		userNameL.setFont(font);
 		userNameL.setBorder(border);
 		userNameL.setBounds(220, 100, 180, 50);
 		add(userNameL);
 		
 		userNameT = new TextField(15);
 		userNameT.setText(userName);
 		userNameT.setFont(font);
 		userNameT.setBounds(220, 220, 180, 40);
 		userNameT.setVisible(false);
 		add(userNameT);
 		
 		btn_change = new JButton("이름바꾸기");
 		btn_change.setFont(font);
 		btn_change.setBounds(220, 160, 180, 50);
 		add(btn_change);
 		btn_change.addActionListener(this);
 		
 		// radio
 		check1 = new JRadioButton("자리연습", true);
		check1.setFont(font);
		check1.setBackground(Color.white);
		check1.setBounds(500, 100, 100, 50);
		check1.addActionListener(this);
		add(check1);
		
		check2 = new JRadioButton("단어연습", false);
		check2.setFont(font);
		check2.setBackground(Color.white);
		check2.setBounds(600, 100, 100, 50);
		check2.addActionListener(this);
		add(check2);
		
		check3 = new JRadioButton("긴글연습", false);
		check3.setFont(font);
		check3.setBackground(Color.white);
		check3.setBounds(500, 200, 100, 50);
		check3.addActionListener(this);
		add(check3);
		
		check4 = new JRadioButton("게임", false);
		check4.setFont(font);
		check4.setBackground(Color.white);
		check4.setBounds(600, 200, 100, 50);
		check4.addActionListener(this);
		add(check4);
		
		cbg = new ButtonGroup();
		cbg.add(check1);
		cbg.add(check2);
		cbg.add(check3);
		cbg.add(check4);
 		
 		// user picture pannel
 		userP = new JPanel();
 		userP.setBackground(Color.white);
 		userP.setBounds(20, 90, 180, 190);
		add(userP);
 		
 		// user info pannel
		userI = new JPanel();
		userI.setBackground(Color.white);
		userI.setBounds(220, 90, 545, 190);
		add(userI);
 		
 		// score pannel
		score1 = new JPanel();
		score1.setBackground(Color.white);
		score1.setBounds(20, 300, 360, 245);
		add(score1);
		score2 = new JPanel();
		score2.setBackground(Color.white);
		score2.setBounds(405, 300, 360, 245);
		add(score2);
		label1 = new JLabel("최신순");
		label1.setFont(font);
		score1.add(label1);
		label2 = new JLabel("득점순");
		label2.setFont(font);
		score2.add(label2);
		ia = new IOAlph();
		wordScore1 = ia.getScore1();
		wordScore2 = ia.getScore2();
		table1 = new JTable(wordScore1, columnName);
		table2 = new JTable(wordScore2, columnName);
		sp1 = new JScrollPane(table1);
		sp2 = new JScrollPane(table2);
		
		score3 = new JPanel();
		score3.setBackground(Color.white);
		score3.setBounds(20, 300, 360, 245);
		add(score3);
		score4 = new JPanel();
		score4.setBackground(Color.white);
		score4.setBounds(405, 300, 360, 245);
		add(score4);
		label1 = new JLabel("최신순");
		label1.setFont(font);
		score3.add(label1);
		label2 = new JLabel("득점순");
		label2.setFont(font);
		score4.add(label2);
		iw = new IOWord();
		wordScore1 = iw.getScore1();
		wordScore2 = iw.getScore2();
		table1 = new JTable(wordScore1, columnName);
		table2 = new JTable(wordScore2, columnName);
		sp3 = new JScrollPane(table1);
		sp4 = new JScrollPane(table2);
		
		score5 = new JPanel();
		score5.setBackground(Color.white);
		score5.setBounds(20, 300, 360, 245);
		add(score5);
		score6 = new JPanel();
		score6.setBackground(Color.white);
		score6.setBounds(405, 300, 360, 245);
		add(score6);
		label1 = new JLabel("최신순");
		label1.setFont(font);
		score5.add(label1);
		label2 = new JLabel("득점순");
		label2.setFont(font);
		score6.add(label2);
		ic = new IOCode();
		wordScore1 = ic.getScore1();
		wordScore2 = ic.getScore2();
		table1 = new JTable(wordScore1, columnName);
		table2 = new JTable(wordScore2, columnName);
		sp5 = new JScrollPane(table1);
		sp6 = new JScrollPane(table2);
		
		score7 = new JPanel();
		score7.setBackground(Color.white);
		score7.setBounds(20, 300, 360, 245);
		add(score7);
		score8 = new JPanel();
		score8.setBackground(Color.white);
		score8.setBounds(405, 300, 360, 245);
		add(score8);
		label1 = new JLabel("최신순");
		label1.setFont(font);
		score7.add(label1);
		label2 = new JLabel("득점순");
		label2.setFont(font);
		score8.add(label2);
		ig = new IOGame();
		wordScore1 = ig.getScore1();
		wordScore2 = ig.getScore2();
		table1 = new JTable(wordScore1, columnName);
		table2 = new JTable(wordScore2, columnName);
		sp7 = new JScrollPane(table1);
		sp8 = new JScrollPane(table2);
	}
	
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == check1) {
			score3.hide();
			score4.hide();
			score5.hide();
			score6.hide();
			score7.hide();
			score8.hide();
			
			score1.show();
			score2.show();
			
		}else if (e.getSource() == check2) {
			score1.hide();
			score2.hide();
			score5.hide();
			score6.hide();
			score7.hide();
			score8.hide();
			
			score3.show();
			score4.show();
		}else if (e.getSource() == check3) {
			score1.hide();
			score2.hide();
			score3.hide();
			score4.hide();
			score7.hide();
			score8.hide();
			
			score5.show();
			score6.show();
		}else if (e.getSource() == check4) {
			score1.hide();
			score2.hide();
			score3.hide();
			score4.hide();
			score5.hide();
			score6.hide();
			
			score7.show();
			score8.show();
		}else if (e.getSource() == btn_change) {
			if(change) {
				if (userNameT.getText().equals("")) {
					JOptionPane.showMessageDialog(this, "이름을 입력해주세요!", "Not Access", JOptionPane.ERROR_MESSAGE);
				}else if(userNameT.getText().equals(userName)){
					JOptionPane.showMessageDialog(this, "변경하려는 이름을 입력해주세요!", "Not Access", JOptionPane.ERROR_MESSAGE);
				}else {
					userName = in.setName(userNameT.getText());
					userNameL.setText(userName);
					userNameT.setText(userName);
					userNameT.setVisible(false);
					btn_change.setText("이름바꾸기");
					JOptionPane.showMessageDialog(this, "변경되었습니다!", "Access", JOptionPane.INFORMATION_MESSAGE);
					change = false;
				}
			}else {
				userNameT.setVisible(true);
				change = true;
				btn_change.setText("저장하기");
			}
		}
	}
}
