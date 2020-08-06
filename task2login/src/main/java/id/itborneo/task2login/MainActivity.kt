package id.itborneo.task2login

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import id.itborneo.task2login.utils.EXTRA_USER
import kotlinx.android.synthetic.main.activity_main.*



class MainActivity : AppCompatActivity() {
val TAG = "MainActivity"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val realUser = User("irpan", "udacoding")

        btn_login.setOnClickListener {

            loginVadilation(realUser)
        }

    }

    private fun loginVadilation(realUser: User) {
        val inputedUser = User(edUsername.text.toString(), edPassword.text.toString())
        Log.d(TAG,"real user $realUser and inputed $inputedUser")

        if (realUser.username == inputedUser.username && realUser.password == inputedUser.password) {
            btn_login.isEnabled = false

            val intent = Intent(this, HomeActivity::class.java)
            intent.putExtra(EXTRA_USER, inputedUser)
            startActivity(intent)
        }else{
            Toast.makeText(applicationContext, "Username / Password Salah", Toast.LENGTH_LONG).show()

        }


    }
}
