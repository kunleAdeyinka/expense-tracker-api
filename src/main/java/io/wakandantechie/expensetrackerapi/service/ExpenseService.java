package io.wakandantechie.expensetrackerapi.service;

import io.wakandantechie.expensetrackerapi.model.Expense;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Date;
import java.util.List;

public interface ExpenseService {

    Page<Expense> getAllExpenses(Pageable page);

    public Expense getExpenseById(Long id);

    public void deleteExpenseById(Long id);

    public Expense saveExpenseDetails(Expense expense);

    public Expense updateExpenseDetails(Long id, Expense expense);

    public List<Expense> readByCategory(String category, Pageable pageable);

    public List<Expense> findByName(String keyword, Pageable pageable);

    public List<Expense> findByDateBetween(Date startDate, Date endDate, Pageable pageable);
}
