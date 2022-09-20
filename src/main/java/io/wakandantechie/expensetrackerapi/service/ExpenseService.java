package io.wakandantechie.expensetrackerapi.service;

import io.wakandantechie.expensetrackerapi.model.Expense;

import java.util.List;

public interface ExpenseService {

    List<Expense> getAllExpenses();

    public Expense getExpenseById(Long id);

    public void deleteExpenseById(Long id);

    public Expense saveExpenseDetails(Expense expense);

    public Expense updateExpenseDetails(Long id, Expense expense);
}
