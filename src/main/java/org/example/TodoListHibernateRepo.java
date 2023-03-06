package org.example;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;


import java.util.ArrayList;
import java.util.List;

public class TodoListHibernateRepo implements TodoListRepo {
    SessionFactory factory;
    Session session;
    Transaction tx;

    public TodoListHibernateRepo(SessionFactory factory) {
        this.factory = factory;
    }

    @Override
    public void addTodo(Todo todo) {
        Session session = factory.openSession();
        Transaction tx = null;

        try {
            tx = session.beginTransaction();
            session.save(todo);
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null) tx.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
    }

    @Override
    public void removeTodo(int todoIndex) {
        Session session = factory.openSession();
        Transaction tx = null;

        try {
            tx = session.beginTransaction();
            Todo todo = session.get(Todo.class, todoIndex);
            session.delete(todo);
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null) tx.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
    }

    @Override
    public List<Todo> getTodoList() {
        Session session = factory.openSession();
        List<Todo> todos = new ArrayList<>();
        Transaction tx = null;

        try {
            tx = session.beginTransaction();
            List<Todo> todoStaging = session.createQuery("FROM Todo").getResultList();
            tx.commit();
            for (Todo todo : todoStaging) {
                todos.add(todo);
            }

        } catch (HibernateException e) {
            if (tx != null) tx.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }

        return todos;
    }
}
