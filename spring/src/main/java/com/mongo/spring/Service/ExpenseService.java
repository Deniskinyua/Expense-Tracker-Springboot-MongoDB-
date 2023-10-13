package com.mongo.spring.Service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.mongo.spring.Repository.ExpenseRepository;
import com.mongo.spring.model.Expense;



@Service
public class ExpenseService {
	
	private final ExpenseRepository expenseRepository;
	public ExpenseService(ExpenseRepository expenseRepository) {
		this.expenseRepository = expenseRepository;
		
	}
	
	//Add
	public void addExpense(Expense expense) {
		expenseRepository.insert(expense);
	}
	//Update
	public void updateExpense(Expense expense) {
		Expense savedExpense = expenseRepository.findById(expense.getId()).orElseThrow(
				() -> new RuntimeException(
						String.format("CANNOT_FIND_EXPENSE_BY_ID %s", expense.getId())));
						
		savedExpense.setExpenseName(expense.getExpenseName());
		savedExpense.setExpenseCategory(expense.getExpenseCategory());
		savedExpense.setExpenseAmount(expense.getExpenseAmount());
		
		expenseRepository.save(expense);
	}
	//Get
	public Expense getExpense(String name) {
        return expenseRepository.findByName(name)
                .orElseThrow(() -> new RuntimeException(String.format("Cannot Find Expense by Name - %s", name)));
    }
	//GetAll
	public List<Expense> getAllExpenses() {
		return expenseRepository.findAll();
	}
	//Delete
	public void deleteExpense(String id) {
		expenseRepository.deleteById(id);
	}
}
