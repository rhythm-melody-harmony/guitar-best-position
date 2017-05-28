package com.rmh.guitar.bestposition.fretboard.settings;

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
@TestPropertySource(properties = {"guitar.setup.number-of-frets=17", "guitar.setup.number-of-strings=4"})
public class DefaultFretBoardSettingsFactoryTest {

	@Autowired
	private DefaultFretBoardSettingsFactory defaultFretBoardSettingsFactory;

	@Test
	public void testCreate() {
		FretBoardSettings fretBoardSettings = defaultFretBoardSettingsFactory.create();

		assertNotNull(fretBoardSettings);
		assertEquals(17, fretBoardSettings.getNumberOfFrets());
		assertEquals(4, fretBoardSettings.getNumberOfStrings());
		assertNotNull(fretBoardSettings.getTuning());
	}

}
