package com.facebook.internal;

import android.content.Intent;
import java.util.UUID;

public class AppCall
{
  public static AppCall currentPendingCall;
  public UUID callId;
  public int requestCode;
  public Intent requestIntent;
  
  public AppCall(int paramInt)
  {
    callId = localUUID;
    requestCode = paramInt;
  }
  
  public AppCall(int paramInt, UUID paramUUID)
  {
    callId = paramUUID;
    requestCode = paramInt;
  }
  
  public static AppCall finishPendingCall(UUID paramUUID, int paramInt)
  {
    try
    {
      AppCall localAppCall = currentPendingCall;
      if ((localAppCall != null) && (localAppCall.getCallId().equals(paramUUID)) && (localAppCall.getRequestCode() == paramInt))
      {
        setCurrentPendingCall(null);
        return localAppCall;
      }
    }
    catch (Throwable paramUUID)
    {
      break label52;
      return null;
      label52:
      throw paramUUID;
    }
  }
  
  public static AppCall getCurrentPendingCall()
  {
    return currentPendingCall;
  }
  
  public static boolean setCurrentPendingCall(AppCall paramAppCall)
  {
    try
    {
      AppCall localAppCall = currentPendingCall;
      currentPendingCall = paramAppCall;
      boolean bool;
      if (localAppCall != null) {
        bool = true;
      } else {
        bool = false;
      }
      return bool;
    }
    catch (Throwable paramAppCall)
    {
      throw paramAppCall;
    }
  }
  
  public UUID getCallId()
  {
    return callId;
  }
  
  public int getRequestCode()
  {
    return requestCode;
  }
  
  public Intent getRequestIntent()
  {
    return requestIntent;
  }
  
  public boolean setPending()
  {
    return setCurrentPendingCall(this);
  }
  
  public void setRequestCode(int paramInt)
  {
    requestCode = paramInt;
  }
  
  public void setRequestIntent(Intent paramIntent)
  {
    requestIntent = paramIntent;
  }
}
