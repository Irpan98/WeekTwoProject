package id.itborneo.task3recyclerview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_detail.*
import kotlinx.android.synthetic.main.partial_details.*

class DetailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)


        val user = intent.getParcelableExtra<User>("user")


        if(user !=null ){

            tv_name.text = user.name
            tv_followers.text = user.follower
            tv_office.text = user.company
            tv_address.text = user.city
            iv_avatar.setImageResource(resources.getIdentifier(user.avatar,"drawable",packageName))

        }


    }
}