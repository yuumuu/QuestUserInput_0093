package com.example.pertemuan5

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.selection.selectable
import androidx.compose.material3.Button
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp

@Composable
fun FormDataDiri(modifier: Modifier) {
    // variabel-variabel untuk mengingat nilai masukan dari keyboard
    var textNama by remember { mutableStateOf("") }
    var textAlamat by remember { mutableStateOf("") }
    var textGender by remember { mutableStateOf("") }
    val genderList: List<String> = listOf("Laki-laki", "Perempuan")

    // variabel-variabel untuk menyimpan data yang diperoleh dari komponen UI
    var nama by remember {mutableStateOf("")}
    var alamat by remember {mutableStateOf("")}
    var gender by remember {mutableStateOf("")}

    Column(modifier = Modifier.padding(top = 50.dp),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally) {
        OutlinedTextField(
            value = textNama,
            singleLine = true,
            shape = MaterialTheme.shapes.large,
            modifier = Modifier.width(250.dp),
            label = { Text("Nama Lengkap") },
            onValueChange = {
                textNama = it
            }
        )
        Row {
            genderList.forEach { item ->
                Row(modifier = Modifier.selectable(
                    selected = textGender == item,
                    onClick = {textGender = item}
                ), verticalAlignment = Alignment.CenterVertically) {
                    RadioButton(
                        selected = textGender == item,
                        onClick = {
                            textGender = item
                        })
                    Text(item)
                }
            }
        }

        OutlinedTextField(
            value = textAlamat,
            singleLine = false,
            modifier = Modifier.width(250.dp),
            label = {Text("Alamat")},
            onValueChange = {
                textAlamat = it
            }
        )

        HorizontalDivider(
            modifier = Modifier.padding(
                bottom = dimensionResource(R.dimen.p_md),
                top = dimensionResource(R.dimen.p_md)
            ),
            thickness = dimensionResource(R.dimen.div_height),
            color = Color.DarkGray
        )

        Button(
            modifier = Modifier.fillMaxWidth(1f),
            // the button is enabled when the user makes a selection
            enabled = textAlamat.isNotBlank() && textGender.isNotBlank() && textNama.isNotBlank(),
            onClick = {
                nama = textNama
                gender = textGender
                alamat = textAlamat
            }
        ) {
            Text(stringResource(R.string.submit))
        }
    }
}
