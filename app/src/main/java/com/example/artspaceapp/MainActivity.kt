package com.example.artspaceapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    private val artworkImages = arrayOf(
        R.drawable.art1,
        R.drawable.art2,
        R.drawable.art3
    )

    private val artworkDescriptions = arrayOf(
        "Leonardo da Vinci: Mona Lisa Mona Lisa,\n oil on wood panel by Leonardo da Vinci, c. 1503–19; in the Louvre, Paris.",
        "Vincent van Gogh: The Starry NightThe Starry Night,\n oil on canvas by Vincent van Gogh, 1889; in the Museum of Modern Art, New York City.",
        "Juan Luna: Spoliarium, \n oil-on-canvas painting by Juan Luna, 1884;\n in the Academia de Dibujo y Pintura, Philippines."
    )

    private var currentIndex = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val imageViewArtwork = findViewById<ImageView>(R.id.imageViewArtwork)
        val textViewDescription = findViewById<TextView>(R.id.textViewDescription)
        val buttonPrev = findViewById<Button>(R.id.buttonPrev)
        val buttonNext = findViewById<Button>(R.id.buttonNext)

        // Initial setup
        updateArtwork(imageViewArtwork, textViewDescription)

        // Next button listener
        buttonNext.setOnClickListener {
            if (currentIndex < artworkImages.size - 1) {
                currentIndex++
                updateArtwork(imageViewArtwork, textViewDescription)
            }
        }

        // Previous button listener
        buttonPrev.setOnClickListener {
            if (currentIndex > 0) {
                currentIndex--
                updateArtwork(imageViewArtwork, textViewDescription)
            }
        }
    }

    private fun updateArtwork(imageView: ImageView, textView: TextView) {
        imageView.setImageResource(artworkImages[currentIndex])
        textView.text = artworkDescriptions[currentIndex]
    }
}
