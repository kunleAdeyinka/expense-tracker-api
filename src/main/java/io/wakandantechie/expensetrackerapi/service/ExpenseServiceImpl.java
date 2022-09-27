package io.wakandantechie.expensetrackerapi.service;

import io.wakandantechie.expensetrackerapi.exceptions.ResourceNotFoundException;
import io.wakandantechie.expensetrackerapi.model.Expense;
import io.wakandantechie.expensetrackerapi.repository.ExpenseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class ExpenseServiceImpl implements ExpenseService{

    @Autowired
    private ExpenseRepository expenseRepository;

    @Override
    public Page<Expense> getAllExpenses(Pageable page) {
        Page<Expense> expenses = expenseRepository.findAll(page);
        return expenses;
    }

    @Override
    public Expense getExpenseById(Long id) {
        Optional<Expense> expense = expenseRepository.findById(id);
        if(expense.isPresent()) {
            return expense.get();
        }
        throw new ResourceNotFoundException("Expense is not found for the id " + id);
    }

    @Override
    public void deleteExpenseById(Long id) {
        Expense expense = getExpenseById(id);
        expenseRepository.delete(expense);
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

    @Override
    public List<Expense> readByCategory(String category, Pageable pageable) {
        return expenseRepository.findByCategory(category, pageable).toList();
    }

    @Override
    public List<Expense> findByName(String keyword, Pageable pageable) {
        return expenseRepository.findByNameContaining(keyword, pageable).toList();
    }

    @Override
    public List<Expense> findByDateBetween(Date startDate, Date endDate, Pageable pageable) {
        if (startDate == null) {
            startDate = new Date(0);
        }

        if(endDate == null) {
            endDate = new Date(System.currentTimeMillis());
        }

        return expenseRepository.findByDateBetween(startDate, endDate, pageable).toList();
    }

}
