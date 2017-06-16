package com.rmh.guitar.bestposition.domain;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Position {

	private Tone tone;
	private int fret;
	private int string;
	private int finger;
	private double weight;

	public Position(PositionPoint positionPoint, int finger) {

		this.tone = positionPoint.getTone();
		this.fret = positionPoint.getFret();
		this.string = positionPoint.getString();
		this.finger = finger;

	}

}
