package com.rmh.guitar.bestposition.fretboard.settings;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@Data
@ConfigurationProperties(prefix = "search")
public class SearchSettings {

    private boolean useThumbFinger = false;
    private boolean useOpenStrings = false;

}
