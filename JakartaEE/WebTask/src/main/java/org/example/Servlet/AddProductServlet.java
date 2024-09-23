package org.example.Servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.Writer;

@WebServlet("/catalog/add-product")
public class AddProductServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Writer writer =resp.getWriter();
        writer.write("""
                <!DOCTYPE html>
                <html lang="en">
                <head>
                    <meta charset="UTF-8">
                    <meta name="viewport" content="width=device-width, initial-scale=1.0">
                    <title>Add Product</title>
                </head>
                <body>
                    <h2>Add Product</h2>
                    <form action="products" method="POST">
                        <label for="productName">Product Name:</label>
                        <input type="text" id="name" name="name" required><br><br>
                
                        <label for="price">Price:</label>
                        <input type="number" id="price" name="price" step="0.01" required><br><br>
                
                        <button type="submit">Add Product</button>
                    </form>
                </body>
                </html>
                """);
    }
}
