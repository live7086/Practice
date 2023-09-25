package com.example.practice

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CardDefaults.cardElevation
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.practice.ui.theme.PracticeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PracticeTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    CreateCard()
                }
            }
        }
    }
}


@Preview
@Composable
fun Content() {
    Box (modifier = Modifier
        .fillMaxHeight()
        .fillMaxWidth()
        .padding(5.dp)) {
        Surface (
            modifier = Modifier
                .padding(3.dp)
                .fillMaxWidth()
                .fillMaxHeight(),
            shape = RoundedCornerShape(corner = CornerSize(5.dp)),
            border = BorderStroke(width =5.dp, color = Color.LightGray)
        ) {

            Portfolio(data = listOf("Project1","Project2","Project3","Project3","Project3","Project3"))

        }
    }
}

@Composable
fun Portfolio(data: List<String>) {
    LazyColumn{
        items(data){
            Box {
                Image(
                    painter = painterResource(id = R.drawable.swish2),
                    contentDescription ="",
                    modifier = Modifier.fillMaxWidth().height(200.dp))
            }
        }
    }
}

@Composable
fun CreateCard () {
    val btnState = remember {
        mutableStateOf(false)
    }
    Surface (
        modifier = Modifier
            .fillMaxHeight()
            .fillMaxWidth()
    ) {
        Box{
            Column {
                Card (
                    modifier = Modifier
                        .fillMaxWidth(1f)
                        .fillMaxHeight(0.5f)
                        .padding(10.dp),
//                        .clickable {}
                    colors = CardDefaults.cardColors(containerColor = Color.LightGray),
                    elevation = cardElevation(10.dp),
                ) {
                    Image(painter = painterResource(
                        id = R.drawable.normal_failure),
                        contentDescription ="",
//                        modifier =Modifier.fillMaxSize(),
                        contentScale = ContentScale.Crop,
                        )
                }
                Button(onClick = { btnState.value= !btnState.value }) {
                    Text(text = "Click Me", style = androidx.compose.material.MaterialTheme.typography.button)
                }

                if(btnState.value){
                        Content()
                }else{
                    Box {

                    }
                }

                Card (
                    modifier = Modifier
                        .fillMaxWidth(1f)
                        .fillMaxHeight(1f)
                        .padding(10.dp),
                    colors = CardDefaults.cardColors(containerColor = Color.LightGray),
                    elevation = cardElevation(10.dp)
                ) {

                }

            }
        }

    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview(){
    PracticeTheme {
        CreateCard()

    }
}