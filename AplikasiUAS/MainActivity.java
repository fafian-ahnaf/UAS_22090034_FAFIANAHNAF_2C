package com.example.aplikasiuas;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.RecyclerView;

import android.os.AsyncTask;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.aplikasiuas.model.Model;
import com.example.aplikasiuas.network.ConnectURI;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;


public class MainActivity extends AppCompatActivity {
    List<Model> model;
    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        try {
            ConnectURI koneksisaya = new ConnectURI();
            URL myAddress = koneksisaya.buildURL("https://dummyjson.com/products/category/smartphones");
            String response = koneksisaya.getResponseFromHttpUrl(myAddress);

            JSONObject jsonArray = new JSONObject(response.toString());
            ArrayList<Model> responseModel = new ArrayList<>();
            JSONArray product = jsonArray.getJSONArray("products");
            for (int i = 0; i < product.length(); i++) {
                Model model = new Model();
                JSONObject myJSONObject = product.getJSONObject(i);
                model.setId(myJSONObject.getInt("id"));
                model.setTittle(myJSONObject.getString("title"));
                model.setDescription(myJSONObject.getString("description"));
                model.setPrice(myJSONObject.getInt("price"));
                model.setDiscount(myJSONObject.getString("discountPercentage"));
                model.setRating(myJSONObject.getString("rating"));
                model.setStock(myJSONObject.getInt("stock"));
                model.setBrand(myJSONObject.getString("brand"));
                model.setCategory(myJSONObject.getString("category"));
                responseModel.add(model);
            }
            TextView titleProduct = findViewById(R.id.nama);
            TextView priceProduct = findViewById(R.id.price);
            ImageView imgProduct = findViewById(R.id.img);
            for (int index = 0; index < responseModel.size(); index++){
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (JSONException e) {
            throw new RuntimeException(e);
        }


    }

}
