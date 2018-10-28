package Servlet;

import Util.UnzipUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.File;
import java.io.IOException;

/**
 * Created by miaohualin on 2018/5/8.
 */
@WebServlet(name = "PhotoupdateServlet" ,urlPatterns = "/photoUpdate")
@MultipartConfig
public class PhotoupdateServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        //System.out.println(System.getProperty("user.dir"));
        //String savePath = "/home/jxjyxyuser/uploadFile/";
        String savePath = DownloadDemoServlet.class.getResource("/").getPath()+"/uploadFile/";
        Part part =request.getPart("file2");
        String header = part.getHeader("content-disposition");
        String fileName = getFileName(header);
        if (!fileName.equals("")) {
            //System.out.println("路径：" + request.getServletContext().getRealPath("/WEB-INF/uploadFile"));
            String temp = savePath + fileName;
            part.write(temp);
            boolean isZip = fileName.endsWith(".zip");
            if (isZip) {
                UnzipUtil unzipUtil = new UnzipUtil();
                File photo = new File(temp);
                //System.getProperty("user.dir")
                String photoPath ="../webapps/NEUEDU/img/";
                //String photoPath = "C:\\Users\\miaohualin\\Desktop\\1000块大项目\\NEUEDU\\web\\img";
                System.out.println(photoPath);
                unzipUtil.unZipFile(photo, photoPath);
                request.getRequestDispatcher("manage.jsp").forward(request,response);
            }else {
                System.out.println("文件格式错误！");
            }
        }
        request.getRequestDispatcher("index.jsp").forward(request,response);
    }
    public String getFileName(String header){
        String[] arr =header.split(";");
        String[] arr2 =arr[2].split("=");
        String fileName = arr2[1].substring(arr2[1].lastIndexOf("\\")+1).replaceAll("\"", "");
        return fileName;
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }

}
