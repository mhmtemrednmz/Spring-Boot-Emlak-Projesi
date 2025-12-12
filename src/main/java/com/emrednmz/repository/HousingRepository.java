package com.emrednmz.repository;

import com.emrednmz.enums.AdvertStatusType;
import com.emrednmz.model.Housing;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HousingRepository extends JpaRepository<Housing, Long> {
    List<Housing> findByAdvertStatusType(AdvertStatusType advertStatusType);
}
