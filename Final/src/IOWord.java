import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;
import java.util.StringTokenizer;

public class IOWord {
	String fname;
	FileReader fr;
	FileWriter fw;
	BufferedReader br;
	BufferedWriter bw;
	StringTokenizer parse;
	String s1 = "", s2 = "", time;
	int length;
	String[] words, scores, times;
	Random random = new Random();
	Date date;
	SimpleDateFormat sdf;
	
	public IOWord() {
		random.setSeed(System.currentTimeMillis());
	}
	
	public String[] getWords() {
		try {
			
			fname = "Final/text/" + random.nextInt(2) + ".txt";
			fr = new FileReader(fname);
			br = new BufferedReader(fr);
			
			s2 = "";
			while((s1 = br.readLine()) != null) {
				s2 += s1 + "\t";
			}
			StringTokenizer parse = new StringTokenizer(s2, "\t");
			length = parse.countTokens();
			
			words = new String[length];
			for (int i = 0; i < length; i++) {
				words[i] = parse.nextToken();
			}
			
			br.close();
			fr.close();
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return words;
	}
	
	public void setScore(int score) {
		try {
			fr = new FileReader("Final/text/WordScores.txt");
			br = new BufferedReader(fr);
			
			s2 = "";
			while((s1 = br.readLine()) != null) {
				s2 += s1 + "\t";
			}
			StringTokenizer parse = new StringTokenizer(s2, "\t");
			length = parse.countTokens() / 2;
			
			scores = new String[length];
			times = new String[length];
			for(int i = 0; i < length; i++) {
				scores[i] = parse.nextToken();
				times[i] = parse.nextToken();
			}
			
			br.close();
			fr.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		try {
			fw = new FileWriter(new File("Final/text/WordScores.txt"));
			bw = new BufferedWriter(fw);
			
			for (int i = 0; i < length; i++) {
				bw.write("" + scores[i] + "\t" + times[i]);
				bw.newLine();
			}
			date = new Date();
			sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
			bw.write("" + score + "\t" + sdf.format(date));
			
			bw.close();
			fw.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
