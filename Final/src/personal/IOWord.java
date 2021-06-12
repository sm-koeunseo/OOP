package personal;


import java.io.*;
import java.util.*;

public class IOWord {
	String fname;
	FileReader fr;
	FileWriter fw;
	BufferedReader br;
	BufferedWriter bw;
	String s1 = "", s2 = "";
	StringTokenizer parse;
	int length;
	String[] words;
	String name;
	String[] scores;
	Random random = new Random();
	
	public IOWord() {
		random.setSeed(System.currentTimeMillis());
	}
	
	public String[] getWords() {
		try {
			
			fname = "./text/" + random.nextInt(2) + ".txt";
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
			fr = new FileReader("./text/WordScores.txt");
			br = new BufferedReader(fr);
			
			s2 = "";
			while((s1 = br.readLine()) != null) {
				s2 += s1 + "\t";
			}
			StringTokenizer parse = new StringTokenizer(s2, "\t");
			length = parse.countTokens();
			
			scores = new String[length];
			for(int i = 0; i < length; i++)
				scores[i] = parse.nextToken();
			
			br.close();
			fr.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
		try {
			fw = new FileWriter(new File("./text/WordScores.txt"));
			bw = new BufferedWriter(fw);
			
			for (int i = 0; i < length - 1; i++) {
				bw.write("" + scores[i]);
				bw.newLine();
			}
			bw.write("" + score);
			
			bw.close();
			fw.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
//	public static void main(String[] args) {
//		IOWord iw = new IOWord();
//		String[] test = iw.getWords();
//		
//		for (int i = 0; i < test.length; i++) {
//			System.out.println(test[i]);
//		}
//	}

}
