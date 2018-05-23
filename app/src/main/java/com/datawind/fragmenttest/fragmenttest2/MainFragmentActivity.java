package com.datawind.fragmenttest.fragmenttest2;

import android.app.FragmentManager;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.FrameLayout;

import com.datawind.fragmenttest.R;

import static android.content.res.Configuration.ORIENTATION_LANDSCAPE;

public class MainFragmentActivity extends AppCompatActivity implements FragmentOne.OnTopicSelectedListener {

    private String TAG = "tst_MainFragAct";

    FrameLayout frameLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_fragment);

        int orientation = getResources().getConfiguration().orientation;

        FragmentOne fragOne = new FragmentOne();
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.mainframe, fragOne);
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();

        if(orientation ==  ORIENTATION_LANDSCAPE){

            FragmentTransaction fragmentTransaction2 = getSupportFragmentManager().beginTransaction();
            FragmentDetails fragDetails = new FragmentDetails();
            fragmentTransaction2.replace(R.id.framedetails, fragDetails);
            fragmentTransaction2.addToBackStack(null);
            fragmentTransaction2.commit();
        }

        //frameLayout = findViewById(R.id.mainframe);
    }

    @Override
    public void onArticleSelected(int position) {
        Log.d(TAG, "****onArticleSelected: position: " + position);

//        FragmentDetails fragDetails = new FragmentDetails();
//        //details.setArguments(getIntent().getExtras());
//
//        FragmentManager fragmentManager = getFragmentManager();
//        android.app.FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
//        fragmentTransaction.add(R.id.headlines_fragment, fragDetails);
//        fragmentTransaction.commit();
        int orientation = getResources().getConfiguration().orientation;

        if(orientation ==  ORIENTATION_LANDSCAPE) {
            FragmentDetails fragDetails = new FragmentDetails();
            Bundle bundle = new Bundle();
            bundle.putInt("position", position);
            fragDetails.setArguments(bundle);

            FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
            fragmentTransaction.replace(R.id.framedetails, fragDetails);
            fragmentTransaction.addToBackStack(null);
            fragmentTransaction.commit();
        } else {
            FragmentDetails fragDetails = new FragmentDetails();
            Bundle bundle = new Bundle();
            bundle.putInt("position", position);
            fragDetails.setArguments(bundle);

            FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
            fragmentTransaction.replace(R.id.mainframe, fragDetails);
            fragmentTransaction.addToBackStack(null);
            fragmentTransaction.commit();
        }

//        FragmentDetails fragDetails = (FragmentDetails)
//                getSupportFragmentManager().findFragmentById(R.id.mainframe);
//
//        if (fragDetails != null) {
////            // If article frag is available, we're in two-pane layout...
////
////            // Call a method in the ArticleFragment to update its content
//            fragDetails.updateDetails(position);
//        } else {
////            // Otherwise, we're in the one-pane layout and must swap frags...
////
////            // Create fragment and give it an argument for the selected article
////            ArticleFragment newFragment = new ArticleFragment();
////            Bundle args = new Bundle();
////            args.putInt(ArticleFragment.ARG_POSITION, position);
////            newFragment.setArguments(args);
////
////            FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
////
////            // Replace whatever is in the fragment_container view with this fragment,
////            // and add the transaction to the back stack so the user can navigate back
////            transaction.replace(R.id.fragment_container, newFragment);
////            transaction.addToBackStack(null);
////
////            // Commit the transaction
////            transaction.commit();
//        }

    }
}
