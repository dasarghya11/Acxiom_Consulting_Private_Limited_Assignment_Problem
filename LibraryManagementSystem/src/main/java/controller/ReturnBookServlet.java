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
import java.time.temporal.ChronoUnit;
import util.DBConnection;

public class ReturnBookServlet extends HttpServlet {

    protected void doPost(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {

        int transId = Integer.parseInt(req.getParameter("transId"));

        try {
            Connection con = DBConnection.getConnection();
            PreparedStatement ps = con.prepareStatement(
                "SELECT return_date FROM transactions WHERE trans_id=?");
            ps.setInt(1, transId);

            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                LocalDate due = rs.getDate("return_date").toLocalDate();
                long lateDays = ChronoUnit.DAYS.between(due, LocalDate.now());
                double fine = lateDays > 0 ? lateDays * 2 : 0;

                req.setAttribute("fine", fine);
                req.setAttribute("transId", transId);
                req.getRequestDispatcher("finePay.jsp").forward(req, res);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
