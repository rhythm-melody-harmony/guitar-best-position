package com.rmh.guitar.bestposition.service;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;

import com.rmh.guitar.bestposition.domain.Note;
import com.rmh.guitar.bestposition.domain.Tone;

public class RawToToneConverterTest {

	@Test
	public void testConvert() {
		RawToToneConverter rawToToneConverter = new RawToToneConverter();
		
		List<String> rawPhrase = new ArrayList<>(Arrays.asList("A/0", "C/1", "B/2"));
		
		List<Tone> phrase = rawToToneConverter.convert(rawPhrase);
		
		assertEquals(new Tone(Note.A, 0), phrase.get(0));
		assertEquals(new Tone(Note.C, 1), phrase.get(1));
		assertEquals(new Tone(Note.B, 2), phrase.get(2));
	}

}
