import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun StopwatchDisplay( formattedTime:String,
                      onStartClick:() -> Unit,
                      onPauseClick:() ->Unit,
                      onResetClick:()->Unit,
                      modifier:Modifier= Modifier
) {
   Column (modifier = modifier,
   verticalArrangement = Arrangement.Center,
   horizontalAlignment = Alignment.CenterHorizontally){

Text(text=formattedTime,
fontSize = 30.sp)
       Row(horizontalArrangement = Arrangement.Center,
       verticalAlignment = Alignment.CenterVertically) {
           Button(onStartClick){
               Text("Start")
           }
           Spacer(Modifier.width(16.dp))
           Button(onPauseClick){
               Text("Pause")
           }
           Spacer(Modifier.width(16.dp))
           Button(onResetClick){
               Text("Reset")
           }


       }
   }
}