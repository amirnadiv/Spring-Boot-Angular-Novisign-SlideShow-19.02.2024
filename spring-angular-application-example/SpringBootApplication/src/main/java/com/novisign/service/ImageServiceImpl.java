package com.novisign.service;

import com.novisign.dto.ImageDTO;
import com.novisign.exception.ImageNotFoundException;
import com.novisign.model.ImageEntity;
import com.novisign.repository.ImageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ImageServiceImpl implements ImageService{

    @Autowired
    private ImageRepository repository;

    public ImageDTO addImage(ImageDTO imageDTO) {
        return null;
    }

    public void deleteImage(Long id) {

        Optional<ImageEntity> image = repository.findById(id);
        if (image != null) {

            repository.deleteById(id);
        } else {

            try {
                throw new ImageNotFoundException("Image with ID " + id + " not found"); // Custom exception, replace with your own (or a standard one), if needed.
            } catch (ImageNotFoundException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public List<ImageDTO> shuffleImages() {

        return null;
    }

    public List<ImageDTO> getImages() {

        return null;
    }
}

