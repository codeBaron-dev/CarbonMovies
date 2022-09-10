package com.codebaron.domain.utilities

/**
 * @param context
 * This function handles removing actionBars from activity/screens
 *//*

fun flagWindows(context: Activity) {
    context.window.setFlags(
        WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS,
        WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS
    )
}

@Composable
fun CustomMaterialDialog(
    title: String,
    message: String,
    positiveButtonText: String,
    negativeButtonText: String
) {
    val openDialog = remember { mutableStateOf(true) }
    if (openDialog.value) {
        AlertDialog(
            onDismissRequest = {
                // Dismiss the dialog when the user clicks outside the dialog or on the back
                // button. If you want to disable that functionality, simply use an empty
                // onCloseRequest.
                openDialog.value = false
            },
            title = {
                Text(
                    text = title,
                    fontFamily = FontFamily.Monospace,
                    fontWeight = FontWeight.Bold,
                    textAlign = TextAlign.Justify,
                    color = Color.White
                )
            },
            text = {
                Text(
                    text = message,
                    fontFamily = FontFamily.Monospace,
                    fontWeight = FontWeight.Bold,
                    textAlign = TextAlign.Justify,
                    color = Color.White
                )
            },
            confirmButton = {
                TextButton(
                    onClick = {
                        openDialog.value = false
                    }
                ) {
                    Text(
                        text = positiveButtonText,
                        fontFamily = FontFamily.Monospace,
                        fontWeight = FontWeight.Bold,
                        textAlign = TextAlign.Justify,
                        color = Color.White
                    )
                }
            },
            dismissButton = {
                TextButton(
                    onClick = {
                        openDialog.value = false
                    }
                ) {
                    Text(
                        text = negativeButtonText,
                        fontFamily = FontFamily.Monospace,
                        fontWeight = FontWeight.Bold,
                        textAlign = TextAlign.Justify,
                        color = Color.Red
                    )
                }
            },
            backgroundColor = Color.Black
        )
    }
}*/
