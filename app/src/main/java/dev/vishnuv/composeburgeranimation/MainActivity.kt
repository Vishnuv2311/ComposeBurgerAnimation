package dev.vishnuv.composeburgeranimation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import dev.vishnuv.composeburgeranimation.screens.BurgerDetailsScreen
import dev.vishnuv.composeburgeranimation.ui.theme.ComposeBurgerAnimationTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ComposeBurgerAnimationTheme {
                BurgerDetailsScreen()
            }
        }
    }
}
