package com.codexasistemas.todoapp.api.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "location")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Location {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private Double latitude;

    @Column(nullable = false)
    private Double longitude;

    @Column(name = "location_name")
    private String locationName;

    @Column(name = "location_description")
    private String locationDescription;

    @OneToOne(mappedBy = "location")
    private Task task;

    public Location(Double latitude, Double longitude, String locationName, String locationDescription) {
        this.latitude = latitude;
        this.longitude = longitude;
        this.locationName = locationName;
        this.locationDescription = locationDescription;
    }

    public void validateCoordinates() {
        if (latitude == null || longitude == null) {
            throw new IllegalArgumentException("Latitude e longitude são obrigatórios");
        }
        if (latitude < -90 || latitude > 90) {
            throw new IllegalArgumentException("Latitude deve estar entre -90 e 90 graus");
        }
        if (longitude < -180 || longitude > 180) {
            throw new IllegalArgumentException("Longitude deve estar entre -180 e 180 graus");
        }
    }
} 