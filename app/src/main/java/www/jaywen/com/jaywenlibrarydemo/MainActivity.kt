package www.jaywen.com.jaywenlibrarydemo

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.webkit.WebChromeClient
import kotlinx.android.synthetic.main.activity_main.*



class MainActivity : AppCompatActivity() {

    var url:String="http://10.13.131.100:8085/dist/index.html?yzg_ticket=YZGTICKET5aebf5ecac3ad40001367c7c" //变量name为String类型

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Example of a call to a native method
        sample_text.text = stringFromJNI()
        sample_text.text="my first kotlin"
        mywebview.loadUrl(url)
        sample_imageview.setBackgroundResource(R.mipmap.ic_launcher)
        mywebview.setWebChromeClient(WebChromeClient())
    }

    /**
     * A native method that is implemented by the 'native-lib' native library,
     * which is packaged with this application.
     */
    external fun stringFromJNI(): String

    companion object {

        // Used to load the 'native-lib' library on application startup.
        init {
            System.loadLibrary("native-lib")
        }
    }
}
