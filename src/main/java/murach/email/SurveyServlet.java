package murach.email;

import murach.business.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/survey")
public class SurveyServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html; charset=UTF-8");
        String url = "/index.jsp";
        // get current action
        String action = request. getParameter ("action") ;
        if (action == null) {
            action = "join"; // default action
        }
        if (action. equals ("join") ) {
            url = "/index.jsp";
        }
        else if (action.equals("add")) {
            String firstName = request.getParameter("firstName");
            String lastName = request.getParameter("lastName");
            String email = request.getParameter("email");
            String dateOfBirth = request.getParameter("dateOfBirth");

            // Radio button: How did you hear about us?
            String heardFrom = request.getParameter("contactVia");

            // Checkbox: Would you like to receive announcements?
            boolean wantsUpdates = request.getParameter("wouldlike") != null;

            // Checkbox: Email announcements
            boolean emailAnnouncements = request.getParameter("emailAnnouncements") != null;

            // Select dropdown: Please contact me by
            String contactMethod = request.getParameter("contact");

            User user = new User(firstName, lastName, email, dateOfBirth, heardFrom, wantsUpdates, emailAnnouncements, contactMethod);
            //UserDB.insert(user);
            request.setAttribute("user", user);
            url = "/survey.jsp";
        }

        getServletContext().getRequestDispatcher(url).forward(request, response);
    }
    @Override
    protected void doGet (HttpServletRequest request,
                          HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}