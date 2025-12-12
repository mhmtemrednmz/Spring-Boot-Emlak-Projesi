package com.emrednmz.controller.impl;

import com.emrednmz.controller.IRestFavoriteController;
import com.emrednmz.controller.RestBaseController;
import com.emrednmz.controller.RootEntity;
import com.emrednmz.dto.request.FavoriteRequest;
import com.emrednmz.dto.response.FavoriteResponse;
import com.emrednmz.service.IFavoriteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("rest/api/favorite")
public class RestFavoriteControllerImpl extends RestBaseController implements IRestFavoriteController {
    @Autowired
    private IFavoriteService favoriteService;

    @PostMapping("add")
    @Override
    public RootEntity<FavoriteResponse> addFavorite(@RequestBody FavoriteRequest favoriteRequest) {
        return ok(favoriteService.addFavorite(favoriteRequest));
    }

    @GetMapping
    @Override
    public RootEntity<List<FavoriteResponse>> getFavorites() {
        return ok(favoriteService.getAllFavorites());
    }

    @GetMapping("by-user/{userId}")
    @Override
    public RootEntity<List<FavoriteResponse>> getFavoritesByUserId(@PathVariable Long userId) {
        return ok(favoriteService.getFavoritesByUserId(userId));
    }

    @GetMapping("{id}")
    @Override
    public RootEntity<FavoriteResponse> getFavoriteById(@PathVariable Long id) {
        return ok(favoriteService.getFavoriteById(id));
    }

    @DeleteMapping("{id}")
    @Override
    public void deleteFavoriteById(@PathVariable Long id) {
        favoriteService.deleteFavoriteById(id);
    }
}
