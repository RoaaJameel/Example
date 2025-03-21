package com.example.example;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    private Button btnSearch;
    private TextView txtResult;
    private Spinner spnBooks;
// comment
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        // build the hooks
        btnSearch= findViewById(R.id.btnSearch);
        txtResult= findViewById(R.id.txtResult);
        spnBooks= findViewById(R.id.spnBooks);
        btnSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String cat = (String )spnBooks.getSelectedItem();
               Database dp = new Database();
                List<Book> result= dp.getBooks(cat);
                String str= " ";
                for (Book b:result ) {
                    str+= b.getTitle()+ "/n";
                    txtResult.setText(str);
                }

            }
        });
    }
}