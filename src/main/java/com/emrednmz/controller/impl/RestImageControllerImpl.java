package com.emrednmz.controller.impl;

import com.emrednmz.controller.IRestImageController;
import com.emrednmz.controller.RestBaseController;
import com.emrednmz.controller.RootEntity;
import com.emrednmz.dto.response.ImageDto;
import com.emrednmz.model.Image;
import com.emrednmz.service.IImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Base64;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("rest/api/images")
public class RestImageControllerImpl extends RestBaseController implements IRestImageController {
    @Autowired
    private IImageService imageService;

    @GetMapping("{advertId}")
    @Override
    public RootEntity<List<Image>> getImagesByAdvertId(@PathVariable Long advertId) {
        return ok(imageService.getImagesByAdvertId(advertId));
    }

    @PostMapping("/upload/{advertId}")
    @Override
    public RootEntity<?> uploadImage(@PathVariable Long advertId,
                                     @RequestParam("file") MultipartFile file) {
        if (file.isEmpty()) {
            return error("Dosya seçilmedi");
        }
        try {
            Image savedImage = imageService.saveImage(file, advertId);
            return ok(savedImage);
        } catch (IOException e) {
            e.printStackTrace();
            return error("Dosya yükleme hatası");
        } catch (RuntimeException e) {
            return error(e.getMessage());
        }
    }
}
