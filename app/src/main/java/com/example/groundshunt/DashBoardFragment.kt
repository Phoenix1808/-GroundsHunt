package com.example.groundshunt

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment

class DashboardFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_dash_board, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        displayUserName(view)

        val btnBookGround: Button? = view.findViewById(R.id.btnBookGround)

        btnBookGround?.setOnClickListener {
            Toast.makeText(requireContext(), "Book a Ground button clicked!", Toast.LENGTH_SHORT).show()
        }
    }

    /**
     * Retrieves the user's name from SharedPreferences and updates the welcome message.
     */
    private fun displayUserName(view: View) {
        val sharedPref = requireActivity().getSharedPreferences("GroundsHunt_Prefs", Context.MODE_PRIVATE)

        val userName = sharedPref.getString("USER_NAME", "Guest") ?: "USER_NAME"

        val tvWelcome: TextView = view.findViewById(R.id.tvWelcome)

        // Update the text
        tvWelcome.text = "Welcome back, $userName!"
    }
}
