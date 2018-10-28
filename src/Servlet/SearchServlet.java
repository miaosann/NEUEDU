package Servlet;

import Dao.Cj_recordDao;
import Dao.StudentDao;
import Entity.Student;
import Entity.cj_record;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by miaohualin on 2018/5/8.
 */
@WebServlet(name = "SearchServlet" , urlPatterns = "/search")
public class SearchServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        request.getSession().setAttribute("a","1002");
        request.getSession().setAttribute("b","1005");
        request.getSession().setAttribute("c","1008");
        String msg = "";
        String pici = request.getParameter("pici");
        String name = request.getParameter("name");
        String id = request.getParameter("id");
        StudentDao studentDao = new StudentDao();
        if (pici.equals("0")){
            Cj_recordDao cj_recordDao = new Cj_recordDao();
            List<cj_record> cj_records = cj_recordDao.queryAll();
            List<Student> studentList = new ArrayList<>();
            for (int i = 0 ;i<cj_records.size();i++) {
                String ijn = cj_records.get(i).getTablename();
                String tabelname = ijn;
                List<Student> student = studentDao.queryById(id,tabelname);
                if (student.size()>0)
                    studentList.add(student.get(0));
                System.out.println(studentList.size());
            }
            if (studentList.size()>0){
                String strfff;
                for (int i = 0 ;i < studentList.size(); i++) {
                        /*System.out.println("!@#$%^ "+studentList.get(i).getKmldm());
                        if (studentList.get(i).getKmldm().equals("1002") ) {
                            strfff = "英语";
                        } else if (studentList.get(i).getKmldm().equals("1005")) {
                            strfff = "日语";
                        } else if (studentList.get(i).getKmldm() .equals("1008")) {
                            strfff = "俄语";
                        } else {
                            strfff = "老子不知道";
                        }*/
                        strfff = studentList.get(i).getKmldm();
                        msg = msg +
                                "                <tr id=\"search_result\">\n" +
                                "                    <td>" + studentList.get(i).getXm() + "</td>\n" +
                                "                    <td>" + studentList.get(i).getSfzh() + "</td>\n" +
                                "                    <td>" + studentList.get(i).getZymc() + "</td>\n" +
                                "                    <td>\n" + strfff +

                                "                    </td>\n" +
                                "                    <td>" + studentList.get(i).getKmlcj() + "</td>\n" +
                                "                    <td>" + studentList.get(i).getRiqi() + "</td>\n" +
                                "                    <td>东北大学</td>\n" +
                                "                </tr>\n";
                        request.getSession().setAttribute("students", studentList);

                }
            }else {
                msg = "该身份证号不存在！！";
            }
        }else {
            String tablename = "cj"+pici;
            List<Student> studentList = studentDao.queryById(id,tablename);
            if (studentList.size()>0){
                String strfff;
                for (int i = 0 ;i < studentList.size(); i++){
                    if (pici.equals(studentList.get(i).getRiqi())){
                        /*if (studentList.get(i).getKmldm().equals("1002")){strfff = "英语";}
                        else if (studentList.get(i).getKmldm().equals("1005")){strfff = "日语";}
                        else if (studentList.get(i).getKmldm().equals("1008")) {strfff = "俄语";}
                        else {
                            strfff ="老子不知道";
                        }*/
                        strfff = studentList.get(i).getKmldm();
                        msg = msg+
                                "                <tr id=\"search_result\">\n" +
                                "                    <td>"+studentList.get(i).getXm()+"</td>\n" +
                                "                    <td>"+studentList.get(i).getSfzh()+"</td>\n" +
                                "                    <td>"+studentList.get(i).getZymc()+"</td>\n" +
                                "                    <td>\n" +strfff+

                                "                    </td>\n" +
                                "                    <td>"+studentList.get(i).getKmlcj()+"</td>\n" +
                                "                    <td>"+studentList.get(i).getRiqi()+"</td>\n" +
                                "                    <td>东北大学</td>\n" +
                                "                </tr>\n" ;

                        request.getSession().setAttribute("students",studentList);
                    }else {
                        msg = "该批次无您的消息";
                    }
                }
            }else {
                msg = "该身份证号不存在！！";
            }
        }
        response.getWriter().println(msg);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
