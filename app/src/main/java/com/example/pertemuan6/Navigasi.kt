package com.example.pertemuan6

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.pertemuan6.ui.viewmodel.MahasiswaViewModel
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.pertemuan6.model.DataJK
import com.example.pertemuan6.ui.view.FormulirView
import com.example.pertemuan6.ui.view.TampilData
import com.example.pertemuan6.ui.view.TampilMahasiswa
import java.text.Normalizer.Form


enum class halaman {
    Form,
    Data,
}

@Composable
fun Navigasi(
    modifier: Modifier = Modifier,
    viewModel: MahasiswaViewModel = viewModel(),
    navHost: NavHostController = rememberNavController(),
) {
    Scaffold { isipadding ->
        val uiState by viewModel.uistate.collectAsState()

        NavHost(modifier = Modifier.padding(isipadding),
            navController = navHost, startDestination = halaman.Form.name
        ) {

            composable(route = halaman.Form.name){
                val konteks = LocalContext.current
                FormulirView(
                    pilihanJk = DataJK.isiJk.map{
                        isi -> konteks.resources.getString(isi)
                    },
                    onClickButton = {
                        viewModel.saveDataMahasiswa(it)
                        navHost.navigate(halaman.Data.name)
                    }
                )
            }
            composable(route = halaman.Data.name){
                TampilMahasiswa(
                    mhs = uiState
                )
            }
        }
    }

}
