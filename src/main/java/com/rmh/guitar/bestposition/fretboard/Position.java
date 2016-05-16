package com.rmh.guitar.bestposition.fretboard;

import com.rmh.guitar.bestposition.domain.Tone;

public class Position {
	
	private PositionPoint positionPoint;
	private int finger;
	
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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + finger;
		result = prime * result + ((positionPoint == null) ? 0 : positionPoint.hashCode());
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
		Position other = (Position) obj;
		if (finger != other.finger)
			return false;
		if (positionPoint == null) {
			if (other.positionPoint != null)
				return false;
		} else if (!positionPoint.equals(other.positionPoint))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Position [positionPoint=" + positionPoint + ", finger=" + finger + "]";
	}
	
}
