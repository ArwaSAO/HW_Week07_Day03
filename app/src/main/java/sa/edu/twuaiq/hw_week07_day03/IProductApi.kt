package sa.edu.twuaiq.hw_week07_day03

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface IProductApi {
    @GET("/demos/marvel/")

    fun getListProducts(
        @Query("limit") limit: Int
    ) : Call<List<ProductModel>>
}
