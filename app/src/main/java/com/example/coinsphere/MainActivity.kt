package com.example.coinsphere

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.coinsphere.ui.theme.CoinSphereTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            CoinSphereTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    CoinSphereHomeScreen(modifier = Modifier.padding(innerPadding))
                }
            }
        }
    }
}

// Colores
val Background     = Color(0xFF0B1020)
val Surface        = Color(0xFF151B2E)
val TextMain       = Color(0xFFE8ECF8)
val TextDim        = Color(0xFF9AA3B2)

// Pantalla Principal

@Composable
fun CoinSphereHomeScreen(modifier: Modifier = Modifier) {
    val cryptoList = listOf(
        "Bitcoin" to "$109,797.37",
        "Ethereum" to "$4,321.21",
        "Tether" to "$1.0000",
        "XRP" to "$2.8100",
        "BNB" to "$845.0000",
        "Solana" to "$201.8500",
        "USDC" to "$0.9998",
        "Dogecoin" to "$0.1320",
        "TRON" to "$0.3630"
    )

    Column(
        modifier = modifier
            .fillMaxSize()
            .background(Background)
            .padding(16.dp)
    ) {
        Text(
            text = "CoinSphere",
            color = TextMain,
            style = MaterialTheme.typography.headlineMedium
        )

        Spacer(modifier = Modifier.height(16.dp))

        InfoCard("Global Market Cap", "$2.18T")
        InfoCard("Fear & Greed", "Neutral (54)")
        InfoCard("Altcoin Season", "No")

        Spacer(modifier = Modifier.height(16.dp))

        LazyColumn {
            itemsIndexed(cryptoList) { index, (name, price) ->
                CryptoListItem(index + 1, name, price)
            }
        }
    }
}

@Composable
fun InfoCard(title: String, value: String) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 4.dp)
            .background(Surface, shape = RoundedCornerShape(12.dp))
            .padding(16.dp)
    ) {
        Column {
            Text(title, color = TextDim, style = MaterialTheme.typography.labelSmall)
            Text(value, color = TextMain, style = MaterialTheme.typography.titleMedium)
        }
    }
}

//Criptomonedas :v

@Composable
fun CryptoListItem(
    number: Int,
    name: String,
    price: String
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 4.dp)
            .background(Surface, shape = RoundedCornerShape(8.dp))
            .padding(12.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text("#$number", color = TextDim, modifier = Modifier.width(32.dp))
        Text(name, color = TextMain, modifier = Modifier.weight(1f))
        Text(price, color = TextMain)
    }
}

@Preview(showBackground = true)
@Composable
fun CoinSpherePreview() {
    CoinSphereTheme {
        CoinSphereHomeScreen()
    }
}
