package com.example.project

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.project.databinding.ItemDateBinding

class AdapterDate: RecyclerView.Adapter<AdapterDate.MyView>() {

    val data = mapOf(
        "걱정1" to listOf("걱정된다", "해결법"),
        "걱정2" to listOf("으아아아아아아아아아아아아아아아아아아아아아아아아악"),
        "걱정3" to listOf("걱정하지말자"),
        "걱정4" to listOf("파이팅", "해결법")
    )

    inner class MyView(private val binding: ItemDateBinding) :
        RecyclerView.ViewHolder(binding.root) {
        init {   // 화살표가 움직이도록 애니메이션 적용.
            binding.layoutDate.setOnClickListener {
                if (binding.layoutDetailDate.visibility == View.VISIBLE) {
                    binding.layoutDetailDate.visibility = View.GONE
                    binding.imgbtnNextD.animate().apply {
                        duration = 200
                        rotation(0f)
                    }
                } else {
                    binding.layoutDetailDate.visibility = View.VISIBLE
                    binding.imgbtnNextD.animate().apply {
                        duration = 200
                        rotation(180f)
                    }
                }
            }
        }

        fun bind(pos: Int) {
            binding.tvDateworrylist.text = data.keys.elementAt(pos)
            data.values.elementAt(pos).forEach {
                val view = TextView(binding.root.context).apply {
                    text = "- ${it}"
                    textSize = 13f
                    setPadding(50, 50, 50, 50)   // 여백
                }
                binding.layoutDetailDate.addView(view)
            }
        }
    }

//    생성된 뷰 홀더에 값 지정. (원래 MyView 대신 DateWorriesViewHolder)
//    class DateWorriesViewHolder(val binding: DateWorriesBinding) : RecyclerView.ViewHolder(binding.root)

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyView {
            // 변수 view: date_worries.xml의 정보를 가져와서 어뎁터와 연결.
            val view =
                LayoutInflater.from(parent.context).inflate(R.layout.item_date, parent, false)
            return MyView(ItemDateBinding.bind(view))
        }

        override fun getItemCount(): Int {
            return data.size
        }

        // 리스트뷰를 계속 사용할 때, onBindViewHolder가 지속적으로 호출이 되면서 모든 데이터들을 연결.
        override fun onBindViewHolder(holder: MyView, position: Int) {
            holder.bind(position)
//            holder.binding.tvDateworrylist.text = dateWorriesList.get(position).dateWorry
//            holder.binding.imgbtnNext.setImageResource(dateWorriesList.get(position).next)
        }
    }