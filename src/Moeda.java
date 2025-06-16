import java.util.HashMap;
import java.util.Map;

public class Moeda {
    private Map<String, Double> conversion_rates;

    public Moeda() {
        this.conversion_rates = new HashMap<>();
    }


    public void addConversionRate(String currencyCode, Double rate) {
        this.conversion_rates.put(currencyCode, rate);
    }


    public Double getConversionRate(String currencyCode) {
        return conversion_rates.get(currencyCode);
    }


    public Map<String, Double> getAllConversionRates() {
        return new HashMap<>(conversion_rates);
    }
}