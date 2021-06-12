

import java.io.*;

import javax.swing.plaf.basic.BasicInternalFrameTitlePane.SystemMenuBar;

public class IOName {
	FileReader fr;
	FileWriter fw;
	BufferedReader br;
	BufferedWriter bw;
	String name;

	public IOName() {
		// TODO Auto-generated constructor stub
	}
	
	public String getName() {
		try {
			fr = new FileReader("./text/name.txt");
			br = new BufferedReader(fr);
			
			name = br.readLine();
			
			br.close();
			fr.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return name;
	}
	
	public String setName(String name) {
		System.out.println(name);
		try {
			fw = new FileWriter(new File("./text/name.txt"));
			bw = new BufferedWriter(fw);
			
			bw.write(name);
			
			bw.close();
			fw.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return getName();
	}
	
//	public static void main(String[] args) {
//		IOName in = new IOName();
//		System.out.println(in.getName());
//	}

}
