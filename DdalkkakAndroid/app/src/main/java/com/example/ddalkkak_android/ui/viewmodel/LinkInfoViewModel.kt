package com.example.ddalkkak_android.ui.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.ddalkkak_android.data.LinkInfo
import com.example.ddalkkak_android.repository.LikeInfoRepository
import com.example.ddalkkak_android.repository.LinkInfoRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import timber.log.Timber
import javax.inject.Inject

@HiltViewModel
class LinkInfoViewModel @Inject constructor(
    private val linkInfoRepository: LinkInfoRepository,
    private val likeInfoRepository: LikeInfoRepository
) : ViewModel() {
    private val _linkInfos = MutableLiveData<List<LinkInfo>>()
    val linkInfos: LiveData<List<LinkInfo>> = _linkInfos

    fun getLinkInfos() {
        viewModelScope.launch {
            runCatching {
                linkInfoRepository.getLinkInfo()
            }.onSuccess {
                _linkInfos.value = it
                Timber.d("정보 가져오기 성공")
            }.onFailure {
                Timber.e("정보 가져오기 실패 : $it")
            }
        }
    }

    fun getLinkInfos(date: String) {
        viewModelScope.launch {
            runCatching {
                linkInfoRepository.getLinkInfoByCreated(date)
            }.onSuccess {
                _linkInfos.value = it
                Timber.d("정보 가져오기 성공")
            }.onFailure {
                Timber.e("정보 가져오기 실패 : $it")
            }
        }
    }

    fun getLinkInfo(user: String) {
        viewModelScope.launch {
            runCatching {
                Timber.d("유저 : $user")
                linkInfoRepository.getLinkInfoByUser(user)
            }.onSuccess {
                _linkInfos.value = it
                Timber.d("정보 가져오기 성공 : $it")
            }.onFailure {
                Timber.e("정보 가져오기 실패 : $it")
            }
        }
    }

    fun getLikeInfo(user: Long) {
        viewModelScope.launch {
            runCatching {
                Timber.d("유저 아이디 : $user")
                likeInfoRepository.getLikes(user)
            }.onSuccess {
                Timber.d("정보 가져오기 성공 $it")
                _linkInfos.value = it
            }.onFailure {
                Timber.e("정보 가져오기 실패 : $it")
            }
        }
    }
}


