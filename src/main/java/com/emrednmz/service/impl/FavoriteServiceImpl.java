package com.emrednmz.service.impl;

import com.emrednmz.dto.request.FavoriteRequest;
import com.emrednmz.dto.response.FavoriteResponse;
import com.emrednmz.exception.BaseException;
import com.emrednmz.exception.ErrorMesaage;
import com.emrednmz.exception.MessageType;
import com.emrednmz.mapper.FavoriteMapper;
import com.emrednmz.model.Favorite;
import com.emrednmz.repository.AdvertRepository;
import com.emrednmz.repository.FavoriteRepository;
import com.emrednmz.repository.UserRepository;
import com.emrednmz.service.IFavoriteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class FavoriteServiceImpl implements IFavoriteService {
    @Autowired
    private FavoriteRepository favoriteRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private AdvertRepository advertRepository;
    @Autowired
    private FavoriteMapper favoriteMapper;

    @Override
    public FavoriteResponse addFavorite(FavoriteRequest favoriteRequest) {
        Favorite savedFavorite = favoriteRepository.save(createFavorite(favoriteRequest));
        return favoriteMapper.toFavoriteResponse(savedFavorite);
    }

    @Override
    public List<FavoriteResponse> getAllFavorites() {
        return favoriteRepository.findAll().stream()
                .map(favoriteMapper::toFavoriteResponse)
                .collect(Collectors.toList());
    }

    @Override
    public List<FavoriteResponse> getFavoritesByUserId(Long userId) {
        return favoriteRepository.findByUser_Id(userId).stream()
                .map(favoriteMapper::toFavoriteResponse)
                .collect(Collectors.toList());
    }

    @Override
    public FavoriteResponse getFavoriteById(Long id) {
        return favoriteRepository.findById(id)
                .map(favoriteMapper::toFavoriteResponse)
                .orElseThrow(() -> new BaseException(new ErrorMesaage(MessageType.NOT_FOUND_FAVORITE, id.toString())));
    }

    @Override
    public void deleteFavoriteById(Long id) {
        favoriteRepository.deleteById(id);
    }

    private Favorite createFavorite(FavoriteRequest favoriteRequest) {
        Favorite favorite = new Favorite();
        favorite.setCreateTime(new Date());

        favorite.setUser(userRepository.findById(favoriteRequest.getUserId())
                .orElseThrow(() -> new BaseException(new ErrorMesaage(MessageType.NOT_FOUND_USER, favoriteRequest.getUserId().toString()))));

        favorite.setAdvert(advertRepository.findById(favoriteRequest.getAdvertId())
                .orElseThrow(()-> new BaseException(new ErrorMesaage(MessageType.NOT_FOUND_ADVERT, favoriteRequest.getAdvertId().toString()))));

        return favorite;
    }
}
