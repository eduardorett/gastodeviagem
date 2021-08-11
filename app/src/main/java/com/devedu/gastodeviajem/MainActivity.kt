package com.devedu.gastodeviajem

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity(), View.OnClickListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        confirmButtom.setOnClickListener(this)
    }

    override fun onClick(view: View) {
       // Log.d("CLICK","clique agora pelo lintener !!!! funfou !!")
        val id = view.id
        if (id == R.id.confirmButtom) {
            calculate()
        }
    }
private fun calculate() {

    if (validationOk()) {
        try{
            val distance = editTotaldekm.text.toString().toFloat()
            val preco = editPreco.text.toString().toFloat()
            val autonomy = editAutonomia.text.toString().toFloat()

            val totalValue = (distance * preco) / autonomy
            textTotalValue.text = "R$ ${"%.2f".format(totalValue)}"

        } catch (nfe: NumberFormatException){
            Toast.makeText(this,getString(R.string.porfavor),Toast.LENGTH_LONG).show()
        }
    } else {
   Toast.makeText(this,getString(R.string.notificação),Toast.LENGTH_LONG).show()
    }
}
    fun validationOk():Boolean{

        return(editAutonomia.text.toString() != ""
                && editPreco.text.toString() != ""
                && editTotaldekm.text.toString() != ""
                && editTotaldekm.text.toString() != "0")

    }
}