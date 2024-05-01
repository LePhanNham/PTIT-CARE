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

public class BuyMedicineActivity extends AppCompatActivity {
    private String[][] packages = {
            {"Thuốc sổ mũi", "", "", "", "50.000VNĐ"},
            {"Thuốc đau bụng", "", "", "", "305.000VNĐ"},
            {"Thuốc đau đầu", "", "", "", "448.000VNĐ"},
            {"Thuốc cảm cúm", "", "", "", "539.000VNĐ"},
            {"Thuốc nhỏ mắt", "", "", "", "30.000VNĐ"},
            {"Thuốc hắt hơi", "", "", "", "50.000VNĐ"},
            {"Thuốc hạ nhiệt", "", "", "", "40.000VNĐ"},
            {"Bình xịt mũi", "", "", "", "30.000VNĐ"},
            {"Lọ hạ nhiệt", "", "", "", "130.000VNĐ"},
    };

    private String[] packages_details = {
            "Tác dụng 1\n" + "Tác dụng 9\n",
            "Tác dụng 2\n" + "Tác dụng 8\n",
            "Tác dụng 3\n" + "Tác dụng 7\n",
            "Tác dụng 4\n" + "Tác dụng 6\n",
            "Tác dụng 5\n" + "Tác dụng 4\n",
            "Tác dụng 6\n" + "Tác dụng 5\n",
            "Tác dụng 7\n" + "Tác dụng 3\n",
            "Tác dụng 8\n" + "Tác dụng 2\n",
            "Tác dụng 9\n" + "Tác dụng 1\n",
    };


    HashMap<String, String> item;
    ArrayList list;
    SimpleAdapter sa;
    ListView lst;
    Button btnBack, btnGoToCart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buy_medicine);

        lst = findViewById(R.id.listViewBM);
        btnBack = findViewById(R.id.buttonBMBack);
        btnGoToCart = findViewById(R.id.buttonBMGoToCart);

        btnGoToCart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(BuyMedicineActivity.this, CartBuyMedicineActivity.class));
            }
        });

        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(BuyMedicineActivity.this, HomeActivity.class));
            }
        });

        list = new ArrayList<>();
        for (int i = 0; i< packages.length;i++) {
            item = new HashMap<String, String>();
            item.put("line1", packages[i][0]);
            item.put("line2", packages[i][1]);
            item.put("line3", packages[i][2]);
            item.put("line4", packages[i][3]);
            item.put("line5", "Total cost:" + packages[i][4] + "/-");
            list.add(item);
        }

        sa = new SimpleAdapter(this,list,
                R.layout.multi_lines,
                new String[]{"line1","line2","line3", "line4", "line5"},
                new int[]{R.id.line_a, R.id.line_b, R.id.line_c, R.id.line_d, R.id.line_e}
        );
        lst.setAdapter(sa);

        lst.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent it = new Intent(BuyMedicineActivity.this, BuyMedicineDetailsActivity.class);
                it.putExtra("text1", packages[i][0]);
                it.putExtra("text2", packages_details[i]);
                it.putExtra("text3", packages[i][4]);
                startActivity(it);
            }
        });
    }


}