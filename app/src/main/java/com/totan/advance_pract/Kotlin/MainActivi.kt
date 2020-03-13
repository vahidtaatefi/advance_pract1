package com.totan.advance_pract.Kotlin

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import com.totan.advance_pract.Mvp.OghatSharie
import com.totan.advance_pract.R
import com.totan.advance_pract.mvvmdagger2.Daggeractivityaladhan
import com.totan.advance_pract.mvvmdagger2.Daggeractivityaladhan_MembersInjector
import com.totan.advance_pract.mvvmkoin.koinactivityaladhan
import kotlinx.android.synthetic.main.activity_main.*

class MainActivi : AppCompatActivity(), TestRecyclerClickListener {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val drawerLayout: DrawerLayout = findViewById(R.id.draw)
        val list2=ArrayList<String>()
        var intent = Intent()
        list2.add("اوقات شرعی")
        list2.add("daggerاوقات شرعی")
        list2.add("koinاوقات شرعی")
      //  list2.add("Caller")
      //  list2.add("Cinema")
       // list2.add("Camera")
        val list = arrayListOf("اوقات شرعی")
        val adapter=TestKotlinRecyclerAdapter(list2){
            if (it.equals("اوقات شرعی")) {
                intent = Intent(this, OghatSharie::class.java)
            }
            if (it.equals("daggerاوقات شرعی")) {
                intent = Intent(this, Daggeractivityaladhan::class.java)
            }
            if (it.equals("koinاوقات شرعی")) {
                intent = Intent(this, koinactivityaladhan::class.java)
            }
            startActivity(intent)

           // Toast.makeText(this, it, Toast.LENGTH_LONG).show()
        }
        recycler.adapter=adapter;
        navbar.setOnClickListener()
        {
            drawerLayout.openDrawer(GravityCompat.START)
        }


    }

    override fun onClick(name: String?) {
        Toast.makeText(this,name,Toast.LENGTH_LONG).show()

    }

}
