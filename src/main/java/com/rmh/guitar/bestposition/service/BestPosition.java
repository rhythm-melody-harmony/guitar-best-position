package com.rmh.guitar.bestposition.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.rmh.guitar.bestposition.domain.Tone;
import com.rmh.guitar.bestposition.fretboard.FretBoardFactory;
import com.rmh.guitar.bestposition.fretboard.Position;
import com.rmh.guitar.bestposition.fretboard.PositionPoint;
import com.rmh.guitar.bestposition.fretboard.settings.DefaultFretBoardSettingsFactory;
import com.rmh.guitar.bestposition.fretboard.settings.FretBoardSettings;

@Component
public class BestPosition {
	
	@Autowired
	private DefaultFretBoardSettingsFactory defaultFretBoardSettingsFactory;
	
	@Autowired
	private FretBoardFactory fretBoardFactory;
	
	public List<Position> find(List<Tone> phrase) {
		
		FretBoardSettings defaultFretBoardSettings = defaultFretBoardSettingsFactory.create();
		
		List<PositionPoint> fretBoard = fretBoardFactory.create(defaultFretBoardSettings);
		
		List<Position> bestPositions = new ArrayList<>();
		
		return bestPositions;
	}

}
