package com.rmh.guitar.bestposition.domain;

import static org.junit.Assert.*;

import org.junit.Test;

import com.rmh.guitar.bestposition.domain.Note;
import com.rmh.guitar.bestposition.domain.Tone;

public class ToneTest {

	@Test
	public void testTone() {
		Tone tone = new Tone(Note.C, 2);
		
		assertEquals(Note.C, tone.getNote());
		assertEquals(2, tone.getOctave());
	}

}
