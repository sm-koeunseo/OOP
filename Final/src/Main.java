import java.awt.*;
import javax.swing.*;

public class Main extends JFrame {
	private CardLayout cards = new CardLayout();
	private TextField tf_game = new TextField();
	private TextField tf_setting = new TextField();
	Alphabet alph;
    Word word;
    Code code;
    Setting setting;
	
	public Main() {
		setSize(800, 600);
        getContentPane().setLayout(cards);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        alph = new Alphabet(this);
        word = new Word(this);
        code = new Code(this);
        setting = new Setting(this);
        getContentPane().add("Main", new MainPanel(this));
        getContentPane().add("Alphabet", alph);
        getContentPane().add("Word", word);
        getContentPane().add("Code", code);
        getContentPane().add("Setting", setting);

		//setUndecorated(true);
        Dimension frameSize = getSize();	//프레임의 크기 구하기
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();	//모니터 화면의 크기 구하기
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
    	else if (name.equals("Code"))
    		code.setFocus();
    	else if (name.equals("Game")) {
    		this.setVisible(false);
			Game game = new Game(this, getLocation()); 
		    game.start();
    	}else if (name.equals("Setting"))
    		setting.setFocus();
    }
	
	public TextField getGame() {
		return tf_game;
	}
	public TextField getSetting() {
		return tf_setting;
	}

	public static void main(String[] args) {
		new Main();
	}
}
