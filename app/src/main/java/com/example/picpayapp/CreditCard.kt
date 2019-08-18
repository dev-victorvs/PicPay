package com.example.picpayapp

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_credit_card.*

class CreditCard : AppCompatActivity() {

    private lateinit var context : Context

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_credit_card)

        btn_cadastrar.setOnClickListener {
            intent = Intent(this, NewCard::class.java)
            startActivity(intent)

            btn_cadastrar.setBackgroundResource(R.drawable.btn_cadastrar_click)
        }

        ic_back_credit.setOnClickListener {
            intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
    }
}
