package com.rmh.guitar.bestposition.fretboard;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.rmh.guitar.bestposition.domain.Note;
import com.rmh.guitar.bestposition.domain.Tone;

public class PositionPointTest {

private PositionPoint position;
    
    @Test
    public void testPosition() {
    	Tone tone = new Tone(Note.A, 1);
        position = new PositionPoint(tone, 2, 6);
    	
        assertEquals(Note.A, position.getTone().getNote());
        assertEquals(2, position.getFret());
        assertEquals(6, position.getString());
    }

}
