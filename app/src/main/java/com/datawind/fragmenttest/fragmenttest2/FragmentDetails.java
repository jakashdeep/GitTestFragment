package com.datawind.fragmenttest.fragmenttest2;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.datawind.fragmenttest.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentDetails extends Fragment {
    private String TAG = "tst_FragmentDetails";
    int position = 0;
    TextView textView;

    public FragmentDetails() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if(savedInstanceState == null){
            if(getArguments() != null){
                position = getArguments().getInt("position", 0);
            }
        }

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View fragmentDetailsView = inflater.inflate(R.layout.fragment_fragment_details, container, false);
        textView = fragmentDetailsView.findViewById(R.id.detailTextView);
        // Inflate the layout for this fragment
        return fragmentDetailsView;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        updateDetails();
    }

    public void updateDetails(){
        Log.d(TAG, "updateDetails: updateDetails: " + position);
        textView.setText("fdsfasdfadsfdas id " + position);
    }



}
