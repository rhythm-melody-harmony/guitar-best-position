package com.rmh.guitar.bestposition.utils;

import java.util.ArrayList;
import java.util.List;

import com.rmh.guitar.bestposition.domain.Note;
import com.rmh.guitar.bestposition.domain.Tone;
import com.rmh.guitar.bestposition.fretboard.Position;
import com.rmh.guitar.bestposition.fretboard.PositionPoint;
import com.rmh.guitar.bestposition.fretboard.settings.FretBoardSettings;

public class TestUtils {

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
	
	public static FretBoardSettings buildFretBoardSettings() {
		FretBoardSettings fretBoardSettings = new FretBoardSettings(21, 6, buildDefaultTuning());
		
		return fretBoardSettings;
	}
	
	public static List<Position> buildTestTonePositions(Tone tone, int fret, int string) {
		
		List<Position> tonePositions = new ArrayList<>();
		
		PositionPoint positionPoint = new PositionPoint(tone, fret, string);
		
		tonePositions.add(new Position(positionPoint, 1));
		tonePositions.add(new Position(positionPoint, 2));
		tonePositions.add(new Position(positionPoint, 3));
		tonePositions.add(new Position(positionPoint, 4));
		
		return tonePositions;
		
	}

}