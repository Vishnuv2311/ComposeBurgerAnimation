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
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun BurgerSizeSelector(
    selectedSize: String,
    onSizeSelected: (String) -> Unit,
    modifier: Modifier = Modifier
) {

    val sizes = listOf("S", "M", "L")

    Row(
        horizontalArrangement = Arrangement.SpaceBetween,
        modifier = modifier
            .width(150.dp)
            .height(50.dp)
            .clip(RoundedCornerShape(30.dp))
            .background(Color(0xFFEEEEEE)),
        verticalAlignment = Alignment.CenterVertically
    ) {
        sizes.forEach { size ->
            ElevatedButton(
                onClick = { onSizeSelected(size) },
                elevation = ButtonDefaults.elevatedButtonElevation(0.dp),
                colors = ButtonDefaults.elevatedButtonColors(
                    if (selectedSize == size) Color.White else Color(
                        0xFFEEEEEE
                    )
                ),
                modifier = Modifier.size(40.dp),
                contentPadding = PaddingValues(0.dp),
                shape = CircleShape
            ) {
                Text(
                    size,
                    style = TextStyle(
                        fontSize = if (selectedSize == size) 15.sp else 14.sp,
                        color = Color.Black,
                        fontWeight = if (selectedSize == size) FontWeight.W600 else FontWeight.Normal
                    )
                )
            }
        }
    }

}

@Preview
@Composable
fun BurgerSizeSelectorPreview() {
    BurgerSizeSelector(selectedSize = "S", onSizeSelected = {})
}