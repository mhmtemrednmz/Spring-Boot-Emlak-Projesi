package com.emrednmz.mapper;

import com.emrednmz.dto.request.AddressRequest;
import com.emrednmz.dto.response.AddressResponse;
import org.mapstruct.Mapper;
import com.emrednmz.model.Address;

@Mapper(componentModel = "spring")
public interface AddressMapper {
    Address toAddress(AddressRequest addressRequest);
    AddressResponse toAddressResponse(Address address);
}
