package com.example.project

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.project.databinding.ItemCategoryBinding

// ArrayList<모델 클래스>: 모델 클래스를 불러와서 리스트화 시킴.
class AdapterCategory(val categoryList: ArrayList<CategoryWorries>) : RecyclerView.Adapter<AdapterCategory.ProfileViewHolder>(){

    class ProfileViewHolder(val binding: ItemCategoryBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProfileViewHolder {
        // 변수 view: activity_itemcategory의 정보를 가져와서 어뎁터와 연결.
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_category, parent, false)
        return ProfileViewHolder(ItemCategoryBinding.bind(view))
    }

    override fun getItemCount(): Int {
        return categoryList.size
    }

    // 리스트뷰를 계속 사용할 때, onBindViewHolder가 지속적으로 호출이 되면서 모든 데이터들을 연결.
    override fun onBindViewHolder(holder: ProfileViewHolder, position: Int) {
        holder.binding.ivCategoryicon.setImageResource(categoryList.get(position).icon)   // position: 현재 클릭한 것의 인덱스 번호.
        holder.binding.tvCategoryworrylist.text = categoryList.get(position).cate
        holder.binding.imgNextC.setImageResource(categoryList.get(position).nextC)
    }
}