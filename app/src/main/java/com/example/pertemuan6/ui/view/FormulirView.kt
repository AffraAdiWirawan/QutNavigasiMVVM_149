package com.example.pertemuan6.ui.view

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.Card
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.key.Key
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.pertemuan6.model.DataJK

@Composable
fun FormulirView(modifier: Modifier = Modifier,
          pilihanJk: List<String>,
          onClickButton: (MutableList<String>) -> Unit
) {
    var nama by remember { mutableStateOf("") }
    var alamat by remember { mutableStateOf("") }
    var nim by remember { mutableStateOf("") }
    var gender by remember { mutableStateOf("") }
    val listdata : MutableList<String> = mutableListOf(nama,gender,alamat,nim)
    Column(modifier = modifier.fillMaxSize()
        .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally) {
        Text(
            text = "Biodata", fontWeight = FontWeight.Bold,
            fontSize = 28.sp
        )
        Spacer(modifier = Modifier.padding(20.dp))
        TextField(
            value = nama,
            onValueChange = { nama = it },
            label = {
                Text("Nama")
            },
            placeholder = {
                Text("Isi Nama Anda")
            },
            modifier = modifier.fillMaxWidth()
                .padding(5.dp)

        )
        Row (
            modifier = Modifier.fillMaxWidth()) {       //mengganti variabel modifier dengan Modifier
            pilihanJk.forEach(){ selectedGender ->
                Row (verticalAlignment = Alignment.CenterVertically) {
                    RadioButton(
                        selected = gender == selectedGender,
                        onClick = {
                            gender = selectedGender
                        })
                }
                Text(text = selectedGender) }
        }
        TextField(
            value = nim,
            onValueChange = { nim = it },
            label = {
                Text("NIM")
            },
            placeholder = {
                Text("Isi NIM Anda")
            },
            modifier = modifier.fillMaxWidth()
                .padding(5.dp)

        )
        TextField(
            value = alamat,
            onValueChange = { alamat = it },
            label = {
                Text("Alamat")
            },
            placeholder = {
                Text("Isi Alamat Anda")
            },
            modifier = modifier.fillMaxWidth()
                .padding(5.dp)

        )
        Button(
            onClick = {
                onClickButton(listdata)
            },
            modifier = Modifier.padding(vertical = 10.dp)) {
            Text("Simpan")
        }

    }

}

