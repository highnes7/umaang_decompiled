package android.support.v4.package_7;

import android.app.Notification;
import android.app.Notification.Action;
import android.app.Notification.Action.Builder;
import android.app.Notification.BigPictureStyle;
import android.app.Notification.BigTextStyle;
import android.app.Notification.Builder;
import android.app.Notification.DecoratedCustomViewStyle;
import android.app.Notification.InboxStyle;
import android.app.Notification.MessagingStyle;
import android.app.Notification.MessagingStyle.Message;
import android.app.Notification.Style;
import android.app.PendingIntent;
import android.app.RemoteInput.Builder;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.res.ColorStateList;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffColorFilter;
import android.graphics.drawable.Drawable;
import android.media.AudioAttributes.Builder;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Parcelable;
import android.os.SystemClock;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.style.TextAppearanceSpan;
import android.util.SparseArray;
import android.widget.RemoteViews;
import b.b.a.G;
import b.b.a.N;
import b.b.a.k;
import f.sufficientlysecure.rootcommands.util.StringBuilder;
import java.lang.annotation.Annotation;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import support.android.internal.Delta;
import support.android.internal.Endpoint;
import support.android.internal.Orientation.1;
import support.android.internal.R.color;
import support.android.internal.R.id;
import support.android.internal.R.integer;
import support.android.internal.R.string;
import support.android.v4.text.BidiFormatter;

public class NotificationCompat
{
  public static final int BADGE_ICON_LARGE = 2;
  public static final int BADGE_ICON_NONE = 0;
  public static final int BADGE_ICON_SMALL = 1;
  public static final String CATEGORY_ALARM = "alarm";
  public static final String CATEGORY_CALL = "call";
  public static final String CATEGORY_EMAIL = "email";
  public static final String CATEGORY_ERROR = "err";
  public static final String CATEGORY_EVENT = "event";
  public static final String CATEGORY_MESSAGE = "msg";
  public static final String CATEGORY_PROGRESS = "progress";
  public static final String CATEGORY_PROMO = "promo";
  public static final String CATEGORY_RECOMMENDATION = "recommendation";
  public static final String CATEGORY_REMINDER = "reminder";
  public static final String CATEGORY_SERVICE = "service";
  public static final String CATEGORY_SOCIAL = "social";
  public static final String CATEGORY_STATUS = "status";
  public static final String CATEGORY_SYSTEM = "sys";
  public static final String CATEGORY_TRANSPORT = "transport";
  @k
  public static final int COLOR_DEFAULT = 0;
  public static final int DEFAULT_ALL = -1;
  public static final int DEFAULT_LIGHTS = 4;
  public static final int DEFAULT_SOUND = 1;
  public static final int DEFAULT_VIBRATE = 2;
  public static final String EXTRA_AUDIO_CONTENTS_URI = "android.audioContents";
  public static final String EXTRA_BACKGROUND_IMAGE_URI = "android.backgroundImageUri";
  public static final String EXTRA_BIG_TEXT = "android.bigText";
  public static final String EXTRA_COMPACT_ACTIONS = "android.compactActions";
  public static final String EXTRA_CONVERSATION_TITLE = "android.conversationTitle";
  public static final String EXTRA_HIDDEN_CONVERSATION_TITLE = "android.hiddenConversationTitle";
  public static final String EXTRA_INFO_TEXT = "android.infoText";
  public static final String EXTRA_IS_GROUP_CONVERSATION = "android.isGroupConversation";
  public static final String EXTRA_LARGE_ICON = "android.largeIcon";
  public static final String EXTRA_LARGE_ICON_BIG = "android.largeIcon.big";
  public static final String EXTRA_MEDIA_SESSION = "android.mediaSession";
  public static final String EXTRA_MESSAGES = "android.messages";
  public static final String EXTRA_MESSAGING_STYLE_USER = "android.messagingStyleUser";
  public static final String EXTRA_PEOPLE = "android.people";
  public static final String EXTRA_PICTURE = "android.picture";
  public static final String EXTRA_PROGRESS = "android.progress";
  public static final String EXTRA_PROGRESS_INDETERMINATE = "android.progressIndeterminate";
  public static final String EXTRA_PROGRESS_MAX = "android.progressMax";
  public static final String EXTRA_REMOTE_INPUT_HISTORY = "android.remoteInputHistory";
  public static final String EXTRA_SELF_DISPLAY_NAME = "android.selfDisplayName";
  public static final String EXTRA_SHOW_CHRONOMETER = "android.showChronometer";
  public static final String EXTRA_SHOW_WHEN = "android.showWhen";
  public static final String EXTRA_SMALL_ICON = "android.icon";
  public static final String EXTRA_SUB_TEXT = "android.subText";
  public static final String EXTRA_SUMMARY_TEXT = "android.summaryText";
  public static final String EXTRA_TEMPLATE = "android.template";
  public static final String EXTRA_TEXT = "android.text";
  public static final String EXTRA_TEXT_LINES = "android.textLines";
  public static final String EXTRA_TITLE = "android.title";
  public static final String EXTRA_TITLE_BIG = "android.title.big";
  public static final int FLAG_AUTO_CANCEL = 16;
  public static final int FLAG_FOREGROUND_SERVICE = 64;
  public static final int FLAG_GROUP_SUMMARY = 512;
  @Deprecated
  public static final int FLAG_HIGH_PRIORITY = 128;
  public static final int FLAG_INSISTENT = 4;
  public static final int FLAG_LOCAL_ONLY = 256;
  public static final int FLAG_NO_CLEAR = 32;
  public static final int FLAG_ONGOING_EVENT = 2;
  public static final int FLAG_ONLY_ALERT_ONCE = 8;
  public static final int FLAG_SHOW_LIGHTS = 1;
  public static final int GROUP_ALERT_ALL = 0;
  public static final int GROUP_ALERT_CHILDREN = 2;
  public static final int GROUP_ALERT_SUMMARY = 1;
  public static final int PRIORITY_DEFAULT = 0;
  public static final int PRIORITY_HIGH = 1;
  public static final int PRIORITY_LOW = -1;
  public static final int PRIORITY_MAX = 2;
  public static final int PRIORITY_MIN = -2;
  public static final int STREAM_DEFAULT = -1;
  public static final int VISIBILITY_PRIVATE = 0;
  public static final int VISIBILITY_PUBLIC = 1;
  public static final int VISIBILITY_SECRET = -1;
  
  public NotificationCompat() {}
  
  public static Action getAction(Notification paramNotification, int paramInt)
  {
    if (Build.VERSION.SDK_INT >= 20) {
      return getActionCompatFromAction(actions[paramInt]);
    }
    Notification.Action localAction = actions[paramInt];
    Object localObject = null;
    SparseArray localSparseArray = extras.getSparseParcelableArray("android.support.actionExtras");
    paramNotification = localObject;
    if (localSparseArray != null) {
      paramNotification = (Bundle)localSparseArray.get(paramInt);
    }
    return NotificationCompatJellybean.readAction(icon, title, actionIntent, paramNotification);
  }
  
  public static Action getActionCompatFromAction(Notification.Action paramAction)
  {
    android.app.RemoteInput[] arrayOfRemoteInput1 = paramAction.getRemoteInputs();
    Object localObject;
    int i;
    if (arrayOfRemoteInput1 == null)
    {
      localObject = null;
    }
    else
    {
      RemoteInput[] arrayOfRemoteInput = new RemoteInput[arrayOfRemoteInput1.length];
      i = 0;
      for (;;)
      {
        localObject = arrayOfRemoteInput;
        if (i >= arrayOfRemoteInput1.length) {
          break;
        }
        localObject = arrayOfRemoteInput1[i];
        arrayOfRemoteInput[i] = new RemoteInput(((android.app.RemoteInput)localObject).getResultKey(), ((android.app.RemoteInput)localObject).getLabel(), ((android.app.RemoteInput)localObject).getChoices(), ((android.app.RemoteInput)localObject).getAllowFreeFormInput(), ((android.app.RemoteInput)localObject).getExtras(), null);
        i += 1;
      }
    }
    boolean bool1;
    if (Build.VERSION.SDK_INT >= 24)
    {
      if ((!paramAction.getExtras().getBoolean("android.support.allowGeneratedReplies")) && (!paramAction.getAllowGeneratedReplies())) {
        bool1 = false;
      } else {
        bool1 = true;
      }
    }
    else {
      bool1 = paramAction.getExtras().getBoolean("android.support.allowGeneratedReplies");
    }
    boolean bool2 = paramAction.getExtras().getBoolean("android.support.action.showsUserInterface", true);
    if (Build.VERSION.SDK_INT >= 28) {
      i = paramAction.getSemanticAction();
    } else {
      i = paramAction.getExtras().getInt("android.support.action.semanticAction", 0);
    }
    return new Action(icon, title, actionIntent, paramAction.getExtras(), (RemoteInput[])localObject, null, bool1, i, bool2);
  }
  
  public static int getActionCount(Notification paramNotification)
  {
    int i = Build.VERSION.SDK_INT;
    paramNotification = actions;
    if (paramNotification != null) {
      return paramNotification.length;
    }
    return 0;
  }
  
  public static int getBadgeIconType(Notification paramNotification)
  {
    if (Build.VERSION.SDK_INT >= 26) {
      return paramNotification.getBadgeIconType();
    }
    return 0;
  }
  
  public static String getCategory(Notification paramNotification)
  {
    if (Build.VERSION.SDK_INT >= 21) {
      return category;
    }
    return null;
  }
  
  public static String getChannelId(Notification paramNotification)
  {
    if (Build.VERSION.SDK_INT >= 26) {
      return paramNotification.getChannelId();
    }
    return null;
  }
  
  public static CharSequence getContentTitle(Notification paramNotification)
  {
    return extras.getCharSequence("android.title");
  }
  
  public static Bundle getExtras(Notification paramNotification)
  {
    int i = Build.VERSION.SDK_INT;
    return extras;
  }
  
  public static String getGroup(Notification paramNotification)
  {
    if (Build.VERSION.SDK_INT >= 20) {
      return paramNotification.getGroup();
    }
    return extras.getString("android.support.groupKey");
  }
  
  public static int getGroupAlertBehavior(Notification paramNotification)
  {
    if (Build.VERSION.SDK_INT >= 26) {
      return paramNotification.getGroupAlertBehavior();
    }
    return 0;
  }
  
  public static List getInvisibleActions(Notification paramNotification)
  {
    ArrayList localArrayList = new ArrayList();
    paramNotification = extras.getBundle("android.car.EXTENSIONS");
    if (paramNotification == null) {
      return localArrayList;
    }
    paramNotification = paramNotification.getBundle("invisible_actions");
    if (paramNotification != null)
    {
      int i = 0;
      while (i < paramNotification.size())
      {
        localArrayList.add(NotificationCompatJellybean.getActionFromBundle(paramNotification.getBundle(Integer.toString(i))));
        i += 1;
      }
    }
    return localArrayList;
  }
  
  public static boolean getLocalOnly(Notification paramNotification)
  {
    if (Build.VERSION.SDK_INT >= 20) {
      return (flags & 0x100) != 0;
    }
    return extras.getBoolean("android.support.localOnly");
  }
  
  public static Notification[] getNotificationArrayFromBundle(Bundle paramBundle, String paramString)
  {
    Parcelable[] arrayOfParcelable = paramBundle.getParcelableArray(paramString);
    if ((!(arrayOfParcelable instanceof Notification[])) && (arrayOfParcelable != null))
    {
      Notification[] arrayOfNotification = new Notification[arrayOfParcelable.length];
      int i = 0;
      while (i < arrayOfParcelable.length)
      {
        arrayOfNotification[i] = ((Notification)arrayOfParcelable[i]);
        i += 1;
      }
      paramBundle.putParcelableArray(paramString, arrayOfNotification);
      return arrayOfNotification;
    }
    return (Notification[])arrayOfParcelable;
  }
  
  public static String getShortcutId(Notification paramNotification)
  {
    if (Build.VERSION.SDK_INT >= 26) {
      return paramNotification.getShortcutId();
    }
    return null;
  }
  
  public static String getSortKey(Notification paramNotification)
  {
    if (Build.VERSION.SDK_INT >= 20) {
      return paramNotification.getSortKey();
    }
    return extras.getString("android.support.sortKey");
  }
  
  public static long getTimeoutAfter(Notification paramNotification)
  {
    if (Build.VERSION.SDK_INT >= 26) {
      return paramNotification.getTimeoutAfter();
    }
    return 0L;
  }
  
  public static boolean isGroupSummary(Notification paramNotification)
  {
    if (Build.VERSION.SDK_INT >= 20) {
      return (flags & 0x200) != 0;
    }
    return extras.getBoolean("android.support.isGroupSummary");
  }
  
