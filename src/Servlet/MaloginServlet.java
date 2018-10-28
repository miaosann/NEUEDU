package Servlet;

import Dao.UserDao;
import Entity.User;
import com.sun.xml.internal.bind.v2.schemagen.xmlschema.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by miaohualin on 2018/5/9.
 */
@WebServlet(name = "MaloginServlet",urlPatterns = "/mlogin")
public class MaloginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        String name = request.getParameter("name");
        String password = request.getParameter("password");
        UserDao userDao = new UserDao();
        if ( userDao.queryforlogin(name,password).size()>0){
            request.getRequestDispatcher("manage.jsp").forward(request,response);
        }else {
            request.getRequestDispatcher("fail.jsp").forward(request,response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
