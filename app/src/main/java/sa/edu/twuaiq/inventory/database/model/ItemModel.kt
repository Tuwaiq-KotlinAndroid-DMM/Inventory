package sa.edu.twuaiq.inventory.database.model

import androidx.room.Entity
import androidx.room.PrimaryKey

/*** You define each Room entity as a class that is annotated with @Entity.
A Room entity includes fields for each column in the corresponding table in the database,
including one or more columns that comprise the primary key.
 **/

/***
 * The following code defines a ItemModel data entity.
 * Each instance of ItemModel represents a row in a ItemModel table in the app's database.
 * */

@Entity
data class ItemModel(
    val name: String,
    val price: Double,
    var inStock: Boolean,
/*
* Each Room entity must define a primary key that uniquely identifies each row in the corresponding database table.
* The most straightforward way of doing this is to annotate a single column with @PrimaryKey:
* */
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0
)
