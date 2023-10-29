package com.example.cat.service;

import com.example.cat.Domain.CatImage;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CatService {

    public List<CatImage> getCatImages (int imageNumber);
}
