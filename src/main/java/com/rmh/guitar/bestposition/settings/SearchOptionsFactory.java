package com.rmh.guitar.bestposition.settings;

import com.rmh.guitar.bestposition.domain.request.options.SearchOptions;
import com.rmh.guitar.bestposition.domain.request.options.WeightOptions;
import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@Data
@ConfigurationProperties(prefix = "search")
public class SearchOptionsFactory {

    private SearchOptions searchOptions;
    private WeightOptions weightOptions;

    public SearchOptions createSearchOptions() {
        return new SearchOptions(searchOptions.isUseThumbFinger(), searchOptions.isUseOpenStrings());
    }

    public WeightOptions createWeightOptions() {
        return new WeightOptions(weightOptions.getEveryPick(), weightOptions.getFretDistance(), weightOptions.getStringDistance(), weightOptions.getFingerDistance(), weightOptions.getFingerDistanceFromIndex());
    }

}
