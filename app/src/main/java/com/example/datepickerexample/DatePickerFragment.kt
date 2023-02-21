package com.example.datepickerexample

import android.app.DatePickerDialog
import android.app.Dialog
import android.content.Context
import android.os.Bundle
import android.widget.DatePicker
import androidx.fragment.app.DialogFragment
import java.util.*

/*****
 * Proyect: DatePickerExample
 * Package: com.example.datepickerexample
 *
 * Created by Rafael Barbeyto Torrellas on 21/02/2023 at 9:45
 * More info: https://www.linkedin.com/in/rafa-barbeyto/
 *
 * All rights reserved 2023.
 *****/

class DatePickerFragment(val listener: (day:Int, month:Int, year:Int) -> Unit): DialogFragment(),
DatePickerDialog.OnDateSetListener{

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        //Inicializamos con la fecha actual
        val cal = Calendar.getInstance()
        val day = cal.get(Calendar.DAY_OF_MONTH)
        val month = cal.get(Calendar.MONTH) //OJO, es base 0 (January = 0)
        val year = cal.get(Calendar.YEAR)

        val picker = DatePickerDialog(activity as Context,this,year,month,day)
        //Podemos limitar con maxDate o minDate las fechas seleccionables
        picker.datePicker.minDate = cal.timeInMillis //Fecha actual
        picker.datePicker.maxDate = 1992590224000 // 10 años vista

        return picker
    }

    override fun onDateSet(view: DatePicker?, year: Int, month: Int, dayOfMonth: Int) {
        listener(dayOfMonth,month,year)
    }
}