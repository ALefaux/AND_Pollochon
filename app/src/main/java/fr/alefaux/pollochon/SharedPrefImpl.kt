package fr.alefaux.pollochon

import android.content.Context
import androidx.preference.PreferenceManager

class SharedPrefImpl(context: Context): SharedPref {

    private val sharedPref = PreferenceManager.getDefaultSharedPreferences(context)

    override fun getStringValue(name: String): String = sharedPref.getString(name, "") ?: ""

    override fun setStringValue(name: String, value: String) {
        val editor = sharedPref.edit()
        editor.putString(name, value)
        editor.apply()
    }

}