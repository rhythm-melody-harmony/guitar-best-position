package com.rmh.guitar.bestposition.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.rmh.guitar.bestposition.fretboard.settings.SearchSettings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.rmh.guitar.bestposition.domain.Tone;
import com.rmh.guitar.bestposition.fretboard.Position;
import com.rmh.guitar.bestposition.fretboard.PositionPoint;

@Component
public class PhrasePositionsFinder {

    private final SearchSettings searchSettings;

    @Autowired
    public PhrasePositionsFinder(SearchSettings searchSettings) {
        this.searchSettings = searchSettings;
    }

    public List<Position> findTonePositions(List<PositionPoint> fretBoard, Tone tone) {
		
		long numberOfStrings = fretBoard.stream()
				.filter(p -> p.getFret() == 0)
				.count();
		
		List<Position> positions = fretBoard.stream()
        	.filter(p -> (searchSettings.isUseOpenStrings() || p.getFret() > 0) && tone.equals(p.getTone()))
        	.flatMap(p -> addFingersToPositionPoint(p, numberOfStrings).stream())
        	.collect(Collectors.toList());
        	
        return positions;
    }
	
    private List<Position> addFingersToPositionPoint(PositionPoint positionPoint, long numberOfStrings) {
        List<Position> positions = new ArrayList<>();
        
        if (positionPoint.getFret() == 0) {
            addPositionForOpenString(positions, positionPoint);
        } else {
            addPositionsWithFingers(positions, positionPoint, numberOfStrings);
        }
        
        return positions;
    }
    
    private void addPositionForOpenString(List<Position> positions, PositionPoint positionPoint) {
        Position position = new Position(positionPoint, -1);
        positions.add(position);
    }
    
    private void addPositionsWithFingers(List<Position> positions, PositionPoint positionPoint, long numberOfStrings) {
        int numberOfFingers = 4;
        if (searchSettings.isUseThumbFinger() && numberOfStrings == positionPoint.getString()) {
            numberOfFingers = 5;
        }
        
        for (int i = 1; i <= numberOfFingers; i++) {
            Position position = new Position(positionPoint, i);
            positions.add(position);
        }
    }

}
