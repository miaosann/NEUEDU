package Servlet;

import Dao.ScoreDao;
import Entity.Score;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * Created by miaohualin on 2018/5/8.
 */
@WebServlet(name = "CheckInfoServlet",urlPatterns = "/checkInfo")
public class CheckInfoServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        String name = request.getParameter("name");
        String id = request.getParameter("sfzh");
        System.out.println(name);
        ScoreDao scoreDao = new ScoreDao();
        List<Score> scoreList = scoreDao.queryById(id);
        if (scoreList.size() > 0) {
            if (scoreList.get(0).getName().equals(name)) {
                request.getSession().setAttribute("check", scoreList.get(0));
                request.getRequestDispatcher("xueweiinfo.jsp").forward(request,response);
            } else {
                System.out.println("用户名与身份证号不匹配！");
            }
        }else {
            System.out.println("身份证号不存在！");
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
