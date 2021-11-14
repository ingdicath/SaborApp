package com.example.saborapp.models

import com.google.firebase.database.IgnoreExtraProperties

@IgnoreExtraProperties
data class RecipeModel(
    var id: String? = "",
    var name: String?="",
    var portions: String?="",
    var time: String?="",
    var ingredients: String?="",
    var instructions: String?=""
)