package com.rmh.guitar.bestposition.service.graph;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.rmh.guitar.bestposition.algorithm.DirectedEdge;
import com.rmh.guitar.bestposition.domain.Note;
import com.rmh.guitar.bestposition.domain.Tone;
import com.rmh.guitar.bestposition.fretboard.Position;
import com.rmh.guitar.bestposition.utils.TestUtils;

@Component
public class StartEdgesBuilderTest {
	
	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	@Test
	public void testBuild() {
		StartEdgesBuilder startEdgesBuilder = new StartEdgesBuilder();		
		List<Position> tonePositions = TestUtils.buildTestTonePositions(new Tone(Note.C, 1), 3, 5);
		
		List<DirectedEdge> edges = startEdgesBuilder.build(tonePositions);
		
		assertEquals(tonePositions.size(), edges.size());
		
		for (int i = 0; i < tonePositions.size(); i++) {
			assertEquals(0, edges.get(i).from());
			assertEquals(i+1, edges.get(i).to());
			assertEquals(Double.valueOf(0.1d), Double.valueOf(edges.get(i).weight()));
		}
		
		logger.info("Test OK, actual edges: {}", edges);
		
	}
	
}
