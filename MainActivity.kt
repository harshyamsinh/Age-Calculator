package com.example.agecalculator
import android.app.DatePickerDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import java.time.LocalDate
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import java.util.Calendar


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val button = findViewById<Button>(R.id.selectDate)

        button.setOnClickListener {view->
            printAge(view)
        }
    }
    fun printAge(view:View){
        var myCal = Calendar.getInstance()

        var year = myCal.get(Calendar.YEAR)
        var month= myCal.get(Calendar.MONTH)
        var day = myCal.get(Calendar.DAY_OF_MONTH)

        val current = LocalDate.now()

        DatePickerDialog (this,DatePickerDialog.OnDateSetListener
        {
                view, year, month, day ->

            val selectDate ="Your Date Of Birth: $day-${month+1}-$year"
            val textview=findViewById<TextView>(R.id.textview1)
            textview.text = selectDate

            val formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy")
            val current = LocalDateTime.now().format(formatter)

            val textview3=findViewById<TextView>(R.id.textview3)
            textview3.text = "Today Date: $current"

            var dob= Calendar.getInstance()
            dob.set(year,month,day)

            var age=myCal.get(Calendar.YEAR) - dob.get(Calendar.YEAR)
            if(myCal.get(Calendar.DAY_OF_YEAR) < dob.get(Calendar.YEAR))
            {
                age--
            }

            var textview2 = findViewById<TextView>(R.id.textview2)
            textview2.text="You are $age year old"
        }
            ,year,month,day).show()
    }
}