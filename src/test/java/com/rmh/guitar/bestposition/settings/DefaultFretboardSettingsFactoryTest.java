package com.rmh.guitar.bestposition.settings;

import com.rmh.guitar.bestposition.domain.request.options.FretboardSettings;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest
@TestPropertySource(properties = {"guitar.fretboard-settings.number-of-frets=17", "guitar.fretboard-settings.number-of-strings=4"})
public class DefaultFretboardSettingsFactoryTest {

	@Autowired
	private FretBoardSettingsFactory fretBoardSettingsFactory;

	@Test
	public void testCreate() {
		FretboardSettings fretboardSettings = fretBoardSettingsFactory.create();

		assertNotNull(fretboardSettings);
		assertEquals(17, fretboardSettings.getNumberOfFrets());
		assertEquals(4, fretboardSettings.getNumberOfStrings());
		assertNotNull(fretboardSettings.getTuning());
	}

}
