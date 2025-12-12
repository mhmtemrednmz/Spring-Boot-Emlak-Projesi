package com.emrednmz.service.impl;

import com.emrednmz.exception.BaseException;
import com.emrednmz.exception.ErrorMesaage;
import com.emrednmz.exception.MessageType;
import com.emrednmz.model.Advert;
import com.emrednmz.repository.AdvertRepository;
import com.emrednmz.repository.ImageRepository;
import com.emrednmz.service.IImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.emrednmz.model.Image;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Date;
import java.util.List;

@Service
public class ImageServiceImpl implements IImageService {

    @Autowired
    private ImageRepository imageRepository;

    @Autowired
    private AdvertRepository advertRepository;


    @Override
    public List<Image> getImagesByAdvertId(Long advertId) {
        Advert advert = advertRepository.findById(advertId)
                .orElseThrow(() -> new BaseException(new ErrorMesaage(MessageType.NOT_FOUND_ADVERT, advertId.toString())));
        return imageRepository.findByAdvertId(advertId)
                .orElseThrow(() -> new BaseException(new ErrorMesaage(MessageType.NOT_FOUND_IMAGES, advertId.toString())));
    }

    @Override
    public Image saveImage(MultipartFile file, Long advertId) throws IOException {
        Advert advert = advertRepository.findById(advertId)
                .orElseThrow(() -> new BaseException(new ErrorMesaage(MessageType.NOT_FOUND_ADVERT, advertId.toString())));

        String uploadDir = "src/main/resources/static/images/";
        Path path = Paths.get(uploadDir + file.getOriginalFilename());
        Files.write(path, file.getBytes());

        Image image = new Image();
        image.setCreateTime(new Date());
        image.setName(file.getOriginalFilename());
        image.setUrl("images/" + file.getOriginalFilename());
        image.setAdvert(advert);

        return imageRepository.save(image);
    }
}
