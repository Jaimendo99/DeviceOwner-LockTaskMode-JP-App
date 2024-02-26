package com.app.cellarius

import android.app.admin.DeviceAdminReceiver
import android.app.admin.DevicePolicyManager
import android.content.ComponentName
import android.content.Context
import android.util.Log
import androidx.core.content.ContextCompat.getSystemService

class DeviceAdminBReceiver : DeviceAdminReceiver() {
    override fun onEnabled(context: android.content.Context, intent: android.content.Intent) {
        super.onEnabled(context, intent)

        allowLockTaskModeToThisApp(context, context!!.packageName)

        Log.d("DeviceAdminBReceiver", "onEnabled")
    }

    override fun onDisabled(context: android.content.Context, intent: android.content.Intent) {
        super.onDisabled(context, intent)
        Log.d("DeviceAdminBReceiver", "onDisabled")
    }

    override fun onLockTaskModeEntering(context: android.content.Context, intent: android.content.Intent, pkg: String) {
        super.onLockTaskModeEntering(context, intent, pkg)
        Log.d("DeviceAdminBReceiver", "onLockTaskModeEntering")
    }

    override fun onLockTaskModeExiting(context: android.content.Context, intent: android.content.Intent) {
        super.onLockTaskModeExiting(context, intent)
        Log.d("DeviceAdminBReceiver", "onLockTaskModeExiting")
    }

    private fun allowLockTaskModeToThisApp(context: android.content.Context, packageName: String) {
        val dpm = context!!.getSystemService(Context.DEVICE_POLICY_SERVICE) as DevicePolicyManager
        val deviceAdmin = ComponentName(context!!, DeviceAdminBReceiver::class.java)
        dpm.setLockTaskPackages(deviceAdmin, arrayOf(packageName))
    }
}