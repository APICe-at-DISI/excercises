package it.unibo.bank.impl;

import it.unibo.bank.api.AccountHolder;

public class StrictBankAccount extends SimpleBankAccount {

    private static final double TRANSACTION_FEE = 0.1;

    public StrictBankAccount(final AccountHolder accountHolder, final double balance) {
        super(accountHolder, balance);
    }

    public void chargeManagementFees(final int usrID) {
        final double feeAmount = MANAGEMENT_FEE + getTransactionsCount() * TRANSACTION_FEE;
        if (checkUser(usrID) && isWithdrawAllowed(feeAmount)) {
            setBalance(getBalance() - feeAmount);
            resetTransactions();
        } else {
            throw new IllegalArgumentException("ID not corresponding: cannot charge management fees.");
        }
    }

    public void withdraw(final int usrID, final double amount) {
        if (isWithdrawAllowed(amount)) {
            super.withdraw(usrID, amount);
        } else {
            throw new IllegalStateException("Not enough balance: cannot withdraw.");
        }
    }

    protected boolean isWithdrawAllowed(final double amount) {
        return (amount > 0 && getBalance() > amount);
    }

}
