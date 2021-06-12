import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class IOName {
	FileReader fr;
	FileWriter fw;
	BufferedReader br;
	BufferedWriter bw;
	String name;
	
	public String getName() {
		try {
			fr = new FileReader("Final/text/name.txt");
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
		try {
			fw = new FileWriter(new File("Final/text/name.txt"));
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
}