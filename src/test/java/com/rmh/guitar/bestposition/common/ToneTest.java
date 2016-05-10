package com.rmh.guitar.bestposition.common;

import static org.junit.Assert.*;

import org.junit.Test;

import com.rmh.guitar.bestposition.common.Note;
import com.rmh.guitar.bestposition.common.Tone;

public class ToneTest {

	@Test
	public void testTone() {
		Tone tone = new Tone(Note.C, 2);
		
		assertEquals(Note.C, tone.getNote());
		assertEquals(2, tone.getOctave());
	}

}
