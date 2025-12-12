package com.emrednmz.controller;

import com.emrednmz.dto.request.FavoriteRequest;
import com.emrednmz.dto.response.FavoriteResponse;

import java.util.List;

public interface IRestFavoriteController {
    RootEntity<FavoriteResponse> addFavorite(FavoriteRequest favoriteRequest);
    RootEntity<List<FavoriteResponse>> getFavorites();
    RootEntity<List<FavoriteResponse>> getFavoritesByUserId(Long userId);
    RootEntity<FavoriteResponse> getFavoriteById(Long id);
    void deleteFavoriteById(Long id);

}
