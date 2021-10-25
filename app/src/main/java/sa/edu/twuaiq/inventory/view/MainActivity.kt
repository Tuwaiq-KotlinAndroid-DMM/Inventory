package sa.edu.twuaiq.inventory.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import sa.edu.twuaiq.inventory.R
import sa.edu.twuaiq.inventory.repositories.InventoryRepository

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        InventoryRepository.init(this)
    }
}