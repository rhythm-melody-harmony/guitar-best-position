package com.rmh.guitar.bestposition.domain;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Tone {

    private Note note;
    private int octave;
    
}
