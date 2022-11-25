package com.shadowtato.demodatepicker

import android.app.DatePickerDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.DatePicker
import android.widget.EditText
import android.widget.ImageButton
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout
import java.util.Calendar

class MainActivity : AppCompatActivity(), DatePickerDialog.OnDateSetListener {

    lateinit var datePickerDialog : DatePickerDialog
    lateinit var etDate : EditText
    lateinit var tfDate : TextInputLayout
    lateinit var tiDate : TextInputEditText
    lateinit var  btnDate : ImageButton


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        init()
        setListeners()
    }

    fun setListeners() {
        tfDate.setEndIconOnClickListener {
            datePickerDialog.show()
        }

        tiDate.setOnClickListener {
            datePickerDialog.show()
        }

        etDate.setOnClickListener {
            datePickerDialog.show()
        }

        btnDate.setOnClickListener {
            datePickerDialog.show()
        }
    }

    fun init() {
        val calendar = Calendar.getInstance()

        tfDate = findViewById(R.id.tf_date)
        tiDate  = findViewById(R.id.ti_date)

        btnDate = findViewById<ImageButton>(R.id.btn_date)

        etDate = findViewById(R.id.etDate)

        datePickerDialog = DatePickerDialog(this,
            this,
            calendar.get(Calendar.YEAR),
            calendar.get(Calendar.MONTH),
            calendar.get(Calendar.DAY_OF_MONTH)
        )
    }

    override fun onDateSet(datePicker: DatePicker?, year: Int, month: Int, day: Int) {
        // TODO: Format the date
        etDate.setText("$day/$month/$year")
        tiDate.setText("$day/$month/$year")
    }
}