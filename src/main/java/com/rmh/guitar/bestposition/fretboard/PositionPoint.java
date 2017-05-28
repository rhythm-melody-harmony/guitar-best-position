package com.rmh.guitar.bestposition.fretboard;

import com.rmh.guitar.bestposition.domain.Tone;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

@Getter
@AllArgsConstructor
@EqualsAndHashCode
@ToString
public class PositionPoint {
	
	private final Tone tone;
    private final int fret;
    private final int string;

}
