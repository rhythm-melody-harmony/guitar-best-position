package com.rmh.guitar.bestposition.domain.request.options;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SearchOptions {

    private boolean useThumbFinger;
    private boolean useOpenStrings;

}
