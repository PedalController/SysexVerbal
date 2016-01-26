package br.com.srmourasilva.sysex.test;

import static org.junit.Assert.*;

import org.junit.Test;

import br.com.srmourasilva.sysex.Builder;

public class BuilderConcatTest {

	@Test
	public void asInteger() {
		byte[] message = new byte[] { (byte) 0b01001010 };
		int expected = 0b011010;
		
		Builder builder = new Builder(message);

		int result = builder.concatOf(0).bit(0x06).bits(0x00, 0x04)
							.asInteger();

		assertEquals(expected, result);
	}
	
	@Test
	public void asIntegerMultiple() {
		byte[] message = new byte[] { (byte) 0b0010000, (byte) 0b00001010 };
		int expected = 0b011010;
		
		Builder builder = new Builder(message);

		int result = builder.concatOf(0).bit(0x04)
							.concatOf(1).bits(0x00, 0x04)
							.asInteger();

		assertEquals(expected, result);
	}
}
