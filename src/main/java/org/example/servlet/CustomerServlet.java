package servlet;

import org.example.entity.Customer;
import org.example.repository.CustomerRepository;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.List;
@WebServlet("/customer")
public class CustomerServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Получение списка всех людей из репозитория
        List<Customer> customerList = CustomerRepository.findAll();

        // Установка атрибута в запросе для передачи данных в представление
        request.setAttribute("customer", customerList);

        // Передача запроса и ответа в JSP-страницу для отображения данных
        RequestDispatcher dispatcher = request.getRequestDispatcher("/index.jsp");
        dispatcher.forward(request, response);
    }
}
