package com.example.androidbottonnavigation;

import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.FrameLayout;

public class MainActivity extends AppCompatActivity {

    private BottomNavigationView mMainNav;
    private FrameLayout mMainFrame;

    private HomeFragment homeFragment;
    private NotificationFragment notificationFragment;
    private AccountFragment accountFragment;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        mMainFrame=(FrameLayout) findViewById(R.id.main_frame);
        mMainNav=(BottomNavigationView)findViewById(R.id.main_nav);


        homeFragment=new HomeFragment();
        notificationFragment=new NotificationFragment();
        accountFragment=new AccountFragment();

        setFragment(homeFragment);

        mMainNav.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {




            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {

                switch (menuItem.getItemId())
                {
                    case R.id.nav_home :mMainNav.setItemBackgroundResource(R.color.colorPrimary);
                    setFragment(homeFragment);
                    return true;
                    case R.id.nav_notif: mMainNav.setItemBackgroundResource(R.color.colorPrimaryDark);
                        setFragment(notificationFragment);
                    return true;
                    case R.id.nav_account: mMainNav.setItemBackgroundResource(R.color.colorAccent);
                        setFragment(accountFragment);
                    return true;
                    default:return false;

                }



            }


        });
    }
        private void setFragment(Fragment fragment) {
            FragmentTransaction fragmentTransaction=getSupportFragmentManager().beginTransaction();
            fragmentTransaction.replace(R.id.main_frame,fragment);
            fragmentTransaction.commit();
        }



}
