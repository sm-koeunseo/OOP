import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.JOptionPane;


public class Setting extends JPanel implements ActionListener{
	private StartFrame f;
	private JPanel userP, userI, score;
	private JButton btn_main, btn_title, btn_change;
	private TextField userNameT;
	private String userName;
	private JLabel userNameL;
	private IOName in;
	private Font font;
	private Border border;
	private boolean change = false;

	public Setting(StartFrame f) {
		// panel settings
		this.f = f;
		setLayout(null);
        setBackground(new Color(239, 239, 143));

        // basic settings
		font = new Font(("ELAND ���̽� Medium"), Font.PLAIN, 20);
		border = BorderFactory.createLineBorder(Color.BLUE, 3);
        
        // title
 		btn_title = new JButton(new ImageIcon("./images/btn_word.png"));
 		btn_title.setBounds(280, 10, 220, 60);
 		btn_title.setBorderPainted(false);
 		btn_title.setContentAreaFilled(false);
 		btn_title.setFocusPainted(false);
 		add(btn_title);
 		
         // home button
 		btn_main = new JButton("���ư���");
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
 		
 		btn_change = new JButton("�̸��ٲٱ�");
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
 		
 		// user info pannel
		score = new JPanel();
		score.setBackground(Color.white);
		score.setBounds(20, 300, 745, 245);
		add(score);
	}
	
	public void actionPerformed(ActionEvent e) {
		if(change) {
			if (userNameT.getText().equals("")) {
				JOptionPane.showMessageDialog(this, "�̸��� �Է����ּ���!", "Not Access", JOptionPane.ERROR_MESSAGE);
			}else if(userNameT.getText().equals(userName)){
				JOptionPane.showMessageDialog(this, "�����Ϸ��� �̸��� �Է����ּ���!", "Not Access", JOptionPane.ERROR_MESSAGE);
			}else {
				userName = in.setName(userNameT.getText());
				userNameL.setText(userName);
				userNameT.setText(userName);
				userNameT.setVisible(false);
				btn_change.setText("�̸��ٲٱ�");
				JOptionPane.showMessageDialog(this, "����Ǿ����ϴ�!", "Access", JOptionPane.INFORMATION_MESSAGE);
				change = false;
			}
		}else {
			userNameT.setVisible(true);
			change = true;
			btn_change.setText("�����ϱ�");
		}
	}
}