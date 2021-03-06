package com.rmh.guitar.bestposition.domain;

import static org.junit.Assert.assertEquals;

import com.rmh.guitar.bestposition.domain.PositionPoint;
import org.junit.Test;

import com.rmh.guitar.bestposition.domain.Note;
import com.rmh.guitar.bestposition.domain.Tone;

public class PositionPointTest {

    @Test
    public void testPosition() {
    	Tone tone = new Tone(Note.A, 1);
        PositionPoint position = new PositionPoint(tone, 2, 6);
    	
        assertEquals(Note.A, position.getTone().getNote());
        assertEquals(2, position.getFret());
        assertEquals(6, position.getString());
    }

}
