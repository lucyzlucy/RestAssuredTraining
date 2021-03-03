package clients;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.response.Response;
import utils.Environment;
import utils.PropertiesManager;

public abstract class IClient {
  RequestSpecBuilder specification =
      new RequestSpecBuilder()
          .addHeader("api_key", Environment.getCurrentEnvironment().getString("api_key"))
          .addHeader("Content-Type", "application/json");

  public abstract Response sendGetRequest();

  public abstract Response sendPostRequest();

  public abstract Response sendDeleteRequest();

  public abstract Response sendUpdateRequest();
}
