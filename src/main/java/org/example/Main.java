package org.example;


import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;
import servlet.CustomerServlet;


public class Main {
    public static void main(String[] args) throws Exception {


        Server server = new Server(8080); // Порт может быть изменен на ваше усмотрение

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

