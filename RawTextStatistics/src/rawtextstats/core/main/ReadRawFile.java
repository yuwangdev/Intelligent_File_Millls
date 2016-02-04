/**
 * 
 */
package rawtextstats.core.main;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

/**
 * @author ywang
 *
 */
public class ReadRawFile {

	private String filePath;

	public String getFilePath() {
		return filePath;
	}

	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}

	public ReadRawFile(String filePath) {
		super();
		this.filePath = filePath;
	}

	public ArrayList<String> convertFileToStringArray() {
		String fileName = this.filePath;
		String line = null;
		ArrayList<String> lines = new ArrayList<String>();

		try {

			FileReader fileReader = new FileReader(fileName);

			BufferedReader bufferedReader = new BufferedReader(fileReader);

			while ((line = bufferedReader.readLine()) != null) {
				lines.add(line);

			}

			bufferedReader.close();
		} catch (FileNotFoundException ex) {
			System.out.println("Unable to open file '" + fileName + "'");
		} catch (IOException ex) {
			System.out.println("Error reading file '" + fileName + "'");

		}
		return lines;
	}

}
