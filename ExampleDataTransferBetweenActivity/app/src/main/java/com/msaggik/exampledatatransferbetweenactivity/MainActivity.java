package com.msaggik.exampledatatransferbetweenactivity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    // определение полей
    private EditText nameIn; // поле имени
    private EditText addressIn; // поле адреса
    private EditText emailIn; // поле электронного адреса
    private Button button; // поле кнопки

    private String name; // поле хранения имени
    private String address; // поле хранения адреса
    private String email; // поле хранения электронного адреса

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // привязка id к полям
        nameIn = findViewById(R.id.nameIn);
        addressIn = findViewById(R.id.addressIn);
        emailIn = findViewById(R.id.emailIn);
        button = findViewById(R.id.button);

        // обработка нажатия кнопки
        button.setOnClickListener(listener);
    }

    // создание слушателя
    private View.OnClickListener listener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            // переключение на другой экран и передача данных

            // ситывание данных с экрана
            name = nameIn.getText().toString();
            address = addressIn.getText().toString();
            email = emailIn.getText().toString();

            // создание намерения
            Intent intent = new Intent(getApplicationContext(), SecondActivity.class);

            // запаковка данных в контейнер намерения
            intent.putExtra("name", name);
            intent.putExtra("address", address);
            intent.putExtra("email", email);

            // старт переключения активити и передачи данных
            startActivity(intent);
        }
    };
}