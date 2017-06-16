package com.rmh.guitar.bestposition.domain.request;

import com.rmh.guitar.bestposition.domain.request.options.FretboardSettings;
import com.rmh.guitar.bestposition.domain.request.options.SearchOptions;
import com.rmh.guitar.bestposition.domain.request.options.WeightOptions;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Options {

    private FretboardSettings fretboardSettings;
    private SearchOptions searchOptions;
    private WeightOptions weightOptions;

}