  public class Action
  {
    public static final String EXTRA_SEMANTIC_ACTION = "android.support.action.semanticAction";
    public static final String EXTRA_SHOWS_USER_INTERFACE = "android.support.action.showsUserInterface";
    public static final int SEMANTIC_ACTION_ARCHIVE = 5;
    public static final int SEMANTIC_ACTION_CALL = 10;
    public static final int SEMANTIC_ACTION_DELETE = 4;
    public static final int SEMANTIC_ACTION_MARK_AS_READ = 2;
    public static final int SEMANTIC_ACTION_MARK_AS_UNREAD = 3;
    public static final int SEMANTIC_ACTION_MUTE = 6;
    public static final int SEMANTIC_ACTION_NONE = 0;
    public static final int SEMANTIC_ACTION_REPLY = 1;
    public static final int SEMANTIC_ACTION_THUMBS_DOWN = 9;
    public static final int SEMANTIC_ACTION_THUMBS_UP = 8;
    public static final int SEMANTIC_ACTION_UNMUTE = 7;
    public PendingIntent actionIntent;
    public int icon;
    public boolean mAllowGeneratedReplies;
    public final RemoteInput[] mDataOnlyRemoteInputs;
    public final Bundle mExtras;
    public final RemoteInput[] mRemoteInputs;
    public final int mSemanticAction;
    public boolean mShowsUserInterface = true;
    public CharSequence title;
    
    public Action(CharSequence paramCharSequence, PendingIntent paramPendingIntent)
    {
      this(paramCharSequence, paramPendingIntent, new Bundle(), null, null, true, 0, true);
    }
    
    public Action(CharSequence paramCharSequence, PendingIntent paramPendingIntent, Bundle paramBundle, RemoteInput[] paramArrayOfRemoteInput1, RemoteInput[] paramArrayOfRemoteInput2, boolean paramBoolean1, int paramInt, boolean paramBoolean2)
    {
      icon = this$1;
      title = NotificationCompat.Builder.limitCharSequenceLength(paramCharSequence);
      actionIntent = paramPendingIntent;
      if (paramBundle == null) {
        paramBundle = new Bundle();
      }
      mExtras = paramBundle;
      mRemoteInputs = paramArrayOfRemoteInput1;
      mDataOnlyRemoteInputs = paramArrayOfRemoteInput2;
      mAllowGeneratedReplies = paramBoolean1;
      mSemanticAction = paramInt;
      mShowsUserInterface = paramBoolean2;
    }
    
    public PendingIntent getActionIntent()
    {
      return actionIntent;
    }
    
    public boolean getAllowGeneratedReplies()
    {
      return mAllowGeneratedReplies;
    }
    
    public RemoteInput[] getDataOnlyRemoteInputs()
    {
      return mDataOnlyRemoteInputs;
    }
    
    public Bundle getExtras()
    {
      return mExtras;
    }
    
    public int getIcon()
    {
      return icon;
    }
    
    public RemoteInput[] getRemoteInputs()
    {
      return mRemoteInputs;
    }
    
    public int getSemanticAction()
    {
      return mSemanticAction;
    }
    
    public boolean getShowsUserInterface()
    {
      return mShowsUserInterface;
    }
    
    public CharSequence getTitle()
    {
      return title;
    }
    
    public final class Builder
    {
      public boolean mAllowGeneratedReplies = true;
      public final Bundle mExtras;
      public final int mIcon;
      public final PendingIntent mIntent;
      public ArrayList<android.support.v4.app.RemoteInput> mRemoteInputs;
      public int mSemanticAction;
      public boolean mShowsUserInterface = true;
      public final CharSequence mTitle;
      
      public Builder(CharSequence paramCharSequence, PendingIntent paramPendingIntent)
      {
        this(paramCharSequence, paramPendingIntent, new Bundle(), null, true, 0, true);
      }
      
      public Builder(CharSequence paramCharSequence, PendingIntent paramPendingIntent, Bundle paramBundle, RemoteInput[] paramArrayOfRemoteInput, boolean paramBoolean1, int paramInt, boolean paramBoolean2)
      {
        mIcon = this$1;
        mTitle = NotificationCompat.Builder.limitCharSequenceLength(paramCharSequence);
        mIntent = paramPendingIntent;
        mExtras = paramBundle;
        if (paramArrayOfRemoteInput == null) {
          paramCharSequence = null;
        } else {
          paramCharSequence = new ArrayList(Arrays.asList(paramArrayOfRemoteInput));
        }
        mRemoteInputs = paramCharSequence;
        mAllowGeneratedReplies = paramBoolean1;
        mSemanticAction = paramInt;
        mShowsUserInterface = paramBoolean2;
      }
      
      public Builder()
      {
        this(title, actionIntent, new Bundle(mExtras), this$1.getRemoteInputs(), this$1.getAllowGeneratedReplies(), this$1.getSemanticAction(), mShowsUserInterface);
      }
      
      public Builder addExtras(Bundle paramBundle)
      {
        if (paramBundle != null) {
          mExtras.putAll(paramBundle);
        }
        return this;
      }
      
      public Builder addRemoteInput(RemoteInput paramRemoteInput)
      {
        if (mRemoteInputs == null) {
          mRemoteInputs = new ArrayList();
        }
        mRemoteInputs.add(paramRemoteInput);
        return this;
      }
      
      public NotificationCompat.Action build()
      {
        Object localObject1 = new ArrayList();
        ArrayList localArrayList = new ArrayList();
        Object localObject2 = mRemoteInputs;
        if (localObject2 != null)
        {
          localObject2 = ((ArrayList)localObject2).iterator();
          while (((Iterator)localObject2).hasNext())
          {
            RemoteInput localRemoteInput = (RemoteInput)((Iterator)localObject2).next();
            if (localRemoteInput.isDataOnly()) {
              ((List)localObject1).add(localRemoteInput);
            } else {
              localArrayList.add(localRemoteInput);
            }
          }
        }
        boolean bool = ((List)localObject1).isEmpty();
        localObject2 = null;
        if (bool) {
          localObject1 = null;
        } else {
          localObject1 = (RemoteInput[])((List)localObject1).toArray(new RemoteInput[((List)localObject1).size()]);
        }
        if (!localArrayList.isEmpty()) {
          localObject2 = (RemoteInput[])localArrayList.toArray(new RemoteInput[localArrayList.size()]);
        }
        return new NotificationCompat.Action(mIcon, mTitle, mIntent, mExtras, (RemoteInput[])localObject2, (RemoteInput[])localObject1, mAllowGeneratedReplies, mSemanticAction, mShowsUserInterface);
      }
      
      public Builder extend(NotificationCompat.Action.Extender paramExtender)
      {
        paramExtender.extend(this);
        return this;
      }
      
      public Bundle getExtras()
      {
        return mExtras;
      }
      
      public Builder setAllowGeneratedReplies(boolean paramBoolean)
      {
        mAllowGeneratedReplies = paramBoolean;
        return this;
      }
      
      public Builder setSemanticAction(int paramInt)
      {
        mSemanticAction = paramInt;
        return this;
      }
      
      public Builder setShowsUserInterface(boolean paramBoolean)
      {
        mShowsUserInterface = paramBoolean;
        return this;
      }
    }
    
    public abstract interface Extender
    {
      public abstract NotificationCompat.Action.Builder extend(NotificationCompat.Action.Builder paramBuilder);
    }
    
    @Retention(RetentionPolicy.SOURCE)
    public @interface SemanticAction {}
    
    public final class WearableExtender
      implements NotificationCompat.Action.Extender
    {
      public static final int DEFAULT_FLAGS = 1;
      public static final String EXTRA_WEARABLE_EXTENSIONS = "android.wearable.EXTENSIONS";
      public static final int FLAG_AVAILABLE_OFFLINE = 1;
      public static final int FLAG_HINT_DISPLAY_INLINE = 4;
      public static final int FLAG_HINT_LAUNCHES_ACTIVITY = 2;
      public static final String KEY_CANCEL_LABEL = "cancelLabel";
      public static final String KEY_CONFIRM_LABEL = "confirmLabel";
      public static final String KEY_FLAGS = "flags";
      public static final String KEY_IN_PROGRESS_LABEL = "inProgressLabel";
      public CharSequence mCancelLabel;
      public CharSequence mConfirmLabel;
      public int mFlags = 1;
      public CharSequence mInProgressLabel;
      
      public WearableExtender() {}
      
      public WearableExtender()
      {
        this$1 = this$1.getExtras().getBundle("android.wearable.EXTENSIONS");
        if (this$1 != null)
        {
          mFlags = this$1.getInt("flags", 1);
          mInProgressLabel = this$1.getCharSequence("inProgressLabel");
          mConfirmLabel = this$1.getCharSequence("confirmLabel");
          mCancelLabel = this$1.getCharSequence("cancelLabel");
        }
      }
      
      private void setFlag(int paramInt, boolean paramBoolean)
      {
        if (paramBoolean)
        {
          mFlags = (paramInt | mFlags);
          return;
        }
        mFlags = (paramInt & mFlags);
      }
      
      public WearableExtender clone()
      {
        WearableExtender localWearableExtender = new WearableExtender();
        mFlags = mFlags;
        mInProgressLabel = mInProgressLabel;
        mConfirmLabel = mConfirmLabel;
        mCancelLabel = mCancelLabel;
        return localWearableExtender;
      }
      
      public NotificationCompat.Action.Builder extend(NotificationCompat.Action.Builder paramBuilder)
      {
        Bundle localBundle = new Bundle();
        int i = mFlags;
        if (i != 1) {
          localBundle.putInt("flags", i);
        }
        CharSequence localCharSequence = mInProgressLabel;
        if (localCharSequence != null) {
          localBundle.putCharSequence("inProgressLabel", localCharSequence);
        }
        localCharSequence = mConfirmLabel;
        if (localCharSequence != null) {
          localBundle.putCharSequence("confirmLabel", localCharSequence);
        }
        localCharSequence = mCancelLabel;
        if (localCharSequence != null) {
          localBundle.putCharSequence("cancelLabel", localCharSequence);
        }
        paramBuilder.getExtras().putBundle("android.wearable.EXTENSIONS", localBundle);
        return paramBuilder;
      }
      
      public CharSequence getCancelLabel()
      {
        return mCancelLabel;
      }
      
      public CharSequence getConfirmLabel()
      {
        return mConfirmLabel;
      }
      
      public boolean getHintDisplayActionInline()
      {
        return (mFlags & 0x4) != 0;
      }
      
      public boolean getHintLaunchesActivity()
      {
        return (mFlags & 0x2) != 0;
      }
      
      public CharSequence getInProgressLabel()
      {
        return mInProgressLabel;
      }
      
      public boolean isAvailableOffline()
      {
        return (mFlags & 0x1) != 0;
      }
      
      public WearableExtender setAvailableOffline(boolean paramBoolean)
      {
        setFlag(1, paramBoolean);
        return this;
      }
      
      public WearableExtender setCancelLabel(CharSequence paramCharSequence)
      {
        mCancelLabel = paramCharSequence;
        return this;
      }
      
      public WearableExtender setConfirmLabel(CharSequence paramCharSequence)
      {
        mConfirmLabel = paramCharSequence;
        return this;
      }
      
      public WearableExtender setHintDisplayActionInline(boolean paramBoolean)
      {
        setFlag(4, paramBoolean);
        return this;
      }
      
      public WearableExtender setHintLaunchesActivity(boolean paramBoolean)
      {
        setFlag(2, paramBoolean);
        return this;
      }
      
      public WearableExtender setInProgressLabel(CharSequence paramCharSequence)
      {
        mInProgressLabel = paramCharSequence;
        return this;
      }
    }
  }
  
  @Retention(RetentionPolicy.SOURCE)
  @N({b.b.a.N.a.b})
  public @interface BadgeIconType {}
  
  public class BigPictureStyle
    extends NotificationCompat.Style
  {
    public Bitmap mBigLargeIcon;
    public boolean mBigLargeIconSet;
    public Bitmap mPicture;
    
    public BigPictureStyle() {}
    
    public BigPictureStyle()
    {
      setBuilder(this$1);
    }
    
    public void apply(NotificationBuilderWithBuilderAccessor paramNotificationBuilderWithBuilderAccessor)
    {
      int i = Build.VERSION.SDK_INT;
      paramNotificationBuilderWithBuilderAccessor = new Notification.BigPictureStyle(paramNotificationBuilderWithBuilderAccessor.getBuilder()).setBigContentTitle(mBigContentTitle).bigPicture(mPicture);
      if (mBigLargeIconSet) {
        paramNotificationBuilderWithBuilderAccessor.bigLargeIcon(mBigLargeIcon);
      }
      if (mSummaryTextSet) {
        paramNotificationBuilderWithBuilderAccessor.setSummaryText(mSummaryText);
      }
    }
    
    public BigPictureStyle bigLargeIcon(Bitmap paramBitmap)
    {
      mBigLargeIcon = paramBitmap;
      mBigLargeIconSet = true;
      return this;
    }
    
    public BigPictureStyle bigPicture(Bitmap paramBitmap)
    {
      mPicture = paramBitmap;
      return this;
    }
    
    public BigPictureStyle setBigContentTitle(CharSequence paramCharSequence)
    {
      mBigContentTitle = NotificationCompat.Builder.limitCharSequenceLength(paramCharSequence);
      return this;
    }
    
    public BigPictureStyle setSummaryText(CharSequence paramCharSequence)
    {
      mSummaryText = NotificationCompat.Builder.limitCharSequenceLength(paramCharSequence);
      mSummaryTextSet = true;
      return this;
    }
  }
  
