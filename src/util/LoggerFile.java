package util;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 把日志写入文件中
 */
public class LoggerFile {

    /**
     * 写入交易数据日志
     *
     * @param str
     */

    public static void tradeLog(String str) {
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        BufferedWriter out = null;

        String path0 = "D://tradeLog/";
        String path1 = path0 + df.format(new Date()) + "-tradeLog.txt";
        File f = new File(path0);
        // 创建文件夹
        if (!f.exists()) {
            f.mkdirs();
        }
        f = new File(path1);
        // 创建文件
        try {
            if (!f.exists()) {
                f.createNewFile();
                out = new BufferedWriter(new OutputStreamWriter(
                        new FileOutputStream(f, true)));
                out.write(str + "\r\n");
            } else {
                out = new BufferedWriter(new OutputStreamWriter(
                        new FileOutputStream(f, true)));
                out.write(str + "\r\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                out.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }


//        try {
//            if (fileJ.exists()) {
//                fileJ.mkdirs();
//            }
//            if (file.exists()) {
//                file.createNewFile();
//            }
//            out = new BufferedWriter(new OutputStreamWriter(
//                    new FileOutputStream(file, true)));
//            out.write(str + "\r\n");
//        } catch (Exception e) {
//            e.printStackTrace();
//        } finally {
//            try {
//                out.close();
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//        }
    }

}
