package com.example.saborapp.views.ui.profile

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.saborapp.R
import com.example.saborapp.views.LoginActivity
import com.google.firebase.auth.FirebaseAuth

class ProfileFragment : Fragment() {

    private lateinit var profileViewModel: ProfileViewModel

    //FirebaseAuth
    private lateinit var firebaseAuth: FirebaseAuth


    override fun onCreateView(inflater: LayoutInflater,container: ViewGroup?,savedInstanceState: Bundle?): View? {

        profileViewModel = ViewModelProvider(this).get(ProfileViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_profile, container, false)

        val textView: TextView = root.findViewById(R.id.tvProfile)
        profileViewModel.text.observe(viewLifecycleOwner, Observer {
            textView.text = it
        })

        return root
    }


}