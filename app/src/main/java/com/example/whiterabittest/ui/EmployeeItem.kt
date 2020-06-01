package com.example.whiterabittest.ui

import com.example.whiterabittest.R
import com.example.whiterabittest.databinding.ItemEmployeeBinding
import com.example.whiterabittest.db.model.EmployeeData
import com.xwray.groupie.databinding.BindableItem



class EmployeeItem(

    private val emp: EmployeeData
) : BindableItem<ItemEmployeeBinding>(){

    override fun getLayout() = R.layout.item_employee

    override fun bind(viewBinding: ItemEmployeeBinding, position: Int) {
        viewBinding.setEmployeedata(emp)
    }
}