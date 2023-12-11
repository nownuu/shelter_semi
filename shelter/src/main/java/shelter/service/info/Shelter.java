package shelter.service.info;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Shelter {

    @JsonProperty("shelterId")
    public String id;

    @JsonProperty("shelterStatus")
    public String status;

    @JsonProperty("shelterService")
    public String service;

    @JsonProperty("shelterName")
    public String organization;

    @JsonProperty("shelterAddress")
    public String location;

    // Add more properties if needed

    @Override
    public String toString() {
        return "Shelter{id='" + id + '\'' + ", status='" + status + '\'' + ", service='" + service + '\'' +
                ", organization='" + organization + '\'' + ", location='" + location + '\'' + '}';
    }
}
