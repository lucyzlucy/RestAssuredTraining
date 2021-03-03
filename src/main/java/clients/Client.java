package clients;

import utils.Environment;
import utils.PropertiesManager;

import static java.lang.String.format;

public abstract class Client {
  private Client() {

  }

  public static IClient getClient(String client) {
    switch (client) {
      case "user":
        return new UserClient();
      case "pet":
        return new PetClient();
      default:
        throw new IllegalArgumentException(
            format(
                "Environment not configured properly. Client for %s not found",
                    Environment.getCurrentEnvironment().getString("client")));
    }
  }
}
