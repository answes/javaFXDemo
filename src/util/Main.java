package util;

import org.apache.http.HttpResponse;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class Main {
    public static void main(String[] arg) {

//        new Thread(new Runnable() {
//            @Override
//            public void run() {
//                while (true)
//                runThread("usessionId=2730178f249244798321b9b86edbbb89",10,0,1,20);
//            }
//        }).start();

//        new Thread(new Runnable() {
//            @Override
//            public void run() {
//                while (true)//18376757142
//                runThread("usessionId=d7ea903fb23e435bb28cb1469dc2c1d4",10,0,1,20);
//            }
//        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                while (true)//18376757141
                runThread("usessionId=null39",5,1,2,20);
            }
        }).start();
    }

    public static void runThread(String cookie, int price, int zaraId, int type, int number){
        Map<String, String> haeder = new HashMap<>();
        Map<String, String> qurey = new HashMap<>();

        haeder.put("Cookie", cookie);
        String  param = String.format("marketId=6&price=%d&zaraId=%d&num=%d&type=%d&tpassword=123456",new Random().nextInt(price)+1,zaraId,new Random().nextInt(number)+1,type);
        try {
            HttpResponse response = HttpUtils.doPost("http://192.168.1.120/trade/order/serverCreateOrder.o?" + param, "", "", haeder, qurey, param);
            InputStreamReader inputStreamReader = new InputStreamReader(response.getEntity().getContent());
            BufferedReader buffered = new BufferedReader(inputStreamReader);
            StringBuffer sb = new StringBuffer();
            String string = buffered.readLine();
            while (string != null) {
                sb.append(string);
                string = buffered.readLine();
            }
            System.out.println(sb.toString()+"");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
