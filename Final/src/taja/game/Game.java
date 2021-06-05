package taja.game;

import java.awt.*;
import javax.swing.*;

public class Game extends JPanel{
	JTextField tf;
	int speed = 500;
	
	String[][] data = { 
            { "java", "swing", "import", "println", "Vector", "Thread","GridLayout", "int", "repaint", "boolean", "private", "event"},
            { "java", "swing", "import", "println", "Vector", "Thread","GridLayout", "int", "repaint", "boolean", "private", "event"},
            { "javax", "util", "new", "Panel", "Label", "String", "BorderLayout", "float", "this", "true", "North", "color"},
            { "javax", "util", "new", "Panel", "Label", "String", "BorderLayout", "float", "this", "true", "North", "color" }
        };

	public Game() {
		setLayout(null);
		
		tf = new JTextField();
		tf.setBounds(10, 300, 400, 30);
		add(tf);
	}
	
	// 패널에서 시작위치 정하기
	// x값 (50~프레임의 끝-50), y값 : 하여간 랜덤
	// 스피드 or 좌표값 중에 하나 랜덤으로 
	// 쓰레드나 구현한 클래스를 여러개를 []
	// 
	// 글씨를 써서 엔터를 누르면 -> 
	
	public void gameStart() {
		for (int i = 0; i < data[0].length; i++) {
			System.out.println(data[0][i]);
            try {
				Thread.sleep(speed);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
