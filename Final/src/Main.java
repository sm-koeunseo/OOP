import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Main extends JPanel implements ActionListener{
	private StartFrame f;
	private Button btn_alphabet, btn_word;

	public Main(StartFrame f) {
		this.f = f;
		
		btn_alphabet = new Button("낱말연습");
		add(btn_alphabet);
		btn_alphabet.addActionListener(this);
		
		btn_word = new Button("단어연습");
		add(btn_word);
		btn_word.addActionListener(this);
	}

	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == btn_alphabet)
			f.changePanel("Alphabet");
		else if(e.getSource() == btn_word)
			f.changePanel("Word");
	}

}
