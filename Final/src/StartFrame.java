import java.awt.*;
import javax.swing.*;

public class StartFrame extends JFrame {
	private CardLayout cards = new CardLayout();
	private JTextField tf_alphabet = new JTextField();
	private JTextField tf_word = new JTextField();
	private TextField tf_line = new TextField();
	private TextField tf_game = new TextField();
	private TextField tf_setting = new TextField();
    Word word;
	
	public StartFrame() {
		setSize(800, 600);
        getContentPane().setLayout(cards);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        word = new Word(this);
        getContentPane().add("Main", new Main(this));
        getContentPane().add("Alphabet", new Alphabet(this));
        getContentPane().add("Word", word);
//        getContentPane().add("Line", new Line(this));
//        getContentPane().add("Game", new Game(this));
        getContentPane().add("Setting", new Setting(this));

		//setUndecorated(true);
        Dimension frameSize = getSize();	//�������� ũ�� ���ϱ�
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();	//����� ȭ���� ũ�� ���ϱ�
		setLocation((screenSize.width - frameSize.width)/2, (screenSize.height - frameSize.height)/2);
		//����Ͱ��� - ������ ���� / 2, ����ͼ��� - ������ ���� / 2
		setVisible(true);
	}
	
	public void changePanel(String name) {
    	cards.show(getContentPane(), name);
    	if (name.equals("Alphabet"))
    		tf_alphabet.requestFocus();
    	else if (name.equals("Word"))
    		word.setFocus();
    	else if (name.equals("Line"))
    		tf_line.requestFocus();
    	else if (name.equals("Game"))
    		tf_game.requestFocus();
    	else if (name.equals("Setting"))
    		tf_setting.requestFocus();
    }
	
//	public void changeLabel(String name) {
//    	//cards.show(getContentPane(), name);
//    	
//		JLabel alphabetlabel = new JLabel("    ��������: �� ���ھ� �ڸ��� ����������!");
//		JLabel wordlabel = new JLabel("    �ܾ��: �ڹ� ���α׷��ֿ� �ʿ��� ���� �ܾ���� �н��մϴ�!");
//		JLabel linelabel = new JLabel("    ��ۿ���: ������ ���α׷����� �ϴ� ��ó�� �ٱ۷� ������!");
//		JLabel gamelabel = new JLabel("    ����: ������ �������� �ܾ���� �����ּ���!");
//		
//    	if (name.equals("Alphabet")) {
//    		tf_alphabet.requestFocus();
//    	else if (name.equals("Word"))
//    		tf_word.requestFocus();
//    	else if (name.equals("Line"))
//    		tf_line.requestFocus();
//    	else if (name.equals("Game"))
//    		tf_game.requestFocus();
//    	else if (name.equals("Setting"))
//    		tf_setting.requestFocus();
//    }
	
	public JTextField getAlphabet() {
		return tf_alphabet;
	}
	public JTextField getWord() {
		return tf_word;
	}
	public TextField getLine() {
		return tf_line;
	}
	public TextField getGame() {
		return tf_game;
	}
	public TextField getSetting() {
		return tf_setting;
	}
		
//	public void newPanel(String name) {
//		getContentPane().add("Main", new Main(this));
//	}
//     
//    public CardLayout getCardLayout() {
//    	 return cards;
//    }

	public static void main(String[] args) {
		new StartFrame();
	}
}