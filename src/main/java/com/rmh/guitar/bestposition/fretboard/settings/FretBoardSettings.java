package com.rmh.guitar.bestposition.fretboard.settings;

import java.util.Arrays;

import com.rmh.guitar.bestposition.domain.Tone;

public class FretBoardSettings {
	
	private final int numberOfFrets;
    private final int numberOfStrings;
    private final Tone[] tuning;
    
	public FretBoardSettings(int numberOfFrets, int numberOfStrings, Tone[] tuning) {
		this.numberOfFrets = numberOfFrets;
		this.numberOfStrings = numberOfStrings;
		this.tuning = tuning;
	}

	public int getNumberOfFrets() {
		return numberOfFrets;
	}

	public int getNumberOfStrings() {
		return numberOfStrings;
	}

	public Tone[] getTuning() {
		return tuning;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + numberOfFrets;
		result = prime * result + numberOfStrings;
		result = prime * result + Arrays.hashCode(tuning);
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		FretBoardSettings other = (FretBoardSettings) obj;
		if (numberOfFrets != other.numberOfFrets)
			return false;
		if (numberOfStrings != other.numberOfStrings)
			return false;
		if (!Arrays.equals(tuning, other.tuning))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "FretBoardSettings [numberOfFrets=" + numberOfFrets + ", numberOfStrings=" + numberOfStrings
				+ ", tuning=" + Arrays.toString(tuning) + "]";
	}
    
}
