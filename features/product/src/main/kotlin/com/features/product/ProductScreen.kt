package com.features.product

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.complexnav.navigation.OnNavigateTo
import com.complexnav.navigation.PreviousScreen

@Composable
internal fun ProductScreen(
    productName: String,
    onNavigate: OnNavigateTo,
) {
    Column(
        modifier =
        Modifier
            .fillMaxSize()
            .background(Color(0xFFD0BCFF)),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
    ) {
        Text(
            text = "This product name is $productName",
            style = MaterialTheme.typography.headlineLarge,
            fontWeight = FontWeight.Bold,
            color = Color.White,
            textAlign = TextAlign.Center,
            modifier = Modifier.padding(16.dp),
        )
        Spacer(modifier = Modifier.height(16.dp))
        Button(onClick = {
            onNavigate(PreviousScreen) {}
        }) {
            Text("Back")
        }
    }
}

@Preview
@Composable
fun ProductScreenPreview() {
    Surface {
        ProductScreen(productName = "Toto", onNavigate = { _, _ -> })
    }
}
