package com.emrednmz.service;

import com.emrednmz.model.Image;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

public interface IImageService {
    List<Image> getImagesByAdvertId(Long advertId);
    Image saveImage(MultipartFile file, Long advertId) throws IOException;
}
