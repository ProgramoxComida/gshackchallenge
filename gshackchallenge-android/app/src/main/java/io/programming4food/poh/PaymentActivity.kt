package io.programming4food.poh

import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.MenuItem
import android.view.View
import android.widget.Button
import android.widget.LinearLayout
import androidx.annotation.RequiresApi
import androidx.appcompat.widget.Toolbar
import com.google.android.material.bottomsheet.BottomSheetBehavior
import androidx.core.content.ContextCompat.startActivity
import android.content.ActivityNotFoundException
import android.content.Intent
import android.net.Uri


class PaymentActivity : AppCompatActivity() {

    @RequiresApi(Build.VERSION_CODES.M)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_payment)

        var toolbar: Toolbar = findViewById(R.id.toolbar_main_payment)
        toolbar.title = "Pagar mi pedido"
        toolbar.setTitleTextColor(getColor(R.color.elektraRed))

        setSupportActionBar(toolbar)

        supportActionBar!!.setDisplayHomeAsUpEnabled(true)
        supportActionBar!!.setDisplayShowHomeEnabled(true)

        var bottomSheet = findViewById<LinearLayout>(R.id.bottom_sheet_payment)
        var accessCode = findViewById<Button>(R.id.btn_credit_card)
        var creditBtn = findViewById<Button>(R.id.btn_credito_azteca)
        var payBtn = findViewById<Button>(R.id.btn_pay_credit_card)
        var bsb = BottomSheetBehavior.from(bottomSheet)

        accessCode.setOnClickListener(object: View.OnClickListener {
            override fun onClick(p0: View?) {
                bsb.state = BottomSheetBehavior.STATE_EXPANDED
            }
        })

        creditBtn.setOnClickListener(object: View.OnClickListener {
            override fun onClick(p0: View?) {
                val urlString = "https://www.elektra.com.mx/credito-elektra"
                val intent = Intent(Intent.ACTION_VIEW, Uri.parse(urlString))
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
                intent.setPackage("com.android.chrome")
                try {
                    startActivity(intent)
                } catch (ex: ActivityNotFoundException) {
                    // Chrome browser presumably not installed and open Kindle Browser
                    intent.setPackage("com.amazon.cloud9")
                    startActivity(intent)
                }

            }
        })

        payBtn.setOnClickListener(object: View.OnClickListener {
            override fun onClick(p0: View?) {
                var i: Intent = Intent(this@PaymentActivity, PaymentResultActivity::class.java)
                startActivity(i)
            }
        })

        bsb.setBottomSheetCallback(object: BottomSheetBehavior.BottomSheetCallback() {
            override fun onSlide(bottomSheet: View, slideOffset: Float) {
                Log.i("BottomSheets", "Offset: " + slideOffset)
            }

            override fun onStateChanged(bottomSheet: View, newState: Int) {
                var nuevoEstado = ""

                when (newState) {
                    BottomSheetBehavior.STATE_COLLAPSED -> nuevoEstado = "STATE_COLLAPSED"
                    BottomSheetBehavior.STATE_EXPANDED -> nuevoEstado = "STATE_EXPANDED"
                    BottomSheetBehavior.STATE_HIDDEN -> nuevoEstado = "STATE_HIDDEN"
                    BottomSheetBehavior.STATE_DRAGGING -> nuevoEstado = "STATE_DRAGGING"
                    BottomSheetBehavior.STATE_SETTLING -> nuevoEstado = "STATE_SETTLING"
                }

                Log.i("BottomSheets", "Nuevo estado: $nuevoEstado")
            }
        })
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // handle arrow click here
        if (item.itemId === android.R.id.home) {
            finish() // close this activity and return to preview activity (if there is any)
        }

        return super.onOptionsItemSelected(item)
    }
}
