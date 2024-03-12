package com.app.cellarius

import android.app.admin.DeviceAdminReceiver
import android.app.admin.DevicePolicyManager
import android.content.ComponentName
import android.content.Context
import android.content.Context.DEVICE_POLICY_SERVICE
import android.content.Intent
import android.util.Log
import android.widget.Toast

class DeviceAdminBReceiver : DeviceAdminReceiver() {

    override fun onEnabled(context:Context, intent: Intent) {
        super.onEnabled(context, intent)


        Log.d("DeviceAdminBReceiver", "onEnabled")
    }

    override fun onDisabled(context: Context, intent:Intent) {
        super.onDisabled(context, intent)
        Log.d("DeviceAdminBReceiver", "onDisabled")
    }

    override fun onLockTaskModeEntering(context: Context, intent: Intent, pkg: String) {
        super.onLockTaskModeEntering(context, intent, pkg)
        Log.d("DeviceAdminBReceiver", "onLockTaskModeEntering")
    }

    override fun onLockTaskModeExiting(context: Context, intent: Intent) {
        super.onLockTaskModeExiting(context, intent)
        Log.d("DeviceAdminBReceiver", "onLockTaskModeExiting")
    }

    fun allowLockTaskModeToThisApp(context: Context, packageName: String) {
        val dpm = context.getSystemService(DEVICE_POLICY_SERVICE) as DevicePolicyManager
        val deviceAdmin = ComponentName(context, DeviceAdminBReceiver::class.java)
        dpm.setLockTaskPackages(deviceAdmin, arrayOf(packageName))
    }

    private val TAG = "DeviceOwnerReceiver"

    @Override
    override fun onProfileProvisioningComplete(context: Context, intent: Intent) {
        super.onProfileProvisioningComplete(context, intent)

        val toastText = "Profile provisioning complete"
        Toast.makeText(context, toastText, Toast.LENGTH_LONG).show()

        Log.d(TAG, "onProfileProvisioningComplete")
    }

}