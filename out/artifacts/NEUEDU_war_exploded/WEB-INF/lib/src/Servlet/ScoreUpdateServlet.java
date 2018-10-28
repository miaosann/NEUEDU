package Servlet;

import Dao.ScoreDao;
import Entity.Score;
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
import java.util.List;
/*
 * Created by miaohualin on 2018/5/8.
*/


@WebServlet(name = "ScoreUpdateServlet" , urlPatterns = "/scoreUpdate")
@MultipartConfig
public class ScoreUpdateServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        String savePath = request.getServletContext().getRealPath("/WEB-INF/uploadFile");
        Part part = request.getPart("file1");
        String header = part.getHeader("content-disposition");
        String fileName = getFileName(header);
        if (!fileName.equals("")) {
            System.out.println("路径：" + request.getServletContext().getRealPath("/WEB-INF/uploadFile"));
            part.write(savePath + File.separator + fileName);
            String filepathandname = savePath + File.separator + fileName;
            ReadExecl readExecl = new ReadExecl();
            boolean isXls = fileName.endsWith(".xlsx");
            List<Score> admitList = null;
            ScoreDao del = new ScoreDao();
            if (del.delete()) {
                admitList = readExecl.readXlsxScore(filepathandname);
                for (int i = 0; i < admitList.size(); i++) {
                    ScoreDao admitDao = new ScoreDao();
                    admitDao.add(admitList.get(i));
                }
            }
            request.getRequestDispatcher("index.jsp").forward(request, response);
        }
    }

    private String getFileName(String header) {
        String[] arr =header.split(";");
        String[] arr2 =arr[2].split("=");
        String fileName = arr2[1].substring(arr2[1].lastIndexOf("\\")+1).replaceAll("\"", "");
        return fileName;
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
    public static void main(String[] args){
        System.out.println("SSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSssss");
    }
}
