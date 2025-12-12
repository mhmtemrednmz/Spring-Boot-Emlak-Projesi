package com.emrednmz.controller.impl;

import com.emrednmz.controller.IRestAddressController;
import com.emrednmz.controller.RestBaseController;
import com.emrednmz.controller.RootEntity;
import com.emrednmz.dto.request.AddressRequest;
import com.emrednmz.dto.response.AddressResponse;
import com.emrednmz.service.IAddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("rest/api/address")
public class RestAddressControllerImpl extends RestBaseController implements IRestAddressController {
    @Autowired
    private IAddressService addressService;

    @PostMapping("add")
    @Override
    public RootEntity<AddressResponse> addAddress(@RequestBody AddressRequest addressRequest) {
        return ok(addressService.addAddress(addressRequest));
    }

    @GetMapping
    @Override
    public RootEntity<List<AddressResponse>> getAllAddresses() {
        return ok(addressService.getAllAddresses());
    }

    @GetMapping("{id}")
    @Override
    public RootEntity<AddressResponse> getAddressById(@PathVariable Long id) {
        return ok(addressService.getAddressesById(id));
    }

    @DeleteMapping("{id}")
    @Override
    public void deleteAddressById(@PathVariable Long id) {
        addressService.deleteAddressById(id);
    }
}