  public class BigTextStyle
    extends NotificationCompat.Style
  {
    public CharSequence mBigText;
    
    public BigTextStyle() {}
    
    public BigTextStyle()
    {
      setBuilder(this$1);
    }
    
    public void apply(NotificationBuilderWithBuilderAccessor paramNotificationBuilderWithBuilderAccessor)
    {
      int i = Build.VERSION.SDK_INT;
      paramNotificationBuilderWithBuilderAccessor = new Notification.BigTextStyle(paramNotificationBuilderWithBuilderAccessor.getBuilder()).setBigContentTitle(mBigContentTitle).bigText(mBigText);
      if (mSummaryTextSet) {
        paramNotificationBuilderWithBuilderAccessor.setSummaryText(mSummaryText);
      }
    }
    
    public BigTextStyle bigText(CharSequence paramCharSequence)
    {
      mBigText = NotificationCompat.Builder.limitCharSequenceLength(paramCharSequence);
      return this;
    }
    
    public BigTextStyle setBigContentTitle(CharSequence paramCharSequence)
    {
      mBigContentTitle = NotificationCompat.Builder.limitCharSequenceLength(paramCharSequence);
      return this;
    }
    
    public BigTextStyle setSummaryText(CharSequence paramCharSequence)
    {
      mSummaryText = NotificationCompat.Builder.limitCharSequenceLength(paramCharSequence);
      mSummaryTextSet = true;
      return this;
    }
  }
  
  public class Builder
  {
    public static final int MAX_CHARSEQUENCE_LENGTH = 5120;
    @N({b.b.a.N.a.b})
    public ArrayList<android.support.v4.app.NotificationCompat.Action> mActions = new ArrayList();
    public int mBadgeIcon = 0;
    public RemoteViews mBigContentView;
    public String mCategory;
    public String mChannelId;
    public int mColor = 0;
    public boolean mColorized;
    public boolean mColorizedSet;
    public CharSequence mContentInfo;
    public PendingIntent mContentIntent;
    public CharSequence mContentText;
    public CharSequence mContentTitle;
    public RemoteViews mContentView;
    public Bundle mExtras;
    public PendingIntent mFullScreenIntent;
    public int mGroupAlertBehavior = 0;
    public String mGroupKey;
    public boolean mGroupSummary;
    public RemoteViews mHeadsUpContentView;
    public ArrayList<android.support.v4.app.NotificationCompat.Action> mInvisibleActions = new ArrayList();
    public Bitmap mLargeIcon;
    public boolean mLocalOnly = false;
    public Notification mNotification = new Notification();
    public int mNumber;
    @Deprecated
    public ArrayList<String> mPeople;
    public int mPriority;
    public int mProgress;
    public boolean mProgressIndeterminate;
    public int mProgressMax;
    public Notification mPublicVersion;
    public CharSequence[] mRemoteInputHistory;
    public String mShortcutId;
    public boolean mShowWhen = true;
    public String mSortKey;
    public NotificationCompat.Style mStyle;
    public CharSequence mSubText;
    public RemoteViews mTickerView;
    public long mTimeout;
    public boolean mUseChronometer;
    public int mVisibility = 0;
    
    public Builder()
    {
      this(null);
    }
    
    public Builder(String paramString)
    {
      mChannelId = paramString;
      mNotification.when = System.currentTimeMillis();
      mNotification.audioStreamType = -1;
      mPriority = 0;
      mPeople = new ArrayList();
    }
    
    public static CharSequence limitCharSequenceLength(CharSequence paramCharSequence)
    {
      if (paramCharSequence == null) {
        return paramCharSequence;
      }
      CharSequence localCharSequence = paramCharSequence;
      if (paramCharSequence.length() > 5120) {
        localCharSequence = paramCharSequence.subSequence(0, 5120);
      }
      return localCharSequence;
    }
    
    private Bitmap reduceLargeIconSize(Bitmap paramBitmap)
    {
      Object localObject = paramBitmap;
      if (paramBitmap != null)
      {
        if (Build.VERSION.SDK_INT >= 27) {
          return paramBitmap;
        }
        localObject = getResources();
        int i = ((Resources)localObject).getDimensionPixelSize(Delta.compat_notification_large_icon_max_width);
        int j = ((Resources)localObject).getDimensionPixelSize(Delta.compat_notification_large_icon_max_height);
        if ((paramBitmap.getWidth() <= i) && (paramBitmap.getHeight() <= j)) {
          return paramBitmap;
        }
        double d1 = i;
        double d2 = Math.max(1, paramBitmap.getWidth());
        Double.isNaN(d1);
        Double.isNaN(d2);
        d1 /= d2;
        d2 = j;
        double d3 = Math.max(1, paramBitmap.getHeight());
        Double.isNaN(d2);
        Double.isNaN(d3);
        d1 = Math.min(d1, d2 / d3);
        d2 = paramBitmap.getWidth();
        Double.isNaN(d2);
        i = (int)Math.ceil(d2 * d1);
        d2 = paramBitmap.getHeight();
        Double.isNaN(d2);
        localObject = Bitmap.createScaledBitmap(paramBitmap, i, (int)Math.ceil(d2 * d1), true);
      }
      return localObject;
    }
    
    private void setFlag(int paramInt, boolean paramBoolean)
    {
      if (paramBoolean)
      {
        localNotification = mNotification;
        flags = (paramInt | flags);
        return;
      }
      Notification localNotification = mNotification;
      flags = (paramInt & flags);
    }
    
    public Builder addAction(int paramInt, CharSequence paramCharSequence, PendingIntent paramPendingIntent)
    {
      mActions.add(new NotificationCompat.Action(paramInt, paramCharSequence, paramPendingIntent));
      return this;
    }
    
    public Builder addAction(NotificationCompat.Action paramAction)
    {
      mActions.add(paramAction);
      return this;
    }
    
    public Builder addExtras(Bundle paramBundle)
    {
      if (paramBundle != null)
      {
        Bundle localBundle = mExtras;
        if (localBundle == null)
        {
          mExtras = new Bundle(paramBundle);
          return this;
        }
        localBundle.putAll(paramBundle);
      }
      return this;
    }
    
    public Builder addInvisibleAction(int paramInt, CharSequence paramCharSequence, PendingIntent paramPendingIntent)
    {
      return addInvisibleAction(new NotificationCompat.Action(paramInt, paramCharSequence, paramPendingIntent));
    }
    
    public Builder addInvisibleAction(NotificationCompat.Action paramAction)
    {
      mInvisibleActions.add(paramAction);
      return this;
    }
    
    public Builder addPerson(String paramString)
    {
      mPeople.add(paramString);
      return this;
    }
    
    public Notification build()
    {
      return new NotificationCompatBuilder(this).build();
    }
    
    public Builder extend(NotificationCompat.Extender paramExtender)
    {
      paramExtender.extend(this);
      return this;
    }
    
    public RemoteViews getBigContentView()
    {
      return mBigContentView;
    }
    
    public int getColor()
    {
      return mColor;
    }
    
    public RemoteViews getContentView()
    {
      return mContentView;
    }
    
    public Bundle getExtras()
    {
      if (mExtras == null) {
        mExtras = new Bundle();
      }
      return mExtras;
    }
    
    public RemoteViews getHeadsUpContentView()
    {
      return mHeadsUpContentView;
    }
    
    public Notification getNotification()
    {
      return build();
    }
    
    public int getPriority()
    {
      return mPriority;
    }
    
    public long getWhenIfShowing()
    {
      if (mShowWhen) {
        return mNotification.when;
      }
      return 0L;
    }
    
    public Builder setAutoCancel(boolean paramBoolean)
    {
      setFlag(16, paramBoolean);
      return this;
    }
    
    public Builder setBadgeIconType(int paramInt)
    {
      mBadgeIcon = paramInt;
      return this;
    }
    
    public Builder setCategory(String paramString)
    {
      mCategory = paramString;
      return this;
    }
    
    public Builder setChannelId(String paramString)
    {
      mChannelId = paramString;
      return this;
    }
    
    public Builder setColor(int paramInt)
    {
      mColor = paramInt;
      return this;
    }
    
    public Builder setColorized(boolean paramBoolean)
    {
      mColorized = paramBoolean;
      mColorizedSet = true;
      return this;
    }
    
    public Builder setContent(RemoteViews paramRemoteViews)
    {
      mNotification.contentView = paramRemoteViews;
      return this;
    }
    
    public Builder setContentInfo(CharSequence paramCharSequence)
    {
      mContentInfo = limitCharSequenceLength(paramCharSequence);
      return this;
    }
    
    public Builder setContentIntent(PendingIntent paramPendingIntent)
    {
      mContentIntent = paramPendingIntent;
      return this;
    }
    
    public Builder setContentText(CharSequence paramCharSequence)
    {
      mContentText = limitCharSequenceLength(paramCharSequence);
      return this;
    }
    
    public Builder setContentTitle(CharSequence paramCharSequence)
    {
      mContentTitle = limitCharSequenceLength(paramCharSequence);
      return this;
    }
    
    public Builder setCustomBigContentView(RemoteViews paramRemoteViews)
    {
      mBigContentView = paramRemoteViews;
      return this;
    }
    
    public Builder setCustomContentView(RemoteViews paramRemoteViews)
    {
      mContentView = paramRemoteViews;
      return this;
    }
    
    public Builder setCustomHeadsUpContentView(RemoteViews paramRemoteViews)
    {
      mHeadsUpContentView = paramRemoteViews;
      return this;
    }
    
    public Builder setDefaults(int paramInt)
    {
      Notification localNotification = mNotification;
      defaults = paramInt;
      if ((paramInt & 0x4) != 0) {
        flags |= 0x1;
      }
      return this;
    }
    
    public Builder setDeleteIntent(PendingIntent paramPendingIntent)
    {
      mNotification.deleteIntent = paramPendingIntent;
      return this;
    }
    
    public Builder setExtras(Bundle paramBundle)
    {
      mExtras = paramBundle;
      return this;
    }
    
    public Builder setFullScreenIntent(PendingIntent paramPendingIntent, boolean paramBoolean)
    {
      mFullScreenIntent = paramPendingIntent;
      setFlag(128, paramBoolean);
      return this;
    }
    
    public Builder setGroup(String paramString)
    {
      mGroupKey = paramString;
      return this;
    }
    
    public Builder setGroupAlertBehavior(int paramInt)
    {
      mGroupAlertBehavior = paramInt;
      return this;
    }
    
    public Builder setGroupSummary(boolean paramBoolean)
    {
      mGroupSummary = paramBoolean;
      return this;
    }
    
    public Builder setLargeIcon(Bitmap paramBitmap)
    {
      mLargeIcon = reduceLargeIconSize(paramBitmap);
      return this;
    }
    
    public Builder setLights(int paramInt1, int paramInt2, int paramInt3)
    {
      Notification localNotification = mNotification;
      ledARGB = paramInt1;
      ledOnMS = paramInt2;
      ledOffMS = paramInt3;
      if ((ledOnMS != 0) && (ledOffMS != 0)) {
        paramInt1 = 1;
      } else {
        paramInt1 = 0;
      }
      localNotification = mNotification;
      flags = (paramInt1 | flags & 0xFFFFFFFE);
      return this;
    }
    
    public Builder setLocalOnly(boolean paramBoolean)
    {
      mLocalOnly = paramBoolean;
      return this;
    }
    
    public Builder setNumber(int paramInt)
    {
      mNumber = paramInt;
      return this;
    }
    
    public Builder setOngoing(boolean paramBoolean)
    {
      setFlag(2, paramBoolean);
      return this;
    }
    
    public Builder setOnlyAlertOnce(boolean paramBoolean)
    {
      setFlag(8, paramBoolean);
      return this;
    }
    
    public Builder setPriority(int paramInt)
    {
      mPriority = paramInt;
      return this;
    }
    
    public Builder setProgress(int paramInt1, int paramInt2, boolean paramBoolean)
    {
      mProgressMax = paramInt1;
      mProgress = paramInt2;
      mProgressIndeterminate = paramBoolean;
      return this;
    }
    
