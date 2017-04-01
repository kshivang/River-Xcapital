package com.xcapital.river.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.xcapital.river.R;
import com.xcapital.river.misc.ExpenseDetailsSchema;

/**
 * Created by kshivang on 21/03/17.
 */

public class ExpenseDetailsActivity extends AppCompatActivity {

    private ExpenseDetailsSchema expenseDetails;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_expense_details);

        expenseDetails = (ExpenseDetailsSchema) getIntent()
                .getSerializableExtra("expenseDetail");
    }
}
