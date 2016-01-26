package br.com.srmourasilva.sysex;

import java.util.ArrayList;
import java.util.List;

import javax.sound.midi.MidiMessage;

public class Builder {

	private List<Byte> buffer;
	private byte[] message;

	public Builder(byte[] message) {
		this.buffer = new ArrayList<>();
		this.message = message;
	}

	public Builder(MidiMessage message) {
		this.buffer = new ArrayList<>();
		this.message = message.getMessage();
	}

	public Builder interval(int start, int end) {
		for (int i = start; i < end; i++)
			aByte(i);

		return this;
	}

	public Builder aByte(int pos) {
		this.buffer.add(message[pos]);

		return this;
	}

	/**
	 * @param bytePosition
	 * @param bitPosition [0 .. 7]
	 */
	public boolean asBoolean(int bytePosition, int bitPosition) {
		return BinaryUtils.asBoolean(message[bytePosition], bitPosition);
	}
	
	public String asAsciiString() {
		StringBuilder builder = new StringBuilder();

		for (Byte aByte : buffer) {
			char character = (char) (byte) aByte;
	        if (character != 0)
	        	builder.append(character);
		}

        return builder.toString();
	}
	
	public BuilderConcat concatOf(int bytePosition) {
		return new BuilderConcat(this.message, bytePosition);
	}
}