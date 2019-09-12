package com.example.imagefiltersexample

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.ImageView
import com.zomato.photofilters.geometry.Point
import com.zomato.photofilters.imageprocessors.Filter
import com.zomato.photofilters.imageprocessors.subfilters.*


class MainActivity : AppCompatActivity() {
    private var imageView: ImageView? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        System.loadLibrary("NativeImageProcessor")
        setContentView(R.layout.activity_main)
        imageView = findViewById(R.id.imageView)
    }

    private fun Int.nonZero() = if (this <= 0) 1 else this
    fun apply_toneCurve(view: View) {
       
        val myFilter = Filter()
        val rgbKnots: Array<Point?>
        rgbKnots = arrayOfNulls<Point>(3)
        rgbKnots[0] = Point(0F, 0F)
        rgbKnots[1] = Point(175F, 139F)
        rgbKnots[2] = Point(255F, 255F)

        myFilter.addSubFilter(ToneCurveSubFilter(rgbKnots, null, null, null))
        val outputImage = myFilter.processFilter(Bitmap.createScaledBitmap(BitmapFactory.decodeResource(this.getApplicationContext().getResources(), R.drawable.photo), 640, 640, false))
        imageView!!.setImageBitmap(outputImage)

    }

    fun apply_saturation_filter(view: View) {
       
        val myFilter = Filter()
        myFilter.addSubFilter(SaturationSubFilter(1.3f))
        val outputImage = myFilter.processFilter(Bitmap.createScaledBitmap(BitmapFactory.decodeResource(this.getApplicationContext().getResources(), R.drawable.photo), 640, 640, false))
        imageView!!.setImageBitmap(outputImage)

    }

    fun apply_overlay_filter(view: View) {
       
        val myFilter = Filter()
        myFilter.addSubFilter(ColorOverlaySubFilter(100, .2f, .2f, .0f))
        val outputImage = myFilter.processFilter(Bitmap.createScaledBitmap(BitmapFactory.decodeResource(this.getApplicationContext().getResources(), R.drawable.photo), 640, 640, false))
        imageView!!.setImageBitmap(outputImage)

    }

    fun apply_contrast_filter(view: View) {
       
        val myFilter = Filter()
        myFilter.addSubFilter(ContrastSubFilter(1.2f))
        val outputImage = myFilter.processFilter(Bitmap.createScaledBitmap(BitmapFactory.decodeResource(this.getApplicationContext().getResources(), R.drawable.photo), 640, 640, false))
        imageView!!.setImageBitmap(outputImage)

    }

    fun apply_brigtness_filter(view: View) {
       
        val myFilter = Filter()
        myFilter.addSubFilter(BrightnessSubFilter(30))
        val ouputImage = myFilter.processFilter(Bitmap.createScaledBitmap(BitmapFactory.decodeResource(this.getApplicationContext().getResources(), R.drawable.photo), 640, 640, false))
        imageView!!.setImageBitmap(ouputImage)

    }

    fun apply_vignette_filter(view: View) {
       
        val myFilter = Filter()
        myFilter.addSubFilter(VignetteSubFilter(this@MainActivity, 100))
        val outputImage = myFilter.processFilter(Bitmap.createScaledBitmap(BitmapFactory.decodeResource(this.getApplicationContext().getResources(), R.drawable.photo), 640, 640, false))
        imageView!!.setImageBitmap(outputImage)

    }
}
