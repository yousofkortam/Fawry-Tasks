package org.example.Servlet;

import org.example.Models.Product;
import org.example.Repository.ProductRepository;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.Writer;
import java.util.List;

@WebServlet("/catalog/products")
public class ProductServlet extends HttpServlet {

    public static int counter = 100;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Product> products = ProductRepository.getProducts();
        Writer writer = resp.getWriter();
        resp.setContentType("text/html");
        writer.write("<a href=\"/WebTask_war_exploded/catalog/my-products\">My Products</a><br>");
        writer.write("<a href=\"/WebTask_war_exploded/catalog/add-product\">Add Product</a>");
        for (Product product : products) {
            writer.write("<h1>Name: " + product.getName() + "</h1><br><h1>Price: " + product.getPrice() + "</h1><br><h1>Owner Email: " + product.getOwnerEmail() + "</h1><hr>");
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        String email = (String) session.getAttribute("user");
        String name = req.getParameter("name");
        double price = Double.parseDouble(req.getParameter("price"));
        Product product = new Product(counter++, name, price, email);
        ProductRepository.addProduct(product);
        resp.sendRedirect("/WebTask_war_exploded/catalog/my-products");
    }
}
