import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ProductServletStatic extends HttpServlet {
    private static Logger logger = LoggerFactory.getLogger(ProductServletRandom.class);

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        logger.info("New doGet request");

        Product product1 = new Product(0, "Paper", 1544);
        Product product2 = new Product(1, "Rock", 121244);
        Product product3 = new Product(2, "Scissors", 10);
        Product product4 = new Product(3, "Mouse", 2148);
        Product product5 = new Product(4, "Keyboard", 10454);
        Product product6 = new Product(5, "Spoon", 7754);
        Product product7 = new Product(6, "Notebook", 648);
        Product product8 = new Product(7, "Chair", 3);
        Product product9 = new Product(8, "Table", 42);
        Product product10 = new Product(9, "Money", 24788);

        resp.getWriter().printf("<html><body><h1><table>" +
                "<tr><th>ID</th><th>Title</th><th>Cost</th></tr>" +
                "<tr><td>" + product1.getId() + "</td><td>" + product1.getTitle() + "</td><td>" + product1.getCost() + "</td></tr>" +
                "<tr><td>" + product2.getId() + "</td><td>" + product2.getTitle() + "</td><td>" + product2.getCost() + "</td></tr>" +
                "<tr><td>" + product3.getId() + "</td><td>" + product3.getTitle() + "</td><td>" + product3.getCost() + "</td></tr>" +
                "<tr><td>" + product4.getId() + "</td><td>" + product4.getTitle() + "</td><td>" + product4.getCost() + "</td></tr>" +
                "<tr><td>" + product5.getId() + "</td><td>" + product5.getTitle() + "</td><td>" + product5.getCost() + "</td></tr>" +
                "<tr><td>" + product6.getId() + "</td><td>" + product6.getTitle() + "</td><td>" + product6.getCost() + "</td></tr>" +
                "<tr><td>" + product7.getId() + "</td><td>" + product7.getTitle() + "</td><td>" + product7.getCost() + "</td></tr>" +
                "<tr><td>" + product8.getId() + "</td><td>" + product8.getTitle() + "</td><td>" + product8.getCost() + "</td></tr>" +
                "<tr><td>" + product9.getId() + "</td><td>" + product9.getTitle() + "</td><td>" + product9.getCost() + "</td></tr>" +
                "<tr><td>" + product10.getId() + "</td><td>" + product10.getTitle() + "</td><td>" + product10.getCost() + "</td></tr>" +
                "</table></h1></body></html>");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        logger.info("New doPost request");
    }
}
