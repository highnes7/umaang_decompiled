package android.support.v4.package_7;

import android.app.Notification;
import android.app.Notification.Action.Builder;
import android.app.Notification.Builder;
import android.app.PendingIntent;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.SparseArray;
import android.widget.RemoteViews;
import b.b.a.N;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@N({b.b.a.N.a.b})
public class NotificationCompatBuilder
  implements NotificationBuilderWithBuilderAccessor
{
  public final List<Bundle> mActionExtrasList = new ArrayList();
  public RemoteViews mBigContentView;
  public final Notification.Builder mBuilder;
  public final NotificationCompat.Builder mBuilderCompat;
  public RemoteViews mContentView;
  public final Bundle mExtras = new Bundle();
  public int mGroupAlertBehavior;
  public RemoteViews mHeadsUpContentView;
  
  public NotificationCompatBuilder(NotificationCompat.Builder paramBuilder)
  {
    mBuilderCompat = paramBuilder;
    if (Build.VERSION.SDK_INT >= 26) {
      mBuilder = new Notification.Builder(mContext, mChannelId);
    } else {
      mBuilder = new Notification.Builder(mContext);
    }
    Object localObject1 = mNotification;
    Object localObject2 = mBuilder.setWhen(when).setSmallIcon(icon, iconLevel).setContent(contentView).setTicker(tickerText, mTickerView).setVibrate(vibrate).setLights(ledARGB, ledOnMS, ledOffMS);
    boolean bool;
    if ((flags & 0x2) != 0) {
      bool = true;
    } else {
      bool = false;
    }
    localObject2 = ((Notification.Builder)localObject2).setOngoing(bool);
    if ((flags & 0x8) != 0) {
      bool = true;
    } else {
      bool = false;
    }
    localObject2 = ((Notification.Builder)localObject2).setOnlyAlertOnce(bool);
    if ((flags & 0x10) != 0) {
      bool = true;
    } else {
      bool = false;
    }
    localObject2 = ((Notification.Builder)localObject2).setAutoCancel(bool).setDefaults(defaults).setContentTitle(mContentTitle).setContentText(mContentText).setContentInfo(mContentInfo).setContentIntent(mContentIntent).setDeleteIntent(deleteIntent);
    Object localObject3 = mFullScreenIntent;
    if ((flags & 0x80) != 0) {
      bool = true;
    } else {
      bool = false;
    }
    ((Notification.Builder)localObject2).setFullScreenIntent((PendingIntent)localObject3, bool).setLargeIcon(mLargeIcon).setNumber(mNumber).setProgress(mProgressMax, mProgress, mProgressIndeterminate);
    if (Build.VERSION.SDK_INT < 21) {
      mBuilder.setSound(sound, audioStreamType);
    }
    int i = Build.VERSION.SDK_INT;
    mBuilder.setSubText(mSubText).setUsesChronometer(mUseChronometer).setPriority(mPriority);
    localObject2 = mActions.iterator();
    while (((Iterator)localObject2).hasNext()) {
      addAction((NotificationCompat.Action)((Iterator)localObject2).next());
    }
    localObject2 = mExtras;
    if (localObject2 != null) {
      mExtras.putAll((Bundle)localObject2);
    }
    if (Build.VERSION.SDK_INT < 20)
    {
      if (mLocalOnly) {
        mExtras.putBoolean("android.support.localOnly", true);
      }
      localObject2 = mGroupKey;
      if (localObject2 != null)
      {
        mExtras.putString("android.support.groupKey", (String)localObject2);
        if (mGroupSummary) {
          mExtras.putBoolean("android.support.isGroupSummary", true);
        } else {
          mExtras.putBoolean("android.support.useSideChannel", true);
        }
      }
      localObject2 = mSortKey;
      if (localObject2 != null) {
        mExtras.putString("android.support.sortKey", (String)localObject2);
      }
    }
    mContentView = mContentView;
    mBigContentView = mBigContentView;
    i = Build.VERSION.SDK_INT;
    mBuilder.setShowWhen(mShowWhen);
    if (Build.VERSION.SDK_INT < 21)
    {
      localObject2 = mPeople;
      if ((localObject2 != null) && (!((ArrayList)localObject2).isEmpty()))
      {
        localObject2 = mExtras;
        localObject3 = mPeople;
        ((Bundle)localObject2).putStringArray("android.people", (String[])((ArrayList)localObject3).toArray(new String[((ArrayList)localObject3).size()]));
      }
    }
    if (Build.VERSION.SDK_INT >= 20)
    {
      mBuilder.setLocalOnly(mLocalOnly).setGroup(mGroupKey).setGroupSummary(mGroupSummary).setSortKey(mSortKey);
      mGroupAlertBehavior = mGroupAlertBehavior;
    }
    if (Build.VERSION.SDK_INT >= 21)
    {
      mBuilder.setCategory(mCategory).setColor(mColor).setVisibility(mVisibility).setPublicVersion(mPublicVersion).setSound(sound, audioAttributes);
      localObject1 = mPeople.iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (String)((Iterator)localObject1).next();
        mBuilder.addPerson((String)localObject2);
      }
      mHeadsUpContentView = mHeadsUpContentView;
      if (mInvisibleActions.size() > 0)
      {
        localObject2 = paramBuilder.getExtras().getBundle("android.car.EXTENSIONS");
        localObject1 = localObject2;
        if (localObject2 == null) {
          localObject1 = new Bundle();
        }
        localObject2 = new Bundle();
        i = 0;
        while (i < mInvisibleActions.size())
        {
          ((Bundle)localObject2).putBundle(Integer.toString(i), NotificationCompatJellybean.getBundleForAction((NotificationCompat.Action)mInvisibleActions.get(i)));
          i += 1;
        }
        ((Bundle)localObject1).putBundle("invisible_actions", (Bundle)localObject2);
        paramBuilder.getExtras().putBundle("android.car.EXTENSIONS", (Bundle)localObject1);
        mExtras.putBundle("android.car.EXTENSIONS", (Bundle)localObject1);
      }
    }
    if (Build.VERSION.SDK_INT >= 24)
    {
      mBuilder.setExtras(mExtras).setRemoteInputHistory(mRemoteInputHistory);
      localObject1 = mContentView;
      if (localObject1 != null) {
        mBuilder.setCustomContentView((RemoteViews)localObject1);
      }
      localObject1 = mBigContentView;
      if (localObject1 != null) {
        mBuilder.setCustomBigContentView((RemoteViews)localObject1);
      }
      localObject1 = mHeadsUpContentView;
      if (localObject1 != null) {
        mBuilder.setCustomHeadsUpContentView((RemoteViews)localObject1);
      }
    }
    if (Build.VERSION.SDK_INT >= 26)
    {
      mBuilder.setBadgeIconType(mBadgeIcon).setShortcutId(mShortcutId).setTimeoutAfter(mTimeout).setGroupAlertBehavior(mGroupAlertBehavior);
      if (mColorizedSet) {
        mBuilder.setColorized(mColorized);
      }
      if (!TextUtils.isEmpty(mChannelId)) {
        mBuilder.setSound(null).setDefaults(0).setLights(0, 0, 0).setVibrate(null);
      }
    }
  }
  
  private void addAction(NotificationCompat.Action paramAction)
  {
    if (Build.VERSION.SDK_INT >= 20)
    {
      Notification.Action.Builder localBuilder = new Notification.Action.Builder(paramAction.getIcon(), paramAction.getTitle(), paramAction.getActionIntent());
      Object localObject;
      if (paramAction.getRemoteInputs() != null)
      {
        localObject = RemoteInput.fromCompat(paramAction.getRemoteInputs());
        int j = localObject.length;
        int i = 0;
        while (i < j)
        {
          localBuilder.addRemoteInput(localObject[i]);
          i += 1;
        }
      }
      if (paramAction.getExtras() != null) {
        localObject = new Bundle(paramAction.getExtras());
      } else {
        localObject = new Bundle();
      }
      ((Bundle)localObject).putBoolean("android.support.allowGeneratedReplies", paramAction.getAllowGeneratedReplies());
      if (Build.VERSION.SDK_INT >= 24) {
        localBuilder.setAllowGeneratedReplies(paramAction.getAllowGeneratedReplies());
      }
      ((Bundle)localObject).putInt("android.support.action.semanticAction", paramAction.getSemanticAction());
      if (Build.VERSION.SDK_INT >= 28) {
        localBuilder.setSemanticAction(paramAction.getSemanticAction());
      }
      ((Bundle)localObject).putBoolean("android.support.action.showsUserInterface", paramAction.getShowsUserInterface());
      localBuilder.addExtras((Bundle)localObject);
      mBuilder.addAction(localBuilder.build());
      return;
    }
    mActionExtrasList.add(NotificationCompatJellybean.writeActionAndGetExtras(mBuilder, paramAction));
  }
  
  private void removeSoundAndVibration(Notification paramNotification)
  {
    sound = null;
    vibrate = null;
    defaults &= 0xFFFFFFFE;
    defaults &= 0xFFFFFFFD;
  }
  
  public Notification build()
  {
    NotificationCompat.Style localStyle = mBuilderCompat.mStyle;
    if (localStyle != null) {
      localStyle.apply(this);
    }
    Object localObject;
    if (localStyle != null) {
      localObject = localStyle.makeContentView(this);
    } else {
      localObject = null;
    }
    Notification localNotification = buildInternal();
    if (localObject != null)
    {
      contentView = ((RemoteViews)localObject);
    }
    else
    {
      localObject = mBuilderCompat.mContentView;
      if (localObject != null) {
        contentView = ((RemoteViews)localObject);
      }
    }
    int i = Build.VERSION.SDK_INT;
    if (localStyle != null)
    {
      localObject = localStyle.makeBigContentView(this);
      if (localObject != null) {
        bigContentView = ((RemoteViews)localObject);
      }
    }
    if ((Build.VERSION.SDK_INT >= 21) && (localStyle != null))
    {
      localObject = mBuilderCompat.mStyle.makeHeadsUpContentView(this);
      if (localObject != null) {
        headsUpContentView = ((RemoteViews)localObject);
      }
    }
    i = Build.VERSION.SDK_INT;
    if (localStyle != null)
    {
      localObject = NotificationCompat.getExtras(localNotification);
      if (localObject != null) {
        localStyle.addCompatExtras((Bundle)localObject);
      }
    }
    return localNotification;
  }
  
  public Notification buildInternal()
  {
    int i = Build.VERSION.SDK_INT;
    if (i >= 26) {
      return mBuilder.build();
    }
    Notification localNotification;
    Object localObject;
    if (i >= 24)
    {
      localNotification = mBuilder.build();
      localObject = localNotification;
      if (mGroupAlertBehavior != 0)
      {
        if ((localNotification.getGroup() != null) && ((flags & 0x200) != 0) && (mGroupAlertBehavior == 2)) {
          removeSoundAndVibration(localNotification);
        }
        localObject = localNotification;
        if (localNotification.getGroup() != null)
        {
          localObject = localNotification;
          if ((flags & 0x200) == 0)
          {
            localObject = localNotification;
            if (mGroupAlertBehavior == 1)
            {
              removeSoundAndVibration(localNotification);
              return localNotification;
            }
          }
        }
      }
    }
    else if (i >= 21)
    {
      mBuilder.setExtras(mExtras);
      localNotification = mBuilder.build();
      localObject = mContentView;
      if (localObject != null) {
        contentView = ((RemoteViews)localObject);
      }
      localObject = mBigContentView;
      if (localObject != null) {
        bigContentView = ((RemoteViews)localObject);
      }
      localObject = mHeadsUpContentView;
      if (localObject != null) {
        headsUpContentView = ((RemoteViews)localObject);
      }
      localObject = localNotification;
      if (mGroupAlertBehavior != 0)
      {
        if ((localNotification.getGroup() != null) && ((flags & 0x200) != 0) && (mGroupAlertBehavior == 2)) {
          removeSoundAndVibration(localNotification);
        }
        localObject = localNotification;
        if (localNotification.getGroup() != null)
        {
          localObject = localNotification;
          if ((flags & 0x200) == 0)
          {
            localObject = localNotification;
            if (mGroupAlertBehavior == 1)
            {
              removeSoundAndVibration(localNotification);
              return localNotification;
            }
          }
        }
      }
    }
    else if (i >= 20)
    {
      mBuilder.setExtras(mExtras);
      localNotification = mBuilder.build();
      localObject = mContentView;
      if (localObject != null) {
        contentView = ((RemoteViews)localObject);
      }
      localObject = mBigContentView;
      if (localObject != null) {
        bigContentView = ((RemoteViews)localObject);
      }
      localObject = localNotification;
      if (mGroupAlertBehavior != 0)
      {
        if ((localNotification.getGroup() != null) && ((flags & 0x200) != 0) && (mGroupAlertBehavior == 2)) {
          removeSoundAndVibration(localNotification);
        }
        localObject = localNotification;
        if (localNotification.getGroup() != null)
        {
          localObject = localNotification;
          if ((flags & 0x200) == 0)
          {
            localObject = localNotification;
            if (mGroupAlertBehavior == 1)
            {
              removeSoundAndVibration(localNotification);
              return localNotification;
            }
          }
        }
      }
    }
    else
    {
      localObject = NotificationCompatJellybean.buildActionExtrasMap(mActionExtrasList);
      if (localObject != null) {
        mExtras.putSparseParcelableArray("android.support.actionExtras", (SparseArray)localObject);
      }
      mBuilder.setExtras(mExtras);
      localNotification = mBuilder.build();
      localObject = mContentView;
      if (localObject != null) {
        contentView = ((RemoteViews)localObject);
      }
      RemoteViews localRemoteViews = mBigContentView;
      localObject = localNotification;
      if (localRemoteViews != null)
      {
        bigContentView = localRemoteViews;
        localObject = localNotification;
      }
    }
    return localObject;
  }
  
  public Notification.Builder getBuilder()
  {
    return mBuilder;
  }
}
