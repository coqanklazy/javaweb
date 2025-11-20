package controller;

import model.Cart;
import model.LineItem;
import model.Product;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/cart")
public class CartController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Forward to cart.jsp
        getServletContext()
                .getRequestDispatcher("/c07/cart.jsp")
                .forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession session = request.getSession();

        // Get cart from session
        Cart cart = (Cart) session.getAttribute("cart");
        if (cart == null) {
            cart = new Cart();
        }

        // Get action parameter
        String action = request.getParameter("action");

        if (action != null && action.equals("add")) {
            // Add item to cart
            String productCode = request.getParameter("productCode");
            String productName = request.getParameter("productName");
            String productPrice = request.getParameter("productPrice");

            Product product = new Product();
            product.setCode(productCode);
            product.setName(productName);
            product.setPrice(Double.parseDouble(productPrice));

            LineItem item = new LineItem();
            item.setProduct(product);
            item.setQuantity(1);

            cart.addItem(item);

        } else if (action != null && action.equals("update")) {
            // Update quantity
            String productCode = request.getParameter("productCode");
            String quantity = request.getParameter("quantity");

            if (quantity != null && !quantity.isEmpty()) {
                int qty = Integer.parseInt(quantity);
                if (qty > 0) {
                    cart.updateQuantity(productCode, qty);
                } else {
                    cart.removeItem(productCode);
                }
            }

        } else if (action != null && action.equals("remove")) {
            // Remove item
            String productCode = request.getParameter("productCode");
            cart.removeItem(productCode);
        }

        // Save cart to session
        session.setAttribute("cart", cart);

        // Forward to cart.jsp
        getServletContext()
                .getRequestDispatcher("/c07/cart.jsp")
                .forward(request, response);
    }
}

