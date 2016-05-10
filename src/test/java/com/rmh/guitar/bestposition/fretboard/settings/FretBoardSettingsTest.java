package com.rmh.guitar.bestposition.fretboard.settings;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.mockito.Mock;

import com.rmh.guitar.bestposition.common.Tone;

public class FretBoardSettingsTest {
	
	@Mock
	private Tone[] tuning;

	@Test
	public void testFretBoardSettings() {
		FretBoardSettings fretBoardSettings = new FretBoardSettings(21, 6, tuning );
		
		assertEquals(21, fretBoardSettings.getNumberOfFrets());
		assertEquals(6, fretBoardSettings.getNumberOfStrings());
		assertArrayEquals(tuning, fretBoardSettings.getTuning());
	}

}
