package com.example.demo;

import lombok.Data;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.geo.GeoJsonPoint;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Data
@Entity
public class WeatherMeasurement {
    private @Id ObjectId id;
    private int date;
    private int value;
    private GeoJsonPoint location;

    public WeatherMeasurement(){}
    public WeatherMeasurement(int date, int value, double longitude, double latitude){
        this.date=date;
        this.value=value;
        this.location = new GeoJsonPoint(longitude,latitude);
    }
    public double getLongitude(){
        return location.getX();
    }
    public double getLatitude(){
        return location.getY();
    }
    public void setLongitude(double longitude){
        double lat= location != null ? location.getY():0.0;
        location= new GeoJsonPoint(longitude,lat);
    }
    public void setLatitude(double latitude){
        double lon= location != null ? location.getX():0.0;
        location= new GeoJsonPoint(lon,latitude);
    }
}
