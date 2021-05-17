package br.com.cotemig.socialcotemig.ui.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import br.com.cotemig.socialcotemig.R
import br.com.cotemig.socialcotemig.models.PostImage
import coil.load

class GalleryAdapter(var context: Context, var gallery: List<PostImage>) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        var view = LayoutInflater.from(context).inflate(R.layout.item_gallery, parent, false)
        return GalleryHolder(view)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        (holder as GalleryHolder).bind(gallery[position])
    }

    override fun getItemCount(): Int {
        return gallery.size
    }

    class GalleryHolder(var view: View) : RecyclerView.ViewHolder(view){
        fun bind(postImage: PostImage){

            var image = view.findViewById<ImageView>(R.id.postImage)
            image.load(postImage.image)

        }
    }
}