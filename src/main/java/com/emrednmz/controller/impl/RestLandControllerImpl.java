package com.emrednmz.controller.impl;

import com.emrednmz.controller.IRestLandController;
import com.emrednmz.controller.RestBaseController;
import com.emrednmz.controller.RootEntity;
import com.emrednmz.dto.request.LandRequest;
import com.emrednmz.dto.response.AdvertResponse;
import com.emrednmz.enums.AdvertStatusType;
import com.emrednmz.service.ILandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("rest/api/land")
public class RestLandControllerImpl extends RestBaseController implements IRestLandController {
    @Autowired
    private ILandService landService;

    @PostMapping("save")
    @Override
    public RootEntity<AdvertResponse> saveLand(@RequestBody LandRequest landRequest) {
        return ok(landService.saveLand(landRequest));
    }

    @GetMapping
    @Override
    public RootEntity<List<AdvertResponse>> getAllLands() {
        return ok(landService.getAllLands());
    }

    @GetMapping("status")
    @Override
    public RootEntity<List<AdvertResponse>> getLandByAdvertStatusType(@RequestParam AdvertStatusType status) {
        return ok(landService.getLandByAdvertStatusType(status));
    }

    @GetMapping("{id}")
    @Override
    public RootEntity<AdvertResponse> getLandById(@PathVariable Long id) {
        return ok(landService.getLandById(id));
    }

    @DeleteMapping("{id}")
    @Override
    public void deleteLandById(@PathVariable Long id) {
        landService.deleteLand(id);
    }
}
