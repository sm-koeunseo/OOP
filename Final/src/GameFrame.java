

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
		System.out.println("2�� �� ���� ����");
		try {
			Thread.sleep(2000);
		}catch(Exception e) {}
		
		gf.gameStart();
	}
}