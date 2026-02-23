package com.example.studyspot;

// Implementing Object-Oriented Programming (OOP) principles
public class StudyLocation {

    // Encapsulated private fields
    private String id;
    private String name;
    private String rating;
    private String description;
    private String distance;
    private String hours;
    private String capacity;
    private String busyness;
    private String noiseLevel;
    private String amenities;

    // Comprehensive Constructor
    public StudyLocation(String id, String name, String rating, String description,
                         String distance, String hours, String capacity,
                         String busyness, String noiseLevel, String amenities) {
        this.id = id;
        this.name = name;
        this.rating = rating;
        this.description = description;
        this.distance = distance;
        this.hours = hours;
        this.capacity = capacity;
        this.busyness = busyness;
        this.noiseLevel = noiseLevel;
        this.amenities = amenities;
    }

    // Getters
    public String getId() { return id; }
    public String getName() { return name; }
    public String getRating() { return rating; }
    public String getDescription() { return description; }
    public String getDistance() { return distance; }
    public String getHours() { return hours; }
    public String getCapacity() { return capacity; }
    public String getBusyness() { return busyness; }
    public String getNoiseLevel() { return noiseLevel; }
    public String getAmenities() { return amenities; }
}