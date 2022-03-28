package com.gaur.blogapp.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Face
import androidx.compose.material.icons.filled.Home
import androidx.compose.ui.graphics.vector.ImageVector

sealed class NavigationItem(val route:String,val icons:ImageVector?=null){

    object Home : NavigationItem(route="Home", Icons.Default.Home)
    object BlogDetails: NavigationItem(route="blog_details/{blogId}",Icons.Default.Face)

}
