
import javax.swing.JLabel;

public class Prof extends Thread {
	Word w;
	JLabel l;

	public Prof(Word w, JLabel l) {
		this.w = w;
		this.l = l;
	}
	
	public void run() {
		l.setVisible(true);
		try {
			sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		l.setVisible(false);
	}
}
