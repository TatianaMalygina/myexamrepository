package com.tatika.examapplication

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView


class CatalogFragment : Fragment() {

    private lateinit var toyImageView: ImageView
    private lateinit var buyButton: Button

    private val toyImageList: List<Int> = listOf(
        R.drawable.dolphin_toy,
        R.drawable.bear_toy,
        R.drawable.cat_toy,
    )

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
val view = inflater.inflate(R.layout.fragment_catalog, container, false)

        toyImageView = view.findViewById(R.id.toy_image_view)
        buyButton = view.findViewById(R.id.buy_button)

        buyButton.setOnClickListener{
            toyImageView.setImageResource(toyImageList.random())
        }
        return view
    }

}