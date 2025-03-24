package com.example.jetpackcomposeinstagram.tutorial

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.IntSize
import androidx.compose.ui.unit.dp

@Composable
fun tutorial_1(name: String, modifier: Modifier = Modifier) {
    Column(modifier = Modifier.padding(16.dp)) {
        Text(
            text = "Hello $name",
            modifier = modifier
        )
        var MaxByte : Byte = Byte.MAX_VALUE
        var MinByte : Byte = Byte.MIN_VALUE
        var MaxShort : Short = Short.MAX_VALUE
        var MinShort : Short = Short.MIN_VALUE
        var MaxInt : Int = Int.MAX_VALUE
        var MinInt : Int = Int.MIN_VALUE
        var MaxLong : Long = Long.MAX_VALUE
        var MinLong : Long = Long.MIN_VALUE

        var unByte : Byte = 1
        var ByteSizeBits = Byte.SIZE_BITS
        var ByteSizeByte = Byte.SIZE_BYTES

        var unShort: Short = 1
        var ShortSizeBits = Short.SIZE_BITS
        var ShortSizeByte = Short.SIZE_BYTES

        var unInt : Int = 1
        var IntSizeBits = Int.SIZE_BITS
        var IntSizeByte = Int.SIZE_BYTES

        var unLong: Long = 1
        var LongSizeBits = Long.SIZE_BITS
        var LongSizeByte = Long.SIZE_BYTES

        Text(text = "==================================================")
        Text(text = "Mostrar alcance de las variables y tipos de datos")
        Text(text = "==================================================")
        Text(text = "unByte = $unByte")
        Text(text = "Longitud Byte en Bits = $ByteSizeBits")
        Text(text = "Longitud Byte en Bytes = $ByteSizeByte")
        Text(text = "Maximo valor en Bytes: " + MaxByte)
        Text(text = "Minimo valor en Bytes: $MinByte")
        Text(text = "El tipo de la variable es ${unByte::class.simpleName}")
        Text(text = "=====================================================")
        Text(text = "unShort = $unShort")
        Text(text = "Longitud Short en Bits = $ShortSizeBits")
        Text(text = "Longitud Short en Bytes = $ShortSizeByte")
        Text(text = "Maximo valor en Short: " + MaxShort)
        Text(text = "Minimo valor en Short: $MinShort")
        Text(text = "El tipo de la variable es ${unShort::class.simpleName}")
        Text(text = "=====================================================")
        Text(text = "unInt = $unInt")
        Text(text = "Longitud Int en Bits = $IntSizeBits")
        Text(text = "Longitud Int en Bytes = $IntSizeByte")
        Text(text = "Maximo valor en Int: " + MaxInt)
        Text(text = "Minimo valor en Int: $MinInt")
        Text(text = "El tipo de la variable es ${unInt::class.simpleName}")
        Text(text = "=====================================================")
        Text(text = "unLong = $unLong")
        Text(text = "Longitud Long en Bits = $LongSizeBits")
        Text(text = "Longitud Long en Bytes = $LongSizeByte")
        Text(text = "Maximo valor en Long: " + MaxLong)
        Text(text = "Minimo valor en Long: $MinLong")
        Text(text = "El tipo de la variable es ${unLong::class.simpleName}")
        Text(text = "=====================================================")
    }
}