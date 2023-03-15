package fr.alefaux.pollochon.core.datastore

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.booleanPreferencesKey
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.preferencesDataStore
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class SettingsDataStore(
    private val context: Context
) {

    fun userIsLogged(): Flow<Boolean> {
        return context.settingsDataStore.data.map { value ->
            value[userIsLogged] ?: false
        }
    }

    suspend fun setUserIsLogged(isLogged: Boolean) {
        context.settingsDataStore.edit { settings ->
            settings[userIsLogged] = isLogged
        }
    }

    companion object {
        private val userIsLogged = booleanPreferencesKey("user_is_logged")
    }
}

val Context.settingsDataStore: DataStore<Preferences> by preferencesDataStore(name = "settings")
