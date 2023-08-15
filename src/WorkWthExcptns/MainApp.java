package WorkWthExcptns;
/*Напишите метод, на вход которого подаётся двумерный строковый массив размером 4х4.
При подаче массива другого размера необходимо бросить исключение MyArraySizeException.
Далее метод должен пройтись по всем элементам массива, преобразовать в int и просуммировать.
Если в каком-то элементе массива преобразование не удалось (например, в ячейке лежит символ или текст вместо числа),
должно быть брошено исключение MyArrayDataException с детализацией, в какой именно ячейке лежат неверные данные.
В методе main() вызвать полученный метод, обработать возможные исключения MyArraySizeException и MyArrayDataException
и вывести результат расчета*/
public class MainApp {
    public static void main(String[] args){
        String [][] mtrx = {{"2", "21", "5", "8"}, {"12", "4", "7", "12"}, {"13", "14", "1", "9"}, {"16", "25", "1", "0"}};
        String [][] errMtrx = {{"7", "3"}, {"9", "6"}, {"2", "8"}};
        String [][] err2Mtrx = {{"17", "2", "22", "7"}, {"3", "4", "10", "6"}, {"2", "9", "k", "6"}, {"7", "55", "13", "5"}};
        String[][][] arr = {mtrx, err2Mtrx, errMtrx};
        for (int i=0; i<arr.length;i++){
            try {
                System.out.println(doMatrix(arr[i]));
            } catch (MyArraySizeException |MyArrayDataException e){
                e.printStackTrace();
            }
        }
    }
    public static void rightVal(String[][] s) throws MyArraySizeException{
        if (s.length<4 || s[0].length<4) throw new MyArraySizeException();
    }
    public static Integer doMatrix(String[][] s) throws MyArraySizeException, MyArrayDataException{
        rightVal(s);
        int c = 0;
        for (int i = 0; i < 4; i++) {
                for (int j = 0; j < 4; j++) {
                   try{ c += Integer.valueOf(s[i][j]);}
                   catch (NumberFormatException ex){
                       throw new MyArrayDataException("Error in pos "+i+" / "+j);}
                }
            } return c;

    }
}
