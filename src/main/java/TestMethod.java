import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import lombok.Getter;
import lombok.Setter;
import lombok.Getter;
import lombok.Setter;
import org.jsoup.Jsoup;

import java.io.IOException;
import java.lang.reflect.Type;
import java.math.BigDecimal;
import java.util.Currency;

import java.math.BigDecimal;
import java.util.Currency;
import java.util.List;

public class TestMethod {

    private static final String URL = "https://api.privatbank.ua/p24api/pubinfo?exchange&coursid=11";

    public TestMethod() throws IOException {
    }

    private static List<Privat> convertResponseToList(String response){
        Type type = TypeToken.getParameterized(List.class,Privat.class).getType();
        Gson gson = new Gson();

        return gson.fromJson(response,type); // перетворює дсон у список обьектів
    }

     static String response;

    static {
        try {
            response = Jsoup.connect(URL).ignoreContentType(true).get().body().text();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) {

List<Privat> respData = convertResponseToList(response); // лист обьектів приват це робота метода с дсон силкою

       // System.out.println(response);
        // System.out.println(respData);
        //System.out.println(respData.get(1)); // всього буде два обьекта
       // System.out.println();
        System.out.println(Currency.getInstance("USA"));
    }


}

@Setter
@Getter
class Privat{

        private Currency ccy;
        private Currency base_ccy;
        private BigDecimal buy;
        private BigDecimal sale;

        @Override
        public String toString() {
            return "PrivateBank change " +
                    ccy +
                    " to " + base_ccy +
                    "\n by this course:\n" +
                    " buy = " + buy +
                    ", sale = " + sale +
                    '}';
        }
    }

