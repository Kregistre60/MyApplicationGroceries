package com.emonics.myapplicationgroceries.fragments.adapters

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.emonics.myapplicationgroceries.R
import com.emonics.myapplicationgroceries.interfaces.mOnclickListener

data class MeatData(val name: String, val imageID1: String, val imageID: Int)

class CustomAdapter(private val dataSet: Array<MeatData>, val mOnclickListener: mOnclickListener) :
    RecyclerView.Adapter<CustomAdapter.ViewHolder>() {

    /**
     * Provide a reference to the type of views that you are using
     * (custom ViewHolder).
     */
    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val textView: TextView
      val myImage: ImageView
private val cardView: CardView

        init {
            // Define click listener for the ViewHolder's View.
            textView = view.findViewById(R.id.textView)
            myImage = view.findViewById(R.id.my_image)
            cardView = view.findViewById(R.id.my_cardView)
        }
    }

    // Create new views (invoked by the layout manager)
    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
        // Create a new view, which defines the UI of the list item
        val view = LayoutInflater.from(viewGroup.context)
            .inflate(R.layout.text_row_item, viewGroup, false)

        return ViewHolder(view)
    }

    // Replace the contents of a view (invoked by the layout manager)
    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {

        // Get element from your dataset at this position and replace the
        // contents of the view with that element
        viewHolder.textView.text = dataSet[position].name
        viewHolder.myImage.setImageResource(dataSet[position].imageID)
        viewHolder.itemView.setOnClickListener {
            mOnclickListener.onClick(dataSet[position])
        }

    }

    // Return the size of your dataset (invoked by the layout manager)
    override fun getItemCount() = dataSet.size

}
