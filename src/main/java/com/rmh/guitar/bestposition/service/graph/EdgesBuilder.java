package com.rmh.guitar.bestposition.service.graph;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.rmh.guitar.bestposition.algorithm.DirectedEdge;
import com.rmh.guitar.bestposition.fretboard.Position;

@Component
public class EdgesBuilder {

	@Autowired
	private EdgeWeightCalculator edgeWeightCalculator;

	public List<DirectedEdge> build(int numberOfVertices, List<Position> priorTonePositions,
			List<Position> tonePositions) {

		List<DirectedEdge> edges = new ArrayList<>();

		for (int i = 0; i < priorTonePositions.size(); i++) {
			for (int j = 0; j < tonePositions.size(); j++) {

				double weight = edgeWeightCalculator.calculate(priorTonePositions.get(i), tonePositions.get(j));

				int fromIndex = numberOfVertices - priorTonePositions.size() + i;
				DirectedEdge edge = new DirectedEdge(fromIndex, numberOfVertices + j, weight);
				edges.add(edge);
			}
		}

		return edges;
	}

}
