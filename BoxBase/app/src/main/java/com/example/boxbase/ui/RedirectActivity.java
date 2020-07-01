package com.example.boxbase.ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import com.example.boxbase.R;

public class RedirectActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_redirect_package);
        LinearLayout delivery_to_redirect = findViewById(R.id.delivery_to_redirect);
        TextView delivery_sender = findViewById(R.id.delivery_sender);
        TextView delivery_destination = findViewById(R.id.delivery_destination);
        TextView delivery_status = findViewById(R.id.delivery_status);
        ImageView delivery_status_image = findViewById(R.id.delivery_status_icon);
        ImageView arrow_to_open_box = findViewById(R.id.arrow_to_open_box);

        //location_selection_mobile_delivery_base
        ImageView arrow_to_close_mdb_box = findViewById(R.id.arrow_to_close_mdb_box);
        ImageView arrow_to_open_mdb_box = findViewById(R.id.arrow_to_open_mdb_box);
        ConstraintLayout cl_selection_mobile_delivery_base = findViewById(R.id.cl_selection_mobile_delivery_base);
        arrow_to_close_mdb_box.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cl_selection_mobile_delivery_base.setVisibility(View.GONE);
                arrow_to_close_mdb_box.setVisibility(View.INVISIBLE);
                arrow_to_open_mdb_box.setVisibility(View.VISIBLE);
            }
        });
        arrow_to_open_mdb_box.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cl_selection_mobile_delivery_base.setVisibility(View.VISIBLE);
                arrow_to_close_mdb_box.setVisibility(View.VISIBLE);
                arrow_to_open_mdb_box.setVisibility(View.INVISIBLE);
            }
        });


        Intent intent = getIntent();
        delivery_sender.setText(intent.getStringExtra("sender"));
        delivery_destination.setText(intent.getStringExtra("destination"));
        delivery_status.setText(intent.getStringExtra("status"));
        delivery_status_image.setImageDrawable(RedirectActivity.this.getResources().getDrawable(intent.getIntExtra("statusImage", 0)));
        arrow_to_open_box.setVisibility(View.INVISIBLE);

    }

}