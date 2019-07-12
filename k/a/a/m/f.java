package k.a.a.m;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.preference.PreferenceManager;
import in.spicedigital.umang.application.MyApplication;

public class f
{
  public static String A;
  public static String ACTION_VIEW_STATES_KEY;
  public static String API_ADD_BY_FILE;
  public static String B;
  public static String C;
  public static String CLOUDINESS_UNIT;
  public static String CLOUDINESS_VALUE;
  public static String COMPONENT;
  public static String CURRENT_TEMP;
  public static String D;
  public static String DOUBLE;
  public static String E;
  public static String EVENTLOG_URL;
  public static String EXECUTABLE;
  public static String EXPANDED_ACTION_VIEW_ID;
  public static String F;
  public static String FALSE;
  public static String FLOAT;
  public static String GRABICON_URL;
  public static String H;
  public static String I;
  public static String INTEGER;
  public static String K;
  public static String LONG;
  public static String M;
  public static String NONE;
  public static String NULL;
  public static String OTHER;
  public static String P;
  public static String PRESENTER_KEY;
  public static String Q;
  public static String REQUIRES_EXTERNAL_AUTHENTICATION_EXTRA;
  public static String RPC_DOWNLOADEDEVER;
  public static String RPC_FILEPRIORITIES;
  public static String RPC_FILEPROGRESS;
  public static String RPC_MAXDOWNLOAD;
  public static String RPC_MAXUPLOAD;
  public static String RPC_METHOD_ADD;
  public static String RPC_METHOD_ADD_FILE;
  public static String RPC_METHOD_ADD_MAGNET;
  public static String RPC_METHOD_FORCERECHECK;
  public static String RPC_METHOD_SETFILE;
  public static String RPC_METHOD_SETLABEL;
  public static String RPC_METHOD_SETTRACKERS;
  public static String RPC_METHOD_STATUS;
  public static String RPC_TORRENTS;
  public static String RPC_TOTALPEERS;
  public static String RPC_TOTALSEEDS;
  public static String RPC_TRACKERS;
  public static String RPC_TRACKER_STATUS;
  public static String RSSFEED_EXTRA;
  public static String RSSFEED_NAME_EXTRA;
  public static String S;
  public static String TAG;
  public static String TIMEOUT;
  public static String TYPE;
  public static String V;
  public static String Value;
  public static String X;
  public static String a;
  public static String app;
  public static String b;
  public static String buttons;
  public static String c;
  public static String cellId;
  public static String classname;
  public static String clientFirstMessageBare;
  public static String code;
  public static String connection;
  public static String containerChildren;
  public static String content;
  public static String current;
  public static String cursor;
  public static String d;
  public static String data;
  public static String e;
  public static String ec;
  public static String elements;
  public static String f;
  public static String file;
  public static String g;
  public static String h;
  public static String header;
  public static String i;
  public static String id;
  public static String index;
  public static String j;
  public static String k;
  public static String key;
  public static String l;
  public static String leafChildren;
  public static String left;
  public static String line;
  public static String locale;
  public static String m;
  public static String mActionItems;
  public static String mCallback;
  public static String mContext;
  public static String mCurrent;
  public static String mCurrentMenuInfo;
  public static String mDefaultShowAsAction;
  public static String mExpandedItem;
  public static String mFrozenViewStates;
  public static String mHeaderIcon;
  public static String mId;
  public static String mIsActionItemsStale;
  public static String mIsClosing;
  public static String mIsVisibleItemsStale;
  public static String mItems;
  public static String mItemsChangedWhileDispatchPrevented;
  public static String mMode;
  public static String mName;
  public static String mNonActionItems;
  public static String mOptionalIconsVisible;
  public static String mOverrideVisibleItems;
  public static String mPresenters;
  public static String mPreventDispatchingItemsChanged;
  public static String mQwertyMode;
  public static String mResources;
  public static String mSeparator;
  public static String mShortcutsVisible;
  public static String mTag;
  public static String mTempShortcutItemList;
  public static String mTitle;
  public static String mVisibleItems;
  public static String m_ProgressBar;
  public static String mainActivity;
  public static String map;
  public static String method;
  public static String min;
  public static String n;
  public static String name;
  public static String o;
  public static String p;
  public static String parent;
  public static String playlist;
  public static String port;
  public static String position;
  public static String q;
  public static String queue;
  public static String r;
  public static String readCurs;
  public static String ref;
  public static String res;
  public static String right;
  public static String s;
  public static String sCategoryToOrder;
  public static String scriptText;
  public static String server;
  public static String sessionID;
  public static String start;
  public static String strVal1;
  public static String subject;
  public static String syncKey;
  public static String t;
  public static String tag;
  public static String text;
  public static String this$0;
  public static String time;
  public static String title;
  public static String top;
  public static String type;
  public static String u;
  public static String uid;
  public static String unknownObjectType;
  public static String uri;
  public static String url;
  public static String v;
  public static String val$data;
  public static String val$name;
  public static String value;
  public static String version;
  public static String view;
  public static String w;
  public static String width;
  public static String x;
  public static String xml;
  public static String y;
  public static String z;
  public Context context;
  public SharedPreferences preferences;
  
