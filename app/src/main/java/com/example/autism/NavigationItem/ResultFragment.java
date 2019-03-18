package com.example.autism.NavigationItem;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.autism.R;


/**
 * A simple {@link Fragment} subclass.
 */
public class ResultFragment extends Fragment {

    TextView total_marks_tv, got_marks_tv;

    public ResultFragment() {
        // Required empty public constructor
    }

    public static ResultFragment getInstance(String question, String marks) {

        Bundle bundle = new Bundle();
        bundle.putString("question", question);
        bundle.putString("marks", marks);
        ResultFragment resultFragment = new ResultFragment();
        resultFragment.setArguments(bundle);
        return resultFragment;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_result, container, false);

        total_marks_tv = view.findViewById(R.id.total_marks_tv);
        got_marks_tv = view.findViewById(R.id.got_marks_tv);

        String question = getArguments().getString("question");
        String marks = getArguments().getString("marks");

        if (question !=null && marks != null){

            total_marks_tv.setText("Total marks : "+question);
            got_marks_tv.setText("You got : "+marks);

        }

        return view;
    }

}
