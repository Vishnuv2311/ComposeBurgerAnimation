package dev.vishnuv.composeburgeranimation.screens


import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import dev.vishnuv.composeburgeranimation.components.AddToCartButton
import dev.vishnuv.composeburgeranimation.components.BurgerImageDisplay
import dev.vishnuv.composeburgeranimation.components.BurgerQuantitySelector
import dev.vishnuv.composeburgeranimation.components.BurgerSizeSelector
import dev.vishnuv.composeburgeranimation.components.BurgerTypeSelector

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BurgerDetailsScreen(modifier: Modifier = Modifier) {


    var selectedSize by remember { mutableStateOf("S") }
    var selectedType by remember { mutableStateOf("White") }
    var quantity by remember { mutableIntStateOf(1) }

    Scaffold(topBar = {
        TopAppBar(
            title = { Text("Cheeseburger", modifier.fillMaxWidth(), textAlign = TextAlign.Center) },
            navigationIcon = { Icon(Icons.Default.ArrowBack, contentDescription = "Back") },
            actions = { Icon(Icons.Default.FavoriteBorder, contentDescription = "Add to Fav") }
        )
    }) { innerPadding ->
        Column(
            modifier
                .padding(innerPadding)
                .fillMaxSize()
                .padding(horizontal = 16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            Spacer(Modifier.height(30.dp))
            Row(
                horizontalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier.fillMaxWidth()
            ) {
                BurgerSizeSelector(
                    selectedSize = selectedSize,
                    onSizeSelected = { size -> selectedSize = size })

                BurgerTypeSelector(
                    selectedType = selectedType,
                    onTypeSelected = { type -> selectedType = type })
            }
            Spacer(Modifier.height(50.dp))
            Box(modifier = Modifier.weight(1f)) {
                BurgerImageDisplay(
                    selectedSize = selectedSize,
                    selectedType = selectedType
                )
            }

            BurgerQuantitySelector(
                quantity = quantity,
                onIncrement = { if (quantity < 10) quantity++ },
                onDecrement = { if (quantity > 0) quantity-- },
            )
            Spacer(Modifier.height(30.dp))

            AddToCartButton(price = 10.40, onClick = {})

            Spacer(Modifier.height(20.dp))


        }
    }


}

@Preview
@Composable
private fun BurgerDetailsScreenPreview() {
    BurgerDetailsScreen()
}