package com.codebaron.netflix

import android.os.Bundle
import android.view.WindowManager
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import com.codebaron.domain.internet.InternetConfigViewModel
import com.codebaron.domain.internet.handler.InternetConnectionHandler
import com.codebaron.netflix.navigation.ScreensNavigationManager
import com.codebaron.netflix.ui.theme.NetflixTheme
import dagger.hilt.android.AndroidEntryPoint

/**
 * @author Anyanwu Nicholas(codeBaron)
 * @since 10-09-2022
 */

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            NetflixTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    window.setFlags(
                        WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS,
                        WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS
                    )
                    NetworkState(mainActivity = this)
                }
            }
        }
    }
}

/**
 * @param mainActivity
 * @see InternetConfigViewModel
 * @see InternetConnectionHandler
 * This function handles network state observation and updates the UI
 */
@Composable
fun NetworkState(mainActivity: MainActivity) {
    val isNetworkAvailable = remember { mutableStateOf(false) }
    val internetConnectionViewModel = hiltViewModel<InternetConfigViewModel>()
    val state by internetConnectionViewModel.networkState(mainActivity)!!.observeAsState()
    when (state) {
        is InternetConnectionHandler.IsInternetAvailable -> {
            isNetworkAvailable.value = true
        }
        is InternetConnectionHandler.IsInternetConnectionTypeChanged -> {
            isNetworkAvailable.value = true
        }
        is InternetConnectionHandler.IsInternetConnectionLost -> {
            isNetworkAvailable.value = false
            Toast.makeText(mainActivity, "Internet disconnected", Toast.LENGTH_SHORT).show()
        }
    }
    ScreensNavigationManager(mainActivity, isNetworkAvailable.value)
}