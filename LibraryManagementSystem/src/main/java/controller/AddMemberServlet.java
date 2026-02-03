package controller;

import javax.servlet.*;
import javax.servlet.http.*;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.*;
import java.time.LocalDate;
import util.DBConnection;

public class AddMemberServlet extends HttpServlet {

    protected void doPost(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {

        String name = req.getParameter("name");
        int months = Integer.parseInt(req.getParameter("months"));

        if (name.isEmpty()) {
            req.setAttribute("error", "Name is mandatory");
            req.getRequestDispatcher("addMember.jsp").forward(req, res);
            return;
        }

        try {
            LocalDate expiry = LocalDate.now().plusMonths(months);
            Connection con = DBConnection.getConnection();
            PreparedStatement ps = con.prepareStatement(
                "INSERT INTO membership(name,expiry_date) VALUES(?,?)");
            ps.setString(1, name);
            ps.setDate(2, Date.valueOf(expiry));
            ps.executeUpdate();

            res.sendRedirect("adminHome.jsp");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
