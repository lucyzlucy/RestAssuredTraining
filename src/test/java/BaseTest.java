import io.qameta.allure.restassured.AllureRestAssured;
import io.restassured.RestAssured;
import io.restassured.filter.log.LogDetail;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import utils.Environment;
import utils.PropertiesManager;

public class BaseTest {
  @Parameters("client")
  @BeforeSuite(alwaysRun = true)
  public void setUp(@Optional(value = "pet") String client) {
    Environment.setEnvironment(client);

    //    RestAssured.enableLoggingOfRequestAndResponseIfValidationFails(LogDetail.ALL);
    RestAssured.filters(new AllureRestAssured());
    RestAssured.filters(new RequestLoggingFilter(), new ResponseLoggingFilter());
    RestAssured.baseURI = Environment.getCurrentEnvironment().getString("baseURI");
  }
}
