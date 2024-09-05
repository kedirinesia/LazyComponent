package com.example.codelab2

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

class LejiRow : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            bodyRow()
            //LazyRoww()
        }
    }
}


data class BodyItem(val drawable: Int, val text: String)

val BodyData = listOf(
    BodyItem(R.drawable.img1, "Gambar 1"),
    BodyItem(R.drawable.imgg, "Gambar 2"),
    BodyItem(R.drawable.img4, "Gambar 3"),
    BodyItem(R.drawable.img5, "Gambar 4"),

    )
data class FotoItem(val drawable: Int, val text: String)
val foto = listOf(
   FotoItem(R.drawable.nature, "Gambar 1"),
    FotoItem(R.drawable.imgg, "Foto 2"),
    FotoItem(R.drawable.imgg6, "")
)

@Composable
fun bodyRow(
    modifier: Modifier = Modifier,
) {

    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxSize()
            .padding(8.dp)
    ) {
        LazyRow(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(8.dp),
            modifier = modifier
        ) {
            items(BodyData) { item ->
                BodyElement(item.drawable, item.text)
            }
        }

        LazyRow {

        }

    }
}



@Composable
fun BodyElement(drawable: Int, text: String) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .padding(8.dp)
            .width(200.dp)
    ) {
        Image(painter = painterResource(id = drawable), contentDescription = null)
        Text(text = text)
    }
}


@Composable
fun LazyRoww() {
    val itemsList = listOf("Item 1", "Item 2", "Item 3", "Item 4", "Item 5")





    LazyRow(


    ) {
        items(itemsList) { item ->
            Text(text = item)

        }
    }
}


@Preview
@Composable
fun LazyRowwPreview() {
    bodyRow()
}