package com.emrednmz.controller;

import com.emrednmz.dto.request.AddressRequest;
import com.emrednmz.dto.response.AddressResponse;

import java.util.List;

public interface IRestAddressController {
    RootEntity<AddressResponse> addAddress(AddressRequest addressRequest);
    RootEntity<List<AddressResponse>> getAllAddresses();
    RootEntity<AddressResponse> getAddressById(Long id);
    void deleteAddressById(Long id);
}
