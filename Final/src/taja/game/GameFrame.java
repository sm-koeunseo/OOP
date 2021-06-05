package taja.game;

import java.awt.*;
import javax.swing.*;

public class GameFrame extends JFrame{
	Game g = new Game();
	
	public GameFrame() {
		setSize(500, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    
	    add(g);
	    setVisible(true);
	}
	
	public void gameStart() {
		g.gameStart();
	}

	public static void main(String[] args) {
		GameFrame gf = new GameFrame();
		System.out.println("2초 후 게임 시작");
		try {
			Thread.sleep(2000);
		}catch(Exception e) {}
		
		gf.gameStart();
	}
}
