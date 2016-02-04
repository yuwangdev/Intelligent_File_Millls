package rawtextstats.core.main;

public class RawTextStats {

	String filePath;

	public RawTextStats(String filePath) {
		super();
		this.filePath = filePath;
	}

	public ResultPerFile getResult() {

		Analyze an = new Analyze((new ReadRawFile(this.filePath)).convertFileToStringArray());

		return (new ResultPerFile(an.calFullContent(), an.calTotalLineNumber(), an.calWordNumberPerLine(),
				an.calAverageWords(), an.calTotalWords(), an.calSymbol()));

	}

}
