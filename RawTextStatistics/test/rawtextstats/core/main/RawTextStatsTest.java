/**
 * 
 */
package rawtextstats.core.main;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * @author ywang
 *
 */
public class RawTextStatsTest {

	@Test
	public void test1() {
		String filePath = "resources/test1.txt";
		RawTextStats rts = new RawTextStats(filePath);
		ResultPerFile rpf = rts.getResult();
		System.out.println(rpf.getFullContent());
		System.out.println(rpf.getSymbols());
		System.out.println(rpf.getAverageWords());
		System.out.println(rpf.getTotalLineNumber());
		System.out.println(rpf.getTotalWords());
		System.out.println(rpf.getWordNumberPerLine());

	}

	@Test
	public void test2() {
		String filePath = "resources/test2.txt";
		RawTextStats rts = new RawTextStats(filePath);
		ResultPerFile rpf = rts.getResult();
		System.out.println(rpf.getFullContent());
		System.out.println(rpf.getSymbols());
		System.out.println(rpf.getAverageWords());
		System.out.println(rpf.getTotalLineNumber());
		System.out.println(rpf.getTotalWords());
		System.out.println(rpf.getWordNumberPerLine());

	}

}
