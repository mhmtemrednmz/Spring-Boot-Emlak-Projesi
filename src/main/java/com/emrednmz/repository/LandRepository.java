package com.emrednmz.repository;

import com.emrednmz.enums.AdvertStatusType;
import com.emrednmz.model.Land;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface LandRepository extends JpaRepository<Land, Long> {

    List<Land> findByAdvertStatusType(AdvertStatusType advertStatusType);
}
