package sa.edu.twuaiq.inventory.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import sa.edu.twuaiq.inventory.R
import sa.edu.twuaiq.inventory.database.model.ItemModel

class ItemDetailsFragment : Fragment() {

    private val inventoryViewModel: InventoryViewModel by activityViewModels()
    private lateinit var selectedItem: ItemModel
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_item_details, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val nameTextView: TextView = view.findViewById(R.id.item_name_textview)
        val priceTextView: TextView = view.findViewById(R.id.item_price_textview)
        val inStockTextView : TextView = view.findViewById(R.id.item_instock_textview)
        val deleteButton: Button = view.findViewById(R.id.delete_button)

        /***
         * To get posted value from inventory adapter in inventory list fragment
         * */
        //
        inventoryViewModel.selectedItemMutableLiveDate.observe(viewLifecycleOwner, Observer {
            it?.let { item ->
                nameTextView.text = item.name
                priceTextView.text = "${item.price} SAR"
                inStockTextView.text = "In Stock: ${item.inStock}"
                selectedItem = item
            }
        })

        deleteButton.setOnClickListener {
            inventoryViewModel.deleteItem(selectedItem)

           // If you want to back to the last fragment from where you come here just user the popBackStack method of NavController
            findNavController().popBackStack()
        }
    }
}