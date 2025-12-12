package com.emrednmz.service.impl;

import com.emrednmz.dto.request.AddressRequest;
import com.emrednmz.dto.response.AddressResponse;
import com.emrednmz.exception.BaseException;
import com.emrednmz.exception.ErrorMesaage;
import com.emrednmz.exception.MessageType;
import com.emrednmz.mapper.AddressMapper;
import com.emrednmz.model.Address;
import com.emrednmz.repository.AddressRepository;
import com.emrednmz.service.IAddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class AddressServiceImpl implements IAddressService {
    @Autowired
    private AddressRepository addressRepository;
    @Autowired
    private AddressMapper addressMapper;


    @Override
    public AddressResponse addAddress(AddressRequest addressRequest) {
        Address savesAddress = addressRepository.save(createAddress(addressRequest));
        return addressMapper.toAddressResponse(savesAddress);
    }

    @Override
    public List<AddressResponse> getAllAddresses() {
        return addressRepository.findAll().stream()
                .map(addressMapper::toAddressResponse)
                .collect(Collectors.toList());
    }

    @Override
    public AddressResponse getAddressesById(Long id) {
         addressRepository.findById(id)
                .map(addressMapper::toAddressResponse)
                .orElseThrow(() -> new BaseException(
                        new ErrorMesaage(MessageType.NOT_FOUND_ADDRESS, id.toString())));
         return null;
    }

    @Override
    public void deleteAddressById(Long id) {
        addressRepository.deleteById(id);
    }


    private Address createAddress(AddressRequest addressRequest) {
        Address address = addressMapper.toAddress(addressRequest);
        address.setCreateTime(new Date());
        return address;
    }
}
