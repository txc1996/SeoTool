package cuong.tran;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileOutputStream;
import java.util.List;

public class ExcelWriter implements FileWriter{
    @Override
    public void writeToFile(List<Card> datas, String filePath) throws Exception{
        XSSFWorkbook workbook = new XSSFWorkbook();
        XSSFSheet sheet = workbook.createSheet("outPutData");

        int i = 0;
        for (Card card: datas) {
            XSSFRow row = sheet.createRow(i);
            for (int j = 0; j < 4; j++) {
                if(i == 0){
                    for (int k = 0; k < 6; k++) {
                        XSSFCell cell = row.createCell(k);
                        if(k == 0){
                            cell.setCellValue("title");
                        }else if (k == 1){
                            cell.setCellValue("link");
                        }else if (k == 2){
                            cell.setCellValue("description");
                        }else if(k == 3){
                            cell.setCellValue("more info");
                        }else if(k == 4){
                            cell.setCellValue("key work");
                        }else{
                            cell.setCellValue("created time");
                        }
                    }
                }else{
                    for (int k = 0; k < 6; k++) {
                        XSSFCell cell = row.createCell(k);
                        if(k == 0){
                            cell.setCellValue(card.getTitle());
                        }else if (k == 1){
                            cell.setCellValue(card.getLink());
                        }else if (k == 2){
                            cell.setCellValue(card.getDescription());
                        }else if(k == 3){
                            cell.setCellValue(card.getMoreInfo());
                        }else if(k == 4){
                            cell.setCellValue(card.getKeyWork());
                        }else{
                            cell.setCellValue(card.getCreatedTime());
                        }

                    }
                }

            }
            i++;
        }


            File f = new File("./"+filePath);

            if(!f.exists()){
                File parent_directory = f.getParentFile();
                if (null != parent_directory){

                    parent_directory.mkdirs();

                }
                f.createNewFile();
            }
            FileOutputStream outputStream = new FileOutputStream(f);
            workbook.write(outputStream);
            workbook.close();
            System.out.println("done");

    }
}
