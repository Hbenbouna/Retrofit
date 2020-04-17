package retrofitjson.Ben

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import dmax.dialog.SpotsDialog
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofitjson.Ben.Adapter.MyMovieAdapter
import retrofitjson.Ben.Common.Common
import retrofitjson.Ben.Interface.RetrofitService
import retrofitjson.Ben.Model.Movies

class MainActivity : AppCompatActivity() {

    lateinit var mService: RetrofitService
    lateinit var layoutManager: LinearLayoutManager
    lateinit var adapter: MyMovieAdapter
    lateinit var dialog: android.app.AlertDialog

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mService = Common.retrofitService


        recyclerMovieList.setHasFixedSize(true)
        layoutManager = LinearLayoutManager(this)
        recyclerMovieList.layoutManager = layoutManager

        dialog = SpotsDialog.Builder().setCancelable(false).setContext(this).build()

        getAllMovieList()


    }

    private fun getAllMovieList() {
        dialog.show()
        mService.getMovieList().enqueue(object : Callback<MutableList<Movies>> {
            override fun onFailure(call: Call<MutableList<Movies>>, t: Throwable) {
                TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
            }

            override fun onResponse(
                call: Call<MutableList<Movies>>,
                response: Response<MutableList<Movies>>
            ) {
                adapter = MyMovieAdapter(baseContext, response.body() as MutableList<Movies>)
                adapter.notifyDataSetChanged()
                recyclerMovieList.adapter = adapter
                dialog.dismiss()
            }

        })
    }
}

