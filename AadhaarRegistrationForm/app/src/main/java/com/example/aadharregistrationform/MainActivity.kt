package com.example.aadharregistrationform


import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.content.Intent
import android.util.Log
import android.view.View;
import android.widget.*

class MainActivity : AppCompatActivity() {

    private val msg:String = "Submitted"
    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Log.d("Form","onCreate")
        var name = findViewById<EditText>(R.id.t1)
        var age = findViewById<EditText>(R.id.t2)
        var Gender = findViewById<EditText>(R.id.t3)
        var Address = findViewById<EditText>(R.id.t4)
        var btn = findViewById<Button>(R.id.FirstBtn)
        var text = findViewById<TextView>(R.id.txt)
        val spinner =findViewById<Spinner>(R.id.spinner);
        var G = arrayOf("Male", "Female", "Other")

        var option = ""

        if (spinner != null) {
            val adapter = ArrayAdapter(
                this,
                android.R.layout.simple_spinner_item, G
            )
            spinner.adapter = adapter

            spinner.onItemSelectedListener = object :
                AdapterView.OnItemSelectedListener {
                override fun onItemSelected(
                    parent: AdapterView<*>,
                    view: View, position: Int, id: Long)
                {
                    option = G[position]
                }

                override fun onNothingSelected(p0: AdapterView<*>?) {
                }
            }
        btn.setOnClickListener{
            if(name.text.isEmpty())
            {
                text.text= "Please enter your name"
            }
            else if(age.text.isEmpty()){
                text.text= "PLease enter your password"
            }
            else if(Gender.text.isEmpty()){
                text.text= "PLease enter your email"
            }
            else if(Address.text.isEmpty()){
                text.text= "PLease enter date"
            }
            else{
                text.text="""${name.text.toString()}
                    |${age.text}
                    |Gender:${spinner.selectedItem}
                    |${Address.text}
                    
                """.trimMargin()
            }


        val btnC = findViewById<Button>(R.id.FirstBtn)
        btnC.setOnClickListener {
            val intent = Intent(this, MainActivity2::class.java)

            intent.putExtra("msg_value", msg)
            startActivity(intent)
        }
    }
}}}



