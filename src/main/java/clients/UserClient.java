package clients;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.response.Response;
import models.User;
import utils.DataManager;
import utils.JsonParsingUtil;
import utils.PropertiesManager;

import static io.restassured.RestAssured.given;

public class UserClient extends IClient {
//  RequestSpecBuilder specification =
//          new RequestSpecBuilder()
//                  .addHeader("api_key", PropertiesManager.getProperty("api_key"))
//                  .addHeader("Content-Type", "application/json");

  String user = DataManager.getUser();
  String username = JsonParsingUtil.getValue(user, "username");

  public Response sendGetRequest() {
    specification.setBasePath("user/" + username);
    System.out.println(specification.toString());
    return given().spec(specification.build()).get();
  }

  public Response sendPostRequest() {
    specification.setBasePath("user");
    specification.setBody(user);
    System.out.println(specification.toString());
    return given().spec(specification.build()).post();
  }

  public Response sendDeleteRequest() {
    specification.setBasePath("user/" + username);
    return given().spec(specification.build()).delete();
  }

  public Response sendUpdateRequest() {
    specification.setBasePath("user/" + username);
    specification.setBody(user);
    return given().spec(specification.build()).put();
  }

}
