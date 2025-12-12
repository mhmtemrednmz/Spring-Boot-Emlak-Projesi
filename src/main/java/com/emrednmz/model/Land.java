package com.emrednmz.model;


import com.emrednmz.enums.LandType;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
public class Land extends Advert {

    private double landSize; // Arsanın büyüklüğü (m2 veya dönüm)
    private boolean isFertile; // Tarıma uygun mu?
    private boolean isCommercial; // Ticari kullanım amaçlı mı?
    @Enumerated(EnumType.STRING)
    private LandType landType; // Arsanın tipi (örneğin, tarla, orman, vb.)

}

