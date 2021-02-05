package utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Iterator;

public class FileUtils {

    public static byte[] readBytesFromFile(String filePath) {
        File file = new File(filePath);
        try {
            return Files.readAllBytes(Paths.get(file.getAbsolutePath()));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return new byte[]{};
    }

    public static String readStringFromFile(String filePath) {
        return new String(readBytesFromFile(filePath));
    }

    public void saveFile(String content, String filePath) {
        File file = new File(filePath);
        try {
            file.getParentFile().mkdirs();
            file.createNewFile();
            PrintWriter writer = new PrintWriter(file, "UTF-8");
            writer.write(content);
            writer.flush();
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}

//
//
//    public static String readXlsxFromFile(String file){
//        String result = "";
//        XSSFWorkbook myExcelBook = null;
//
//        try {
//            myExcelBook = new XSSFWorkbook(new FileInputStream(file));
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//
//        XSSFSheet myExcelSheet = myExcelBook.getSheetAt(0);
//        Iterator<Row> rows = myExcelSheet.iterator();
//
//        while (rows.hasNext()) {
//            Row row = rows.next();
//            Iterator<Cell> cells = row.iterator();
//            while (cells.hasNext()) {
//                Cell cell = cells.next();
//                CellType cellType = cell.getCellType();
//                //перебираем возможные типы ячеек
//                switch (cellType) {
////                    case Cell.CELL_TYPE_STRING:
////                        result += cell.getStringCellValue() + "=";
////                        break;
////                    case Cell.CELL_TYPE_NUMERIC:
////                        result += "[" + cell.getNumericCellValue() + "]";
////                        break;
////
////                    case Cell.CELL_TYPE_FORMULA:
////                        result += "[" + cell.getNumericCellValue() + "]";
////                        break;
//                    default:
//                        result += cell.toString();
//                        break;
//                }
//            }
//        }
//
//        try {
//            myExcelBook.close();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//
//        return result;
//    }
//}
