package com.example.jetbiz

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui. graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.jetbiz.ui.theme.JetBizTheme

@Composable
fun Portfolio(data: List<String>) {
    LazyColumn(horizontalAlignment = Alignment.CenterHorizontally, modifier = Modifier.padding(top = 10.dp)) {
        items(data) { i ->
            Surface(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(160.dp)
                    .padding(10.dp),
                border = BorderStroke(width = 1.dp, color = Color.DarkGray)
            ) {
                Column(horizontalAlignment = Alignment.CenterHorizontally) {
                    Text(
                        text = i,
                        textAlign = TextAlign.Center,
                        fontSize = 28.sp,
                        modifier = Modifier.padding(top = 5.dp)
                    )
                    Text("Some other text 1", modifier = Modifier.padding(top = 2.dp, bottom = 5.dp))
                    Text("Some other text 2", modifier = Modifier.padding(top = 2.dp, bottom = 5.dp))
                    Text("Some other text 3", modifier = Modifier.padding(top = 2.dp, bottom = 5.dp))
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PortfolioPreview() {
    JetBizTheme {
        Portfolio(data = listOf("lalala", "lololo"))
    }
}