package io.wakandantechie.expensetrackerapi.repository;

import io.wakandantechie.expensetrackerapi.model.Expense;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;

@Repository
public interface ExpenseRepository extends JpaRepository<Expense, Long> {

    //SELECT * FROM tbl_expenses WHERE category=?
    public Page<Expense> findByCategory(String category, Pageable pageable);

    //SELECT * FROM tbl_expenses WHERE name LIKE '%keyword%'
    public Page<Expense> findByNameContaining(String keyword, Pageable pageable);

    //SELECT * FROM tbl_expenses WHERE date BETWEEN 'startDate' AND 'endDate'
    public Page<Expense> findByDateBetween(Date startDate, Date endDate, Pageable pageable);
}
