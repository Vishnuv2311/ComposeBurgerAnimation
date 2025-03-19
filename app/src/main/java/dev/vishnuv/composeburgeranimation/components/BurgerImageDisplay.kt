package dev.vishnuv.composeburgeranimation.components

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.animation.slideInVertically
import androidx.compose.animation.slideOutVertically
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import dev.vishnuv.composeburgeranimation.R

@Composable
fun BurgerImageDisplay(
    selectedSize: String,
    selectedType: String,
    modifier: Modifier = Modifier
) {

    val configuration = LocalConfiguration.current
    val screenWidth = configuration.screenWidthDp.dp


    val tomatoWithPattyPosition by animateDpAsState(targetValue = if (selectedSize == "L") 170.dp else if (selectedSize == "M") 120.dp else 70.dp)
    val parttyLeftPosition by animateDpAsState(targetValue = if (selectedSize == "L") 120.dp else 70.dp)
    val bottomBunPosition by animateDpAsState(targetValue = if (selectedSize == "L") 260.dp else if (selectedSize == "M") 210.dp else 160.dp)


    val rotationAnimationSpec = tween<Float>(delayMillis = 200)
    val translateAnimationSpec = tween<Dp>(delayMillis = 200)

    val blackBunHorizontalPosition by animateDpAsState(
        targetValue = if (selectedType == "Black") 0.dp else screenWidth,
        animationSpec = translateAnimationSpec
    )
    val whiteBunHorizontalPosition by animateDpAsState(
        targetValue = if (selectedType == "White") 0.dp else -screenWidth,
        animationSpec = translateAnimationSpec
    )

    val blackBunRotation by animateFloatAsState(
        targetValue = if (selectedType == "Black") 0f else 100f,
        animationSpec = rotationAnimationSpec
    )
    val whiteBunRotation by animateFloatAsState(
        targetValue = if (selectedType == "White") 0f else 100f,
        animationSpec = rotationAnimationSpec
    )



    Box(modifier.fillMaxSize(), contentAlignment = Alignment.TopCenter) {


        //Black Bun
        Image(
            painter = painterResource(id = R.drawable.black_bun_bottom),
            contentDescription = "Bun",
            modifier = Modifier
                .offset(y = bottomBunPosition + 18.dp, x = blackBunHorizontalPosition)
                .rotate(-blackBunRotation)
        )

        //White Bun
        Image(
            painter = painterResource(id = R.drawable.white_bun_bottom),
            contentDescription = "Bun",
            modifier = Modifier
                .offset(y = bottomBunPosition, x = whiteBunHorizontalPosition)
                .rotate(-whiteBunRotation)
        )
        Image(
            painter = painterResource(R.drawable.tomato_with_patty),
            contentDescription = "Bun",
            contentScale = ContentScale.FillWidth,
            modifier = Modifier
                .offset(y = tomatoWithPattyPosition)
                .width(270.dp)
        )



        AnimatedVisibility(
            selectedSize == "L" || selectedSize == "M",
            enter = slideInVertically(),
            exit = slideOutVertically()
        ) {
            Image(
                painter = painterResource(R.drawable.patty_left),
                contentDescription = "Bun",
                contentScale = ContentScale.FillWidth,
                modifier = Modifier
                    .offset(y = parttyLeftPosition)
                    .width(270.dp)

            )
        }

        AnimatedVisibility(
            selectedSize == "L",
            enter = slideInVertically(),
            exit = slideOutVertically()
        ) {
            Image(
                painter = painterResource(R.drawable.patty_right), contentDescription = "Bun",
                contentScale = ContentScale.FillWidth,
                modifier = Modifier
                    .offset(y = 70.dp)
                    .width(270.dp)

            )
        }

        //Black Bun Top
        Image(
            painter = painterResource(id = R.drawable.black_bun_top),
            contentDescription = "Bun",
            modifier = Modifier
                .offset(y = 0.dp, x = blackBunHorizontalPosition)
                .rotate(blackBunRotation)
        )

        //White Bun Top
        Image(
            painter = painterResource(id = R.drawable.white_bun_top),
            contentDescription = "Bun",
            modifier = Modifier
                .offset(y = 0.dp, x = whiteBunHorizontalPosition)
                .rotate(whiteBunRotation)
        )


    }


}

@Preview
@Composable
private fun BurgerImageDisplayPreview() {
    BurgerImageDisplay(selectedSize = "L", selectedType = "Black")
}