package InputOutputExmple;

import java.io.*;
import java.util.Arrays;
/*1. Реализовать сохранение данных в csv файл;
2. Реализовать загрузку данных из csv файла. Файл читается целиком.
Структура csv файла:
| Строка заголовок с набором столбцов |
| Набор строк с целочисленными значениями |
| * Разделитель между столбцами - символ точка с запятой (;) |
Пример:
Value 1;Value 2;Value 3
100;200;123
300,400,500*/
public class AppData {
    private String [] header;
    private int [][] data;
    public AppData(String[] header, int[][] data) {
        this.header = header;
        this.data = data;
    }
    public String[] getHeader() {
        return header;
    }
    public int[][] getData() {
        return data;
    }
    //метод побайтовой записи в файл:
    public void writeBts(File file){
        byte []b = ";".getBytes();
        byte[]n = "\n".getBytes();
        //заголовок:
        try {FileOutputStream fos = new FileOutputStream(file);
            for(int i=0;i<this.getHeader().length;i++){
                byte[] outHeader = this.getHeader()[i].getBytes();
                fos.write(outHeader);
                fos.write(b);
            }
        } catch (IOException e) {e.printStackTrace();}
        //данные:
        try {FileOutputStream fos = new FileOutputStream(file, true);
            for (int i=0;i<this.getData().length;i++){
                fos.write(n);
            for (int j=0;j<this.getData()[i].length;j++){
                byte[] outData = String.valueOf(this.getData()[i][j]).getBytes();
                fos.write(outData);
                fos.write(b);}
        }
        }catch (IOException e){e.printStackTrace();}
    }
    //метод побайтового чтения даных из файла в консоль:
    public void readBts(File file){
        try (FileInputStream in = new FileInputStream(file)) {
            for(int i=0;i<this.getHeader().length;i++){
                byte[] buf = new byte[1220];
                int count;
                while ((count = in.read(buf)) > 0) {
                    for (int j = 0; j < count; j++) {
                        System.out.print((char) buf[j]);}
                }
            }
        } catch (IOException e) {e.printStackTrace();}
    }


    public static void main(String[] args) {
        String [] header = {"Value1", "Value2", "Value3"};
        int [][] data = {{100, 200, 300}, {300, 200, 123}, {252, 321, 115}};

        File file = new File("src/resources/table.csv");
        AppData appData = new AppData(header, data);

        //реализация записи
        appData.writeBts(file);

        //реализация чтения
        appData.readBts(file);
    }
}

