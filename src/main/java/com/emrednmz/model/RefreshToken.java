package com.emrednmz.model;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
@Entity
@Getter
@Setter
public class RefreshToken extends BaseEntity{
    private Date expiredDate;
    private String refreshToken;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

}
