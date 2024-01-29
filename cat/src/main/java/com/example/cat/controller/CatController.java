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
@Controller
@RequiredArgsConstructor
public class CatController {

    final private CatphotoService catService;

//    @GetMapping("/images")
//    public List<CatImage> getImages(@RequestParam Long imageNumber){
//        return catService.getCatImages(imageNumber);
//    }

    @GetMapping("/")
    public String getCatImages() {
        return "catImages";
    }

    @GetMapping("/catImages")
    public String getCatImages(@RequestParam int imageNumber, Model model) {
        List<CatImage> catImages = catService.getCatImages(imageNumber);
        log.info("catImages : " + catImages);
        model.addAttribute("catImages", catImages.get(0));
        return "catImages";
    }

    @PostMapping("/collection")
    public String getCollection(@RequestBody List<CatImage> collection, Model model) {

        model.addAttribute("collection", collection);

        return "collection";
    }
}
