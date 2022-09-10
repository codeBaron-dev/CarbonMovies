package com.codebaron.domain.internet

import android.content.Context
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.codebaron.domain.internet.handler.InternetConnectionHandler
import com.codebaron.domain.internet.model.InternetConfigObject
import kotlinx.coroutines.launch

/**
 * @author Anyanwu Nicholas(codeBaron)
 * @since @since 10-09-2022
 * @see InternetConnectivityConfig
 * This function handles getting network state result and updating the UI
 */
class InternetConfigViewModel:  ViewModel() {

    companion object {
        var internetConnectivityConfig: InternetConnectivityConfig? = null
        var internetConfigObject: MutableLiveData<InternetConnectionHandler<InternetConfigObject>>? = null
    }

    fun networkState(context: Context): MutableLiveData<InternetConnectionHandler<InternetConfigObject>>? {
        viewModelScope.launch {
            internetConnectivityConfig = InternetConnectivityConfig().networkInstance()
            internetConfigObject = internetConnectivityConfig?.internetConfig(context)
        }
        return internetConfigObject
    }
}