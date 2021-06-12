import java.awt.CardLayout;
import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JFrame;

public class StartFrame extends JFrame {
	private CardLayout cards = new CardLayout();
	Alphabet alph;
    Word word;
    Dimension frameSize, screenSize;
	
	public StartFrame() {
		setSize(800, 600);
        getContentPane().setLayout(cards);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        alph = new Alphabet(this);
        word = new Word(this);
        getContentPane().add("Main", new Main(this));
        getContentPane().add("Alphabet", alph);
        getContentPane().add("Word", word);
        getContentPane().add("Code", new Code(this));
//        getContentPane().add("Game", new Game(this));
        getContentPane().add("Setting", new Setting(this));

		//setUndecorated(true);
        frameSize = getSize();	//프레임의 크기 구하기
		screenSize = Toolkit.getDefaultToolkit().getScreenSize();	//모니터 화면의 크기 구하기
		setLocation((screenSize.width - frameSize.width)/2, (screenSize.height - frameSize.height)/2);
		//모니터가로 - 프레임 가로 / 2, 모니터세로 - 프레임 세로 / 2
		//setUndecorated(true);
		setVisible(true);
	}
	
	public void changePanel(String name) {
    	cards.show(getContentPane(), name);
    	if (name.equals("Alphabet"))
    		alph.setFocus();
    	else if (name.equals("Word"))
    		word.setFocus();
    	else if (name.equals("Code")) {}
    	else if (name.equals("Game")) {
    	    this.setVisible(false);
    		Game game = new Game(this, getLocation()); 
    	    game.start();
    	}
    	else if (name.equals("Setting")) {}
    }

	public static void main(String[] args) {
		new StartFrame();
	}
}
