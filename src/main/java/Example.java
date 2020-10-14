import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;


public class Example {
    public static void main(String[] args) throws IOException {
        //you can read from console, you can not read from console
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
//        String url = reader.readLine();
        String url = "http://site.com/test?weight=150&justBecouse&name=Vasya";
        parseQueryParams(url);
    }

    public static void parseQueryParams(String url) {
        ArrayList param = new ArrayList();
        HashMap<String, String> map = new HashMap();

        String[] part1 = url.split("\\?");
        String[] part2 = part1[1].split("\\&");

        for (String s : part2) {
            String[] part3 = s.split("\\=");
            if (part3.length > 1) {
                map.put(part3[0], part3[1]);
                param.add(part3[0]);
            } else param.add(part3[0]);
        }

        System.out.println("Parsed query parameters are:");
        for (Object s : param) {
            System.out.print(s + " ");
        }

        for (HashMap.Entry<String, String> pair : map.entrySet()) {
            System.out.printf("\n" + "For parameter %s value is %s", pair.getKey(), pair.getValue());
        }

    }
}