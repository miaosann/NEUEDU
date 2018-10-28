package Util;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;
import java.util.Enumeration;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

/**
 * Created by miaohualin on 2018/5/4.
 */
public class UnzipUtil {
    @SuppressWarnings("rawtypes")
    public void unZipFile(File zipFile , String descDir) throws IOException {
        boolean isZip = zipFile.getName().endsWith(".zip");
        if (isZip) {
            Charset charset = Charset.forName("GBK");//解决中文文件夹乱码
            ZipFile zip = new ZipFile(zipFile, charset);
            String name = zip.getName().substring(zip.getName().lastIndexOf('\\') + 1, zip.getName().lastIndexOf('.'));
           //System.out.println(name);
            /* File pathFile = new File(descDir+name);
            if (!pathFile.exists()) {
                pathFile.mkdir();   //创建此抽象路径名指定的目录。一级目录
            }*/
            Enumeration<ZipEntry> entries = (Enumeration<ZipEntry>) zip.entries();//枚举zip文件内部的一个一个文件
            while (entries.hasMoreElements()) {
                ZipEntry entry = (ZipEntry) entries.nextElement();
                String zipEntryName = entry.getName();
                System.out.println("1 &*()"+zipEntryName);
                String[] qwert =  zipEntryName.split("/");
                String realName = "";
                if (qwert.length==2)
                    realName = qwert[1];
                if (!realName.equals("")) {
                    System.out.println("2 &*()" + realName);
                    InputStream in = zip.getInputStream(entry);
                    //String outPath = (descDir + "/" + realName).replaceAll("\\*", "/");
                    String outPath = descDir + "/" + realName;
                    //判断路径是否存在，不存在则创建路径
                    File file = new File(outPath.substring(0, outPath.lastIndexOf('/')));
                    if (!file.exists()) {
                        file.mkdir();
                    }
                    // 判断文件全路径是否为文件夹,如果是上面已经上传,不需要解压
                    if (new File(outPath).isDirectory()) {
                        continue;
                    }
                    FileOutputStream out = new FileOutputStream(outPath);
                    byte[] buf = new byte[1024];
                    int len;
                    while ((len = in.read(buf)) > 0) {
                        out.write(buf, 0, len);
                    }
                    in.close();
                    out.close();
                }
            }
            System.out.println("******************解压完毕********************");
        }else {
            System.out.println("文件类型不是zip！！请重新压缩！！");
        }
    }

    public static void main(String[] args){
        //这里仅仅支持zip解压，你妄想把rar重命名是不好用的
        File file = new File("C:/Users/miaohualin/Desktop/pic.zip");
        System.out.println(file.getName());
        try {
            new UnzipUtil().unZipFile(file,"C:/Users/miaohualin/Desktop/");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
