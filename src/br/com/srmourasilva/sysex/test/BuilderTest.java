package br.com.srmourasilva.sysex.test;

import static org.junit.Assert.*;

import org.junit.Test;

import br.com.srmourasilva.sysex.Builder;

public class BuilderTest {

	@Test
	public void asBoolean() {
		byte[] message = new byte[] { (byte) 0b10101010 };
		Builder builder = new Builder(message);

		assertFalse(builder.asBoolean(0, (byte) 0x00));
		assertTrue( builder.asBoolean(0, (byte) 0x01));
	}
}
