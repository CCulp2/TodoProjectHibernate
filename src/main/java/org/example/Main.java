package org.example;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration().configure().buildSessionFactory();
        TodoListHibernateRepo repo = new TodoListHibernateRepo(factory);
        Scanner sc = new Scanner(System.in);
        Menu menu = new Menu(repo, sc);
        menu.menuLoop();

    }
}