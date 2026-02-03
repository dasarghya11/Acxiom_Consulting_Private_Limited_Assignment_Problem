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

public class IssueBookServlet extends HttpServlet {

    protected void doPost(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {

        int bookId = Integer.parseInt(req.getParameter("bookId"));
        int memberId = Integer.parseInt(req.getParameter("memberId"));
        LocalDate issueDate = LocalDate.now();
        LocalDate returnDate = LocalDate.parse(req.getParameter("returnDate"));

        if (returnDate.isAfter(issueDate.plusDays(15))) {
            req.setAttribute("error", "Return date cannot exceed 15 days");
            req.getRequestDispatcher("issueBook.jsp").forward(req, res);
            return;
        }

        try {
            Connection con = DBConnection.getConnection();
            PreparedStatement ps = con.prepareStatement(
                "INSERT INTO transactions(book_id,member_id,issue_date,return_date,fine,fine_paid) VALUES(?,?,?,?,0,false)");
            ps.setInt(1, bookId);
            ps.setInt(2, memberId);
            ps.setDate(3, Date.valueOf(issueDate));
            ps.setDate(4, Date.valueOf(returnDate));
            ps.executeUpdate();

            PreparedStatement ps2 = con.prepareStatement(
                "UPDATE books SET available=false WHERE book_id=?");
            ps2.setInt(1, bookId);
            ps2.executeUpdate();

            res.sendRedirect("userHome.jsp");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

