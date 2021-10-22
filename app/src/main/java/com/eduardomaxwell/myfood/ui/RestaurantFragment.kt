package com.eduardomaxwell.myfood.ui

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.eduardomaxwell.myfood.R
import com.eduardomaxwell.myfood.databinding.FragmentRestarauntBinding
import com.eduardomaxwell.myfood.model.FilterItem
import com.eduardomaxwell.myfood.model.toChip

class RestaurantFragment : Fragment(R.layout.fragment_restaraunt) {
    private var binding: FragmentRestarauntBinding? = null

    var filters = arrayOf(
        FilterItem(1, "Ordernar", closeIcon = R.drawable.ic_baseline_keyboard_arrow_down_24),
        FilterItem(2, "Para Retirar", icon = R.drawable.ic_baseline_directions_walk_24),
        FilterItem(3, "Entrega grátis"),
        FilterItem(4, "Vale-refeição", closeIcon = R.drawable.ic_baseline_keyboard_arrow_down_24),
        FilterItem(5, "Distância", closeIcon = R.drawable.ic_baseline_keyboard_arrow_down_24),
        FilterItem(6, "Entrega parceira"),
        FilterItem(7, "Super restaurante"),
        FilterItem(8, "Filtros", closeIcon = R.drawable.ic_baseline_filter_list_24)
    )

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding = FragmentRestarauntBinding.bind(view)

        binding?.let {
            filters.forEach { filter ->
                it.chipGroupFilter.addView(filter.toChip(requireContext()))
            }
        }
    }
}