package taja.game;
import java.awt.FlowLayout;

import javax.swing.JFrame;

public class GameFrame extends JFrame{
	
	public GameFrame() {
		setSize(800, 596);
	    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    setLayout(new FlowLayout());
	    
	    add("Center", new Game());
	    setVisible(true);
	}

	public static void main(String[] args) {
		new GameFrame();
		
	}
}
