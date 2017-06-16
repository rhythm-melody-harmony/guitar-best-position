package com.rmh.guitar.bestposition.domain.request.options;

import com.rmh.guitar.bestposition.domain.Tone;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FretboardSettings {

	private int numberOfFrets;
    private int numberOfStrings;
    private Tone[] tuning;

}
