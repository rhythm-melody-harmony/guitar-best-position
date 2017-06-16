package com.rmh.guitar.bestposition.fretboard;

import static org.junit.Assert.*;

import java.util.List;

import com.rmh.guitar.bestposition.domain.PositionPoint;
import org.junit.Test;

import com.rmh.guitar.bestposition.domain.request.options.FretboardSettings;
import com.rmh.guitar.bestposition.utils.TestUtils;

public class FretboardFactoryTest {

	@Test
	public void testCreate() {
		FretboardFactory fretboardFactory = new FretboardFactory();

		FretboardSettings fretboardSettings = TestUtils.buildFretBoardSettings();

		List<PositionPoint> positionPoints = fretboardFactory.create(fretboardSettings);

		assertEquals((fretboardSettings.getNumberOfFrets() + 1) * fretboardSettings.getNumberOfStrings(),
				positionPoints.size());
		
	}

}
