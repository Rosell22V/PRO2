package src.controller;


import src.model.Student;
import src.model.Team;
import src.storage.Storage;


public abstract class Controller {
    private static Storage storage;

    public static void setStorage(Storage storage) {
        Controller.storage = storage;
    }

    //-----------------------------------------------------

    public static Team createTeam(String name, String room) {
        Team t = new Team(name, room);
        storage.addTeam(t);
        return t;
    }

    public static Student createStudent(String name, int age) {
        Student s = new Student(name, age);
        storage.addStudent(s);
        return s;
    }

    public static void addStudentToTeam(Student s, Team t) {
        t.addStudent(s);
    }

    public static void updateTeam(Team t, String name, String room) {
        t.setName(name);
        t.setRoom(room);
    }
}
