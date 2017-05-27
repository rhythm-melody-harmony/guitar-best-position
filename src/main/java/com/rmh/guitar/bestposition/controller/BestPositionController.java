package com.rmh.guitar.bestposition.controller;

import java.util.Arrays;
import java.util.List;

import com.rmh.guitar.bestposition.service.BestPosition;
import com.rmh.guitar.bestposition.service.RawToToneConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.rmh.guitar.bestposition.domain.Tone;
import com.rmh.guitar.bestposition.fretboard.Position;

@RestController
@RequestMapping(path = "/bestposition")
public class BestPositionController {

	@Autowired
	private BestPosition bestPosition;

	@Autowired
	private RawToToneConverter rawToToneConverter;

	@RequestMapping(method = RequestMethod.POST, path = "/find")
	public List<Position> find(@RequestBody List<Tone> phrase) {

		return bestPosition.find(phrase);

	}

	/*
	 * method that accept string list for test purposes
	 */
	@RequestMapping(method = RequestMethod.POST, path = "/findtxt", consumes = MediaType.TEXT_PLAIN_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Position> findFromTxt(@RequestBody String[] rawPhrase) {

		List<Tone> phrase = rawToToneConverter.convert(Arrays.asList(rawPhrase));

		return bestPosition.find(phrase);

	}

}
