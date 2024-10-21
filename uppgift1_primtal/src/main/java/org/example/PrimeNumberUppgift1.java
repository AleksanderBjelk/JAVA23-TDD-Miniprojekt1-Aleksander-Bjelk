package org.example;

public class PrimeNumberUppgift1 {

    //räknar antal primtal
    public int countPrimeNumbers(int start, int end) {
        int count = 0;
        for (int i = start; i <= end; i++) {
            if (isPrimeNumber(i)) {
                count++;
            }
        }
        return count;
    }

    //kollar så att det är primtal (tal som bara kan delas med 1 och sig självt)
    private boolean isPrimeNumber(int number) {
        if (number <= 1) return false;
        for (int i = 2; i <= Math.sqrt(number); i++) {
            if (number % i == 0) return false;
        }
        return true;
    }

    //adderar summan av alla primtal
    public int sumPrimeNumbers(int start, int end) {
        int sum = 0;
        for (int i = start; i <= end; i++) {
            if (isPrimeNumber(i)) {
                sum += i;
            }
        }
        return sum;
    }

    //meddelandet för antal primtal det finns
    public void logPrimeNumbers(int count) {
        System.out.println("Hej, det finns " + count + " primtal mellan 0 och 1000!");
    }

    //meddelandet för summan av primtalen
    public void logSumPrimeNumbers(int sum) {
        System.out.println("Och den totala summan av dessa primtal är " + sum + ".");
    }

    //hanterar så att intervallet kan endast vara 0-1000, ger annars felmeddelande
    public boolean validateInput(int start, int end) {
        if (start < 0 || end > 1000 || start > end) {
            System.out.println("Hoppsan, fel intervall angivet!");
            return false;
        }
        return true;
    }

    //kör programmet (testas inte så ger därav 6/7 testade)
    public static void main(String[] args) {
        PrimeNumberUppgift1 counter = new PrimeNumberUppgift1();

        int start = 0;
        int end = 1000;

        if (counter.validateInput(start, end)) {
            int count = counter.countPrimeNumbers(start, end);
            int sum = counter.sumPrimeNumbers(start, end);
            counter.logPrimeNumbers(count);
            counter.logSumPrimeNumbers(sum);
        }
    }
}
