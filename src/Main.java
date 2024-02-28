import model.Tasks;
import repository.TaskRepo;
import service.TaskService;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        TaskRepo taskRepo = new TaskRepo();
        Tasks tasks = new Tasks();
        TaskService taskService = new TaskService(taskRepo, tasks);
        while (true){
            System.out.println("Выберите действие:");
            System.out.println("1. Создать");
            System.out.println("2. Редактировать");
            System.out.println("3. Удалить");
            System.out.println("4. Показать задачи");
            System.out.print("Выберите номер действия (1-4): ");
            int choice = scanner.nextInt();

            switch (choice){
                case 1:
                    taskService.createTask();
                    break;
                case 2:
                    taskService.editTask();
                    break;
                case 3:
                    taskService.deleteTask();
                break;
                case 4:
                    taskService.showAllTask();
                    break;
//                default:
//                    System.out.println("Некорректный выбор. Пожалуйста, введите число от 1 до 4.");
            }
        }
        }
    }
