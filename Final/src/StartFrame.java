import java.awt.*;
import javax.swing.*;

public class StartFrame extends JFrame {
	private CardLayout cards = new CardLayout();
	private TextField tf_alphabet = new TextField();
	private TextField tf_word = new TextField();

	public StartFrame() {
		setSize(500, 400);
        getContentPane().setLayout(cards);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        getContentPane().add("Main", new Main(this));
        getContentPane().add("Alphabet", new Alphabet(this));
        getContentPane().add("Word", new Word(this));
        
        Dimension frameSize = getSize();	//프레임의 크기 구하기
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();	//모니터 화면의 크기 구하기
		setLocation((screenSize.width - frameSize.width)/2, (screenSize.height - frameSize.height)/2);
		//모니터가로 - 프레임 가로 / 2, 모니터세로 - 프레임 세로 / 2
        setVisible(true);
	}
	
	public void changePanel(String name) {
    	cards.show(getContentPane(), name);
    	if (name.equals("Alphabet"))
    		tf_alphabet.requestFocus();
    	else if (name.equals("Word"))
    		tf_word.requestFocus();
    }
	
	public TextField getAlphabet() {
		return tf_alphabet;
	}
	public TextField getWord() {
		return tf_word;
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
