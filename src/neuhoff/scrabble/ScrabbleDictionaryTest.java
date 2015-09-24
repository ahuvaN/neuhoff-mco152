package neuhoff.scrabble;

import java.io.IOException;

import org.junit.Assert;
import org.junit.Test;

public class ScrabbleDictionaryTest {

	@Test
	public void testContains() throws IOException {
		ScrabbleDictionary sd = new ScrabbleDictionary();

		Assert.assertTrue(sd
				.contains("pneumonoultramicroscopicsilicovolcanoconiosis"));

	}
}
