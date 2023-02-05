package Tests.PetTests;

import DTOs.Pets.CategoryDTO;
import DTOs.Pets.PetDTO;
import DTOs.Pets.Status;
import DTOs.Pets.TagDTO;
import RequestApi.AddPetPostRequest;
import RequestApi.GetPetRequestById;
import Tests.InitTest;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


public class PetTest extends InitTest {

    AddPetPostRequest addPetPostRequest;
    private ObjectMapper mapper;
    private PetDTO petDtoBuild;

    @BeforeTest
    public void init() {
        printLog("we go to create a pet");
        mapper = new ObjectMapper();
        petDtoBuild = PetDTO.builder()
                .id(1)
                .category(CategoryDTO.builder()
                        .id(0)
                        .name("string")
                        .build())
                .name("doggie")
                .photoUrls(new String[]{"string"})
                .tags(new TagDTO[]{
                        TagDTO.builder()
                                .id(0)
                                .name("string")
                                .build()
                })
                .status(Status.available)
                .build();
        addPetPostRequest = AddPetPostRequest.builder().build().defaultBuilder()
                .petDTO(petDtoBuild)
                .build();
        printLog(String.format("The pet that we are go to create is %s", addPetPostRequest.petDTO.toString()));
    }

    @Test(priority = 10, description = "add new Pet")
    public void addNewPet() {
        RestAssured.given()
                .contentType(ContentType.JSON)
                .baseUri(baseURI)
                .basePath(basePath)
                .body(mapper.valueToTree(addPetPostRequest.petDTO))
                .post()
                .then()
                .statusCode(200);
    }

    @Test(priority = 20, description = "verify Pet added")
    public void verifyPetAdded() {
        GetPetRequestById getPetRequest = GetPetRequestById.builder().build().defaultBuilder().petId(1).build();
        Response getResponse = RestAssured.given()
                .contentType(ContentType.JSON)
                .baseUri(baseURI)
                .basePath(basePath + getPetRequest.getPath())
                .params(getPetRequest.petParams())
                .get();
        getResponse.then().statusCode(200);
        Assert.assertEquals(mapper.valueToTree(petDtoBuild).toString(), (getResponse.body().asString()),
                String.format("The body of the pet aren't the same as we request\n" +
                        "The expected is %s\n" +
                        "but the actual is %s",
                        mapper.valueToTree(petDtoBuild).toString(), (getResponse.body().asString())));
    }

    @AfterTest
    public void cleanup() {

    }


}
