package com.example.picpayapp

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.KeyEvent
import android.view.View
import android.widget.EditText
import android.widget.SimpleAdapter
import kotlinx.android.synthetic.main.telainicial.*

class MainActivity : AppCompatActivity() {

    private lateinit var context: Context
    private lateinit var adp: UsersAdapter
    private var users = ArrayList<Users>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.telainicial)

        initVars()
        initActions()
    }

    private fun initVars() {
        context = this@MainActivity

        montarListaContatos()

    }

    private fun montarListaContatos() {

        val De = arrayOf(Users.PROFILE_PICTURE, Users.USERNAME, Users.NAME)
        val Para = intArrayOf(R.id.profile_image, R.id.tv_username, R.id.tv_name)

        lv_contatos.adapter = SimpleAdapter(
            context,
            gerarContatos(),
            R.layout.contatos,
            De,
            Para
        )
    }


    private fun gerarContatos(): ArrayList<Users> {
        val contatos = ArrayList<Users>()


        for (i in 0 until listaUsername.size) {

            val users = Users()

            users[Users.ID] = (i + 1).toString()
            users[Users.PROFILE_PICTURE] = listaImg[i].toString()
            users[Users.USERNAME] = listaUsername[i]
            users[Users.NAME] = listaName[i]

            contatos.add(users)
        }


        return contatos
    }


    var listaImg = intArrayOf(
        R.drawable.aliceromero,
        R.drawable.caiovibes,
        R.drawable.danlop,
        R.drawable.depaula,
        R.drawable.fab_dias,
        R.drawable.figueiredo_bruna,
        R.drawable.gust,
        R.drawable.helena,
        R.drawable.igor_m,
        R.drawable.llucena,
        R.drawable.vvieira,
        R.drawable.vkimyte,
        R.drawable.zelda_williams
    )

    var listaUsername = arrayOf(
        "aliceromero",
        "caiovibes",
        "danlop",
        "depaula",
        "fab.dias",
        "figueiredo.bruna",
        "gust",
        "helena",
        "igor.m",
        "llucena",
        "victorvs",
        "viniciuskimyte",
        "zelda.williams"
    )

    var listaName = arrayOf(
        "Alice Romero",
        "Caio Borges",
        "Daniel Lopes",
        "Eliane de Paula",
        "Fabrício Dias",
        "Bruna Figueiredo",
        "Gustavo Almeida",
        "Helena Pacheco",
        "Igor Matos",
        "Leandro Lucena",
        "Victor Vieira",
        "Vinicius Kimyte",
        "Zelda Williams"
    )


    private fun initActions() {

        lv_contatos.setOnItemClickListener { parent, view, position, id ->
            val item = parent.getItemAtPosition(position) as Users

            intent = Intent(context, CreditCard::class.java)
            startActivity(intent)
        }

        et_contatos.setOnKeyListener(View.OnKeyListener { v, keyCode, event ->
            if (keyCode == KeyEvent.KEYCODE_ENTER && event.action == KeyEvent.ACTION_UP) {
                //Perform Code
                return@OnKeyListener true
            }
            false
        })


    }

}
