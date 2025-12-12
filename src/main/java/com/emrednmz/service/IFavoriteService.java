package com.emrednmz.service;

import com.emrednmz.dto.request.FavoriteRequest;
import com.emrednmz.dto.response.FavoriteResponse;

import java.util.List;

public interface IFavoriteService {
    FavoriteResponse addFavorite(FavoriteRequest favoriteRequest);
    List<FavoriteResponse> getAllFavorites();
    List<FavoriteResponse> getFavoritesByUserId(Long userId);
    FavoriteResponse getFavoriteById(Long id);
    void deleteFavoriteById(Long id);
}
