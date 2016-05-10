package com.rmh.guitar.bestposition.fretboard.settings;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;

public class DefaultFretBoardSettingsFactoryTest {

	@Test
	public void testCreate() {
		DefaultFretBoardSettingsFactory defaultFretBoardSettingsFactory = new DefaultFretBoardSettingsFactory();
		
		FretBoardSettings fretBoardSettings = defaultFretBoardSettingsFactory.create();
		
		assertNotNull(fretBoardSettings);
		assertNotNull(fretBoardSettings.getNumberOfFrets());
		assertNotNull(fretBoardSettings.getNumberOfStrings());
		assertNotNull(fretBoardSettings.getTuning());
	}

}
