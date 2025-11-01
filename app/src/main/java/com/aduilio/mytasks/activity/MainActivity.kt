package com.aduilio.mytasks.activity

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.aduilio.mytasks.adapter.ListAdapter
import com.aduilio.mytasks.databinding.ActivityMainBinding
import com.aduilio.mytasks.entity.Task

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initComponents()
    }

    private fun initComponents() {
        val adapter = ListAdapter()
        binding.rvMain.adapter = adapter

        for (i in 1..20) {
            adapter.addItem(Task(title = "Minha tarefa $i", date = "01/11/2025"))
        }

        binding.fabNew.setOnClickListener {
            startActivity(Intent(this, FormActivity::class.java))
        }
    }
}