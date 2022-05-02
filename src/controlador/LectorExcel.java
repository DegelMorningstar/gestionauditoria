/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

/**
 *
 * @author Yael_
 */
import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
public class LectorExcel {
    public LectorExcel() {
    }// fin contructor
    public List getExcel(File fileName){
        int indice = 0;
        List cellData = new ArrayList();
        try {
            File rutaArchivoExcel = fileName;
            FileInputStream inputStream = new FileInputStream(rutaArchivoExcel);
            Workbook workbook = new XSSFWorkbook(inputStream);
            Sheet firstSheet = workbook.getSheetAt(0);
            Iterator iterator = firstSheet.iterator();
            
            DataFormatter formatter = new DataFormatter();
            while (iterator.hasNext()) {
                Row nextRow = (Row) iterator.next();
                Iterator cellIterator = nextRow.cellIterator();
                indice=0;
                String [] aux = new String [14];
                while(cellIterator.hasNext()) {
                    Cell cell = (Cell) cellIterator.next();
                    String contenidoCelda = formatter.formatCellValue(cell);
                    aux[indice] = contenidoCelda;
                    indice++;
                }
                cellData.add(aux);
            }
            //imprimiraux(cellData);
            return cellData;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public void imprimiraux(List lista){
        System.out.println("-------------------------------------------------------------------------------");
        System.out.println("size lista: "+lista.size());
        for (int i = 0; i < lista.size(); i++) {
            String [] l = (String[]) lista.get(i);
            for (int j = 0; j < l.length; j++) {
                System.out.println("celda: "+l[j]);
            }
        }
    }
}
