package com.rmh.guitar.bestposition.domain.request.options;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class WeightOptions {

    double everyPick;
    double fretDistance;
    double stringDistance;
    double fingerDistance;
    double fingerDistanceFromIndex;

}
