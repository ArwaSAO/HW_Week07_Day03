package sa.edu.twuaiq.hw_week07_day03

import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.squareup.picasso.Picasso

class ProductRecyclerViewAdapter(private val list: List<ProductModel>) :
    RecyclerView.Adapter<ProductRecyclerViewAdapter.ProductViewHolder>() {

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ProductRecyclerViewAdapter.ProductViewHolder {

        return ProductViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.item_layout,
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: ProductViewHolder, position: Int) {

        val item = list[position]
        holder.titleTextView.text = item.name
        holder.bioTextView.text=item.bio
        holder.createdByTextView.text=item.createdby
        holder.firstAppearanceTextView.text=item.firstappearance
        holder.publisherTextView.text=item.publisher
        holder.realNameTextView.text=item.realname
        holder.teamTextView.text=item.team
        Picasso.get().load(item.imageurl).into((holder.poster))

    }

    override fun getItemCount(): Int {
        return list.size
    }


    class ProductViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        val titleTextView: TextView = itemView.findViewById(R.id.product_name)
        val bioTextView: TextView = itemView.findViewById(R.id.product_bio)
        val createdByTextView: TextView = itemView.findViewById(R.id.product_createdby)
        val firstAppearanceTextView: TextView = itemView.findViewById(R.id.product_firstapeariance)
        val poster: ImageView = itemView.findViewById(R.id.product_image)
        val publisherTextView: TextView = itemView.findViewById(R.id.product_publisher)
        val realNameTextView: TextView = itemView.findViewById(R.id.product_realname)
        val teamTextView: TextView = itemView.findViewById(R.id.product_team)

    }

}