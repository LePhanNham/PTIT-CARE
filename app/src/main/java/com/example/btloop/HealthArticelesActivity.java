package com.example.btloop;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.HashMap;

public class HealthArticelesActivity extends AppCompatActivity {
    private String[][] heatlh_details = {
            {"Đi bộ hàng ngày", "", "", "", "Xem Chi Tiết"},
            {"Chăm sóc tại nhà khi mắc COVID-19", "", "", "", "Xem Chi Tiết"},
            {"Dừng hút thuốc", "", "", "", "Xem Chi Tiết"},
            {"Đau kinh", "", "", "", "Xem Chi Tiết"},
            {"Duy trì sức khỏe của đường ruột", "", "", "", "Xem Chi Tiết"}
    };

    private int[] images = {
            R.drawable.health1,
            R.drawable.health2,
            R.drawable.health3,
            R.drawable.health4,
            R.drawable.health5,
    };
    HashMap<String, String> item;
    ArrayList list;
    SimpleAdapter sa;

    Button btnBack;
    ListView lst;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_health_articeles);

        lst = findViewById(R.id.listViewHA);
        btnBack= findViewById(R.id.buttonHABack);

        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(HealthArticelesActivity.this, HomeActivity.class));
            }
        });

        list = new ArrayList();
        for (int i =0; i <heatlh_details.length; i++) {
            item = new HashMap<>();
            item.put("line1", heatlh_details[i][0]);
            item.put("line2", heatlh_details[i][1]);
            item.put("line3", heatlh_details[i][2]);
            item.put("line4", heatlh_details[i][3]);
            item.put("line5", heatlh_details[i][4]);
            list.add(item);
        }

        sa = new SimpleAdapter(this, list,
                R.layout.multi_lines,
                new String[] {"line1", "line2","line3","line4","line5"},
                new int[] {R.id.line_a, R.id.line_b, R.id.line_c, R.id.line_d, R.id.line_e});
        lst.setAdapter(sa);

        lst.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int i, long l) {
                Intent it = new Intent(HealthArticelesActivity.this, HealthArticelesDetailsActivity.class);
                it.putExtra("text1", heatlh_details[i][0]);
                it.putExtra("text2", images[i]);
                startActivity(it);
            }
        });
    }
}