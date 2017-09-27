package util;

import org.apache.poi.hssf.usermodel.*;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

public class ExcelUtil {
    private HSSFWorkbook wb = new HSSFWorkbook();
    private HSSFSheet sheet;
    private HSSFRow row;

    public ExcelUtil(String title){
        sheet = wb.createSheet(title);
    }

    /**
     * 设置表头
     * @param titles
     */
    public void setRowTitle(List<String> titles){
        row = sheet.createRow(0);
        HSSFCellStyle style = wb.createCellStyle();
        style.setAlignment(HSSFCellStyle.ALIGN_CENTER); // 创建一个居中格式
        int i=0;
        for(String s: titles){
            HSSFCell cell = row.createCell(i);
            cell.setCellValue(s);
            cell.setCellStyle(style);
        }
    }

    /**
     *
     * @param datas
     */
    public void setRowData(List<String> datas){
        for (int i = 0; i < datas.size(); i++)
        {
            row = sheet.createRow(i + 1);
            HSSFCell cell = row.createCell(i);
            cell.setCellValue(datas.get(i));
        }
    }

    /**
     * 输出文件
     * @param path 不需要加后缀
     */
    public void out(String path){
        try {
            FileOutputStream fout = new FileOutputStream("E:/"+path+".xls");
            wb.write(fout);
            fout.close();
        }catch (IOException e){
            e.printStackTrace();
        }

    }
}
