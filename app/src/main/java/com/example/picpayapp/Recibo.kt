package com.example.picpayapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_recibo.*
import java.text.SimpleDateFormat
import java.util.*

class Recibo : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recibo)


        val sdf = SimpleDateFormat("dd/MM/yyyy")
        val sdft = SimpleDateFormat("hh:mm")
        val currentDate = sdf.format(Date())
        val currentTime = sdft.format(Date())
        val dateTime = "$currentDate às $currentTime"

        tv_date.text = dateTime

        btn_finalizar.setOnClickListener {
            btn_finalizar.setBackgroundResource(R.drawable.btn_finalizar_click)

            Toast.makeText(this, "Pagamento efetuado com sucesso!", Toast.LENGTH_SHORT).show()

            intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
    }
}
