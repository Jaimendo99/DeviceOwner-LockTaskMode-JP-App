package com.app.cellarius

import android.os.Build
import android.os.Bundle
import android.os.PersistableBundle
import androidx.annotation.RequiresApi
import androidx.core.app.ComponentActivity

class AdminPolicyComplianceActivity : ComponentActivity() {

    @RequiresApi(Build.VERSION_CODES.Q)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_admin_policy_compliance)
        setResult(RESULT_OK, intent);
        finish();
    }
}