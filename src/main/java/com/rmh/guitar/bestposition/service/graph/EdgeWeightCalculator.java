package com.rmh.guitar.bestposition.service.graph;

import java.math.BigDecimal;
import java.math.RoundingMode;

import com.rmh.guitar.bestposition.domain.request.options.WeightOptions;
import org.springframework.stereotype.Component;

import com.rmh.guitar.bestposition.domain.Position;

@Component
public class EdgeWeightCalculator {

	public double calculate(Position fromPosition, Position toPosition, WeightOptions weightOptions) {
		
		double fretWeight = Math.abs(toPosition.getFret() - fromPosition.getFret()) * weightOptions.getFretDistance();
		double stringWeight = Math.abs(toPosition.getString() - fromPosition.getString()) * weightOptions.getStringDistance();
		double fingerWeight = Math.abs(
									  (toPosition.getFret() - fromPosition.getFret())
									- (toPosition.getFinger() - fromPosition.getFinger())
									) * weightOptions.getFingerDistance() + toPosition.getFinger() * weightOptions.getFingerDistanceFromIndex();

		double weight = fretWeight
				+ stringWeight
				+ fingerWeight;

		return round(weight + weightOptions.getEveryPick());
	}
	
	private double round(double value) {
	    BigDecimal bd = new BigDecimal(value);
	    bd = bd.setScale(2, RoundingMode.HALF_UP);
	    return bd.doubleValue();
	}

}
