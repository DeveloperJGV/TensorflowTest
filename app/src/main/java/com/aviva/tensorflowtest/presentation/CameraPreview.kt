package com.aviva.tensorflowtest.presentation

import androidx.camera.view.LifecycleCameraController
import androidx.camera.view.PreviewView
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalLifecycleOwner
import androidx.compose.ui.viewinterop.AndroidView

@Composable
    /*
     *  Este controller funciona para controlar la cámara para tomar fotos,
     *  decidir si es la camara trasera o delantera ETC.
     */
fun CameraPreview(
    controller: LifecycleCameraController,
    modifier: Modifier = Modifier
) {

    /*
     * Este Lifecycle es para que este al pendiente del ciclo de vida de la cámara
     */
    val lifecyclerOwner = LocalLifecycleOwner.current
    AndroidView(
        factory = {
            PreviewView(it).apply {
                this.controller = controller
                controller.bindToLifecycle(lifecyclerOwner)
            }
        },
        modifier = modifier
    )
}

