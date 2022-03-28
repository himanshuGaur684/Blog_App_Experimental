package com.gaur.blogapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.gaur.blogapp.navigation.NavigationItem
import com.gaur.blogapp.screens.details.DetailsScreen
import com.gaur.blogapp.screens.home.HomeScreen
import com.gaur.blogapp.ui.theme.BlogAppTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BlogAppTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    MyApp {
                        val navController = rememberNavController()
                        NavHost(
                            navController = navController,
                            startDestination = NavigationItem.Home.route
                        ) {
                            composable(NavigationItem.Home.route) {
                                HomeScreen(navController = navController)
                            }
                            composable(
                                NavigationItem.BlogDetails.route,
                                arguments = listOf(navArgument("blogId") { type = NavType.StringType })
                            ) {
                                val id = navController.currentBackStackEntry?.arguments?.getString("blogId")
                                 DetailsScreen(id = id.toString(), viewModel = hiltViewModel())
                            }
                        }

                    }
                }
            }
        }
    }
}


@Composable
fun MyApp(content: @Composable () -> Unit) {
    content()

}

