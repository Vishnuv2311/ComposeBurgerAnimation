package dev.vishnuv.composeburgeranimation.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment.Companion.CenterVertically
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun BurgerQuantitySelector(
    quantity: Int,
    onIncrement: () -> Unit,
    onDecrement: () -> Unit,
    modifier: Modifier = Modifier
) {

    Row(
        modifier
            .width(140.dp)
            .height(50.dp)
            .clip(RoundedCornerShape(30.dp))
            .background(Color(0xFFEEEEEE)),
        verticalAlignment = CenterVertically,
        horizontalArrangement = Arrangement.SpaceAround
    ) {
        ElevatedButton(
            onClick = onDecrement,
            enabled = quantity > 0,
            shape = CircleShape,
            modifier = Modifier.size(40.dp),
            elevation = ButtonDefaults.elevatedButtonElevation(0.dp),
            colors = ButtonDefaults.elevatedButtonColors(containerColor = Color.White),
            contentPadding = PaddingValues(0.dp)
        ) {
            Text("-", style = TextStyle(fontSize = 21.sp, color = Color.Black))
        }
        Text(
            quantity.toString(),
            style = TextStyle(
                fontSize = 16.sp,
                color = Color(0xFF424242),
                fontWeight = FontWeight.W500
            )
        )
        ElevatedButton(
            onClick = onIncrement,
            enabled = quantity < 10,
            shape = CircleShape,
            modifier = Modifier.size(40.dp),
            elevation = ButtonDefaults.elevatedButtonElevation(0.dp),
            colors = ButtonDefaults.elevatedButtonColors(containerColor = Color.White),
            contentPadding = PaddingValues(0.dp)
        ) {
            Text("+", style = TextStyle(fontSize = 21.sp, color = Color.Black))
        }
    }

}

@Preview
@Composable
fun BurgerQuantitySelectorPreview() {
    BurgerQuantitySelector(quantity = 1, onIncrement = {}, onDecrement = {})
}