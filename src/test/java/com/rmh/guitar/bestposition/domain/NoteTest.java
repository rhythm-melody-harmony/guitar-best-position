package com.rmh.guitar.bestposition.domain;

import static org.junit.Assert.*;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.rmh.guitar.bestposition.domain.Note;
import com.rmh.guitar.bestposition.utils.TestUtils;

public class NoteTest {
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Test
	public void testNoteGivenValidToneString() {
		
		logger.info("Test fromString and toString");
		
		Note note = Note.fromString("A");
		
		assertEquals(Note.A, note);
		assertEquals("A", note.toString());
		
		note = Note.fromString("G#");
		
		assertEquals(Note.GSharp, note);
		assertEquals("G#", note.toString());
		
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testNoteGivenInvalidToneStringShouldThrowException() {
		
		logger.info("Test fromString given invalid argument");
		
		Note.fromString("X");
		
	}
	
	@Test
    public void testValues() {
        logger.info("Test all values");
        Note[] expResult = TestUtils.buildNoteArray();
        Note[] result = Note.values();
        assertArrayEquals(expResult, result);
    }
	
}