    public Builder setPublicVersion(Notification paramNotification)
    {
      mPublicVersion = paramNotification;
      return this;
    }
    
    public Builder setRemoteInputHistory(CharSequence[] paramArrayOfCharSequence)
    {
      mRemoteInputHistory = paramArrayOfCharSequence;
      return this;
    }
    
    public Builder setShortcutId(String paramString)
    {
      mShortcutId = paramString;
      return this;
    }
    
    public Builder setShowWhen(boolean paramBoolean)
    {
      mShowWhen = paramBoolean;
      return this;
    }
    
    public Builder setSmallIcon(int paramInt)
    {
      mNotification.icon = paramInt;
      return this;
    }
    
    public Builder setSmallIcon(int paramInt1, int paramInt2)
    {
      Notification localNotification = mNotification;
      icon = paramInt1;
      iconLevel = paramInt2;
      return this;
    }
    
    public Builder setSortKey(String paramString)
    {
      mSortKey = paramString;
      return this;
    }
    
    public Builder setSound(Uri paramUri)
    {
      Notification localNotification = mNotification;
      sound = paramUri;
      audioStreamType = -1;
      if (Build.VERSION.SDK_INT >= 21) {
        audioAttributes = new AudioAttributes.Builder().setContentType(4).setUsage(5).build();
      }
      return this;
    }
    
    public Builder setSound(Uri paramUri, int paramInt)
    {
      Notification localNotification = mNotification;
      sound = paramUri;
      audioStreamType = paramInt;
      if (Build.VERSION.SDK_INT >= 21) {
        audioAttributes = new AudioAttributes.Builder().setContentType(4).setLegacyStreamType(paramInt).build();
      }
      return this;
    }
    
    public Builder setStyle(NotificationCompat.Style paramStyle)
    {
      if (mStyle != paramStyle)
      {
        mStyle = paramStyle;
        paramStyle = mStyle;
        if (paramStyle != null) {
          paramStyle.setBuilder(this);
        }
      }
      return this;
    }
    
    public Builder setSubText(CharSequence paramCharSequence)
    {
      mSubText = limitCharSequenceLength(paramCharSequence);
      return this;
    }
    
    public Builder setTicker(CharSequence paramCharSequence)
    {
      mNotification.tickerText = limitCharSequenceLength(paramCharSequence);
      return this;
    }
    
    public Builder setTicker(CharSequence paramCharSequence, RemoteViews paramRemoteViews)
    {
      mNotification.tickerText = limitCharSequenceLength(paramCharSequence);
      mTickerView = paramRemoteViews;
      return this;
    }
    
    public Builder setTimeoutAfter(long paramLong)
    {
      mTimeout = paramLong;
      return this;
    }
    
    public Builder setUsesChronometer(boolean paramBoolean)
    {
      mUseChronometer = paramBoolean;
      return this;
    }
    
    public Builder setVibrate(long[] paramArrayOfLong)
    {
      mNotification.vibrate = paramArrayOfLong;
      return this;
    }
    
    public Builder setVisibility(int paramInt)
    {
      mVisibility = paramInt;
      return this;
    }
    
    public Builder setWhen(long paramLong)
    {
      mNotification.when = paramLong;
      return this;
    }
  }
  
  public final class CarExtender
    implements NotificationCompat.Extender
  {
    @N({b.b.a.N.a.b})
    public static final String EXTRA_CAR_EXTENDER = "android.car.EXTENSIONS";
    public static final String EXTRA_COLOR = "app_color";
    public static final String EXTRA_CONVERSATION = "car_conversation";
    @N({b.b.a.N.a.b})
    public static final String EXTRA_INVISIBLE_ACTIONS = "invisible_actions";
    public static final String EXTRA_LARGE_ICON = "large_icon";
    public static final String KEY_AUTHOR = "author";
    public static final String KEY_MESSAGES = "messages";
    public static final String KEY_ON_READ = "on_read";
    public static final String KEY_ON_REPLY = "on_reply";
    public static final String KEY_PARTICIPANTS = "participants";
    public static final String KEY_REMOTE_INPUT = "remote_input";
    public static final String KEY_TEXT = "text";
    public static final String KEY_TIMESTAMP = "timestamp";
    public int mColor = 0;
    public Bitmap mLargeIcon;
    public UnreadConversation mUnreadConversation;
    
    public CarExtender() {}
    
    public CarExtender()
    {
      if (Build.VERSION.SDK_INT < 21) {
        return;
      }
      if (NotificationCompat.getExtras(this$1) == null) {
        this$1 = null;
      } else {
        this$1 = NotificationCompat.getExtras(this$1).getBundle("android.car.EXTENSIONS");
      }
      if (this$1 != null)
      {
        mLargeIcon = ((Bitmap)this$1.getParcelable("large_icon"));
        mColor = this$1.getInt("app_color", 0);
        mUnreadConversation = getUnreadConversationFromBundle(this$1.getBundle("car_conversation"));
      }
    }
    
    public static Bundle getBundleForUnreadConversation(UnreadConversation paramUnreadConversation)
    {
      Bundle localBundle1 = new Bundle();
      Object localObject = paramUnreadConversation.getParticipants();
      int i = 0;
      if ((localObject != null) && (paramUnreadConversation.getParticipants().length > 1)) {
        localObject = paramUnreadConversation.getParticipants()[0];
      } else {
        localObject = null;
      }
      Parcelable[] arrayOfParcelable = new Parcelable[paramUnreadConversation.getMessages().length];
      while (i < arrayOfParcelable.length)
      {
        Bundle localBundle2 = new Bundle();
        localBundle2.putString("text", paramUnreadConversation.getMessages()[i]);
        localBundle2.putString("author", (String)localObject);
        arrayOfParcelable[i] = localBundle2;
        i += 1;
      }
      localBundle1.putParcelableArray("messages", arrayOfParcelable);
      localObject = paramUnreadConversation.getRemoteInput();
      if (localObject != null) {
        localBundle1.putParcelable("remote_input", (Parcelable)new RemoteInput.Builder(((RemoteInput)localObject).getResultKey()).setLabel(((RemoteInput)localObject).getLabel()).setChoices(((RemoteInput)localObject).getChoices()).setAllowFreeFormInput(((RemoteInput)localObject).getAllowFreeFormInput()).addExtras(((RemoteInput)localObject).getExtras()).build());
      }
      localBundle1.putParcelable("on_reply", paramUnreadConversation.getReplyPendingIntent());
      localBundle1.putParcelable("on_read", paramUnreadConversation.getReadPendingIntent());
      localBundle1.putStringArray("participants", paramUnreadConversation.getParticipants());
      localBundle1.putLong("timestamp", paramUnreadConversation.getLatestTimestamp());
      return localBundle1;
    }
    
    public static UnreadConversation getUnreadConversationFromBundle(Bundle paramBundle)
    {
      RemoteInput localRemoteInput = null;
      if (paramBundle == null) {
        return null;
      }
      Object localObject = paramBundle.getParcelableArray("messages");
      String[] arrayOfString1;
      if (localObject != null)
      {
        arrayOfString1 = new String[localObject.length];
        int j = 0;
        int i = 0;
        while (i < arrayOfString1.length)
        {
          if (!(localObject[i] instanceof Bundle))
          {
            i = j;
            break label89;
          }
          arrayOfString1[i] = ((Bundle)localObject[i]).getString("text");
          if (arrayOfString1[i] == null)
          {
            i = j;
            break label89;
          }
          i += 1;
        }
        i = 1;
        label89:
        if (i == 0) {
          return null;
        }
      }
      else
      {
        arrayOfString1 = null;
      }
      localObject = (PendingIntent)paramBundle.getParcelable("on_read");
      PendingIntent localPendingIntent = (PendingIntent)paramBundle.getParcelable("on_reply");
      android.app.RemoteInput localRemoteInput1 = (android.app.RemoteInput)paramBundle.getParcelable("remote_input");
      String[] arrayOfString2 = paramBundle.getStringArray("participants");
      if (arrayOfString2 != null)
      {
        if (arrayOfString2.length != 1) {
          return null;
        }
        if (localRemoteInput1 != null) {
          localRemoteInput = new RemoteInput(localRemoteInput1.getResultKey(), localRemoteInput1.getLabel(), localRemoteInput1.getChoices(), localRemoteInput1.getAllowFreeFormInput(), localRemoteInput1.getExtras(), null);
        }
        return new UnreadConversation(arrayOfString1, localRemoteInput, localPendingIntent, (PendingIntent)localObject, arrayOfString2, paramBundle.getLong("timestamp"));
      }
      return null;
    }
    
    public NotificationCompat.Builder extend(NotificationCompat.Builder paramBuilder)
    {
      if (Build.VERSION.SDK_INT < 21) {
        return paramBuilder;
      }
      Bundle localBundle = new Bundle();
      Object localObject = mLargeIcon;
      if (localObject != null) {
        localBundle.putParcelable("large_icon", (Parcelable)localObject);
      }
      int i = mColor;
      if (i != 0) {
        localBundle.putInt("app_color", i);
      }
      localObject = mUnreadConversation;
      if (localObject != null) {
        localBundle.putBundle("car_conversation", getBundleForUnreadConversation((UnreadConversation)localObject));
      }
      paramBuilder.getExtras().putBundle("android.car.EXTENSIONS", localBundle);
      return paramBuilder;
    }
    
    public int getColor()
    {
      return mColor;
    }
    
    public Bitmap getLargeIcon()
    {
      return mLargeIcon;
    }
    
    public UnreadConversation getUnreadConversation()
    {
      return mUnreadConversation;
    }
    
    public CarExtender setColor(int paramInt)
    {
      mColor = paramInt;
      return this;
    }
    
    public CarExtender setLargeIcon(Bitmap paramBitmap)
    {
      mLargeIcon = paramBitmap;
      return this;
    }
    
    public CarExtender setUnreadConversation(UnreadConversation paramUnreadConversation)
    {
      mUnreadConversation = paramUnreadConversation;
      return this;
    }
    
    public class UnreadConversation
    {
      public final long mLatestTimestamp;
      public final String[] mParticipants;
      public final PendingIntent mReadPendingIntent;
      public final RemoteInput mRemoteInput;
      public final PendingIntent mReplyPendingIntent;
      
      public UnreadConversation(RemoteInput paramRemoteInput, PendingIntent paramPendingIntent1, PendingIntent paramPendingIntent2, String[] paramArrayOfString, long paramLong)
      {
        mRemoteInput = paramRemoteInput;
        mReadPendingIntent = paramPendingIntent2;
        mReplyPendingIntent = paramPendingIntent1;
        mParticipants = paramArrayOfString;
        mLatestTimestamp = paramLong;
      }
      
      public long getLatestTimestamp()
      {
        return mLatestTimestamp;
      }
      
      public String[] getMessages()
      {
        return NotificationCompat.CarExtender.this;
      }
      
      public String getParticipant()
      {
        String[] arrayOfString = mParticipants;
        if (arrayOfString.length > 0) {
          return arrayOfString[0];
        }
        return null;
      }
      
      public String[] getParticipants()
      {
        return mParticipants;
      }
      
      public PendingIntent getReadPendingIntent()
      {
        return mReadPendingIntent;
      }
      
      public RemoteInput getRemoteInput()
      {
        return mRemoteInput;
      }
      
      public PendingIntent getReplyPendingIntent()
      {
        return mReplyPendingIntent;
      }
      
      public class Builder
      {
        public long mLatestTimestamp;
        public final List<String> mMessages = new ArrayList();
        public PendingIntent mReadPendingIntent;
        public RemoteInput mRemoteInput;
        public PendingIntent mReplyPendingIntent;
        
        public Builder() {}
        
        public Builder addMessage(String paramString)
        {
          mMessages.add(paramString);
          return this;
        }
        
        public NotificationCompat.CarExtender.UnreadConversation build()
        {
          Object localObject = mMessages;
          localObject = (String[])((List)localObject).toArray(new String[((List)localObject).size()]);
          String str = NotificationCompat.CarExtender.UnreadConversation.this;
          RemoteInput localRemoteInput = mRemoteInput;
          PendingIntent localPendingIntent1 = mReplyPendingIntent;
          PendingIntent localPendingIntent2 = mReadPendingIntent;
          long l = mLatestTimestamp;
          return new NotificationCompat.CarExtender.UnreadConversation((String[])localObject, localRemoteInput, localPendingIntent1, localPendingIntent2, new String[] { str }, l);
        }
        
        public Builder setLatestTimestamp(long paramLong)
        {
          mLatestTimestamp = paramLong;
          return this;
        }
        
        public Builder setReadPendingIntent(PendingIntent paramPendingIntent)
        {
          mReadPendingIntent = paramPendingIntent;
          return this;
        }
        
        public Builder setReplyAction(PendingIntent paramPendingIntent, RemoteInput paramRemoteInput)
        {
          mRemoteInput = paramRemoteInput;
          mReplyPendingIntent = paramPendingIntent;
          return this;
        }
      }
    }
  }
  
