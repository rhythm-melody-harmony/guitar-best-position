package com.rmh.guitar.bestposition.fretboard;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.rmh.guitar.bestposition.domain.Note;
import com.rmh.guitar.bestposition.domain.Tone;
import com.rmh.guitar.bestposition.fretboard.settings.FretBoardSettings;

@Component
public class FretBoardFactory {
	
	private int numberOfStrings;
	private int numberOfFrets;
	private Tone[] tuning;
	private List<Note> naturalScale;
	
	public List<PositionPoint> create(FretBoardSettings fretBoardSettings) {
		
		numberOfStrings = fretBoardSettings.getNumberOfStrings();
		numberOfFrets = fretBoardSettings.getNumberOfFrets();
		tuning = fretBoardSettings.getTuning();
		naturalScale = buildNaturalScale(); 
		
		List<PositionPoint> positionPoints = new ArrayList<>();
		
		for (int i = 0; i < numberOfStrings; i++) {
			List<PositionPoint> stringPositoinPoints = createString(i);
			
			positionPoints.addAll(stringPositoinPoints);
        }
		
		return positionPoints;
	}
	
	private List<PositionPoint> createString(int string) {
		List<PositionPoint> positionPoints = new ArrayList<>();
		
        for (int i = 0; i < numberOfFrets+1; i++) {
            Tone tone = createTone(string, i);
            PositionPoint positionPoint = new PositionPoint(tone, i, string+1);
            
            positionPoints.add(positionPoint);
        }
        
        return positionPoints;
    }
    
    private Tone createTone(int string, int fret) {
        Tone tuningTone = tuning[string];
        
        Note note = tuningTone.getNote();
        int noteIndex = naturalScale.indexOf(note);
        int octave = tuningTone.getOctave();
        
        for (int i = 0; i < fret; i++) {
           noteIndex++;
           if (noteIndex == 12) {
               noteIndex = 0;
               octave++;
           }
        }
        
        note = naturalScale.get(noteIndex);
        
        Tone tone = new Tone(note, octave);
        
        return tone;
    }
    
    private List<Note> buildNaturalScale() {
        List<Note> scale = new ArrayList<Note>();
        
        scale.add(Note.C);
        scale.add(Note.CSharp);
        scale.add(Note.D);
        scale.add(Note.DSharp);
        scale.add(Note.E);
        scale.add(Note.F);
        scale.add(Note.FSharp);
        scale.add(Note.G);
        scale.add(Note.GSharp);
        scale.add(Note.A);
        scale.add(Note.ASharp);
        scale.add(Note.B);
        
        return scale;
    }
	
}
