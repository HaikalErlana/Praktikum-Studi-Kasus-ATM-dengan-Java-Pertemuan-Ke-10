package com.atm.transaction;

import com.atm.model.Account;
import java.util.Scanner;

public class Withdrawal extends Transaction {
    private static final double MINIMUM_BALANCE = 50000;

    public Withdrawal(Account account) {
        super(account);
    }

    @Override
    public void execute() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Masukkan jumlah penarikan: ");
        double amount = scanner.nextDouble();

        if (amount <= account.getBalance() - MINIMUM_BALANCE) {
            account.debit(amount);
            System.out.println("Penarikan berhasil. Saldo Anda sekarang: " + account.getBalance());
        } else {
            System.out.println("Saldo tidak mencukupi untuk penarikan dengan saldo minimal Rp50,000.");
        }

    }
}