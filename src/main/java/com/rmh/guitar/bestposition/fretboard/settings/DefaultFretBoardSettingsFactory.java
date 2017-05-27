package com.rmh.guitar.bestposition.fretboard.settings;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import com.rmh.guitar.bestposition.domain.Note;
import com.rmh.guitar.bestposition.domain.Tone;

import java.util.List;

@Component
@Data
@Slf4j
@ConfigurationProperties(prefix = "guitar.setup")
public class DefaultFretBoardSettingsFactory {

	private Tone[] tuning;
	private int numberOfFrets;
	private int numberOfStrings;
	
	public FretBoardSettings create() {

        FretBoardSettings fretBoardSettings = new FretBoardSettings(numberOfFrets, numberOfStrings, tuning);
		
		return fretBoardSettings;
		
	}

}
