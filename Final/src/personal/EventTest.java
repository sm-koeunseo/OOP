import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class EventTest extends JFrame implements KeyListener{
	Panel p;
	TextField tf;

	public EventTest() {
		p = new Panel();
		tf = new TextField(30);
		tf.addKeyListener(this);
		//tf.setVisible(false);
		
		p.setLayout(null);
		p.add(tf);
		// x좌표, y좌표, 가로길이 세로길이
		tf.setBounds(-20, -50, 10, 20);
		add(p);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(1000, 800);
		setVisible(true);
	}

	public static void main(String[] args) {
		new EventTest();
	}

	@Override
	public void keyTyped(KeyEvent e) {
		System.out.println("keyTyped:" + e.getKeyChar());
	}

	@Override
	public void keyPressed(KeyEvent e) {
		//System.out.println("keyPressed");
	}

	@Override
	public void keyReleased(KeyEvent e) {
		//System.out.println("keyReleased");
	}

}
