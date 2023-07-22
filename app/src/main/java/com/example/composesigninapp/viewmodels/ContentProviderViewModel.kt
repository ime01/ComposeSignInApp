package com.example.composesigninapp.viewmodels

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.example.composesigninapp.ImagesFromContentProvider

class ContentProviderViewModel:ViewModel() {


    var imagesFromContentProvider by mutableStateOf(emptyList<ImagesFromContentProvider>())
        private set



    fun upDateImages(images:List<ImagesFromContentProvider>){
       this.imagesFromContentProvider = images
    }
}