package com.emrednmz.controller.impl;

import com.emrednmz.controller.IRestHousingController;
import com.emrednmz.controller.RestBaseController;
import com.emrednmz.controller.RootEntity;
import com.emrednmz.dto.request.HousingRequest;
import com.emrednmz.dto.response.AdvertResponse;
import com.emrednmz.enums.AdvertStatusType;
import com.emrednmz.service.IHousingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("rest/api/housing")
public class RestHousingControllerImpl extends RestBaseController implements IRestHousingController {
    @Autowired
    private IHousingService housingService;

    @PostMapping("save")
    @Override
    public RootEntity<AdvertResponse> saveHousing(@RequestBody HousingRequest housingRequest) {
        return ok(housingService.saveHousing(housingRequest));
    }

    @GetMapping
    @Override
    public RootEntity<List<AdvertResponse>> getAllHousing() {
        return ok(housingService.getAllHousing());
    }

    @GetMapping("status")
    @Override
    public RootEntity<List<AdvertResponse>> getHousingByAdvertStatusType(@RequestParam AdvertStatusType status) {
        return ok(housingService.getHousingByAdvertStatusType(status));
    }

    @GetMapping("{id}")
    @Override
    public RootEntity<AdvertResponse> getHousingById(@PathVariable Long id) {
        return ok(housingService.getHousingById(id));
    }

    @DeleteMapping("{id}")
    @Override
    public void deleteHousingById(Long id) {
        housingService.deleteHousingById(id);
    }
}
