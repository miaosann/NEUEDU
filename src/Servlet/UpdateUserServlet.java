package Servlet;

import Dao.UserDao;
import Entity.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "UpdateUserServlet", urlPatterns = "/UpdateUserServlet")
public class UpdateUserServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        User olduser = new User();
        olduser.setZhanghao(request.getParameter("zhanghao"));
        olduser.setPassword(request.getParameter("password"));
        User neuser= new User();
        neuser.setZhanghao(request.getParameter("zhanghao"));
        neuser.setPassword(request.getParameter("password1"));
        UserDao userDao = new UserDao();
        userDao.update(neuser,olduser);
        request.getRequestDispatcher("manage.jsp").forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}