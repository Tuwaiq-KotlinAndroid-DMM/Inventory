package sa.edu.twuaiq.inventory.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton
import sa.edu.twuaiq.inventory.R
import sa.edu.twuaiq.inventory.database.model.ItemModel


/***
 * A Fragment represents a reusable portion of your app's UI.
 * A fragment defines and manages its own layout, has its own lifecycle, and can handle its own input events.
 * Fragments cannot live on their own--they must be hosted by an activity or another fragment.
 * The fragment’s view hierarchy becomes part of, or attaches to, the host’s view hierarchy.
 * */

class InventoryListFragment : Fragment() {

    private val inventoryItems = mutableListOf<ItemModel>()

    // To get instance from view model you need to use bu activityViewModels to provide you with the object from the InventoryViewModel
    private val inventoryViewModel: InventoryViewModel by activityViewModels()



    // The onCreateView method is called when Fragment should create its View object hierarchy,
    // either dynamically or via XML layout inflation.
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_inventory_list, container, false)
    }

    // This event is triggered soon after onCreateView().
    // Any view setup should occur here.  E.g., view lookups and attaching view listeners.
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Setup any handles to view objects here


        val inventoryRecyclerView: RecyclerView = view.findViewById(R.id.inventory_recyclerview)
        val addFloatingActionButton: FloatingActionButton = view.findViewById(R.id.add_button)

        val inventoryAdapter = InventoryAdapter(inventoryItems,inventoryViewModel)

        inventoryRecyclerView.adapter = inventoryAdapter

        /***
         * When your app displays data or uses data in other ways,
         * you usually want to take action when the data changes.
         * This means you have to observe the data so that when it changes,
         * you can react. Depending on how the data is stored,
         * And now you can use LiveData for do that
         * */

        /*** Benefits of using LiveData
         * Ensures that your UI matches your data state
         * No memory leaks
         * No crashes due to stopped activities
         * Data is always up to date
         * Configuration changes handled properly
         * Resources can be shared
         * */
        inventoryViewModel.inventoryItems.observe(viewLifecycleOwner, Observer {
            it?.let { items ->
                inventoryItems.clear()
                inventoryItems.addAll(items)
                inventoryAdapter.notifyDataSetChanged()
            }
        })

        addFloatingActionButton.setOnClickListener {

            // Use the navigate method of NavController class with a destination id given in the navigation graph.
            findNavController().navigate(R.id.action_inventoryListFragment_to_addItemFragment)
        }
    }

}