import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

@WebServlet (name = "ProductServletRandom", urlPatterns = "/product_servlet_random")
public class ProductServletRandom extends HttpServlet {
    public static final int BOUND = 100000;
    private static Logger logger = LoggerFactory.getLogger(ProductServletRandom.class);

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        logger.info("New doGet request");
        Random random = new Random();

        resp.getWriter().printf("<html><body><h1><table>" +
                "<tr><th>ID</th><th>Title</th><th>Cost</th></tr>");

        Product[] arr = new Product[10];
        String[] titles = new String[]{"Paper", "Rock", "Scissors", "Mouse", "Keyboard", "Spoon", "Notebook", "Chair", "Table", "Money"};
        ArrayList arrayList = new ArrayList<>(Arrays.asList(titles));
        String title;
        for (int i = 0; i < 10; i++) {
            title = (String) arrayList.get(random.nextInt(arrayList.size()));
            arrayList.remove(title);
            arr[i] = new Product(i, title, random.nextInt(BOUND));
            resp.getWriter().printf("<tr><td>" + arr[i].getId() + "</td><td>" + arr[i].getTitle() + "</td><td>" + arr[i].getCost() + "</td></tr>");
        }

        resp.getWriter().printf("</table></h1></body></html>");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        logger.info("New doPost request");
    }
}
