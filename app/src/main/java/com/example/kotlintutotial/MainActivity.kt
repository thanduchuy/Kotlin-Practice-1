package com.example.kotlintutotial

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import timber.log.Timber

const val KEY_NUMBER1 = "Number 1"
const val KEY_NUMBER2 = "Number 2"

class MainActivity : AppCompatActivity() {
    private var randomInt1 = 0
    private var randomInt2 = 0
    private fun getRandomDiceImage(randomInt : Int) : Int {
        var result = when (randomInt) {
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            else -> R.drawable.dice_6
        }
        return result
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        if (savedInstanceState != null) {
            randomInt1 = savedInstanceState.getInt(KEY_NUMBER1, 0)
            randomInt2 = savedInstanceState.getInt(KEY_NUMBER2, 0)
            image1.setImageResource(getRandomDiceImage(randomInt1))
            image2.setImageResource(getRandomDiceImage(randomInt2))
            text.text = (randomInt1+randomInt2).toString()
        }
        btn.setOnClickListener {
            randomInt1 = (1..6).random()
            randomInt2 = (1..6).random()
            image1.setImageResource(getRandomDiceImage(randomInt1))
            image2.setImageResource(getRandomDiceImage(randomInt2))
            text.text = (randomInt1+randomInt2).toString()
        }
    }
    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        Timber.i("onSaveInstanceState Called")
        outState.putInt(KEY_NUMBER1, randomInt1)
        outState.putInt(KEY_NUMBER2, randomInt2)
    }
}
