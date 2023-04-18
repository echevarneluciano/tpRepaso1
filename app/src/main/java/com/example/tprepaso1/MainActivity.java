package com.example.tprepaso1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.content.Intent;
import android.os.Bundle;
import android.renderscript.ScriptGroup;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.example.tprepaso1.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding binding;
    private MainActivityViewModel mv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_main);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        mv= ViewModelProvider.AndroidViewModelFactory.getInstance(getApplication()).create(MainActivityViewModel.class);
        mv.getLogeo().observe(this, new Observer<Boolean>() {
            @Override
            public void onChanged(Boolean aBoolean) {
              if(aBoolean){
                  Log.d("Salida", aBoolean+"");
                  Toast toast = Toast.makeText( MainActivity.this,"Logeo exitoso",Toast.LENGTH_SHORT);
                  toast.show();
                  Intent intent=new Intent(MainActivity.this,MainActivityMenu.class );
                  startActivity(intent);
              }
            }
        });
        binding.buttonLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
             mv.logear(binding.editTextEmail.getText().toString(),binding.editTextPassword.getText().toString());
            }
        });

    }
}