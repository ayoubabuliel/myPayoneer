package RequestApi;

import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.HashMap;
import java.util.Map;

@Builder(toBuilder = true)
public class GetPetRequestById extends RequestAPIAbstract{
    public int petId;

    public GetPetRequestByIdBuilder defaultBuilder(){
        path = "/" + petId;
        return toBuilder();
    }

    public String getPath(){
        return "/" + petId;
    }

    public Map<String, ?> petParams() {
        HashMap<String, Integer> map = new HashMap<>();
        map.put("petId", petId);
        return map;
    }
}
