package ru.wolfnord.fragmentsstudy;

import android.os.Bundle;
import android.view.View;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import ru.wolfnord.fragmentsstudy.databinding.ActivityMain2Binding;

public class MainActivity2 extends AppCompatActivity implements View.OnClickListener {

    ActivityMain2Binding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMain2Binding.inflate(getLayoutInflater());
        EdgeToEdge.enable(this);
        setContentView(binding.getRoot());
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        FirstFragment fragment = new FirstFragment();
        fragmentTransaction.replace(R.id.fragment_box, fragment, "Fragment 2");
        fragmentTransaction.commit();
        binding.button1.setOnClickListener(this);
        binding.button2.setOnClickListener(this);
        binding.button3.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        if (v.getId() == R.id.button1) {
            FirstFragment fragment = new FirstFragment();
            fragmentTransaction.replace(R.id.fragment_box, fragment, "Fragment 2");
            fragmentTransaction.commit();
        }
        else if (v.getId() == R.id.button2) {
            SecondFragment fragment = new SecondFragment();
            fragmentTransaction.replace(R.id.fragment_box, fragment, "Fragment 2");
            fragmentTransaction.commit();
        }
        else if (v.getId() == R.id.button3) {
            ThirdFragment fragment = new ThirdFragment();
            fragmentTransaction.replace(R.id.fragment_box, fragment, "Fragment 2");
            fragmentTransaction.commit();
        }
    }
}