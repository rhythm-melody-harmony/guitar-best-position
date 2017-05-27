package com.rmh.guitar.bestposition.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public enum Note {
	
	A("A"), 
    ASharp("A#"), 
    B("B"),
    C("C"), 
    CSharp("C#"), 
    D("D"), 
    DSharp("D#"), 
    E("E"), 
    F("F"), 
    FSharp("F#"), 
    G("G"), 
    GSharp("G#");
        
    private String label;
    
    Note(String label) {
        this.label = label;
    }
    
    @JsonCreator
    public static Note fromString(@JsonProperty("note") String label) {
        
        for (Note note : Note.values()) {
            if (note.label.equals(label)) {
                return note;
            }
        }
        
        throw new IllegalArgumentException();
    }
    
    @Override
    @JsonValue
    public String toString() {
        return label;
    }

}
