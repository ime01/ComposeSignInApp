package com.example.composesigninapp

import android.Manifest
import android.content.ContentUris
import android.net.Uri
import android.os.Bundle
import android.provider.MediaStore
import android.provider.MediaStore.Images
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.animation.Crossfade
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.displayCutoutPadding
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.app.ActivityCompat
import coil.compose.AsyncImage
import com.example.composesigninapp.mainapp.JCAuthApp
import com.example.composesigninapp.navigation.JCAuthAppRouter
import com.example.composesigninapp.navigation.Screen
import com.example.composesigninapp.screens.LoginScreen
import com.example.composesigninapp.screens.SignUpScreen
import com.example.composesigninapp.screens.TermsAndConditionScreen
import com.example.composesigninapp.ui.theme.ComposeSignInAppTheme
import com.example.composesigninapp.viewmodels.ContentProviderViewModel
import java.util.Calendar

class MainActivity : ComponentActivity() {

    private val viewModel by viewModels<ContentProviderViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        ActivityCompat.requestPermissions(this, arrayOf(Manifest.permission.READ_MEDIA_IMAGES), 0)




        //contentProvider Setup
        val projection = arrayOf(
            MediaStore.Images.Media._ID,
            MediaStore.Images.Media.DISPLAY_NAME
        )

        val yesterdayInMillis = Calendar.getInstance().apply {
            add(Calendar.DAY_OF_YEAR, -1)
        }.timeInMillis

        val selection = "${MediaStore.Images.Media.DATE_TAKEN} >= ?"
        val selectionArgs = arrayOf(yesterdayInMillis.toString())

        val sortOrder = "${MediaStore.Images.Media.DATE_TAKEN} ASC"

        contentResolver.query(
            MediaStore.Images.Media.EXTERNAL_CONTENT_URI,
            projection,
            selection,
            selectionArgs,
            sortOrder
        )?.use {cursor->

           val idColumn = cursor.getColumnIndex(MediaStore.Images.Media._ID)
           val nameColumn = cursor.getColumnIndex(MediaStore.Images.Media.DISPLAY_NAME)

            //read all images via uri and details
            val images = mutableListOf<ImagesFromContentProvider>()

            while (cursor.moveToNext()){

                val id = cursor.getLong(idColumn)
                val name = cursor.getString(nameColumn)
                val uri = ContentUris.withAppendedId(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, id)

                images.add(ImagesFromContentProvider(id = id, name = name, uri =uri))

            }

            viewModel.upDateImages(images)

        }








        setContent {
            ComposeSignInAppTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {

                    LazyColumn(modifier = Modifier.fillMaxSize()){
                        items(viewModel.imagesFromContentProvider){image->

                            Column(modifier = Modifier.fillMaxWidth(), horizontalAlignment = Alignment.CenterHorizontally) {

                                AsyncImage(model = image.uri, contentDescription = "Images from content provider")

                                Text(
                                    text = image.name,
                                    style = TextStyle(
                                        fontSize = 16.sp,
                                        fontWeight = FontWeight.Normal,
                                        fontStyle = FontStyle.Normal
                                    ),
                                    color = colorResource(id = R.color.colorText),
                                    textAlign = TextAlign.Center
                                )

                                Spacer(modifier = Modifier.height(8.dp))

                                Text(
                                    text = image.id.toString(),
                                    style = TextStyle(
                                        fontSize = 16.sp,
                                        fontWeight = FontWeight.Normal,
                                        fontStyle = FontStyle.Normal
                                    ),
                                    color = colorResource(id = R.color.colorText),
                                    textAlign = TextAlign.Center
                                )




                            }

                        }
                    }











                        //Crossfade(targetState = JCAuthAppRouter.currentScreen) { currentState ->

                    //  when (currentState.value) {

                    //   is Screen.SignupScreen -> {
                    //     SignUpScreen()
                    //    }

                    //     is Screen.TermsAndConditionsScreen -> {
                    //              TermsAndConditionScreen()
                    //          }

                    //        is Screen.LoginScreen -> {
                    //            LoginScreen()
                    //         }

                    //      }
                    //   }



                }
            }
        }
    }
}



@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    ComposeSignInAppTheme {
        JCAuthApp()
    }
}

data class ImagesFromContentProvider(
    val id: Long,
    val name: String,
    val uri: Uri,
)