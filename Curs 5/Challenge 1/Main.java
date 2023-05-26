public class Main {
    public static void main(String[] args) {
        ExchangeDesk exchangeDesk = new ExchangeDesk();

        // Adding exchange rates
        exchangeDesk.addRate(RON.class, USD.class, 0.24);
        exchangeDesk.addRate(USD.class, RON.class, 4.1);

        // Currency conversion
        RON lei = new RON();
        lei.setAmount(1000);

        USD dollar = exchangeDesk.convert(lei, USD.class);
        System.out.println(dollar.getAmount()); // Output: 240.0

        RON leiConverted = exchangeDesk.convert(dollar, RON.class);
        System.out.println(leiConverted.getAmount()); // Output: 1000.0
    }
}

