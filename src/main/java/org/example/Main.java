package org.example;


import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;
import org.example.controller.CustomerController;
import org.example.repository.CustomerRepository;
import servlet.CustomerServlet;


public class Main {
    public static void main(String[] args) throws Exception {
        CustomerController customerController=new CustomerController();
        customerController.showAllPerson();

        Server server = new Server(8080);

        ServletContextHandler servletContextHandler = new ServletContextHandler();
        servletContextHandler.setContextPath("/");

        // Регистрация сервлета PersonServlet
        servletContextHandler.addServlet(new ServletHolder(new CustomerServlet()), "/customer");

        // Установка контекста сервлета в сервер Jetty
        server.setHandler(servletContextHandler);

        // Запуск сервера Jetty
        server.start();
        server.join();
    }
    }

