package edu.rupp.ckcc.fragment_demo;

import android.content.res.Resources;
import android.support.annotation.IdRes;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.content.res.ResourcesCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;

public class TabActivity extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener{


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tab);
        BottomNavigationView bottomNavigationView=findViewById(R.id.buttonNavigationview);
        bottomNavigationView.setOnNavigationItemSelectedListener(this);

        //Add home fragment to Activity
        HomeFragment homeFragment=new HomeFragment();

        FragmentManager fragmentManager=getSupportFragmentManager();
        FragmentTransaction transaction=fragmentManager.beginTransaction();
        transaction.replace(R.id.container,homeFragment);
        transaction.commit();




    }
    //Event on bottom navigation view
    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        if(item.getItemId()==R.id.home){
            HomeFragment homeFragment=new HomeFragment();
            ChangeFragment(R.id.container2,homeFragment);
        }
        else if(item.getItemId()==R.id.profile){
            ProfileFragment profileFragment=new ProfileFragment();
            ChangeFragment(R.id.container,profileFragment);
        }
        else {
            SettingFragment settingFragment=new SettingFragment();
            ChangeFragment(R.id.container,settingFragment);
        }
        return true;
    }
    private void ChangeFragment(@IdRes int containerid, Fragment fragment){
       FragmentManager  fragmentManager=getSupportFragmentManager();
        FragmentTransaction transaction=fragmentManager.beginTransaction();
        transaction.replace(containerid,fragment);
        transaction.commit();
    }

}
