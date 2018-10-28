package Servlet;

import Dao.AdmitDao;
import Dao.Cj_recordDao;
import Dao.StudentDao;
import Entity.Admit;
import Entity.Student;
import Entity.cj_record;
import Util.ReadExecl;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.File;
import java.io.IOException;
import java.sql.Timestamp;
import java.util.List;

@WebServlet(name = "DownloadSecondServlet", urlPatterns = "/DownloadSecondServlet")
@MultipartConfig
public class DownloadSecondServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        //String savePath = "/home/jxjyxyuser/uploadFile/";
        String savePath = DownloadDemoServlet.class.getResource("/").getPath()+"/uploadFile/";
        Part part =request.getPart("filesecond");
        String header = part.getHeader("content-disposition");
        String fileName = getFileName(header);
        if (!fileName.equals("")) {
            String[] table_names = fileName.substring(2).split("\\.");
            System.out.println(table_names.length+" : ");
            String table_name = table_names[0];
            StudentDao studentDao = new StudentDao();
            if (!studentDao.isTableExit(table_name)) {
                table_name = "cj" + table_name;
                boolean isCreate = studentDao.createTabel(table_name);
                if (isCreate) {
                    //System.out.println("路径：" + request.getServletContext().getRealPath("/WEB-INF/uploadFile"));
                    part.write(savePath + fileName);
                    String filepathandname = savePath + fileName;
                    String riqi = fileName.substring(2).split("\\.")[0];
                    ReadExecl readExecl = new ReadExecl();
                    List<Student> admitList = readExecl.readXlsxForStudent(filepathandname, riqi);
                    for (int i = 0; i < admitList.size(); i++) {
                        StudentDao admitDao = new StudentDao();
                        admitDao.add(admitList.get(i),table_name);
                        admitDao = null;
                    }
                    cj_record excel_record = new cj_record();
                    excel_record.setTablename(table_name);
                    excel_record.setCreatetime(new Timestamp(System.currentTimeMillis()));
                    Cj_recordDao excel_recordDao = new Cj_recordDao();
                    excel_recordDao.add(excel_record);
                    request.getRequestDispatcher("manage.jsp").forward(request, response);
                }else {
                    System.out.println("数据库创建失败");
                }
            }else {
                System.out.println("该数据库已存在");
            }
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
    public String getFileName(String header){
        String[] arr =header.split(";");
        String[] arr2 =arr[2].split("=");
        String fileName = arr2[1].substring(arr2[1].lastIndexOf("\\")+1).replaceAll("\"", "");
        return fileName;
    }
}