package id.itborneo.task3recyclerview

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.core.app.ActivityOptionsCompat
import androidx.core.util.Pair
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setRecyclerview()
    }



    private fun setRecyclerview() {
        val users = jsonFromGson()

        val rvAdapter = RvAdapter(users) { user: User, view: View ->

            moveActivity(user, view)
        }



        rv_user.adapter = rvAdapter
        rv_user.layoutManager = LinearLayoutManager(this)
    }
    private fun moveActivity(user: User, view: View) {


        val textTransition : Pair<View, String> = Pair.create(view.findViewById(R.id.tv_name),"textUserTransition" )
        val imageTransition : Pair<View, String> = Pair.create(view.findViewById(R.id.iv_user),"imageUserTransition" )


        val activityOptionsCompat =
            ActivityOptionsCompat.makeSceneTransitionAnimation(this@MainActivity, textTransition,imageTransition)


        val intent = Intent(this, DetailActivity::class.java).apply {
            this.putExtra("user",user)
        }
        startActivity(intent,activityOptionsCompat.toBundle())


    }


    private fun jsonFromGson(): ArrayList<User> {
        val users: ArrayList<User>
        val jsonFileString = getJsonDataFromAsset(applicationContext, "famousUser.json")
        if (jsonFileString != null) {
            Log.i("data", jsonFileString)
        }

        val gson = Gson()
        val listUserType = object : TypeToken<List<User>>() {}.type

        users = gson.fromJson(jsonFileString, listUserType)
        return users

    }
}
