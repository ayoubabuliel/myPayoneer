package DTOs.Pets;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;

@Builder(toBuilder = true)
public class PetDTO {

    @JsonProperty("id")
    int id;
    @JsonProperty("category")
    CategoryDTO category;
    @JsonProperty("name")
    String name;
    @JsonProperty("photoUrls")
    String [] photoUrls;

    @JsonProperty("tags")
    TagDTO [] tags;
    @JsonProperty("status")
    Status status;

    public String toString(){
        return "\n" +
                "id= '" + id + "'\n"
                + "category= '" + category + "'\n"
                + "name= '" + name + "'\n"
                + "photoUrls= '" + photoUrls + "'\n"
                + "tags= '" + tags + "'\n"
                + "status= '" + status + "'\n";
    }
}