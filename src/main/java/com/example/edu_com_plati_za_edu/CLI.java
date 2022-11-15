package com.example.edu_com_plati_za_edu;

import com.example.edu_com_plati_za_edu.entity.*;

import javax.xml.crypto.dsig.dom.DOMValidateContext;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CLI {
    private static final String chooseTable = "Choose table: \n1 - student; \n2 - teacher; \n3 - course_stud; \n4 - group_stud; \n5 - class_stud; \n";
    private static final String chooseAction = "Choose action: \n 1 - create; \n 2 - read; \n 3 - update\n 4- delete; \n";
    private static final String createText = "Enter element's attributes: \n";
    private static final String chooseRead = "Choose action: \n1 - find by id; \n2 - read whole table; \n";
    private static final String byIdText = "Enter id: \n";
    private static final String ChooseUpdate = "Choose attr to update (0-4) \n";
    private static final String tryAgain = "invalid args. Try again \n";
    DBRepo dbRepo = new DBRepo();
    private static final String exceptionText = "Something went wrong. Try again";


    public void start() {
        Scanner in = new Scanner(System.in);
        try {
            while (true) {
                print(chooseTable);
                int chosenTable = in.nextInt();
                if (chosenTable < 0 || chosenTable > 5) {
                    print(tryAgain);
                    continue;
                }
                print(chooseAction);
                int input = in.nextInt();

                switch (input) {
                    case 1:
                        create(in, chosenTable);
                        break;
                    case 2:
                        read(in, chosenTable);
                        break;
                    case 3:
                        break;
                    case 4:
                        delete(in, chosenTable);
                        break;
                    default:
                        System.exit(0);

                }

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void delete(Scanner in, int chosenTable) {
        print(byIdText);
        int input = in.nextInt();
        try {
            switch (chosenTable) {
                case 1:
                    dbRepo.deleteByIdFrom(input, Student.class);
                    break;
                case 2:
                    dbRepo.deleteByIdFrom(input, Teacher.class);
                    break;
                case 3:
                    dbRepo.deleteByIdFrom(input, Course.class);
                    break;
                case 4:
                    dbRepo.deleteByIdFrom(input, GroupStud.class);
                    break;
                case 5:
                    dbRepo.deleteByIdFrom(input, ClassStud.class);
                    break;
            }
        } catch (SQLException e){
            System.out.println(exceptionText);
        }
    }

    private static void update(Connection con, Scanner in, int chosenTable) {

    }

    private void read(Scanner in, int chosenTable) {
        print(chooseRead);
        int input = in.nextInt();
        try {
            switch (input) {
                case 1:
                    print(byIdText);
                    input = in.nextInt();
                    switch (chosenTable) {
                        case 1:
                            Student student = (Student) dbRepo.findById(input, Student.class);
                            print(student.toString());
                            break;
                        case 2:
                            Teacher teacher = (Teacher) dbRepo.findById(input, Teacher.class);
                            print(teacher.toString());
                            break;
                        case 3:
                            Course course = (Course) dbRepo.findById(input, Course.class);
                                print(course.toString());
                            break;
                        case 4:
                            GroupStud groupStud = (GroupStud) dbRepo.findById(input, GroupStud.class);
                                print(groupStud.toString());
                            break;
                        case 5:
                            ClassStud classStud = (ClassStud) dbRepo.findById(input, ClassStud.class);
                                print(classStud.toString());
                            break;
                        default:
                            print(tryAgain);
                    }
                    break;
                case 2:
                    switch (chosenTable) {
                        case 1:
                            List<MyEntity> students = dbRepo.getAll(Student.class);
                            for (MyEntity entity : students) {
                                Student student = (Student) entity;
                                print(student.toString());
                            }
                            break;
                        case 2:
                            List<MyEntity> teachers = dbRepo.getAll(Teacher.class);
                            for (MyEntity entity : teachers) {
                                Teacher teacher = (Teacher) entity;
                                print(teacher.toString());
                            }
                            break;
                        case 3:
                            List<MyEntity> courses = dbRepo.getAll(Course.class);
                            for (MyEntity entity : courses) {
                                Course course = (Course) entity;
                                print(course.toString());
                            }
                            break;
                        case 4:
                            List<MyEntity> groups = dbRepo.getAll(GroupStud.class);
                            for (MyEntity entity : groups) {
                                GroupStud group = (GroupStud) entity;
                                print(group.toString());
                            }
                            break;
                        case 5:
                            List<MyEntity> classStuds = dbRepo.getAll(ClassStud.class);
                            for (MyEntity entity : classStuds) {
                                ClassStud classStud = (ClassStud) entity;
                                print(classStud.toString());
                            }
                            break;
                        default:
                            print(tryAgain);
                    }
                    break;
            }
        } catch(SQLException e){
            System.out.println(exceptionText);
        }
    }

    private void create(Scanner in, int chosenTable) {
        print(createText);
        switch (chosenTable) {
            case 1:
                print("email, fio, group_id \n");
                String email = in.nextLine();
                String fio = in.nextLine();
                int groupId = in.nextInt();
                Student student = new Student(0, email, fio, groupId);
                dbRepo.insert(student);
                break;
            case 2:
                print("email, fio, number \n");

                email = in.nextLine();
                fio = in.nextLine();
                String number = in.nextLine();
                Teacher teacher = new Teacher(0, email, fio, number);
                dbRepo.insert(teacher);
                break;
            case 3:
                print("subject, price, teacher_id");
                String subject = in.nextLine();
                int price = in.nextInt();
                int teacher_id = in.nextInt();
                Course course = new Course(0, subject, price, teacher_id);
                dbRepo.insert(course);
                break;
            case 4:
                print("group_number, course_id");
                int group_number = in.nextInt();
                int course_id = in.nextInt();
                GroupStud groupStud = new GroupStud(0, group_number, course_id);
                dbRepo.insert(groupStud);
                break;
            case 5:
                print("start_at, room_no, group_id, teacher_id");
                String start_at = in.nextLine();
                int room_no = in.nextInt();
                int group_id = in.nextInt();
                teacher_id = in.nextInt();
                ClassStud classStud = new ClassStud(0, start_at,room_no, group_id, teacher_id);
                dbRepo.insert(classStud);
                break;
        }
    }


    private static void print(String s) {
        System.out.println(s);
    }
}
