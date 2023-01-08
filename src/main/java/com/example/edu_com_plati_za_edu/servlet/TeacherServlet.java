package com.example.edu_com_plati_za_edu.servlet;

import com.example.edu_com_plati_za_edu.DBRepo;
import com.example.edu_com_plati_za_edu.entity.MyEntity;
import com.example.edu_com_plati_za_edu.entity.Student;
import com.example.edu_com_plati_za_edu.entity.Teacher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/teacher")
public class TeacherServlet extends HttpServlet {
    DBRepo dbRepo = new DBRepo();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            List<Teacher> students = new ArrayList<>();
            if (req.getParameter("action")  != null) {
                students.add((Teacher) dbRepo.findById(Integer.parseInt(
                                req.getParameter("find_id")),
                        TeacherServlet.class));
            }else {
                List<MyEntity> studentList = dbRepo.getAll(Teacher.class);

                for (MyEntity entity : studentList) {
                    Teacher student = (Teacher) entity;
                    students.add(student);
                }}
            req.setAttribute("list", students);
            req.getRequestDispatcher("/getTeachers.jsp").forward(req, resp);
        } catch (SQLException e) {
            req.setAttribute("error_message", "student not found");

            req.getRequestDispatcher("/error.jsp").forward(req, resp);
        }
    }
}
