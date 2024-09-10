package com.joao.syncinterface;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

public class MainActivity extends AppCompatActivity {

    private LikesViewModel viewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EditText editTextNome = findViewById(R.id.editTextNome);
        EditText editTextSobrenome = findViewById(R.id.editTextSobrenome);
        ImageView imageViewLikes = findViewById(R.id.imageViewLikes);
        Button buttonLike = findViewById(R.id.buttonLike);
        ProgressBar progressBar = findViewById(R.id.progressBar);

        viewModel = new ViewModelProvider(this).get(LikesViewModel.class);

        viewModel.getNome().observe(this, nome -> {
            editTextNome.setText(nome);
        });

        viewModel.getSobrenome().observe(this, sobrenome -> {
            editTextSobrenome.setText(sobrenome);
        });

        viewModel.getLikes().observe(this, likes -> {
            progressBar.setProgress(likes);
        });

        viewModel.getImagemLikes().observe(this, resId -> {
            imageViewLikes.setImageResource(resId);
        });

        buttonLike.setOnClickListener(v -> {
            viewModel.darLike();
        });
    }
}
