package com.example.picpayapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextWatcher
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_new_card.*
import kotlinx.android.synthetic.main.activity_pagamento.*

class Pagamento : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pagamento)


        et_valor.setOnFocusChangeListener { view, b ->

            et_valor.addTextChangedListener(Mask.mask("##.##", et_valor))

            et_valor.setCompoundDrawablesRelativeWithIntrinsicBounds(R.drawable.reais_click, 0,0,0)
            btn_pagar.setBackgroundResource(R.drawable.btn_pagar)

            btn_pagar.isFocusable = true

            btn_pagar.setOnClickListener {
                btn_pagar.setBackgroundResource(R.drawable.btn_pagar_click)

                intent = Intent(this, Recibo::class.java)
                startActivity(intent)
            }
        }

    }
}
