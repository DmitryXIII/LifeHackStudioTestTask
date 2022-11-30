package ru.avacodo.lifehackstudiotesttask.presentation.screens.list

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import ru.avacodo.lifehackstudiotesttask.databinding.FragmentCompaniesListItemBinding
import ru.avacodo.lifehackstudiotesttask.domain.model.CompanyShortDomain
import ru.avacodo.lifehackstudiotesttask.presentation.core.DiffUtilCallback
import ru.avacodo.lifehackstudiotesttask.presentation.loadImage

class CompaniesListAdapter(private val onClickAction: (id: String) -> Unit) :
    RecyclerView.Adapter<CompaniesListAdapter.CompaniesListViewHolder>() {

    private var dataList = listOf<CompanyShortDomain>()

    fun setData(mDataList: List<CompanyShortDomain>) {
        val diffUtilCallback = DiffUtilCallback(dataList, mDataList)
        dataList = mDataList
        DiffUtil.calculateDiff(diffUtilCallback).dispatchUpdatesTo(this)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CompaniesListViewHolder {
        return CompaniesListViewHolder(
            (FragmentCompaniesListItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false))
                .root)
    }

    override fun onBindViewHolder(holder: CompaniesListViewHolder, position: Int) {
        holder.bind(dataList[position])
    }

    override fun getItemCount() = dataList.size

    inner class CompaniesListViewHolder(view: View) : ViewHolder(view) {
        fun bind(company: CompanyShortDomain) {
            FragmentCompaniesListItemBinding.bind(itemView).apply {
                companyItemLogoImageView.loadImage(company.logoUrl)
                companyNameTextView.text = company.name
            }
            itemView.setOnClickListener {
                onClickAction.invoke(company.id)
            }
        }
    }
}