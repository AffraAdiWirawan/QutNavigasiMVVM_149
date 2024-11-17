package com.example.pertemuan6.ui.view

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.modifier.modifierLocalMapOf
import androidx.compose.ui.unit.dp
import com.example.pertemuan6.model.Mahasiswa


@Composable
fun TampilMahasiswa(
    mhs:Mahasiswa
){
    Column(modifier = Modifier.fillMaxSize()){
        TampilData(
            param = "Nama",
            argu = mhs.nama
        )
        TampilData(
            param = "Gender",
            argu = mhs.gender
        )
        TampilData(
            param = "NIM",
            argu = mhs.nim
        )
        TampilData(
            param = "Alamat",
            argu = mhs.alamat
        )
    }
}

