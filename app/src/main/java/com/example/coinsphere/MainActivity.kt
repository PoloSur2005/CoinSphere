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
import androidx.compose.ui.layout.ContentScale
import coil3.compose.AsyncImage


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
        Triple("Bitcoin", "$109,797.37", "https://dynamic-assets.coinbase.com/e785e0181f1a23a30d9476038d9be91e9f6c63959b538eabbc51a1abc8898940383291eede695c3b8dfaa1829a9b57f5a2d0a16b0523580346c6b8fab67af14b/asset_icons/b57ac673f06a4b0338a596817eb0a50ce16e2059f327dc117744449a47915cb2.png"),
        Triple("Ethereum", "$4,321.21", "https://dynamic-assets.coinbase.com/dbb4b4983bde81309ddab83eb598358eb44375b930b94687ebe38bc22e52c3b2125258ffb8477a5ef22e33d6bd72e32a506c391caa13af64c00e46613c3e5806/asset_icons/4113b082d21cc5fab17fc8f2d19fb996165bcce635e6900f7fc2d57c4ef33ae9.png"),
        Triple("Tether", "$1.0000", "https://dynamic-assets.coinbase.com/41f6a93a3a222078c939115fc304a67c384886b7a9e6c15dcbfa6519dc45f6bb4a586e9c48535d099efa596dbf8a9dd72b05815bcd32ac650c50abb5391a5bd0/asset_icons/1f8489bb280fb0a0fd643c1161312ba49655040e9aaaced5f9ad3eeaf868eadc.png"),
        Triple("XRP", "$2.8100", "https://dynamic-assets.coinbase.com/e81509d2307f706f3a6f8999968874b50b628634abf5154fc91a7e5f7685d496a33acb4cde02265ed6f54b0a08fa54912208516e956bc5f0ffd1c9c2634099ae/asset_icons/3af4b33bde3012fd29dd1366b0ad737660f24acc91750ee30a034a0679256d0b.png"),
        Triple("BNB", "$845.0000", "https://dynamic-assets.coinbase.com/36f266bc4826775268588346777c84c1ae035e7de268a6e124bcc22659f0aa2bf4f66dcad89b2ac978cfdb4d51c2d9f63cf7157769efb500b20ca16a6d5719c7/asset_icons/7deb6ff58870072405c0418d85501c4521c3296e33ef58452be98e4ca592ed19.png"),
        Triple("Solana", "$201.8500", "https://s2.coinmarketcap.com/static/img/coins/64x64/5426.png"),
        Triple("USDC", "$0.9998", "https://dynamic-assets.coinbase.com/3c15df5e2ac7d4abbe9499ed9335041f00c620f28e8de2f93474a9f432058742cdf4674bd43f309e69778a26969372310135be97eb183d91c492154176d455b8/asset_icons/9d67b728b6c8f457717154b3a35f9ddc702eae7e76c4684ee39302c4d7fd0bb8.png"),
        Triple("Dogecoin", "$0.1320", "https://dynamic-assets.coinbase.com/3803f30367bb3972e192cd3fdd2230cd37e6d468eab12575a859229b20f12ff9c994d2c86ccd7bf9bc258e9bd5e46c5254283182f70caf4bd02cc4f8e3890d82/asset_icons/1597d628dd19b7885433a2ac2d7de6ad196c519aeab4bfe679706aacbf1df78a.png"),
        Triple("TRON", "$0.3630", "https://dynamic-assets.coinbase.com/49567ec5f7c7a1ccb3ce247297c443b3dd32072ee5b91902abc0f6789654e14fd3b9ed8851580b93b4daf7da13324bc61e143a2d391d9e6d8b98f8d69923e4b4/asset_icons/3c5b36c70a05bad40eee4f711aeefbb1809169a17db047bf91f1ef45828349e5.png")
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
            itemsIndexed(cryptoList) { index, (name, price, imageUrl) ->
                CryptoListItem(index + 1, name, price, imageUrl)
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
    price: String,
    imageUrl: String
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

        AsyncImage(
            model = imageUrl,
            contentDescription = "$name icon",
            modifier = Modifier
                .size(30.dp)
                .padding(end = 8.dp),
            contentScale = ContentScale.Fit
        )

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
