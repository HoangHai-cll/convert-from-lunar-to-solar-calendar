package com.example.bmi; // Nhớ đổi đúng tên package của bạn

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class doilich extends AppCompatActivity {

    EditText edtDay, edtMonth, edtYear;
    Button btnToLunar, btnToSolar;
    TextView txtResultConvert;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doilich);

        edtDay = findViewById(R.id.edtDay);
        edtMonth = findViewById(R.id.edtMonth);
        edtYear = findViewById(R.id.edtYear);
        btnToLunar = findViewById(R.id.btnToLunar);
        btnToSolar = findViewById(R.id.btnToSolar);
        txtResultConvert = findViewById(R.id.txtResultConvert);

        // Nút chuyển từ Dương sang Âm
        btnToLunar.setOnClickListener(v -> {
            thucHienChuyenDoi(true);
        });

        // Nút chuyển từ Âm sang Dương
        btnToSolar.setOnClickListener(v -> {
            thucHienChuyenDoi(false);
        });
    }

    private void thucHienChuyenDoi(boolean laDuongSangAm) {
        // 1. Lấy dữ liệu từ ô nhập
        String ngayStr = edtDay.getText().toString();
        String thangStr = edtMonth.getText().toString();
        String namStr = edtYear.getText().toString();

        // 2. Kiểm tra trống
        if (ngayStr.isEmpty() || thangStr.isEmpty() || namStr.isEmpty()) {
            txtResultConvert.setText("Vui lòng nhập đủ thông tin!");
            return;
        }

        // 3. Chuyển sang kiểu số để tính toán
        int d = Integer.parseInt(ngayStr);
        int m = Integer.parseInt(thangStr);
        int y = Integer.parseInt(namStr);

        // 4. Gọi hàm từ Class LunarCalendar
        if (laDuongSangAm) {
            // ĐÂY LÀ DÒNG QUAN TRỌNG NHẤT
            String ketQua = LunarCalendar.convertSolarToLunar(d, m, y);
            txtResultConvert.setText(ketQua);
        } else {
            txtResultConvert.setText("Tính năng Âm -> Dương đang cập nhật...");
        }
    }
}