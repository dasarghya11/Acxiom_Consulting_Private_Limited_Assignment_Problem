package controller;

import javax.servlet.*;
import javax.servlet.http.*;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.*;
import util.DBConnection;

public class AddBookServlet extends HttpServlet {

    protected void doPost(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {

        String name = req.getParameter("name");
        String author = req.getParameter("author");
        String type = req.getParameter("type");

        if (name.isEmpty() || author.isEmpty()) {
            req.setAttribute("error", "All fields are mandatory");
            req.getRequestDispatcher("addBook.jsp").forward(req, res);
            return;
        }

        try {
            Connection con = DBConnection.getConnection();
            PreparedStatement ps = con.prepareStatement(
                "INSERT INTO books(name,author,type,available) VALUES(?,?,?,true)");
            ps.setString(1, name);
            ps.setString(2, author);
            ps.setString(3, type);
            ps.executeUpdate();

            res.sendRedirect("adminHome.jsp");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

