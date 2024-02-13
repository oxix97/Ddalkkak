//package com.example.ddalkkak_android.util
//
//import android.content.Context
//import androidx.datastore.core.DataStore
//import androidx.datastore.preferences.core.Preferences
//import androidx.datastore.preferences.core.booleanPreferencesKey
//import androidx.datastore.preferences.core.edit
//import androidx.datastore.preferences.core.intPreferencesKey
//import androidx.datastore.preferences.core.stringPreferencesKey
//import androidx.datastore.preferences.preferencesDataStore
//import dagger.hilt.android.lifecycle.HiltViewModel
//import kotlinx.coroutines.flow.Flow
//import kotlinx.coroutines.flow.map
//import java.time.LocalDate
//import javax.inject.Inject
//
//class UserManager @Inject constructor(
//    private val dataStore: DataStore<Preferences>
//) {
//    private val Context.dataStore: DataStore<Preferences> by preferencesDataStore(name = "user_prefs")
//
//    companion object {
//        val USER_ID_KEY = stringPreferencesKey("USER_ID")
//
//        //        val USER_LEARN_ID_KEY = stringPreferencesKey("USER_LEARN_ID")
//        val USER_LEARN_URL_KEY = stringPreferencesKey("USER_LEARN_URL")
//        val USER_LEARN_CREATE_KEY = stringPreferencesKey("USER_LEARN_CREATE")
//    }
//
//    suspend fun storeUser(
//        userId: String,
////        learnId: String,
//        learnUrl: String,
//        learnCreate: String
//    ) {
//        dataStore.edit {
//            it[USER_ID_KEY] = userId
////            it[USER_LEARN_ID_KEY] = learnId
//            it[USER_LEARN_URL_KEY] = learnUrl
//            it[USER_LEARN_CREATE_KEY] = learnCreate
//        }
//    }
//
//    val userIdFlow: Flow<String?> = dataStore.data.map {
//        it[USER_ID_KEY]
//    }
//
////    val userLearnIdFlow: Flow<String?> = dataStore.data.map {
////        it[USER_LEARN_ID_KEY]
////    }
//
//    val userLearnUrlFlow: Flow<String?> = dataStore.data.map {
//        it[USER_LEARN_URL_KEY]
//    }
//
//    val userLearnCreateFlow: Flow<String?> = dataStore.data.map {
//        it[USER_LEARN_CREATE_KEY]
//    }
//
//}