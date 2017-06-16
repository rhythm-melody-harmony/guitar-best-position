package com.rmh.guitar.bestposition.service.graph;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.rmh.guitar.bestposition.algorithm.DirectedEdge;
import com.rmh.guitar.bestposition.domain.Position;

@Component
public class StartEdgesBuilder {
	
	public List<DirectedEdge> build(List<Position> tonePositions) {
		
		List<DirectedEdge> edges = new ArrayList<>();
		
		for (int i = 0; i < tonePositions.size(); i++) {
			DirectedEdge edge = new DirectedEdge(0, i + 1, 0.1);
			edges.add(edge);
		}
		
		return edges;
		
	}

}
