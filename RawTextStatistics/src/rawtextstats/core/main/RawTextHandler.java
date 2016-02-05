/**
 *
 */
package rawtextstats.core.main;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * @author ywang
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


    public ArrayList<HashMap<String, Integer>> parseResult() {
        ArrayList<HashMap<String, Integer>> r = new ArrayList<>();

        HashMap<String, Integer> tmp = new HashMap<>();

        for (ResultPerFile rpf : result) {
            tmp.put("lineNumber", rpf.getTotalLineNumber());
            tmp.put("averageWordNumber", rpf.getAverageWords());
            tmp.put("totalWordNumber", rpf.getTotalWords());
            tmp.put("letter", rpf.getSymbols().get("letter"));
            tmp.put("digit", rpf.getSymbols().get("digit"));
            tmp.put("blank", rpf.getSymbols().get("blank"));
            tmp.put("comma", rpf.getSymbols().get("comma"));
            tmp.put("exclamatory", rpf.getSymbols().get("exclamatory"));
            tmp.put("question", rpf.getSymbols().get("question"));
            tmp.put("period", rpf.getSymbols().get("period"));
            tmp.put("colon", rpf.getSymbols().get("colon"));
            tmp.put("semicolon", rpf.getSymbols().get("semicolon"));


        }

        return r;
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
