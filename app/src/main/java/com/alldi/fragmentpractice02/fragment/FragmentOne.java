package com.alldi.fragmentpractice02.fragment;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.alldi.fragmentpractice02.MainActivity;
import com.alldi.fragmentpractice02.R;
import com.alldi.fragmentpractice02.databinding.FragmentOneBinding;

public class FragmentOne extends Fragment {

    FragmentOneBinding binding;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_one, container, false);
        return binding.getRoot();
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        binding.myTextView.setText("데이터 바인딩 성공");
        binding.okBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String title = binding.titleEdt.getText().toString();
                ((MainActivity) getActivity()).setCustomTitle(title);
            }
        });

    }

    public void changeTextMsg(String inputMessage){
        binding.myTextView.setText(inputMessage);
    }
}
