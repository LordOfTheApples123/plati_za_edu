package com.example.edu_com_plati_za_edu;

import com.example.edu_com_plati_za_edu.entity.*;

import java.sql.Connection;
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

    public static void start() {
        Scanner in = new Scanner(System.in);
        try {
            Connection con = ConnectionMgr.getNewConnection();
            while (true) {
                print(chooseTable);
                int chosenTable = in.nextInt();
                if (chosenTable < 0 && chosenTable > 5) {
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
                        read(con, in, chosenTable);
                        break;
                    case 3:
                        update(con, in, chosenTable);
                        break;
                    case 4:
                        delete(con, in, chosenTable);
                        break;
                    default:
                        con.close();
                        System.exit(0);

                }

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void delete(Connection con, Scanner in, int chosenTable) {
        int input = in.nextInt();
        switch (chosenTable) {
            case 1:
                DBRepo.deleteByIdFrom(input, "student");
                break;
            case 2:
                DBRepo.deleteByIdFrom(input, "teacher");
                break;
            case 3:
                DBRepo.deleteByIdFrom(input, "course");
                break;
            case 4:
                DBRepo.deleteByIdFrom(input, "group_stud");
                break;
            case 5:
                DBRepo.deleteByIdFrom(input, "class_stud");
                break;
        }
    }

    private static void update(Connection con, Scanner in, int chosenTable) {

    }

    private static void read(Connection con, Scanner in, int chosenTable) {
        print(chooseRead);
        int input = in.nextInt();
        switch (input) {
            case 1:
                print(byIdText);
                switch (chosenTable) {
                    case 1:
                        Student student = DBRepo.findStudentById(input);
                        if (student != null) {
                            print(student.toString());
                        } else print("not found");
                        break;
                    case 2:
                        Teacher teacher = DBRepo.findTeacherById(input);
                        if (teacher != null) {
                            print(teacher.toString());
                        } else print("not found");
                        break;
                    case 3:
                        Course course = DBRepo.findCourseById(input);
                        if (course != null) {
                            print(course.toString());
                        } else print("not found");
                        break;
                    case 4:
                        GroupStud groupStud = DBRepo.findGroupById(input);
                        if (groupStud != null) {
                            print(groupStud.toString());
                        } else print("not found");
                        break;
                    case 5:
                        ClassStud classStud = DBRepo.findClassById(input);
                        if (classStud != null) {
                            print(classStud.toString());
                        } else print("not found");
                        break;
                    default:
                        print(tryAgain);
                }
                break;
            case 2:
                switch (chosenTable) {
                    case 1:
                        List<Student> students = DBRepo.getStudents();
                        for (Student stud : students) {
                            print(stud.toString());
                        }
                        break;
                    case 2:
                        List<Teacher> teachers = DBRepo.getTeachers();
                        for (Teacher teacher : teachers) {
                            print(teacher.toString());
                        }
                        break;
                    case 3:
                        List<Course> course = DBRepo.getCourses();
                        for (Course course1 : course) {
                            print(course1.toString());
                        }
                        break;
                    case 4:
                        List<GroupStud> groups = DBRepo.getGroups();
                        for (GroupStud group : groups) {
                            print(group.toString());
                        }
                        break;
                    case 5:
                        List<ClassStud> classStuds = DBRepo.getClasses();
                        for (ClassStud classStud : classStuds) {
                            print(classStud.toString());
                        }
                        break;
                    default:
                        print(tryAgain);
                }
                break;
        }
    }

    private static void create(Scanner in, int chosenTable) {
        print(createText);
        switch (chosenTable) {
            case 1:
                print("id, email, fio, group_id \n");
                Student st = new Student(in.nextInt(), in.nextLine(), in.nextLine(), in.nextInt());
                DBRepo.insert(st);
                break;
            case 2:
                print("id, email, fio, number \n");
                Teacher teacher = new Teacher(in.nextInt(), in.nextLine(), in.nextLine(), in.nextLine());
                DBRepo.insert(teacher);
                break;
            case 3:
                print("id, subject, price, teacher_id");
                Course course = new Course(in.nextInt(), in.nextLine(), in.nextInt(), in.nextInt());
                DBRepo.insert(course);
                break;
            case 4:
                print("id, group_number, course_id");
                GroupStud groupStud = new GroupStud(in.nextInt(), in.nextInt(), in.nextInt());
                DBRepo.insert(groupStud);
                break;
            case 5:
                print("id, start_at, room_no, group_id, teacher_id");
                ClassStud classStud = new ClassStud(in.nextInt(), in.nextLine(), in.nextInt(), in.nextInt(), in.nextInt());
                DBRepo.insert(classStud);
                break;
        }
    }


    private static void print(String s) {
        System.out.println(s);
    }
}
