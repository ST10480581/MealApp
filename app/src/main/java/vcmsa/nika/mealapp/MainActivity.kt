package vcmsa.nika.mealapp

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // UI Elements
        val inputTimeOfDay: EditText = findViewById(R.id.edtTimeOfDay)
        val btnGenerate: Button = findViewById(R.id.btnGenerate)
        val btnReset: Button = findViewById(R.id.btnReset)
        val textViewResult: TextView = findViewById(R.id.tvSuggestedMeal)

        // Click listener for Generate button
        btnGenerate.setOnClickListener {
            val timeOfDay = inputTimeOfDay.text.toString().trim().lowercase()

            // Determine meal suggestion using when expression
            val mealSuggestion = when (timeOfDay) {
                "morning" -> "Pancakes with Orange Juice"
                "mid-morning" -> "Smoothie with a handful of Nuts"
                "afternoon" -> "Grilled Chicken Wrap with Veggies"
                "mid-afternoon" -> "Cheese & Crackers"
                "dinner" -> "Steak with Mashed Potatoes"
                "after dinner" -> "Chocolate Mousse"
                else -> null
            }

            // Display the meal suggestion or an error message
            if (mealSuggestion != null) {
                textViewResult.text = "Suggested Meal: $mealSuggestion"
            } else {
                textViewResult.text = ""
                Toast.makeText(this, "Invalid time of day! Please enter a valid time.", Toast.LENGTH_SHORT).show()
            }
        }

        // Click listener for Reset button
        btnReset.setOnClickListener {
            inputTimeOfDay.text.clear()
            textViewResult.text = ""
        }
    }
}
