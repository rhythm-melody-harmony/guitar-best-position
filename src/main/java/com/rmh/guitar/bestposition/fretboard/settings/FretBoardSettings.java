package com.rmh.guitar.bestposition.fretboard.settings;

import java.util.Arrays;

import com.rmh.guitar.bestposition.domain.Tone;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class FretBoardSettings {

	private final int numberOfFrets;
    private final int numberOfStrings;
    private final Tone[] tuning;

}
