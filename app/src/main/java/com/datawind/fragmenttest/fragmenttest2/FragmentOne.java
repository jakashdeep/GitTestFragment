package com.datawind.fragmenttest.fragmenttest2;


import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;

import com.datawind.fragmenttest.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentOne extends Fragment{

    private String TAG = "tst_FragmentOne";

    ListView listView;

    public FragmentOne() {
        // Required empty public constructor
    }

    OnTopicSelectedListener mCallback;

    // Container Activity must implement this interface
    public interface OnTopicSelectedListener {
        public void onArticleSelected(int position);
    }

    /**
     * Called when a fragment is first attached to its context.
     * {@link #onCreate(Bundle)} will be called after this.
     *
     * @param context
     */
    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        Log.d(TAG, "onAttach: Fragment is getting");

        try {
            mCallback = (OnTopicSelectedListener) context;
        }catch(ClassCastException e){
            Log.e(TAG, "onAttach: ClassCastException: ", e);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        View fragmentOneView = inflater.inflate(R.layout.fragment_fragment3, container, false);

        listView = fragmentOneView.findViewById(R.id.listView);

        return fragmentOneView;
    }

    /**
     * @param view               The View returned by {@link #onCreateView(LayoutInflater, ViewGroup, Bundle)}.
     * @param savedInstanceState If non-null, this fragment is being re-constructed
     */
    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        createList();
    }

    private void createList(){
        ArrayAdapter arrayAdapter = new ArrayAdapter(getContext() , android.R.layout.simple_list_item_1);
        arrayAdapter.add("Test1");
        arrayAdapter.add("Test2");
        listView.setAdapter(arrayAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Log.d(TAG, "onClick: List view got click: ");
                mCallback.onArticleSelected(position);
            }
        });
    }

}