  public class DecoratedCustomViewStyle
    extends NotificationCompat.Style
  {
    public static final int MAX_ACTION_BUTTONS = 3;
    
    public DecoratedCustomViewStyle() {}
    
    private RemoteViews createRemoteViews(RemoteViews paramRemoteViews, boolean paramBoolean)
    {
      int i = Orientation.1.notification_template_custom_big;
      int m = 1;
      int k = 0;
      RemoteViews localRemoteViews = applyStandardTemplate(true, i, false);
      localRemoteViews.removeAllViews(R.id.actions);
      if (paramBoolean)
      {
        Object localObject = mBuilder.mActions;
        if (localObject != null)
        {
          int n = Math.min(((ArrayList)localObject).size(), 3);
          if (n > 0)
          {
            i = 0;
            for (;;)
            {
              j = m;
              if (i >= n) {
                break;
              }
              localObject = generateActionButton((NotificationCompat.Action)mBuilder.mActions.get(i));
              localRemoteViews.addView(R.id.actions, (RemoteViews)localObject);
              i += 1;
            }
          }
        }
      }
      int j = 0;
      if (j != 0) {
        i = k;
      } else {
        i = 8;
      }
      localRemoteViews.setViewVisibility(R.id.actions, i);
      localRemoteViews.setViewVisibility(R.id.action_divider, i);
      buildIntoRemoteViews(localRemoteViews, paramRemoteViews);
      return localRemoteViews;
    }
    
    private RemoteViews generateActionButton(NotificationCompat.Action paramAction)
    {
      if (actionIntent == null) {
        i = 1;
      } else {
        i = 0;
      }
      Object localObject = mBuilder.mContext.getPackageName();
      int j;
      if (i != 0) {
        j = Orientation.1.notification_action_tombstone;
      } else {
        j = Orientation.1.notification_action;
      }
      localObject = new RemoteViews((String)localObject, j);
      ((RemoteViews)localObject).setImageViewBitmap(R.id.action_image, createColoredBitmap(paramAction.getIcon(), mBuilder.mContext.getResources().getColor(R.color.notification_action_color_filter)));
      ((RemoteViews)localObject).setTextViewText(R.id.action_text, title);
      if (i == 0) {
        ((RemoteViews)localObject).setOnClickPendingIntent(R.id.action_container, actionIntent);
      }
      int i = Build.VERSION.SDK_INT;
      ((RemoteViews)localObject).setContentDescription(R.id.action_container, title);
      return localObject;
    }
    
    public void apply(NotificationBuilderWithBuilderAccessor paramNotificationBuilderWithBuilderAccessor)
    {
      if (Build.VERSION.SDK_INT >= 24) {
        paramNotificationBuilderWithBuilderAccessor.getBuilder().setStyle((Notification.Style)new Notification.DecoratedCustomViewStyle());
      }
    }
    
    public RemoteViews makeBigContentView(NotificationBuilderWithBuilderAccessor paramNotificationBuilderWithBuilderAccessor)
    {
      if (Build.VERSION.SDK_INT >= 24) {
        return null;
      }
      RemoteViews localRemoteViews = mBuilder.getBigContentView();
      paramNotificationBuilderWithBuilderAccessor = localRemoteViews;
      if (localRemoteViews == null) {
        paramNotificationBuilderWithBuilderAccessor = mBuilder.getContentView();
      }
      if (paramNotificationBuilderWithBuilderAccessor == null) {
        return null;
      }
      return createRemoteViews(paramNotificationBuilderWithBuilderAccessor, true);
    }
    
    public RemoteViews makeContentView(NotificationBuilderWithBuilderAccessor paramNotificationBuilderWithBuilderAccessor)
    {
      if (Build.VERSION.SDK_INT >= 24) {
        return null;
      }
      if (mBuilder.getContentView() == null) {
        return null;
      }
      return createRemoteViews(mBuilder.getContentView(), false);
    }
    
    public RemoteViews makeHeadsUpContentView(NotificationBuilderWithBuilderAccessor paramNotificationBuilderWithBuilderAccessor)
    {
      if (Build.VERSION.SDK_INT >= 24) {
        return null;
      }
      RemoteViews localRemoteViews = mBuilder.getHeadsUpContentView();
      if (localRemoteViews != null) {
        paramNotificationBuilderWithBuilderAccessor = localRemoteViews;
      } else {
        paramNotificationBuilderWithBuilderAccessor = mBuilder.getContentView();
      }
      if (localRemoteViews == null) {
        return null;
      }
      return createRemoteViews(paramNotificationBuilderWithBuilderAccessor, true);
    }
  }
  
  public abstract interface Extender
  {
    public abstract NotificationCompat.Builder extend(NotificationCompat.Builder paramBuilder);
  }
  
  @Retention(RetentionPolicy.SOURCE)
  @N({b.b.a.N.a.b})
  public @interface GroupAlertBehavior {}
  
  public class InboxStyle
    extends NotificationCompat.Style
  {
    public ArrayList<CharSequence> mTexts = new ArrayList();
    
    public InboxStyle() {}
    
    public InboxStyle()
    {
      setBuilder(this$1);
    }
    
    public InboxStyle addLine(CharSequence paramCharSequence)
    {
      mTexts.add(NotificationCompat.Builder.limitCharSequenceLength(paramCharSequence));
      return this;
    }
    
    public void apply(NotificationBuilderWithBuilderAccessor paramNotificationBuilderWithBuilderAccessor)
    {
      int i = Build.VERSION.SDK_INT;
      paramNotificationBuilderWithBuilderAccessor = new Notification.InboxStyle(paramNotificationBuilderWithBuilderAccessor.getBuilder()).setBigContentTitle(mBigContentTitle);
      if (mSummaryTextSet) {
        paramNotificationBuilderWithBuilderAccessor.setSummaryText(mSummaryText);
      }
      Iterator localIterator = mTexts.iterator();
      while (localIterator.hasNext()) {
        paramNotificationBuilderWithBuilderAccessor.addLine((CharSequence)localIterator.next());
      }
    }
    
    public InboxStyle setBigContentTitle(CharSequence paramCharSequence)
    {
      mBigContentTitle = NotificationCompat.Builder.limitCharSequenceLength(paramCharSequence);
      return this;
    }
    
    public InboxStyle setSummaryText(CharSequence paramCharSequence)
    {
      mSummaryText = NotificationCompat.Builder.limitCharSequenceLength(paramCharSequence);
      mSummaryTextSet = true;
      return this;
    }
  }
  
