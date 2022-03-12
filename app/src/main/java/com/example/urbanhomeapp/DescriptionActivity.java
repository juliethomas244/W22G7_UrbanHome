package com.example.urbanhomeapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.util.List;

public class DescriptionActivity extends AppCompatActivity {
    ImageView imgViewLarge;
    TextView txtViewDesc;
    TextView txtViewPrice;
    ImageView imgViewBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_description);

        imgViewLarge = findViewById(R.id.imgViewLarge);
        txtViewDesc = findViewById(R.id.txtViewDesc);
        txtViewPrice = findViewById(R.id.txtViewPrice);
        imgViewBack = findViewById(R.id.imgViewBack);

        imgViewBack.setOnClickListener((View view) -> {
            startActivity(new Intent(DescriptionActivity.this, HomeActivity.class));
        });
        Bundle bundle = getIntent().getExtras();
        int idx = getIntent().getExtras().getInt("IDX", -1);
        try {
            switch (idx){
                case 0:
                    imgViewLarge.setImageResource(R.drawable.icons_sofa);
                    txtViewDesc.setText("• Tight back cushion is high-resilience polyfoam topped with an extra layer of fiber\n" +
                            "• Self-welt detailing\n" +
                            "• Made in North Carolina, USA of domestic and imported materials");
                    txtViewPrice.setText("$75");
                    break;
                case 1:
                    imgViewLarge.setImageResource(R.drawable.icons_teapot);
                    txtViewDesc.setText("• Temperature options: 175°F, 185°F, 195°F, 200°F and 212°F\n" +
                            "• Steep time options: 1 to 5 minutes\n" +
                            "• Timer beeps when brew time is complete");
                    txtViewPrice.setText("$22");
                    break;
                case 2:
                    imgViewLarge.setImageResource(R.drawable.icons_wallshelf);
                    txtViewDesc.setText("• Walnut veneer wood shelves with walnut finish\n" +
                            "• Steel frames with black finish\n" +
                            "• Mounting hardware included");
                    txtViewPrice.setText("$45");
                    break;
                case 3:
                    imgViewLarge.setImageResource(R.drawable.icons_thinchair);
                    txtViewDesc.setText("• Weather-resistant high-density polyethylene\n" +
                            "• Stainless steel hardware\n" +
                            "• Protect from inclement weather");
                    txtViewPrice.setText("$33");
                    break;
            }
        } catch (Exception ex){
            ex.printStackTrace();

        }
    }
}