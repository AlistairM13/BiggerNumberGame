package com.example.biggernumbergame


import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.biggernumbergame.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        changeNumbers()

        binding.leftBtn.setOnClickListener {
            checkAnswer(true)
        }

        binding.rightBtn.setOnClickListener {
          checkAnswer(false)
        }
    }
private fun checkAnswer(isLeftButtonSelected : Boolean){
    val leftNumber = binding.leftBtn.text.toString().toInt()
    val rightNumber = binding.rightBtn.text.toString().toInt()

    val isAnswerCorrect = if(isLeftButtonSelected) leftNumber > rightNumber else rightNumber > leftNumber

    if (isAnswerCorrect){
        binding.root.setBackgroundResource(R.color.green)
        Toast.makeText(this, "Correct", Toast.LENGTH_SHORT).show()
    }else {
        binding.root.setBackgroundResource(R.color.red)
        Toast.makeText(this, "Wrong", Toast.LENGTH_SHORT).show()
    }
    changeNumbers()
}

private fun changeNumbers() {
        val leftNum = (0..10).random()
        var rightNum = leftNum
        while (leftNum == rightNum) {
            rightNum = (0..10).random()
        }
        binding.leftBtn.text = leftNum.toString()
        binding.rightBtn.text = rightNum.toString()
    }
}