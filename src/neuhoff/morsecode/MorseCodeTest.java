package neuhoff.morsecode;

import org.junit.Assert;
import org.junit.Test;

public class MorseCodeTest {

	@Test
	public void testEncode() {
		MorseCode e = new MorseCode();
		Assert.assertEquals(
				"-- -.--   -. .- -- .   .. ...   .- .... ..- ...- .-",
				e.encode("my name is ahuva"));
	}

	@Test
	public void testDecode() {
		MorseCode d = new MorseCode();
		Assert.assertEquals("my name is ahuva",
				d.decode("-- -.--   -. .- -- .   .. ...   .- .... ..- ...- .-"));
	}
}
