package com.example.encodeurdecodeur

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.tooling.preview.Preview

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CesarCipherApp()
        }
    }
}

@Composable
fun CesarCipherApp() {
    var texte by remember { mutableStateOf("") }
    var decalage by remember { mutableStateOf("3") }
    var resultat by remember { mutableStateOf("") }

    Column(modifier = Modifier.padding(16.dp)) {
        Text("Encodeur et Décodeur de César", style = MaterialTheme.typography.headlineSmall)

        Spacer(modifier = Modifier.height(16.dp))

        TextField(
            value = texte,
            onValueChange = { texte = it },
            modifier = Modifier.fillMaxWidth(),


        )

        Spacer(modifier = Modifier.height(8.dp))

        TextField(
            value = decalage,
            onValueChange = { decalage = it },
            modifier = Modifier.fillMaxWidth()

        )
        Spacer(modifier = Modifier.height(16.dp))

        Button(onClick = {
            val shift = decalage.toIntOrNull() ?: 3
            resultat = CesarCipher.encoder(texte, shift)
        },
            modifier = Modifier.fillMaxWidth()) {
            Text("Encoder")
        }

        Button(onClick = {
            val shift = decalage.toIntOrNull() ?: 3
            resultat = CesarCipher.decoder(texte, shift)
        },
            modifier = Modifier.fillMaxWidth()) {
            Text("Décoder")
        }

        Spacer(modifier = Modifier.height(16.dp))

        Text("Résultat : $resultat", style = MaterialTheme.typography.bodyLarge)
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    CesarCipherApp()
}
