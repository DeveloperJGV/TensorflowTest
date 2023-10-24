package com.aviva.tensorflowtest.domain


/**
 * El modelo de IA que se va a ocupar, tiene datos importartes con los que vamos a trabajar.
 * Para empezar detecta el nombre y una calificación del monumento y un nombre.
 */

data class Classification(
    val name: String,
    val score: Float
)


