package com.rmh.guitar.bestposition.service;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

import com.rmh.guitar.bestposition.domain.Note;
import com.rmh.guitar.bestposition.domain.Tone;
import com.rmh.guitar.bestposition.fretboard.FretBoardFactory;
import com.rmh.guitar.bestposition.fretboard.Position;
import com.rmh.guitar.bestposition.fretboard.PositionPoint;
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
		FretBoardFactory fretBoardFactory = new FretBoardFactory();
		
		List<PositionPoint> fretBoard = fretBoardFactory.create(TestUtils.buildFretBoardSettings());
		List<Position> tonePositions = phrasePositionsFinder.findTonePositions(fretBoard, new Tone(Note.C, 1));
		
		assertNotNull(tonePositions);
	}

}
