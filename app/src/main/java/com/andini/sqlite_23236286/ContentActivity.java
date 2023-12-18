package com.andini.sqlite_23236286;

import android.os.Bundle;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import com.andini.sqlite_23236286.databinding.ActivityRegisterBinding;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class ContentActivity extends AppCompatActivity {
    private ActivityRegisterBinding binding;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener =
            new BottomNavigationView.OnNavigationItemSelectedListener() {

                @Override
                public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                    Fragment fragment;
                    switch (item.getItemId()) {
                        case R.id.navigation_home:
                            fragment = new HomeFragment();
                            switchFragment(fragment);
                            return true;

                        case R.id.navigation_dashboard:
                            fragment = new DashboardFragment();
                            switchFragment(fragment);
                            return true;

                        case R.id.navigation_account:
                            fragment = new AccountFragment();
                            switchFragment(fragment);
                            return true;
                    }
                    return false;
                }
            };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityRegisterBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
        if (savedInstanceState == null) {
            binding.navigation.setSelectedItemId(R.id.navigation_home);
        }
    }

    private void switchFragment(Fragment fragment) {
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.container_layout, fragment, fragment.getClass().getSimpleName())
                .commit();
    }
}


