package android.support.v7.widget;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageItemInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.database.DataSetObservable;
import android.os.AsyncTask;
import android.text.TextUtils;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ActivityChooserModel
  extends DataSetObservable
{
  public static final String ATTRIBUTE_ACTIVITY = "activity";
  public static final String ATTRIBUTE_TIME = "time";
  public static final String ATTRIBUTE_WEIGHT = "weight";
  public static final boolean DEBUG = false;
  public static final int DEFAULT_ACTIVITY_INFLATION = 5;
  public static final float DEFAULT_HISTORICAL_RECORD_WEIGHT = 1.0F;
  public static final String DEFAULT_HISTORY_FILE_NAME = "activity_choser_model_history.xml";
  public static final int DEFAULT_HISTORY_MAX_LENGTH = 50;
  public static final String HISTORY_FILE_EXTENSION = ".xml";
  public static final int INVALID_INDEX = -1;
  public static final String LOG_TAG = "ActivityChooserModel";
  public static final String TAG_HISTORICAL_RECORD = "historical-record";
  public static final String TAG_HISTORICAL_RECORDS = "historical-records";
  public static final Map<String, ActivityChooserModel> sDataModelRegistry = new HashMap();
  public static final Object sRegistryLock = new Object();
  public final List<ActivityResolveInfo> mActivities = new ArrayList();
  public OnChooseActivityListener mActivityChoserModelPolicy;
  public ActivitySorter mActivitySorter = new DefaultSorter();
  public boolean mCanReadHistoricalData = true;
  public final Context mContext;
  public final List<HistoricalRecord> mHistoricalRecords = new ArrayList();
  public boolean mHistoricalRecordsChanged = true;
  public final String mHistoryFileName;
  public int mHistoryMaxSize = 50;
  public final Object mInstanceLock = new Object();
  public Intent mIntent;
  public boolean mReadShareHistoryCalled = false;
  public boolean mReloadActivities = false;
  
  public ActivityChooserModel(Context paramContext, String paramString)
  {
    mContext = paramContext.getApplicationContext();
    if ((!TextUtils.isEmpty(paramString)) && (!paramString.endsWith(".xml")))
    {
      mHistoryFileName = f.sufficientlysecure.rootcommands.util.StringBuilder.toString(paramString, ".xml");
      return;
    }
    mHistoryFileName = paramString;
  }
  
  private boolean addHistoricalRecord(HistoricalRecord paramHistoricalRecord)
  {
    boolean bool = mHistoricalRecords.add(paramHistoricalRecord);
    if (bool)
    {
      mHistoricalRecordsChanged = true;
      pruneExcessiveHistoricalRecordsIfNeeded();
      persistHistoricalDataIfNeeded();
      sortActivitiesIfNeeded();
      notifyChanged();
    }
    return bool;
  }
  
  private void ensureConsistentState()
  {
    boolean bool1 = loadActivitiesIfNeeded();
    boolean bool2 = readHistoricalDataIfNeeded();
    pruneExcessiveHistoricalRecordsIfNeeded();
    if ((bool1 | bool2))
    {
      sortActivitiesIfNeeded();
      notifyChanged();
    }
  }
  
  public static ActivityChooserModel get(Context paramContext, String paramString)
  {
    Object localObject = sRegistryLock;
    try
    {
      ActivityChooserModel localActivityChooserModel2 = (ActivityChooserModel)sDataModelRegistry.get(paramString);
      ActivityChooserModel localActivityChooserModel1 = localActivityChooserModel2;
      if (localActivityChooserModel2 == null)
      {
        localActivityChooserModel1 = new ActivityChooserModel(paramContext, paramString);
        sDataModelRegistry.put(paramString, localActivityChooserModel1);
      }
      return localActivityChooserModel1;
    }
    catch (Throwable paramContext)
    {
      throw paramContext;
    }
  }
  
  private boolean loadActivitiesIfNeeded()
  {
    boolean bool = mReloadActivities;
    int i = 0;
    if ((bool) && (mIntent != null))
    {
      mReloadActivities = false;
      mActivities.clear();
      List localList = mContext.getPackageManager().queryIntentActivities(mIntent, 0);
      int j = localList.size();
      while (i < j)
      {
        ResolveInfo localResolveInfo = (ResolveInfo)localList.get(i);
        mActivities.add(new ActivityResolveInfo(localResolveInfo));
        i += 1;
      }
      return true;
    }
    return false;
  }
  
  private void persistHistoricalDataIfNeeded()
  {
    if (mReadShareHistoryCalled)
    {
      if (!mHistoricalRecordsChanged) {
        return;
      }
      mHistoricalRecordsChanged = false;
      if (!TextUtils.isEmpty(mHistoryFileName)) {
        new PersistHistoryAsyncTask().executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Object[] { new ArrayList(mHistoricalRecords), mHistoryFileName });
      }
    }
    else
    {
      throw new IllegalStateException("No preceding call to #readHistoricalData");
    }
  }
  
  private void pruneExcessiveHistoricalRecordsIfNeeded()
  {
    int j = mHistoricalRecords.size() - mHistoryMaxSize;
    if (j <= 0) {
      return;
    }
    mHistoricalRecordsChanged = true;
    int i = 0;
    while (i < j)
    {
      HistoricalRecord localHistoricalRecord = (HistoricalRecord)mHistoricalRecords.remove(0);
      i += 1;
    }
  }
  
  private boolean readHistoricalDataIfNeeded()
  {
    if ((mCanReadHistoricalData) && (mHistoricalRecordsChanged) && (!TextUtils.isEmpty(mHistoryFileName)))
    {
      mCanReadHistoricalData = false;
      mReadShareHistoryCalled = true;
      readHistoricalDataImpl();
      return true;
    }
    return false;
  }
  
  /* Error */
  private void readHistoricalDataImpl()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 135	android/support/v7/widget/ActivityChooserModel:mContext	Landroid/content/Context;
    //   4: astore 6
    //   6: aload_0
    //   7: getfield 155	android/support/v7/widget/ActivityChooserModel:mHistoryFileName	Ljava/lang/String;
    //   10: astore 7
    //   12: aload 6
    //   14: aload 7
    //   16: invokevirtual 264	android/content/Context:openFileInput	(Ljava/lang/String;)Ljava/io/FileInputStream;
    //   19: astore 6
    //   21: invokestatic 270	android/util/Xml:newPullParser	()Lorg/xmlpull/v1/XmlPullParser;
    //   24: astore 7
    //   26: aload 7
    //   28: aload 6
    //   30: ldc_w 272
    //   33: invokeinterface 278 3 0
    //   38: iconst_0
    //   39: istore_2
    //   40: iload_2
    //   41: iconst_1
    //   42: if_icmpeq +19 -> 61
    //   45: iload_2
    //   46: iconst_2
    //   47: if_icmpeq +14 -> 61
    //   50: aload 7
    //   52: invokeinterface 281 1 0
    //   57: istore_2
    //   58: goto -18 -> 40
    //   61: ldc 63
    //   63: aload 7
    //   65: invokeinterface 285 1 0
    //   70: invokevirtual 288	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   73: istore_3
    //   74: iload_3
    //   75: ifeq +153 -> 228
    //   78: aload_0
    //   79: getfield 114	android/support/v7/widget/ActivityChooserModel:mHistoricalRecords	Ljava/util/List;
    //   82: astore 8
    //   84: aload 8
    //   86: invokeinterface 203 1 0
    //   91: aload 7
    //   93: invokeinterface 281 1 0
    //   98: istore_2
    //   99: iload_2
    //   100: iconst_1
    //   101: if_icmpne +14 -> 115
    //   104: aload 6
    //   106: ifnull +236 -> 342
    //   109: aload 6
    //   111: invokevirtual 293	java/io/FileInputStream:close	()V
    //   114: return
    //   115: iload_2
    //   116: iconst_3
    //   117: if_icmpeq -26 -> 91
    //   120: iload_2
    //   121: iconst_4
    //   122: if_icmpne +6 -> 128
    //   125: goto -34 -> 91
    //   128: aload 7
    //   130: invokeinterface 285 1 0
    //   135: astore 9
    //   137: ldc 60
    //   139: aload 9
    //   141: invokevirtual 288	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   144: istore_3
    //   145: iload_3
    //   146: ifeq +67 -> 213
    //   149: aload 7
    //   151: aconst_null
    //   152: ldc 29
    //   154: invokeinterface 296 3 0
    //   159: astore 9
    //   161: aload 7
    //   163: aconst_null
    //   164: ldc 32
    //   166: invokeinterface 296 3 0
    //   171: invokestatic 302	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   174: lstore 4
    //   176: aload 7
    //   178: aconst_null
    //   179: ldc 35
    //   181: invokeinterface 296 3 0
    //   186: invokestatic 308	java/lang/Float:parseFloat	(Ljava/lang/String;)F
    //   189: fstore_1
    //   190: aload 8
    //   192: new 18	android/support/v7/widget/ActivityChooserModel$HistoricalRecord
    //   195: dup
    //   196: aload 9
    //   198: lload 4
    //   200: fload_1
    //   201: invokespecial 311	android/support/v7/widget/ActivityChooserModel$HistoricalRecord:<init>	(Ljava/lang/String;JF)V
    //   204: invokeinterface 163 2 0
    //   209: pop
    //   210: goto -119 -> 91
    //   213: new 258	org/xmlpull/v1/XmlPullParserException
    //   216: dup
    //   217: ldc_w 313
    //   220: invokespecial 314	org/xmlpull/v1/XmlPullParserException:<init>	(Ljava/lang/String;)V
    //   223: astore 7
    //   225: aload 7
    //   227: athrow
    //   228: new 258	org/xmlpull/v1/XmlPullParserException
    //   231: dup
    //   232: ldc_w 316
    //   235: invokespecial 314	org/xmlpull/v1/XmlPullParserException:<init>	(Ljava/lang/String;)V
    //   238: astore 7
    //   240: aload 7
    //   242: athrow
    //   243: astore 7
    //   245: goto +98 -> 343
    //   248: getstatic 318	android/support/v7/widget/ActivityChooserModel:LOG_TAG	Ljava/lang/String;
    //   251: astore 7
    //   253: new 320	java/lang/StringBuilder
    //   256: dup
    //   257: invokespecial 321	java/lang/StringBuilder:<init>	()V
    //   260: astore 7
    //   262: aload 7
    //   264: ldc_w 323
    //   267: invokevirtual 327	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   270: pop
    //   271: aload 7
    //   273: aload_0
    //   274: getfield 155	android/support/v7/widget/ActivityChooserModel:mHistoryFileName	Ljava/lang/String;
    //   277: invokevirtual 327	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   280: pop
    //   281: aload 7
    //   283: invokevirtual 329	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   286: pop
    //   287: aload 6
    //   289: ifnull +98 -> 387
    //   292: goto -183 -> 109
    //   295: getstatic 318	android/support/v7/widget/ActivityChooserModel:LOG_TAG	Ljava/lang/String;
    //   298: astore 7
    //   300: new 320	java/lang/StringBuilder
    //   303: dup
    //   304: invokespecial 321	java/lang/StringBuilder:<init>	()V
    //   307: astore 7
    //   309: aload 7
    //   311: ldc_w 323
    //   314: invokevirtual 327	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   317: pop
    //   318: aload 7
    //   320: aload_0
    //   321: getfield 155	android/support/v7/widget/ActivityChooserModel:mHistoryFileName	Ljava/lang/String;
    //   324: invokevirtual 327	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   327: pop
    //   328: aload 7
    //   330: invokevirtual 329	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   333: pop
    //   334: aload 6
    //   336: ifnull +51 -> 387
    //   339: goto -230 -> 109
    //   342: return
    //   343: aload 6
    //   345: ifnull +8 -> 353
    //   348: aload 6
    //   350: invokevirtual 293	java/io/FileInputStream:close	()V
    //   353: aload 7
    //   355: athrow
    //   356: astore 6
    //   358: return
    //   359: astore 7
    //   361: goto -66 -> 295
    //   364: astore 7
    //   366: goto -118 -> 248
    //   369: astore 6
    //   371: return
    //   372: astore 7
    //   374: goto -79 -> 295
    //   377: astore 7
    //   379: goto -131 -> 248
    //   382: astore 6
    //   384: goto -31 -> 353
    //   387: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	388	0	this	ActivityChooserModel
    //   189	12	1	f	float
    //   39	84	2	i	int
    //   73	73	3	bool	boolean
    //   174	25	4	l	long
    //   4	345	6	localObject1	Object
    //   356	1	6	localFileNotFoundException	java.io.FileNotFoundException
    //   369	1	6	localIOException1	java.io.IOException
    //   382	1	6	localIOException2	java.io.IOException
    //   10	231	7	localObject2	Object
    //   243	1	7	localThrowable	Throwable
    //   251	103	7	localObject3	Object
    //   359	1	7	localXmlPullParserException1	org.xmlpull.v1.XmlPullParserException
    //   364	1	7	localIOException3	java.io.IOException
    //   372	1	7	localXmlPullParserException2	org.xmlpull.v1.XmlPullParserException
    //   377	1	7	localIOException4	java.io.IOException
    //   82	109	8	localList	List
    //   135	62	9	str	String
    // Exception table:
    //   from	to	target	type
    //   21	38	243	java/lang/Throwable
    //   50	58	243	java/lang/Throwable
    //   61	74	243	java/lang/Throwable
    //   84	91	243	java/lang/Throwable
    //   91	99	243	java/lang/Throwable
    //   128	137	243	java/lang/Throwable
    //   137	145	243	java/lang/Throwable
    //   149	190	243	java/lang/Throwable
    //   190	210	243	java/lang/Throwable
    //   213	225	243	java/lang/Throwable
    //   225	228	243	java/lang/Throwable
    //   228	240	243	java/lang/Throwable
    //   240	243	243	java/lang/Throwable
    //   248	287	243	java/lang/Throwable
    //   295	334	243	java/lang/Throwable
    //   12	21	356	java/io/FileNotFoundException
    //   21	38	359	org/xmlpull/v1/XmlPullParserException
    //   50	58	359	org/xmlpull/v1/XmlPullParserException
    //   61	74	359	org/xmlpull/v1/XmlPullParserException
    //   84	91	359	org/xmlpull/v1/XmlPullParserException
    //   91	99	359	org/xmlpull/v1/XmlPullParserException
    //   21	38	364	java/io/IOException
    //   50	58	364	java/io/IOException
    //   61	74	364	java/io/IOException
    //   84	91	364	java/io/IOException
    //   91	99	364	java/io/IOException
    //   109	114	369	java/io/IOException
    //   128	137	372	org/xmlpull/v1/XmlPullParserException
    //   137	145	372	org/xmlpull/v1/XmlPullParserException
    //   149	190	372	org/xmlpull/v1/XmlPullParserException
    //   190	210	372	org/xmlpull/v1/XmlPullParserException
    //   213	225	372	org/xmlpull/v1/XmlPullParserException
    //   225	228	372	org/xmlpull/v1/XmlPullParserException
    //   228	240	372	org/xmlpull/v1/XmlPullParserException
    //   240	243	372	org/xmlpull/v1/XmlPullParserException
    //   128	137	377	java/io/IOException
    //   137	145	377	java/io/IOException
    //   149	190	377	java/io/IOException
    //   190	210	377	java/io/IOException
    //   213	225	377	java/io/IOException
    //   228	240	377	java/io/IOException
    //   348	353	382	java/io/IOException
  }
  
  private boolean sortActivitiesIfNeeded()
  {
    if ((mActivitySorter != null) && (mIntent != null) && (!mActivities.isEmpty()) && (!mHistoricalRecords.isEmpty()))
    {
      mActivitySorter.sort(mIntent, mActivities, Collections.unmodifiableList(mHistoricalRecords));
      return true;
    }
    return false;
  }
  
  public Intent chooseActivity(int paramInt)
  {
    Object localObject1 = mInstanceLock;
    try
    {
      if (mIntent == null) {
        return null;
      }
      ensureConsistentState();
      Object localObject2 = (ActivityResolveInfo)mActivities.get(paramInt);
      localObject2 = new ComponentName(resolveInfo.activityInfo.packageName, resolveInfo.activityInfo.name);
      Intent localIntent1 = new Intent(mIntent);
      localIntent1.setComponent((ComponentName)localObject2);
      if (mActivityChoserModelPolicy != null)
      {
        Intent localIntent2 = new Intent(localIntent1);
        if (mActivityChoserModelPolicy.onChooseActivity(this, localIntent2)) {
          return null;
        }
      }
      addHistoricalRecord(new HistoricalRecord((ComponentName)localObject2, System.currentTimeMillis(), 1.0F));
      return localIntent1;
    }
    catch (Throwable localThrowable)
    {
      throw localThrowable;
    }
  }
  
  public ResolveInfo getActivity(int paramInt)
  {
    Object localObject = mInstanceLock;
    try
    {
      ensureConsistentState();
      ResolveInfo localResolveInfo = mActivities.get(paramInt)).resolveInfo;
      return localResolveInfo;
    }
    catch (Throwable localThrowable)
    {
      throw localThrowable;
    }
  }
  
  public int getActivityCount()
  {
    Object localObject = mInstanceLock;
    try
    {
      ensureConsistentState();
      int i = mActivities.size();
      return i;
    }
    catch (Throwable localThrowable)
    {
      throw localThrowable;
    }
  }
  
  public int getActivityIndex(ResolveInfo paramResolveInfo)
  {
    Object localObject = mInstanceLock;
    try
    {
      ensureConsistentState();
      List localList = mActivities;
      int j = localList.size();
      int i = 0;
      while (i < j)
      {
        if (getresolveInfo == paramResolveInfo) {
          return i;
        }
        i += 1;
      }
      return -1;
    }
    catch (Throwable paramResolveInfo)
    {
      throw paramResolveInfo;
    }
  }
  
  public ResolveInfo getDefaultActivity()
  {
    Object localObject = mInstanceLock;
    try
    {
      ensureConsistentState();
      if (!mActivities.isEmpty())
      {
        ResolveInfo localResolveInfo = mActivities.get(0)).resolveInfo;
        return localResolveInfo;
      }
      return null;
    }
    catch (Throwable localThrowable)
    {
      throw localThrowable;
    }
  }
  
  public int getHistoryMaxSize()
  {
    Object localObject = mInstanceLock;
    try
    {
      int i = mHistoryMaxSize;
      return i;
    }
    catch (Throwable localThrowable)
    {
      throw localThrowable;
    }
  }
  
  public int getHistorySize()
  {
    Object localObject = mInstanceLock;
    try
    {
      ensureConsistentState();
      int i = mHistoricalRecords.size();
      return i;
    }
    catch (Throwable localThrowable)
    {
      throw localThrowable;
    }
  }
  
  public Intent getIntent()
  {
    Object localObject = mInstanceLock;
    try
    {
      Intent localIntent = mIntent;
      return localIntent;
    }
    catch (Throwable localThrowable)
    {
      throw localThrowable;
    }
  }
  
  public void setActivitySorter(ActivitySorter paramActivitySorter)
  {
    Object localObject = mInstanceLock;
    try
    {
      if (mActivitySorter == paramActivitySorter) {
        return;
      }
      mActivitySorter = paramActivitySorter;
      if (sortActivitiesIfNeeded()) {
        notifyChanged();
      }
      return;
    }
    catch (Throwable paramActivitySorter)
    {
      throw paramActivitySorter;
    }
  }
  
  public void setDefaultActivity(int paramInt)
  {
    Object localObject = mInstanceLock;
    for (;;)
    {
      try
      {
        ensureConsistentState();
        ActivityResolveInfo localActivityResolveInfo1 = (ActivityResolveInfo)mActivities.get(paramInt);
        ActivityResolveInfo localActivityResolveInfo2 = (ActivityResolveInfo)mActivities.get(0);
        if (localActivityResolveInfo2 != null)
        {
          f = weight - weight + 5.0F;
          addHistoricalRecord(new HistoricalRecord(new ComponentName(resolveInfo.activityInfo.packageName, resolveInfo.activityInfo.name), System.currentTimeMillis(), f));
          return;
        }
      }
      catch (Throwable localThrowable)
      {
        throw localThrowable;
      }
      float f = 1.0F;
    }
  }
  
  public void setHistoryMaxSize(int paramInt)
  {
    Object localObject = mInstanceLock;
    try
    {
      if (mHistoryMaxSize == paramInt) {
        return;
      }
      mHistoryMaxSize = paramInt;
      pruneExcessiveHistoricalRecordsIfNeeded();
      if (sortActivitiesIfNeeded()) {
        notifyChanged();
      }
      return;
    }
    catch (Throwable localThrowable)
    {
      throw localThrowable;
    }
  }
  
  public void setIntent(Intent paramIntent)
  {
    Object localObject = mInstanceLock;
    try
    {
      if (mIntent == paramIntent) {
        return;
      }
      mIntent = paramIntent;
      mReloadActivities = true;
      ensureConsistentState();
      return;
    }
    catch (Throwable paramIntent)
    {
      throw paramIntent;
    }
  }
  
  public void setOnChooseActivityListener(OnChooseActivityListener paramOnChooseActivityListener)
  {
    Object localObject = mInstanceLock;
    try
    {
      mActivityChoserModelPolicy = paramOnChooseActivityListener;
      return;
    }
    catch (Throwable paramOnChooseActivityListener)
    {
      throw paramOnChooseActivityListener;
    }
  }
  
  public static abstract interface ActivityChooserModelClient
  {
    public abstract void setActivityChooserModel(ActivityChooserModel paramActivityChooserModel);
  }
  
  public static final class ActivityResolveInfo
    implements Comparable<ActivityResolveInfo>
  {
    public final ResolveInfo resolveInfo;
    public float weight;
    
    public ActivityResolveInfo(ResolveInfo paramResolveInfo)
    {
      resolveInfo = paramResolveInfo;
    }
    
    public int compareTo(ActivityResolveInfo paramActivityResolveInfo)
    {
      return Float.floatToIntBits(weight) - Float.floatToIntBits(weight);
    }
    
    public boolean equals(Object paramObject)
    {
      if (this == paramObject) {
        return true;
      }
      if (paramObject == null) {
        return false;
      }
      if (ActivityResolveInfo.class != paramObject.getClass()) {
        return false;
      }
      paramObject = (ActivityResolveInfo)paramObject;
      return Float.floatToIntBits(weight) == Float.floatToIntBits(weight);
    }
    
    public int hashCode()
    {
      return Float.floatToIntBits(weight) + 31;
    }
    
    public String toString()
    {
      StringBuilder localStringBuilder = f.sufficientlysecure.rootcommands.util.StringBuilder.append("[", "resolveInfo:");
      localStringBuilder.append(resolveInfo.toString());
      localStringBuilder.append("; weight:");
      return f.sufficientlysecure.rootcommands.util.StringBuilder.append(localStringBuilder, new BigDecimal(weight), "]");
    }
  }
  
  public static abstract interface ActivitySorter
  {
    public abstract void sort(Intent paramIntent, List paramList1, List paramList2);
  }
  
  private static final class DefaultSorter
    implements ActivityChooserModel.ActivitySorter
  {
    public static final float WEIGHT_DECAY_COEFFICIENT = 0.95F;
    public final Map<ComponentName, ActivityChooserModel.ActivityResolveInfo> mPackageNameToActivityMap = new HashMap();
    
    public DefaultSorter() {}
    
    public void sort(Intent paramIntent, List paramList1, List paramList2)
    {
      paramIntent = mPackageNameToActivityMap;
      paramIntent.clear();
      int j = paramList1.size();
      int i = 0;
      Object localObject;
      while (i < j)
      {
        localObject = (ActivityChooserModel.ActivityResolveInfo)paramList1.get(i);
        weight = 0.0F;
        paramIntent.put(new ComponentName(resolveInfo.activityInfo.packageName, resolveInfo.activityInfo.name), localObject);
        i += 1;
      }
      i = paramList2.size() - 1;
      float f2;
      for (float f1 = 1.0F; i >= 0; f1 = f2)
      {
        localObject = (ActivityChooserModel.HistoricalRecord)paramList2.get(i);
        ActivityChooserModel.ActivityResolveInfo localActivityResolveInfo = (ActivityChooserModel.ActivityResolveInfo)paramIntent.get(activity);
        f2 = f1;
        if (localActivityResolveInfo != null)
        {
          f2 = weight;
          weight = (weight * f1 + f2);
          f2 = f1 * 0.95F;
        }
        i -= 1;
      }
      Collections.sort(paramList1);
    }
  }
  
  public static final class HistoricalRecord
  {
    public final ComponentName activity;
    public final long time;
    public final float weight;
    
    public HistoricalRecord(ComponentName paramComponentName, long paramLong, float paramFloat)
    {
      activity = paramComponentName;
      time = paramLong;
      weight = paramFloat;
    }
    
    public HistoricalRecord(String paramString, long paramLong, float paramFloat)
    {
      this(ComponentName.unflattenFromString(paramString), paramLong, paramFloat);
    }
    
    public boolean equals(Object paramObject)
    {
      if (this == paramObject) {
        return true;
      }
      if (paramObject == null) {
        return false;
      }
      if (HistoricalRecord.class != paramObject.getClass()) {
        return false;
      }
      paramObject = (HistoricalRecord)paramObject;
      ComponentName localComponentName = activity;
      if (localComponentName == null)
      {
        if (activity != null) {
          return false;
        }
      }
      else if (!localComponentName.equals(activity)) {
        return false;
      }
      if (time != time) {
        return false;
      }
      return Float.floatToIntBits(weight) == Float.floatToIntBits(weight);
    }
    
    public int hashCode()
    {
      ComponentName localComponentName = activity;
      int i;
      if (localComponentName == null) {
        i = 0;
      } else {
        i = localComponentName.hashCode();
      }
      long l = time;
      int j = (int)(l ^ l >>> 32);
      return Float.floatToIntBits(weight) + ((i + 31) * 31 + j) * 31;
    }
    
    public String toString()
    {
      StringBuilder localStringBuilder = f.sufficientlysecure.rootcommands.util.StringBuilder.append("[", "; activity:");
      localStringBuilder.append(activity);
      localStringBuilder.append("; time:");
      localStringBuilder.append(time);
      localStringBuilder.append("; weight:");
      return f.sufficientlysecure.rootcommands.util.StringBuilder.append(localStringBuilder, new BigDecimal(weight), "]");
    }
  }
  
  public static abstract interface OnChooseActivityListener
  {
    public abstract boolean onChooseActivity(ActivityChooserModel paramActivityChooserModel, Intent paramIntent);
  }
  
  private final class PersistHistoryAsyncTask
    extends AsyncTask<Object, Void, Void>
  {
    public PersistHistoryAsyncTask() {}
    
    /* Error */
    public Void doInBackground(Object... paramVarArgs)
    {
      // Byte code:
      //   0: aload_1
      //   1: iconst_0
      //   2: aaload
      //   3: checkcast 35	java/util/List
      //   6: astore 7
      //   8: aload_1
      //   9: iconst_1
      //   10: aaload
      //   11: checkcast 37	java/lang/String
      //   14: astore 8
      //   16: aload_0
      //   17: getfield 14	android/support/v7/widget/ActivityChooserModel$PersistHistoryAsyncTask:this$0	Landroid/support/v7/widget/ActivityChooserModel;
      //   20: getfield 41	android/support/v7/widget/ActivityChooserModel:mContext	Landroid/content/Context;
      //   23: astore_1
      //   24: aload_1
      //   25: aload 8
      //   27: iconst_0
      //   28: invokevirtual 47	android/content/Context:openFileOutput	(Ljava/lang/String;I)Ljava/io/FileOutputStream;
      //   31: astore_1
      //   32: invokestatic 53	android/util/Xml:newSerializer	()Lorg/xmlpull/v1/XmlSerializer;
      //   35: astore 8
      //   37: aload 8
      //   39: aload_1
      //   40: aconst_null
      //   41: invokeinterface 59 3 0
      //   46: aload 8
      //   48: ldc 61
      //   50: iconst_1
      //   51: invokestatic 67	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
      //   54: invokeinterface 71 3 0
      //   59: aload 8
      //   61: aconst_null
      //   62: ldc 73
      //   64: invokeinterface 77 3 0
      //   69: pop
      //   70: aload 7
      //   72: invokeinterface 81 1 0
      //   77: istore 4
      //   79: iconst_0
      //   80: istore_3
      //   81: iload_3
      //   82: iload 4
      //   84: if_icmpge +116 -> 200
      //   87: aload 7
      //   89: iconst_0
      //   90: invokeinterface 85 2 0
      //   95: astore 9
      //   97: aload 9
      //   99: checkcast 87	android/support/v7/widget/ActivityChooserModel$HistoricalRecord
      //   102: astore 9
      //   104: aload 8
      //   106: aconst_null
      //   107: ldc 89
      //   109: invokeinterface 77 3 0
      //   114: pop
      //   115: aload 9
      //   117: getfield 93	android/support/v7/widget/ActivityChooserModel$HistoricalRecord:activity	Landroid/content/ComponentName;
      //   120: astore 10
      //   122: aload 8
      //   124: aconst_null
      //   125: ldc 94
      //   127: aload 10
      //   129: invokevirtual 100	android/content/ComponentName:flattenToString	()Ljava/lang/String;
      //   132: invokeinterface 104 4 0
      //   137: pop
      //   138: aload 9
      //   140: getfield 108	android/support/v7/widget/ActivityChooserModel$HistoricalRecord:time	J
      //   143: lstore 5
      //   145: aload 8
      //   147: aconst_null
      //   148: ldc 109
      //   150: lload 5
      //   152: invokestatic 112	java/lang/String:valueOf	(J)Ljava/lang/String;
      //   155: invokeinterface 104 4 0
      //   160: pop
      //   161: aload 9
      //   163: getfield 116	android/support/v7/widget/ActivityChooserModel$HistoricalRecord:weight	F
      //   166: fstore_2
      //   167: aload 8
      //   169: aconst_null
      //   170: ldc 117
      //   172: fload_2
      //   173: invokestatic 120	java/lang/String:valueOf	(F)Ljava/lang/String;
      //   176: invokeinterface 104 4 0
      //   181: pop
      //   182: aload 8
      //   184: aconst_null
      //   185: ldc 89
      //   187: invokeinterface 123 3 0
      //   192: pop
      //   193: iload_3
      //   194: iconst_1
      //   195: iadd
      //   196: istore_3
      //   197: goto -116 -> 81
      //   200: aload 8
      //   202: aconst_null
      //   203: ldc 73
      //   205: invokeinterface 123 3 0
      //   210: pop
      //   211: aload 8
      //   213: invokeinterface 126 1 0
      //   218: aload_0
      //   219: getfield 14	android/support/v7/widget/ActivityChooserModel$PersistHistoryAsyncTask:this$0	Landroid/support/v7/widget/ActivityChooserModel;
      //   222: iconst_1
      //   223: putfield 130	android/support/v7/widget/ActivityChooserModel:mCanReadHistoricalData	Z
      //   226: aload_1
      //   227: ifnull +240 -> 467
      //   230: goto +173 -> 403
      //   233: astore 7
      //   235: goto +174 -> 409
      //   238: getstatic 134	android/support/v7/widget/ActivityChooserModel:LOG_TAG	Ljava/lang/String;
      //   241: astore 7
      //   243: new 136	java/lang/StringBuilder
      //   246: dup
      //   247: invokespecial 137	java/lang/StringBuilder:<init>	()V
      //   250: astore 7
      //   252: aload 7
      //   254: ldc -117
      //   256: invokevirtual 143	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   259: pop
      //   260: aload 7
      //   262: aload_0
      //   263: getfield 14	android/support/v7/widget/ActivityChooserModel$PersistHistoryAsyncTask:this$0	Landroid/support/v7/widget/ActivityChooserModel;
      //   266: getfield 146	android/support/v7/widget/ActivityChooserModel:mHistoryFileName	Ljava/lang/String;
      //   269: invokevirtual 143	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   272: pop
      //   273: aload 7
      //   275: invokevirtual 149	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   278: pop
      //   279: aload_0
      //   280: getfield 14	android/support/v7/widget/ActivityChooserModel$PersistHistoryAsyncTask:this$0	Landroid/support/v7/widget/ActivityChooserModel;
      //   283: iconst_1
      //   284: putfield 130	android/support/v7/widget/ActivityChooserModel:mCanReadHistoricalData	Z
      //   287: aload_1
      //   288: ifnull +179 -> 467
      //   291: goto +112 -> 403
      //   294: getstatic 134	android/support/v7/widget/ActivityChooserModel:LOG_TAG	Ljava/lang/String;
      //   297: astore 7
      //   299: new 136	java/lang/StringBuilder
      //   302: dup
      //   303: invokespecial 137	java/lang/StringBuilder:<init>	()V
      //   306: astore 7
      //   308: aload 7
      //   310: ldc -117
      //   312: invokevirtual 143	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   315: pop
      //   316: aload 7
      //   318: aload_0
      //   319: getfield 14	android/support/v7/widget/ActivityChooserModel$PersistHistoryAsyncTask:this$0	Landroid/support/v7/widget/ActivityChooserModel;
      //   322: getfield 146	android/support/v7/widget/ActivityChooserModel:mHistoryFileName	Ljava/lang/String;
      //   325: invokevirtual 143	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   328: pop
      //   329: aload 7
      //   331: invokevirtual 149	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   334: pop
      //   335: aload_0
      //   336: getfield 14	android/support/v7/widget/ActivityChooserModel$PersistHistoryAsyncTask:this$0	Landroid/support/v7/widget/ActivityChooserModel;
      //   339: iconst_1
      //   340: putfield 130	android/support/v7/widget/ActivityChooserModel:mCanReadHistoricalData	Z
      //   343: aload_1
      //   344: ifnull +123 -> 467
      //   347: goto +56 -> 403
      //   350: getstatic 134	android/support/v7/widget/ActivityChooserModel:LOG_TAG	Ljava/lang/String;
      //   353: astore 7
      //   355: new 136	java/lang/StringBuilder
      //   358: dup
      //   359: invokespecial 137	java/lang/StringBuilder:<init>	()V
      //   362: astore 7
      //   364: aload 7
      //   366: ldc -117
      //   368: invokevirtual 143	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   371: pop
      //   372: aload 7
      //   374: aload_0
      //   375: getfield 14	android/support/v7/widget/ActivityChooserModel$PersistHistoryAsyncTask:this$0	Landroid/support/v7/widget/ActivityChooserModel;
      //   378: getfield 146	android/support/v7/widget/ActivityChooserModel:mHistoryFileName	Ljava/lang/String;
      //   381: invokevirtual 143	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   384: pop
      //   385: aload 7
      //   387: invokevirtual 149	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   390: pop
      //   391: aload_0
      //   392: getfield 14	android/support/v7/widget/ActivityChooserModel$PersistHistoryAsyncTask:this$0	Landroid/support/v7/widget/ActivityChooserModel;
      //   395: iconst_1
      //   396: putfield 130	android/support/v7/widget/ActivityChooserModel:mCanReadHistoricalData	Z
      //   399: aload_1
      //   400: ifnull +67 -> 467
      //   403: aload_1
      //   404: invokevirtual 154	java/io/FileOutputStream:close	()V
      //   407: aconst_null
      //   408: areturn
      //   409: aload_0
      //   410: getfield 14	android/support/v7/widget/ActivityChooserModel$PersistHistoryAsyncTask:this$0	Landroid/support/v7/widget/ActivityChooserModel;
      //   413: iconst_1
      //   414: putfield 130	android/support/v7/widget/ActivityChooserModel:mCanReadHistoricalData	Z
      //   417: aload_1
      //   418: ifnull +7 -> 425
      //   421: aload_1
      //   422: invokevirtual 154	java/io/FileOutputStream:close	()V
      //   425: aload 7
      //   427: athrow
      //   428: getstatic 134	android/support/v7/widget/ActivityChooserModel:LOG_TAG	Ljava/lang/String;
      //   431: astore_1
      //   432: ldc -117
      //   434: aload 8
      //   436: invokestatic 160	f/sufficientlysecure/rootcommands/util/StringBuilder:get	(Ljava/lang/String;Ljava/lang/String;)V
      //   439: aconst_null
      //   440: areturn
      //   441: astore_1
      //   442: goto -14 -> 428
      //   445: astore 7
      //   447: goto -97 -> 350
      //   450: astore 7
      //   452: goto -158 -> 294
      //   455: astore 7
      //   457: goto -219 -> 238
      //   460: astore_1
      //   461: aconst_null
      //   462: areturn
      //   463: astore_1
      //   464: goto -39 -> 425
      //   467: aconst_null
      //   468: areturn
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	469	0	this	PersistHistoryAsyncTask
      //   0	469	1	paramVarArgs	Object[]
      //   166	7	2	f	float
      //   80	117	3	i	int
      //   77	8	4	j	int
      //   143	8	5	l	long
      //   6	82	7	localList	List
      //   233	1	7	localThrowable	Throwable
      //   241	185	7	localObject1	Object
      //   445	1	7	localIllegalArgumentException	IllegalArgumentException
      //   450	1	7	localIllegalStateException	IllegalStateException
      //   455	1	7	localIOException	java.io.IOException
      //   14	421	8	localObject2	Object
      //   95	67	9	localObject3	Object
      //   120	8	10	localComponentName	ComponentName
      // Exception table:
      //   from	to	target	type
      //   37	79	233	java/lang/Throwable
      //   87	97	233	java/lang/Throwable
      //   97	104	233	java/lang/Throwable
      //   104	115	233	java/lang/Throwable
      //   115	122	233	java/lang/Throwable
      //   122	138	233	java/lang/Throwable
      //   138	145	233	java/lang/Throwable
      //   145	161	233	java/lang/Throwable
      //   167	193	233	java/lang/Throwable
      //   200	218	233	java/lang/Throwable
      //   238	279	233	java/lang/Throwable
      //   294	335	233	java/lang/Throwable
      //   350	391	233	java/lang/Throwable
      //   24	32	441	java/io/FileNotFoundException
      //   37	79	445	java/lang/IllegalArgumentException
      //   87	97	445	java/lang/IllegalArgumentException
      //   104	115	445	java/lang/IllegalArgumentException
      //   122	138	445	java/lang/IllegalArgumentException
      //   145	161	445	java/lang/IllegalArgumentException
      //   167	193	445	java/lang/IllegalArgumentException
      //   200	218	445	java/lang/IllegalArgumentException
      //   37	79	450	java/lang/IllegalStateException
      //   87	97	450	java/lang/IllegalStateException
      //   104	115	450	java/lang/IllegalStateException
      //   122	138	450	java/lang/IllegalStateException
      //   145	161	450	java/lang/IllegalStateException
      //   167	193	450	java/lang/IllegalStateException
      //   200	218	450	java/lang/IllegalStateException
      //   37	79	455	java/io/IOException
      //   87	97	455	java/io/IOException
      //   104	115	455	java/io/IOException
      //   122	138	455	java/io/IOException
      //   145	161	455	java/io/IOException
      //   167	193	455	java/io/IOException
      //   200	218	455	java/io/IOException
      //   403	407	460	java/io/IOException
      //   421	425	463	java/io/IOException
    }
  }
}
