import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.Border;

public class MainPanel extends JPanel implements ActionListener{
   private Main f;
   private Panel titlepanel,menupanel,textpanel,startpanel;
   private JLabel titlelabel, menulabel, textlabel;
   private JButton btn_alphabet, btn_word, btn_code, btn_game, btn_setting;
   private JButton start, prof, exit;
   private String tmpPanel = "";
   private Font font, font2, font3;
   private JTextField tf_main = new JTextField(300) {
      public void setBorder(Border border) { } 
    };
    
   public MainPanel(Main f) {
      this.f = f;      
      setLayout(new BorderLayout());
      tf_main.setLayout(null);
      tf_main.setEnabled(false);
      tf_main.setDisabledTextColor(Color.black);
      
      font = new Font(("ELAND ���̽� Medium"), Font.PLAIN, 30);
      font2 = new Font(("ELAND ���̽� Medium"), Font.PLAIN, 15);
      
      //Ÿ��Ʋ �г�
      titlepanel = new Panel();
      Color color = new Color(239, 239, 143);
        setBackground(color);
      titlelabel = new JLabel("<html><br/>������ �����԰� �Բ��ϴ� \"��ü Ÿ�ڿ���\"<br/><br/></html>");
      
      titlelabel.setFont(font);
      titlepanel.add(titlelabel);
      //�޴��г�
      menupanel = new Panel();      
      Color color2 = new Color(238, 203, 224);
      menupanel.setBackground(color2);
      
      GridLayout grid1 = new GridLayout(6,1);
      menupanel.setLayout(grid1);
      
      menulabel = new JLabel(" **    �Ʒ����� �޴��� �����ϼ���.   **");
      
      menulabel.setFont(font2);
      menupanel.add(menulabel);
      
      btn_alphabet = new JButton(new ImageIcon("Final/images/btn_alpha.png"));
      btn_alphabet.setBorderPainted(false);
      btn_alphabet.setContentAreaFilled(false);
      btn_alphabet.setFocusPainted(false);
      menupanel.add(btn_alphabet);
      btn_alphabet.addActionListener(this);
      
      btn_word = new JButton(new ImageIcon("Final/images/btn_word.png"));
      btn_word.setBorderPainted(false);
      btn_word.setContentAreaFilled(false);
      btn_word.setFocusPainted(false);
      menupanel.add(btn_word);
      btn_word.addActionListener(this);
      
      btn_code = new JButton(new ImageIcon("Final/images/btn_long.png"));
      btn_code.setBorderPainted(false);
      btn_code.setContentAreaFilled(false);
      btn_code.setFocusPainted(false);
      menupanel.add(btn_code);
      btn_code.addActionListener(this);
      
      btn_game = new JButton(new ImageIcon("Final/images/btn_game.png"));
      btn_game.setBorderPainted(false);
      btn_game.setContentAreaFilled(false);
      btn_game.setFocusPainted(false);
      menupanel.add(btn_game);
      btn_game.addActionListener(this);
      
      btn_setting = new JButton(new ImageIcon("Final/images/btn_settings.png"));
      btn_setting.setBorderPainted(false);
      btn_setting.setContentAreaFilled(false);
      btn_setting.setFocusPainted(false);
      menupanel.add(btn_setting);
      btn_setting.addActionListener(this);
      
      textpanel = new Panel();
      textpanel.setLayout(new BorderLayout());
      textlabel = new JLabel("    ** �޴� ���� **");
      prof = new JButton(new ImageIcon("Final/images/prof.png"));
      prof.setBorderPainted(false);
      prof.setContentAreaFilled(false);
      prof.setFocusPainted(false);
      prof.addActionListener(this);
      
      startpanel = new Panel();
      start = new JButton(new ImageIcon("Final/images/btn_start.png"));
      start.setBorderPainted(false);
      start.setContentAreaFilled(false);
      start.setFocusPainted(false);
      start.addActionListener(this);
      startpanel.add(start);
      
      exit = new JButton(new ImageIcon("Final/images/btn_exit.png"));
      exit.setBorderPainted(false);
      exit.setContentAreaFilled(false);
      exit.setFocusPainted(false);
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
      font3 = new Font(("ELAND ���̽� Medium"), Font.PLAIN, 17);
      tf_main.setFont(font3);
      if(e.getSource() == btn_alphabet) {
         tmpPanel = "Alphabet";
         tf_main.setText("    �ڸ�����: �� ���ھ� �ڸ��� ����������!");
      } else if(e.getSource() == btn_word) {
         tmpPanel = "Word";
         tf_main.setText("    �ܾ��: �ڹ� ���α׷��ֿ� �ʿ��� ���� �ܾ���� �н��մϴ�!");
      }else if(e.getSource() == btn_code) {
         tmpPanel = "Code";
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
      }else if (e.getSource() == exit) {
         System.exit(0);
      }else if(e.getSource() == prof) {
         tf_main.setText("    �л� ������ ȭ����!");
      }
   }
}