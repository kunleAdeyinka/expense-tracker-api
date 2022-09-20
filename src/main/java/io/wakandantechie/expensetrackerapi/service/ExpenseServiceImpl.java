package io.wakandantechie.expensetrackerapi.service;

import io.wakandantechie.expensetrackerapi.model.Expense;
import io.wakandantechie.expensetrackerapi.repository.ExpenseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ExpenseServiceImpl implements ExpenseService{

    @Autowired
    private ExpenseRepository expenseRepository;

    @Override
    public List<Expense> getAllExpenses() {
        List<Expense> expenses = expenseRepository.findAll();
        return expenses;
    }

    @Override
    public Expense getExpenseById(Long id) {
        Optional<Expense> expense = expenseRepository.findById(id);
        if(expense.isPresent()) {
            return expense.get();
        }
        throw new RuntimeException("Expense is not found for the id " + id);
    }

    @Override
    public void deleteExpenseById(Long id) {
        expenseRepository.deleteById(id);
    }

    @Override
    public Expense saveExpenseDetails(Expense expense) {
        return expenseRepository.save(expense);
    }

    @Override
    public Expense updateExpenseDetails(Long id, Expense expense) {
        Expense existingExpense = getExpenseById(id);
        if(expense.getName() != null) {
            existingExpense.setName(expense.getName());
        }

        if(expense.getCategory() != null) {
            existingExpense.setCategory(expense.getCategory());
        }

        if(expense.getDescription() != null) {
            existingExpense.setDescription(expense.getDescription());
        }

        if(expense.getAmount() != null) {
            existingExpense.setAmount(expense.getAmount());
        }

        if(expense.getDate() != null) {
            existingExpense.setDate(expense.getDate());
        }





        return expenseRepository.save(existingExpense);
    }


}
