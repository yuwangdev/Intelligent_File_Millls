/**
 * 
 */
package rawtextstats.core.main;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * @author ywang
 *
 */
public class RawTextHandler {
	/*
	 * mode: single mode: multiple mode: config
	 */

	private String mode;
	private String configFileLocation;

	private String singleFileLocation;
	private ArrayList<String> multipleFilesLocations;
	ArrayList<ResultPerFile> result = new ArrayList<>();

	public RawTextHandler(String singleFileLocation) {
		super();
		this.singleFileLocation = singleFileLocation;
		this.mode = "single";
	}

	public RawTextHandler(String mode, ArrayList<String> multipleFilesLocations) throws IllegalAccessException {
		super();
		this.mode = mode;
		this.multipleFilesLocations = multipleFilesLocations;
		if (!this.mode.equals("multiple")) {
			throw new IllegalAccessException("Multiple file uploading mode needs the mode of 'multiple'");
		}
	}

	public RawTextHandler(String mode, String configFileLocation) throws IllegalAccessException {
		super();
		this.mode = mode;
		this.configFileLocation = configFileLocation;
		if (!this.mode.equals("config")) {
			throw new IllegalAccessException("Multiple file uploading mode needs the mode of 'config'");
		}
	}

	public ArrayList<ResultPerFile> analyze() {

		if (this.mode.equals("single")) {
			result.add((new RawTextStats(this.singleFileLocation)).getResult());

		}

		if (this.mode.equals("multiple")) {
			for (String file : this.multipleFilesLocations) {
				result.add((new RawTextStats(file)).getResult());
			}

		}

		if (this.mode.equals("config")) {
			ArrayList<String> fileList = obtainFilesFromConfig(this.configFileLocation);

			for (String file : fileList) {
				result.add((new RawTextStats(file)).getResult());
			}
		}

		return result;

	}
	
	(new ResultPerFile(an.calFullContent(), an.calTotalLineNumber(), an.calWordNumberPerLine(),
			an.calAverageWords(), an.calTotalWords(), an.calSymbol()));

	
	public HashMap<String, Integer> parseResult(){
		HashMap<String, Integer> hm = new HashMap<>();
		for (ResultPerFile rpf : result) {
			
		}
		
		
		
		
		
		
		
		
		
		return hm;
		
	}
	
	
	private ArrayList<String> obtainFilesFromConfig(String cfg) {
		// TODO Auto-generated method stub
		ArrayList<String> list = new ArrayList<>();
		ReadRawFile rrf = new ReadRawFile(cfg);
		list = rrf.convertFileToStringArray();
		if (list.size() < 0) {
			throw new IllegalAccessError("The configure file shoud not be empty");
		}

		return list;
	}

}
