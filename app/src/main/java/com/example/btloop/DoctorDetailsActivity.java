package com.example.btloop;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;

public class DoctorDetailsActivity extends AppCompatActivity {
    public String[][] doctor_details1 =
            {
                    {"Bác sĩ : Bác sĩ A", "Địa chỉ bệnh viện : Bệnh viện Việt Đức", "Kinh nghiệm : 10 năm", "Số điện thoại: 123456789", "100000"},
                    {"Bác sĩ : Bác sĩ B", "Địa chỉ bệnh viện : Bệnh viện Y Hà Nội", "Kinh nghiệm : 8 năm", "Số điện thoại: 987654321", "900000"},
                    {"Bác sĩ : Bác sĩ C", "Địa chỉ bệnh viện : Bệnh viện Cầu Giấy", "Kinh nghiệm : 15 năm", "Số điện thoại: 555555555", "120000"}
            };

    public String[][] doctor_details2 =
            {
                    {"Bác sĩ : Bác sĩ A", "Địa chỉ bệnh viện : Bệnh viện Việt Đức", "Kinh nghiệm : 10 năm", "Số điện thoại: 123456789", "100000"},
                    {"Bác sĩ : Bác sĩ B", "Địa chỉ bệnh viện : Bệnh viện Y Hà Nội", "Kinh nghiệm : 8 năm", "Số điện thoại: 987654321", "900000"},
                    {"Bác sĩ : Bác sĩ C", "Địa chỉ bệnh viện : Bệnh viện Cầu Giấy", "Kinh nghiệm : 15 năm", "Số điện thoại: 555555555", "120000"}
            };

    public String[][] doctor_details3 =
            {
                    {"Bác sĩ : Bác sĩ A", "Địa chỉ bệnh viện : Bệnh viện Việt Đức", "Kinh nghiệm : 10 năm", "Số điện thoại: 123456789", "100000"},
                    {"Bác sĩ : Bác sĩ B", "Địa chỉ bệnh viện : Bệnh viện Y Hà Nội", "Kinh nghiệm : 8 năm", "Số điện thoại: 987654321", "900000"},
                    {"Bác sĩ : Bác sĩ C", "Địa chỉ bệnh viện : Bệnh viện Cầu Giấy", "Kinh nghiệm : 15 năm", "Số điện thoại: 555555555", "120000"}
            };

    TextView tv;
    Button btn;
    String[][] doctor_details = {};
    ArrayList list;
    SimpleAdapter sa;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doctor_details);

        tv = findViewById(R.id.textViewCartPackageName);
        btn = findViewById(R.id.buttonLDBack);
        Intent it = getIntent();
        String title = it.getStringExtra("title");
        tv.setText(title);

        if (title.compareTo("Gói trị liệu gia đình") == 0) {
            doctor_details = doctor_details1;
        }
        else if (title.compareTo("Dietician") == 0) {
            doctor_details = doctor_details2;
        }
        else {
            doctor_details = doctor_details3;
        }

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(DoctorDetailsActivity.this, FindDoctorActivity.class));
            }
        });

        list = new ArrayList();
        for (int i = 0; i< doctor_details.length;i++) {
            HashMap<String,String> item = new HashMap<String, String>();
            item.put("line1", doctor_details[i][0]);
            item.put("line2", doctor_details[i][1]);
            item.put("line3", doctor_details[i][2]);
            item.put("line4", doctor_details[i][3]);
            item.put("line5", "Cons Fees:"+doctor_details[i][4]+"/-");
            list.add(item);
        }
        sa = new SimpleAdapter(this,list,
                R.layout.multi_lines,
                new String[]{"line1","line2","line3", "line4", "line5"},
                new int[]{R.id.line_a, R.id.line_b, R.id.line_c}
            );
        ListView lst = findViewById(R.id.listViewLT);
        lst.setAdapter(sa);

        lst.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent it = new Intent(DoctorDetailsActivity.this, BookAppointmentActivity.class);
                it.putExtra("text1", title);
                it.putExtra("text2", doctor_details[i][0]);
                it.putExtra("text3", doctor_details[i][1]);
                it.putExtra("text4", doctor_details[i][3]);
                it.putExtra("text5", doctor_details[i][4]);
                startActivity(it);
            }
        });
    }
}