  public class MessagingStyle
    extends NotificationCompat.Style
  {
    public static final int MAXIMUM_RETAINED_MESSAGES = 25;
    @G
    public CharSequence mConversationTitle;
    @G
    public Boolean mIsGroupConversation;
    public final List<android.support.v4.app.NotificationCompat.MessagingStyle.Message> mMessages = new ArrayList();
    public Person mUser;
    
    public MessagingStyle() {}
    
    public MessagingStyle()
    {
      if (!TextUtils.isEmpty(this$1.getName()))
      {
        mUser = this$1;
        return;
      }
      throw new IllegalArgumentException("User's name must not be empty.");
    }
    
    public MessagingStyle()
    {
      mUser = new Person.Builder().setName(this$1).build();
    }
    
    public static MessagingStyle extractMessagingStyleFromNotification(Notification paramNotification)
    {
      paramNotification = NotificationCompat.getExtras(paramNotification);
      if ((paramNotification != null) && (!paramNotification.containsKey("android.selfDisplayName")) && (!paramNotification.containsKey("android.messagingStyleUser"))) {
        return null;
      }
      try
      {
        MessagingStyle localMessagingStyle = new MessagingStyle();
        localMessagingStyle.restoreFromCompatExtras(paramNotification);
        return localMessagingStyle;
      }
      catch (ClassCastException paramNotification) {}
      return null;
    }
    
    private Message findLatestIncomingMessage()
    {
      int i = mMessages.size();
      Message localMessage;
      do
      {
        int j;
        do
        {
          j = i - 1;
          if (j < 0) {
            break;
          }
          localMessage = (Message)mMessages.get(j);
          i = j;
        } while (localMessage.getPerson() == null);
        i = j;
      } while (TextUtils.isEmpty(localMessage.getPerson().getName()));
      return localMessage;
      if (!mMessages.isEmpty()) {
        return (Message)StringBuilder.get(mMessages, -1);
      }
      return null;
    }
    
    private boolean hasMessagesWithoutSender()
    {
      int i = mMessages.size() - 1;
      while (i >= 0)
      {
        Message localMessage = (Message)mMessages.get(i);
        if ((localMessage.getPerson() != null) && (localMessage.getPerson().getName() == null)) {
          return true;
        }
        i -= 1;
      }
      return false;
    }
    
    private TextAppearanceSpan makeFontColorSpan(int paramInt)
    {
      return new TextAppearanceSpan(null, 0, 0, ColorStateList.valueOf(paramInt), null);
    }
    
    private CharSequence makeMessageLine(Message paramMessage)
    {
      BidiFormatter localBidiFormatter = BidiFormatter.getInstance();
      SpannableStringBuilder localSpannableStringBuilder = new SpannableStringBuilder();
      int j;
      if (Build.VERSION.SDK_INT >= 21) {
        j = 1;
      } else {
        j = 0;
      }
      int i;
      if (j != 0) {
        i = -16777216;
      } else {
        i = -1;
      }
      Object localObject1 = paramMessage.getPerson();
      String str = "";
      if (localObject1 == null) {
        localObject1 = "";
      } else {
        localObject1 = paramMessage.getPerson().getName();
      }
      int k = i;
      Object localObject2 = localObject1;
      if (TextUtils.isEmpty((CharSequence)localObject1))
      {
        localObject1 = mUser.getName();
        k = i;
        localObject2 = localObject1;
        if (j != 0)
        {
          k = i;
          localObject2 = localObject1;
          if (mBuilder.getColor() != 0)
          {
            k = mBuilder.getColor();
            localObject2 = localObject1;
          }
        }
      }
      localObject1 = localBidiFormatter.getPackageName((CharSequence)localObject2);
      localSpannableStringBuilder.append((CharSequence)localObject1);
      localSpannableStringBuilder.setSpan(makeFontColorSpan(k), localSpannableStringBuilder.length() - ((CharSequence)localObject1).length(), localSpannableStringBuilder.length(), 33);
      if (paramMessage.getText() == null) {
        paramMessage = str;
      } else {
        paramMessage = paramMessage.getText();
      }
      localSpannableStringBuilder.append("  ").append(localBidiFormatter.getPackageName((CharSequence)paramMessage));
      return localSpannableStringBuilder;
    }
    
    public void addCompatExtras(Bundle paramBundle)
    {
      paramBundle.putCharSequence("android.selfDisplayName", mUser.getName());
      paramBundle.putBundle("android.messagingStyleUser", mUser.toBundle());
      paramBundle.putCharSequence("android.hiddenConversationTitle", mConversationTitle);
      if ((mConversationTitle != null) && (mIsGroupConversation.booleanValue())) {
        paramBundle.putCharSequence("android.conversationTitle", mConversationTitle);
      }
      if (!mMessages.isEmpty()) {
        paramBundle.putParcelableArray("android.messages", Message.getBundleArrayForMessages(mMessages));
      }
      Boolean localBoolean = mIsGroupConversation;
      if (localBoolean != null) {
        paramBundle.putBoolean("android.isGroupConversation", localBoolean.booleanValue());
      }
    }
    
    public MessagingStyle addMessage(Message paramMessage)
    {
      mMessages.add(paramMessage);
      if (mMessages.size() > 25) {
        mMessages.remove(0);
      }
      return this;
    }
    
    public MessagingStyle addMessage(CharSequence paramCharSequence, long paramLong, Person paramPerson)
    {
      addMessage(new Message(paramCharSequence, paramLong, paramPerson));
      return this;
    }
    
    public MessagingStyle addMessage(CharSequence paramCharSequence1, long paramLong, CharSequence paramCharSequence2)
    {
      mMessages.add(new Message(paramCharSequence1, paramLong, new Person.Builder().setName(paramCharSequence2).build()));
      if (mMessages.size() > 25) {
        mMessages.remove(0);
      }
      return this;
    }
    
    public void apply(NotificationBuilderWithBuilderAccessor paramNotificationBuilderWithBuilderAccessor)
    {
      setGroupConversation(isGroupConversation());
      int i = Build.VERSION.SDK_INT;
      if (i >= 24)
      {
        if (i >= 28) {
          localObject1 = new Notification.MessagingStyle(mUser.toAndroidPerson());
        } else {
          localObject1 = new Notification.MessagingStyle(mUser.getName());
        }
        if ((mIsGroupConversation.booleanValue()) || (Build.VERSION.SDK_INT >= 28)) {
          ((Notification.MessagingStyle)localObject1).setConversationTitle(mConversationTitle);
        }
        if (Build.VERSION.SDK_INT >= 28) {
          ((Notification.MessagingStyle)localObject1).setGroupConversation(mIsGroupConversation.booleanValue());
        }
        Iterator localIterator = mMessages.iterator();
        while (localIterator.hasNext())
        {
          Message localMessage = (Message)localIterator.next();
          if (Build.VERSION.SDK_INT >= 28)
          {
            localObject2 = localMessage.getPerson();
            CharSequence localCharSequence = localMessage.getText();
            long l = localMessage.getTimestamp();
            if (localObject2 == null) {
              localObject2 = null;
            } else {
              localObject2 = ((Person)localObject2).toAndroidPerson();
            }
            localObject2 = new Notification.MessagingStyle.Message(localCharSequence, l, (android.app.Person)localObject2);
          }
          else
          {
            if (localMessage.getPerson() != null) {
              localObject2 = localMessage.getPerson().getName();
            } else {
              localObject2 = null;
            }
            localObject2 = new Notification.MessagingStyle.Message(localMessage.getText(), localMessage.getTimestamp(), (CharSequence)localObject2);
          }
          if (localMessage.getDataMimeType() != null) {
            ((Notification.MessagingStyle.Message)localObject2).setData(localMessage.getDataMimeType(), localMessage.getDataUri());
          }
          ((Notification.MessagingStyle)localObject1).addMessage((Notification.MessagingStyle.Message)localObject2);
        }
        ((Notification.MessagingStyle)localObject1).setBuilder(paramNotificationBuilderWithBuilderAccessor.getBuilder());
        return;
      }
      Object localObject1 = findLatestIncomingMessage();
      if ((mConversationTitle != null) && (mIsGroupConversation.booleanValue()))
      {
        paramNotificationBuilderWithBuilderAccessor.getBuilder().setContentTitle(mConversationTitle);
      }
      else if (localObject1 != null)
      {
        paramNotificationBuilderWithBuilderAccessor.getBuilder().setContentTitle("");
        if (((Message)localObject1).getPerson() != null) {
          paramNotificationBuilderWithBuilderAccessor.getBuilder().setContentTitle(((Message)localObject1).getPerson().getName());
        }
      }
      if (localObject1 != null)
      {
        localObject2 = paramNotificationBuilderWithBuilderAccessor.getBuilder();
        if (mConversationTitle != null) {
          localObject1 = makeMessageLine((Message)localObject1);
        } else {
          localObject1 = ((Message)localObject1).getText();
        }
        ((Notification.Builder)localObject2).setContentText((CharSequence)localObject1);
      }
      i = Build.VERSION.SDK_INT;
      Object localObject2 = new SpannableStringBuilder();
      if ((mConversationTitle == null) && (!hasMessagesWithoutSender())) {
        i = 0;
      } else {
        i = 1;
      }
      int j = mMessages.size() - 1;
      while (j >= 0)
      {
        localObject1 = (Message)mMessages.get(j);
        if (i != 0) {
          localObject1 = makeMessageLine((Message)localObject1);
        } else {
          localObject1 = ((Message)localObject1).getText();
        }
        if (j != mMessages.size() - 1) {
          ((SpannableStringBuilder)localObject2).insert(0, "\n");
        }
        ((SpannableStringBuilder)localObject2).insert(0, (CharSequence)localObject1);
        j -= 1;
      }
      new Notification.BigTextStyle(paramNotificationBuilderWithBuilderAccessor.getBuilder()).setBigContentTitle(null).bigText((CharSequence)localObject2);
    }
    
    public CharSequence getConversationTitle()
    {
      return mConversationTitle;
    }
    
    public List getMessages()
    {
      return mMessages;
    }
    
    public Person getUser()
    {
      return mUser;
    }
    
    public CharSequence getUserDisplayName()
    {
      return mUser.getName();
    }
    
    public boolean isGroupConversation()
    {
      Object localObject = mBuilder;
      if ((localObject != null) && (mContext.getApplicationInfo().targetSdkVersion < 28) && (mIsGroupConversation == null))
      {
        if (mConversationTitle != null) {
          return true;
        }
      }
      else
      {
        localObject = mIsGroupConversation;
        if (localObject != null) {
          return ((Boolean)localObject).booleanValue();
        }
      }
      return false;
    }
    
    public void restoreFromCompatExtras(Bundle paramBundle)
    {
      mMessages.clear();
      if (paramBundle.containsKey("android.messagingStyleUser")) {
        mUser = Person.fromBundle(paramBundle.getBundle("android.messagingStyleUser"));
      } else {
        mUser = new Person.Builder().setName(paramBundle.getString("android.selfDisplayName")).build();
      }
      mConversationTitle = paramBundle.getCharSequence("android.conversationTitle");
      if (mConversationTitle == null) {
        mConversationTitle = paramBundle.getCharSequence("android.hiddenConversationTitle");
      }
      Parcelable[] arrayOfParcelable = paramBundle.getParcelableArray("android.messages");
      if (arrayOfParcelable != null) {
        mMessages.addAll(Message.getMessagesFromBundleArray(arrayOfParcelable));
      }
      if (paramBundle.containsKey("android.isGroupConversation")) {
        mIsGroupConversation = Boolean.valueOf(paramBundle.getBoolean("android.isGroupConversation"));
      }
    }
    
    public MessagingStyle setConversationTitle(CharSequence paramCharSequence)
    {
      mConversationTitle = paramCharSequence;
      return this;
    }
    
    public MessagingStyle setGroupConversation(boolean paramBoolean)
    {
      mIsGroupConversation = Boolean.valueOf(paramBoolean);
      return this;
    }
    
    public final class Message
    {
      public static final String KEY_DATA_MIME_TYPE = "type";
      public static final String KEY_DATA_URI = "uri";
      public static final String KEY_EXTRAS_BUNDLE = "extras";
      public static final String KEY_NOTIFICATION_PERSON = "sender_person";
      public static final String KEY_PERSON = "person";
      public static final String KEY_SENDER = "sender";
      public static final String KEY_TEXT = "text";
      public static final String KEY_TIMESTAMP = "time";
      @G
      public String mDataMimeType;
      @G
      public Uri mDataUri;
      public Bundle mExtras = new Bundle();
      @G
      public final Person mPerson;
      public final long mTimestamp;
      
      public Message(long paramLong, Person paramPerson)
      {
        mTimestamp = paramLong;
        mPerson = paramPerson;
      }
      
      public Message(long paramLong, CharSequence paramCharSequence)
      {
        this(paramLong, new Person.Builder().setName(paramCharSequence).build());
      }
      
      public static Bundle[] getBundleArrayForMessages(List paramList)
      {
        Bundle[] arrayOfBundle = new Bundle[paramList.size()];
        int j = paramList.size();
        int i = 0;
        while (i < j)
        {
          arrayOfBundle[i] = ((Message)paramList.get(i)).toBundle();
          i += 1;
        }
        return arrayOfBundle;
      }
      
      public static Message getMessageFromBundle(Bundle paramBundle)
      {
        Object localObject;
        try
        {
          boolean bool = paramBundle.containsKey("text");
          if (bool)
          {
            bool = paramBundle.containsKey("time");
            if (!bool) {
              return null;
            }
            bool = paramBundle.containsKey("person");
            if (bool)
            {
              localObject = Person.fromBundle(paramBundle.getBundle("person"));
            }
            else
            {
              bool = paramBundle.containsKey("sender_person");
              if ((bool) && (Build.VERSION.SDK_INT >= 28))
              {
                localObject = Person.fromAndroidPerson((android.app.Person)paramBundle.getParcelable("sender_person"));
              }
              else
              {
                bool = paramBundle.containsKey("sender");
                if (bool) {
                  localObject = new Person.Builder().setName(paramBundle.getCharSequence("sender")).build();
                } else {
                  localObject = null;
                }
              }
            }
            localObject = new Message(paramBundle.getCharSequence("text"), paramBundle.getLong("time"), (Person)localObject);
            bool = paramBundle.containsKey("type");
            if (bool)
            {
              bool = paramBundle.containsKey("uri");
              if (bool) {
                ((Message)localObject).setData(paramBundle.getString("type"), (Uri)paramBundle.getParcelable("uri"));
              }
            }
            bool = paramBundle.containsKey("extras");
            if (bool)
            {
              ((Message)localObject).getExtras().putAll(paramBundle.getBundle("extras"));
              return localObject;
            }
          }
          else
          {
            return null;
          }
        }
        catch (ClassCastException paramBundle)
        {
          return null;
        }
        return localObject;
      }
      
      public static List getMessagesFromBundleArray(Parcelable[] paramArrayOfParcelable)
      {
        ArrayList localArrayList = new ArrayList(paramArrayOfParcelable.length);
        int i = 0;
        while (i < paramArrayOfParcelable.length)
        {
          if ((paramArrayOfParcelable[i] instanceof Bundle))
          {
            Message localMessage = getMessageFromBundle((Bundle)paramArrayOfParcelable[i]);
            if (localMessage != null) {
              localArrayList.add(localMessage);
            }
          }
          i += 1;
        }
        return localArrayList;
      }
      
      private Bundle toBundle()
      {
        Bundle localBundle = new Bundle();
        Object localObject = NotificationCompat.MessagingStyle.this;
        if (localObject != null) {
          localBundle.putCharSequence("text", (CharSequence)localObject);
        }
        localBundle.putLong("time", mTimestamp);
        localObject = mPerson;
        if (localObject != null)
        {
          localBundle.putCharSequence("sender", ((Person)localObject).getName());
          if (Build.VERSION.SDK_INT >= 28) {
            localBundle.putParcelable("sender_person", (Parcelable)mPerson.toAndroidPerson());
          } else {
            localBundle.putBundle("person", mPerson.toBundle());
          }
        }
        localObject = mDataMimeType;
        if (localObject != null) {
          localBundle.putString("type", (String)localObject);
        }
        localObject = mDataUri;
        if (localObject != null) {
          localBundle.putParcelable("uri", (Parcelable)localObject);
        }
        localObject = mExtras;
        if (localObject != null) {
          localBundle.putBundle("extras", (Bundle)localObject);
        }
        return localBundle;
      }
      
      public String getDataMimeType()
      {
        return mDataMimeType;
      }
      
      public Uri getDataUri()
      {
        return mDataUri;
      }
      
      public Bundle getExtras()
      {
        return mExtras;
      }
      
      public Person getPerson()
      {
        return mPerson;
      }
      
      public CharSequence getSender()
      {
        Person localPerson = mPerson;
        if (localPerson == null) {
          return null;
        }
        return localPerson.getName();
      }
      
      public CharSequence getText()
      {
        return NotificationCompat.MessagingStyle.this;
      }
      
      public long getTimestamp()
      {
        return mTimestamp;
      }
      
      public Message setData(String paramString, Uri paramUri)
      {
        mDataMimeType = paramString;
        mDataUri = paramUri;
        return this;
      }
    }
  }
  
  @Retention(RetentionPolicy.SOURCE)
  @N({b.b.a.N.a.b})
  public @interface NotificationVisibility {}
  
  @Retention(RetentionPolicy.SOURCE)
  @N({b.b.a.N.a.b})
  public @interface StreamType {}
  
  public abstract class Style
  {
    public CharSequence mBigContentTitle;
    @N({b.b.a.N.a.b})
    public NotificationCompat.Builder mBuilder;
    public CharSequence mSummaryText;
    public boolean mSummaryTextSet = false;
    
    public Style() {}
    
    private int calculateTopPadding()
    {
      Resources localResources = mBuilder.mContext.getResources();
      int i = localResources.getDimensionPixelSize(Delta.notification_top_pad);
      int j = localResources.getDimensionPixelSize(Delta.notification_top_pad_large_text);
      float f1 = (constrain(getConfigurationfontScale, 1.0F, 1.3F) - 1.0F) / 0.29999995F;
      float f2 = i;
      return Math.round(f1 * j + (1.0F - f1) * f2);
    }
    
    public static float constrain(float paramFloat1, float paramFloat2, float paramFloat3)
    {
      if (paramFloat1 < paramFloat2) {
        return paramFloat2;
      }
      if (paramFloat1 > paramFloat3) {
        return paramFloat3;
      }
      return paramFloat1;
    }
    
