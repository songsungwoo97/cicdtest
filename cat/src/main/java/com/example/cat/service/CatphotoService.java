package com.example.cat.service;

import com.example.cat.Domain.CatImage;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.util.UriComponentsBuilder;
import reactor.core.publisher.Mono;

import java.net.URI;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CatphotoService implements CatService {

    private final WebClient webClient;

    @Value("${external-api.url}")
    private String apiUrl;

    @Value("${external-api.apiKey}")
    private String apiKey;

    @Override
    public List<CatImage> getCatImages(int imageNumber) {

        URI uri = UriComponentsBuilder
                .fromUriString(apiUrl)
                .path("/images/search")
                .queryParam("limit", imageNumber)
                .encode()
                .build()
                .toUri();

        Mono<List<CatImage>> result = webClient.get()
                .uri(uri)
                .retrieve()
                .bodyToMono(new ParameterizedTypeReference<>() {
                });

        List<CatImage> catImages = result.block();

        return catImages;
    }
}
