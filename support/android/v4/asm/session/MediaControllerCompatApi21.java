package support.android.v4.asm.session;

import android.app.Activity;
import android.app.PendingIntent;
import android.content.Context;
import android.media.AudioAttributes;
import android.media.session.MediaController;
import android.media.session.MediaController.Callback;
import android.media.session.MediaController.PlaybackInfo;
import android.media.session.MediaSession.Token;
import android.os.Bundle;
import android.os.Handler;
import android.os.ResultReceiver;
import android.view.KeyEvent;
import b.b.a.K;
import java.util.ArrayList;
import java.util.List;

@K(21)
public class MediaControllerCompatApi21
{
  public MediaControllerCompatApi21() {}
  
  public static void adjustVolume(Object paramObject, int paramInt1, int paramInt2)
  {
    ((MediaController)paramObject).adjustVolume(paramInt1, paramInt2);
  }
  
  public static boolean dispatchMediaButtonEvent(Object paramObject, KeyEvent paramKeyEvent)
  {
    return ((MediaController)paramObject).dispatchMediaButtonEvent(paramKeyEvent);
  }
  
  public static Object fromToken(Context paramContext, Object paramObject)
  {
    return new MediaController(paramContext, (MediaSession.Token)paramObject);
  }
  
  public static Bundle getExtras(Object paramObject)
  {
    return ((MediaController)paramObject).getExtras();
  }
  
  public static long getFlags(Object paramObject)
  {
    return ((MediaController)paramObject).getFlags();
  }
  
  public static Object getMediaController(Activity paramActivity)
  {
    return paramActivity.getMediaController();
  }
  
  public static Object getMetadata(Object paramObject)
  {
    return ((MediaController)paramObject).getMetadata();
  }
  
  public static String getPackageName(Object paramObject)
  {
    return ((MediaController)paramObject).getPackageName();
  }
  
  public static Object getPlaybackInfo(Object paramObject)
  {
    return ((MediaController)paramObject).getPlaybackInfo();
  }
  
  public static Object getPlaybackState(Object paramObject)
  {
    return ((MediaController)paramObject).getPlaybackState();
  }
  
  public static List getQueue(Object paramObject)
  {
    paramObject = ((MediaController)paramObject).getQueue();
    if (paramObject == null) {
      return null;
    }
    return new ArrayList(paramObject);
  }
  
  public static CharSequence getQueueTitle(Object paramObject)
  {
    return ((MediaController)paramObject).getQueueTitle();
  }
  
  public static int getRatingType(Object paramObject)
  {
    return ((MediaController)paramObject).getRatingType();
  }
  
  public static PendingIntent getSessionActivity(Object paramObject)
  {
    return ((MediaController)paramObject).getSessionActivity();
  }
  
  public static Object getSessionToken(Object paramObject)
  {
    return ((MediaController)paramObject).getSessionToken();
  }
  
  public static Object getTransportControls(Object paramObject)
  {
    return ((MediaController)paramObject).getTransportControls();
  }
  
  public static Object registerCallback(MediaControllerCompat.Callback paramCallback)
  {
    return new MediaControllerCompat.Callback.StubCompat(paramCallback);
  }
  
  public static void registerCallback(Object paramObject1, Object paramObject2, Handler paramHandler)
  {
    ((MediaController)paramObject1).registerCallback((MediaController.Callback)paramObject2, paramHandler);
  }
  
  public static void sendCommand(Object paramObject, String paramString, Bundle paramBundle, ResultReceiver paramResultReceiver)
  {
    ((MediaController)paramObject).sendCommand(paramString, paramBundle, paramResultReceiver);
  }
  
  public static void setMediaController(Activity paramActivity, Object paramObject)
  {
    paramActivity.setMediaController((MediaController)paramObject);
  }
  
  public static void setVolumeTo(Object paramObject, int paramInt1, int paramInt2)
  {
    ((MediaController)paramObject).setVolumeTo(paramInt1, paramInt2);
  }
  
  public static void unregisterCallback(Object paramObject1, Object paramObject2)
  {
    ((MediaController)paramObject1).unregisterCallback((MediaController.Callback)paramObject2);
  }
  
  public class PlaybackInfo
  {
    public static final int FLAG_SCO = 4;
    public static final int STREAM_BLUETOOTH_SCO = 6;
    public static final int STREAM_SYSTEM_ENFORCED = 7;
    
    public PlaybackInfo() {}
    
    public static AudioAttributes getAudioAttributes(Object paramObject)
    {
      return ((MediaController.PlaybackInfo)paramObject).getAudioAttributes();
    }
    
    public static int getCurrentVolume(Object paramObject)
    {
      return ((MediaController.PlaybackInfo)paramObject).getCurrentVolume();
    }
    
    public static int getLegacyAudioStream(Object paramObject)
    {
      return toLegacyStreamType(getAudioAttributes(paramObject));
    }
    
    public static int getMaxVolume(Object paramObject)
    {
      return ((MediaController.PlaybackInfo)paramObject).getMaxVolume();
    }
    
    public static int getPlaybackType(Object paramObject)
    {
      return ((MediaController.PlaybackInfo)paramObject).getPlaybackType();
    }
    
    public static int getVolumeControl(Object paramObject)
    {
      return ((MediaController.PlaybackInfo)paramObject).getVolumeControl();
    }
    
    public static int toLegacyStreamType(AudioAttributes paramAudioAttributes)
    {
      if ((paramAudioAttributes.getFlags() & 0x1) == 1) {
        return 7;
      }
      if ((paramAudioAttributes.getFlags() & 0x4) == 4) {
        return 6;
      }
      switch (paramAudioAttributes.getUsage())
      {
      default: 
        return 3;
      case 13: 
        return 1;
      case 6: 
        return 2;
      case 5: 
      case 7: 
      case 8: 
      case 9: 
      case 10: 
        return 5;
      case 4: 
        return 4;
      case 3: 
        return 8;
      case 2: 
        return 0;
      }
      return 3;
    }
  }
}