    private Bitmap createColoredBitmap(int paramInt1, int paramInt2, int paramInt3)
    {
      Drawable localDrawable = mBuilder.mContext.getResources().getDrawable(paramInt1);
      if (paramInt3 == 0) {
        paramInt1 = localDrawable.getIntrinsicWidth();
      } else {
        paramInt1 = paramInt3;
      }
      int i = paramInt3;
      if (paramInt3 == 0) {
        i = localDrawable.getIntrinsicHeight();
      }
      Bitmap localBitmap = Bitmap.createBitmap(paramInt1, i, Bitmap.Config.ARGB_8888);
      localDrawable.setBounds(0, 0, paramInt1, i);
      if (paramInt2 != 0) {
        localDrawable.mutate().setColorFilter(new PorterDuffColorFilter(paramInt2, PorterDuff.Mode.SRC_IN));
      }
      localDrawable.draw(new Canvas(localBitmap));
      return localBitmap;
    }
    
    private Bitmap createIconWithBackground(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
    {
      int j = Endpoint.notification_icon_background;
      int i = paramInt4;
      if (paramInt4 == 0) {
        i = 0;
      }
      Bitmap localBitmap = createColoredBitmap(j, i, paramInt2);
      Canvas localCanvas = new Canvas(localBitmap);
      Drawable localDrawable = mBuilder.mContext.getResources().getDrawable(paramInt1).mutate();
      localDrawable.setFilterBitmap(true);
      paramInt1 = (paramInt2 - paramInt3) / 2;
      paramInt2 = paramInt3 + paramInt1;
      localDrawable.setBounds(paramInt1, paramInt1, paramInt2, paramInt2);
      localDrawable.setColorFilter(new PorterDuffColorFilter(-1, PorterDuff.Mode.SRC_ATOP));
      localDrawable.draw(localCanvas);
      return localBitmap;
    }
    
    private void hideNormalContent(RemoteViews paramRemoteViews)
    {
      paramRemoteViews.setViewVisibility(R.id.title, 8);
      paramRemoteViews.setViewVisibility(R.id.text2, 8);
      paramRemoteViews.setViewVisibility(R.id.text, 8);
    }
    
    public void addCompatExtras(Bundle paramBundle) {}
    
    public void apply(NotificationBuilderWithBuilderAccessor paramNotificationBuilderWithBuilderAccessor) {}
    
    public RemoteViews applyStandardTemplate(boolean paramBoolean1, int paramInt, boolean paramBoolean2)
    {
      Resources localResources = mBuilder.mContext.getResources();
      RemoteViews localRemoteViews = new RemoteViews(mBuilder.mContext.getPackageName(), paramInt);
      paramInt = mBuilder.getPriority();
      int k = 0;
      if (paramInt < -1) {
        paramInt = 1;
      } else {
        paramInt = 0;
      }
      if (Build.VERSION.SDK_INT < 21) {
        if (paramInt != 0)
        {
          localRemoteViews.setInt(R.id.notification_background, "setBackgroundResource", Endpoint.notification_bg_low);
          localRemoteViews.setInt(R.id.icon, "setBackgroundResource", Endpoint.notification_template_icon_low_bg);
        }
        else
        {
          localRemoteViews.setInt(R.id.notification_background, "setBackgroundResource", Endpoint.notification_bg);
          localRemoteViews.setInt(R.id.icon, "setBackgroundResource", Endpoint.notification_template_icon_bg);
        }
      }
      Object localObject = mBuilder;
      if (mLargeIcon != null)
      {
        paramInt = Build.VERSION.SDK_INT;
        localRemoteViews.setViewVisibility(R.id.icon, 0);
        localRemoteViews.setImageViewBitmap(R.id.icon, mBuilder.mLargeIcon);
        if ((paramBoolean1) && (mBuilder.mNotification.icon != 0))
        {
          paramInt = localResources.getDimensionPixelSize(Delta.notification_right_icon_size);
          i = localResources.getDimensionPixelSize(Delta.notification_small_icon_background_padding);
          if (Build.VERSION.SDK_INT >= 21)
          {
            localObject = mBuilder;
            localObject = createIconWithBackground(mNotification.icon, paramInt, paramInt - i * 2, ((NotificationCompat.Builder)localObject).getColor());
            localRemoteViews.setImageViewBitmap(R.id.right_icon, (Bitmap)localObject);
          }
          else
          {
            localRemoteViews.setImageViewBitmap(R.id.right_icon, createColoredBitmap(mBuilder.mNotification.icon, -1));
          }
          localRemoteViews.setViewVisibility(R.id.right_icon, 0);
        }
      }
      else if ((paramBoolean1) && (mNotification.icon != 0))
      {
        localRemoteViews.setViewVisibility(R.id.icon, 0);
        if (Build.VERSION.SDK_INT >= 21)
        {
          paramInt = localResources.getDimensionPixelSize(Delta.notification_large_icon_width);
          i = localResources.getDimensionPixelSize(Delta.notification_big_circle_margin);
          j = localResources.getDimensionPixelSize(Delta.notification_small_icon_size_as_large);
          localObject = mBuilder;
          localObject = createIconWithBackground(mNotification.icon, paramInt - i, j, ((NotificationCompat.Builder)localObject).getColor());
          localRemoteViews.setImageViewBitmap(R.id.icon, (Bitmap)localObject);
        }
        else
        {
          localRemoteViews.setImageViewBitmap(R.id.icon, createColoredBitmap(mBuilder.mNotification.icon, -1));
        }
      }
      localObject = mBuilder.mContentTitle;
      if (localObject != null) {
        localRemoteViews.setTextViewText(R.id.title, (CharSequence)localObject);
      }
      localObject = mBuilder.mContentText;
      if (localObject != null)
      {
        localRemoteViews.setTextViewText(R.id.text, (CharSequence)localObject);
        paramInt = 1;
      }
      else
      {
        paramInt = 0;
      }
      if ((Build.VERSION.SDK_INT < 21) && (mBuilder.mLargeIcon != null)) {
        i = 1;
      } else {
        i = 0;
      }
      localObject = mBuilder;
      CharSequence localCharSequence = mContentInfo;
      if (localCharSequence != null)
      {
        localRemoteViews.setTextViewText(R.id.info, localCharSequence);
        localRemoteViews.setViewVisibility(R.id.info, 0);
      }
      for (;;)
      {
        j = 1;
        paramInt = 1;
        break label644;
        if (mNumber <= 0) {
          break;
        }
        paramInt = localResources.getInteger(R.integer.status_bar_notification_info_maxnum);
        if (mBuilder.mNumber > paramInt)
        {
          localRemoteViews.setTextViewText(R.id.info, localResources.getString(R.string.status_bar_notification_info_overflow));
        }
        else
        {
          localObject = NumberFormat.getIntegerInstance();
          localRemoteViews.setTextViewText(R.id.info, ((NumberFormat)localObject).format(mBuilder.mNumber));
        }
        localRemoteViews.setViewVisibility(R.id.info, 0);
      }
      localRemoteViews.setViewVisibility(R.id.info, 8);
      int j = paramInt;
      paramInt = i;
      label644:
      localObject = mBuilder.mSubText;
      if (localObject != null)
      {
        i = Build.VERSION.SDK_INT;
        localRemoteViews.setTextViewText(R.id.text, (CharSequence)localObject);
        localObject = mBuilder.mContentText;
        if (localObject != null)
        {
          localRemoteViews.setTextViewText(R.id.text2, (CharSequence)localObject);
          localRemoteViews.setViewVisibility(R.id.text2, 0);
          i = 1;
        }
        else
        {
          localRemoteViews.setViewVisibility(R.id.text2, 8);
        }
      }
      else
      {
        i = 0;
      }
      if (i != 0)
      {
        i = Build.VERSION.SDK_INT;
        if (paramBoolean2)
        {
          float f = localResources.getDimensionPixelSize(Delta.notification_subtext_size);
          localRemoteViews.setTextViewTextSize(R.id.text, 0, f);
        }
        localRemoteViews.setViewPadding(R.id.line1, 0, 0, 0, 0);
      }
      if (mBuilder.getWhenIfShowing() != 0L)
      {
        if (mBuilder.mUseChronometer)
        {
          paramInt = Build.VERSION.SDK_INT;
          localRemoteViews.setViewVisibility(R.id.chronometer, 0);
          paramInt = R.id.chronometer;
          long l = mBuilder.getWhenIfShowing();
          localRemoteViews.setLong(paramInt, "setBase", SystemClock.elapsedRealtime() - System.currentTimeMillis() + l);
          localRemoteViews.setBoolean(R.id.chronometer, "setStarted", true);
        }
        else
        {
          localRemoteViews.setViewVisibility(R.id.time, 0);
          localRemoteViews.setLong(R.id.time, "setTime", mBuilder.getWhenIfShowing());
        }
        paramInt = 1;
      }
      int i = R.id.right_side;
      if (paramInt != 0) {
        paramInt = 0;
      } else {
        paramInt = 8;
      }
      localRemoteViews.setViewVisibility(i, paramInt);
      i = R.id.line3;
      if (j != 0) {
        paramInt = k;
      } else {
        paramInt = 8;
      }
      localRemoteViews.setViewVisibility(i, paramInt);
      return localRemoteViews;
    }
    
    public Notification build()
    {
      NotificationCompat.Builder localBuilder = mBuilder;
      if (localBuilder != null) {
        return localBuilder.build();
      }
      return null;
    }
    
    public void buildIntoRemoteViews(RemoteViews paramRemoteViews1, RemoteViews paramRemoteViews2)
    {
      hideNormalContent(paramRemoteViews1);
      paramRemoteViews1.removeAllViews(R.id.notification_main_column);
      paramRemoteViews1.addView(R.id.notification_main_column, paramRemoteViews2.clone());
      paramRemoteViews1.setViewVisibility(R.id.notification_main_column, 0);
      if (Build.VERSION.SDK_INT >= 21) {
        paramRemoteViews1.setViewPadding(R.id.notification_main_column_container, 0, calculateTopPadding(), 0, 0);
      }
    }
    
    public Bitmap createColoredBitmap(int paramInt1, int paramInt2)
    {
      return createColoredBitmap(paramInt1, paramInt2, 0);
    }
    
    public RemoteViews makeBigContentView(NotificationBuilderWithBuilderAccessor paramNotificationBuilderWithBuilderAccessor)
    {
      return null;
    }
    
    public RemoteViews makeContentView(NotificationBuilderWithBuilderAccessor paramNotificationBuilderWithBuilderAccessor)
    {
      return null;
    }
    
    public RemoteViews makeHeadsUpContentView(NotificationBuilderWithBuilderAccessor paramNotificationBuilderWithBuilderAccessor)
    {
      return null;
    }
    
    public void restoreFromCompatExtras(Bundle paramBundle) {}
    
    public void setBuilder(NotificationCompat.Builder paramBuilder)
    {
      if (mBuilder != paramBuilder)
      {
        mBuilder = paramBuilder;
        paramBuilder = mBuilder;
        if (paramBuilder != null) {
          paramBuilder.setStyle(this);
        }
      }
    }
  }
  
