package com.rmh.guitar.bestposition.fretboard.settings;

import org.springframework.stereotype.Component;

import com.rmh.guitar.bestposition.domain.Note;
import com.rmh.guitar.bestposition.domain.Tone;

@Component
public class DefaultFretBoardSettingsFactory {
	
	public FretBoardSettings create() {
		
		Tone[] tuning = {
				new Tone(Note.E, 1),
				new Tone(Note.B, 0),
				new Tone(Note.G, 0),
				new Tone(Note.D, 0),
				new Tone(Note.A, -1),
				new Tone(Note.E, -1)
		};
        
        FretBoardSettings fretBoardSettings = new FretBoardSettings(21, 6, tuning);
		
		return fretBoardSettings;
		
	}

}
