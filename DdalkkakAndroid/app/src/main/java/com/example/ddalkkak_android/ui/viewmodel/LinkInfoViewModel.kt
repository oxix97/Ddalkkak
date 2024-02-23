package com.example.ddalkkak_android.ui.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.ddalkkak_android.dao.AppDatabase
import com.example.ddalkkak_android.dao.LinkInfoDao
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
    private val likeInfoRepository: LikeInfoRepository,
    private val db: AppDatabase
) : ViewModel() {
    private val _linkInfos = MutableLiveData<List<LinkInfo>>()
    val linkInfos: LiveData<List<LinkInfo>> get() = _linkInfos

    private val _myInfos = MutableLiveData<List<LinkInfo>>()
    val myInfos: LiveData<List<LinkInfo>> get() = _myInfos

    private val _searchInfos = MutableLiveData<List<LinkInfo>>()
    val searchInfos: LiveData<List<LinkInfo>> get() = _searchInfos

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

    fun getAll() {
        viewModelScope.launch {
            runCatching {
                db.linkInfoDao().getAll()
            }.onSuccess {
                Timber.d("정보 가져오기 성공 : $it")
                _myInfos.value = it
            }.onFailure {
                Timber.e("정보 가져오기 실패 : $it")
            }
        }
    }

    fun insertLinkInfo(item: LinkInfo) {
        viewModelScope.launch {
            runCatching {
                db.linkInfoDao().insert(item)
                Timber.d("아이템 : ${myInfos.value}")
            }.onSuccess {
                val current = _myInfos.value?.toMutableList()
                current?.add(item)
                _myInfos.value = current!!
                Timber.d("저장")
            }.onFailure {
                Timber.e("저장 실패")
            }
        }
    }

    fun deleteLinkInfo(item: LinkInfo) {
        viewModelScope.launch {
            runCatching {
                db.linkInfoDao().delete(item)
                Timber.d("아이템 : ${myInfos.value}")
            }.onSuccess {
                val current = _myInfos.value?.toMutableList()
                current?.remove(item)
                _myInfos.value = current!!

                Timber.d("삭제")
            }.onFailure {
                Timber.e("삭제 실패")
            }
        }
    }

    fun getSearchLinkInfo(keyword: String) {
        viewModelScope.launch {
            runCatching {
                linkInfoRepository.getSearch(keyword)
            }.onSuccess {
                _searchInfos.value = it
                Timber.d("검색 성공 $it")
            }.onFailure {
                Timber.e("검색 실패 $it")
            }
        }
    }
}


