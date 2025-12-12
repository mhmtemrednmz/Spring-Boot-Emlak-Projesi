package com.emrednmz.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
public class Image extends BaseEntity {

    private String name;
    private String url;

    @ManyToOne
    @JoinColumn(name = "advert_id")
    private Advert advert;


}
