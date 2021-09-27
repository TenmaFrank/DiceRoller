package com.tenma_frank.diceroller

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    private lateinit var rollButton: Button
    private lateinit var resultText: TextView
    private lateinit var countUpButton: Button
    private lateinit var resetButton: Button
    private lateinit var diceImage: ImageView
    private lateinit var secondDiceImage: ImageView
    private lateinit var rollTwoButton: Button
    private lateinit var countUpTwoButton: Button
    private lateinit var countUpAllButton: Button

    private var actualNum = 0
    private var secondActualNum = 0


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        rollButton= findViewById(R.id.roll_button)
        resultText= findViewById(R.id.result_text)
        diceImage = findViewById(R.id.dice_image)
        secondDiceImage = findViewById(R.id.second_dice_image)
        countUpButton= findViewById(R.id.count_up_button)
        resetButton = findViewById(R.id.reset)
        rollTwoButton =findViewById(R.id.roll_two_button)
        countUpTwoButton = findViewById(R.id.count_up_two_button)
        countUpAllButton = findViewById(R.id.count_up_all_button)


        rollButton.setOnClickListener{ rollDice()}
        countUpButton.setOnClickListener{ countUpOne() }
        resetButton.setOnClickListener { resetDice() }
        rollTwoButton.setOnClickListener { rollTwoDices() }
        countUpTwoButton.setOnClickListener { countUpTwo() }
        countUpAllButton.setOnClickListener { countUpAll() }

    }

    private fun drawSetter(diceOne: Int, diceTwo: Int){

        resultText.text = (diceOne + diceTwo).toString()

        val diceOneImage = when(diceOne){
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            6 -> R.drawable.dice_6
            else -> R.drawable.empty_dice
        }

        val diceTwoImage = when(diceTwo){
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            6 -> R.drawable.dice_6
            else -> R.drawable.empty_dice
        }

        diceImage.setImageResource(diceOneImage)
        secondDiceImage.setImageResource(diceTwoImage)
    }

    private fun rollDice(){
        val randomInt = (1..6).random()
        actualNum = randomInt

        Toast.makeText(this, R.string.roll_button_clicked, Toast.LENGTH_SHORT).show()

        drawSetter(actualNum, 0)
    }

    private fun countUpOne(){
        Toast.makeText(this, R.string.count_up_button_clicked, Toast.LENGTH_SHORT).show()

        actualNum += 1

        actualNum = when{
            actualNum < 6 -> actualNum
            else -> 6
        }

        drawSetter(actualNum, secondActualNum)
    }

    private fun countUpTwo(){
        Toast.makeText(this, R.string.count_up_button_clicked, Toast.LENGTH_SHORT).show()

        secondActualNum += 1

        secondActualNum = when{
            secondActualNum < 6 -> secondActualNum
            else -> 6
        }

        drawSetter(actualNum, secondActualNum)
    }

    private fun countUpAll(){

        Toast.makeText(this, R.string.count_up_button_clicked, Toast.LENGTH_SHORT).show()

        actualNum += 1
        secondActualNum += 1

        actualNum = when{
            actualNum < 6 -> actualNum
            else -> 6
        }

        secondActualNum = when{
            secondActualNum < 6 -> secondActualNum
            else -> 6
        }

        drawSetter(actualNum, secondActualNum)

    }

    private fun resetDice(){
        Toast.makeText(this, R.string.reset_button_clicked ,Toast.LENGTH_SHORT).show()

        actualNum = 0
        secondActualNum = 0

        drawSetter(actualNum, secondActualNum)

    }

    private fun rollTwoDices(){
        val randomInt = (1..6).random()
        val secondRandomInt = (1..6).random()

        actualNum = randomInt
        secondActualNum = secondRandomInt

        Toast.makeText(this, R.string.roll_two_button_clicked, Toast.LENGTH_SHORT).show()

        drawSetter(actualNum, secondActualNum)
    }

}

