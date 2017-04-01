package com.xcapital.river.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import com.xcapital.river.R;
import com.xcapital.river.fragment.ExpensesFragment;
import com.xcapital.river.fragment.GoalFragment;
import com.xcapital.river.fragment.SavingFragment;

/**
 * Created by kshivang on 07/03/17.
 *
 */

public class SwipeActivity extends AppCompatActivity {


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_swipe);

        final TabLayout tabLayout = (TabLayout) findViewById(R.id.primary_tabs);
        final ViewPager mViewPager = (ViewPager) findViewById(R.id.fragment);


        FragmentPagerAdapter adapter = new FragmentPagerAdapter(getSupportFragmentManager()) {
            @Override
            public Fragment getItem(int position) {
                switch (position) {
                    case 0:
                        return new ExpensesFragment();
                    case 1:
                        return new GoalFragment();
                    default:
                        return new SavingFragment();
                }
            }

            @Override
            public int getCount() {
                return 3;
            }

        };

        mViewPager.setAdapter(adapter);
        tabLayout.setupWithViewPager(mViewPager);

        TabLayout.Tab tbExpenses = tabLayout.getTabAt(0);
        TabLayout.Tab tbGoals = tabLayout.getTabAt(1);
        TabLayout.Tab tbSaving = tabLayout.getTabAt(2);

        if (tbExpenses != null) {
            tbExpenses.setIcon(R.drawable.ic_tab_expenses);
        }
        if (tbGoals != null) {
            tbGoals.setIcon(R.drawable.ic_tab_goals);
        }
        if (tbSaving != null) {
            tbSaving.setIcon(R.drawable.ic_tab_saving);
        }
    }

}
