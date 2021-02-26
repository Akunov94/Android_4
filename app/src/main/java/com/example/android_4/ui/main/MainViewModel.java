package com.example.android_4.ui.main;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class MainViewModel extends ViewModel {
    public MutableLiveData<String> nameData = new MutableLiveData<>();

    public void getName() {
        nameData.setValue("Kutman Akunov");

    }
    public void getName2() {
        nameData.setValue("Kutman Akunov 94");
    }
}
