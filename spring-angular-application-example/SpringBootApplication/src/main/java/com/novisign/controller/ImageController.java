package com.novisign.controller;

import com.novisign.dto.ImageDTO;
import com.novisign.service.ImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ImageController {

    @Autowired
    private ImageService imageService;

    @PostMapping("/addImage")
    public ResponseEntity<?> addImage(@RequestBody ImageDTO imageDTO) {

        imageService.addImage(imageDTO);
        return new ResponseEntity(HttpStatus.OK);
    }

    @DeleteMapping("/deleteImage/{id}")
    public ResponseEntity<?> deleteImage(@PathVariable Long id) {
        // Implement logic to delete an existing image URL
        imageService.deleteImage(id);
        return new ResponseEntity(HttpStatus.OK); // todo amirn - complete
    }

    @PostMapping("/shuffleImages")
    public ResponseEntity<?> shuffleImages() {
        // Implement logic to shuffle existing images
        return new ResponseEntity(HttpStatus.OK); // todo amirn - complete
    }

    @GetMapping("/images")
    public ResponseEntity<List<String>> getImages() {
        List<ImageDTO> imagesUrls = imageService.getImages();
        return new ResponseEntity(HttpStatus.OK);
    }

}
