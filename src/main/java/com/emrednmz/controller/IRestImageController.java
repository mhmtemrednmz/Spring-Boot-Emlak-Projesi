package com.emrednmz.controller;

import com.emrednmz.model.Image;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface IRestImageController {
    RootEntity<List<Image>> getImagesByAdvertId(Long advertId);
    RootEntity<?> uploadImage(Long advertId, MultipartFile file);
}
