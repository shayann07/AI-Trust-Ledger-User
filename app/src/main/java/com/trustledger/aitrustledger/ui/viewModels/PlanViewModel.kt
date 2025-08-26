package com.trustledger.aitrustledger.ui.viewModels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.trustledger.aitrustledger.data.repository.BuyPlanRepo
import com.trustledger.aitrustledger.models.PlanModel
import com.trustledger.aitrustledger.utils.Status
import kotlinx.coroutines.launch

class PlanViewModel(private val buyPlanRepo: BuyPlanRepo) : ViewModel() {

    private val _userPlansLiveData = MutableLiveData<List<Map<String, Any>>>()
    val userPlansLiveData: LiveData<List<Map<String, Any>>> = _userPlansLiveData

    private var userId: String? = null

    fun initUserId(id: String) {
        userId = id
    }

    private val _allPlans = MutableLiveData<List<PlanModel>>()
    val allPlans: LiveData<List<PlanModel>> get() = _allPlans

    private val _planProgressLiveData =
        MutableLiveData<List<Int>>()  // Holds the list of progress values
    val planProgressLiveData: LiveData<List<Int>> get() = _planProgressLiveData

    fun fetchPlanProgress(userId: String) {
        buyPlanRepo.fetchPlanProgress(userId) { progressList ->
            _planProgressLiveData.postValue(progressList)  // Pass the list of progress values to the LiveData
        }
    }

    fun fetchFilteredPlans() {
        buyPlanRepo.getPlans().observeForever { plans ->
            _allPlans.postValue(plans)
        }
    }

    fun getStocksWalletTotal(): LiveData<Double> {
        return buyPlanRepo.getWalletTotalLive("stock_open", userId ?: "")
    }

    fun getMedicineWalletTotal(): LiveData<Double> {
        return buyPlanRepo.getWalletTotalLive("medicine_active", userId ?: "")
    }

    fun getForexWalletTotal(): LiveData<Double> {
        return buyPlanRepo.getWalletTotalLive("active", userId ?: "")
    }

    fun getPlans(): LiveData<List<PlanModel>> = buyPlanRepo.getPlans()


    fun fetchUserPlans(status: String, userId: String) {
        viewModelScope.launch {
            val plans = buyPlanRepo.getUsersByPlan(status, userId)
            _userPlansLiveData.postValue(plans)
        }
    }

    suspend fun sellPlan(docId: String): Status {
        return buyPlanRepo.sellStock(docId)
    }

    suspend fun sellForex(docId: String): Status {
        return buyPlanRepo.sellForex(docId)
    }
}
