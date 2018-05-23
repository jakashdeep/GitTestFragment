package com.datawind.fragmenttest;

import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

public class MainActivity extends AppCompatActivity implements DetailFragment.OnDetailFragmentListener {
    DetailFragment detailFragment;
    Fragment2 fragment2;
    boolean isSet = false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        detailFragment = new DetailFragment();
        fragment2 = new Fragment2();
    }

    public void onButtonClick(View view){

        if(isSet) {
            fragmentTransaction1();
            isSet=false;
        }
        else {
            fragmentTransaction2();
            isSet=true;
        }
    }

    private void fragmentTransaction1(){
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.fragmentLayout, detailFragment);
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
    }

    private void fragmentTransaction2(){
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.fragmentLayout, fragment2);
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
    }

    @Override
    public void onDetailFragmentInteraction(String uri) {
        Log.d("Test", "onDetailFragmentInteraction: GOt String uri " + uri);
    }
}
