package com.xcapital.river.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.xcapital.river.R;
import com.xcapital.river.misc.ExpenseCardSchema;
import com.xcapital.river.misc.ExpensesSchema;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by kshivang on 21/03/17.
 *
 */

public class ExpenseAdapter extends RecyclerView.Adapter<ExpenseAdapter.ExpenseViewHolder> {

    private List<ExpensesSchema> expenses = new ArrayList<>();
    private View.OnClickListener onClickListener;

    public ExpenseAdapter(List<ExpensesSchema> expenses,
                          View.OnClickListener onClickListener) {
        this.expenses = expenses;
        this.onClickListener = onClickListener;
    }

    @Override
    public ExpenseViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_expense,
                parent, false);
        view.setOnClickListener(onClickListener);
        return new ExpenseViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ExpenseViewHolder holder, int position) {
        ExpenseCardSchema expense = expenses.get(position).getExpenseCardSchema();
        holder.tvInfo.setText(expense.getInfo());
        holder.tvTimeStamp.setText(expense.getTimeStamp());
        holder.tvAmount.setText(expense.getAmount());
        holder.tvBankCode.setText(expense.getBankCode());

    }

    @Override
    public int getItemCount() {
        return (null != expenses ? expenses.size() : 0);
    }

    class ExpenseViewHolder extends RecyclerView.ViewHolder {

        TextView tvInfo, tvTimeStamp, tvAmount, tvBankCode;

        ExpenseViewHolder(View view) {
            super(view);
            tvInfo = (TextView) view.findViewById(R.id.info);
            tvTimeStamp = (TextView) view.findViewById(R.id.timeStamp);
            tvAmount = (TextView) view.findViewById(R.id.amount);
            tvBankCode = (TextView) view.findViewById(R.id.bankCode);
        }
    }
}
