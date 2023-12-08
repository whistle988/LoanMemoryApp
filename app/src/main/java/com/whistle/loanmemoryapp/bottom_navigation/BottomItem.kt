package com.whistle.loanmemoryapp.bottom_navigation

import com.whistle.loanmemoryapp.R


enum class BottomItem(val route: String, val icon: Int, val title: String) {
    Home("home", R.drawable.ic_home, "Home"),
    Favorite("favorite", R.drawable.ic_book, "Favorite"),
    Profile("profile", R.drawable.ic_profile, "Profile")
}
