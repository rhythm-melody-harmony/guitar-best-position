package com.rmh.guitar.bestposition.settings;

import com.rmh.guitar.bestposition.domain.request.options.FretboardSettings;
import com.rmh.guitar.bestposition.domain.request.options.SearchOptions;
import com.rmh.guitar.bestposition.domain.request.Options;
import com.rmh.guitar.bestposition.domain.request.options.WeightOptions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class OptionsFactory {

    private final FretBoardSettingsFactory fretBoardSettingsFactory;

    private final SearchOptionsFactory searchOptionsFactory;

    @Autowired
    public OptionsFactory(FretBoardSettingsFactory fretBoardSettingsFactory, SearchOptionsFactory searchOptionsFactory) {
        this.fretBoardSettingsFactory = fretBoardSettingsFactory;
        this.searchOptionsFactory = searchOptionsFactory;
    }

    public Options create(Options model) {

        FretboardSettings fretboardSettings = fretBoardSettingsFactory.create();
        SearchOptions searchOptions = searchOptionsFactory.createSearchOptions();
        WeightOptions weightOptions = searchOptionsFactory.createWeightOptions();

        if (model != null) {

            if (model.getFretboardSettings() != null) {
                if (model.getFretboardSettings().getNumberOfFrets() > 0) {
                    fretboardSettings.setNumberOfFrets(model.getFretboardSettings().getNumberOfFrets());
                }

                if (model.getFretboardSettings().getNumberOfStrings() > 0) {
                    fretboardSettings.setNumberOfStrings(model.getFretboardSettings().getNumberOfStrings());
                }

                if (model.getFretboardSettings().getTuning() != null && model.getFretboardSettings().getTuning().length > 0) {
                    fretboardSettings.setTuning(model.getFretboardSettings().getTuning());
                }
            }

            if (model.getSearchOptions() != null) {
                searchOptions.setUseOpenStrings(model.getSearchOptions().isUseOpenStrings());
                searchOptions.setUseThumbFinger(model.getSearchOptions().isUseThumbFinger());
            }

            if (model.getWeightOptions() != null) {
                weightOptions.setEveryPick(model.getWeightOptions().getEveryPick());
                weightOptions.setFingerDistance(model.getWeightOptions().getFingerDistance());
                weightOptions.setFingerDistanceFromIndex(model.getWeightOptions().getFingerDistanceFromIndex());
                weightOptions.setFretDistance(model.getWeightOptions().getFretDistance());
                weightOptions.setStringDistance(model.getWeightOptions().getStringDistance());
            }

        }

        return new Options(fretboardSettings, searchOptions, weightOptions);
    }

}
