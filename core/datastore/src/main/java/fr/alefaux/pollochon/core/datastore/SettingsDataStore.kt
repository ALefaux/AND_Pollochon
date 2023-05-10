package fr.alefaux.pollochon.core.datastore

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.booleanPreferencesKey
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.intPreferencesKey
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.mapNotNull

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

    fun getUserId(): Flow<Int> {
        return context.settingsDataStore.data.mapNotNull { value ->
            value[userId]
        }
    }

    suspend fun setUserId(id: Int) {
        context.settingsDataStore.edit { settings ->
            settings[userId] = id
        }
    }

    fun getUserName(): Flow<String> {
        return context.settingsDataStore.data.mapNotNull { value ->
            value[userName]
        }
    }

    suspend fun setUserName(name: String) {
        context.settingsDataStore.edit { settings ->
            settings[userName] = name
        }
    }

    fun getUserImageUrl(): Flow<String?> {
        return context.settingsDataStore.data.map { value ->
            value[userImageUrl]
        }
    }

    suspend fun setUserImageUrl(imageUrl: String) {
        context.settingsDataStore.edit { settings ->
            settings[userImageUrl] = imageUrl
        }
    }

    companion object {
        private val userIsLogged = booleanPreferencesKey("user_is_logged")
        private val userId = intPreferencesKey("user_id")
        private val userName = stringPreferencesKey("user_name")
        private val userImageUrl = stringPreferencesKey("user_image_url")
    }
}

val Context.settingsDataStore: DataStore<Preferences> by preferencesDataStore(name = "settings")
