/**
 * 
 */
package rawtextstats.core.main;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

/**
 * @author ywang
 *
 */
public class AnalyzeTest {

	String filePath = "resources/test1.txt";
	Analyze an = new Analyze((new ReadRawFile(filePath)).convertFileToStringArray());

	@Test
	public void fullContentShouldNotBeNull() {
		ArrayList<String> temp = null;
		temp = an.calFullContent();

		assertNotNull(temp);

	}

	@Test
	public void totalLineNumberShouldBeRight() {
		assertEquals(15, an.calTotalLineNumber());
	}

	@Test
	public void totalWordsNumberShouldBeRight() {
		assertEquals(121, an.calTotalWords());
	}

	@Test
	public void averageWordsNumberShouldBeRight() {

		assertEquals(8, an.calAverageWords());
	}

	@Test
	public void allSymbolsNumberShouldBeRight() {

		assertEquals(8, an.calSymbol().get("comma").intValue());
		assertEquals(5, an.calSymbol().get("period").intValue());
		assertEquals(115, an.calSymbol().get("blank").intValue());
		assertEquals(3, an.calSymbol().get("question").intValue());
		assertEquals(488, an.calSymbol().get("letter").intValue());
		assertEquals(0, an.calSymbol().get("colon").intValue());
		assertEquals(1, an.calSymbol().get("exclamatory").intValue());
		assertEquals(1, an.calSymbol().get("semicolon").intValue());
		assertEquals(11, an.calSymbol().get("digit").intValue());

	}

}
