package ru.code.codeworkers

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import ru.code.codeworkers.databinding.ActivityMainBinding
import ru.code.codeworkers.dto.Worker

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

    }
}