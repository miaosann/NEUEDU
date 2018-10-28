package Servlet;

import Dao.AdmitDao;
import Dao.Excel_recordDao;
import Entity.Admit;
import Entity.Excel_record;
import Util.ReadExecl;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.*;
import java.sql.Timestamp;
import java.util.List;

@WebServlet(name = "DownloadDemoServlet",urlPatterns = "/download")
@MultipartConfig
public class DownloadDemoServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        //String savePath =request.getServletContext().getRealPath("/WEB-INF/uploadFile");
        //String savePath = "/home/jxjyxyuser/uploadFile/";
        String savePath = DownloadDemoServlet.class.getResource("/").getPath()+"/uploadFile/";
        Part part =request.getPart("file");
        String header = part.getHeader("content-disposition");
        String fileName = getFileName(header);
        //PrintWriter p = response.getWriter();
        if (!fileName.equals("")) {
            String[] table_names = fileName.split("\\.");
            System.out.println(table_names.length+" : ");
            String table_name = table_names[0];
            AdmitDao tableDao = new AdmitDao();
            if (!tableDao.isTableExit(table_name)) {
                //p.println("表名不重复");
                table_name = "admit" + table_name;
                boolean isCreate = tableDao.createTabel(table_name);
                if (isCreate) {
                    //p.println("创建表成功");
                    //System.out.println("路径：" + request.getServletContext().getRealPath("/WEB-INF/uploadFile"));
                    part.write(savePath+ fileName);
                    String filepathandname = savePath + fileName;
                    ReadExecl readExecl = new ReadExecl();
                    List<Admit> admitList = readExecl.readXlsx(filepathandname);
                    for (int i = 0; i < admitList.size(); i++) {
                        AdmitDao admitDao = new AdmitDao();
                        admitDao.add(admitList.get(i), table_name);
                        admitDao = null;
                    }
                   // p.println("读取入数据库成功");
                    Excel_record excel_record = new Excel_record();
                    excel_record.setPici(table_name);
                    excel_record.setName(table_name);
                    excel_record.setCreatetime(new Timestamp(System.currentTimeMillis()));
                    Excel_recordDao excel_recordDao = new Excel_recordDao();
                    excel_recordDao.add(excel_record);

                   // p.println("Success");

                    request.getRequestDispatcher("manage.jsp").forward(request,response);
                } else {
                    System.out.println("数据库创建失败");
                }
            }else {
                System.out.println("该数据库已存在");
            }
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        String username = request.getParameter("username");
        //上传文件



    }
    public String getFileName(String header){
        String[] arr =header.split(";");
        String[] arr2 =arr[2].split("=");
        String fileName = arr2[1].substring(arr2[1].lastIndexOf("\\")+1).replaceAll("\"", "");
        return fileName;
    }
}