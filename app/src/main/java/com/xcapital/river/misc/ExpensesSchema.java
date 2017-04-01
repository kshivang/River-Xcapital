package com.xcapital.river.misc;

/**
 * Created by kshivang on 21/03/17.
 */

public class ExpensesSchema {

    private ExpenseCardSchema expenseCardSchema;
    private ExpenseDetailsSchema expenseDetailsSchema;

    public ExpensesSchema setExpensesSchema(ExpenseCardSchema expenseCardShcema,
                                  ExpenseDetailsSchema expenseDetailsSchema){
        this.expenseCardSchema = expenseCardShcema;
        this.expenseDetailsSchema = expenseDetailsSchema;
        return this;
    }

    public ExpenseCardSchema getExpenseCardSchema() {
        return expenseCardSchema;
    }

    public void setExpenseCardSchema(ExpenseCardSchema expenseCardSchema) {
        this.expenseCardSchema = expenseCardSchema;
    }

    public ExpenseDetailsSchema getExpenseDetailsSchema() {
        return expenseDetailsSchema;
    }

    public void setExpenseDetailsSchema(ExpenseDetailsSchema expenseDetailsSchema) {
        this.expenseDetailsSchema = expenseDetailsSchema;
    }
}
