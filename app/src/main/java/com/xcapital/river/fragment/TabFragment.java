package com.xcapital.river.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.xcapital.river.R;

/**
 * Created by kshivang on 21/03/17.
 */

public class TabFragment extends Fragment {

    private static final String WHICH_TAB = "wt";

    public static Fragment newInstance(int whichTab) {
        Fragment fragment = new TabFragment();
        Bundle args = fragment.getArguments();
        if (args == null) {
            args = new Bundle();
        }
        args.putInt(WHICH_TAB, whichTab);
        fragment.setArguments(args);
        return fragment;
    }

    private TextView tvTotal;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.tab_fragment, container, false);
        tvTotal = (TextView) root.findViewById(R.id.total);
        return root;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        switch (getArguments().getInt(WHICH_TAB)) {
            case 0:
                tvTotal.setText(String.format("Total : %s", getTotal()));
                break;
            case 1:
                tvTotal.setText(String.format("Goal : %s", getGoal()));
                break;
            default:
                tvTotal.setText(String.format("Saved : %s", getSaved()));
        }
    }

    private String getTotal () {
        //todo update it with some real fetch function
        return "$ 100";
    }

    private String getGoal () {
        //todo update it with some real fetch function
        return "$ 1000";
    }

    private String getSaved () {
        //todo update it with some real fetch function
        return "$ 20";
    }
}
