package com.example.presentation.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.domain.proto.model.LikeModel
import com.example.presentation.databinding.ItmeLikeBinding
import com.example.presentation.util.ItemClickListener

class LikeAdapter(private val list: ArrayList<LikeModel>, private val listener: ItemClickListener<LikeModel>) :
    RecyclerView.Adapter<LikeAdapter.LikeViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        LikeViewHolder(ItmeLikeBinding.inflate(LayoutInflater.from(parent.context), parent, false), listener)

    override fun getItemCount() = list.size

    override fun onBindViewHolder(holder: LikeViewHolder, position: Int) {
        holder.bind(list[position])
    }

    class LikeViewHolder(private val binding: ItmeLikeBinding, private val listener: ItemClickListener<LikeModel>) : ViewHolder(binding.root) {
        fun bind(item: LikeModel) = with(binding) {
            likeImage.setThumbnailUrl(item.image)
            likeTitle.text = item.title
            likeAuthor.text = item.author

            likeBtn.setOnClickListener {
                listener.itemClick(adapterPosition, item)
            }
        }
    }
}