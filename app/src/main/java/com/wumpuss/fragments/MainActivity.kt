package com.wumpuss.fragments

import android.os.Bundle
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem

import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(),
    FirstFragment.onMainFragmentInteractionListener,
    SecondFragment.onMainFragmentInteractionListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)

        supportFragmentManager.beginTransaction()
            .add(
                R.id.fragment_container,
                FirstFragment()
            )
            .commit()

        fab.setOnClickListener { view ->
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                    .setAction("Action", null).show()
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        return when (item.itemId) {
            R.id.action_settings -> true
            else -> super.onOptionsItemSelected(item)
        }
    }

    override fun onGotoSecondFragment() {
        supportFragmentManager.beginTransaction()
            .replace(
                R.id.fragment_container,
                SecondFragment()
            )
            .addToBackStack(null)
            .commit()
    }

    override fun onGotoFirstFragment() {
        supportFragmentManager.beginTransaction()
            .replace(
                R.id.fragment_container,
                FirstFragment()
            )
            .addToBackStack(null)
            .commit()
    }
}
