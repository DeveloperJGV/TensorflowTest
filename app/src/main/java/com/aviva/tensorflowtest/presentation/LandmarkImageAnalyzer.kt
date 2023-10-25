package com.aviva.tensorflowtest.presentation

import androidx.camera.core.ImageAnalysis
import androidx.camera.core.ImageProxy
import com.aviva.tensorflowtest.domain.Classification
import com.aviva.tensorflowtest.domain.LandmarkClassifier

class LandmarkImageAnalyzer(
     private val classifier: LandmarkClassifier,
     private val onResults: (List<Classification>) -> Unit
): ImageAnalysis.Analyzer {

     private var frameSkipCounter = 0

     override fun analyze(image: ImageProxy) {
          if (frameSkipCounter % 60 == 0) {
               val rotationDegrees = image.imageInfo.rotationDegrees
               val bitmap = image
                    .toBitmap()
                    .centerCrop(desiredWidth = 321, desiredHeight = 321)

               val results = classifier.classify(bitmap, rotationDegrees)
               onResults(results)
          }
          frameSkipCounter++
          image.close()

     }
}