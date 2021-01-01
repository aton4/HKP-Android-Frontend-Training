package com.example.challengefragmentsrecyclerview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements CarAdapter.ItemClicked {
    FragmentManager fragmentManager;
    Fragment ma_listFragment, ma_buttonsFragment, ma_carInfoFragment, ma_ownerInfoFragment;

    ImageView ivFragCarMaker;
    TextView tvFragCarModel;

    TextView tvFragOwnerInfo;
    TextView tvFragOwner;
    TextView tvFragTel;

    Button btnCarInfo;
    Button btnOwnerInfo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fragmentManager = getSupportFragmentManager();
        ma_listFragment = fragmentManager.findFragmentById(R.id.ma_listFragment);
        ma_buttonsFragment = fragmentManager.findFragmentById(R.id.ma_buttonsFragment);
        ma_carInfoFragment = fragmentManager.findFragmentById(R.id.ma_carInfoFragment);
        ma_ownerInfoFragment = fragmentManager.findFragmentById(R.id.ma_ownerInfoFragment);

        ivFragCarMaker = findViewById(R.id.ivFragCarMaker);
        tvFragCarModel = findViewById(R.id.tvFragCarModel);
        tvFragOwnerInfo = findViewById(R.id.tvFragOwnerInfo);
        tvFragOwnerInfo.setText("Owner Information");
        tvFragOwner = findViewById(R.id.tvFragOwner);
        tvFragTel = findViewById(R.id.tvFragTel);

        fragmentManager.beginTransaction()
                .show(ma_listFragment)
                .show(ma_buttonsFragment)
                .show(ma_carInfoFragment)
                .hide(ma_ownerInfoFragment)
                .commit();

        btnCarInfo = findViewById(R.id.btnCarInfo);
        btnOwnerInfo = findViewById(R.id.btnOwnerInfo);

        btnCarInfo.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                fragmentManager.beginTransaction()
                        .show(ma_listFragment)
                        .show(ma_buttonsFragment)
                        .show(ma_carInfoFragment)
                        .hide(ma_ownerInfoFragment)
                        .commit();
            }
        });

        btnOwnerInfo.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                fragmentManager.beginTransaction()
                        .show(ma_listFragment)
                        .show(ma_buttonsFragment)
                        .hide(ma_carInfoFragment)
                        .show(ma_ownerInfoFragment)
                        .commit();
            }
        });

        onItemClicked(0);
    }

    @Override
    public void onItemClicked(int index)
    {
        ivFragCarMaker.setImageResource(ApplicationClass.cars.get(index).getMaker());
        tvFragCarModel.setText(ApplicationClass.cars.get(index).getModel());

        tvFragOwner.setText(ApplicationClass.cars.get(index).getOwner());
        tvFragTel.setText(ApplicationClass.cars.get(index).getOwnerTel());
    }
}