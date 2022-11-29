package ru.avacodo.lifehackstudiotesttask.presentation

import android.widget.ImageView
import coil.load
import coil.size.Scale
import coil.transform.RoundedCornersTransformation
import ru.avacodo.lifehackstudiotesttask.R

private const val BASE_IMAGE_URL = "https://lifehack.studio/test_task/"
private const val IMAGE_CORNER_RADIUS = 10f

fun ImageView.loadImage(imageUrl: String, isRoundedCornersRequired: Boolean = true) {
    this.load("$BASE_IMAGE_URL$imageUrl") {
        placeholder(R.drawable.ic_launcher_foreground)
        scale(Scale.FILL)
        if (isRoundedCornersRequired) {
            transformations(RoundedCornersTransformation(IMAGE_CORNER_RADIUS))
        }
        error(R.drawable.no_image)
    }
}