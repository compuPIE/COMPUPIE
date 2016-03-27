package util;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class ConvertQuery1 {

	public static void main(String[] args) throws IOException {

		int id = 0;
		int subId = 1;
		String tableName = "";
		BufferedReader br = new BufferedReader(new FileReader("info1.txt"));
		String line;
		while((line = br.readLine()) != null){	
		//System.out.println(line);
			if(line.contains("--")){
				System.out.println("insert into PHYSICAL_HEALTH_CATEGORIES  values ("+(++id)+",\""+line.substring(5).trim()+"\");");
			}else{ 
				String[] s = line.split("\t");
				System.out.println("insert into PHYSICAL_HEALTH_PROBLEMS values ("+(subId++)+","+id+",'"+s[1]+"',\""+s[0]+"\");");
			}
		}
	}

}
