package com.example.wordsapp

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.recyclerview.widget.RecyclerView

/**
 * Adapter for the [RecyclerView] in [DetailActivity].
 */
class WordAdapter(private val letterId: String, context: Context) :
    RecyclerView.Adapter<WordAdapter.WordViewHolder>() {

    private val filteredWords: List<String>

    init {
        // Retrieve the list of words from res/values/arrays.xml
        val words = context.resources.getStringArray(R.array.words).toList()

        filteredWords = words
            // Returns items in a collection if the conditional clause is true,
            // in this case if an item starts with the given letter,
            // ignoring UPPERCASE or lowercase.
            .filter { it.startsWith(letterId, ignoreCase = true) }
            // Returns a collection that it has shuffled in place
            .shuffled()
            // Returns the first n items as a [List]
            .take(5)
            // Returns a sorted version of that [List]
            .sorted()
    }

    class WordViewHolder(val view: View) : RecyclerView.ViewHolder(view) {
        val button = view.findViewById<Button>(R.id.button_item)
    }

    override fun getItemCount(): Int = filteredWords.size

    /**
     * Creates new views with R.layout.item_view as its template
     */
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WordViewHolder {
        val layout = LayoutInflater
            .from(parent.context)
            .inflate(R.layout.item_view, parent, false)

        return WordViewHolder(layout)
    }

    /**
     * Replaces the content of an existing view with new data
     */
    override fun onBindViewHolder(holder: WordViewHolder, position: Int) {

        val item = filteredWords[position]
        // Needed to call startActivity
        val context = holder.view.context

        // Set the text of the WordViewHolder
        holder.button.text = item



    }

}