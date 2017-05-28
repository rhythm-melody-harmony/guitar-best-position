package com.rmh.guitar.bestposition.fretboard.settings;

import com.rmh.guitar.bestposition.domain.Tone;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@Data
@Slf4j
@ConfigurationProperties(prefix = "guitar.setup")
public class DefaultFretBoardSettingsFactory {

	private Tone[] tuning;
	private int numberOfFrets;
	private int numberOfStrings;
	
	public FretBoardSettings create() {

		return new FretBoardSettings(numberOfFrets, numberOfStrings, tuning);
		
	}

}
