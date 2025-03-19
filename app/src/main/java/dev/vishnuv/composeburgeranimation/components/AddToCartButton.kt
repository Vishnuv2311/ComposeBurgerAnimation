package dev.vishnuv.composeburgeranimation.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
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
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun AddToCartButton(price: Double, onClick: () -> Unit, modifier: Modifier = Modifier) {
    Row(
        modifier
            .height(55.dp)
            .clip(RoundedCornerShape(30.dp))
            .background(Color(0xFFEEEEEE)),
        verticalAlignment = Alignment.CenterVertically

    ) {
        ElevatedButton(
            onClick = onClick,
            shape = RoundedCornerShape(25.dp),
            elevation = ButtonDefaults.elevatedButtonElevation(0.dp),
            colors = ButtonDefaults.elevatedButtonColors(containerColor = Color.Black),
            modifier = Modifier
                .weight(1f)
                .padding(8.dp)
        ) {
            Text(
                text = "Add to Cart",
                style = TextStyle(
                    fontSize = 15.sp,
//                    fontFamily = poppinsFontFamily,
                    fontWeight = FontWeight.W600, color = Color.White
                ),

                )
        }

        Text(
            text = "$${String.format("%.2f", price)}",
            textAlign = TextAlign.Center,
            style = TextStyle(
                color = Color.Black,
                fontSize = 16.sp,
//                fontFamily = poppinsFontFamily,
                fontWeight = FontWeight.W600
            ),
            modifier = Modifier
                .weight(1f)
        )
    }
}


@Preview
@Composable
fun AddToCartButtonPreview() {
    AddToCartButton(price = 3.3, onClick = {})
}