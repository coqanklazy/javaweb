package email;

import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import business.User;
import data.UserDB;
import util.*;

/**
 *
 * @author lequa
 */
@WebServlet(name = "EmailListServlet", urlPatterns = {"/emailList"})
public class EmailListServlet extends HttpServlet {

    // ... (Giữ nguyên phần processRequest và doGet) ...
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            out.println("<!DOCTYPE html>");
            out.println("<html><head><title>Servlet EmailListServlet</title></head><body>");
            out.println("<h1>Servlet EmailListServlet at " + request.getContextPath() + "</h1>");
            out.println("</body></html>");
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doPost(request, response);
    }

    // --- PHẦN QUAN TRỌNG: Cập nhật doPost ---
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        request.setCharacterEncoding("UTF-8"); // Đảm bảo nhận tiếng Việt đúng

        // get current action
        String action = request.getParameter("action");
        if(action == null) {
            action = "join";
        }
        
        String url = "/index.jsp";
        
        if(action.equals("join")) {
            url = "/index.jsp";
        } 
        else if (action.equals("add")) {
            // get parameters
            String firstName = request.getParameter("firstName");
            String lastName = request.getParameter("lastName");
            String email = request.getParameter("email");

            // store data
            User user = new User();
            user.setEmail(email);
            user.setFirstName(firstName);
            user.setLastName(lastName);
            
            String message;
            if (UserDB.emailExists(user.getEmail())) {
                message = "This email address already exists.<br>" +
                                 "Please enter another email address.";
                
                // QUAN TRỌNG: Phải set attribute để JSP hiển thị được lỗi
                request.setAttribute("message", message); 
                
                // Quay về trang nhập liệu
                url = "/index.jsp"; 
            } 
            else {
                // 2. Chỉ thực hiện khi email chưa tồn tại (Khối ELSE)
                UserDB.insert(user);
                request.setAttribute("user", user);
                
                // --- GỬI EMAIL HTML ---
                String to = email;
                String from = "leduyhung412max@gmail.com";
                String subject = "Welcome to our email list";
                String body = createHtmlEmailBody(firstName);
                boolean isBodyHTML = true;

                try {
                    MailUtilGmail.sendMail(to, from, subject, body, isBodyHTML);
                } catch (Exception e) {
                    String errorMessage = 
                        "ERROR: Unable to send email. " + 
                            "Check logs for details.<br>" +
                        "ERROR MESSAGE: " + e.getMessage();
                    request.setAttribute("errorMessage", errorMessage);
                    this.log("Unable to send email to " + email);
                    e.printStackTrace();
                }            
                
                // Chỉ chuyển sang trang cảm ơn khi thành công
                url = "/thanks.jsp";
            }
        }
        
        getServletContext()
                .getRequestDispatcher(url)
                .forward(request, response);
    }

    /**
     * Hàm hỗ trợ tạo nội dung HTML style Tailwind
     */
    private String createHtmlEmailBody(String name) {
        StringBuilder sb = new StringBuilder();

        // Wrapper: bg-gray-100 (màu nền xám nhẹ)
        sb.append("<div style=\"background-color: #f3f4f6; padding: 40px 0; font-family: sans-serif;\">");

        // Container: max-w-md, mx-auto (căn giữa)
        sb.append("  <div style=\"max-width: 600px; margin: 0 auto; padding: 0 20px;\">");

        // Card: bg-white, rounded-lg, shadow-lg (thẻ trắng, bo góc, đổ bóng)
        sb.append("    <div style=\"background-color: #ffffff; padding: 32px; border-radius: 12px; box-shadow: 0 4px 6px rgba(0,0,0,0.1);\">");

        // Header (Logo text): text-blue-600, font-bold, text-2xl
        sb.append("      <h2 style=\"color: #2563eb; font-size: 24px; font-weight: bold; margin-top: 0; margin-bottom: 24px; text-align: center;\">Email List</h2>");

        // Divider
        sb.append("      <div style=\"border-bottom: 1px solid #e5e7eb; margin-bottom: 24px;\"></div>");

        // Greeting: text-gray-800
        sb.append("      <p style=\"font-size: 16px; color: #1f2937; margin-bottom: 16px;\">Dear <strong>").append(name).append("</strong>,</p>");

        // Body Text: text-gray-600
        sb.append("      <p style=\"font-size: 16px; color: #4b5563; line-height: 1.5; margin-bottom: 16px;\">");
        sb.append("        Thanks for joining our email list. We'll make sure to send you announcements about new products and promotions.");
        sb.append("      </p>");

        sb.append("      <p style=\"font-size: 16px; color: #4b5563; line-height: 1.5; margin-bottom: 32px;\">");
        sb.append("        Have a great day and thanks again!");
        sb.append("      </p>");

        // Button (Call to action): bg-blue-600, text-white, rounded
        sb.append("      <div style=\"text-align: center; margin-bottom: 32px;\">");
//        sb.append("        <a href=\"#\" style=\"background-color: #2563eb; color: #ffffff; padding: 12px 24px; text-decoration: none; border-radius: 6px; font-weight: bold; display: inline-block;\">Visit Website</a>");
        sb.append("      </div>");

        sb.append("  </div>"); // End Container
        sb.append("</div>"); // End Wrapper

        return sb.toString();
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }
}