package com.application.coin_ranking.features.country.list

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.application.coin_ranking.R
import com.application.coin_ranking.data.model.Country
import com.application.coin_ranking.databinding.FragmentCountriesListBinding
import com.application.coin_ranking.features.country.CountryViewModel
import com.application.coin_ranking.features.home.Spinner

class CountriesListFragment : Fragment() {

    private val countryViewModel: CountryViewModel by viewModels()
    private lateinit var listAdapter: CountryListAdapter
    private lateinit var recyclerView: RecyclerView

    private lateinit var binding: FragmentCountriesListBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentCountriesListBinding.inflate(inflater, container, false)
        val view = binding.root
        setupRecyclerView()
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initViewsRecyclerView()
        initValuesRecyclerView()
        setupSpinner()
    }

    override fun onResume() {
        super.onResume()
    }

    private fun setupSpinner() {
        val spinner = Spinner
        spinner.setupSpinner(
            requireActivity(),
            binding.spinnerHomeTime,
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

    //setup recyclerView
    private fun setupRecyclerView() {
        listAdapter = CountryListAdapter{
            navigateToDetailFragment(it)
        }
    }

    private fun initValuesRecyclerView() {
        countryViewModel.returnFilteredList()
        countryViewModel.countryLiveData.observe(requireActivity()) {
            val list = it
            with(listAdapter) {
                submitList(list)
            }
        }
    }

    private fun initViewsRecyclerView() {
        recyclerView = requireView().findViewById(R.id.rv_home_recycler_view) as RecyclerView
        with(recyclerView) {
            setHasFixedSize(true)
            adapter = listAdapter
        }
    }

    private fun navigateToDetailFragment(country: Country){
        val navigate =
            CountriesListFragmentDirections.actionCountryListFragmentToDetail(
                country
            )
        findNavController().navigate(navigate)
    }
}