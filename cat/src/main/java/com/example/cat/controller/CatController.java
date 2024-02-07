package com.example.cat.controller;

import com.example.cat.Domain.CatImage;
import com.example.cat.service.CatphotoService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//@RestController
@Slf4j
@RestController
@RequiredArgsConstructor
public class CatController {

    final private CatphotoService catService;

    @GetMapping("/catImages/{imageNumber}")
    public List<CatImage> getCatImages(@PathVariable("imageNumber") int imageNumber) {
        List<CatImage> catImages = catService.getCatImages(imageNumber);
        log.info("catImages : " + catImages);
        return catImages;
    }

}
