package com.example.saborapp.views.ui.about

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class AboutViewModel : ViewModel() {
    private val _text = MutableLiveData<String>().apply {
        value = "Somos el App que te da recetas deliciosas, nutritivas y consistentes. " +
                "Desde smoothies hasta sopas, postres y antojos tipicos, SaborApp te guiara " +
                "paso a paso hasta un perfecto resultado cada vez. En nuestra ultima " +
                "actualizacion incluimos las sugerencias hechas por nuestros usuarios. " +
                "¡Dejate sorprender!"
    }
    val text: LiveData<String> = _text

}