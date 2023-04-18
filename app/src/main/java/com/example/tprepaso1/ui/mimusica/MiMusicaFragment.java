package com.example.tprepaso1.ui.mimusica;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.tprepaso1.databinding.FragmentHomeBinding;

public class MiMusicaFragment extends Fragment {

    private FragmentHomeBinding binding;
    private Intent intent;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        MiMusicaViewModel homeViewModel =
                new ViewModelProvider(this).get(MiMusicaViewModel.class);

        binding = FragmentHomeBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        binding.button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                 intent=new Intent(getActivity(),ServicioMusical.class);
                getActivity().startService(intent);
            }
        });

        return root;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        if (intent != null) {
            getActivity().stopService(intent);
        }
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }


}