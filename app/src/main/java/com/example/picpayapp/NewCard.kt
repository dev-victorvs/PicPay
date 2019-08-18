package com.example.picpayapp

import android.app.DatePickerDialog
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_new_card.*
import java.util.*

class NewCard : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_new_card)


        val c = Calendar.getInstance()
        val year = c.get(Calendar.YEAR)
        val month = c.get(Calendar.MONTH)
        val day = c.get(Calendar.DAY_OF_MONTH)


        et_numero_cartao.addTextChangedListener(Mask.mask("####.####.####.####", et_numero_cartao))
        et_cvv.addTextChangedListener(Mask.mask("###", et_cvv))
        et_vencimento.addTextChangedListener(Mask.mask("##.##", et_vencimento))


        btn_salvar.setOnClickListener {
            intent = Intent(this, Pagamento::class.java)
            startActivity(intent)

            btn_salvar.setBackgroundResource(R.drawable.btn_salvar_click)
        }

        ic_back_card.setOnClickListener {
            intent = Intent(this, CreditCard::class.java)
            startActivity(intent)
        }

    }
}
