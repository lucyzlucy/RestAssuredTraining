import clients.Client;
import io.restassured.response.Response;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import utils.Environment;

import static org.apache.http.HttpStatus.SC_OK;
public class CRUDTests extends BaseTest {
//  @Parameters("client")
//  @Test
//  public void createEntityTest(String client) {
//    Response response = Client.getClient(client).sendPostRequest();
//    response.then().assertThat().statusCode(SC_OK);
//  }
//  @Parameters("client")
//  @Test(dependsOnMethods = "createEntityTest")
//  public void getEntityTest(String client) {
//    Client.getClient(client).sendPostRequest();
//
//    Response response = Client.getClient(client).sendGetRequest();
//    //    response.then().assertThat().statusCode(SC_OK);
//    Assert.assertEquals(response.then().extract().statusCode(), SC_OK, "Response code not OK");
//  }
//  @Parameters("client")
//
//  @Test(dependsOnMethods = "createEntityTest")
//  public void updateEntityTest(String client) {
//    Client.getClient(client).sendPostRequest();
//
//    Response response = Client.getClient(client).sendUpdateRequest();
//    response.then().assertThat().statusCode(SC_OK);
//    Assert.assertEquals(response.then().extract().statusCode(), SC_OK, "Response code not OK");
//  }
//  @Parameters("client")
  @Test(groups = "smoke")
  public void deleteEntityTest() {
    Client.getClient(Environment.getCurrentEnvironment().getString("client")).sendPostRequest();

    Response response = Client.getClient(Environment.getCurrentEnvironment().getString("client")).sendDeleteRequest();
    response.then().assertThat().statusCode(SC_OK);
  }
}
