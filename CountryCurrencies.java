/**
 3.Create a class CountryCurrencies with fields countryName and currency.Make a collection list of CountryCurrencies
 */
class CountryCurrencies {
    String countryName;
    String currency;

    public CountryCurrencies(String countryName, String currency) {
        this.countryName = countryName;
        this.currency = currency;
    }

    public String getCountryName() { return countryName; }
    public String getCurrency() { return currency; }
}
