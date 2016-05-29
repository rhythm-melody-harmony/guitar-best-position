package com.rmh.guitar.bestposition.service.graph;

import org.springframework.stereotype.Component;

import com.rmh.guitar.bestposition.fretboard.Position;

@Component
public class EdgeWeightCalculator {

	public double calculate(Position fromPosition, Position toPosition) {
		
		double fretWeight = Math.abs(toPosition.getFret() - fromPosition.getFret());
		double stringWeight = Math.abs(toPosition.getString() - fromPosition.getString());
		double fingerWeight = Math.abs(
									  (toPosition.getFret() - fromPosition.getFret())
									- (toPosition.getFinger() - fromPosition.getFinger())
									);

		double weight = fretWeight
				+ stringWeight
				+ fingerWeight;

		return weight + 0.1;
	}

}
