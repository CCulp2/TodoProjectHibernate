package org.example;
import java.util.ArrayList;
import java.util.List;

public class TodoListRepo {
    private List<Todo> todoList;
    public TodoListRepo() {
        todoList = new ArrayList<>();
    }
    public void addTodo(Todo todo) {
        todoList.add(todo);
    }
    public void removeTodo(int todoIndex) {
        todoList.remove(todoIndex);
    }
    public List<Todo> getTodoList() {
        return todoList;
    }
}
