package sandbox;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.ServletException;
import java.io.IOException;

public class RedirectServletExample extends HttpServlet {
  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    String redirectUrl = "https://www.example.com";
    response.setStatus(HttpServletResponse.SC_FOUND);
    response.setHeader("Location", redirectUrl);
  }
}
