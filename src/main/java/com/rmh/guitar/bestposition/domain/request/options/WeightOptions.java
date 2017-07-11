package com.rmh.guitar.bestposition.domain.request.options;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class WeightOptions {

    double everyPick;
    double fretDistance;
    double stringDistance;
    double fingerDistance;
    double fingerDistanceFromIndex;
    double consecutiveSameFinger;
    double consecutiveChangeFinger;
    double consecutiveChangeString;
    double moving;
    double consecutiveMoving;

}
