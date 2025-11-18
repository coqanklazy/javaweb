//package murach.email;
//import murach.business.User;
//
//import java.io.*;
//import javax.servlet.*;
//import javax.servlet.http.*;
//public class EmailListServlet extends HttpServlet{
//    @Override
//    protected void doPost (HttpServletRequest request,
//                           HttpServletResponse response)
//            throws ServletException, IOException {
//
//        request.setCharacterEncoding("UTF-8");
//        response.setContentType("text/html; charset=UTF-8");
//        String url = "/index.html";
//
//        // get current action
//        String action = request. getParameter ("action") ;
//        if (action == null) {
//            action = "join"; // default action
//        }
//        if (action. equals ("join") ) {
//            url = "/index.html";
//        }
//        else if (action.equals("add")) {
//                String firstName = request.getParameter("firstName");
//                String lastName = request.getParameter("lastName");
//                String email = request.getParameter("email");
//                String dateOfBirth = request.getParameter("dateOfBirth");
//                User user = new User(firstName, lastName, email, dateOfBirth);
//                //UserDB.insert(user);
//                request.setAttribute("user", user);
//                url = "/thanks.jsp";
//            }
//
//            getServletContext().getRequestDispatcher(url).forward(request, response);
//        }
//        @Override
//        protected void doGet (HttpServletRequest request,
//                HttpServletResponse response) throws ServletException, IOException {
//            doPost(request, response);
//        }
//
//}