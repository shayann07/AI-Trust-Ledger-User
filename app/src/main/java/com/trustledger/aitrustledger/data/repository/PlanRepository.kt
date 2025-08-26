package com.trustledger.aitrustledger.data.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.ListenerRegistration
import com.trustledger.aitrustledger.models.PlanModel
import com.trustledger.aitrustledger.utilsclass.Constants

class PlanRepository {


    private val db: FirebaseFirestore = FirebaseFirestore.getInstance()
    private var planListener: ListenerRegistration? = null



    fun     getPlans(): LiveData<List<PlanModel>> {
        val plansLiveData = MutableLiveData<List<PlanModel>>()

        planListener = db.collection(Constants.PLAN_COLLECTION)
            .addSnapshotListener { snapshots, e ->
                if (e != null) {
                    plansLiveData.value = emptyList()
                    return@addSnapshotListener
                }
                val recitations = snapshots?.documents?.mapNotNull { document ->
                    document.toObject(PlanModel::class.java)
                }
                plansLiveData.value = recitations ?: emptyList()
            }
        return plansLiveData
    }
}