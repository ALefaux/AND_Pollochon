package fr.alefaux.pollochon

interface SharedPref {
    fun getStringValue(name: String): String
    fun setStringValue(name: String, value: String)

    companion object {
        const val USER_ID = "USER_ID"
    }
}