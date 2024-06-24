package lesson_15.homework;

import lesson_15.homework.exceptions.WrongAccountException;
import lesson_15.homework.exceptions.WrongCurrencyException;
import lesson_15.homework.exceptions.WrongOperationException;

public class Main {

    private static final BankApplication bankApplication = new BankApplication();

    public static void main(String[] args) {
        processWrapper("accountId000", 50, "USD");
        processWrapper("accountId003", 250, "HRV");
        processWrapper("accountId001", 50, "EUR");
        processWrapper("accountId001", 50, "USD");
        processWrapper("accountId001", 2000, "USD");
    }

    public static void processWrapper(String accountId, int amount, String currency) {
        System.out.println("--------------------------------------------------");
        try {
            bankApplication.process(accountId, amount, currency);
            System.out.println("Операція на суму " + amount +" " + currency + " успішна для акаунту " + accountId);
        } catch (WrongAccountException e) {
            System.out.println("Увага "+ accountId + "!\nТакого акаунту не існує " );
        } catch (WrongCurrencyException e) {
            System.out.println("Акаунт "+ accountId + " має рахунок в іншій валюті -> " +currency);
        } catch (WrongOperationException e) {
            System.out.println("Акаунт "+ accountId+ " має недостатньо коштів для виконання операції "+ "\nВаш баланс: "+amount +" "+currency);
        } catch (Exception e) {
            System.out.println("Увага " +accountId +"!\nСталася помилка при процесінгу, спробуйте ще раз");
        } finally {
            System.out.println("Дякуємо, що скористалися нашим сервісом");
            System.out.println("--------------------------------------------------");
            System.out.println();
        }
    }
}
