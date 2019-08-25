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
import androidx.constraintlayout.widget.ConstraintLayout
import com.google.android.material.bottomsheet.BottomSheetBehavior

class  LoginActivity : AppCompatActivity() {

    @RequiresApi(Build.VERSION_CODES.M)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        var toolbar: Toolbar = findViewById(R.id.toolbar_main_login)
        toolbar.title = "Iniciar sesión en Elektra"
        toolbar.setTitleTextColor(getColor(R.color.elektraRed))

        setSupportActionBar(toolbar)

        supportActionBar!!.setDisplayHomeAsUpEnabled(true)
        supportActionBar!!.setDisplayShowHomeEnabled(true)

        var bottomSheet = findViewById<LinearLayout>(R.id.bottom_sheet)
        var accessCode = findViewById<Button>(R.id.btn_accesscode_login)
        var bsb = BottomSheetBehavior.from(bottomSheet)

        accessCode.setOnClickListener(object: View.OnClickListener {
            override fun onClick(p0: View?) {
                bsb.state = BottomSheetBehavior.STATE_EXPANDED
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
