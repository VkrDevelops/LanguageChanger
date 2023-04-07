package com.example.languagechanger

import android.app.Activity
import android.content.Context
import android.content.res.Configuration
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.languagechanger.databinding.ActivityMainBinding
import java.util.*

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.urdu.setOnClickListener {
            setLocale("ur",this)
        }
        binding.english.setOnClickListener {
            setLocale("en",this)
        }
    }

    private fun setLocale(languageCode: String, activity: Activity) {
        val currentLocale = activity.resources.configuration.locale
        if (currentLocale.language != languageCode) {
            val locale = Locale(languageCode)
            Locale.setDefault(locale)
            val resources = activity.resources
            val configuration = Configuration(resources.configuration)
            configuration.setLocale(locale)
            activity.baseContext.resources.updateConfiguration(configuration, activity.baseContext.resources.displayMetrics)
            activity.recreate()

        }else{
            Toast.makeText(activity, "Already Selected Language", Toast.LENGTH_SHORT).show()
        }
    }

}