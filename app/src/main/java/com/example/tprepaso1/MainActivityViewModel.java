package com.example.tprepaso1;

import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class MainActivityViewModel extends ViewModel {

private MutableLiveData<Boolean> logeado;


    public LiveData<Boolean> getLogeo(){
        if(logeado==null){
            this.logeado=new MutableLiveData<>();
        }
        return logeado;
    }

    public void logear(String mail, String pass){
        if(mail.equals("luciano")&&pass.equals("123456")){
            Log.d("Salida", "ingresan");
           logeado.setValue(true);
        }else {
            logeado.setValue(false);
        }
    }

}
