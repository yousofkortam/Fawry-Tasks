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

@WebServlet("/catalog/my-products")
public class MyProductsServlet extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        String email = (String) session.getAttribute("user");
        List<Product> myProducts = ProductRepository.getUserProducts(email);
        Writer writer = resp.getWriter();
        writer.write("<a href=\"/WebTask_war_exploded/catalog/products\">All Products</a><br>");
        writer.write("<a href=\"/WebTask_war_exploded/catalog/add-product\">Add Product</a>");
        writer.write("<h1>Hello " + email + ", Your Products 👇</h1><br>");
        for (Product product : myProducts) {
            writer.write("<h1>Name: " + product.getName() + "</h1><br><h1>Price: " + product.getPrice() + "</h1><hr>");
        }
    }
}
