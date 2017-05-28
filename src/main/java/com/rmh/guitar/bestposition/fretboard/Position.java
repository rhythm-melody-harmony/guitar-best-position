package com.rmh.guitar.bestposition.fretboard;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.rmh.guitar.bestposition.domain.Tone;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@EqualsAndHashCode
@ToString
public class Position {
	
	@JsonIgnore
	private PositionPoint positionPoint;
	private int finger;
	private double weight;
	
	public Position(PositionPoint positionPoint, int finger) {
		this.positionPoint = positionPoint;
		this.finger = finger;
	}

	public PositionPoint getPositionPoint() {
		return positionPoint;
	}

	public int getFinger() {
		return finger;
	}
	
	public Tone getTone() {
		if (positionPoint != null) {
			return positionPoint.getTone();
		}
		
		return null;
	}
	
	public int getFret() {
		if (positionPoint != null) {
			return positionPoint.getFret();
		}
		
		return -1;
	}
	
	public int getString() {
		if (positionPoint != null) {
			return positionPoint.getString();
		}
		
		return -1;
	}
	
	public double getWeight() {
		return weight;
	}

	public void setWeight(double weight) {
		this.weight = weight;
	}

}
