package com.example.edu_com_plati_za_edu.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
@WebServlet("/course")
public class CourseServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter pw = resp.getWriter();
        pw.write("<!DOCTYPE html>\n" +
                "<html>\n" +
                "<body>\n" +
                "\n" +
                "<h1>My First Heading</h1>\n" +
                "\n" +
                "<form action=\"http://localhost:8080/Gradle___com_example___edu_com_plati_za_edu_1_0_SNAPSHOT_war__exploded_/create_course\" method=\"get\" class=\"form-\">\n" +
                "    <div>\n" +
                "        <input type = \"Submit\" value = \"getAll\">\n" +
                "    </div>\n" +
                "</form>\n" +
                "\n" +
                "<form action=\"http://localhost:8080/Gradle___com_example___edu_com_plati_za_edu_1_0_SNAPSHOT_war__exploded_/create_course\" method=\"post\" class=\"form-create\">\n" +
                "    <div class=\"form-example\">\n" +
                "        <label for=\"name\">subject: </label>\n" +
                "        <input type=\"text\" name=\"subject\" id=\"subject\" required>\n" +
                "    </div>\n" +
                "    <div class=\"form-example\">\n" +
                "        <label for=\"price\">email: </label>\n" +
                "        <input type=\"number\" name=\"price\" id=\"price\" required>\n" +
                "    </div>\n" +
                "    <div class=\"form-example\">\n" +
                "        <label for=\"group_id\">group_id: </label>\n" +
                "        <input type=\"number\" name=\"group_id\" id=\"group_id\" required>\n" +
                "    </div>\n" +
                "    <div class=\"form-example\">\n" +
                "        <input type=\"submit\" value=\"Submit!\">\n" +
                "    </div>\n" +
                "</form>\n" +
                "\n" +
                "<form action=\"http://localhost:8080/Gradle___com_example___edu_com_plati_za_edu_1_0_SNAPSHOT_war__exploded_/deleteStudent\" method=\"get\" class=\"form-create\">\n" +
                "    <div class=\"form-example\">\n" +
                "        <label for=\"id\">id: </label>\n" +
                "        <input type=\"number\" name=\"id\" id=\"id\" required>\n" +
                "    </div>\n" +
                "    <div class=\"form-example\">\n" +
                "        <input type=\"submit\" value=\"delete\">\n" +
                "    </div>\n" +
                "</form>\n" +
                "\n" +
                "</body>\n" +
                "</html>");
    }
}
