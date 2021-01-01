package com.example.challengefragmentsrecyclerview;

import android.app.Application;

import java.util.ArrayList;

public class ApplicationClass extends Application
{
    public static ArrayList<Car> cars;

    @Override
    public void onCreate() {
        super.onCreate();

        cars = new ArrayList<Car>();
        cars.add(new Car("Chuck Norris", "312321562", R.mipmap.volkswagen_foreground, "Polo"));
        cars.add(new Car("Peter Pollock", "534543645", R.mipmap.mercedes_foreground, "E200"));
        cars.add(new Car("Chris James", "1234678989", R.mipmap.nissan_foreground, "Almera"));
        cars.add(new Car("John Rambo", "985676573", R.mipmap.mercedes_foreground, "E180"));
        cars.add(new Car("Chuck Norris", "312321562", R.mipmap.volkswagen_foreground, "Polo"));
        cars.add(new Car("Peter Pollock", "534543645", R.mipmap.mercedes_foreground, "E200"));
        cars.add(new Car("Chris James", "1234678989", R.mipmap.nissan_foreground, "Almera"));
        cars.add(new Car("John Rambo", "985676573", R.mipmap.mercedes_foreground, "E180"));
        cars.add(new Car("Chuck Norris", "312321562", R.mipmap.volkswagen_foreground, "Polo"));
        cars.add(new Car("Peter Pollock", "534543645", R.mipmap.mercedes_foreground, "E200"));
        cars.add(new Car("Chris James", "1234678989", R.mipmap.nissan_foreground, "Almera"));
        cars.add(new Car("John Rambo", "985676573", R.mipmap.mercedes_foreground, "E180"));
    }
}
