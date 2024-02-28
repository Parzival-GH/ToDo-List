package service;


import model.Tasks;
import repository.TaskRepo;
import java.sql.Statement;

import java.sql.*;
import java.util.ArrayList;
import java.util.Scanner;

public class TaskService {
    public Tasks tasks;

    private int nextTaskId;


    public void identifier() {
        ArrayList<Tasks> idNum = new ArrayList<>();
        this.nextTaskId = 1;
    }


    public TaskRepo taskRepo;
    Statement statement;
    public TaskService(TaskRepo taskRepo, Tasks tasks) {
        this.taskRepo = taskRepo;
        this.tasks = tasks;
    }

    public void createTask() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите задачу: ");
        String name = scanner.next();
        scanner.nextLine();
        try {
            taskRepo.statement.execute(String.format("insert into tasks (description, status) values('%s', '%s')", name, "Назначено"));
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        System.out.println("Задача успешно добавлена! Идентификатор задачи: " + ++nextTaskId);

    }

    public void editTask(){
        System.out.println("Введите идентификатор задачи для редактирования: ");
        Scanner scanner = new Scanner(System.in);
        int identifier = scanner.nextInt();
        if (identifier != nextTaskId){
            System.out.println("Задачи с данным идентификатором не существует");
        } else {
            System.out.println("Введите новое описание задачи: ");
            String name = scanner.next();
            scanner.nextLine();
            try {
                taskRepo.statement.execute(String.format("update tasks set description = '"+name+"' where id = '"+identifier+"'"));
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
            System.out.println("Задача перезаписана");
        }
    }

    public void deleteTask(){
        System.out.println("Введите идентификатор задачи для удаления: ");
        Scanner scanner1 =  new Scanner(System.in);
        int deleteTask = scanner1.nextInt();
        if (deleteTask != nextTaskId){
            System.out.println("Задачи с данным идентификатором не существует");
        } else {
            try {
                taskRepo.statement.execute(String.format("delete from tasks where id = '"+nextTaskId+"'"));
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
            System.out.println("Задача удалена");
        }
    }

    public void showAllTask(){
        try {
            taskRepo.statement.execute("select * from tasks");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        System.out.println();
    }
}

