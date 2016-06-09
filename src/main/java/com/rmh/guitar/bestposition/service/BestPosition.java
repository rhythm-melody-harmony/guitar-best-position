package com.rmh.guitar.bestposition.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.rmh.guitar.bestposition.algorithm.DirectedEdge;
import com.rmh.guitar.bestposition.algorithm.EdgeWeightedDigraph;
import com.rmh.guitar.bestposition.algorithm.shortestpath.Dijkstra;
import com.rmh.guitar.bestposition.domain.Tone;
import com.rmh.guitar.bestposition.fretboard.FretBoardFactory;
import com.rmh.guitar.bestposition.fretboard.Position;
import com.rmh.guitar.bestposition.fretboard.PositionPoint;
import com.rmh.guitar.bestposition.fretboard.settings.DefaultFretBoardSettingsFactory;
import com.rmh.guitar.bestposition.fretboard.settings.FretBoardSettings;
import com.rmh.guitar.bestposition.service.graph.EdgesBuilder;
import com.rmh.guitar.bestposition.service.graph.EndEdgesBuilder;
import com.rmh.guitar.bestposition.service.graph.StartEdgesBuilder;

@Component
public class BestPosition {
	
	@Autowired
	private DefaultFretBoardSettingsFactory defaultFretBoardSettingsFactory;
	
	@Autowired
	private FretBoardFactory fretBoardFactory;
	
	@Autowired
	private PhrasePositionsFinder phrasePositionsFinder;
	
	@Autowired
	private StartEdgesBuilder startEdgesBuilder;
	
	@Autowired
	private EndEdgesBuilder endEdgesBuilder;
	
	@Autowired
	private EdgesBuilder edgesBuilder;
	
	public List<Position> find(List<Tone> phrase) {
		
		int numberOfVertices = 1; //counter - number of positions. Initialized with 1
  		  						  //because we need temporary starting point

		List<DirectedEdge> edges = new ArrayList<>();
		List<Position> allPositions = new ArrayList<>();
		
		FretBoardSettings defaultFretBoardSettings = defaultFretBoardSettingsFactory.create();
		List<PositionPoint> fretBoard = fretBoardFactory.create(defaultFretBoardSettings);
		
		List<Position> tonePositions = phrasePositionsFinder.findTonePositions(fretBoard, phrase.get(0));
		List<DirectedEdge> toneEdges = startEdgesBuilder.build(tonePositions);
		edges.addAll(toneEdges);						
		numberOfVertices += tonePositions.size();
		
		List<Position> priorTonePositions = tonePositions;
		allPositions.addAll(tonePositions);
		
		for (int i = 1; i < phrase.size(); i++) {
			Tone tone = phrase.get(i);
			tonePositions = phrasePositionsFinder.findTonePositions(fretBoard, tone);
			toneEdges = edgesBuilder.build(numberOfVertices, priorTonePositions, tonePositions);
			
			edges.addAll(toneEdges);						
			numberOfVertices += tonePositions.size();
			
			priorTonePositions = tonePositions;
			allPositions.addAll(tonePositions);
		}
		
		toneEdges = endEdgesBuilder.build(numberOfVertices, priorTonePositions);
		edges.addAll(toneEdges);
		numberOfVertices++;
		
		EdgeWeightedDigraph edgeWeightedDigraph = new EdgeWeightedDigraph(numberOfVertices);
		for (DirectedEdge edge : edges) {
			edgeWeightedDigraph.addEdge(edge);
		}
		
		Dijkstra dijkstra = new Dijkstra(edgeWeightedDigraph, 0);
		Iterable<DirectedEdge> bestPath = dijkstra.pathTo(numberOfVertices - 1);
		
		List<Position> bestPositions = new ArrayList<>();
		
		for (DirectedEdge edge : bestPath) {
			int index = edge.to();
			
			if (index < allPositions.size()) {
				Position position = allPositions.get(index - 1);
				bestPositions.add(position);
			}
		}
		
		return bestPositions;
	}

}
