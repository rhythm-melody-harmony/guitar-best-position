package com.rmh.guitar.bestposition.settings;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

import com.rmh.guitar.bestposition.domain.request.options.FretboardSettings;
import org.junit.Test;
import org.mockito.Mock;

import com.rmh.guitar.bestposition.domain.Tone;

public class FretboardSettingsTest {
	
	@Mock
	private Tone[] tuning;

	@Test
	public void testFretBoardSettings() {
		FretboardSettings fretboardSettings = new FretboardSettings(21, 6, tuning );
		
		assertEquals(21, fretboardSettings.getNumberOfFrets());
		assertEquals(6, fretboardSettings.getNumberOfStrings());
		assertArrayEquals(tuning, fretboardSettings.getTuning());
	}

}
