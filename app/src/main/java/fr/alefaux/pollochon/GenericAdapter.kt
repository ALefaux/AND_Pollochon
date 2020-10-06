package fr.alefaux.pollochon

import android.view.View
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.recyclerview.widget.RecyclerView
import fr.alefaux.pollochon.extensions.inflate

abstract class GenericAdapter<T> : RecyclerView.Adapter<GenericAdapter.Binder<T>>() {

    private val listItems: MutableList<T> = mutableListOf()
    var items: List<T>?
        get() = listItems.toList()
        set(value) {
            listItems.clear()
            value?.let {
                listItems.addAll(it)
            }
            notifyDataSetChanged()
        }

    fun addItem(item: T) {
        listItems.add(item)
        notifyItemInserted(listItems.size - 1)
    }

    fun removeItem(position: Int) {
        listItems.removeAt(position)
        notifyItemRemoved(position)
    }

    fun moveItem(from: Int, to: Int) {
        listItems.removeAt(from).let {
            listItems.add(to, it)
        }
        notifyItemMoved(from, to)
    }

    private var itemClickListener: ((T) -> Unit)? = null

    fun setOnClickListener(itemClickListener: (T) -> Unit) {
        this.itemClickListener = itemClickListener
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Binder<T> {
        return getViewHolder(parent.inflate(viewType))
    }

    override fun onBindViewHolder(holder: Binder<T>, position: Int) {
        val data = listItems[position]
        holder.bind(data, position)
        holder.itemView.setOnClickListener {
            itemClickListener?.invoke(data)
        }
    }

    override fun getItemCount() = listItems.size

    override fun getItemViewType(position: Int): Int {
        return getLayoutId(position, listItems[position])
    }

    @LayoutRes
    protected abstract fun getLayoutId(position: Int, obj: T): Int

    abstract fun getViewHolder(view: View): Binder<T>

    abstract class Binder<T>(itemView: View) : RecyclerView.ViewHolder(itemView) {
        abstract fun bind(data: T, position: Int)
    }
}