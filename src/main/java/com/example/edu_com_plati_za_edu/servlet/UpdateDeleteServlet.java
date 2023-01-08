package com.example.edu_com_plati_za_edu.servlet;

import com.example.edu_com_plati_za_edu.DBRepo;
import com.example.edu_com_plati_za_edu.entity.GroupStud;
import com.example.edu_com_plati_za_edu.entity.Student;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.SQLException;
@WebServlet("/update_delete")
public class UpdateDeleteServlet extends HttpServlet {
    DBRepo dbRepo = new DBRepo();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if(req.getParameter("delete")!=null){
            try {
                dbRepo.deleteByIdFrom(Integer.parseInt(req.getParameter("delete")),
                        Class.forName(req.getParameter("class")));
                req.getRequestDispatcher("/studentCR").forward(req, resp);
            } catch (SQLException | ClassNotFoundException e) {
                throw new RuntimeException(e);
            }
        } else if (req.getParameter("update")!=null) {
            switch (req.getParameter("class")){
                case "student":
                    try {
                        Student student = (Student) dbRepo.findById(Integer.parseInt(req.getParameter("update")), Student.class);
                        req.setAttribute("student", student);
                        req.setAttribute("groupsList", new DBRepo().getAll(GroupStud.class));
                        req.getRequestDispatcher("/formStudents.jsp").forward(req, resp);
                    } catch (SQLException e) {
                        throw new RuntimeException(e);
                    }
                    break;
                case "course":
                    break;
                case "groupStud":
                    break;
                case "teacher":
                    break;
            }

        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        switch (req.getParameter("class")){
            case "student":
                int id = Integer.parseInt(req.getParameter("id"));
                String fio = req.getParameter("name");
                String email = req.getParameter("email");
                int group_id = Integer.parseInt(req.getParameter("group_number"));
                dbRepo.update(new Student(id, email, fio, group_id));
                req.getRequestDispatcher("/formStudents.jsp").forward(req, resp);
                break;
            case "course":
                break;
            case "groupStud":
                break;
            case "teacher":
                break;
        }

    }
}
