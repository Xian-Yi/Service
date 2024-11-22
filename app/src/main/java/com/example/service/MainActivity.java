package com.example.service;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        Button button = findViewById(R.id.button); // 找到 Button 元件

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Button 點擊事件
                Intent intent = new Intent(MainActivity.this, MyService.class); // 創建一個 Intent，指定要啟動的 Service
                startService(intent); // 啟動 Service
                Toast.makeText(MainActivity.this, "啟動 Service", Toast.LENGTH_LONG).show(); // 顯示一個 Toast 提示訊息
                finish(); // 結束當前的 Activity
            }
        });

    }
}