package br.com.srmourasilva.sysex;

import java.util.ArrayList;
import java.util.List;

public class BuilderConcat {

	private List<Boolean> result;

	private byte byteSelected;
	private byte[] message;

	public BuilderConcat(byte[] message, int bytePosition) {
		this(message, bytePosition, new ArrayList<>());
	}

	private BuilderConcat(byte[] message, int bytePosition, List<Boolean> result) {
		this.message = message;
		this.byteSelected = message[bytePosition];
		this.result = result;
	}

	public BuilderConcat concatOf(int bytePosition) {
		return new BuilderConcat(message, bytePosition, result);
	}

	/**
	 * Interval close open: [bitStart, bitEnd)
	 * 
	 * @param bytePosition
	 * @param bitStart [0 .. 7]
	 * @param bitEnd   [0 .. 7]
	 */
	public BuilderConcat bits(int bitStart, int bitEnd) {
		for (byte i = (byte) (bitEnd-1); i >= bitStart; i--)
			bit(i);

		return this;
	}

	/**
	 * @param bytePosition
	 * @param bitPosition 0 = First bit
	 * 				  	  7 = Last bit
	 */
	public BuilderConcat bit(int bitPosition) {
		result.add(BinaryUtils.asBoolean(byteSelected, bitPosition));

		return this;
	}

	public int asInteger() {
		int n = 0;
	    for (boolean b : this.result)
	        n = (n << 1) | (b ? 1 : 0);

	    return n;
	}
}
