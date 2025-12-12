package com.emrednmz.service.impl;

import com.emrednmz.dto.request.LandRequest;
import com.emrednmz.dto.response.AdvertResponse;
import com.emrednmz.enums.AdvertStatusType;
import com.emrednmz.exception.BaseException;
import com.emrednmz.exception.ErrorMesaage;
import com.emrednmz.exception.MessageType;
import com.emrednmz.mapper.LandMapper;
import com.emrednmz.model.Land;
import com.emrednmz.repository.AddressRepository;
import com.emrednmz.repository.LandRepository;
import com.emrednmz.repository.UserRepository;
import com.emrednmz.service.ILandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class LandServiceImpl implements ILandService {
    @Autowired
    private LandRepository landRepository;
    @Autowired
    private LandMapper landMapper;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private AddressRepository addressRepository;

    @Override
    public AdvertResponse saveLand(LandRequest landRequest) {
        Land savedLand = landRepository.save(createLand(landRequest));
        return landMapper.toAdvertResponse(savedLand);
    }

    @Override
    public List<AdvertResponse> getAllLands() {
        return landRepository.findAll().stream()
                .map(landMapper::toAdvertResponse)
                .collect(Collectors.toList());
    }

    @Override
    public List<AdvertResponse> getLandByAdvertStatusType(AdvertStatusType advertStatusType) {
        return landRepository.findByAdvertStatusType(advertStatusType).stream()
                .map(landMapper::toAdvertResponse)
                .collect(Collectors.toList());
    }

    @Override
    public AdvertResponse getLandById(Long id) {
        return landRepository.findById(id)
                .map(landMapper::toAdvertResponse)
                .orElseThrow(() -> new BaseException(new ErrorMesaage(MessageType.NOT_FOUND_ADVERT, id.toString())));
    }

    @Override
    public void deleteLand(Long id) {
        landRepository.deleteById(id);
    }

    private Land createLand(LandRequest landRequest) {
        Land land = landMapper.toLand(landRequest);
        land.setCreateTime(new Date());

        land.setUser(userRepository.findById(landRequest.getUser_id())
                .orElseThrow(() -> new BaseException(new ErrorMesaage(MessageType.NOT_FOUND_USER, landRequest.getUser_id().toString()))));

        land.setAddress(addressRepository.findById(landRequest.getAddress_id())
                .orElseThrow(() -> new BaseException(new ErrorMesaage(MessageType.NOT_FOUND_ADDRESS, landRequest.getAddress_id().toString()))));

        return land;
    }
}
