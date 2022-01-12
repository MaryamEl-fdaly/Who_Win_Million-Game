package com.androidproject.quizapp

import android.content.Context
import android.content.res.Configuration
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.DialogFragment
import com.androidproject.quizapp.databinding.LanguagePopupBinding
//import android.content.
import java.util.*

class languagecustomdialog: DialogFragment() {
    lateinit var   deButton : Button
    private lateinit var binding: LanguagePopupBinding
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View?
    {
        super.onCreate(savedInstanceState)
        binding = LanguagePopupBinding.inflate(layoutInflater)
        //setContentView(binding.root)
        binding.germanbutton.setOnClickListener(
            setLocate("de")
            recreate()
        )

        var rootView : View = inflater.inflate(R.layout.language_popup,container,false)

        rootView.setOnClickListener{
            dismiss()
        }


        return rootView
    }

    private fun setLocate(lang: String) {
        val locale= Locale(lang)
        Locale.setDefault(locale)
        val config =Configuration()
        config.locale= locale
        baseContext.resources.updateConfiguration(config, baseContext.resources.displayMetrics)

        val editor = context?.getSharedPreferences("Settings", Context.MODE_PRIVATE).edit()
    }
}
