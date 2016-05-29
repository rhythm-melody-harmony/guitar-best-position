package com.rmh.guitar.bestposition.service.graph;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.rmh.guitar.bestposition.algorithm.DirectedEdge;
import com.rmh.guitar.bestposition.fretboard.Position;

@Component
public class EndEdgesBuilder {
	
	public List<DirectedEdge> build(int numberOfVertices, List<Position> priorTonePositions) {

		List<DirectedEdge> edges = new ArrayList<>();

		for (int i = numberOfVertices - priorTonePositions.size(); i < numberOfVertices; i++) {
			DirectedEdge edge = new DirectedEdge(i, numberOfVertices, 0.1);
			edges.add(edge);
		}

		return edges;
	}

}
