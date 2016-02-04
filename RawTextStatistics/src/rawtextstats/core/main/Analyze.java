/**
 * 
 */
package rawtextstats.core.main;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

/**
 * @author ywang
 *
 */
public class Analyze implements AnalyzeFile {

	private ArrayList<String> file;

	public Analyze(ArrayList<String> file) {
		super();
		this.file = file;
	}

	@Override
	public ArrayList<String> calFullContent() {
		// TODO Auto-generated method stub
		return this.file;
	}

	@Override
	public int calTotalLineNumber() {
		// TODO Auto-generated method stub
		return this.file.size();
	}

	@Override
	public ArrayList<Integer> calWordNumberPerLine() {
		// TODO Auto-generated method stub
		ArrayList<Integer> words = new ArrayList<>();
		for (String line : this.file) {
			words.add(calculateWordsPerLine(line));
		}

		return words;
	}

	@Override
	public int calAverageWords() {
		// TODO Auto-generated method stub
		return calTotalWords() / calTotalLineNumber();

	}

	@Override
	public int calTotalWords() {
		// TODO Auto-generated method stub
		int result = 0;
		for (Integer counter : calWordNumberPerLine()) {
			result += counter;
		}

		return result;
	}

	public HashMap<String, Integer> calSymbol() {
		HashMap<String, Integer> result = new HashMap<>();
		result.put("letter", 0);
		result.put("digit", 0);
		result.put("blank", 0);
		result.put("comma", 0);
		result.put("exclamatory", 0);
		result.put("question", 0);
		result.put("period", 0);
		result.put("colon", 0);
		result.put("semicolon", 0);

		for (String line : this.file) {
			for (char ch : line.toCharArray()) {

				if (Character.isLetter(ch)) {
					result.put("letter", result.get("letter") + 1);
				}

				if (Character.isDigit(ch)) {
					result.put("digit", result.get("digit") + 1);
				}

				if (ch == ' ') {
					result.put("blank", result.get("blank") + 1);
				}

				if (ch == ',') {
					result.put("comma", result.get("comma") + 1);
				}

				if (ch == '!') {
					result.put("exclamatory", result.get("exclamatory") + 1);
				}

				if (ch == '?') {
					result.put("question", result.get("question") + 1);
				}
				if (ch == '.') {
					result.put("period", result.get("period") + 1);
				}

				if (ch == ':') {
					result.put("colon", result.get("colon") + 1);
				}

				if (ch == ';') {
					result.put("semicolon", result.get("semicolon") + 1);
				}

			}
		}

		return result;
	}

	private int calculateWordsPerLine(String s) {
		// TODO Auto-generated method stub
		int wordCount = 0;

		boolean word = false;
		int endOfLine = s.length() - 1;

		for (int i = 0; i < s.length(); i++) {
			// if the char is a letter, word = true.
			if (Character.isLetter(s.charAt(i)) && i != endOfLine) {
				word = true;
				// if char isn't a letter and there have been letters before,
				// counter goes up.
			} else if (!Character.isLetter(s.charAt(i)) && word) {
				wordCount++;
				word = false;
				// last word of String; if it doesn't end with a non letter, it
				// wouldn't count without this.
			} else if (Character.isLetter(s.charAt(i)) && i == endOfLine) {
				wordCount++;
			}
		}
		return wordCount;

	}
}
