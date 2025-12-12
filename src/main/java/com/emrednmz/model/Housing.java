package com.emrednmz.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Housing extends Advert {
    private int numberOfRooms;        // Oda sayısı
    private int numberOfLounge;       // Salon sayısı
    private int numberOfBathrooms;    // Banyo sayısı
    private int floorNumber;          // Bulunduğu kat
    private int totalFloorsInBuilding;// Binadaki toplam kat sayısı
    private int housingSize;          // Dairenin büyüklüğü (m2)
    private int housingAge;           // Dairenin yaşı
    private boolean isFurnished;      // Eşyalı mı?


}

