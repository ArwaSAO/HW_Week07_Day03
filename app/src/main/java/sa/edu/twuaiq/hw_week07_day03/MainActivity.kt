package sa.edu.twuaiq.hw_week07_day03

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.RecyclerView
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : AppCompatActivity() {
    private val products = mutableListOf<ProductModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val productRecyclerView: RecyclerView = findViewById(R.id.product_recyclerview)
        val productsAdapter = ProductRecyclerViewAdapter(products)

        productRecyclerView.adapter = productsAdapter


        val retrofit = Retrofit.Builder()
            .baseUrl("https://simplifiedcoding.net")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        //  Builder API
        val productApi = retrofit.create(IProductApi::class.java)

        // Calling the API Methods and handles the result
        productApi.getListProducts(3).enqueue(object : Callback<List<ProductModel>> {
            override fun onResponse(
                call: Call<List<ProductModel>>,
                response: Response<List<ProductModel>>
            ) {


                response.body()?.run {
                    products.addAll(this)
                    productsAdapter.notifyDataSetChanged()
                }
            }

            override fun onFailure(call: Call<List<ProductModel>>, t: Throwable) {
            }

        })


    }



}