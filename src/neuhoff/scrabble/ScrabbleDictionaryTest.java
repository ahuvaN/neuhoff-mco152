package neuhoff.scrabble;

import org.junit.Assert;
import org.junit.Test;


public class ScrabbleDictionaryTest {
	@Test
	public void testContains(){
		ScrabbleDictionary sd = new ScrabbleDictionary();
		
		Assert.assertTrue(sd.contains("hello"));
		
		
	}
}

