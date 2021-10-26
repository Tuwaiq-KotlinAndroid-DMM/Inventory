package sa.edu.twuaiq.inventory.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupActionBarWithNavController
import sa.edu.twuaiq.inventory.R
import sa.edu.twuaiq.inventory.repositories.InventoryRepository


/***
 * Before starting the implementation of the Navigation Architecture Component.
   you must be aware of the following:
 * Navigation Graph (Destination and Action)
 * Navigation Host Fragment
 * Navigation Controller
 * */


/***
 * Navigation Graph
Navigation graph is an XML file which shows you how the Fragments are related to each other.
It contains the Fragments Destinations, routes, arguments, action, etc.
Using the Navigation graph you can quickly set the Transition Animation by setting up some attributes.
 * */

/**
 * A Navigation Graph consists of:
 * Destinations: The individual screens the user can navigate to and can specify arguments,
   actions and deep link URLs to these destinations.
 * Actions: The routes user can take between your app’s destinations.
   Which are represented by the arrow sign in the Design view.
 * */


/***
 * Navigation Host Fragment
In our Activity layout, we have to add a fragment as NavHost and need to define, Where the NavHostFragment finds the navigation graph.
You can see the following code in which we define the fragment as NavHostFragment and also define the navigation graph.
 * You must defines which Navigation Graph will be associated with the Navigation Host
 * */


/***
 * Navigation Controller
NavController is the class which deals with the FragmentManager or FragmentTransaction.
NavController manages application navigation with the NavHostFragment.
Navigation flow and destination are determined by the navigation graph owned by the NavController class.
And currently running NavHostFragment directly deal with maintaining back-stack,
action bar, toolbar, navigation drawer icon, etc
 * */
class MainActivity : AppCompatActivity() {

    private lateinit var navController: NavController
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Initialize Inventory Repository only for one time with companion object function in InventoryRepository class
        InventoryRepository.init(this)


        val navHostFragment = supportFragmentManager
            .findFragmentById(R.id.fragmentContainerView2) as NavHostFragment
        navController = navHostFragment.navController

        setupActionBarWithNavController(navController)

    }

    // If you want to back to the last fragment from where you come here just user the navigateUp method of NavController
    override fun onSupportNavigateUp(): Boolean {
        return navController.navigateUp() || super.onSupportNavigateUp()
    }
}