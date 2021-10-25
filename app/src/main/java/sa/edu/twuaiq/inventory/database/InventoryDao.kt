package sa.edu.twuaiq.inventory.database

import androidx.lifecycle.LiveData
import androidx.room.*
import sa.edu.twuaiq.inventory.database.model.ItemModel


/**
 * The following code defines a DAO called InventoryDao.
 * InventoryDao provides the methods that the rest of the app uses to interact with data in the ItemModel table.
 * */
@Dao
interface InventoryDao {


    // The @Insert annotation allows you to define methods that insert their parameters into the appropriate table in the database
    @Insert
    suspend fun addItem(itemModel: ItemModel)


    /***
     * The @Query annotation allows you to write SQL statements and expose them as DAO methods.
     * Use these query methods to query data from your app's database,
     * or when you need to perform more complex inserts, updates, and deletes.
     *
     * Room validates SQL queries at compile time. This means that if there's a problem with your query,
     * a compilation error occurs instead of a runtime failure.
     * */
    @Query("SELECT * FROM itemmodel")
    fun getItems() : LiveData<List<ItemModel>>

    // The @Update annotation allows you to define methods that update specific rows in a database table.
    // Similarly to @Insert methods, @Update methods accept data entity instances as parameters.
    @Update
    suspend fun updateItem(itemModel: ItemModel)

    // The @Delete annotation allows you to define methods that delete specific rows from a database table.
    // Similarly to @Insert methods, @Delete methods accept data entity instances as parameters.
    @Delete
    suspend fun deleteItem(itemModel: ItemModel)
}