  public final class WearableExtender
    implements NotificationCompat.Extender
  {
    public static final int DEFAULT_CONTENT_ICON_GRAVITY = 8388613;
    public static final int DEFAULT_FLAGS = 1;
    public static final int DEFAULT_GRAVITY = 80;
    public static final String EXTRA_WEARABLE_EXTENSIONS = "android.wearable.EXTENSIONS";
    public static final int FLAG_BIG_PICTURE_AMBIENT = 32;
    public static final int FLAG_CONTENT_INTENT_AVAILABLE_OFFLINE = 1;
    public static final int FLAG_HINT_AVOID_BACKGROUND_CLIPPING = 16;
    public static final int FLAG_HINT_CONTENT_INTENT_LAUNCHES_ACTIVITY = 64;
    public static final int FLAG_HINT_HIDE_ICON = 2;
    public static final int FLAG_HINT_SHOW_BACKGROUND_ONLY = 4;
    public static final int FLAG_START_SCROLL_BOTTOM = 8;
    public static final String KEY_ACTIONS = "actions";
    public static final String KEY_BACKGROUND = "background";
    public static final String KEY_BRIDGE_TAG = "bridgeTag";
    public static final String KEY_CONTENT_ACTION_INDEX = "contentActionIndex";
    public static final String KEY_CONTENT_ICON = "contentIcon";
    public static final String KEY_CONTENT_ICON_GRAVITY = "contentIconGravity";
    public static final String KEY_CUSTOM_CONTENT_HEIGHT = "customContentHeight";
    public static final String KEY_CUSTOM_SIZE_PRESET = "customSizePreset";
    public static final String KEY_DISMISSAL_ID = "dismissalId";
    public static final String KEY_DISPLAY_INTENT = "displayIntent";
    public static final String KEY_FLAGS = "flags";
    public static final String KEY_GRAVITY = "gravity";
    public static final String KEY_HINT_SCREEN_TIMEOUT = "hintScreenTimeout";
    public static final String KEY_PAGES = "pages";
    public static final int SCREEN_TIMEOUT_LONG = -1;
    public static final int SCREEN_TIMEOUT_SHORT = 0;
    public static final int SIZE_DEFAULT = 0;
    public static final int SIZE_FULL_SCREEN = 5;
    public static final int SIZE_LARGE = 4;
    public static final int SIZE_MEDIUM = 3;
    public static final int SIZE_SMALL = 2;
    public static final int SIZE_XSMALL = 1;
    public static final int UNSET_ACTION_INDEX = -1;
    public ArrayList<android.support.v4.app.NotificationCompat.Action> mActions = new ArrayList();
    public Bitmap mBackground;
    public String mBridgeTag;
    public int mContentActionIndex = -1;
    public int mContentIcon;
    public int mContentIconGravity = 8388613;
    public int mCustomContentHeight;
    public int mCustomSizePreset = 0;
    public String mDismissalId;
    public PendingIntent mDisplayIntent;
    public int mFlags = 1;
    public int mGravity = 80;
    public int mHintScreenTimeout;
    public ArrayList<Notification> mPages = new ArrayList();
    
    public WearableExtender() {}
    
    public WearableExtender()
    {
      this$1 = NotificationCompat.getExtras(this$1);
      if (this$1 != null) {
        this$1 = this$1.getBundle("android.wearable.EXTENSIONS");
      } else {
        this$1 = null;
      }
      if (this$1 != null)
      {
        Object localObject = this$1.getParcelableArrayList("actions");
        int i = Build.VERSION.SDK_INT;
        if (localObject != null)
        {
          NotificationCompat.Action[] arrayOfAction = new NotificationCompat.Action[((ArrayList)localObject).size()];
          i = 0;
          while (i < arrayOfAction.length)
          {
            if (Build.VERSION.SDK_INT >= 20) {
              arrayOfAction[i] = NotificationCompat.getActionCompatFromAction((Notification.Action)((ArrayList)localObject).get(i));
            } else {
              arrayOfAction[i] = NotificationCompatJellybean.getActionFromBundle((Bundle)((ArrayList)localObject).get(i));
            }
            i += 1;
          }
          Collections.addAll(mActions, arrayOfAction);
        }
        mFlags = this$1.getInt("flags", 1);
        mDisplayIntent = ((PendingIntent)this$1.getParcelable("displayIntent"));
        localObject = NotificationCompat.getNotificationArrayFromBundle(this$1, "pages");
        if (localObject != null) {
          Collections.addAll(mPages, (Object[])localObject);
        }
        mBackground = ((Bitmap)this$1.getParcelable("background"));
        mContentIcon = this$1.getInt("contentIcon");
        mContentIconGravity = this$1.getInt("contentIconGravity", 8388613);
        mContentActionIndex = this$1.getInt("contentActionIndex", -1);
        mCustomSizePreset = this$1.getInt("customSizePreset", 0);
        mCustomContentHeight = this$1.getInt("customContentHeight");
        mGravity = this$1.getInt("gravity", 80);
        mHintScreenTimeout = this$1.getInt("hintScreenTimeout");
        mDismissalId = this$1.getString("dismissalId");
        mBridgeTag = this$1.getString("bridgeTag");
      }
    }
    
    public static Notification.Action getActionFromActionCompat(NotificationCompat.Action paramAction)
    {
      Notification.Action.Builder localBuilder = new Notification.Action.Builder(paramAction.getIcon(), paramAction.getTitle(), paramAction.getActionIntent());
      Bundle localBundle;
      if (paramAction.getExtras() != null) {
        localBundle = new Bundle(paramAction.getExtras());
      } else {
        localBundle = new Bundle();
      }
      localBundle.putBoolean("android.support.allowGeneratedReplies", paramAction.getAllowGeneratedReplies());
      if (Build.VERSION.SDK_INT >= 24) {
        localBuilder.setAllowGeneratedReplies(paramAction.getAllowGeneratedReplies());
      }
      localBuilder.addExtras(localBundle);
      paramAction = paramAction.getRemoteInputs();
      if (paramAction != null)
      {
        paramAction = RemoteInput.fromCompat(paramAction);
        int j = paramAction.length;
        int i = 0;
        while (i < j)
        {
          localBuilder.addRemoteInput(paramAction[i]);
          i += 1;
        }
      }
      return localBuilder.build();
    }
    
    private void setFlag(int paramInt, boolean paramBoolean)
    {
      if (paramBoolean)
      {
        mFlags = (paramInt | mFlags);
        return;
      }
      mFlags = (paramInt & mFlags);
    }
    
    public WearableExtender addAction(NotificationCompat.Action paramAction)
    {
      mActions.add(paramAction);
      return this;
    }
    
    public WearableExtender addActions(List paramList)
    {
      mActions.addAll(paramList);
      return this;
    }
    
    public WearableExtender addPage(Notification paramNotification)
    {
      mPages.add(paramNotification);
      return this;
    }
    
    public WearableExtender addPages(List paramList)
    {
      mPages.addAll(paramList);
      return this;
    }
    
    public WearableExtender clearActions()
    {
      mActions.clear();
      return this;
    }
    
    public WearableExtender clearPages()
    {
      mPages.clear();
      return this;
    }
    
    public WearableExtender clone()
    {
      WearableExtender localWearableExtender = new WearableExtender();
      mActions = new ArrayList(mActions);
      mFlags = mFlags;
      mDisplayIntent = mDisplayIntent;
      mPages = new ArrayList(mPages);
      mBackground = mBackground;
      mContentIcon = mContentIcon;
      mContentIconGravity = mContentIconGravity;
      mContentActionIndex = mContentActionIndex;
      mCustomSizePreset = mCustomSizePreset;
      mCustomContentHeight = mCustomContentHeight;
      mGravity = mGravity;
      mHintScreenTimeout = mHintScreenTimeout;
      mDismissalId = mDismissalId;
      mBridgeTag = mBridgeTag;
      return localWearableExtender;
    }
    
    public NotificationCompat.Builder extend(NotificationCompat.Builder paramBuilder)
    {
      Bundle localBundle = new Bundle();
      if (!mActions.isEmpty())
      {
        i = Build.VERSION.SDK_INT;
        localObject = new ArrayList(mActions.size());
        Iterator localIterator = mActions.iterator();
        while (localIterator.hasNext())
        {
          NotificationCompat.Action localAction = (NotificationCompat.Action)localIterator.next();
          if (Build.VERSION.SDK_INT >= 20) {
            ((ArrayList)localObject).add(getActionFromActionCompat(localAction));
          } else {
            ((ArrayList)localObject).add(NotificationCompatJellybean.getBundleForAction(localAction));
          }
        }
        localBundle.putParcelableArrayList("actions", (ArrayList)localObject);
      }
      int i = mFlags;
      if (i != 1) {
        localBundle.putInt("flags", i);
      }
      Object localObject = mDisplayIntent;
      if (localObject != null) {
        localBundle.putParcelable("displayIntent", (Parcelable)localObject);
      }
      if (!mPages.isEmpty())
      {
        localObject = mPages;
        localBundle.putParcelableArray("pages", (Parcelable[])((ArrayList)localObject).toArray(new Notification[((ArrayList)localObject).size()]));
      }
      localObject = mBackground;
      if (localObject != null) {
        localBundle.putParcelable("background", (Parcelable)localObject);
      }
      i = mContentIcon;
      if (i != 0) {
        localBundle.putInt("contentIcon", i);
      }
      i = mContentIconGravity;
      if (i != 8388613) {
        localBundle.putInt("contentIconGravity", i);
      }
      i = mContentActionIndex;
      if (i != -1) {
        localBundle.putInt("contentActionIndex", i);
      }
      i = mCustomSizePreset;
      if (i != 0) {
        localBundle.putInt("customSizePreset", i);
      }
      i = mCustomContentHeight;
      if (i != 0) {
        localBundle.putInt("customContentHeight", i);
      }
      i = mGravity;
      if (i != 80) {
        localBundle.putInt("gravity", i);
      }
      i = mHintScreenTimeout;
      if (i != 0) {
        localBundle.putInt("hintScreenTimeout", i);
      }
      localObject = mDismissalId;
      if (localObject != null) {
        localBundle.putString("dismissalId", (String)localObject);
      }
      localObject = mBridgeTag;
      if (localObject != null) {
        localBundle.putString("bridgeTag", (String)localObject);
      }
      paramBuilder.getExtras().putBundle("android.wearable.EXTENSIONS", localBundle);
      return paramBuilder;
    }
    
    public List getActions()
    {
      return mActions;
    }
    
    public Bitmap getBackground()
    {
      return mBackground;
    }
    
    public String getBridgeTag()
    {
      return mBridgeTag;
    }
    
    public int getContentAction()
    {
      return mContentActionIndex;
    }
    
    public int getContentIcon()
    {
      return mContentIcon;
    }
    
    public int getContentIconGravity()
    {
      return mContentIconGravity;
    }
    
    public boolean getContentIntentAvailableOffline()
    {
      return (mFlags & 0x1) != 0;
    }
    
    public int getCustomContentHeight()
    {
      return mCustomContentHeight;
    }
    
    public int getCustomSizePreset()
    {
      return mCustomSizePreset;
    }
    
    public String getDismissalId()
    {
      return mDismissalId;
    }
    
    public PendingIntent getDisplayIntent()
    {
      return mDisplayIntent;
    }
    
    public int getGravity()
    {
      return mGravity;
    }
    
    public boolean getHintAmbientBigPicture()
    {
      return (mFlags & 0x20) != 0;
    }
    
    public boolean getHintAvoidBackgroundClipping()
    {
      return (mFlags & 0x10) != 0;
    }
    
    public boolean getHintContentIntentLaunchesActivity()
    {
      return (mFlags & 0x40) != 0;
    }
    
    public boolean getHintHideIcon()
    {
      return (mFlags & 0x2) != 0;
    }
    
    public int getHintScreenTimeout()
    {
      return mHintScreenTimeout;
    }
    
    public boolean getHintShowBackgroundOnly()
    {
      return (mFlags & 0x4) != 0;
    }
    
    public List getPages()
    {
      return mPages;
    }
    
    public boolean getStartScrollBottom()
    {
      return (mFlags & 0x8) != 0;
    }
    
    public WearableExtender setBackground(Bitmap paramBitmap)
    {
      mBackground = paramBitmap;
      return this;
    }
    
    public WearableExtender setBridgeTag(String paramString)
    {
      mBridgeTag = paramString;
      return this;
    }
    
    public WearableExtender setContentAction(int paramInt)
    {
      mContentActionIndex = paramInt;
      return this;
    }
    
    public WearableExtender setContentIcon(int paramInt)
    {
      mContentIcon = paramInt;
      return this;
    }
    
    public WearableExtender setContentIconGravity(int paramInt)
    {
      mContentIconGravity = paramInt;
      return this;
    }
    
    public WearableExtender setContentIntentAvailableOffline(boolean paramBoolean)
    {
      setFlag(1, paramBoolean);
      return this;
    }
    
    public WearableExtender setCustomContentHeight(int paramInt)
    {
      mCustomContentHeight = paramInt;
      return this;
    }
    
    public WearableExtender setCustomSizePreset(int paramInt)
    {
      mCustomSizePreset = paramInt;
      return this;
    }
    
    public WearableExtender setDismissalId(String paramString)
    {
      mDismissalId = paramString;
      return this;
    }
    
    public WearableExtender setDisplayIntent(PendingIntent paramPendingIntent)
    {
      mDisplayIntent = paramPendingIntent;
      return this;
    }
    
    public WearableExtender setGravity(int paramInt)
    {
      mGravity = paramInt;
      return this;
    }
    
    public WearableExtender setHintAmbientBigPicture(boolean paramBoolean)
    {
      setFlag(32, paramBoolean);
      return this;
    }
    
    public WearableExtender setHintAvoidBackgroundClipping(boolean paramBoolean)
    {
      setFlag(16, paramBoolean);
      return this;
    }
    
    public WearableExtender setHintContentIntentLaunchesActivity(boolean paramBoolean)
    {
      setFlag(64, paramBoolean);
      return this;
    }
    
    public WearableExtender setHintHideIcon(boolean paramBoolean)
    {
      setFlag(2, paramBoolean);
      return this;
    }
    
    public WearableExtender setHintScreenTimeout(int paramInt)
    {
      mHintScreenTimeout = paramInt;
      return this;
    }
    
    public WearableExtender setHintShowBackgroundOnly(boolean paramBoolean)
    {
      setFlag(4, paramBoolean);
      return this;
    }
    
    public WearableExtender setStartScrollBottom(boolean paramBoolean)
    {
      setFlag(8, paramBoolean);
      return this;
    }
  }
}
