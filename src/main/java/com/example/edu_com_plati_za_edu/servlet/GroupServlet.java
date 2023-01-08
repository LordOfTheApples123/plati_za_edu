package com.example.edu_com_plati_za_edu.servlet;

import com.example.edu_com_plati_za_edu.DBRepo;
import com.example.edu_com_plati_za_edu.entity.GroupStud;
import com.example.edu_com_plati_za_edu.entity.MyEntity;
import com.example.edu_com_plati_za_edu.entity.Student;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/group")
public class GroupServlet extends HttpServlet {
    DBRepo dbRepo = new DBRepo();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


        try {
            List<GroupStud> students = new ArrayList<>();
            if (req.getParameter("action")  != null) {
                students.add((GroupStud) dbRepo.findById(Integer.parseInt(
                                req.getParameter("find_id")),
                        Student.class));
            }else {
                List<MyEntity> studentList = dbRepo.getAll(GroupStud.class);

                for (MyEntity entity : studentList) {
                    GroupStud student = (GroupStud) entity;
                    students.add(student);
                }}
            req.setAttribute("list", students);
            req.setAttribute("dbrepo", dbRepo);
            req.getRequestDispatcher("/getGroups.jsp").forward(req, resp);
        } catch (SQLException e) {
            req.setAttribute("error_message", "student not found");

            req.getRequestDispatcher("/error.jsp").forward(req, resp);
        }


    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        String email = req.getParameter("email");
        int group_id = Integer.parseInt(req.getParameter("group_id"));
        try {
            dbRepo.insert(new Student(0, name, email, group_id));
        } catch (SQLException e) {
            req.setAttribute("error_message", "group_id is not vaild");
            req.getRequestDispatcher("/error.jsp").forward(req, resp);
        }
        req.getRequestDispatcher("/success.jsp").forward(req, resp);
    }
}
