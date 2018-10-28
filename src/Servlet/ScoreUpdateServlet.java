package Servlet;

import Dao.ScoreDao;
import Entity.Score;
import Util.ReadExecl;
import org.apache.poi.openxml4j.exceptions.OpenXML4JException;
import org.xml.sax.SAXException;

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
        //String savePath = "/home/jxjyxyuser/uploadFile/";
        String savePath = DownloadDemoServlet.class.getResource("/").getPath()+"/uploadFile/";
        //String savePath = request.getServletContext().getRealPath("/WEB-INF/uploadFile");
        //System.out.println("QWERTYU");
        Part part = request.getPart("file1");
        String header = part.getHeader("content-disposition");
        String fileName = getFileName(header);
        System.out.println("开始");
        if (!fileName.equals("")) {
            //System.out.println("路径：" + request.getServletContext().getRealPath("/WEB-INF/uploadFile"));
            part.write(savePath + fileName);
            System.out.println("这里已经长传完毕，接下来readExcel");
            String filepathandname = savePath + fileName;
            ReadExecl readExecl = new ReadExecl();
            System.out.println("建完对象，准备读入了！");
            ScoreDao del = new ScoreDao();
            int count = del.getCount();
            List<Score> admitList = null;
            if (count==0) {
                admitList = readExecl.readXlsxScore(filepathandname);
                for (int i = 0; i < admitList.size(); i++) {
                    ScoreDao admitDao = new ScoreDao();
                    admitDao.add(admitList.get(i));
                    admitDao = null;
                }
                System.out.println("读入完毕！！");
            } else {
                del.delete();
                admitList = readExecl.readXlsxScore(filepathandname);
                for (int i = 0; i < admitList.size(); i++) {
                    ScoreDao admitDao = new ScoreDao();
                    admitDao.add(admitList.get(i));
                    admitDao = null;
                }
            }
            request.getRequestDispatcher("manage.jsp").forward(request, response);
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
