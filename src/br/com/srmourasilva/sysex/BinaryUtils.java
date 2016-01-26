package br.com.srmourasilva.sysex;

class BinaryUtils {
	private BinaryUtils() {};
	
	/**
	 * @param bitPosition [0..7]
	 */
	public static boolean asBoolean(byte byteSelected, int bitPosition) {
		byte MASK = (byte) (0x01 << bitPosition); 

		return (byteSelected & MASK) == MASK;
	}
}
