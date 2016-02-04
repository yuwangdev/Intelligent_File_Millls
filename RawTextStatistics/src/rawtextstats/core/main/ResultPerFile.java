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
public class ResultPerFile {

	private ArrayList<String> fullContent;
	private int totalLineNumber;
	private ArrayList<Integer> wordNumberPerLine;
	private int averageWords;
	private int totalWords;

	public int getTotalWords() {
		return totalWords;
	}

	public ResultPerFile(ArrayList<String> fullContent, int totalLineNumber, ArrayList<Integer> wordNumberPerLine,
			int averageWords, int totalWords, HashMap<String, Integer> symbols) {
		super();
		this.fullContent = fullContent;
		this.totalLineNumber = totalLineNumber;
		this.wordNumberPerLine = wordNumberPerLine;
		this.averageWords = averageWords;
		this.totalWords = totalWords;
		this.symbols = symbols;
	}

	private HashMap<String, Integer> symbols;

	public ArrayList<String> getFullContent() {
		return fullContent;
	}

	public int getTotalLineNumber() {
		return totalLineNumber;
	}

	public ArrayList<Integer> getWordNumberPerLine() {
		return wordNumberPerLine;
	}

	public int getAverageWords() {
		return averageWords;
	}

	public HashMap<String, Integer> getSymbols() {
		return symbols;
	}

	public ResultPerFile(ArrayList<String> fullContent, int totalLineNumber, ArrayList<Integer> wordNumberPerLine,
			int averageWords, HashMap<String, Integer> symbols) {
		super();
		this.fullContent = fullContent;
		this.totalLineNumber = totalLineNumber;
		this.wordNumberPerLine = wordNumberPerLine;
		this.averageWords = averageWords;
		this.symbols = symbols;
	}

	public ResultPerFile(int totalLineNumber, ArrayList<Integer> wordNumberPerLine, int averageWords,
			HashMap<String, Integer> symbols) {
		super();
		this.totalLineNumber = totalLineNumber;
		this.wordNumberPerLine = wordNumberPerLine;
		this.averageWords = averageWords;
		this.symbols = symbols;
	}

	public ResultPerFile(int totalLineNumber, int averageWords, HashMap<String, Integer> symbols) {
		super();
		this.totalLineNumber = totalLineNumber;
		this.averageWords = averageWords;
		this.symbols = symbols;
	}

}