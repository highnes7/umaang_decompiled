package android.support.v4.package_7;

import android.app.Notification;
import android.app.Notification.Builder;
import android.app.PendingIntent;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.SparseArray;
import b.b.a.K;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

@K(16)
public class NotificationCompatJellybean
{
  public static final String EXTRA_ALLOW_GENERATED_REPLIES = "android.support.allowGeneratedReplies";
  public static final String EXTRA_DATA_ONLY_REMOTE_INPUTS = "android.support.dataRemoteInputs";
  public static final String KEY_ACTION_INTENT = "actionIntent";
  public static final String KEY_ALLOWED_DATA_TYPES = "allowedDataTypes";
  public static final String KEY_ALLOW_FREE_FORM_INPUT = "allowFreeFormInput";
  public static final String KEY_CHOICES = "choices";
  public static final String KEY_DATA_ONLY_REMOTE_INPUTS = "dataOnlyRemoteInputs";
  public static final String KEY_EXTRAS = "extras";
  public static final String KEY_ICON = "icon";
  public static final String KEY_LABEL = "label";
  public static final String KEY_REMOTE_INPUTS = "remoteInputs";
  public static final String KEY_RESULT_KEY = "resultKey";
  public static final String KEY_SEMANTIC_ACTION = "semanticAction";
  public static final String KEY_SHOWS_USER_INTERFACE = "showsUserInterface";
  public static final String KEY_TITLE = "title";
  public static final String TAG = "NotificationCompat";
  public static Class<?> sActionClass;
  public static Field sActionIconField;
  public static Field sActionIntentField;
  public static Field sActionTitleField;
  public static boolean sActionsAccessFailed;
  public static Field sActionsField;
  public static final Object sActionsLock = new Object();
  public static Field sExtrasField;
  public static boolean sExtrasFieldAccessFailed;
  public static final Object sExtrasLock = new Object();
  
  public NotificationCompatJellybean() {}
  
  public static SparseArray buildActionExtrasMap(List paramList)
  {
    int j = paramList.size();
    Object localObject1 = null;
    int i = 0;
    while (i < j)
    {
      Bundle localBundle = (Bundle)paramList.get(i);
      Object localObject2 = localObject1;
      if (localBundle != null)
      {
        localObject2 = localObject1;
        if (localObject1 == null) {
          localObject2 = new SparseArray();
        }
        ((SparseArray)localObject2).put(i, localBundle);
      }
      i += 1;
      localObject1 = localObject2;
    }
    return localObject1;
  }
  
  public static boolean ensureActionReflectionReadyLocked()
  {
    if (sActionsAccessFailed) {
      return false;
    }
    if (sActionsField == null) {}
    for (;;)
    {
      try
      {
        localObject = Class.forName("android.app.Notification$Action");
        sActionClass = (Class)localObject;
        localObject = sActionClass;
        localObject = ((Class)localObject).getDeclaredField("icon");
        sActionIconField = (Field)localObject;
        localObject = sActionClass;
        localObject = ((Class)localObject).getDeclaredField("title");
        sActionTitleField = (Field)localObject;
        localObject = sActionClass;
        localObject = ((Class)localObject).getDeclaredField("actionIntent");
        sActionIntentField = (Field)localObject;
      }
      catch (ClassNotFoundException localClassNotFoundException1)
      {
        Object localObject;
        continue;
      }
      catch (NoSuchFieldException localNoSuchFieldException1)
      {
        continue;
      }
      try
      {
        localObject = Notification.class.getDeclaredField("actions");
        sActionsField = (Field)localObject;
        localObject = sActionsField;
        ((Field)localObject).setAccessible(true);
      }
      catch (ClassNotFoundException localClassNotFoundException2) {}catch (NoSuchFieldException localNoSuchFieldException2) {}
    }
    sActionsAccessFailed = true;
    break label104;
    sActionsAccessFailed = true;
    label104:
    return true ^ sActionsAccessFailed;
  }
  
  public static RemoteInput fromBundle(Bundle paramBundle)
  {
    Object localObject = paramBundle.getStringArrayList("allowedDataTypes");
    HashSet localHashSet = new HashSet();
    if (localObject != null)
    {
      localObject = ((ArrayList)localObject).iterator();
      while (((Iterator)localObject).hasNext()) {
        localHashSet.add((String)((Iterator)localObject).next());
      }
    }
    return new RemoteInput(paramBundle.getString("resultKey"), paramBundle.getCharSequence("label"), paramBundle.getCharSequenceArray("choices"), paramBundle.getBoolean("allowFreeFormInput"), paramBundle.getBundle("extras"), localHashSet);
  }
  
  public static RemoteInput[] fromBundleArray(Bundle[] paramArrayOfBundle)
  {
    if (paramArrayOfBundle == null) {
      return null;
    }
    RemoteInput[] arrayOfRemoteInput = new RemoteInput[paramArrayOfBundle.length];
    int i = 0;
    while (i < paramArrayOfBundle.length)
    {
      arrayOfRemoteInput[i] = fromBundle(paramArrayOfBundle[i]);
      i += 1;
    }
    return arrayOfRemoteInput;
  }
  
