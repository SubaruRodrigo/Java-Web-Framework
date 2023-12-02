package Main;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import Http.Request;
import Http.Response;
import Routing.Router;
import Server.Server;
import Server.ServerImpl;

/**
 * Main
 */
public class Main {

  public static void main(String[] args) throws IOException {
    Router router = new Router();

    router.get("/", (Request request, Response response) -> {
      response.setContent("Hello World");
      return response;
    });

    router.get("/user/{username}", (Request request, Response response) -> {
      Map<String, Object> params = new HashMap<>();

      params.put("username", request.getParameter("username"));

      return response.view("user",params);
    });

    Server server = new ServerImpl();

    server.start(router);

  }
}