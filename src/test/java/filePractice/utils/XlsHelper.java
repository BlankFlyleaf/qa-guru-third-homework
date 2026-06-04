package filePractice.utils;

import com.codeborne.xlstest.XLS;

public class XlsHelper {

    public String getCellValue(XLS xls, int sheetIndex, int rowIndex, int cellIndex){
        return xls.excel
                .getSheetAt(sheetIndex)
                .getRow(rowIndex)
                .getCell(cellIndex)
                .getStringCellValue();
    }
}
