package support.android.v4.asm.session;

import android.media.session.PlaybackState;
import android.media.session.PlaybackState.Builder;
import android.media.session.PlaybackState.CustomAction;
import b.b.a.K;
import java.util.Iterator;
import java.util.List;

@K(21)
public class PlaybackStateCompat
{
  public PlaybackStateCompat() {}
  
  public static long getActions(Object paramObject)
  {
    return ((PlaybackState)paramObject).getActions();
  }
  
  public static long getActiveQueueItemId(Object paramObject)
  {
    return ((PlaybackState)paramObject).getActiveQueueItemId();
  }
  
  public static long getBufferedPosition(Object paramObject)
  {
    return ((PlaybackState)paramObject).getBufferedPosition();
  }
  
  public static List getCustomActions(Object paramObject)
  {
    return ((PlaybackState)paramObject).getCustomActions();
  }
  
  public static CharSequence getErrorMessage(Object paramObject)
  {
    return ((PlaybackState)paramObject).getErrorMessage();
  }
  
  public static long getLastPositionUpdateTime(Object paramObject)
  {
    return ((PlaybackState)paramObject).getLastPositionUpdateTime();
  }
  
  public static float getPlaybackSpeed(Object paramObject)
  {
    return ((PlaybackState)paramObject).getPlaybackSpeed();
  }
  
  public static long getPosition(Object paramObject)
  {
    return ((PlaybackState)paramObject).getPosition();
  }
  
  public static int getState(Object paramObject)
  {
    return ((PlaybackState)paramObject).getState();
  }
  
  public static Object newInstance(int paramInt, long paramLong1, long paramLong2, float paramFloat, long paramLong3, CharSequence paramCharSequence, long paramLong4, List paramList, long paramLong5)
  {
    PlaybackState.Builder localBuilder = new PlaybackState.Builder();
    localBuilder.setState(paramInt, paramLong1, paramFloat, paramLong4);
    localBuilder.setBufferedPosition(paramLong2);
    localBuilder.setActions(paramLong3);
    localBuilder.setErrorMessage(paramCharSequence);
    paramCharSequence = paramList.iterator();
    while (paramCharSequence.hasNext()) {
      localBuilder.addCustomAction((PlaybackState.CustomAction)paramCharSequence.next());
    }
    localBuilder.setActiveQueueItemId(paramLong5);
    return localBuilder.build();
  }
}
