package com.example.customlistviewexample;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ListView lvProducts;
    ArrayList<Product> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lvProducts = (ListView) findViewById(R.id.lvProducts);

        list = new ArrayList<Product>();

        Product product1 = new Product("Dell Latitude 3500",
                                        "The dell new laptiopn",
                                        "Laptop",
                                        14500.99,
                                        true);

        Product product2 = new Product("Acer Aspire 7",
                "revolution acer",
                "Laptop",
                12500.99,
                false);

        Product product3 = new Product("Sandisk",
                "cheap kiw cost",
                "Memory",
                299.99,
                false);

        Product product4 = new Product("Verbativk",
                "cdr",
                "HDD",
                399.99,
                false);

        list.add(product1);
        list.add(product2);
        list.add(product3);
        list.add(product4);

        ProductAdapter adapter = new ProductAdapter(this, list);

        lvProducts.setAdapter(adapter);
    }
}