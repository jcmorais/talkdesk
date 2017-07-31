import java.io.IOException;
import java.util.HashMap;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException {

        Parser parser = new Parser();
        HashMap<String, List<Call>> mapCalls = parser.read("input.in");


        HashMap<String, Integer> fromTotalInSeconds = new HashMap<>();

        for (String s : mapCalls.keySet()) {
            int sum = 0;
            for (Call call : mapCalls.get(s)) {
                sum += call.getCallTimeInSeconds();
            }
            fromTotalInSeconds.put(s, sum);
        }

        System.out.println("total SEC "+fromTotalInSeconds);

        int max=0;
        String numberMax="";
        for (String s : fromTotalInSeconds.keySet()) {
            if (max < fromTotalInSeconds.get(s)){
                numberMax = s;
                max = fromTotalInSeconds.get(s);
            }
        }

        mapCalls.remove(numberMax);


        Double sumPrice=0.0;

        for (String s : mapCalls.keySet()) {

            for (Call call : mapCalls.get(s)) {
                long m = call.getCallTimeInMinutes();
                if (m <= 5)
                    sumPrice += m* 0.05;
                else {
                    sumPrice += 0.25;
                    sumPrice += (m-5)*0.02;
                }
            }

        }


        System.out.println("PRICE: "+sumPrice);


    }
}
