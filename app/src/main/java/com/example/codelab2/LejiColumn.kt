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
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.codelab2.ui.theme.CodeLab2Theme

class LejiColumn : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            val context = LocalContext.current
            val itemList = listOf(R.drawable.img1, R.drawable.img2, R.drawable.img4, R.drawable.img5, R.drawable.imgg)
            LazyColumn(Modifier.fillMaxWidth(), verticalArrangement = Arrangement.Center) {
                items(itemList){item ->
                    Image(painter = painterResource(id = item) , contentDescription =null,
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(10.dp)
                            .clickable {
                                val index = itemList.indexOf(item) + 1
                                if (index == 1) {
                                    Toast
                                        .makeText(context, "Air Terjun", Toast.LENGTH_SHORT)
                                        .show()
                                }
                                if (index == 2) {
                                    Toast
                                        .makeText(context, "Pegunungan Indah", Toast.LENGTH_SHORT)
                                        .show()
                                }
                                if (index == 3) {
                                    Toast
                                        .makeText(context, "Burung  ", Toast.LENGTH_SHORT)
                                        .show()
                                } else {
                                    Toast
                                        .makeText(context, "Error/ atmin malas menambahkan logika", Toast.LENGTH_SHORT)
                                        .show()
                                }

                            }
                    )

                }

            }
                }
            }
        }
