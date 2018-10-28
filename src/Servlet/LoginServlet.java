package Servlet;

import Dao.AdmitDao;
import Dao.Excel_recordDao;
import Entity.Admit;
import Entity.Excel_record;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * Created by miaohualin on 2018/5/6.
 */
@WebServlet(name = "LoginServlet" , urlPatterns = "/LoginServlet")
public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        String name = request.getParameter("name");
        String password = request.getParameter("password");
        String msg = null;
        if (name.equals("admin")&&password.equals("admin123456")){
            msg = "admin";
        }else if (name.equals("admin")&&(!password.equals("admin123456"))){
            msg = "管理员密码错误";
        }else {
            Excel_recordDao excel_recordDao = new Excel_recordDao();
            List<Excel_record> excel_records = excel_recordDao.queryAll();
            AdmitDao admitDao = new AdmitDao();
            boolean isExist = admitDao.isExist(name, excel_records.get(0).getName());
            System.out.println("name:" + name + ":" + "shujuku:" + excel_records.get(0).getName());
            if (isExist) {
                List<Admit> students = admitDao.queryByName(name, excel_records.get(0).getName());
                System.out.println(students.get(0).getId() + " : " + password);
                if (students.get(0).getId().equals(password)) {
                    msg = "qwer";
                    request.getSession().setAttribute("admits", students);
                } else {
                    msg = "密码错误";
                    System.out.println("密码错误");
                }
            } else {
                msg = "未录取";
                System.out.println("未录取！");
            }
        }
        response.getWriter().println(msg);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
