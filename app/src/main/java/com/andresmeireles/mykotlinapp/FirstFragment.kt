package com.andresmeireles.mykotlinapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.navigation.fragment.findNavController

/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class FirstFragment : Fragment() {

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_first, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // toaster action
        view.findViewById<Button>(R.id.button_toast).setOnClickListener {
            val myToast = Toast.makeText(context, "Toast is showing man!", Toast.LENGTH_SHORT)
            myToast.show()
        }

        // count button
        view.findViewById<Button>(R.id.button_count).setOnClickListener {
            countMe(view)
        }

        view.findViewById<Button>(R.id.button_random).setOnClickListener {
            val showCountTextView = view.findViewById<TextView>(R.id.textview_first)
            val currentCount = showCountTextView.text.toString().toInt()
            val action = FirstFragmentDirections.actionFirstFragmentToSecondFragment(currentCount)
            findNavController().navigate(action)
        }
    }

    private fun countMe(view: View) {
        val showCountTextView = view.findViewById<TextView>(R.id.textview_first)
        val countToString = showCountTextView.text.toString()
        var count = countToString.toInt()
        count++
        showCountTextView.text = count.toString()
    }
}