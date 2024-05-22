package app.backend.geo;

import jakarta.persistence.*;

@Entity
@Table(name = "log")
public class Log {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID", nullable = false, columnDefinition = "BIGINT AUTO_INCREMENT")
    private Long id;
    private String type;
    private String parameters;
    @Lob
    private String response;

    public Log() {}

    public Log(String type, String parameters, String response) {
        this.type = type;
        this.parameters = parameters;
        this.response = response;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getParameters() {
        return parameters;
    }

    public void setParameters(String parameters) {
        this.parameters = parameters;
    }

    public String getResponse() {
        return response;
    }

    public void setResponse(String response) {
        this.response = response;
    }
}
