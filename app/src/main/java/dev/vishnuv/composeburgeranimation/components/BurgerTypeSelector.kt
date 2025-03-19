package dev.vishnuv.composeburgeranimation.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
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
fun BurgerTypeSelector(
    selectedType: String,
    onTypeSelected: (String) -> Unit,
    modifier: Modifier = Modifier
) {

    val types = listOf("Black", "White")

    Row(
        horizontalArrangement = Arrangement.SpaceEvenly,
        verticalAlignment = Alignment.CenterVertically,
        modifier = modifier
            .width(160.dp)
            .height(50.dp)
            .clip(RoundedCornerShape(30.dp))
            .background(Color(0xFFEEEEEE))
    ) {
        types.forEach { type ->
            ElevatedButton(
                onClick = { onTypeSelected(type) },
                colors = ButtonDefaults.elevatedButtonColors(
                    containerColor =
                        if (selectedType == type) Color.White else Color(0xFFEEEEEE)
                ),
                contentPadding = PaddingValues(0.dp),
                shape = RoundedCornerShape(25.dp),
                modifier = Modifier.size(width = 70.dp, height = 40.dp),
                elevation = ButtonDefaults.elevatedButtonElevation(0.dp)
            ) {
                Text(
                    type,
                    style = TextStyle(
                        color = Color.Black,
                        fontSize = if (selectedType == type) 15.sp else 14.sp,
                        fontWeight = if (selectedType == type) FontWeight.W600 else FontWeight.Normal
                    )
                )
            }
        }
    }


}

@Preview
@Composable
fun BurgerTypeSelectorPreview() {
    BurgerTypeSelector(selectedType = "Black", onTypeSelected = {})
}