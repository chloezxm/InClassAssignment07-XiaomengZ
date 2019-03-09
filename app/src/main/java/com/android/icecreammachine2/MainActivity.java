package com.android.icecreammachine2;

import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView iceCreamInfo;
    Button addIceCream;

    private String iceCreams = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        iceCreamInfo = findViewById(R.id.ice_cream_text);
        addIceCream = findViewById(R.id.add_ice_cream);
        addIceCream.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, AddIceCreamActivity.class);
                startActivityForResult(intent, RequestCodes.ADD_ICE_CREAM);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        if (requestCode == RequestCodes.ADD_ICE_CREAM && resultCode == RESULT_OK) {
            IceCream iceCream = (IceCream) data.getSerializableExtra(Keys.ICE_CREAM);
            iceCreams = iceCreams + iceCream.toString();
            iceCreamInfo.setText(iceCreams);
        }
    }
}
