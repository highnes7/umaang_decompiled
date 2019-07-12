package support.android.v4.asm.fingerprint;

import android.app.Notification.Builder;
import android.app.Notification.DecoratedMediaCustomViewStyle;
import android.app.Notification.Style;
import android.content.Context;
import android.content.res.Resources;
import android.os.Build.VERSION;
import android.support.v4.package_7.NotificationBuilderWithBuilderAccessor;
import android.support.v4.package_7.NotificationCompat.Builder;
import android.support.v4.package_7.NotificationCompat.Style;
import android.widget.RemoteViews;
import support.android.preference.R.color;
import support.android.preference.R.id;
import support.android.preference.R.layout;

public class ShowcaseViews
  extends ByteVector
{
  public ShowcaseViews() {}
  
  private void updateAppWidget(RemoteViews paramRemoteViews)
  {
    int i;
    if (mBuilder.getColor() != 0) {
      i = mBuilder.getColor();
    } else {
      i = mBuilder.mContext.getResources().getColor(R.color.notification_material_background_media_default_color);
    }
    paramRemoteViews.setInt(R.id.status_bar_latest_event_content, "setBackgroundColor", i);
  }
  
  public void apply(NotificationBuilderWithBuilderAccessor paramNotificationBuilderWithBuilderAccessor)
  {
    if (Build.VERSION.SDK_INT >= 24)
    {
      paramNotificationBuilderWithBuilderAccessor.getBuilder().setStyle((Notification.Style)add(new Notification.DecoratedMediaCustomViewStyle()));
      return;
    }
    super.apply(paramNotificationBuilderWithBuilderAccessor);
  }
  
  public int getBigLayoutResource(int paramInt)
  {
    if (paramInt <= 3) {
      return R.layout.notification_template_big_media_narrow_custom;
    }
    return R.layout.notification_template_big_media_custom;
  }
  
  public RemoteViews makeBigContentView(NotificationBuilderWithBuilderAccessor paramNotificationBuilderWithBuilderAccessor)
  {
    if (Build.VERSION.SDK_INT >= 24) {
      return null;
    }
    if (mBuilder.getBigContentView() != null) {
      paramNotificationBuilderWithBuilderAccessor = mBuilder.getBigContentView();
    } else {
      paramNotificationBuilderWithBuilderAccessor = mBuilder.getContentView();
    }
    if (paramNotificationBuilderWithBuilderAccessor == null) {
      return null;
    }
    RemoteViews localRemoteViews = generateBigContentView();
    buildIntoRemoteViews(localRemoteViews, paramNotificationBuilderWithBuilderAccessor);
    if (Build.VERSION.SDK_INT >= 21) {
      updateAppWidget(localRemoteViews);
    }
    return localRemoteViews;
  }
  
  public RemoteViews makeContentView(NotificationBuilderWithBuilderAccessor paramNotificationBuilderWithBuilderAccessor)
  {
    if (Build.VERSION.SDK_INT >= 24) {
      return null;
    }
    paramNotificationBuilderWithBuilderAccessor = mBuilder.getContentView();
    int k = 1;
    int i;
    if (paramNotificationBuilderWithBuilderAccessor != null) {
      i = 1;
    } else {
      i = 0;
    }
    if (Build.VERSION.SDK_INT >= 21)
    {
      int j = k;
      if (i == 0) {
        if (mBuilder.getBigContentView() != null) {
          j = k;
        } else {
          j = 0;
        }
      }
      if (j != 0)
      {
        paramNotificationBuilderWithBuilderAccessor = generateContentView();
        if (i != 0) {
          buildIntoRemoteViews(paramNotificationBuilderWithBuilderAccessor, mBuilder.getContentView());
        }
        updateAppWidget(paramNotificationBuilderWithBuilderAccessor);
        return paramNotificationBuilderWithBuilderAccessor;
      }
    }
    else
    {
      paramNotificationBuilderWithBuilderAccessor = generateContentView();
      if (i != 0)
      {
        buildIntoRemoteViews(paramNotificationBuilderWithBuilderAccessor, mBuilder.getContentView());
        return paramNotificationBuilderWithBuilderAccessor;
      }
    }
    return null;
  }
  
  public RemoteViews makeHeadsUpContentView(NotificationBuilderWithBuilderAccessor paramNotificationBuilderWithBuilderAccessor)
  {
    if (Build.VERSION.SDK_INT >= 24) {
      return null;
    }
    if (mBuilder.getHeadsUpContentView() != null) {
      paramNotificationBuilderWithBuilderAccessor = mBuilder.getHeadsUpContentView();
    } else {
      paramNotificationBuilderWithBuilderAccessor = mBuilder.getContentView();
    }
    if (paramNotificationBuilderWithBuilderAccessor == null) {
      return null;
    }
    RemoteViews localRemoteViews = generateBigContentView();
    buildIntoRemoteViews(localRemoteViews, paramNotificationBuilderWithBuilderAccessor);
    if (Build.VERSION.SDK_INT >= 21) {
      updateAppWidget(localRemoteViews);
    }
    return localRemoteViews;
  }
  
  public int show()
  {
    if (mBuilder.getContentView() != null) {
      return R.layout.notification_template_media_custom;
    }
    return R.layout.notification_template_media;
  }
}
