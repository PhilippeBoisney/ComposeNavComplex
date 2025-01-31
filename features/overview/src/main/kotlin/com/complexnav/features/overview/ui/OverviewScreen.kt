package com.complexnav.features.overview.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.complexnav.navigation.NavigableGraph
import com.complexnav.navigation.OnNavigateTo

@Composable
internal fun OverviewScreen(onNavigate: OnNavigateTo) {
    Column(
        modifier =
        Modifier
            .fillMaxSize()
            .background(Color(0xFFD8EFD3)),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
    ) {
        Text(
            text = "Overview Screen",
            style = MaterialTheme.typography.headlineLarge,
            fontWeight = FontWeight.Bold,
            color = Color.White,
        )
        Spacer(modifier = Modifier.height(16.dp))
        Button(onClick = {
            onNavigate(NavigableGraph.Onboarding) {
                launchSingleTop = true
            }
        }) {
            Text("Onboarding")
        }
    }
}

@Preview
@Composable
fun OverviewScreenPreview() {
    Surface {
        OverviewScreen(onNavigate = { _, _ -> })
    }
}
