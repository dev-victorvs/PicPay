package com.example.picpayapp

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.LinearLayout
import android.widget.TextView

class UsersAdapter(
    private val context: Context,
    private var resource: Int,
    private var dados : ArrayList<Users>

) : BaseAdapter(){


    private val mInflater: LayoutInflater = LayoutInflater.from(context)
    private var contador = 0


    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        var novaCelula = false
        var mView = convertView

        if (mView == null){
            novaCelula = true
            contador ++

            mView = mInflater.inflate(resource, parent, false)
        }

        val item = dados[position]


        //layout

        var celContacts = mView!!.findViewById<LinearLayout>(R.id.ll_contatos)
        var username = mView!!.findViewById<TextView>(R.id.tv_username)
        var name = mView!!.findViewById<TextView>(R.id.tv_name)


        username.text = item[Users.USERNAME]
        name.text = item[Users.NAME]

        return mView
    }

    override fun getItem(position: Int): Any {
        return dados[position]
    }

    override fun getItemId(position: Int): Long {
        return dados[position][Users.ID]!!.toLong()
    }

    override fun getCount(): Int {
        return 2
    }
}