package retrofitjson.Ben.Interface

import retrofit2.Call
import retrofit2.http.GET
import retrofitjson.Ben.Model.Movies

interface RetrofitService {
    @GET( "marvel")
    fun getMovieList(): Call<MutableList<Movies>>
}