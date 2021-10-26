package com.eduardomaxwell.myfood.ui

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import co.tiagoaguiar.atway.ui.adapter.ATAdapter
import com.eduardomaxwell.myfood.R
import com.eduardomaxwell.myfood.databinding.FragmentRestarauntBinding
import com.eduardomaxwell.myfood.model.Category
import com.eduardomaxwell.myfood.model.FilterItem
import com.eduardomaxwell.myfood.model.toChip

class RestaurantFragment : Fragment(R.layout.fragment_restaraunt) {
    private var binding: FragmentRestarauntBinding? = null

    private val categoryAdapter = ATAdapter({
        CategoryView(it)
    })

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

        categoryAdapter.items = arrayListOf(
            Category(
                1,
                "https://www.ifood.com.br/static/images/categories/market.png",
                "Mercador",
                0xFFB6D048
            ),
            Category(
                2,
                "https://www.ifood.com.br/static/images/categories/restaurant.png",
                "Restaurante",
                0xFFE91D20
            ),
            Category(
                3,
                "https://www.ifood.com.br/static/images/categories/drinks.png",
                "Bebidas",
                0xFFF6D553
            ),
            Category(
                4,
                "https://www.ifood.com.br/static/images/categories/express.png",
                "Express",
                0xFFFF0000
            ),
            Category(
                5,
                "https://parceiros.ifood.com.br/static/media/salad.9db040c0.png",
                "Saudável",
                0xFFBC60C5
            ),
            Category(
                6,
                "https://www.ifood.com.br/static/images/categories/petshop.png",
                "Petshop",
                0xFFE91020
            ),
        )

        binding = FragmentRestarauntBinding.bind(view)

        binding?.let {
            it.rvCategory.layoutManager =
                LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
            it.rvCategory.adapter = categoryAdapter

            filters.forEach { filter ->
                it.chipGroupFilter.addView(filter.toChip(requireContext()))
            }
        }
    }
}