package lee.jaebaom.additor_sample

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.helper.ItemTouchHelper
import kotlinx.android.synthetic.main.activity_main.*
import lee.jaebaom.additor_sample.data.Note
import lee.jaebaom.additor_sample.data.Section

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val sections = ArrayList<Section>()
        val adapter = ProjectAdapter(sections)
        val helper = ItemTouchHelper(CardCallback(adapter))

        recycler.adapter = adapter
        helper.attachToRecyclerView(recycler)

        fab.setOnClickListener {
            val notes = ArrayList<Note>()
            sections.add(Section("", "", notes))
            adapter.refresh()
        }
    }
}
