package util;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class ConvertToQUERY {

	public static boolean isUpper(String s) {
		for (char c : s.toCharArray()) {
			if (!Character.isUpperCase(c))
				return false;
		}
		return true;
	}

	public static void main(String[] args) throws IOException {

		int id = 1;
		String tableName = "";
		for (String line : Files.readAllLines(Paths.get("history.txt"))) {
			String[] s = line.split(",");
			System.out.println("insert into TRAUMA_HISTORY values("+s[0] +",\""+s[1]+"\",\""+s[2]+"\");");
			
			/*if (!line.trim().equalsIgnoreCase("")) {

				String temp = line;
				temp = temp.replaceAll("_", "");
				temp = temp.replaceAll(" ", "");
				if (isUpper(temp)) {
					tableName = line;
					System.out.println("Create table " + tableName + " (id INT, items varchar(250));");
					id = 1;
				} else {
					System.out.println("insert into " + tableName + " values (" + id + ",\"" + line + "\");");
					id++;
				}
			}*/
			// System.out.println(line);
		}

	}

}
