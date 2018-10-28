package Util;

import com.github.junrar.Archive;
import com.github.junrar.exception.RarException;
import com.github.junrar.rarfile.FileHeader;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

/**
 * Created by miaohualin on 2018/5/5.
 */
public class UnrarUtil {
    @SuppressWarnings("rawtypes")
    public void unRarFile(String sourceRar , String destDir) throws RarException, IOException {
        /*FileOutputStream out = null;
        Archive rar = new Archive(rarFile);
        File pathFile = new File(descDir);
        System.out.println(pathFile.getAbsolutePath());
        if (!pathFile.exists()){
            pathFile.mkdir();
        }
        FileHeader fileHeader = rar.nextFileHeader();
        while (fileHeader!=null){
            // // 如果是中文路径，调用getFileNameW()方法，否则调用getFileNameString()方法，还可以使用if(fh.isUnicode())
            String filename = fileHeader.getFileNameW().isEmpty()?fileHeader.getFileNameString():fileHeader.getFileNameW();
            if (fileHeader.isDirectory()){ // 判断文件全路径是否为文件夹
                File fol = new File(descDir+File.separator+filename);
                fol.mkdirs();
                System.out.println("SSs");
            } else{// 判断文件全路径是否为文件
                File outFile = new File(descDir + File.separator + filename.trim());
                if (!outFile.exists()) {
                    if (!outFile.getParentFile().exists()) {// 相对路径可能多级，可能需要创建父目录.
                        outFile.getParentFile().mkdirs();
                    }
                    outFile.createNewFile();
                }
                out = new FileOutputStream(outFile);
                rar.extractFile(fileHeader,out);
                System.out.println("SSs");
                out.close();
            }
            fileHeader = rar.nextFileHeader();
        }
        rar.close();*/


        Archive a = null;
        FileOutputStream fos = null;
        try {
            a = new Archive(new File(sourceRar));
            FileHeader fh = a.nextFileHeader();
            while (fh != null) {
                if (!fh.isDirectory()) {
                    // 1 根据不同的操作系统拿到相应的 destDirName 和 destFileName
                    String compressFileName = fh.getFileNameString().trim();
                    String destFileName = "";
                    String destDirName = "";
                    // 非windows系统
                    if (File.separator.equals("/")) {
                        destFileName = destDir
                                + compressFileName.replaceAll("\\\\", "/");
                        destDirName = destFileName.substring(0,
                                destFileName.lastIndexOf("/"));
                        // windows系统
                    } else {
                        destFileName = destDir
                                + compressFileName.replaceAll("/", "\\\\");
                        destDirName = destFileName.substring(0,
                                destFileName.lastIndexOf("\\"));
                    }
                    // 2创建文件夹
                    File dir = new File(destDirName);
                    if (!dir.exists() || !dir.isDirectory()) {
                        dir.mkdirs();
                    }
                    // 3解压缩文件
                    fos = new FileOutputStream(new File(destFileName));
                    a.extractFile(fh, fos);
                    fos.close();
                    fos = null;
                    System.out.println("解压成功");

                }
                fh = a.nextFileHeader();
            }
            a.close();
            a = null;
        } catch (Exception e) {
            throw e;
        } finally {
            if (fos != null) {
                try {
                    fos.close();
                    fos = null;
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            if (a != null) {
                try {
                    a.close();
                    a = null;
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static boolean  unrar(String rarFileName, String outFilePath)  throws  Exception{

        boolean flag = false;
        try  {
            Archive archive = new Archive(new File(rarFileName));
            if(archive == null){
                throw new FileNotFoundException(rarFileName + " NOT FOUND!");
            }
            if(archive.isEncrypted()){
                throw new Exception(rarFileName + " IS ENCRYPTED!");
            }
            List<FileHeader> files =  archive.getFileHeaders();
            for (FileHeader fh : files) {
                if(fh.isEncrypted()){
                    throw new Exception(rarFileName + " IS ENCRYPTED!");
                }
                String fileName = fh.getFileNameW();
                if(fileName != null && fileName.trim().length() > 0){
                    String saveFileName = outFilePath+"\\"+fileName;
                    File saveFile = new File(saveFileName);
                    File parent =  saveFile.getParentFile();
                    if(!parent.exists()){
                        parent.mkdirs();
                    }
                    if(!saveFile.exists()){
                        saveFile.createNewFile();
                    }
                    FileOutputStream fos = new FileOutputStream(saveFile);
                    try {
                        archive.extractFile(fh, fos);
                        fos.flush();
                        fos.close();
                    } catch (RarException e) {
                        if(e.getType().equals(RarException.RarExceptionType.notImplementedYet)){
                        }
                    }finally{
                    }
                }
            }
            flag = true;
        } catch  (Exception e) {
            e.printStackTrace();
            throw e;
        }
        return flag;
    }

    public  void deCompress(String sourceFile, String destDir)
            throws Exception {
        // 保证文件夹路径最后是"/"或者"\"
        char lastChar = destDir.charAt(destDir.length() - 1);
        if (lastChar != '/' && lastChar != '\\') {
            destDir += File.separator;
        }
        // 根据类型，进行相应的解压缩
        String type = sourceFile.substring(sourceFile.lastIndexOf(".") + 1);
      /*  if (type.equals("zip")) {
            ZipUtils.unzip(sourceFile, destDir);
        } */if (type.equals("rar")) {
           this .unRarFile(sourceFile, destDir);
        } else {
            throw new Exception("只支持zip和rar格式的压缩包！");
        }
    }
    public static void main(String[] args) throws Exception {
        File file = new File("C:/Users/miaohualin/Desktop/pic.rar");
        File desfile = new File("C:/Users/miaohualin/Desktop/");
        System.out.println(file.getName());
        new UnrarUtil().unrar("C:/Users/miaohualin/Desktop/pic.rar","C:/Users/miaohualin/Desktop/");
        //new UnrarUtil().deCompress("C:/Users/miaohualin/Desktop/pic.rar","C:/Users/miaohualin/Desktop/");
    }
}
