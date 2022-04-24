package com.androidproject.quizapp

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment

class Losingdialog : DialogFragment() {

        override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
        ): View? {

            var rootView: View = inflater.inflate(R.layout.lost, container, false)

            rootView.setOnClickListener {
                dismiss()
            }

            return rootView
        }
}