  public f(Context paramContext)
  {
    preferences = PreferenceManager.getDefaultSharedPreferences(paramContext);
    context = paramContext;
  }
  
  public void a()
  {
    String str1 = data;
    String str2;
    try
    {
      str1 = get(str1, "");
    }
    catch (Exception localException1)
    {
      StringBuilder.append(localException1);
      str2 = "";
    }
    String str4 = TYPE;
    String str5;
    try
    {
      str4 = get(str4, "");
    }
    catch (Exception localException4)
    {
      StringBuilder.append(localException4);
      str5 = "";
    }
    String str6 = width;
    Object localObject1 = context;
    String str7;
    try
    {
      str6 = get(str6, Log.getVersion((Context)localObject1));
    }
    catch (Exception localException5)
    {
      StringBuilder.append(localException5);
      str7 = "";
    }
    localObject1 = x;
    String str8;
    try
    {
      localObject1 = get((String)localObject1, "");
    }
    catch (Exception localException6)
    {
      StringBuilder.append(localException6);
      str8 = "";
    }
    String str9 = w;
    String str10;
    try
    {
      str9 = get(str9, "false");
    }
    catch (Exception localException7)
    {
      StringBuilder.append(localException7);
      str10 = "";
    }
    String str11 = C;
    String str12;
    try
    {
      str11 = get(str11, "https://web.umang.gov.in/uaw/tnc.html");
    }
    catch (Exception localException8)
    {
      StringBuilder.append(localException8);
      str12 = "";
    }
    String str13 = D;
    String str14;
    try
    {
      str13 = get(str13, "https://web.umang.gov.in/uaw/pvcp.html");
    }
    catch (Exception localException9)
    {
      StringBuilder.append(localException9);
      str14 = "";
    }
    String str15 = v;
    String str16;
    try
    {
      str15 = get(str15, "https://web.umang.gov.in/uaw/ops.html");
    }
    catch (Exception localException10)
    {
      StringBuilder.append(localException10);
      str16 = "";
    }
    String str17 = X;
    String str18;
    try
    {
      str17 = get(str17, "https://web.umang.gov.in/uaw/usrman.html");
    }
    catch (Exception localException11)
    {
      StringBuilder.append(localException11);
      str18 = "";
    }
    String str19 = y;
    String str20;
    try
    {
      str19 = get(str19, "https://web.umang.gov.in/uw/#/mobFaqsHome");
    }
    catch (Exception localException12)
    {
      StringBuilder.append(localException12);
      str20 = "";
    }
    String str21 = mCurrent;
    String str22;
    try
    {
      str21 = get(str21, "https://www.facebook.com/OfficialDigitalIndia/");
    }
    catch (Exception localException13)
    {
      StringBuilder.append(localException13);
      str22 = "";
    }
    String str23 = mId;
    String str24;
    try
    {
      str23 = get(str23, "https://plus.google.com/+MyNeGP");
    }
    catch (Exception localException14)
    {
      StringBuilder.append(localException14);
      str24 = "";
    }
    String str25 = P;
    String str26;
    try
    {
      str25 = get(str25, "https://twitter.com/_DigitalIndia");
    }
    catch (Exception localException15)
    {
      StringBuilder.append(localException15);
      str26 = "";
    }
    String str27 = c;
    String str28;
    try
    {
      str27 = get(str27, "en");
    }
    catch (Exception localException16)
    {
      StringBuilder.append(localException16);
      str28 = "";
    }
    String str29 = left;
    String str30;
    try
    {
      str29 = get(str29, "");
    }
    catch (Exception localException17)
    {
      StringBuilder.append(localException17);
      str30 = "";
    }
    String str31 = a;
    String str32;
    try
    {
      str31 = get(str31, "normal");
    }
    catch (Exception localException18)
    {
      StringBuilder.append(localException18);
      str32 = "";
    }
    String str33 = e;
    String str34;
    try
    {
      str33 = get(str33, "normal");
    }
    catch (Exception localException19)
    {
      StringBuilder.append(localException19);
      str34 = "";
    }
    String str35 = line;
    String str36;
    try
    {
      str35 = get(str35, "");
    }
    catch (Exception localException20)
    {
      StringBuilder.append(localException20);
      str36 = "";
    }
    String str37 = position;
    String str38;
    try
    {
      str37 = get(str37, "");
    }
    catch (Exception localException21)
    {
      StringBuilder.append(localException21);
      str38 = "";
    }
    String str39 = z;
    String str40;
    try
    {
      str39 = get(str39, "");
    }
    catch (Exception localException22)
    {
      StringBuilder.append(localException22);
      str40 = "";
    }
    String str41 = r;
    String str42;
    try
    {
      str41 = get(str41, "false");
    }
    catch (Exception localException23)
    {
      StringBuilder.append(localException23);
      str42 = "";
    }
    String str43 = i;
    String str44;
    try
    {
      str43 = get(str43, "");
    }
    catch (Exception localException24)
    {
      StringBuilder.append(localException24);
      str44 = "";
    }
    String str45 = K;
    String str46;
    try
    {
      str45 = get(str45, "");
    }
    catch (Exception localException25)
    {
      StringBuilder.append(localException25);
      str46 = "";
    }
    String str47 = I;
    String str48;
    try
    {
      str47 = get(str47, "");
    }
    catch (Exception localException26)
    {
      StringBuilder.append(localException26);
      str48 = "";
    }
    String str49 = M;
    String str50;
    try
    {
      str49 = get(str49, "");
    }
    catch (Exception localException27)
    {
      StringBuilder.append(localException27);
      str50 = "";
    }
    String str51 = t;
    String str52;
    try
    {
      str51 = get(str51, "");
    }
    catch (Exception localException28)
    {
      StringBuilder.append(localException28);
      str52 = "";
    }
    String str53 = time;
    String str54;
    try
    {
      str53 = get(str53, "");
    }
    catch (Exception localException29)
    {
      StringBuilder.append(localException29);
      str54 = "";
    }
    String str55 = type;
    String str56;
    try
    {
      str55 = get(str55, "");
    }
    catch (Exception localException30)
    {
      StringBuilder.append(localException30);
      str56 = "";
    }
    String str57 = classname;
    String str58;
    try
    {
      str57 = get(str57, "");
    }
    catch (Exception localException31)
    {
      StringBuilder.append(localException31);
      str58 = "";
    }
    String str59 = file;
    String str60;
    try
    {
      str59 = get(str59, "");
    }
    catch (Exception localException32)
    {
      StringBuilder.append(localException32);
      str60 = "";
    }
    String str61 = url;
    String str62;
    try
    {
      str61 = get(str61, "");
    }
    catch (Exception localException33)
    {
      StringBuilder.append(localException33);
      str62 = "";
    }
    String str63 = ref;
    String str64;
    try
    {
      str63 = get(str63, "");
    }
    catch (Exception localException34)
    {
      StringBuilder.append(localException34);
      str64 = "";
    }
    String str65 = value;
    String str66;
    try
    {
      str65 = get(str65, "");
    }
    catch (Exception localException35)
    {
      StringBuilder.append(localException35);
      str66 = "";
    }
    String str67 = min;
    String str68;
    try
    {
      str67 = get(str67, "");
    }
    catch (Exception localException36)
    {
      StringBuilder.append(localException36);
      str68 = "";
    }
    String str69 = B;
    String str70;
    try
    {
      str69 = get(str69, "");
    }
    catch (Exception localException37)
    {
      StringBuilder.append(localException37);
      str70 = "";
    }
    String str71 = res;
    String str72;
    try
    {
      str71 = get(str71, "");
    }
    catch (Exception localException38)
    {
      StringBuilder.append(localException38);
      str72 = "";
    }
    String str73 = current;
    String str74;
    try
    {
      str73 = get(str73, "");
    }
    catch (Exception localException39)
    {
      StringBuilder.append(localException39);
      str74 = "";
    }
    String str75 = header;
    String str76;
    try
    {
      str75 = get(str75, "");
    }
    catch (Exception localException40)
    {
      StringBuilder.append(localException40);
      str76 = "";
    }
    String str77 = INTEGER;
    String str78;
    try
    {
      str77 = add(str77, "");
    }
    catch (Exception localException41)
    {
      StringBuilder.append(localException41);
      str78 = "";
    }
    String str79 = LONG;
    String str80;
    try
    {
      str79 = add(str79, "");
    }
    catch (Exception localException42)
    {
      StringBuilder.append(localException42);
      str80 = "";
    }
    String str81 = Q;
    String str82;
    try
    {
      str81 = add(str81, "");
    }
    catch (Exception localException43)
    {
      StringBuilder.append(localException43);
      str82 = "";
    }
    String str83 = H;
    String str84;
    try
    {
      str83 = add(str83, "");
    }
    catch (Exception localException44)
    {
      StringBuilder.append(localException44);
      str84 = "";
    }
    String str85 = E;
    String str86;
    try
    {
      str85 = add(str85, "");
    }
    catch (Exception localException45)
    {
      StringBuilder.append(localException45);
      str86 = "";
    }
    String str87 = F;
    String str88;
    try
    {
      str87 = add(str87, "");
    }
    catch (Exception localException46)
    {
      StringBuilder.append(localException46);
      str88 = "";
    }
    String str89 = V;
    String str90;
    try
    {
      str89 = add(str89, "");
    }
    catch (Exception localException47)
    {
      StringBuilder.append(localException47);
      str90 = "";
    }
    String str91 = l;
    String str92;
    try
    {
      str91 = add(str91, "");
    }
    catch (Exception localException48)
    {
      StringBuilder.append(localException48);
      str92 = "";
    }
    String str93 = FLOAT;
    String str94;
    try
    {
      str93 = add(str93, "");
    }
    catch (Exception localException49)
    {
      StringBuilder.append(localException49);
      str94 = "";
    }
    String str95 = DOUBLE;
    String str96;
    try
    {
      str95 = add(str95, "");
    }
    catch (Exception localException50)
    {
      StringBuilder.append(localException50);
      str96 = "";
    }
    String str97 = NULL;
    String str98;
    try
    {
      str97 = add(str97, "");
    }
    catch (Exception localException51)
    {
      StringBuilder.append(localException51);
      str98 = "";
    }
    Object localObject2 = preferences.edit();
    ((SharedPreferences.Editor)localObject2).clear();
    ((SharedPreferences.Editor)localObject2).commit();
    try
    {
      boolean bool = str2.equalsIgnoreCase("");
      if (!bool)
      {
        localObject2 = data;
        append((String)localObject2, str2);
      }
    }
    catch (Exception localException2)
    {
      StringBuilder.append(localException2);
    }
    String str3 = TYPE;
    try
    {
      append(str3, str5);
      str3 = width;
      append(str3, str7);
      str3 = x;
      append(str3, str8);
      str3 = w;
      append(str3, str10);
      str3 = C;
      append(str3, str12);
      str3 = D;
      append(str3, str14);
      str3 = v;
      append(str3, str16);
      str3 = X;
      append(str3, str18);
      str3 = y;
      append(str3, str20);
      str3 = mCurrent;
      append(str3, str22);
      str3 = mId;
      append(str3, str24);
      str3 = P;
      append(str3, str26);
      str3 = c;
      append(str3, str28);
      str3 = left;
      append(str3, str30);
      str3 = a;
      append(str3, str32);
      str3 = e;
      append(str3, str34);
      str3 = line;
      append(str3, str36);
      str3 = position;
      append(str3, str38);
      str3 = z;
      append(str3, str40);
      str3 = r;
      append(str3, str42);
      str3 = i;
      append(str3, str44);
      str3 = K;
      append(str3, str46);
      str3 = I;
      append(str3, str48);
      str3 = M;
      append(str3, str50);
      str3 = t;
      append(str3, str52);
      str3 = time;
      append(str3, str54);
      str3 = type;
      append(str3, str56);
      str3 = classname;
      append(str3, str58);
      str3 = file;
      append(str3, str60);
      str3 = url;
      append(str3, str62);
      str3 = ref;
      append(str3, str64);
      str3 = value;
      append(str3, str66);
      str3 = min;
      append(str3, str68);
      str3 = B;
      append(str3, str70);
      str3 = res;
      append(str3, str72);
      str3 = current;
      append(str3, str74);
      str3 = header;
      append(str3, str76);
      str3 = INTEGER;
      put(str3, str78);
      str3 = LONG;
      put(str3, str80);
      str3 = Q;
      put(str3, str82);
      str3 = H;
      put(str3, str84);
      str3 = E;
      put(str3, str86);
      str3 = F;
      put(str3, str88);
      str3 = V;
      put(str3, str90);
      str3 = l;
      put(str3, str92);
      str3 = FLOAT;
      put(str3, str94);
      str3 = DOUBLE;
      put(str3, str96);
      str3 = NULL;
      put(str3, str98);
      return;
    }
    catch (Exception localException3)
    {
      StringBuilder.append(localException3);
    }
  }
  
