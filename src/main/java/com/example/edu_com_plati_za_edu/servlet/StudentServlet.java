package com.example.edu_com_plati_za_edu.servlet;

import com.example.edu_com_plati_za_edu.DBRepo;
import com.example.edu_com_plati_za_edu.entity.GroupStud;
import com.example.edu_com_plati_za_edu.entity.MyEntity;
import com.example.edu_com_plati_za_edu.entity.Student;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/studentCR")
public class StudentServlet extends HttpServlet {
    DBRepo dbRepo = new DBRepo();

    static String PAGE_HEADER = "<html><head><title>helloworld</title></head><body>";

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int page = 1;
        int recordsPerPage = 50;

        if (req.getParameter("page") != null)
            page = Integer.parseInt(req.getParameter("page"));

        try {
            int noOfRecords = dbRepo.getAll(Student.class).size();
            int noOfPages = noOfRecords / recordsPerPage;
            if (noOfRecords % recordsPerPage != 0) {
                noOfPages++;
            }
            req.setAttribute("noOfPages", noOfPages);
            req.setAttribute("page", page);
            req.setAttribute("recordsPerPage", recordsPerPage);
            List<Student> students = new ArrayList<>();
            if (req.getParameter("findById") != null) {
                students.add((Student) dbRepo.findById(Integer.parseInt(
                                req.getParameter("find_id")),
                        Student.class));
            } else if (req.getParameter("findByFio") != null) {
                students =dbRepo.findStudentsByFio(req.getParameter("fio"));

            } else {
                List<MyEntity> studentList = dbRepo.getAll(Student.class);

                for (MyEntity entity : studentList) {
                    Student student = (Student) entity;
                    students.add(student);
                }
            }
            req.setAttribute("list", students);
            req.setAttribute("groupsList", dbRepo.getAll(GroupStud.class));
            req.getRequestDispatcher("/getStudents.jsp").forward(req, resp);
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
