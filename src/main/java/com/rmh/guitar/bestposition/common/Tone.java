package com.rmh.guitar.bestposition.common;

public class Tone {
    
    private final Note note;
    private final int octave;
    
    public Tone(Note note, int octave) {
        this.note = note;
        this.octave = octave;
    }

    public Note getNote() {
        return note;
    }

    public int getOctave() {
        return octave;
    }

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((note == null) ? 0 : note.hashCode());
		result = prime * result + octave;
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
		Tone other = (Tone) obj;
		if (note != other.note)
			return false;
		if (octave != other.octave)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Tone [note=" + note + ", octave=" + octave + "]";
	}
    

}
