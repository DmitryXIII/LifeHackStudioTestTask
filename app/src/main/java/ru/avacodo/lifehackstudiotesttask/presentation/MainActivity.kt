package ru.avacodo.lifehackstudiotesttask.presentation

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import ru.avacodo.lifehackstudiotesttask.R
import ru.avacodo.lifehackstudiotesttask.presentation.core.NavigationFragmentHolder
import ru.avacodo.lifehackstudiotesttask.presentation.navigation.NavigationFragment

private const val NAVIGATION_FRAGMENT_TAG = "ROUTER"

class MainActivity : AppCompatActivity(), NavigationFragmentHolder {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        if (savedInstanceState == null) {
            supportFragmentManager
                .beginTransaction()
                .replace(R.id.main_container, NavigationFragment(), NAVIGATION_FRAGMENT_TAG)
                .commit()
        }
    }

    override fun getNavigationFragmentTag(): String {
        return NAVIGATION_FRAGMENT_TAG
    }
}