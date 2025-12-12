package com.emrednmz.service;

import com.emrednmz.dto.request.AddressRequest;
import com.emrednmz.dto.response.AddressResponse;

import java.util.List;

public interface IAddressService {
    AddressResponse addAddress(AddressRequest addressRequest);
    List<AddressResponse> getAllAddresses();
    AddressResponse getAddressesById(Long id);
    void deleteAddressById(Long id);
}
