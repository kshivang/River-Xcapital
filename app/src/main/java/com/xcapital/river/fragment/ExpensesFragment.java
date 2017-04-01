package com.xcapital.river.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.xcapital.river.R;
import com.xcapital.river.activity.ExpenseDetailsActivity;
import com.xcapital.river.adapter.ExpenseAdapter;
import com.xcapital.river.misc.ExpenseCardSchema;
import com.xcapital.river.misc.ExpenseDetailsSchema;
import com.xcapital.river.misc.ExpensesSchema;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by kshivang on 07/03/17.
 *
 */

public class ExpensesFragment extends Fragment {

    List<ExpensesSchema> expensesSchemasList;
    RecyclerView recyclerView;
    ViewPager viewPager;
    TabLayout tabLayout;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
                             Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_expenses, container, false);
        recyclerView = (RecyclerView) root.findViewById(R.id.recyclerView);
        viewPager = (ViewPager) root.findViewById(R.id.viewPager);
        tabLayout = (TabLayout) root.findViewById(R.id.tab_layout);

        //For Test purpose only delete below line after integration with backend
        expensesSchemasList = new ArrayList<>();
        ExpenseCardSchema expense1 = new ExpenseCardSchema();
        expense1.setAmount("₹100");
        expense1.setBankCode("SBIXXX");
        expense1.setInfo("CCD");
        expense1.setTimeStamp("Today 11:30pm");
        ExpenseDetailsSchema expenseTab1 = new ExpenseDetailsSchema();
        expensesSchemasList.add(new ExpensesSchema().setExpensesSchema(expense1, expenseTab1));

        ExpenseCardSchema expense2 = new ExpenseCardSchema();
        expense2.setAmount("₹200");
        expense2.setBankCode("SBIXXX");
        expense2.setInfo("MC Donald");
        expense2.setTimeStamp("Today 1:30pm");
        ExpenseDetailsSchema expenseTab2 = new ExpenseDetailsSchema();
        expensesSchemasList.add(new ExpensesSchema().setExpensesSchema(expense2, expenseTab2));
        //Till here

        return root;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        ExpenseAdapter adapter = new ExpenseAdapter(expensesSchemasList, new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int position = recyclerView.getChildAdapterPosition(view);
                startActivity(new Intent(getContext(), ExpenseDetailsActivity.class)
                        .putExtra("expenseDetail", expensesSchemasList.get(position)
                                .getExpenseDetailsSchema()));
            }
        });
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setAdapter(adapter);

        FragmentPagerAdapter adapter1 = new FragmentPagerAdapter(getChildFragmentManager()) {
            @Override
            public Fragment getItem(int position) {
                return TabFragment.newInstance(position);
            }

            @Override
            public int getCount() {
                return 3;
            }
        };

        viewPager.setAdapter(adapter1);
        tabLayout.setupWithViewPager(viewPager, true);
    }
}

