package com.example.codelab2

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.codelab2.ui.theme.CodeLab2Theme

class LejiGrid : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            CodeLab2Theme {
                Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background) {
                    val itemList = listOf(R.drawable.img1, R.drawable.img2, R.drawable.img4)
                    ImageGrid(itemList)
                }
            }
        }
    }
}

@Composable
fun ImageGrid(itemList: List<Int>) {
    val context = LocalContext.current
    LazyVerticalGrid(
        columns = GridCells.Fixed(2),
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.spacedBy(10.dp),
        horizontalArrangement = Arrangement.spacedBy(10.dp),
    ) {
        items(itemList) { item ->
            Image(
                painter = painterResource(id = item),
                contentDescription = null,
                modifier = Modifier
                    .fillMaxSize()
                    .padding(10.dp)
                    .clickable {
                        val index = itemList.indexOf(item) + 1
                        Toast.makeText(context, "Gambar ke-$index diklik", Toast.LENGTH_SHORT).show()
                    }
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    CodeLab2Theme {
        val itemList = listOf(R.drawable.img1, R.drawable.img2, R.drawable.img4)
        ImageGrid(itemList)
    }
}
