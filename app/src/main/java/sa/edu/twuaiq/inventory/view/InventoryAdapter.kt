package sa.edu.twuaiq.inventory.view

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import android.widget.TextView
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import sa.edu.twuaiq.inventory.R
import sa.edu.twuaiq.inventory.database.model.ItemModel

/***
Once you've determined your layout, you need to implement your Adapter and ViewHolder.
These two classes work together to define how your data is displayed.
The ViewHolder is a wrapper around a View that contains the layout for an individual item in the list.
The Adapter creates ViewHolder objects as needed, and also sets the data for those views.
The process of associating views to their data is called binding.
When you define your adapter, you need to override three key methods:
onCreateViewHolder()
onBindViewHolder()
getItemCount()
 **/

class InventoryAdapter
    (val items: List<ItemModel>,val viewModel: InventoryViewModel):
    RecyclerView.Adapter<InventoryAdapter.InventoryViewHolder>() {

    /**
     * onCreateViewHolder(): RecyclerView calls this method whenever it needs to create a new ViewHolder.
    The method creates and initializes the ViewHolder and its associated View,
    but does not fill in the view's contents—the ViewHolder has not yet been bound to specific data.
     */

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): InventoryAdapter.InventoryViewHolder {

        return InventoryViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.item_layout,
                parent,
                false
            )
        )
    }

    /**
     * onBindViewHolder(): RecyclerView calls this method to associate a ViewHolder with data.
    The method fetches the appropriate data and uses the data to fill in the view holder's layout.
    For example, if the RecyclerView displays a list of names,
    the method might find the appropriate name in the list and fill in the view holder's TextView widget.
     */


    override fun onBindViewHolder(holder: InventoryAdapter.InventoryViewHolder, position: Int) {

        val item = items[position]

        holder.nameTextView.text = item.name
        holder.priceTextView.text = item.price.toString()
        holder.inStock.isChecked = item.inStock

    }

    /**
     * getItemCount(): RecyclerView calls this method to get the size of the data set.
    For example, in an address book app, this might be the total number of addresses.
    RecyclerView uses this to determine when there are no more items that can be displayed.
     */

    override fun getItemCount(): Int {
        return items.size
    }


    class InventoryViewHolder(view: View): RecyclerView.ViewHolder(view) {
        val nameTextView: TextView = view.findViewById(R.id.name_textview)
        val priceTextView: TextView = view.findViewById(R.id.price_textview)
        val inStock: CheckBox = view.findViewById(R.id.instock_checkbox)
    }
}