import java.util.HashMap;
import java.util.Map;

public class ExchangeDesk {
    private Map<Class<? extends Currency>, Map<Class<? extends Currency>, Double>> exchangeRates;

    public ExchangeDesk() {
        exchangeRates = new HashMap<>();
    }

    public <T extends Currency, U extends Currency> void addRate(Class<T> fromCurrency, Class<U> toCurrency, double rate) {
        exchangeRates.computeIfAbsent(fromCurrency, k -> new HashMap<>()).put(toCurrency, rate);
        exchangeRates.computeIfAbsent(toCurrency, k -> new HashMap<>()).put(fromCurrency, 1 / rate);
    }

    public <T extends Currency, U extends Currency> U convert(T fromCurrency, Class<U> toCurrency) {
        if (!exchangeRates.containsKey(fromCurrency.getClass()) || !exchangeRates.get(fromCurrency.getClass()).containsKey(toCurrency)) {
            throw new IllegalArgumentException("Exchange rate not available for the specified currencies");
        }

        double rate = exchangeRates.get(fromCurrency.getClass()).get(toCurrency);
        double convertedAmount = fromCurrency.getAmount() * rate;

        try {
            U convertedCurrency = toCurrency.getDeclaredConstructor().newInstance();
            convertedCurrency.setAmount(convertedAmount);
            return convertedCurrency;
        } catch (Exception e) {
            throw new RuntimeException("Failed to convert currency", e);
        }
    }
}

