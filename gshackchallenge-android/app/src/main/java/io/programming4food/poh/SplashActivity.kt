package io.programming4food.poh

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler

class SplashActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        var handler: Handler = Handler()
        handler.postDelayed(Runnable() {
            var i: Intent = Intent(this@SplashActivity, DashboardActivity::class.java)
            startActivity(i)
        }, 3000)
    }
}
