package com.example.encodeurdecodeur

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.tooling.preview.Preview

class MainActivity : ComponentActivity() {
    @SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
                Scaffold(
                    topBar = {
                        TopAppBar(
                            title = { Text("Encodeur De Cesar") },
                        )
                    }
                ) {
                    CesarCipherApp()

                    }
                }
            }

        }



@Composable
fun CesarCipherApp() {
    var texte by remember { mutableStateOf("") }
    var decalage by remember { mutableStateOf("3") }
    var resultat by remember { mutableStateOf("") }

    Column(

        modifier = Modifier.padding(16.dp)) {
        Text("Encodeur et Décodeur de César", style = MaterialTheme.typography.headlineSmall)

        Spacer(modifier = Modifier.height(16.dp))

        TextField(
            value = texte,
            onValueChange = { texte = it },
            label = {Text("Entrez le text a coder")},
            modifier  = Modifier.width(200.dp).align(Alignment.CenterHorizontally)

        )

        Spacer(modifier = Modifier.height(8.dp))

        TextField(
            value = decalage,
            onValueChange = { decalage = it },
            label = {Text("Decalage")},
            modifier  = Modifier.width(200.dp).align(Alignment.CenterHorizontally)
            ,


        )
        Spacer(modifier = Modifier.height(16.dp))

        Row(modifier = Modifier.align(Alignment.CenterHorizontally)){
        Button(onClick = {
            val shift = decalage.toIntOrNull() ?: 3
            resultat = CesarCipher.encoder(texte, shift)
        },
            modifier = Modifier.width(100.dp)) {
            Text("Encoder")
        }
        Spacer(modifier = Modifier.width(16.dp))

        Button(onClick = {
            val shift = decalage.toIntOrNull() ?: 3
            resultat = CesarCipher.decoder(texte, shift)
        },
            modifier = Modifier.width(100.dp)
            ) {
            Text("Décoder")
        }
        }

        Spacer(modifier = Modifier.height(16.dp))

        Text("Résultat : $resultat", style = MaterialTheme.typography.bodyLarge, modifier = Modifier.fillMaxWidth().align(Alignment.CenterHorizontally))

    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    CesarCipherApp()
}
