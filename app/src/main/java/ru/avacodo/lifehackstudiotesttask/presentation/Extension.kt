package ru.avacodo.lifehackstudiotesttask.presentation

import android.widget.ImageView
import coil.load
import coil.transform.RoundedCornersTransformation

private const val BASE_IMAGE_URL = "https://lifehack.studio/test_task/"
private const val IMAGE_CORNER_RADIUS = 4f

fun ImageView.loadImage(imageUrl: String) {
    this.load("$BASE_IMAGE_URL$imageUrl") {
        transformations(RoundedCornersTransformation(IMAGE_CORNER_RADIUS))
    }
}