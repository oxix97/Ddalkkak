package com.example.ddalkkak_android.ui.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.ddalkkak_android.data.UserInfo
import com.example.ddalkkak_android.repository.UserInfoRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import timber.log.Timber
import javax.inject.Inject

@HiltViewModel
class UserInfoViewModel @Inject constructor(
    private val userInfoRepository: UserInfoRepository
) : ViewModel() {
    private val _userInfos = MutableLiveData<List<UserInfo>>()
    val userInfos: LiveData<List<UserInfo>> = _userInfos

    fun getUsers() {
        viewModelScope.launch {
            runCatching {
                userInfoRepository.getUsers()
            }.onSuccess {
                _userInfos.value = it
                Timber.d("유저 정보 호출 완료")
            }.onFailure {
                Timber.e("유저 정보 호출 실패 : $it")
            }
        }
    }
}