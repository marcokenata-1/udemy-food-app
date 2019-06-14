package com.example.foodapp_udemy

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.food_ticket.view.*

class MainActivity : AppCompatActivity() {

    var listOfFoods = ArrayList<Food>()
    var adapter:FoodAdapter? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        listOfFoods.add(Food("Coffee","Coffee Black is for drink",R.drawable.coffee_pot))
        listOfFoods.add(Food("Espresso","Espresso is for drink, beside coffee",R.drawable.espresso))
        listOfFoods.add(Food("French Fries","French Fries from Mcd",R.drawable.french_fries))
        listOfFoods.add(Food("Honey","Bee Torturing result",R.drawable.honey))
        listOfFoods.add(Food("Strawberry","Ice Cream which is terrible",R.drawable.strawberry_ice_cream))
        listOfFoods.add(Food("Sugar Cubes","Instantly getting Diabetes",R.drawable.sugar_cubes))

        adapter = FoodAdapter(this,listOfFoods)
        gvListFood.adapter = adapter
    }

    class FoodAdapter: BaseAdapter {
        var listOfFood = ArrayList<Food>()
        var context: Context? = null

        constructor(context: Context,listOfFood: ArrayList<Food>) : super(){
            this.context = context
            this.listOfFood = listOfFood
        }

        override fun getView(p0: Int, p1: View?, p2: ViewGroup?): View {
            var food = listOfFood[p0]
            var inflator = context!!.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
            var foodView = inflator.inflate(R.layout.food_ticket,null)

            foodView.ivFoodImage.setImageResource(food.image!!)
            foodView.tvName.text = food.name!!

            foodView.ivFoodImage.setOnClickListener{
                val intent = Intent(context,FoodDetails::class.java)
                intent.putExtra("name",food.name!!)
                intent.putExtra("des",food.des!!)
                intent.putExtra("image",food.image!!)
                context!!.startActivity(intent)
            }
            return foodView
        }

        override fun getItem(p0: Int): Any {
            return listOfFood[p0]
        }

        override fun getItemId(p0: Int): Long {
            return p0.toLong()
        }

        override fun getCount(): Int {
            return listOfFood.size
        }

    }
}