  public static NotificationCompat.Action getAction(Notification paramNotification, int paramInt)
  {
    localObject1 = sActionsLock;
    try
    {
      localObject2 = getActionObjectsLocked(paramNotification);
      if (localObject2 == null) {
        break label123;
      }
      localObject2 = localObject2[paramInt];
      paramNotification = getExtras(paramNotification);
      if (paramNotification == null) {
        break label135;
      }
      paramNotification = paramNotification.getSparseParcelableArray("android.support.actionExtras");
      if (paramNotification == null) {
        break label135;
      }
      paramNotification = paramNotification.get(paramInt);
      paramNotification = (Bundle)paramNotification;
    }
    catch (Throwable paramNotification)
    {
      Object localObject2;
      Object localObject3;
      Field localField;
      break label127;
      sActionsAccessFailed = true;
      return null;
      throw paramNotification;
    }
    catch (IllegalAccessException paramNotification)
    {
      for (;;)
      {
        continue;
        paramNotification = null;
      }
    }
    localObject3 = sActionIconField;
    paramInt = ((Field)localObject3).getInt(localObject2);
    localObject3 = sActionTitleField;
    localObject3 = ((Field)localObject3).get(localObject2);
    localObject3 = (CharSequence)localObject3;
    localField = sActionIntentField;
    localObject2 = localField.get(localObject2);
    localObject2 = (PendingIntent)localObject2;
    paramNotification = readAction(paramInt, (CharSequence)localObject3, (PendingIntent)localObject2, paramNotification);
    return paramNotification;
  }
  
  public static int getActionCount(Notification paramNotification)
  {
    Object localObject = sActionsLock;
    for (;;)
    {
      try
      {
        paramNotification = getActionObjectsLocked(paramNotification);
        if (paramNotification != null)
        {
          i = paramNotification.length;
          return i;
        }
      }
      catch (Throwable paramNotification)
      {
        throw paramNotification;
      }
      int i = 0;
    }
  }
  
  public static NotificationCompat.Action getActionFromBundle(Bundle paramBundle)
  {
    Bundle localBundle = paramBundle.getBundle("extras");
    boolean bool;
    if (localBundle != null) {
      bool = localBundle.getBoolean("android.support.allowGeneratedReplies", false);
    } else {
      bool = false;
    }
    return new NotificationCompat.Action(paramBundle.getInt("icon"), paramBundle.getCharSequence("title"), (PendingIntent)paramBundle.getParcelable("actionIntent"), paramBundle.getBundle("extras"), fromBundleArray(getBundleArrayFromBundle(paramBundle, "remoteInputs")), fromBundleArray(getBundleArrayFromBundle(paramBundle, "dataOnlyRemoteInputs")), bool, paramBundle.getInt("semanticAction"), paramBundle.getBoolean("showsUserInterface"));
  }
  
  public static Object[] getActionObjectsLocked(Notification paramNotification)
  {
    localObject = sActionsLock;
    try
    {
      if (!ensureActionReflectionReadyLocked()) {
        return null;
      }
      localField = sActionsField;
    }
    catch (Throwable paramNotification)
    {
      Field localField;
      label35:
      throw paramNotification;
    }
    try
    {
      paramNotification = localField.get(paramNotification);
      paramNotification = (Object[])paramNotification;
      return paramNotification;
    }
    catch (IllegalAccessException paramNotification)
    {
      break label35;
    }
    sActionsAccessFailed = true;
    return null;
  }
  
