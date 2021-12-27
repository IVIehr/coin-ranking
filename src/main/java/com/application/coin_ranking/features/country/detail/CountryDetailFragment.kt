package com.application.coin_ranking.features.country.detail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import com.application.coin_ranking.R
import com.application.coin_ranking.databinding.FragmentCountryDetailBinding
import com.application.coin_ranking.features.home.Spinner

class CountryDetailFragment : Fragment() {

    private lateinit var binding: FragmentCountryDetailBinding

    private val args by navArgs<CountryDetailFragmentArgs>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentCountryDetailBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.country = args.country
        setupSpinners()
    }

//    private fun setupSpinner() {
//        val spinner = Spinner
//        spinner.setupSpinner(
//            requireActivity(),
//            binding.spinnerCryptoComparison,
//            R.array.times,
//            this
//        )
//    }
private fun setupSpinners() {
    val spinner = Spinner
    spinner.setupSpinner(
        requireActivity(),
        binding.spinnerCryptoComparison,
        R.array.times,
        object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(
                parent: AdapterView<*>,
                view: View?,
                pos: Int,
                id: Long
            ) {
//                viewModel.setTimePeriod(parent.getItemAtPosition(pos).toString())
            }

            override fun onNothingSelected(parent: AdapterView<*>) {}
        }
    )
}
}