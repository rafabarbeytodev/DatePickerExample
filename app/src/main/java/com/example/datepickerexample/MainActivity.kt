package com.example.datepickerexample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import com.example.datepickerexample.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var mBinding : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(mBinding.root)

        mBinding.etDate.setOnClickListener {
            showPickerDateDialog()
        }

    }

    private fun showPickerDateDialog() {
        val datePicker = DatePickerFragment { day, month, year ->
            onDateSelected(day, month, year)
        }
        datePicker.show(supportFragmentManager,"datePicker")
    }

    private fun String.toEditable(): Editable =
        Editable.Factory.getInstance().newEditable(this)

    private fun onDateSelected(day:Int, month:Int, year:Int){
        val text = "Date selected: $day/${month+1}/$year"
        mBinding.etDate.text = text.toEditable()
    }
}