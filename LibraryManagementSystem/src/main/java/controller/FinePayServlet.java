package controller;

import javax.servlet.*;
import javax.servlet.http.*;

import org.apache.catalina.filters.ExpiresFilter.XHttpServletResponse;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;

import java.io.IOException;
import java.sql.*;
import util.DBConnection;

public class FinePayServlet extends HttpServlet {

    protected void doPost(HttpServletRequest req, XHttpServletResponse res)
            throws ServletException, IOException {

        int transId = Integer.parseInt(req.getParameter("transId"));
        boolean paid = req.getParameter("paid") != null;

        try {
            Connection con = DBConnection.getConnection();
            PreparedStatement ps = con.prepareStatement(
                "UPDATE transactions SET fine_paid=? WHERE trans_id=?");
            ps.setBoolean(1, paid);
            ps.setInt(2, transId);
            ps.executeUpdate();

            res.sendRedirect("userHome.jsp");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

