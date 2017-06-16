package com.rmh.guitar.bestposition.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.rmh.guitar.bestposition.domain.request.options.SearchOptions;
import org.springframework.stereotype.Component;

import com.rmh.guitar.bestposition.domain.Tone;
import com.rmh.guitar.bestposition.domain.Position;
import com.rmh.guitar.bestposition.domain.PositionPoint;

@Component
public class PhrasePositionsFinder {

    public List<Position> findTonePositions(List<PositionPoint> fretBoard, Tone tone, SearchOptions searchOptions) {

		long numberOfStrings = fretBoard.stream()
				.filter(p -> p.getFret() == 0)
				.count();
		
		List<Position> positions = fretBoard.stream()
        	.filter(p -> (searchOptions.isUseOpenStrings() || p.getFret() > 0) && tone.equals(p.getTone()))
        	.flatMap(p -> addFingersToPositionPoint(p, numberOfStrings, searchOptions.isUseThumbFinger()).stream())
        	.collect(Collectors.toList());
        	
        return positions;
    }
	
    private List<Position> addFingersToPositionPoint(PositionPoint positionPoint, long numberOfStrings, boolean isUseThumbFinger) {
        List<Position> positions = new ArrayList<>();
        
        if (positionPoint.getFret() == 0) {
            addPositionForOpenString(positions, positionPoint);
        } else {
            addPositionsWithFingers(positions, positionPoint, numberOfStrings, isUseThumbFinger);
        }
        
        return positions;
    }
    
    private void addPositionForOpenString(List<Position> positions, PositionPoint positionPoint) {
        Position position = Position.builder()
                .tone(positionPoint.getTone())
                .fret(positionPoint.getFret())
                .string(positionPoint.getString())
                .finger(-1)
                .build();
        positions.add(position);
    }
    
    private void addPositionsWithFingers(List<Position> positions, PositionPoint positionPoint, long numberOfStrings, boolean isUseThumbFinger) {
        int numberOfFingers = 4;
        if (isUseThumbFinger && numberOfStrings == positionPoint.getString()) {
            numberOfFingers = 5;
        }
        
        for (int i = 1; i <= numberOfFingers; i++) {

            Position position = Position.builder()
                    .tone(positionPoint.getTone())
                    .string(positionPoint.getString())
                    .fret(positionPoint.getFret())
                    .finger(i)
                    .build();

            positions.add(position);
        }
    }

}
