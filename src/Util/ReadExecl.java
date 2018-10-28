package Util;

import Entity.Admit;
import Entity.Score;
import Entity.Student;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.openxml4j.exceptions.OpenXML4JException;
import org.apache.poi.openxml4j.opc.OPCPackage;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.xml.sax.SAXException;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class ReadExecl {
    public List<Admit> readXls(String path) throws IOException {
        InputStream is = new FileInputStream(path);
        HSSFWorkbook hssfWorkbook = new HSSFWorkbook(is);
        Admit student = null;
        List<Admit> list = new ArrayList<Admit>();
        // 循环工作表Sheet
        for (int numSheet = 0; numSheet < hssfWorkbook.getNumberOfSheets(); numSheet++) {
            HSSFSheet hssfSheet = hssfWorkbook.getSheetAt(numSheet);
            if (hssfSheet == null) {
                continue;
            }
            // 循环行Row
            for (int rowNum = 1; rowNum <= hssfSheet.getLastRowNum(); rowNum++) {
                HSSFRow hssfRow = hssfSheet.getRow(rowNum);
                if (hssfRow != null) {
                    student = new Admit();
                    HSSFCell id = hssfRow.getCell(6);
                    HSSFCell name = hssfRow.getCell(2);
                    HSSFCell sex = hssfRow.getCell(3);
                    HSSFCell peiyang = hssfRow.getCell(4);
                    HSSFCell major = hssfRow.getCell(5);
//                    HSSFCell xuezhi = hssfRow.getCell(5);
                    HSSFCell tuition = hssfRow.getCell(7);
                    HSSFCell school = hssfRow.getCell(1);
                    HSSFCell pic = hssfRow.getCell(0);

                    student.setId(getValue(id));
                    student.setName(getValue(name));
                    student.setSex(getValue(sex));
                    student.setPeiyang(getValue(peiyang));
                    student.setMajor(getValue(major));
                    student.setXuezhi("2年");
                    student.setTuition(tuition.getNumericCellValue());
                    student.setSchool(getValue(school));
                    student.setPici(getValue(pic));
                    list.add(student);

                }
            }
        }
        return list;
    }
    public List<Admit> readXlsx(String path) throws IOException {
        InputStream is = new FileInputStream(path);

        XSSFWorkbook hssfWorkbook = new XSSFWorkbook(is);
        Admit student = null;
        List<Admit> list = new ArrayList<Admit>();
        // 循环工作表Sheet
//        for (int numSheet = 0; numSheet < hssfWorkbook.getNumberOfSheets(); numSheet++) {
//            XSSFSheet hssfSheet = hssfWorkbook.getSheetAt(numSheet);
//            if (hssfSheet == null) {
//                continue;
//            }
        XSSFSheet hssfSheet = hssfWorkbook.getSheetAt(0);
            // 循环行Row
            for (int rowNum = 1; rowNum <= hssfSheet.getLastRowNum(); rowNum++) {
                XSSFRow hssfRow = hssfSheet.getRow(rowNum);
                if (hssfRow != null) {
                    student = new Admit();
                    XSSFCell id = hssfRow.getCell(6);
                    XSSFCell name = hssfRow.getCell(2);
                    XSSFCell sex = hssfRow.getCell(3);
                    XSSFCell peiyang = hssfRow.getCell(4);
                    XSSFCell major = hssfRow.getCell(5);
//                    HSSFCell xuezhi = hssfRow.getCell(5);
                    XSSFCell tuition = hssfRow.getCell(7);
                    XSSFCell school = hssfRow.getCell(1);
                    XSSFCell pic = hssfRow.getCell(0);

                    student.setId(id.getStringCellValue());
                    student.setName(name.getStringCellValue());
                    student.setSex(sex.getStringCellValue());
                    student.setPeiyang(peiyang.getStringCellValue());
                    student.setMajor(major.getStringCellValue());
                    student.setXuezhi("2年");
                    student.setTuition(Double.valueOf(tuition.getStringCellValue()));
                    student.setSchool(school.getStringCellValue());
                    student.setPici(pic.getStringCellValue());
                    list.add(student);

                }
            }

        return list;
    }

    @SuppressWarnings("static-access")
    private String getValue(HSSFCell hssfCell) {
        if (hssfCell.getCellType() == hssfCell.CELL_TYPE_BOOLEAN) {
            // 返回布尔类型的值
            return String.valueOf(hssfCell.getBooleanCellValue());
        } else if (hssfCell.getCellType() == hssfCell.CELL_TYPE_NUMERIC) {
            // 返回数值类型的值
            return String.valueOf(hssfCell.getNumericCellValue());
        } else {
            // 返回字符串类型的值
            return String.valueOf(hssfCell.getStringCellValue());
        }
    }
//    @SuppressWarnings("static-access")
//    private String getValue(XSSFCell hssfCell){
//        if (hssfCell.getCellType() == HssfCell.CELL_TYPE_BOOLEAN) {
//            // 返回布尔类型的值
//            return String.valueOf(hssfCell.getBooleanCellValue());
//        } else if (hssfCell.getCellType() == hssfCell.CELL_TYPE_NUMERIC) {
//            // 返回数值类型的值
//            return String.valueOf(hssfCell.getNumericCellValue());
//        } else {
//            // 返回字符串类型的值
//            return String.valueOf(hssfCell.getStringCellValue());
//        }
//    }
public List<Score> readXlsxScore(String path) throws IOException {
    InputStream is = new FileInputStream(path);

    XSSFWorkbook hssfWorkbook = new XSSFWorkbook(is);
    Score student = null;
    List<Score> list = new ArrayList<Score>();
    // 循环工作表Sheet
//        for (int numSheet = 0; numSheet < hssfWorkbook.getNumberOfSheets(); numSheet++) {
//            XSSFSheet hssfSheet = hssfWorkbook.getSheetAt(numSheet);
//            if (hssfSheet == null) {
//                continue;
//            }
    XSSFSheet hssfSheet = hssfWorkbook.getSheetAt(0);
    // 循环行Row
    for (int rowNum = 1; rowNum <= hssfSheet.getLastRowNum(); rowNum++) {
        XSSFRow hssfRow = hssfSheet.getRow(rowNum);
        if (hssfRow != null) {
            student = new Score();
            XSSFCell bmd = hssfRow.getCell(0);
            XSSFCell xm = hssfRow.getCell(1);
            XSSFCell xb = hssfRow.getCell(2);
            hssfRow.getCell(3).setCellType(Cell.CELL_TYPE_STRING);
            XSSFCell sfzh = hssfRow.getCell(3);
            XSSFCell csrq = hssfRow.getCell(4);
            XSSFCell mz = hssfRow.getCell(5);
            XSSFCell zymc = hssfRow.getCell(6);
            XSSFCell ksly = hssfRow.getCell(7);
            hssfRow.getCell(8).setCellType(Cell.CELL_TYPE_STRING);
            XSSFCell xz = hssfRow.getCell(8);
            hssfRow.getCell(9).setCellType(Cell.CELL_TYPE_STRING);
            XSSFCell nj = hssfRow.getCell(9);
            XSSFCell txdz = hssfRow.getCell(10);
            XSSFCell kmlbmh = hssfRow.getCell(11);
            XSSFCell kmldm = hssfRow.getCell(12);

            student.setBmd(bmd.getStringCellValue());
            student.setName(xm.getStringCellValue());
            student.setSex(xb.getStringCellValue());
            student.setId((String) sfzh.getStringCellValue());
            student.setCsrq(csrq.getStringCellValue());
            student.setMz(mz.getStringCellValue());
            student.setZymc(zymc.getStringCellValue());
            student.setKsly(ksly.getStringCellValue());
            student.setXz((String) xz.getStringCellValue());
            student.setNj((String)nj.getStringCellValue());
            student.setTxdz(txdz.getStringCellValue());
            student.setKm1dm(kmldm.getStringCellValue());
            student.setKsly(ksly.getStringCellValue());
            student.setKm1bmh(kmlbmh.getStringCellValue());
            list.add(student);

        }
    }
    return list;
}
    public List<Score> readXlsScore(String path) throws IOException {
        InputStream is = new FileInputStream(path);
        HSSFWorkbook hssfWorkbook = new HSSFWorkbook(is);
        Score student = null;
        List<Score> list = new ArrayList<Score>();
        // 循环工作表Sheet
        for (int numSheet = 0; numSheet < hssfWorkbook.getNumberOfSheets(); numSheet++) {
            HSSFSheet hssfSheet = hssfWorkbook.getSheetAt(numSheet);
            if (hssfSheet == null) {
                continue;
            }
            // 循环行Row
            for (int rowNum = 1; rowNum <= hssfSheet.getLastRowNum(); rowNum++) {
                HSSFRow hssfRow = hssfSheet.getRow(rowNum);
                if (hssfRow != null) {
                    student = new Score();
                    HSSFCell bdm = hssfRow.getCell(0);
                    HSSFCell xm = hssfRow.getCell(1);
                    HSSFCell xb = hssfRow.getCell(2);
                    HSSFCell sfzh = hssfRow.getCell(3);
                    HSSFCell csrq = hssfRow.getCell(4);
                    HSSFCell mz = hssfRow.getCell(5);
                    HSSFCell zymc = hssfRow.getCell(6);
                    HSSFCell ksly = hssfRow.getCell(7);
                    HSSFCell xz = hssfRow.getCell(8);
                    HSSFCell nj = hssfRow.getCell(9);
                    HSSFCell txdz = hssfRow.getCell(10);
                    HSSFCell km1bmh = hssfRow.getCell(11);
                    HSSFCell kmldm = hssfRow.getCell(12);

                    student.setBmd(bdm.getStringCellValue());
                    student.setName(xm.getStringCellValue());
                    student.setSex(xb.getStringCellValue());
                    student.setId(sfzh.getStringCellValue());
                    student.setCsrq(csrq.getStringCellValue());
                    student.setMz(mz.getStringCellValue());
                    student.setZymc(zymc.getStringCellValue());
                    student.setKsly(ksly.getStringCellValue());
                    student.setXz(xz.getStringCellValue());
                    student.setNj(nj.getStringCellValue());
                    student.setTxdz(txdz.getStringCellValue());
                    student.setKm1bmh(km1bmh.getStringCellValue());
                    student.setKm1dm(kmldm.getStringCellValue());


                    list.add(student);

                }
            }
        }
        return list;
    }
    public List<Student> readXlsxForStudent(String path,String riqi) throws IOException {
        InputStream is = new FileInputStream(path);

        XSSFWorkbook hssfWorkbook = new XSSFWorkbook(is);
        Student student = null;
        List<Student> list = new ArrayList<Student>();
        // 循环工作表Sheet
//        for (int numSheet = 0; numSheet < hssfWorkbook.getNumberOfSheets(); numSheet++) {
//            XSSFSheet hssfSheet = hssfWorkbook.getSheetAt(numSheet);
//            if (hssfSheet == null) {
//                continue;
//            }
        XSSFSheet hssfSheet = hssfWorkbook.getSheetAt(0);
        // 循环行Row
        for (int rowNum = 1; rowNum <= hssfSheet.getLastRowNum(); rowNum++) {
            XSSFRow hssfRow = hssfSheet.getRow(rowNum);
            if (hssfRow != null) {
                student = new Student(riqi);
                XSSFCell xm = hssfRow.getCell(0);
                XSSFCell sfzh = hssfRow.getCell(1);
                XSSFCell zymc = hssfRow.getCell(2);
                XSSFCell txdz = hssfRow.getCell(3);
                XSSFCell km1dm = hssfRow.getCell(4);
                hssfRow.getCell(5).setCellType(Cell.CELL_TYPE_STRING);
                XSSFCell km1cj = hssfRow.getCell(5);

                student.setXm(xm.getStringCellValue());
                student.setSfzh(sfzh.getStringCellValue());
                student.setZymc(zymc.getStringCellValue());
                student.setTxdz(txdz.getStringCellValue());
                student.setKmldm(km1dm.getStringCellValue());
                student.setKmlcj((String)km1cj.getStringCellValue());
                list.add(student);

            }
        }

        return list;
    }


    public static void main(String args[]) throws IOException, OpenXML4JException, SAXException {

        long starTime=System.currentTimeMillis();

        /*ReadExecl readExecl1 = new ReadExecl();
        String path1 = "D:\\test\\luqu.xlsx";
        readExecl1.readXlsx(path1);
        long endTime=System.currentTimeMillis();
        System.out.println(endTime-starTime);*/
//        long starTim=System.currentTimeMillis();
//        ReadExecl readExecl = new ReadExecl();
//        String path = "D:\\test\\luqu.xlsx";
//        InputStream in = new FileInputStream(path);
//        OPCPackage p = OPCPackage.open(in); //取得一个文件的读写权限
//        XLSX2CSV xlsx2csv = new XLSX2CSV(p);
//        xlsx2csv.process();
//        p.close();
//        List<List<List<String>>> list = xlsx2csv.getList();
//        long endTim=System.currentTimeMillis();
//        System.out.println(endTim-starTim);
    }
}
