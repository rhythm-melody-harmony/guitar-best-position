package com.rmh.guitar.bestposition.service.graph;

import java.math.BigDecimal;
import java.math.RoundingMode;

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
									) + toPosition.getFinger() * 0.1;

		double weight = fretWeight
				+ stringWeight
				+ fingerWeight;

		return round(weight + 0.1, 2);
	}
	
	private double round(double value, int places) {
	    if (places < 0) throw new IllegalArgumentException();

	    BigDecimal bd = new BigDecimal(value);
	    bd = bd.setScale(places, RoundingMode.HALF_UP);
	    return bd.doubleValue();
	}

}
