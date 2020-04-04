package main;

import java.net.URL;
import java.util.ArrayList;

public class Company {
  String name;
  String description;
  String location;
  String mapImage;
  ArrayList<CompanyFile> files = new ArrayList<>();

  public Company(String name, String description, String location) {
    this.name = name;
    this.description = description;
    this.location = location;
  }

  public Company(String name, String description, String location, String mapImage) {
    this.name = name;
    this.description = description;
    this.location = location;
    this.mapImage = mapImage;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getLocation() {
    return location;
  }

  public void setLocation(String location) {
    this.location = location;
  }

  public String getMapImage() {
    return mapImage;
  }

  public void setMapImage(String mapImage) {
    this.mapImage = mapImage;
  }
}
