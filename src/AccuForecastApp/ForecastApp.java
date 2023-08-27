package AccuForecastApp;

import okhttp3.OkHttpClient;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Scanner;
/*Weather forecast service with using accuweather api
for 1 or 5 days with adding results to the database*/
public class ForecastApp {

    public static void main(String[] args) throws IOException {
        try{
            Forecasts f = new Forecasts();
            f.deleteFromDB(); //delete all previous results from database;
            issue(f);
                f.readFromDB();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    public static void issue(Forecasts f)throws SQLException, IOException {
        OkHttpClient okHttpClient = new OkHttpClient();
        Scanner scanner = new Scanner(System.in);
        while (true){
            System.out.println("Enter:\n1 - to get 1-day forecast;\n2 - for 5-day forecast;");
            String enterCity = scanner.nextLine();
            if (enterCity.equals("1")) {
                System.out.println(f.oneDayForecast(okHttpClient));
                System.out.println("*****");
                System.out.println("Want another forecast? (1-y/2-n)");
                String ans = scanner.nextLine();
                if (ans.equals("1") | ans.equals("y")){
                    issue(f);}
                else {break;}
            } else if (enterCity.equals("2")) {
                System.out.println(f.fiveDayForecast(okHttpClient));
                System.out.println("*****");
                System.out.println("Want another forecast? (1-y/2-n)");
                String ans = scanner.nextLine();
                if (ans.equals("1") | ans.equals("y")){
                    issue(f);}
                else {break;}
            } else {
                System.out.println("You can enter only 1 or 2!!!");
            }
        }
    }

}

