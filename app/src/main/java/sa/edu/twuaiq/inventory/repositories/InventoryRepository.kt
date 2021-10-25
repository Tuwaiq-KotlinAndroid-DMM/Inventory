package sa.edu.twuaiq.inventory.repositories

import android.content.Context
import androidx.room.Room
import sa.edu.twuaiq.inventory.database.InventoryDatabase
import sa.edu.twuaiq.inventory.database.model.ItemModel
import java.lang.Exception


/**
 * A Repository is a class that abstracts access to multiple data sources (Room db, Network).
 * It is a suggested best practice for code separation and architecture. A Repository class handles data operations
 * */

private const val DATABASE_NAME = "inventory-database"
class InventoryRepository(context: Context) {

    /**
     * After you have defined the data entity,
     * the DAO, and the database object,
     * you can use the following code to create an instance of the database:
     * */
    private val database: InventoryDatabase =
        Room.databaseBuilder(
            context,
            InventoryDatabase::class.java,
            DATABASE_NAME
        ).fallbackToDestructiveMigration().build()

    /**
     * You can then use the abstract methods from the InventoryDatabase to get an instance of the DAO.
    * */

    private val inventoryDao = database.inventoryDao()

    // In turn, you can use the methods from the DAO instance to interact with the database:
    fun getItems() = inventoryDao.getItems()

    suspend fun addItem(itemModel: ItemModel) = inventoryDao.addItem(itemModel)
    suspend fun updateItem(itemModel: ItemModel) = inventoryDao.updateItem(itemModel)
    suspend fun deleteItem(itemModel: ItemModel) = inventoryDao.deleteItem(itemModel)


    /***
     * this companion object for restricts the instantiation of a class to one "single" instance.
     * This is useful when exactly one object is needed to coordinate actions across the system.
     * */

    companion object {
        private var instance: InventoryRepository? = null

        fun init(context: Context) {
            if (instance == null)
                instance = InventoryRepository(context)
        }

        fun get(): InventoryRepository {
            return instance ?: throw Exception("Inventory Repository must be initialized")
        }
    }
}