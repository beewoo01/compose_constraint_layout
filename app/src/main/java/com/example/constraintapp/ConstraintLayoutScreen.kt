package com.example.constraintapp

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout

@Composable
fun ConstraintLayoutScreen() {
    ConstraintLayout(modifier = Modifier.fillMaxWidth()) {
        // 1- Define the
        val (box1, box2, text) = createRefs()


        val guideLine1 = createGuidelineFromStart(0.15f)


        Box(
            modifier = Modifier
                .size(100.dp)
                .background(Color.Red)
                .constrainAs(box1) {
                    top.linkTo(parent.top, margin = 100.dp)
                    start.linkTo(guideLine1, margin = 40.dp)

                }
        )

        Box(
            modifier = Modifier
                .size(250.dp)
                .background(Color.Green)
                .constrainAs(box2) {
                    top.linkTo(box1.bottom, margin = 20.dp)
                    start.linkTo(guideLine1)
                }
        )

        Text(
            text = "Hello Constraint Layout",
            modifier = Modifier.constrainAs(text) {
                top.linkTo(box2.bottom, margin = 16.dp)
                start.linkTo(guideLine1)
            })

    }
}