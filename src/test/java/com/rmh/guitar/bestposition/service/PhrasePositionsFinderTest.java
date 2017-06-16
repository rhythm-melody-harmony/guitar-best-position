package com.rmh.guitar.bestposition.service;

import static org.junit.Assert.*;

import java.util.List;

import com.rmh.guitar.bestposition.domain.*;
import com.rmh.guitar.bestposition.domain.request.options.SearchOptions;
import org.junit.Test;

import com.rmh.guitar.bestposition.fretboard.FretboardFactory;
import com.rmh.guitar.bestposition.utils.TestUtils;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PhrasePositionsFinderTest {

	@Autowired
	private PhrasePositionsFinder phrasePositionsFinder;

	@Test
	public void testFindTonePositions() {
		FretboardFactory fretboardFactory = new FretboardFactory();

		SearchOptions searchOptions = new SearchOptions(false, false);
		
		List<PositionPoint> fretBoard = fretboardFactory.create(TestUtils.buildFretBoardSettings());
		List<Position> tonePositions = phrasePositionsFinder.findTonePositions(fretBoard, new Tone(Note.C, 1), searchOptions);
		
		assertNotNull(tonePositions);
	}

}
