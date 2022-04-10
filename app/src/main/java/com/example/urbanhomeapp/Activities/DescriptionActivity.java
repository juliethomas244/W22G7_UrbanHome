package com.example.urbanhomeapp.Activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.urbanhomeapp.Daos.CartDao;
import com.example.urbanhomeapp.Database.CartDatabase;
import com.example.urbanhomeapp.model.LocalStorage;
import com.example.urbanhomeapp.R;
import com.example.urbanhomeapp.model.CartItem;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

public class DescriptionActivity extends AppCompatActivity {
    ImageView imgViewLarge;
    TextView txtViewDesc;
    TextView txtViewPrice;
    ImageView imgViewBack;
    LocalStorage localStorage;
    Context context;
    Gson gson;
    List<CartItem> itemsList = new ArrayList<>();
    Button btnAddtocart;
    Button btnBuyNow;
    private CartDao cartDao;
    boolean nameExist = false;
    Toast curToast = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_description);

        imgViewLarge = findViewById(R.id.imgViewLarge);
        txtViewDesc = findViewById(R.id.txtViewDesc);
        txtViewPrice = findViewById(R.id.txtViewPrice);
        imgViewBack = findViewById(R.id.imgViewBack);
        btnAddtocart = findViewById(R.id.btnCart);
        btnBuyNow = findViewById(R.id.btnBuy);

        Bundle bundle = getIntent().getExtras();
        int idx = getIntent().getExtras().getInt("IDX", -1);


        imgViewBack.setOnClickListener((View view) -> {
            startActivity(new Intent(DescriptionActivity.this, HomeActivity.class));
        });

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

                case 11:
                    imgViewLarge.setImageResource(R.drawable.dhpvictoria);
                    txtViewDesc.setText("• FSC ®-certified solid oak and engineered hardwood\n" +
                            "• Wirebrush and low-sheen finish\n" +
                            "• Handwoven abaca sea grass");
                    txtViewPrice.setText("$75");
                    break;
                case 12:
                    imgViewLarge.setImageResource(R.drawable.genuineleather);
                    txtViewDesc.setText("• Slat support system makes box spring optional\n" +
                            "• Mattresses and optional bunky board available (sold separately)\n" +
                            "• Solid oak, oak veneer, and engineered hardwood");
                    txtViewPrice.setText("$82");
                    break;
                case 13:
                    imgViewLarge.setImageResource(R.drawable.mercerwulff);
                    txtViewDesc.setText("• Medium wirebrush and natural oak finish\n" +
                            "• Poly-cotton upholstery with leather trim\n" +
                            "• Polyurethane foam fill");
                    txtViewPrice.setText("$75");
                    break;
                case 14:
                    imgViewLarge.setImageResource(R.drawable.modwayollie);
                    txtViewDesc.setText("• Traditional joinery detail on headboard\n" +
                            "• Slat support system makes box spring optional\n" +
                            "• Mattresses and optional bunky board available (sold separately)");
                    txtViewPrice.setText("$63");
                    break;
                case 15:
                    imgViewLarge.setImageResource(R.drawable.sandroasher);
                    txtViewDesc.setText("• Compatible with Maren Olive Beds\n" +
                            "• 100% poplar\n" +
                            "• Features caster wheels");
                    txtViewPrice.setText("$85");
                    break;
                case 16:
                    imgViewLarge.setImageResource(R.drawable.zinusjoseph);
                    txtViewDesc.setText("• Bed sold separately\n" +
                            "• 100% polyester fabric\n" +
                            "• Foam and polyester fiber fill");
                    txtViewPrice.setText("$73");
                    break;

                case 21:
                    imgViewLarge.setImageResource(R.drawable.renaychair);
                    txtViewDesc.setText("• Solid wood and engineered wood\n" +
                            "• Polyester velvet upholstery\n" +
                            "• Foam cushioning");
                    txtViewPrice.setText("$35");
                    break;
                case 22:
                    imgViewLarge.setImageResource(R.drawable.lolliechair);
                    txtViewDesc.setText("• Frame is benchmade with solid ash with a natural ash finish\n" +
                            "• Top-grain, full-aniline leather\n" +
                            "• Synthetic webbing suspension system");
                    txtViewPrice.setText("$32");
                    break;
                case 23:
                    imgViewLarge.setImageResource(R.drawable.denchevlounge);
                    txtViewDesc.setText("• Soy-based polyfoam and fiber tight seat and back cushions\n" +
                            "• Each piece exhibits the unique markings of natural leather\n" +
                            "• Contract grade tested for commercial spaces");
                    txtViewPrice.setText("$41");
                    break;
                case 24:
                    imgViewLarge.setImageResource(R.drawable.wingbackchair);
                    txtViewDesc.setText("• Frame is benchmade with precision-cut solid ash with grey wash finish, hardwood plywood, and a cane seat\n" +
                            "• Synthetic webbing suspension system\n" +
                            "• Soy-based polyfoam cushion with fiber encased in downproof ticking");
                    txtViewPrice.setText("$30");
                    break;
                case 25:
                    imgViewLarge.setImageResource(R.drawable.louisechair);
                    txtViewDesc.setText("• Frame stained with grey wash finish and clear protective lacquer\n" +
                            "• Fade- and mildew-resistant solution-dyed Sunbrella ® acrylic\n" +
                            "• Fiber-foam cushion fill");
                    txtViewPrice.setText("$35");
                    break;
                case 26:
                    imgViewLarge.setImageResource(R.drawable.sofalazy);
                    txtViewDesc.setText("• Cushions have ventilation zippers\n" +
                            "• Frame is solid and engineered wood\n" +
                            "• Synthetic webbing suspension system");
                    txtViewPrice.setText("$29");
                    break;

                case 31:
                    imgViewLarge.setImageResource(R.drawable.hampton);
                    txtViewDesc.setText("• Cut and welded natural dark steel with millscale finish at corners\n" +
                            "• Clear powdercoat finish on base\n" +
                            "• Polished Italian Carrara marble top over honeycomb aluminum core to reduce weight and limit cracking");
                    txtViewPrice.setText("$40");
                    break;
                case 32:
                    imgViewLarge.setImageResource(R.drawable.endtable);
                    txtViewDesc.setText("• Slight tolerance for fit to base is characteristic of the marble\n" +
                            "• Plastic glides on feet protect floor\n" +
                            "• Low emission engineered wood and solid beech wood legs");
                    txtViewPrice.setText("$52");
                    break;
                case 33:
                    imgViewLarge.setImageResource(R.drawable.abs);
                    txtViewDesc.setText("• Includes oval table top with 30\" height legs\n" +
                            "• Perfect height to accommodate our desk chairs or to use as a standing craft station\n" +
                            "• Optional paper roll holder available (not included)");
                    txtViewPrice.setText("$55");
                    break;
                case 34:
                    imgViewLarge.setImageResource(R.drawable.griffin);
                    txtViewDesc.setText("• Medium-density fiberboard with oak veneer\n" +
                            "• Extruded polystyrene with UV and anti-oxidant protection\n" +
                            "• Aluminum frame with powdercoat finish");
                    txtViewPrice.setText("$43");
                    break;
                case 35:
                    imgViewLarge.setImageResource(R.drawable.laurel);
                    txtViewDesc.setText("• Raw-edge solid acacia wood with butterfly joints\n" +
                            "• Grey tint, acrylic sealer, topcoat and clear wax finish\n" +
                            "• Steel base with matte antique black finish");
                    txtViewPrice.setText("$55");
                    break;
                case 36:
                    imgViewLarge.setImageResource(R.drawable.everly);
                    txtViewDesc.setText("• Oak, plywood and engineered wood with heavy wire brushing and clear topcoat\n" +
                            "• Travertine marble with clear matte resin coating\n" +
                            "• Due to the characteristics of natural stone, each top will vary slightly in color and veining");
                    txtViewPrice.setText("$63");
                    break;
            }
        } catch (Exception ex){
            ex.printStackTrace();

        }

        CartDatabase database = Room.databaseBuilder(getApplicationContext(), CartDatabase.class,
                "cart_db").fallbackToDestructiveMigration().allowMainThreadQueries().build();
        cartDao = database.cartDao();

        btnAddtocart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                String StrID = String.valueOf(idx);
