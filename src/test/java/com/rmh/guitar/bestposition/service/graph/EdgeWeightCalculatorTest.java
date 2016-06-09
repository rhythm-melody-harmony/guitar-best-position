package com.rmh.guitar.bestposition.service.graph;

import static org.junit.Assert.*;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.rmh.guitar.bestposition.domain.Note;
import com.rmh.guitar.bestposition.domain.Tone;
import com.rmh.guitar.bestposition.fretboard.Position;
import com.rmh.guitar.bestposition.fretboard.PositionPoint;

public class EdgeWeightCalculatorTest {
	
	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	@Test
	public void testCalculateSamePositon() {
		
		EdgeWeightCalculator edgeWeightCalculator = new EdgeWeightCalculator();
		
		PositionPoint positionPoint = new PositionPoint(new Tone(Note.C, 1), 3, 5);
		Position fromPosition = new Position(positionPoint, 1);
		
		positionPoint = new PositionPoint(new Tone(Note.C, 1), 3, 5);
		Position toPosition = new Position(positionPoint, 1);
		
		double weight = edgeWeightCalculator.calculate(fromPosition, toPosition);
		
		assertEquals(Double.valueOf(0.1d), Double.valueOf(weight));
		
		logger.info("Test OK. Actual weight: {}", weight);
	}
	
	@Test
	public void testCalculateSameStringDiffFretSameFinger() {
		
		EdgeWeightCalculator edgeWeightCalculator = new EdgeWeightCalculator();
		
		PositionPoint positionPoint = new PositionPoint(new Tone(Note.C, 1), 3, 5);
		Position fromPosition = new Position(positionPoint, 1);
		
		positionPoint = new PositionPoint(new Tone(Note.D, 1), 5, 5);
		Position toPosition = new Position(positionPoint, 1);
		
		double weight = edgeWeightCalculator.calculate(fromPosition, toPosition);
		
		assertEquals(Double.valueOf(4.1d), Double.valueOf(weight));
		
		logger.info("Test OK. Actual weight: {}", weight);
	}
	
	@Test
	public void testCalculateSameStringDiffFretDiffFinger() {
		
		EdgeWeightCalculator edgeWeightCalculator = new EdgeWeightCalculator();
		
		PositionPoint positionPoint = new PositionPoint(new Tone(Note.C, 1), 3, 5);
		Position fromPosition = new Position(positionPoint, 1);
		
		positionPoint = new PositionPoint(new Tone(Note.D, 1), 5, 5);
		Position toPosition = new Position(positionPoint, 3);
		
		double weight = edgeWeightCalculator.calculate(fromPosition, toPosition);
		
		assertEquals(Double.valueOf(2.1d), Double.valueOf(weight));
		
		logger.info("Test OK. Actual weight: {}", weight);
	}
	
	@Test
	public void testCalculateDiffStringDiffFretDiffFinger() {
		
		EdgeWeightCalculator edgeWeightCalculator = new EdgeWeightCalculator();
		
		PositionPoint positionPoint = new PositionPoint(new Tone(Note.C, 1), 3, 5);
		Position fromPosition = new Position(positionPoint, 2);
		
		positionPoint = new PositionPoint(new Tone(Note.E, 1), 2, 4);
		Position toPosition = new Position(positionPoint, 1);
		
		double weight = edgeWeightCalculator.calculate(fromPosition, toPosition);
		
		assertEquals(Double.valueOf(2.1d), Double.valueOf(weight));
		
		logger.info("Test OK. Actual weight: {}", weight);
	}
	
	@Test
	public void testCalculateDiffStringDiffFretSameFinger() {
		
		EdgeWeightCalculator edgeWeightCalculator = new EdgeWeightCalculator();
		
		PositionPoint positionPoint = new PositionPoint(new Tone(Note.C, 1), 3, 5);
		Position fromPosition = new Position(positionPoint, 1);
		
		positionPoint = new PositionPoint(new Tone(Note.E, 1), 2, 4);
		Position toPosition = new Position(positionPoint, 1);
		
		double weight = edgeWeightCalculator.calculate(fromPosition, toPosition);
		
		assertEquals(Double.valueOf(3.1d), Double.valueOf(weight));
		
		logger.info("Test OK. Actual weight: {}", weight);
	}
	
	@Test
	public void testCalculateSameStringDiffFretDiffFingerMovePositon() {
		
		EdgeWeightCalculator edgeWeightCalculator = new EdgeWeightCalculator();
		
		PositionPoint positionPoint = new PositionPoint(new Tone(Note.C, 1), 3, 5);
		Position fromPosition = new Position(positionPoint, 3);
		
		positionPoint = new PositionPoint(new Tone(Note.D, 1), 5, 5);
		Position toPosition = new Position(positionPoint, 1);
		
		double weight = edgeWeightCalculator.calculate(fromPosition, toPosition);
		
		assertEquals(Double.valueOf(6.1d), Double.valueOf(weight));
		
		logger.info("Test OK. Actual weight: {}", weight);
	}

}
