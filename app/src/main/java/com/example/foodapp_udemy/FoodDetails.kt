package com.example.foodapp_udemy

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_food_details.*


class FoodDetails : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_food_details)

        val bundle = intent.extras!!

        tvFoodImage.setImageResource(bundle.getInt("image"))
        tvName.text = bundle.getString("name")
        tvDes.text = bundle.getString("des")
    }
}
