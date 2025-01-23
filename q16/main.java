import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.WebServlet;

@WebServlet("/cookie")
public class CookieServlet extends HttpServlet {
  public void doPost(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {

    response.setContentType("text/html");
    PrintWriter out = response.getWriter();

    // Get username from form
    String username = request.getParameter("username");

    // Create cookie
    Cookie userCookie = new Cookie("user", username);
    userCookie.setMaxAge(60 * 60 * 24); // 24 hours
    response.addCookie(userCookie);

    // Create session
    HttpSession session = request.getSession();
    session.setAttribute("username", username);

    out.println("<html><body>");
    out.println("<h2>Cookie and Session Demo</h2>");

    // Display cookie value
    out.println("<h3>Name from Cookie:</h3>");
    Cookie[] cookies = request.getCookies();
    if (cookies != null) {
      for (Cookie cookie : cookies) {
        if (cookie.getName().equals("user")) {
          out.println("Welcome, " + cookie.getValue() + "!<br><br>");
        }
      }
    }

    // Display session value
    out.println("<h3>Name from Session:</h3>");
    String sessionUser = (String) session.getAttribute("username");
    out.println("Session User: " + sessionUser + "<br><br>");

    out.println("<a href='index.html'>Back to form</a>");
    out.println("</body></html>");
  }
}
