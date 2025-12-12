package com.emrednmz.mapper;

import com.emrednmz.dto.request.FavoriteRequest;
import com.emrednmz.dto.response.FavoriteResponse;
import com.emrednmz.model.Favorite;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = {UserMapper.class, AdvertMapper.class})
public interface FavoriteMapper {

    Favorite toFavorite(FavoriteRequest favoriteRequest);
    FavoriteResponse toFavoriteResponse(Favorite favorite);

}
