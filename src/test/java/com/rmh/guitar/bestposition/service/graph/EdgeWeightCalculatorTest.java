package com.rmh.guitar.bestposition.service.graph;

import com.rmh.guitar.bestposition.domain.Note;
import com.rmh.guitar.bestposition.domain.Position;
import com.rmh.guitar.bestposition.domain.PositionPoint;
import com.rmh.guitar.bestposition.domain.Tone;
import com.rmh.guitar.bestposition.settings.SearchOptionsFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
public class EdgeWeightCalculatorTest {
	
	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private SearchOptionsFactory searchOptionsFactory;

	@Test
	public void testCalculateSamePosition() {
		
		EdgeWeightCalculator edgeWeightCalculator = new EdgeWeightCalculator();
		
		PositionPoint positionPoint = new PositionPoint(new Tone(Note.C, 1), 3, 5);
		Position fromPosition = new Position(positionPoint, 1);
		
		positionPoint = new PositionPoint(new Tone(Note.C, 1), 3, 5);
		Position toPosition = new Position(positionPoint, 1);
		
		double weight = edgeWeightCalculator.calculate(fromPosition, toPosition, searchOptionsFactory.getWeightOptions());
		
		assertEquals(Double.valueOf(0.2d), Double.valueOf(weight));
		
		logger.info("Test OK. Actual weight: {}", weight);
	}
	
	@Test
	public void testCalculateSameStringDiffFretSameFinger() {
		
		EdgeWeightCalculator edgeWeightCalculator = new EdgeWeightCalculator();
		
		PositionPoint positionPoint = new PositionPoint(new Tone(Note.C, 1), 3, 5);
		Position fromPosition = new Position(positionPoint, 1);
		
		positionPoint = new PositionPoint(new Tone(Note.D, 1), 5, 5);
		Position toPosition = new Position(positionPoint, 1);
		
		double weight = edgeWeightCalculator.calculate(fromPosition, toPosition, searchOptionsFactory.getWeightOptions());
		
		assertEquals(Double.valueOf(4.2d), Double.valueOf(weight));
		
		logger.info("Test OK. Actual weight: {}", weight);
	}
	
	@Test
	public void testCalculateSameStringDiffFretDiffFinger() {
		
		EdgeWeightCalculator edgeWeightCalculator = new EdgeWeightCalculator();
		
		PositionPoint positionPoint = new PositionPoint(new Tone(Note.C, 1), 3, 5);
		Position fromPosition = new Position(positionPoint, 1);
		
		positionPoint = new PositionPoint(new Tone(Note.D, 1), 5, 5);
		Position toPosition = new Position(positionPoint, 3);
		
		double weight = edgeWeightCalculator.calculate(fromPosition, toPosition, searchOptionsFactory.getWeightOptions());
		
		assertEquals(Double.valueOf(2.4d), Double.valueOf(weight));
		
		logger.info("Test OK. Actual weight: {}", weight);
	}
	
	@Test
	public void testCalculateDiffStringDiffFretDiffFinger() {
		
		EdgeWeightCalculator edgeWeightCalculator = new EdgeWeightCalculator();
		
		PositionPoint positionPoint = new PositionPoint(new Tone(Note.C, 1), 3, 5);
		Position fromPosition = new Position(positionPoint, 2);
		
		positionPoint = new PositionPoint(new Tone(Note.E, 1), 2, 4);
		Position toPosition = new Position(positionPoint, 1);
		
		double weight = edgeWeightCalculator.calculate(fromPosition, toPosition, searchOptionsFactory.getWeightOptions());
		
		assertEquals(Double.valueOf(2.2d), Double.valueOf(weight));
		
		logger.info("Test OK. Actual weight: {}", weight);
	}
	
	@Test
	public void testCalculateDiffStringDiffFretSameFinger() {
		
		EdgeWeightCalculator edgeWeightCalculator = new EdgeWeightCalculator();
		
		PositionPoint positionPoint = new PositionPoint(new Tone(Note.C, 1), 3, 5);
		Position fromPosition = new Position(positionPoint, 1);
		
		positionPoint = new PositionPoint(new Tone(Note.E, 1), 2, 4);
		Position toPosition = new Position(positionPoint, 1);
		
		double weight = edgeWeightCalculator.calculate(fromPosition, toPosition, searchOptionsFactory.getWeightOptions());
		
		assertEquals(Double.valueOf(3.2d), Double.valueOf(weight));
		
		logger.info("Test OK. Actual weight: {}", weight);
	}
	
	@Test
	public void testCalculateSameStringDiffFretDiffFingerMovePosition() {
		
		EdgeWeightCalculator edgeWeightCalculator = new EdgeWeightCalculator();
		
		PositionPoint positionPoint = new PositionPoint(new Tone(Note.C, 1), 3, 5);
		Position fromPosition = new Position(positionPoint, 3);
		
		positionPoint = new PositionPoint(new Tone(Note.D, 1), 5, 5);
		Position toPosition = new Position(positionPoint, 1);
		
		double weight = edgeWeightCalculator.calculate(fromPosition, toPosition, searchOptionsFactory.getWeightOptions());
		
		assertEquals(Double.valueOf(6.2d), Double.valueOf(weight));
		
		logger.info("Test OK. Actual weight: {}", weight);
	}
	
	@Test
	public void testCalculateReal1() {
		
		EdgeWeightCalculator edgeWeightCalculator = new EdgeWeightCalculator();
		
		PositionPoint positionPoint = new PositionPoint(new Tone(Note.C, 1), 5, 5);
		Position fromPosition = new Position(positionPoint, 1);
		
		positionPoint = new PositionPoint(new Tone(Note.D, 1), 7, 5);
		Position toPosition = new Position(positionPoint, 1);
		
		double weight = edgeWeightCalculator.calculate(fromPosition, toPosition, searchOptionsFactory.getWeightOptions());
		
		assertEquals(Double.valueOf(4.2d), Double.valueOf(weight));
		
		logger.info("Test OK. Actual weight: {}", weight);
	}
	
	@Test
	public void testCalculateReal2() {
		
		EdgeWeightCalculator edgeWeightCalculator = new EdgeWeightCalculator();
		
		PositionPoint positionPoint = new PositionPoint(new Tone(Note.C, 1), 5, 5);
		Position fromPosition = new Position(positionPoint, 1);
		
		positionPoint = new PositionPoint(new Tone(Note.D, 1), 7, 5);
		Position toPosition = new Position(positionPoint, 3);
		
		double weight = edgeWeightCalculator.calculate(fromPosition, toPosition, searchOptionsFactory.getWeightOptions());
		
		assertEquals(Double.valueOf(2.4d), Double.valueOf(weight));
		
		logger.info("Test OK. Actual weight: {}", weight);
	}

}
