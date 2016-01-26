package br.com.srmourasilva.sysex;

import javax.sound.midi.MidiMessage;

public class SysexVerbal {
	public static Builder For(MidiMessage sysex) {
		return new Builder(sysex);
	}
}
