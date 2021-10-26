package sa.edu.twuaiq.inventory.view

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import sa.edu.twuaiq.inventory.database.model.ItemModel
import sa.edu.twuaiq.inventory.repositories.InventoryRepository


/**
 * The ViewModel is a class whose role is to provide data to the UI and survive configuration changes.
 * A ViewModel acts as a communication center between the Repository and the UI.
 * You can also use a ViewModel to share data between fragments.
 *
 * A ViewModel holds your app's UI data in a lifecycle-conscious way that survives configuration changes.
 * Separating your app's UI data from your Activity and Fragment classes lets you better follow the single responsibility principle:
 * Your activities and fragments are responsible for drawing data to the screen,
 * while your ViewModel is responsible for holding and processing all the data needed for the UI.
 * */

class InventoryViewModel: ViewModel() {

    // Getting instance from inventory repository with companion object function
    private val inventoryRepository = InventoryRepository.get()

    var inventoryItems = inventoryRepository.getItems()


    var item: ItemModel? = null
    var selectedItemMutableLiveDate = MutableLiveData<ItemModel>()


    fun addItem(name: String, price:Double , inStock: Boolean){
        viewModelScope.launch {
            inventoryRepository.addItem(ItemModel(name,price,inStock))
        }
    }

    fun updateItem(itemModel: ItemModel) {
        viewModelScope.launch {
            inventoryRepository.updateItem(itemModel)
        }
    }

    fun deleteItem(itemModel: ItemModel){
        viewModelScope.launch {
            inventoryRepository.deleteItem(itemModel)
        }
    }

}