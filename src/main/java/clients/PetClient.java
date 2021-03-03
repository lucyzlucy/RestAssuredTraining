package clients;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.response.Response;
import utils.DataManager;
import utils.Environment;
import utils.PropertiesManager;

import static io.restassured.RestAssured.given;

public class PetClient extends IClient {
  String user = DataManager.getPet();

  public Response sendGetRequest() {
    specification.setBasePath(Environment.getCurrentEnvironment().getString("client") +"/1");
    return given().spec(specification.build()).get();
  }

  public Response sendPostRequest() {
    specification.setBasePath(Environment.getCurrentEnvironment().getString("client"));
    specification.setBody(user);
    return given().spec(specification.build()).post();
  }

  public Response sendDeleteRequest() {
    specification.setBasePath(Environment.getCurrentEnvironment().getString("client") +"/1");
    return given().spec(specification.build()).delete();
  }

  public Response sendUpdateRequest() {
    specification.setBasePath(Environment.getCurrentEnvironment().getString("client") +"/1");
    specification.setBody(user);
    return given().spec(specification.build()).put();
  }
}
