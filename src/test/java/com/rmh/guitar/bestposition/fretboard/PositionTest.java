package com.rmh.guitar.bestposition.fretboard;

import static org.junit.Assert.*;

import org.junit.Test;

import com.rmh.guitar.bestposition.domain.Note;
import com.rmh.guitar.bestposition.domain.Tone;

public class PositionTest {

	@Test
	public void testPosition() {
		
		Tone tone = new Tone(Note.C, 1);
		PositionPoint positionPoint = new PositionPoint(tone, 3, 5);
		Position position = new Position(positionPoint, 1);
		
		assertEquals(positionPoint, position.getPositionPoint());
		assertEquals(1, position.getFinger());
		assertEquals(tone, position.getTone());
		assertEquals(3, position.getFret());
		assertEquals(5, position.getString());
	}

}
