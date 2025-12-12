package com.emrednmz.service.impl;

import com.emrednmz.dto.request.HousingRequest;
import com.emrednmz.dto.response.AddressResponse;
import com.emrednmz.dto.response.AdvertResponse;
import com.emrednmz.enums.AdvertStatusType;
import com.emrednmz.exception.BaseException;
import com.emrednmz.exception.ErrorMesaage;
import com.emrednmz.exception.MessageType;
import com.emrednmz.mapper.HousingMapper;
import com.emrednmz.model.Housing;
import com.emrednmz.repository.AddressRepository;
import com.emrednmz.repository.HousingRepository;
import com.emrednmz.repository.UserRepository;
import com.emrednmz.service.IHousingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class HousingServiceImpl implements IHousingService {
    @Autowired
    private HousingRepository housingRepository;
    @Autowired
    private HousingMapper housingMapper;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private AddressRepository addressRepository;

    @Override
    public AdvertResponse saveHousing(HousingRequest housingRequest) {
        Housing savedHousing = housingRepository.save(createHousing(housingRequest));
        return housingMapper.toAdvertResponse(savedHousing);
    }

    @Override
    public List<AdvertResponse> getAllHousing() {
        return housingRepository.findAll().stream()
                .map(housingMapper::toAdvertResponse)
                .collect(Collectors.toList());
    }

    @Override
    public List<AdvertResponse> getHousingByAdvertStatusType(AdvertStatusType advertStatusType) {
        return housingRepository.findByAdvertStatusType(advertStatusType).stream()
                .map(housingMapper::toAdvertResponse)
                .collect(Collectors.toList());
    }

    @Override
    public AdvertResponse getHousingById(Long id) {
        return housingRepository.findById(id)
                .map(housingMapper::toAdvertResponse)
                .orElseThrow(() -> new BaseException(new ErrorMesaage(MessageType.NOT_FOUND_ADVERT, id.toString())));
    }

    @Override
    public void deleteHousingById(Long id) {
        housingRepository.deleteById(id);
    }

    private Housing createHousing(HousingRequest housingRequest) {
        Housing housing = housingMapper.toHousing(housingRequest);
        housing.setCreateTime(new Date());

        housing.setUser(userRepository.findById(housingRequest.getUser_id())
                .orElseThrow(() -> new BaseException(new ErrorMesaage(MessageType.NOT_FOUND_USER, housingRequest.getUser_id().toString()))));

        housing.setAddress(addressRepository.findById(housingRequest.getAddress_id())
                .orElseThrow(() -> new BaseException(new ErrorMesaage(MessageType.NOT_FOUND_ADDRESS, housingRequest.getAddress_id().toString()))));

        return housing;
    }
}
