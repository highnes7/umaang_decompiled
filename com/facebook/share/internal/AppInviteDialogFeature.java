package com.facebook.share.internal;

import com.facebook.internal.DialogFeature;

public enum AppInviteDialogFeature
  implements DialogFeature
{
  APP_INVITES_DIALOG(20140701);
  
  public int minVersion;
  
  public AppInviteDialogFeature(int paramInt)
  {
    minVersion = paramInt;
  }
  
  public String getAction()
  {
    return "com.facebook.platform.action.request.APPINVITES_DIALOG";
  }
  
  public int getMinVersion()
  {
    return minVersion;
  }
}
