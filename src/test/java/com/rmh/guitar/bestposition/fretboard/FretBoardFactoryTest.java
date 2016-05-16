package com.rmh.guitar.bestposition.fretboard;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

import com.rmh.guitar.bestposition.domain.TestUtil;
import com.rmh.guitar.bestposition.fretboard.settings.FretBoardSettings;

public class FretBoardFactoryTest {

	@Test
	public void testCreate() {
		FretBoardFactory fretBoardFactory = new FretBoardFactory();

		FretBoardSettings fretBoardSettings = TestUtil.buildFretBoardSettings();

		List<PositionPoint> positionPoints = fretBoardFactory.create(fretBoardSettings);

		assertEquals((fretBoardSettings.getNumberOfFrets() + 1) * fretBoardSettings.getNumberOfStrings(),
				positionPoints.size());
		
	}

}
