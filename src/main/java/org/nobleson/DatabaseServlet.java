package org.nobleson;

import org.nobleson.db.DatabaseUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

@WebServlet("/database")
public class DatabaseServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        try (Connection connection = DatabaseUtil.getConnection()) {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM user");

            PrintWriter out = response.getWriter();
            out.println("<html><body>");
            while (resultSet.next()) {
                out.println( "<p>" +  "Name: " +  resultSet.getString("name") + "</p>");
                out.println( "<p>" +"Age: " + resultSet.getString("age") + "</p>");
            }
            out.println("</body></html>");
        } catch (SQLException e) {
            throw new ServletException("Database access error", e);
        }
    }
}
