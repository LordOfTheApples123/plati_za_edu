package com.example.edu_com_plati_za_edu.servlet;

import com.example.edu_com_plati_za_edu.DBRepo;
import com.example.edu_com_plati_za_edu.entity.Course;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.SQLException;

@WebServlet("/courseForm")
public class CourseFormServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            req.setAttribute("list", new DBRepo().getAll(Course.class));
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        req.getRequestDispatcher("/formCourses.jsp").forward(req, resp);
    }
}
