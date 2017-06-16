package com.rmh.guitar.bestposition.service.graph;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.rmh.guitar.bestposition.algorithm.DirectedEdge;
import com.rmh.guitar.bestposition.domain.Note;
import com.rmh.guitar.bestposition.domain.Tone;
import com.rmh.guitar.bestposition.domain.Position;
import com.rmh.guitar.bestposition.utils.TestUtils;

public class EndEdgesBuilderTest {
	
	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	@Test
	public void testBuild() {
		EndEdgesBuilder endEdgesBuilder = new EndEdgesBuilder();
		List<Position> priorTonePositions = TestUtils.buildTestTonePositions(new Tone(Note.C, 1), 3, 5);
		int numberOfVertices = priorTonePositions.size() + 1;
		
		List<DirectedEdge> edges = endEdgesBuilder.build(numberOfVertices, priorTonePositions);
		
		assertEquals(priorTonePositions.size(), edges.size());
		
		for (int i = 0; i < priorTonePositions.size(); i++) {
			assertEquals(i+1, edges.get(i).from());
			assertEquals(numberOfVertices, edges.get(i).to());
			assertEquals(Double.valueOf(0.1d), Double.valueOf(edges.get(i).weight()));
		}
		
		logger.info("Test OK, actual edges: {}", edges);
	}

}
