package com.example.myapplication

import android.content.res.ColorStateList
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import com.google.android.material.floatingactionbutton.FloatingActionButton
import java.util.*

class MainActivity : AppCompatActivity() {
    private val random = Random()
    private val numbers = arrayListOf<Int>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var num1 = findViewById<Button>(R.id.lottoNum1)
        var num2 = findViewById<Button>(R.id.lottoNum2)
        var num3 = findViewById<Button>(R.id.lottoNum3)
        var num4 = findViewById<Button>(R.id.lottoNum4)
        var num5 = findViewById<Button>(R.id.lottoNum5)
        var num6 = findViewById<Button>(R.id.lottoNum6)

        findViewById<FloatingActionButton>(R.id.floatingActionButton).setOnClickListener{
            numbers.clear()

            setLottoNum(num1)
            setLottoNum(num2)
            setLottoNum(num3)
            setLottoNum(num4)
            setLottoNum(num5)
            setLottoNum(num6)
        }
    }

    private fun setLottoNum(lottoNum: Button) {
        var num=0
        while(true){
            num=random.nextInt(45)+1
            if(!numbers.contains(num)){
                numbers.add(num)
                break
            }
        }
        lottoNum.text="${num}"

        if(num<=10) { //노란색
            lottoNum.backgroundTintList= ColorStateList.valueOf(Color.rgb(255,255,0))
        }else if(num<=20) { //파란색
            lottoNum.backgroundTintList= ColorStateList.valueOf(Color.rgb(0,0,255))
        }else if(num<=30){ //빨간색
            lottoNum.backgroundTintList= ColorStateList.valueOf(Color.rgb(255,0,0))
        }else if(num<=40){ //자주색
            lottoNum.backgroundTintList= ColorStateList.valueOf(Color.rgb(255,20,147))
        }else{ //초록색
            lottoNum.backgroundTintList= ColorStateList.valueOf(Color.rgb(0,255,0))
        }
    }
}
