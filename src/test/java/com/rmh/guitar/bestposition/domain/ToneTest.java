package com.rmh.guitar.bestposition.domain;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ToneTest {

	@Test
	public void testTone() {
		Tone tone = new Tone(Note.C, 2);
		
		assertEquals(Note.C, tone.getNote());
		assertEquals(2, tone.getOctave());
	}

}
