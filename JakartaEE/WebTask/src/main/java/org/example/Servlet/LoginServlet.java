package org.example.Servlet;

import org.example.Repository.UserRepository;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.Writer;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Writer writer = resp.getWriter();
        writer.write("""
                <!DOCTYPE html>
                <html>
                <head>
                <meta charset="UTF-8">
                </head>
                <body>
                <h1>Login Form</h1>
                <form action='login' method='post'>
                <input type="text" name="email" id="email" required><br>
                <input type="password" name="password" id="password" required><br>
                <input type='submit' value='Login'/>
                </form>
                </body>
                </html>
                """);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String email = req.getParameter("email");
        String password = req.getParameter("password");

        boolean isAuthenticated = UserRepository.isAuthenticated(email, password);

        if (isAuthenticated) {
            HttpSession session = req.getSession();
            session.setAttribute("user", email);
            resp.sendRedirect("catalog/products");
        } else {
            Writer writer = resp.getWriter();
            writer.write("""
                <!DOCTYPE html>
                <html>
                <head>
                <meta charset="UTF-8">
                </head>
                <body>
                <h1>Login Form</h1>
                <p style="color: red">Email or Password is incorrect</p>
                <form action='login' method='post'>
                <input type="text" name="email" id="email" value="
                """ + email + """
                " required><br>
                <input type="password" name="password" id="password" required><br>
                <input type='submit' value='Login'/>
                </form>
                </body>
                </html>
                """);
        }
    }
}
