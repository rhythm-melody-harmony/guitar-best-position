package com.rmh.guitar.bestposition.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.rmh.guitar.bestposition.domain.Note;
import com.rmh.guitar.bestposition.domain.Tone;

@Component
public class RawToToneConverter {
	
	public List<Tone> convert(List<String> rawPhrase) {
		
		List<Tone> phrase = new ArrayList<>();
		
		for (String rawTone : rawPhrase) {
			
			String[] splittedTone = rawTone.split("/");
			Note note = Note.fromString(splittedTone[0]);
			int octave = Integer.parseInt(splittedTone[1]);
			
			Tone tone = new Tone(note, octave);
			
			phrase.add(tone);
		}
		
		return phrase;
		
	}

}