  public String add(String paramString1, String paramString2)
  {
    return preferences.getString(paramString1, paramString2);
  }
  
  public void append(String paramString1, String paramString2)
  {
    Object localObject = MyApplication.s;
    try
    {
      boolean bool = ((String)localObject).equalsIgnoreCase("");
      if (!bool)
      {
        localObject = name;
        bool = paramString1.equalsIgnoreCase((String)localObject);
        if (!bool)
        {
          localObject = mName;
          bool = paramString1.equalsIgnoreCase((String)localObject);
          if (!bool)
          {
            localObject = code;
            bool = paramString1.equalsIgnoreCase((String)localObject);
            if (!bool)
            {
              localObject = connection;
              bool = paramString1.equalsIgnoreCase((String)localObject);
              if (!bool)
              {
                localObject = method;
                bool = paramString1.equalsIgnoreCase((String)localObject);
                if (!bool)
                {
                  localObject = context;
                  paramString2 = new d((Context)localObject).a(paramString2);
                  localObject = preferences;
                  localObject = ((SharedPreferences)localObject).edit();
                  ((SharedPreferences.Editor)localObject).putString(paramString1, paramString2);
                  ((SharedPreferences.Editor)localObject).commit();
                  return;
                }
              }
            }
          }
        }
        localObject = context;
        localObject = new ClassWriter((Context)localObject);
        String str1 = this$0;
        String str2 = MyApplication.a;
        paramString2 = ((ClassWriter)localObject).init(paramString2, get(str1, str2.toString()));
        localObject = preferences;
        localObject = ((SharedPreferences)localObject).edit();
        ((SharedPreferences.Editor)localObject).putString(paramString1, paramString2);
        ((SharedPreferences.Editor)localObject).commit();
        return;
      }
    }
    catch (Exception paramString1)
    {
      StringBuilder.append(paramString1);
    }
  }
  
