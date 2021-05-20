package br.com.cotemig.socialcotemig.ui.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import br.com.cotemig.socialcotemig.R
import br.com.cotemig.socialcotemig.models.Stories
import coil.load
import coil.transform.RoundedCornersTransformation

class StoriesAdapter(var context: Context, var storie: List<Stories>) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        if(viewType==0){
            var view = LayoutInflater.from(context).inflate(R.layout.item_new_stories, parent, false)
            return NewStoriesHolder(view)
        }else{
            var view = LayoutInflater.from(context).inflate(R.layout.item_stories, parent, false)
            return StoriesHolder(view)
        }
    }

    override fun getItemViewType(position: Int): Int {
        if (position == 0) {
            return 0;
        } else {
            return 1;
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if (position == 0) {
            (holder as NewStoriesHolder).bind()
        } else {
            (holder as StoriesHolder).bind(storie[position - 1])
        }
    }

    override fun getItemCount(): Int {
        return storie.size + 1
    }

    class StoriesHolder(var view: View) : RecyclerView.ViewHolder(view) {

        fun bind(stories: Stories) {

            var avatarStories = view.findViewById<ImageView>(R.id.avatarStories)
            avatarStories.load(stories.avatar) {
                transformations(RoundedCornersTransformation(50f))
            }

            var live = view.findViewById<ImageView>(R.id.live)
            if (stories.live) {
                live.visibility = View.VISIBLE
            } else {
                live.visibility = View.GONE
            }

        }

    }

    class NewStoriesHolder(var view: View) : RecyclerView.ViewHolder(view) {
        fun bind() {
            var cam = view.findViewById<ImageView>(R.id.cam)
            cam.load(R.drawable.camera)
        }
    }

}