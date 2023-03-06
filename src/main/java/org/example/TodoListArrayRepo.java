package org.example;
import java.util.ArrayList;
import java.util.List;

public class TodoListArrayRepo implements TodoListRepo {
    private List<Todo> todoList;
    public TodoListArrayRepo() {
        todoList = new ArrayList<>();
    }
    @Override
    public void addTodo(Todo todo) {
        todoList.add(todo);
    }
    @Override
    public void removeTodo(int todoIndex) {
        todoList.remove(todoIndex);
    }
    @Override
    public List<Todo> getTodoList() {
        return todoList;
    }
}
