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
	
	// �гο��� ������ġ ���ϱ�
	// x�� (50~�������� ��-50), y�� : �Ͽ��� ����
	// ���ǵ� or ��ǥ�� �߿� �ϳ� �������� 
	// �����峪 ������ Ŭ������ �������� []
	// 
	// �۾��� �Ἥ ���͸� ������ -> 
	
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