import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
public class MyServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<html>");
        out.println("<head>");
        out.println("<title>Вебтехнології та вебдизайн</title>");
        out.println("<link rel='stylesheet' type='text/css' href='/styles.css'>");
        out.println("<script type='text/javascript' src='/script.js'></script>");
        out.println("</head>");
        out.println("<body>");
        out.println("<h1>Вебтехнології та вебдизайн</h1>");
        out.println("<p>Це сторінка, присвячена вебтехнологіям та вебдизайну. Детальніше про цю тему можна дізнатися з різноманітних джерел, книг та онлайн-курсів. Вебтехнології включають HTML, CSS, JavaScript та інші технології, які використовуються для розробки веб-сайтів та веб-додатків.</p>");
        out.println("<p>Вебдизайн включає створення естетично привабливих та функціональних інтерфейсів для веб-сайтів. Він охоплює вибір кольорової палітри, шрифтів, компонування елементів та інші аспекти, які стосуються зовнішнього вигляду та користувацького досвіду.</p>");
        out.println("<button id='myButton'>Натисни мене</button>");
        out.println("<div id='myText'></div>");
        out.println("</body>");
        out.println("</html>");
    }
}
