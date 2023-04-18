package com.example.tprepaso1.ui.mimusica;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class MiMusicaViewModel extends ViewModel {

    private final MutableLiveData<String> mText;

    public MiMusicaViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is home fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}