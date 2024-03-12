package com.app.cellarius

import android.os.Bundle
import androidx.core.app.ComponentActivity

class ProvisioningModeActivity : ComponentActivity()
{
    private val EXTRA_PROVISIONING_ALLOWED_PROVISIONING_MODES = "android.app.extra.PROVISIONING_ALLOWED_PROVISIONING_MODES";
    private val PROVISIONING_MODE_FULLOY_MANAGED_DEVICE = 1;
    private val PROVISIONING_MODE_MANAGED_PROFILE = 2;
    private val EXTRA_PROVISIONING_MODE = "android.app.extra.PROVISIONING_MODE";

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_provisioning_mode)

        var provisioningMode = PROVISIONING_MODE_MANAGED_PROFILE;
        val allowedProvisioningModes =
            intent.getIntArrayExtra(EXTRA_PROVISIONING_ALLOWED_PROVISIONING_MODES);

        if(allowedProvisioningModes != null){
                provisioningMode = if (allowedProvisioningModes.contains(PROVISIONING_MODE_FULLOY_MANAGED_DEVICE)){
                    PROVISIONING_MODE_FULLOY_MANAGED_DEVICE
                } else { PROVISIONING_MODE_MANAGED_PROFILE }
            }

        intent.putExtra(EXTRA_PROVISIONING_MODE, provisioningMode);
        setResult(RESULT_OK, intent);
        finish();

    }


    }