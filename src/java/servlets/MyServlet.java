package servlets;

import entity.Book;
import session.BookFacade;
import java.io.IOException;
import java.util.List;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "MyServlet", urlPatterns = {"/addBook", "/createBook", "/createReader", "/listBooks",})
public class MyServlet extends HttpServlet {
    private Book book ;
    @EJB 
    BookFacade bookFacade;
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        
        String path = request.getServletPath();
        switch (path) {
            case "/addBook":
                request.getRequestDispatcher("/WEB-INF/addBook.jsp").forward(request, response);
                break;
            case "/createBook":
                String name = request.getParameter("name");
                String author = request.getParameter("author");
                String year = request.getParameter("year");
                
                
                
                if (    "".equals(name) || name == null ||
                        "".equals(author) || author == null ||
                        "".equals(year) || year == null){
                    
                    request.setAttribute("info", "Заполните формы");
                    request.setAttribute("name", name );
                    request.setAttribute("author", author);
                    request.setAttribute("year", year);
                    request.getRequestDispatcher("/WEB-INF/addBook.jsp").forward(request, response);
                    break;
                }
                book = new Book(name, author, year);
                
                bookFacade.create(book);
                request.setAttribute("info", "Книга была добавлена! ('" + book.toString());
                request.getRequestDispatcher("/index.jsp").forward(request, response);
                
                
                break;
                
            case "/createReader":
                request.getRequestDispatcher("/WEB-INF/addBook.jsp").forward(request, response);
                break;
                
            case "/listBooks":
                List<Book> listBooks = bookFacade.findAll();
                request.setAttribute("listBooks", listBooks);
                request.getRequestDispatcher("/WEB-INF/listBooks.jsp").forward(request, response);
                break;
        }
        
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
