package com.rmh.guitar.bestposition.controller;

import com.rmh.guitar.bestposition.domain.Note;
import com.rmh.guitar.bestposition.domain.Tone;
import com.rmh.guitar.bestposition.domain.Position;
import com.rmh.guitar.bestposition.domain.request.Request;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@Slf4j
public class BestPositionControllerTest {

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    public void find() throws Exception {

        List<Tone> tones = new ArrayList<>();
        Request request = Request.builder().phrase(tones).build();

        tones.add(new Tone(Note.E, 0));
        tones.add(new Tone(Note.B, 0));

        ResponseEntity<Position[]> responseEntity = restTemplate.postForEntity("/bestposition/find", request, Position[].class);

        Position[] positions = responseEntity.getBody();

        log.info("find positions: {}", Arrays.asList(positions));

    }

    @Test
    public void findFromTxt() throws Exception {
    }

}