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

public class IOAlph {
	String fname;
	FileReader fr;
	FileWriter fw;
	BufferedReader br;
	BufferedWriter bw;
	StringTokenizer parse;
	String s1 = "", s2 = "", time, tmp;
	int length, cnt;
	String[][] tmpScores1, tmpScores2;
	String[] words, scores, times;
	Random random = new Random();
	Date date;
	SimpleDateFormat sdf;
	
	private void getScore() {
		try {
			fr = new FileReader("Final/text/AlphScores.txt");
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
	}
	
	public void setScore(double score) {
		getScore();
		
		try {
			fw = new FileWriter(new File("Final/text/AlphScores.txt"));
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
	
	public String[][] getScore1(){
		getScore();
		
		cnt = 0;
		tmpScores1 = new String[length][3];
		for (int i = length - 1; i > -1; i--) {
			tmpScores1[cnt][2] = scores[i];
			tmpScores1[cnt][1] = times[i];
			tmpScores1[cnt][0] = "" + ++cnt;
		}
		return tmpScores1;
	}
	
	public String[][] getScore2(){
		cnt = 0;
		tmpScores2 = new String[length][3];
		for (int i = length - 1; i > -1; i--) {
			tmpScores2[cnt][2] = scores[i];
			tmpScores2[cnt][1] = times[i];
			tmpScores2[cnt][0] = "" + ++cnt;
		}
		
		for (int i = length - 1; i > 0; i--) {
			for (int j = 0; j < i; j++) {
				if (tmpScores2[j][2].equals(tmpScores2[j + 1][2])) {
					if(tmpScores2[j][1].compareTo(tmpScores2[j + 1][1]) > 0){
						tmp = tmpScores2[j][2];
						tmpScores2[j][2] = tmpScores2[j + 1][2];
						tmpScores2[j + 1][2] = tmp;
						
						tmp = tmpScores2[j][1];
						tmpScores2[j][1] = tmpScores2[j + 1][1];
						tmpScores2[j + 1][1] = tmp;
						
					}
				}else if (Double.parseDouble(tmpScores2[j][2]) < Double.parseDouble(tmpScores2[j + 1][2])) {
					tmp = tmpScores2[j][2];
					tmpScores2[j][2] = tmpScores2[j + 1][2];
					tmpScores2[j + 1][2] = tmp;
					
					tmp = tmpScores2[j][1];
					tmpScores2[j][1] = tmpScores2[j + 1][1];
					tmpScores2[j + 1][1] = tmp;
				}
			}
		}
		
		return tmpScores2;
	}
}
