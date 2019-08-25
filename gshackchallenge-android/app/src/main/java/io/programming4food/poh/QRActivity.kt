package io.programming4food.meanmachine

import android.os.Bundle

import android.widget.Button
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import io.programming4food.poh.R
import kotlinx.android.synthetic.main.activity_qr.*

class QRActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_qr)
        //setSupportActionBar(toolbar)

        supportActionBar!!.setDisplayHomeAsUpEnabled(true)
        supportActionBar!!.title = "PAGO QR"

        var amount:String = intent.getStringExtra("amount")

        //var uri = "http://hackathonbbvabackend-pro.jjej6axnqt.us-east-1.elasticbeanstalk.com/api/code/generate?alias=CREDITCARD&account=4772133032264209&account_type=CREDIT_CARD&reference=1234567&account_holder_name=Fidel%20Aquino&amount=" + amount
        var uri = "https://api.qrserver.com/v1/create-qr-code/?size=150x150&data=$200.00"
        var imageView = findViewById<ImageView>(R.id.qr_image)

        Glide.with(this).load(uri).into(imageView)

        val finish = findViewById<Button>(R.id.finish_button)
        finish.setOnClickListener({
            finish()
        })
    }

    override fun onSupportNavigateUp(): Boolean {
        finish()
        return super.onSupportNavigateUp()
    }
}