//                Cart cart = new Cart(StrID, "abcd","abcd", "$", "100", "random attribute", "10", "1000");
//                //cartList = ((HomeActivity) context).getCartList();
//                cartList = ((HomeActivity) context).getCartList();
//                cartList.add(cart);
//                String cartStr = gson.toJson(cartList);
//                //Log.d("CART", cartStr);
//                localStorage.setCart(cartStr);
//                ((AddorRemoveCallbacks) context).onAddProduct();

                itemsList = database.cartDao().getAllCartItems();
                CartItem cart = new CartItem();
                cart.setName(getIntent().getExtras().getString("NAME", "error"));
                cart.setQuantity(1);
                cart.setPrice(Double.parseDouble(txtViewPrice.getText().toString().substring(1)));

                for (int i=0; i<itemsList.size(); i++){
                    if (itemsList.get(i).getName().equals(cart.getName())){
                        nameExist = true;
                        break;
                    }
                }

                if (!nameExist){
                    if (curToast != null){
                        curToast.cancel();
                    }
                    cartDao.insertItem(cart);
                    curToast = Toast.makeText(getApplicationContext(), "Added to cart", Toast.LENGTH_SHORT);
                    curToast.show();
                }else{
                    if (curToast != null){
                        curToast.cancel();
                    }
                    curToast = Toast.makeText(getApplicationContext(), "This item is already in the cart.", Toast.LENGTH_SHORT);
                    curToast.show();
                }
            }
        });

        btnBuyNow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent checkoutResult = new Intent(DescriptionActivity.this, CheckoutActivity.class);
                Bundle bundle = new Bundle();
                bundle.putDouble("ITEMPRICE", Double.parseDouble(txtViewPrice.getText().toString().substring(1)));
                bundle.putDouble("ITEMQTT", 1);
                checkoutResult.putExtras(bundle);
                startActivity(checkoutResult);

            }
        });

    }
}