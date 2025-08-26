package com.trustledger.aitrustledger.ui.viewModels


import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.trustledger.aitrustledger.data.repository.BuyPlanRepo

class PlanViewModelFactory(private val buyPlanRepo: BuyPlanRepo) : ViewModelProvider.Factory {

    override  fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(PlanViewModel::class.java)) {
            return PlanViewModel(buyPlanRepo) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}
