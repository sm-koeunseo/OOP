import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.border.Border;


public class Setting extends JPanel implements ActionListener{
	private StartFrame f;
	private JPanel userP, userI, score1, score2;
	private JButton btn_main, btn_title, btn_change;
	private TextField userNameT;
	private String userName;
	private JLabel userNameL, label1, label2;
	private IOName in;
	private IOWord io;
	private Font font;
	private Border border;
	private boolean change = false;
	String columnName[] = {"번호", "날짜", "점수"};
	String wordScore1[][], wordScore2[][];
	JTable table1, table2;
	JScrollPane sp1, sp2;
	
	public void setFocus() {
		sp1.hide();
		sp2.hide();
		wordScore1 = io.getScore1();
		wordScore2 = io.getScore2();
		wordScore1 = io.getScore1();
		wordScore2 = io.getScore2();
		table1 = new JTable(wordScore1, columnName);
		table2 = new JTable(wordScore2, columnName);
		sp1 = new JScrollPane(table1);
		sp2 = new JScrollPane(table2);
		sp1.setPreferredSize(new Dimension(350, 210));
		sp2.setPreferredSize(new Dimension(350, 210));
		score1.add(sp1);
		score2.add(sp2);
	}

	public Setting(StartFrame f) {
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
        
        // user
 		btn_title = new JButton(new ImageIcon("./images/prof.png"));
 		btn_title.setBounds(20, 90, 180, 190);
 		btn_title.setBorderPainted(false);
 		btn_title.setContentAreaFilled(false);
 		btn_title.setFocusPainted(false);
 		add(btn_title);
 		
 		// user name
 		in = new IOName();
 		userName = in.getName();
 		userNameL = new JLabel(userName);
 		userNameL.setFont(font);
 		userNameL.setBorder(border);
 		userNameL.setBounds(220, 90, 180, 50);
 		add(userNameL);
 		
 		userNameT = new TextField(15);
 		userNameT.setText(userName);
 		userNameT.setFont(font);
 		userNameT.setBounds(220, 210, 180, 40);
 		userNameT.setVisible(false);
 		add(userNameT);
 		
 		btn_change = new JButton("이름바꾸기");
 		btn_change.setFont(font);
 		btn_change.setBounds(220, 150, 180, 50);
 		add(btn_change);
 		btn_change.addActionListener(this);
 		
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
		
		io = new IOWord();
		wordScore1 = io.getScore1();
		wordScore2 = io.getScore2();
		table1 = new JTable(wordScore1, columnName);
		table2 = new JTable(wordScore2, columnName);
		sp1 = new JScrollPane(table1);
		sp2 = new JScrollPane(table2);
		sp1.setPreferredSize(new Dimension(350, 210));
		sp2.setPreferredSize(new Dimension(350, 210));
		score1.add(sp1);
		score2.add(sp2);
	}
	
	public void actionPerformed(ActionEvent e) {
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
