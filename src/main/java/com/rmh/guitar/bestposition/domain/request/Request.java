package com.rmh.guitar.bestposition.domain.request;

import com.rmh.guitar.bestposition.domain.Tone;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class Request {

    private List<Tone> phrase;
    private Options options;
}
