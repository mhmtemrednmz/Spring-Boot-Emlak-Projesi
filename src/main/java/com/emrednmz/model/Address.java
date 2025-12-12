package com.emrednmz.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Address extends BaseEntity{
    @Column
    private String city;
    private String district;
    private String neighborhood;
    private String street;
}
