package edu.temple.uiattempttwo

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.AlertDialog

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.main, menu)
        return super.onCreateOptionsMenu(menu)


    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId){
            R.id.mnCamera -> Toast.makeText(this, "Taking Picture", Toast.LENGTH_SHORT)
            R.id.mnHelp -> startActivity(Intent(Intent.ACTION_VIEW).setData(Uri.parse("https://www.temple.edu")))
            R.id.mnDelete -> {
                AlertDialog.Builder(this)
                    .setTitle("Confirmation")
                    .setMessage("Are you sure? Cannot be done")
                    .setPositiveButton("Yes" ){_,_ -> Toast.makeText(this, "deleting", Toast.LENGTH_SHORT)}
                    .setNegativeButton("No"){dialog,_ -> dialog.cancel()}
                    .setCancelable(false)
                    .create()
                    .show()
            }
            else -> return false
        }

        return true
    }
}