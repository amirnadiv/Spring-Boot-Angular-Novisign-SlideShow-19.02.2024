package com.novisign.service;
import com.novisign.dto.ImageDTO;
import org.springframework.stereotype.Service;
import java.util.List;


@Service
public interface ImageService {

    public ImageDTO addImage(ImageDTO imageDTO) ;

    public void deleteImage(Long id) ;

    public List<ImageDTO> shuffleImages() ;

    public List<ImageDTO> getImages() ;

}