package com.rmh.guitar.bestposition.common;

import com.rmh.guitar.bestposition.common.Note;

public class TestUtil {

	public static Note[] buildNoteArray() {
        Note[] notes = {
            Note.A,
            Note.ASharp,
            Note.B,
            Note.C,
            Note.CSharp,
            Note.D,
            Note.DSharp,
            Note.E,
            Note.F,
            Note.FSharp,
            Note.G,
            Note.GSharp
        };
        
        return notes;
    }

	public static Tone[] buildDefaultTuning() {
		
		Tone[] tuning = {
				new Tone(Note.E, 1),
				new Tone(Note.B, 0),
				new Tone(Note.G, 0),
				new Tone(Note.D, 0),
				new Tone(Note.A, -1),
				new Tone(Note.E, -1)
		};
		
		return tuning;
	}

}