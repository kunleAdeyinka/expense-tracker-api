package io.wakandantechie.expensetrackerapi.repository;

import io.wakandantechie.expensetrackerapi.model.Expense;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExpenseRepository extends JpaRepository<Expense, Long> {
}
