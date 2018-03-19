package com.calc.joytoo.calculator

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun bunumberEvent(view:View){
        if (isNewOp){
            shownum.setText("")
        }
        isNewOp=false

        val buSelect = view as Button
        var buClickValue:String = shownum.text.toString()

        when(buSelect.id){
            bu0.id->{
                if (shownum.text.toString().endsWith("0")){
                    shownum.setText("")
                }else {
                    buClickValue+="0"
                }
            }
            bu1.id->{
                buClickValue+="1"
            }
            bu2.id->{
                buClickValue+="2"
            }
            bu3.id->{
                buClickValue+="3"
            }
            bu4.id->{
                buClickValue+="4"
            }
            bu5.id->{
                buClickValue+="5"
            }
            bu6.id->{
                buClickValue+="6"
            }
            bu7.id->{
                buClickValue+="7"
            }
            bu8.id->{
                buClickValue+="8"
            }
            bu9.id->{
                buClickValue+="9"
            }
            budot.id->{
                if (shownum.text.toString().endsWith(".")){
                    shownum.setText("")
                }else {
                    buClickValue+="."
                }
            }
            buplusminus.id->{
                buClickValue="-" + buClickValue
            }
        }
        shownum.setText(buClickValue)
    }

    var op="*"
    var oldNumber=""
    var isNewOp =true
    fun buOpEvent(view: View) {
        val buSelect = view as Button

        when (buSelect.id) {
            buMul.id -> {
                op = "*"
            }

            buDiv.id -> {
                op = "/"
            }

            buSub.id -> {
                op = "-"

            }
            buAdd.id -> {
                op = "+"

            }

        }
        oldNumber=shownum.text.toString()
        isNewOp=true
    }

    fun buEqualEvent(view: View){
        val newNumber=shownum.text.toString()
        var answer:Double?=null
        when(op){
            "*"->{
                answer=oldNumber.toDouble() * newNumber.toDouble()

            }
            "/"->{
                answer=oldNumber.toDouble() / newNumber.toDouble()

            }
            "+"->{
                answer=oldNumber.toDouble() + newNumber.toDouble()

            }
            "-"->{
                answer=oldNumber.toDouble() - newNumber.toDouble()

            }
        }

        shownum.setText(answer.toString())
        isNewOp=true

    }

    fun bupercent(view: View){
        val number:Double=shownum.text.toString().toDouble()/100
        shownum.setText(number.toString())
        isNewOp=true
    }

    fun buClean(view: View){
        shownum.setText("")
        isNewOp=true
    }
}
