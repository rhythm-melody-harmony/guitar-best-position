package com.rmh.guitar.bestposition.settings;

import com.rmh.guitar.bestposition.domain.request.options.FretboardSettings;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@Data
@Slf4j
@ConfigurationProperties(prefix = "guitar")
public class FretBoardSettingsFactory {

	private FretboardSettings fretboardSettings;

	public FretboardSettings create() {

		return new FretboardSettings(fretboardSettings.getNumberOfFrets(), fretboardSettings.getNumberOfStrings(), fretboardSettings.getTuning());
		
	}

}
