
package com.example.domainservice.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;

import com.example.domainservice.model.Annonce;

import reactor.core.publisher.Flux;


@RestController
@RequestMapping("/domain/")
public class AnnonceController {

    private final WebClient webClient;

    public AnnonceController(WebClient.Builder webClientBuilder) {
        this.webClient = webClientBuilder.baseUrl("http://localhost:8080").build();
        
    }

    @GetMapping("/annonce")
    public Flux<Annonce> listerAnnonces() {
        return this.webClient.get().uri("/annonces")
                .retrieve()
                .bodyToFlux(Annonce.class);
    }
}
