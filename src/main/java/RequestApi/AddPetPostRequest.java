package RequestApi;

import DTOs.Pets.PetDTO;
import lombok.Builder;

@Builder(toBuilder = true)
public class AddPetPostRequest extends RequestAPIAbstract{
    public PetDTO petDTO;

    public AddPetPostRequestBuilder defaultBuilder(){
        path = "";
        return toBuilder();
    }

    @Override
    public String getPath() {
        return "";
    }
}
