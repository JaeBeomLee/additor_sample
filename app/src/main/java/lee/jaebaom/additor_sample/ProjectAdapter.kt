package lee.jaebaom.additor_sample

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

/**
 * Created by leejaebeom on 2018. 2. 2..
 */
import kotlinx.android.synthetic.main.section_item.view.*
import kotlinx.android.synthetic.main.note_item.view.card_text
import lee.jaebaom.additor_sample.data.Note
import lee.jaebaom.additor_sample.data.Section
import java.util.*

class ProjectAdapter(val sections: ArrayList<Section>) : RecyclerView.Adapter<ProjectAdapter.CardViewHolder>(), CardCallback.OnItemMoveListener {
    override fun onItemMove(fromPosition: Int?, toPosition: Int?) {
        Collections.swap(sections, fromPosition!!, toPosition!!)
        notifyItemMoved(fromPosition, toPosition)
    }

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): CardViewHolder {
        return CardViewHolder(LayoutInflater.from(parent?.context).inflate(R.layout.section_item, parent, false))
    }

    override fun getItemCount(): Int {
        return sections.size
    }

    override fun onBindViewHolder(holder: CardViewHolder?, position: Int) {
        holder?.bind(sections[position])
        holder?.itemView?.add_notes?.setOnClickListener {
            sections[position].notes?.add(Note("", null))
            refresh()
        }

    }

    class CardViewHolder(itemView: View?) : RecyclerView.ViewHolder(itemView) {
        fun bind(section: Section){
            itemView.section_name.setText(section.name)
            itemView.section_summarize.setText(section.summarize)


            val notes = section.notes
            itemView.section_content_layout.removeAllViews()
            for (note in notes!!){
                val noteLayout = LayoutInflater.from(itemView.context).inflate(R.layout.note_item, itemView.section_content_layout, false)
                noteLayout.card_text.setText(note.text)
                itemView.section_content_layout.addView(noteLayout)
            }

        }
    }

    fun refresh(){
        notifyDataSetChanged()
    }
}