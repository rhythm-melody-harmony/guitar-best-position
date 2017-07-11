package com.rmh.guitar.bestposition.controller;

import com.rmh.guitar.bestposition.domain.request.Options;
import com.rmh.guitar.bestposition.settings.OptionsFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/options")
public class OptionsController {

    @Autowired
    private OptionsFactory optionsFactory;

    @RequestMapping("/default")
    public Options loadDefault() {

        Options options = optionsFactory.createDefault();

        return options;

    }

}
