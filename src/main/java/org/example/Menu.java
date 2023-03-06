package org.example;
import java.util.List;
import java.util.Scanner;

public class Menu {
    private TodoListRepo todoListRepo;
    private Scanner sc;

    public Menu(TodoListRepo todoListRepo, Scanner sc) {
        this.todoListRepo = todoListRepo;
        this.sc = sc;
    }

    public void menuLoop() {
        displayMainMenu();
        try {
            var choice = Integer.parseInt(sc.nextLine());
            if (choice > 0) {
                menuSelection(choice);
            }
        } catch (NumberFormatException e) {
            System.out.println("That is not a number. Please enter a valid number.\n");
            menuLoop();
        }
    }
    private void displayMainMenu() {
        System.out.println("Select what you'd like to do: ");
        System.out.println("(1) Add a todo.");
        System.out.println("(2) Delete a todo");
        System.out.println("(3) Print all todos");
        System.out.println("(4) Quit\n");
    }
    private void addTodoMenu() {
        String title;
        String details;
        Todo todo;

        System.out.println("What is the title of the todo?");
        title = sc.nextLine();
        System.out.println("\nWhat are the deets?");
        details = sc.nextLine();
        todo = new Todo();
        todo.setTitle(title);
        todo.setDetails(details);
        todoListRepo.addTodo(todo);
        System.out.println("Added!\n");
        displayTodos();
        menuLoop();
    }
    private int displayTodos() {
        var todos = todoListRepo.getTodoList();
        int count = 1;
        for (var todo : todos) {
            System.out.println("(" + count + ") " + todo.getTitle());
            System.out.println("\t" + todo.getDetails());
            System.out.println("-------\n");
            count++;
        }
        return count;
    }
    private void menuSelection(int choice) {
        if (choice == 1) {
            addTodoMenu();
        } else if (choice == 2) {
            deleteTodoMenu();
        } else if (choice == 3) {
            displayTodos();
            menuLoop();
        } else if (choice == 4) {
            System.exit(0);
        } else {
            System.out.println("\nPlease enter a valid choice.");
            menuLoop();
        }
    }
    private void deleteTodoMenu() {
        int count = displayTodos();
        List<Todo> todos = todoListRepo.getTodoList();

        System.out.println("Which todo would you like to delete?\n");
        try {
            var choice = Integer.parseInt(sc.nextLine());
            if (choice > 0 && choice <= count) {
                Todo todoToBeDeleted = todos.get(choice - 1);
                todoListRepo.removeTodo(todoToBeDeleted.getId());
                System.out.println("Done!");
                menuLoop();
            } else if (choice > count) {
                System.out.println("That is not a valid todo. Sending you back to main menu.\n");
                menuLoop();
            }
        } catch (NumberFormatException e) {
            System.out.println("That is not a number. Please enter a valid number.\n");
            deleteTodoMenu();
        }
    }
}
