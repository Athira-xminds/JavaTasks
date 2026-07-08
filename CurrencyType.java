import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class CurrencyType {
    public static void main(String[] args) {
        List<CountryCurrencies> list = Arrays.asList(
                new CountryCurrencies("India", "Indian Rupee"),
                new CountryCurrencies("USA", "US Dollar"),
                new CountryCurrencies("UAE", "United Arab Dirham"),
                new CountryCurrencies("China", "Yuan"));

        Map<String, String> currencyMapping = list.stream()
                .collect(Collectors.toMap(CountryCurrencies::getCountryName, CountryCurrencies::getCurrency));

        System.out.println(currencyMapping);
    }
}
