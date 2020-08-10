package com.example.apkx.ui.home;

import androidx.lifecycle.ViewModelProviders;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.example.apkx.R;
import com.example.apkx.databinding.InnerHomeFragmentBinding;

public class InnerHomeFragment extends Fragment {

//    private InnerHomeViewModel mViewModel;
    InnerHomeFragmentBinding binding;

    Button buttonAdd;
    LinearLayout container_layout;
    EditText textIn, textOut;

    @Override
    public View onCreateView(final LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
//        return inflater.inflate(R.layout.inner_home_fragment, container, false);
        binding = InnerHomeFragmentBinding.inflate(getLayoutInflater());

        buttonAdd = binding.getRoot().findViewById(R.id.add);
        container_layout = binding.getRoot().findViewById(R.id.container_layout);
        textIn = binding.getRoot().findViewById(R.id.textin);

        buttonAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getContext(), textIn.getText().toString(), Toast.LENGTH_SHORT).show();

                LayoutInflater layoutInflater = ((LayoutInflater) getContext().getSystemService(Context
                        .LAYOUT_INFLATER_SERVICE));

                final View addView = layoutInflater.inflate(R.layout.row, null);

                textOut = (EditText) addView.findViewById(R.id.textout);
                textOut.setText(textIn.getText().toString());
                textIn.setText("");
                Button buttonRemove = (Button) addView.findViewById(R.id.remove);

                final View.OnClickListener thisListener = new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        ((LinearLayout) addView.getParent()).removeView(addView);
                    }
                };

                buttonRemove.setOnClickListener(thisListener);
                container_layout.addView(addView);
            }
        });

        return binding.getRoot();
    }

    // for the prevention of memory leak
    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding=null;
    }

}