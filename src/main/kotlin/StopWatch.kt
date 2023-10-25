import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import kotlinx.coroutines.*
import java.time.Instant
import java.time.LocalDateTime
import java.time.ZoneId
import java.time.format.DateTimeFormatter
import java.util.*

class StopWatch {
    var formattedTime by mutableStateOf("00:00:000")
    private var coroutineScope= CoroutineScope(Dispatchers.Main)
    private var isActive=false

    private var timeMilis=0L
    private var lastTimestamp=0L
    fun start(){
        if(isActive) return

        coroutineScope.launch {
            lastTimestamp=System.currentTimeMillis()
            this@StopWatch.isActive= true
            while (this@StopWatch.isActive){
                delay(10L)
                timeMilis+= System.currentTimeMillis() -lastTimestamp
                lastTimestamp=System.currentTimeMillis()
                formattedTime=formatTime(timeMilis)
            }
        }


    }

    fun pause(){
        isActive=false
    }
    fun reset(){
        coroutineScope.cancel()
        coroutineScope= CoroutineScope(Dispatchers.Main)
   isActive=false

     timeMilis=0L
       lastTimestamp=0L
        formattedTime="00:00:000"
    }

    private fun formatTime(timeMilis:Long):String{
val localDateTime=LocalDateTime.ofInstant(
    Instant.ofEpochMilli(timeMilis),
    ZoneId.systemDefault()
)
        val formatter= DateTimeFormatter.ofPattern(
            "mm:ss:SSS",
            Locale.getDefault()
        )

        return localDateTime.format(formatter)
    }
}