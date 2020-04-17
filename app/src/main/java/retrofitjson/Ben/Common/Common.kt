package retrofitjson.Ben.Common

import retrofit2.create
import retrofitjson.Ben.Interface.RetrofitService
import retrofitjson.Ben.Retrofit.RetrofitClient

object Common {
    private val BASE_URL = "https://www.simplifiedcoding.net/demos/"

    val retrofitService: RetrofitService
    get() = RetrofitClient.getClient(BASE_URL).create(RetrofitService::class.java)
}