package com.emrednmz.repository;

import com.emrednmz.model.Favorite;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FavoriteRepository extends JpaRepository<Favorite, Long> {
    @Query(value = "select * from favorite where user_id = :id" , nativeQuery = true)
    List<Favorite> findByUser_Id(Long id);
}