  public void clear(String paramString)
  {
    Object localObject = preferences;
    try
    {
      localObject = ((SharedPreferences)localObject).edit();
      ((SharedPreferences.Editor)localObject).remove(paramString);
      ((SharedPreferences.Editor)localObject).commit();
      return;
    }
    catch (Exception paramString)
    {
      StringBuilder.append(paramString);
    }
  }
  
  public void clear(String paramString, int paramInt)
  {
    SharedPreferences.Editor localEditor = preferences.edit();
    localEditor.putInt(paramString, paramInt);
    localEditor.commit();
  }
  
  public String get(String paramString1, String paramString2)
  {
    String str1 = preferences.getString(paramString1, paramString2);
    if (str1.equalsIgnoreCase(paramString2)) {
      return paramString2;
    }
    String str2 = MyApplication.s;
    try
    {
      boolean bool = str2.equalsIgnoreCase("");
      if (!bool)
      {
        str2 = name;
        bool = paramString1.equalsIgnoreCase(str2);
        if (!bool)
        {
          str2 = mName;
          bool = paramString1.equalsIgnoreCase(str2);
          if (!bool)
          {
            str2 = code;
            bool = paramString1.equalsIgnoreCase(str2);
            if (!bool)
            {
              str2 = connection;
              bool = paramString1.equalsIgnoreCase(str2);
              if (!bool)
              {
                str2 = method;
                bool = paramString1.equalsIgnoreCase(str2);
                if (!bool)
                {
                  paramString1 = context;
                  paramString1 = new d(paramString1).init(str1);
                  if (paramString1 != null) {
                    return paramString1;
                  }
                  return paramString2;
                }
              }
            }
          }
        }
        paramString1 = context;
        paramString1 = new ClassWriter(paramString1);
        str2 = this$0;
        String str3 = MyApplication.a;
        paramString1 = paramString1.a(str1, get(str2, str3.toString()));
        if (paramString1 != null) {
          return paramString1;
        }
      }
      else
      {
        return paramString2;
      }
    }
    catch (Exception paramString1)
    {
      StringBuilder.append(paramString1);
    }
    return paramString2;
  }
  
  public int getItem(String paramString, int paramInt)
  {
    return preferences.getInt(paramString, paramInt);
  }
  
  public void put(String paramString1, String paramString2)
  {
    SharedPreferences.Editor localEditor = preferences.edit();
    localEditor.putString(paramString1, paramString2);
    localEditor.commit();
  }
}
