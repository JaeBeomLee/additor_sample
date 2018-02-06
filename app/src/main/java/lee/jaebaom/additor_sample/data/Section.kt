package lee.jaebaom.additor_sample.data

/**
 * Created by leejaebeom on 2018. 2. 4..
 */
data class Section (val name: String, val summarize: String, val notes: ArrayList<Note>?)

data class Note(var text: String?, val links: ArrayList<String>?)
//Note O, Link O
//Note O, Link X
//Note X, Link O
//Note O -> several Links O
//Note X -> several Links X