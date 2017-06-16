package com.rmh.guitar.bestposition.controller;

import java.util.Arrays;
import java.util.List;

import com.rmh.guitar.bestposition.domain.request.Request;
import com.rmh.guitar.bestposition.service.BestPosition;
import com.rmh.guitar.bestposition.service.RawToToneConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.rmh.guitar.bestposition.domain.Tone;
import com.rmh.guitar.bestposition.domain.Position;

@RestController
@RequestMapping(path = "/bestposition")
public class BestPositionController {

	private final BestPosition bestPosition;

	private final RawToToneConverter rawToToneConverter;

	@Autowired
	public BestPositionController(BestPosition bestPosition, RawToToneConverter rawToToneConverter) {
		this.bestPosition = bestPosition;
		this.rawToToneConverter = rawToToneConverter;
	}

	@RequestMapping(method = RequestMethod.POST, path = "/find")
	public List<Position> find(@RequestBody Request request) {

		return bestPosition.find(request);

	}

	/*
	 * method that accept string list for test purposes
	 */
	@RequestMapping(method = RequestMethod.POST, path = "/findtxt", consumes = MediaType.TEXT_PLAIN_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Position> findFromTxt(@RequestBody String[] rawPhrase) {

		List<Tone> phrase = rawToToneConverter.convert(Arrays.asList(rawPhrase));
		Request request = Request.builder()
				.phrase(phrase)
				.build();

		return bestPosition.find(request);

	}

}
