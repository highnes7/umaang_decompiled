package com.google.android.android.tagmanager;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.app.Dialog;
import android.content.ContextWrapper;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;

public class PreviewActivity
  extends Activity
{
  public PreviewActivity() {}
  
  public void onCreate(Bundle paramBundle)
  {
    try
    {
      super.onCreate(paramBundle);
      paramBundle = zzdj.zzjss;
      paramBundle.zzcq("Preview activity");
      paramBundle = getIntent().getData();
      boolean bool = TagManager.getInstance(this).get(paramBundle);
      if (!bool)
      {
        paramBundle = String.valueOf(paramBundle);
        i = paramBundle.length();
        localObject = new StringBuilder(i + 73);
        ((StringBuilder)localObject).append("Cannot preview the app with the uri: ");
        ((StringBuilder)localObject).append(paramBundle);
        ((StringBuilder)localObject).append(". Launching current version instead.");
        paramBundle = ((StringBuilder)localObject).toString();
        localObject = zzdj.zzjss;
        ((zzdk)localObject).zzcr(paramBundle);
        localObject = new AlertDialog.Builder(this).create();
        ((AlertDialog)localObject).setTitle("Preview failure");
        ((AlertDialog)localObject).setMessage(paramBundle);
        ((AlertDialog)localObject).setButton(-1, "Continue", new zzeh(this));
        ((Dialog)localObject).show();
      }
      Object localObject = getPackageManager().getLaunchIntentForPackage(getPackageName());
      if (localObject != null)
      {
        paramBundle = String.valueOf(getPackageName());
        i = paramBundle.length();
        if (i != 0) {
          paramBundle = "Invoke the launch activity for package name: ".concat(paramBundle);
        } else {
          paramBundle = new String("Invoke the launch activity for package name: ");
        }
        zzdk localZzdk = zzdj.zzjss;
        localZzdk.zzcq(paramBundle);
        startActivity((Intent)localObject);
        return;
      }
      paramBundle = String.valueOf(getPackageName());
      int i = paramBundle.length();
      if (i != 0) {
        paramBundle = "No launch activity found for package name: ".concat(paramBundle);
      } else {
        paramBundle = new String("No launch activity found for package name: ");
      }
      localObject = zzdj.zzjss;
      ((zzdk)localObject).zzcq(paramBundle);
      return;
    }
    catch (Exception paramBundle)
    {
      paramBundle = String.valueOf(paramBundle.getMessage());
      if (paramBundle.length() != 0) {
        paramBundle = "Calling preview threw an exception: ".concat(paramBundle);
      } else {
        paramBundle = new String("Calling preview threw an exception: ");
      }
      zzdj.zzjss.get(paramBundle);
    }
  }
}
