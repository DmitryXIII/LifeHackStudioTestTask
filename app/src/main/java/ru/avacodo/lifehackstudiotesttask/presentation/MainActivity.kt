package ru.avacodo.lifehackstudiotesttask.presentation

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import ru.avacodo.lifehackstudiotesttask.R
import ru.avacodo.lifehackstudiotesttask.presentation.core.NavigationFragmentHolder
import ru.avacodo.lifehackstudiotesttask.presentation.core.SplashScreenKeeper
import ru.avacodo.lifehackstudiotesttask.presentation.navigation.NavigationFragment

/**
 * created by Avacodo 30.11.2022
 * 1) Ошибку, возникающую при получении данных о компаниях 6 и 7, видел -
 * в исходном json'е в объекте description прилетает лишняя кавычка,
 * которая крашит конвертацию из json.
 * Сходу не придумал, как в ответе сервера эту кавычку удалить, поэтому ошибка поймана и
 * (для экономии времени на отправку задания) обработана как ошибка на стороне сервера.
 * Но буду разбираться - кейс интересный, как в рантайме перед началом конвертации заменять символы
 * в ответе сервера.
 *
 * 2) Для корректного отображения splash screen приложение необходимо запускать с утсройства
 * (при запуске из студии гугловый сплэш показывает только фон, иконка не отображается)
 */

private const val NAVIGATION_FRAGMENT_TAG = "ROUTER"

class MainActivity : AppCompatActivity(), NavigationFragmentHolder, SplashScreenKeeper {
    private var isSplashScreenKeeping = true

    override fun onCreate(savedInstanceState: Bundle?) {
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
        installSplashScreen().apply {
            setKeepOnScreenCondition { isSplashScreenKeeping }
        }
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

    override fun hideSplashScreen() {
        isSplashScreenKeeping = false
    }
}