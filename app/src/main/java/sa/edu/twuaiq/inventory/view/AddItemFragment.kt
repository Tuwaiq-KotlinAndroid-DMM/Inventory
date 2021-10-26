package sa.edu.twuaiq.inventory.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import sa.edu.twuaiq.inventory.R

class AddItemFragment : Fragment() {

    private val inventoryViewModel: InventoryViewModel by activityViewModels()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_add_item, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val nameEditText: EditText = view.findViewById(R.id.name_edittext)
        val priceEditText: EditText = view.findViewById(R.id.price_edittext)
        val inStockCheckbox: CheckBox = view.findViewById(R.id.item_instock_checkbox)
        val saveButton: Button = view.findViewById(R.id.save_button)

        saveButton.setOnClickListener {
            val name = nameEditText.text.toString()
            val price = priceEditText.text.toString()
            val inStock = inStockCheckbox.isChecked

            if (name.isNotEmpty() && price.isNotEmpty()){

                inventoryViewModel.addItem(name,price.toDouble(),inStock)
                findNavController().popBackStack()

            }
        }
    }
}