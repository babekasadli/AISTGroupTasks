package app.backend.geo;

import jakarta.persistence.*;

@Entity
@Table(name = "places")
public class Place {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID", nullable = false, columnDefinition = "BIGINT AUTO_INCREMENT")
    private Long id;
    @Column(name = "display_name")
    private String displayName;
    private String lat;
    private String lon;
    private String category;

    public Place() {}

    public Place(String displayName, String lat, String lon, String category) {
        this.displayName = displayName;
        this.lat = lat;
        this.lon = lon;
        this.category = category;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    public String getLat() {
        return lat;
    }

    public void setLat(String lat) {
        this.lat = lat;
    }

    public String getLon() {
        return lon;
    }

    public void setLon(String lon) {
        this.lon = lon;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }
}
