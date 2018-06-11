package lesson20.task2;

public class Utils {
    private int limitTransactionsPerDaycount = 10;
    private int limitTransactionsPerDayAmount = 100;
    private int limitSimpleTransactionsAmount = 40;
    private String[] cities = {"Kiev", "Odessa"};


    public int getLimitTransactionsPerDaycount() {
        return limitTransactionsPerDaycount;
    }

    public int getLimitTransactionsPerDayAmount() {
        return limitTransactionsPerDayAmount;
    }

    public int getLimitSimpleTransactionsAmount() {
        return limitSimpleTransactionsAmount;
    }

    public String[] getCities() {
        return cities;
    }
}