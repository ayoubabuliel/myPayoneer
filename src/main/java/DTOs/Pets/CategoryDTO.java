package DTOs.Pets;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;

@Builder(toBuilder = true)
public class CategoryDTO {

    @JsonProperty("id")
    int id;

    @JsonProperty("name")
    String name;

    public String toString() {
        return "\n" + "id= '" + id + "'\n" + "name= '" + name + "'\n";
    }
}
