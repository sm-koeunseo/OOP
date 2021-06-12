package personal;
import java.io.*;
import java.util.StringTokenizer;

public class IOTest {

	public IOTest() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		String fname = "./text/test.txt";
		
		try {
			FileReader fr = new FileReader(fname);
			BufferedReader br = new BufferedReader(fr);
			String s1= "";
			String s2= "";
			String user = br.readLine();
			String[] score1;
			String[] score2;
			String[] score3;
			
			while((s1 = br.readLine()) != null) {
				s2 += s1 + "\t";
			}
			
			StringTokenizer parse = new StringTokenizer(s2, "\t");
			int length = parse.countTokens()/3;
			score1 = new String[length + 1];
			score2 = new String[length + 1];
			score3 = new String[length + 1];
			
			for(int i = 0; i < length; i++) {
				score1[i] = parse.nextToken();
				score2[i] = parse.nextToken();
				score3[i] = parse.nextToken();
				
				System.out.println(score1[i] + ", " + score2[i] + ", " + score3[i]);
			}
			
			score1[length] = "153";
			score2[length] = "153";
			score3[length] = "153";

			FileWriter fw = new FileWriter(new File("./text/test.txt"));
			BufferedWriter bw = new BufferedWriter(fw);
			
			bw.write(user);
			bw.newLine();
			for (int i = 0; i < length + 1; i++) {
				bw.write(score1[i] + "\t" + score2[i] + "\t" + score3[i]);
				bw.newLine();
			}
			
			br.close();
			bw.close();
			fw.close();
			
		} catch(Exception e) {
			System.out.println(e.toString());
		}

	}

}