  public static Bundle[] getBundleArrayFromBundle(Bundle paramBundle, String paramString)
  {
    Object localObject = paramBundle.getParcelableArray(paramString);
    if ((!(localObject instanceof Bundle[])) && (localObject != null))
    {
      localObject = (Bundle[])Arrays.copyOf((Object[])localObject, localObject.length, [Landroid.os.Bundle.class);
      paramBundle.putParcelableArray(paramString, (Parcelable[])localObject);
      return localObject;
    }
    return (Bundle[])localObject;
  }
  
  public static Bundle getBundleForAction(NotificationCompat.Action paramAction)
  {
    Bundle localBundle2 = new Bundle();
    localBundle2.putInt("icon", paramAction.getIcon());
    localBundle2.putCharSequence("title", paramAction.getTitle());
    localBundle2.putParcelable("actionIntent", paramAction.getActionIntent());
    Bundle localBundle1;
    if (paramAction.getExtras() != null) {
      localBundle1 = new Bundle(paramAction.getExtras());
    } else {
      localBundle1 = new Bundle();
    }
    localBundle1.putBoolean("android.support.allowGeneratedReplies", paramAction.getAllowGeneratedReplies());
    localBundle2.putBundle("extras", localBundle1);
    localBundle2.putParcelableArray("remoteInputs", toBundleArray(paramAction.getRemoteInputs()));
    localBundle2.putBoolean("showsUserInterface", paramAction.getShowsUserInterface());
    localBundle2.putInt("semanticAction", paramAction.getSemanticAction());
    return localBundle2;
  }
  
  public static Bundle getExtras(Notification paramNotification)
  {
    localObject3 = sExtrasLock;
    for (;;)
    {
      try
      {
        if (sExtrasFieldAccessFailed) {
          return null;
        }
        if (sExtrasField != null) {}
      }
      catch (Throwable paramNotification)
      {
        Object localObject1;
        boolean bool;
        Object localObject2;
        throw paramNotification;
      }
      try
      {
        localObject1 = Notification.class.getDeclaredField("extras");
        bool = Bundle.class.isAssignableFrom(((Field)localObject1).getType());
        if (!bool)
        {
          sExtrasFieldAccessFailed = true;
          return null;
        }
      }
      catch (IllegalAccessException paramNotification)
      {
        continue;
      }
      catch (NoSuchFieldException paramNotification)
      {
        continue;
      }
      try
      {
        ((Field)localObject1).setAccessible(true);
        sExtrasField = (Field)localObject1;
        localObject1 = sExtrasField;
        localObject1 = ((Field)localObject1).get(paramNotification);
        localObject2 = (Bundle)localObject1;
        localObject1 = localObject2;
        if (localObject2 == null)
        {
          localObject1 = new Bundle();
          localObject2 = sExtrasField;
          ((Field)localObject2).set(paramNotification, localObject1);
        }
        return localObject1;
      }
      catch (IllegalAccessException paramNotification) {}catch (NoSuchFieldException paramNotification) {}
    }
    sExtrasFieldAccessFailed = true;
    return null;
  }
  
  public static NotificationCompat.Action readAction(int paramInt, CharSequence paramCharSequence, PendingIntent paramPendingIntent, Bundle paramBundle)
  {
    RemoteInput[] arrayOfRemoteInput1;
    RemoteInput[] arrayOfRemoteInput2;
    boolean bool;
    if (paramBundle != null)
    {
      arrayOfRemoteInput1 = fromBundleArray(getBundleArrayFromBundle(paramBundle, "android.support.remoteInputs"));
      arrayOfRemoteInput2 = fromBundleArray(getBundleArrayFromBundle(paramBundle, "android.support.dataRemoteInputs"));
      bool = paramBundle.getBoolean("android.support.allowGeneratedReplies");
    }
    else
    {
      arrayOfRemoteInput1 = null;
      arrayOfRemoteInput2 = null;
      bool = false;
    }
    return new NotificationCompat.Action(paramInt, paramCharSequence, paramPendingIntent, paramBundle, arrayOfRemoteInput1, arrayOfRemoteInput2, bool, 0, true);
  }
  
  public static Bundle toBundle(RemoteInput paramRemoteInput)
  {
    Bundle localBundle = new Bundle();
    localBundle.putString("resultKey", paramRemoteInput.getResultKey());
    localBundle.putCharSequence("label", paramRemoteInput.getLabel());
    localBundle.putCharSequenceArray("choices", paramRemoteInput.getChoices());
    localBundle.putBoolean("allowFreeFormInput", paramRemoteInput.getAllowFreeFormInput());
    localBundle.putBundle("extras", paramRemoteInput.getExtras());
    Object localObject = paramRemoteInput.getAllowedDataTypes();
    if ((localObject != null) && (!((Set)localObject).isEmpty()))
    {
      paramRemoteInput = new ArrayList(((Set)localObject).size());
      localObject = ((Set)localObject).iterator();
      while (((Iterator)localObject).hasNext()) {
        paramRemoteInput.add((String)((Iterator)localObject).next());
      }
      localBundle.putStringArrayList("allowedDataTypes", paramRemoteInput);
    }
    return localBundle;
  }
  
  public static Bundle[] toBundleArray(RemoteInput[] paramArrayOfRemoteInput)
  {
    if (paramArrayOfRemoteInput == null) {
      return null;
    }
    Bundle[] arrayOfBundle = new Bundle[paramArrayOfRemoteInput.length];
    int i = 0;
    while (i < paramArrayOfRemoteInput.length)
    {
      arrayOfBundle[i] = toBundle(paramArrayOfRemoteInput[i]);
      i += 1;
    }
    return arrayOfBundle;
  }
  
  public static Bundle writeActionAndGetExtras(Notification.Builder paramBuilder, NotificationCompat.Action paramAction)
  {
    paramBuilder.addAction(paramAction.getIcon(), paramAction.getTitle(), paramAction.getActionIntent());
    paramBuilder = new Bundle(paramAction.getExtras());
    if (paramAction.getRemoteInputs() != null) {
      paramBuilder.putParcelableArray("android.support.remoteInputs", toBundleArray(paramAction.getRemoteInputs()));
    }
    if (paramAction.getDataOnlyRemoteInputs() != null) {
      paramBuilder.putParcelableArray("android.support.dataRemoteInputs", toBundleArray(paramAction.getDataOnlyRemoteInputs()));
    }
    paramBuilder.putBoolean("android.support.allowGeneratedReplies", paramAction.getAllowGeneratedReplies());
    return paramBuilder;
  }
}
