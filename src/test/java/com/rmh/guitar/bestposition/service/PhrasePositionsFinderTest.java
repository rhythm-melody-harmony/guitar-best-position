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

public class PhrasePositionsFinderTest {

	@Test
	public void testFindTonePositions() {
		PhrasePositionsFinder phrasePositionsFinder = new PhrasePositionsFinder();
		FretBoardFactory fretBoardFactory = new FretBoardFactory();
		
		List<PositionPoint> fretBoard = fretBoardFactory.create(TestUtils.buildFretBoardSettings());
		List<Position> tonePositions = phrasePositionsFinder.findTonePositions(fretBoard, new Tone(Note.C, 1));
		
		assertNotNull(tonePositions);
	}

}
