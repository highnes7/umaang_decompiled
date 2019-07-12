package support.android.v4.asm.fingerprint;

import android.app.Notification;
import android.app.Notification.Builder;
import android.app.Notification.MediaStyle;
import android.app.Notification.Style;
import android.app.PendingIntent;
import android.content.Context;
import android.content.res.Resources;
import android.media.session.MediaSession.Token;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.support.v4.media.session.MediaSessionCompat.Token;
import android.support.v4.package_7.BundleCompat;
import android.support.v4.package_7.NotificationBuilderWithBuilderAccessor;
import android.support.v4.package_7.NotificationCompat;
import android.support.v4.package_7.NotificationCompat.Action;
import android.support.v4.package_7.NotificationCompat.Builder;
import android.support.v4.package_7.NotificationCompat.Style;
import android.widget.RemoteViews;
import java.util.ArrayList;
import support.android.preference.R.id;
import support.android.preference.R.integer;
import support.android.preference.R.layout;

public class ByteVector
  extends NotificationCompat.Style
{
  public static final int TRANSACTION_getInfo = 5;
  public static final int b = 3;
  public MediaSessionCompat.Token a;
  public PendingIntent cancel_action;
  public boolean media_actions;
  public int[] size = null;
  
  public ByteVector() {}
  
  public ByteVector(NotificationCompat.Builder paramBuilder)
  {
    setBuilder(paramBuilder);
  }
  
  private RemoteViews generateMediaActionButton(NotificationCompat.Action paramAction)
  {
    if (paramAction.getActionIntent() == null) {
      i = 1;
    } else {
      i = 0;
    }
    RemoteViews localRemoteViews = new RemoteViews(mBuilder.mContext.getPackageName(), R.layout.notification_media_action);
    localRemoteViews.setImageViewResource(R.id.action0, paramAction.getIcon());
    if (i == 0) {
      localRemoteViews.setOnClickPendingIntent(R.id.action0, paramAction.getActionIntent());
    }
    int i = Build.VERSION.SDK_INT;
    localRemoteViews.setContentDescription(R.id.action0, paramAction.getTitle());
    return localRemoteViews;
  }
  
  public static MediaSessionCompat.Token get(Notification paramNotification)
  {
    paramNotification = NotificationCompat.getExtras(paramNotification);
    if (paramNotification != null) {
      if (Build.VERSION.SDK_INT >= 21)
      {
        paramNotification = paramNotification.getParcelable("android.mediaSession");
        if (paramNotification != null) {
          return MediaSessionCompat.Token.fromToken(paramNotification);
        }
      }
      else
      {
        Object localObject = BundleCompat.getBinder(paramNotification, "android.mediaSession");
        if (localObject != null)
        {
          paramNotification = Parcel.obtain();
          paramNotification.writeStrongBinder((IBinder)localObject);
          paramNotification.setDataPosition(0);
          localObject = (MediaSessionCompat.Token)MediaSessionCompat.Token.CREATOR.createFromParcel(paramNotification);
          paramNotification.recycle();
          return localObject;
        }
      }
    }
    return null;
  }
  
  public ByteVector a(boolean paramBoolean)
  {
    if (Build.VERSION.SDK_INT < 21) {
      media_actions = paramBoolean;
    }
    return this;
  }
  
  public Notification.MediaStyle add(Notification.MediaStyle paramMediaStyle)
  {
    Object localObject = size;
    if (localObject != null) {
      paramMediaStyle.setShowActionsInCompactView((int[])localObject);
    }
    localObject = a;
    if (localObject != null) {
      paramMediaStyle.setMediaSession((MediaSession.Token)((MediaSessionCompat.Token)localObject).get());
    }
    return paramMediaStyle;
  }
  
  public void apply(NotificationBuilderWithBuilderAccessor paramNotificationBuilderWithBuilderAccessor)
  {
    if (Build.VERSION.SDK_INT >= 21)
    {
      paramNotificationBuilderWithBuilderAccessor.getBuilder().setStyle((Notification.Style)add(new Notification.MediaStyle()));
      return;
    }
    if (media_actions) {
      paramNotificationBuilderWithBuilderAccessor.getBuilder().setOngoing(true);
    }
  }
  
  public ByteVector b(MediaSessionCompat.Token paramToken)
  {
    a = paramToken;
    return this;
  }
  
  public RemoteViews generateBigContentView()
  {
    Object localObject = mBuilder;
    ByteVector localByteVector = this;
    int j = Math.min(mActions.size(), 5);
    RemoteViews localRemoteViews = localByteVector.applyStandardTemplate(false, localByteVector.getBigLayoutResource(j), false);
    localRemoteViews.removeAllViews(R.id.media_actions);
    localObject = localByteVector;
    if (j > 0)
    {
      int i = 0;
      for (;;)
      {
        localObject = localByteVector;
        if (i >= j) {
          break;
        }
        localObject = mBuilder;
        localObject = localByteVector.generateMediaActionButton((NotificationCompat.Action)mActions.get(i));
        localRemoteViews.addView(R.id.media_actions, (RemoteViews)localObject);
        i += 1;
      }
    }
    if (media_actions)
    {
      localRemoteViews.setViewVisibility(R.id.cancel_action, 0);
      localRemoteViews.setInt(R.id.cancel_action, "setAlpha", mBuilder.mContext.getResources().getInteger(R.integer.cancel_button_image_alpha));
      localRemoteViews.setOnClickPendingIntent(R.id.cancel_action, cancel_action);
      return localRemoteViews;
    }
    localRemoteViews.setViewVisibility(R.id.cancel_action, 8);
    return localRemoteViews;
  }
  
  public RemoteViews generateContentView()
  {
    RemoteViews localRemoteViews = applyStandardTemplate(false, show(), true);
    int k = mBuilder.mActions.size();
    Object localObject = size;
    int i;
    if (localObject == null) {
      i = 0;
    } else {
      i = Math.min(localObject.length, 3);
    }
    localRemoteViews.removeAllViews(R.id.media_actions);
    if (i > 0)
    {
      int j = 0;
      while (j < i) {
        if (j < k)
        {
          localObject = generateMediaActionButton((NotificationCompat.Action)mBuilder.mActions.get(size[j]));
          localRemoteViews.addView(R.id.media_actions, (RemoteViews)localObject);
          j += 1;
        }
        else
        {
          throw new IllegalArgumentException(String.format("setShowActionsInCompactView: action %d out of bounds (max %d)", new Object[] { Integer.valueOf(j), Integer.valueOf(k - 1) }));
        }
      }
    }
    if (media_actions)
    {
      localRemoteViews.setViewVisibility(R.id.end_padder, 8);
      localRemoteViews.setViewVisibility(R.id.cancel_action, 0);
      localRemoteViews.setOnClickPendingIntent(R.id.cancel_action, cancel_action);
      localRemoteViews.setInt(R.id.cancel_action, "setAlpha", mBuilder.mContext.getResources().getInteger(R.integer.cancel_button_image_alpha));
      return localRemoteViews;
    }
    localRemoteViews.setViewVisibility(R.id.end_padder, 0);
    localRemoteViews.setViewVisibility(R.id.cancel_action, 8);
    return localRemoteViews;
  }
  
  public int getBigLayoutResource(int paramInt)
  {
    if (paramInt <= 3) {
      return R.layout.notification_template_big_media_narrow;
    }
    return R.layout.notification_template_big_media;
  }
  
  public RemoteViews makeBigContentView(NotificationBuilderWithBuilderAccessor paramNotificationBuilderWithBuilderAccessor)
  {
    if (Build.VERSION.SDK_INT >= 21) {
      return null;
    }
    return generateBigContentView();
  }
  
  public RemoteViews makeContentView(NotificationBuilderWithBuilderAccessor paramNotificationBuilderWithBuilderAccessor)
  {
    if (Build.VERSION.SDK_INT >= 21) {
      return null;
    }
    return generateContentView();
  }
  
  public ByteVector putUTF8(PendingIntent paramPendingIntent)
  {
    cancel_action = paramPendingIntent;
    return this;
  }
  
  public int show()
  {
    return R.layout.notification_template_media;
  }
  
  public ByteVector write(int... paramVarArgs)
  {
    size = paramVarArgs;
    return this;
  }
}
