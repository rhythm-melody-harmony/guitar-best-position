package com.rmh.guitar.bestposition.fretboard;

import com.rmh.guitar.bestposition.common.Tone;

public class PositionPoint {
	
	private final Tone tone;
    private final int fret;
    private final int string;
    
    public PositionPoint(Tone tone, int fret, int string) {
        this.tone = tone;
        this.fret = fret;
        this.string = string;
    }

    public Tone getTone() {
        return tone;
    }
    
    public int getFret() {
        return fret;
    }

    public int getString() {
        return string;
    }

    @Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + fret;
		result = prime * result + string;
		result = prime * result + ((tone == null) ? 0 : tone.hashCode());
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
		PositionPoint other = (PositionPoint) obj;
		if (fret != other.fret)
			return false;
		if (string != other.string)
			return false;
		if (tone == null) {
			if (other.tone != null)
				return false;
		} else if (!tone.equals(other.tone))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "PositionPoint [tone=" + tone + ", fret=" + fret + ", string=" + string + "]";
	}
	

}
