package com.rmh.guitar.bestposition.service.graph;

import static org.junit.Assert.assertEquals;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.when;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.rmh.guitar.bestposition.algorithm.DirectedEdge;
import com.rmh.guitar.bestposition.domain.Note;
import com.rmh.guitar.bestposition.domain.Tone;
import com.rmh.guitar.bestposition.fretboard.Position;
import com.rmh.guitar.bestposition.utils.TestUtils;

public class EdgesBuilderTest {

	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@InjectMocks
	private EdgesBuilder edgesBuilder;
	
	@Mock
	private EdgeWeightCalculator edgeWeightCalculator;
	
	@Before
	public void setUp() {
		MockitoAnnotations.initMocks(this);
		
		when(edgeWeightCalculator.calculate(any(Position.class), any(Position.class))).thenReturn(1d);
	}

	@Test
	public void testBuild() {
		
		List<Position> priorTonePositions = TestUtils.buildTestTonePositions(new Tone(Note.C, 1), 3, 5);
		List<Position> tonePositions = TestUtils.buildTestTonePositions(new Tone(Note.D, 1), 5, 5);

		int numberOfVertices = priorTonePositions.size() + 1;
		List<DirectedEdge> edges = edgesBuilder.build(numberOfVertices, priorTonePositions, tonePositions);

		assertEquals(16, priorTonePositions.size() * tonePositions.size());

		logger.info("Test OK, {} actual edges: {}", edges.size(), edges);
	}

}
