package com.example.edu_com_plati_za_edu.servlet;

import com.example.edu_com_plati_za_edu.DBRepo;
import com.example.edu_com_plati_za_edu.entity.Student;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.SQLException;
@WebServlet("/deleteStudentById")
public class deleteStudentServlet extends HttpServlet {
    DBRepo dbRepo = new DBRepo();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("delete_id"));

        try {
            dbRepo.deleteByIdFrom(id, Student.class);

            req.getRequestDispatcher("/success.jsp").forward(req, resp);
        } catch (SQLException e) {
            req.setAttribute("error_message", "student not found");
            req.getRequestDispatcher("/error.jsp").forward(req, resp);
        }
    }
}
