package k.a.a.e;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteClosable;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import k.a.a.c.A;
import k.a.a.c.C;
import k.a.a.c.Log;
import k.a.a.c.M;
import k.a.a.c.N;
import k.a.a.c.O;
import k.a.a.c.S;
import k.a.a.c.U;
import k.a.a.c.d;
import k.a.a.c.z;

public class System
  extends SQLiteOpenHelper
{
  public static String $assertionsDisabled;
  public static String A;
  public static String ADD;
  public static String B;
  public static String C;
  public static String CENTER;
  public static String CONTENT_URI;
  public static String DEBUG;
  public static String DOMAIN;
  public static String FALSE;
  public static String G;
  public static String H;
  public static int HTTP_PROXY_PORT = 0;
  public static String I;
  public static String INSTANCE;
  public static String LOG;
  public static String LOGGER;
  public static String LOG_TAG;
  public static String M;
  public static String NONE;
  public static String NULL;
  public static String P;
  public static String Q;
  public static String ROOT;
  public static String S;
  public static String START;
  public static String TAG;
  public static String TYPE;
  public static String URI;
  public static String URL;
  public static String X;
  public static String a;
  public static String activity;
  public static String adapter;
  public static String app;
  public static String args;
  public static String arretId;
  public static String authors;
  public static String b;
  public static String board;
  public static String buf;
  public static String c;
  public static String cache;
  public static String command;
  public static String comment;
  public static String connection;
  public static String content;
  public static String contentType;
  public static String context;
  public static String count;
  public static String country;
  public static String current;
  public static String cursor;
  public static String d;
  public static String data;
  public static String date;
  public static String db;
  public static String delegate;
  public static String description;
  public static String directory;
  public static String e;
  public static String element;
  public static String file;
  public static String filePath;
  public static String filename;
  public static String filter;
  public static String first;
  public static String format;
  public static String from;
  public static String g;
  public static String geocode;
  public static String h;
  public static String handler;
  public static String hash;
  public static String header;
  public static String helper;
  public static String host;
  public static String hour;
  public static String i;
  public static String id;
  public static String image;
  public static String index;
  public static String input;
  public static System instance;
  public static String j;
  public static String key;
  public static String l;
  public static String lang;
  public static String language;
  public static String latitude;
  public static String left;
  public static String length;
  public static String level;
  public static String ligneId;
  public static String line;
  public static String lock;
  public static String log;
  public static String logger;
  public static String login;
  public static String longitude;
  public static String m;
  public static String mContext;
  public static final String mLastError = "UMANG_DB";
  public static String mName;
  public static String mUri;
  public static String map;
  public static String max;
  public static String message;
  public static String mimeType;
  public static String min;
  public static String minute;
  public static String mode;
  public static String n;
  public static String name;
  public static String names;
  public static String next;
  public static String offset;
  public static String out;
  public static String p;
  public static String packageName;
  public static String params;
  public static String parent;
  public static String path;
  public static String payload;
  public static String phoneNumber;
  public static String pointer;
  public static String port;
  public static String pos;
  public static String position;
  public static String q;
  public static String query;
  public static String queue;
  public static String r;
  public static String realm;
  public static String res;
  public static String root;
  public static String s;
  public static String score;
  public static String separator;
  public static String server;
  public static String size;
  public static String source;
  public static String sql;
  public static String start;
  public static String state;
  public static String status;
  public static String t;
  public static String table;
  public static String tag;
  public static String text;
  public static String this$1;
  public static String thread;
  public static String time;
  public static String title;
  public static String to;
  public static String token;
  public static String top;
  public static String type;
  public static String uri;
  public static String url;
  public static String user;
  public static String username;
  public static String value;
  public static String values;
  public static String version;
  public static String view;
  public static String w;
  public static String width;
  public static String x;
  public static String y;
  public final Context ctx;
  public int currentIndex;
  public final String icon = "DatabaseManager";
  public SQLiteDatabase this$0;
  
  public System(Context paramContext)
  {
    super(paramContext, "UMANG_DB", null, HTTP_PROXY_PORT);
    ctx = paramContext;
  }
  
  public static System getInstance(Context paramContext)
  {
    try
    {
      if (instance == null) {
        instance = new System(paramContext);
      }
      paramContext = instance;
      return paramContext;
    }
    catch (Throwable paramContext)
    {
      throw paramContext;
    }
  }
  
  public ArrayList a()
    throws SQLException
  {
    try
    {
      ArrayList localArrayList = new ArrayList();
      get();
      Object localObject1 = this$0;
      Object localObject2 = i;
      String str1 = NULL;
      String str2 = mode;
      String str3 = filePath;
      String str4 = mimeType;
      String str5 = header;
      String str6 = command;
      String str7 = version;
      String str8 = description;
      String str9 = score;
      String str10 = lang;
      String str11 = geocode;
      String str12 = ligneId;
      String str13 = arretId;
      try
      {
        localObject1 = ((SQLiteDatabase)localObject1).query((String)localObject2, new String[] { str1, str2, str3, str4, str5, str6, str7, str8, str9, str10, str11, str12, str13 }, null, null, null, null, null);
        if (localObject1 != null)
        {
          boolean bool = ((Cursor)localObject1).moveToFirst();
          if (bool) {
            for (;;)
            {
              localObject2 = new U();
              ((U)localObject2).f(((Cursor)localObject1).getString(0));
              ((U)localObject2).a(((Cursor)localObject1).getString(1));
              ((U)localObject2).b(((Cursor)localObject1).getString(2));
              ((U)localObject2).e(((Cursor)localObject1).getString(3));
              ((U)localObject2).m(((Cursor)localObject1).getString(4));
              ((U)localObject2).k(((Cursor)localObject1).getString(5));
              ((U)localObject2).d(((Cursor)localObject1).getString(6));
              ((U)localObject2).l(((Cursor)localObject1).getString(7));
              ((U)localObject2).i(((Cursor)localObject1).getString(8));
              ((U)localObject2).j(((Cursor)localObject1).getString(9));
              ((U)localObject2).c(((Cursor)localObject1).getString(10));
              ((U)localObject2).n(((Cursor)localObject1).getString(11));
              ((U)localObject2).g(((Cursor)localObject1).getString(12));
              localArrayList.add(localObject2);
              bool = ((Cursor)localObject1).moveToNext();
              if (!bool) {
                break;
              }
            }
          }
          ((Cursor)localObject1).close();
        }
      }
      catch (Exception localException)
      {
        k.a.a.m.StringBuilder.append(localException);
      }
      append();
      return localArrayList;
    }
    catch (Throwable localThrowable)
    {
      throw localThrowable;
    }
  }
  
  public ArrayList a(String paramString)
    throws SQLException
  {
    try
    {
      ArrayList localArrayList = new ArrayList();
      get();
      Object localObject1 = this$0;
      Object localObject2 = r;
      String str1 = w;
      String str2 = m;
      String str3 = Q;
      String str4 = H;
      String str5 = n;
      String str6 = S;
      String str7 = G;
      String str8 = P;
      String str9 = TYPE;
      String str10 = c;
      String str11 = d;
      String str12 = DOMAIN;
      String str13 = B;
      String str14 = X;
      String str15 = M;
      String str16 = A;
      String str17 = C;
      String str18 = t;
      String str19 = x;
      String str20 = I;
      String str21 = width;
      try
      {
        Object localObject3 = new StringBuilder();
        String str22 = x;
        ((StringBuilder)localObject3).append(str22);
        ((StringBuilder)localObject3).append("=\"");
        ((StringBuilder)localObject3).append(paramString);
        ((StringBuilder)localObject3).append("\"");
        paramString = ((StringBuilder)localObject3).toString();
        localObject3 = new StringBuilder();
        str22 = d;
        ((StringBuilder)localObject3).append(str22);
        ((StringBuilder)localObject3).append(" DESC");
        localObject3 = ((StringBuilder)localObject3).toString();
        localObject1 = ((SQLiteDatabase)localObject1).query((String)localObject2, new String[] { str1, str2, str3, str4, str5, str6, str7, str8, str9, str10, str11, str12, str13, str14, str15, str16, str17, str18, str19, str20, str21 }, paramString, null, null, null, (String)localObject3);
        if (localObject1 != null)
        {
          boolean bool = ((Cursor)localObject1).moveToFirst();
          if (bool) {
            for (;;)
            {
              localObject2 = new C();
              paramString = ((Cursor)localObject1).getString(0);
              if (paramString == null) {
                paramString = "";
              } else {
                paramString = ((Cursor)localObject1).getString(0);
              }
              ((C)localObject2).h(paramString);
              paramString = ((Cursor)localObject1).getString(1);
              if (paramString == null) {
                paramString = "";
              } else {
                paramString = ((Cursor)localObject1).getString(1);
              }
              ((C)localObject2).p(paramString);
              paramString = ((Cursor)localObject1).getString(2);
              if (paramString == null) {
                paramString = "";
              } else {
                paramString = ((Cursor)localObject1).getString(2);
              }
              ((C)localObject2).e(paramString);
              paramString = ((Cursor)localObject1).getString(3);
              if (paramString == null) {
                paramString = "";
              } else {
                paramString = ((Cursor)localObject1).getString(3);
              }
              ((C)localObject2).g(paramString);
              paramString = ((Cursor)localObject1).getString(4);
              if (paramString == null) {
                paramString = "";
              } else {
                paramString = ((Cursor)localObject1).getString(4);
              }
              ((C)localObject2).q(paramString);
              paramString = ((Cursor)localObject1).getString(5);
              if (paramString == null) {
                paramString = "";
              } else {
                paramString = ((Cursor)localObject1).getString(5);
              }
              ((C)localObject2).b(paramString);
              paramString = ((Cursor)localObject1).getString(6);
              if (paramString == null) {
                paramString = "";
              } else {
                paramString = ((Cursor)localObject1).getString(6);
              }
              ((C)localObject2).o(paramString);
              paramString = ((Cursor)localObject1).getString(7);
              if (paramString == null) {
                paramString = "";
              } else {
                paramString = ((Cursor)localObject1).getString(7);
              }
              ((C)localObject2).m(paramString);
              ((C)localObject2).a(Boolean.parseBoolean(((Cursor)localObject1).getString(8)));
              paramString = ((Cursor)localObject1).getString(9);
              if (paramString == null) {
                paramString = "";
              } else {
                paramString = ((Cursor)localObject1).getString(9);
              }
              ((C)localObject2).k(paramString);
              paramString = ((Cursor)localObject1).getString(10);
              if (paramString == null) {
                paramString = "";
              } else {
                paramString = ((Cursor)localObject1).getString(10);
              }
              ((C)localObject2).a(paramString);
              paramString = ((Cursor)localObject1).getString(11);
              if (paramString == null) {
                paramString = "";
              } else {
                paramString = ((Cursor)localObject1).getString(11);
              }
              ((C)localObject2).n(paramString);
              paramString = ((Cursor)localObject1).getString(12);
              if (paramString == null) {
                paramString = "";
              } else {
                paramString = ((Cursor)localObject1).getString(12);
              }
              ((C)localObject2).r(paramString);
              paramString = ((Cursor)localObject1).getString(13);
              if (paramString == null) {
                paramString = "";
              } else {
                paramString = ((Cursor)localObject1).getString(13);
              }
              ((C)localObject2).j(paramString);
              paramString = ((Cursor)localObject1).getString(14);
              if (paramString == null) {
                paramString = "";
              } else {
                paramString = ((Cursor)localObject1).getString(14);
              }
              ((C)localObject2).i(paramString);
              paramString = ((Cursor)localObject1).getString(15);
              if (paramString == null) {
                paramString = "";
              } else {
                paramString = ((Cursor)localObject1).getString(15);
              }
              ((C)localObject2).d(paramString);
              paramString = ((Cursor)localObject1).getString(16);
              if (paramString == null) {
                paramString = "";
              } else {
                paramString = ((Cursor)localObject1).getString(16);
              }
              ((C)localObject2).t(paramString);
              paramString = ((Cursor)localObject1).getString(17);
              if (paramString == null) {
                paramString = "";
              } else {
                paramString = ((Cursor)localObject1).getString(17);
              }
              ((C)localObject2).f(paramString);
              paramString = ((Cursor)localObject1).getString(18);
              if (paramString == null) {
                paramString = "";
              } else {
                paramString = ((Cursor)localObject1).getString(18);
              }
              ((C)localObject2).s(paramString);
              paramString = ((Cursor)localObject1).getString(19);
              if (paramString == null) {
                paramString = "";
              } else {
                paramString = ((Cursor)localObject1).getString(19);
              }
              ((C)localObject2).c(paramString);
              paramString = ((Cursor)localObject1).getString(20);
              if (paramString == null) {
                paramString = "";
              } else {
                paramString = ((Cursor)localObject1).getString(20);
              }
              ((C)localObject2).l(paramString);
              ((C)localObject2).b(false);
              localArrayList.add(localObject2);
              paramString = new StringBuilder();
              paramString.append("notifid : ");
              paramString.append(((Cursor)localObject1).getString(0));
              paramString.toString();
              paramString = new StringBuilder();
              paramString.append("isfav : ");
              paramString.append(((Cursor)localObject1).getString(8));
              paramString.toString();
              bool = ((Cursor)localObject1).moveToNext();
              if (!bool) {
                break;
              }
            }
          }
          ((Cursor)localObject1).close();
        }
      }
      catch (Exception paramString)
      {
        k.a.a.m.StringBuilder.append(paramString);
      }
      append();
      return localArrayList;
    }
    catch (Throwable paramString)
    {
      throw paramString;
    }
  }
  
  public ArrayList a(String paramString1, String paramString2)
    throws SQLException
  {
    try
    {
      ArrayList localArrayList = new ArrayList();
      get();
      SQLiteDatabase localSQLiteDatabase = this$0;
      String str1 = p;
      String str2 = q;
      String str3 = s;
      String str4 = e;
      String str5 = port;
      String str6 = realm;
      String str7 = query;
      String str8 = h;
      String str9 = board;
      String str10 = start;
      String str11 = server;
      String str12 = to;
      String str13 = from;
      String str14 = time;
      String str15 = thread;
      String str16 = host;
      String str17 = packageName;
      String str18 = image;
      String str19 = CENTER;
      try
      {
        StringBuilder localStringBuilder = new StringBuilder();
        String str20 = x;
        localStringBuilder.append(str20);
        localStringBuilder.append("=\"");
        localStringBuilder.append(paramString1);
        localStringBuilder.append("\" AND ");
        paramString1 = q;
        localStringBuilder.append(paramString1);
        localStringBuilder.append("=\"");
        localStringBuilder.append(paramString2);
        localStringBuilder.append("\"");
        paramString1 = localStringBuilder.toString();
        paramString1 = localSQLiteDatabase.query(str1, new String[] { str2, str3, str4, str5, str6, str7, str8, str9, str10, str11, str12, str13, str14, str15, str16, str17, str18, str19 }, paramString1, null, null, null, null);
        if (paramString1 != null)
        {
          boolean bool = paramString1.moveToFirst();
          if (bool) {
            for (;;)
            {
              paramString2 = new k.a.a.c.f();
              paramString2.c(paramString1.getString(0));
              paramString2.b(paramString1.getString(1));
              paramString2.d(paramString1.getString(2));
              paramString2.e(paramString1.getString(3));
              paramString2.f(paramString1.getString(4));
              paramString2.g(paramString1.getString(5));
              paramString2.o(paramString1.getString(6));
              paramString2.j(paramString1.getString(7));
              paramString2.m(paramString1.getString(8));
              paramString2.r(paramString1.getString(9));
              paramString2.p(paramString1.getString(10));
              paramString2.k(paramString1.getString(11));
              paramString2.i(paramString1.getString(12));
              paramString2.l(paramString1.getString(13));
              paramString2.n(paramString1.getString(14));
              paramString2.q(paramString1.getString(15));
              paramString2.a(paramString1.getString(16));
              paramString2.h(paramString1.getString(17));
              localArrayList.add(paramString2);
              bool = paramString1.moveToNext();
              if (!bool) {
                break;
              }
            }
          }
          paramString1.close();
        }
      }
      catch (Exception paramString1)
      {
        k.a.a.m.StringBuilder.append(paramString1);
      }
      append();
      return localArrayList;
    }
    catch (Throwable paramString1)
    {
      throw paramString1;
    }
  }
  
  public ArrayList a(String paramString1, ArrayList paramArrayList1, ArrayList paramArrayList2, String paramString2, String paramString3, String paramString4)
    throws SQLException
  {
    try
    {
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append("select * from ");
      ((StringBuilder)localObject).append(r);
      ((StringBuilder)localObject).append(" where ");
      String str = ((StringBuilder)localObject).toString();
      localObject = str;
      if (paramString1.equalsIgnoreCase("promo"))
      {
        paramString1 = new StringBuilder();
        paramString1.append(str);
        paramString1.append(n);
        paramString1.append(" = 'promo'");
        localObject = paramString1.toString();
      }
      else if (paramString1.equalsIgnoreCase("trans"))
      {
        paramString1 = new StringBuilder();
        paramString1.append(str);
        paramString1.append(n);
        paramString1.append(" = 'trans'");
        localObject = paramString1.toString();
      }
      else if (paramString1.equalsIgnoreCase("fav"))
      {
        paramString1 = new StringBuilder();
        paramString1.append(str);
        paramString1.append(TYPE);
        paramString1.append(" = 'true'");
        localObject = paramString1.toString();
      }
      if (!((String)localObject).contains(n))
      {
        paramString1 = (String)localObject;
        if (!((String)localObject).contains(TYPE)) {}
      }
      else
      {
        paramString1 = (String)localObject;
        if (paramArrayList1.size() > 0)
        {
          paramString1 = new StringBuilder();
          paramString1.append((String)localObject);
          paramString1.append(" AND ");
          paramString1 = paramString1.toString();
        }
      }
      localObject = paramString1;
      if (paramArrayList1.size() > 0)
      {
        paramArrayList1 = paramArrayList1.toString().replace("[", "(").replace("]", ")");
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append(paramString1);
        ((StringBuilder)localObject).append(c);
        ((StringBuilder)localObject).append(" IN ");
        ((StringBuilder)localObject).append(paramArrayList1);
        localObject = ((StringBuilder)localObject).toString();
      }
      if ((!((String)localObject).contains(n)) && (!((String)localObject).contains(TYPE)))
      {
        paramArrayList1 = (ArrayList)localObject;
        if (!((String)localObject).contains(c)) {}
      }
      else
      {
        paramArrayList1 = (ArrayList)localObject;
        if (paramArrayList2.size() > 0)
        {
          paramString1 = new StringBuilder();
          paramString1.append((String)localObject);
          paramString1.append(" AND ");
          paramArrayList1 = paramString1.toString();
        }
      }
      paramString1 = paramArrayList1;
      if (paramArrayList2.size() > 0) {
        if (!paramArrayList2.contains("-1"))
        {
          paramString1 = paramArrayList2.toString().replace("[", "(").replace("]", ")");
          paramArrayList2 = new StringBuilder();
          paramArrayList2.append(paramArrayList1);
          paramArrayList2.append(P);
          paramArrayList2.append(" IN ");
          paramArrayList2.append(paramString1);
          paramString1 = paramArrayList2.toString();
        }
        else
        {
          paramString1 = paramArrayList2.toString().replace("[", "(").replace("]", ")");
          paramArrayList2 = new StringBuilder();
          paramArrayList2.append(paramArrayList1);
          paramArrayList2.append(P);
          paramArrayList2.append(" NOT IN ");
          paramArrayList2.append(paramString1);
          paramString1 = paramArrayList2.toString();
        }
      }
      if ((!paramString1.contains(n)) && (!paramString1.contains(TYPE)) && (!paramString1.contains(c)))
      {
        paramArrayList1 = paramString1;
        if (!paramString1.contains(P)) {}
      }
      else
      {
        paramArrayList1 = new StringBuilder();
        paramArrayList1.append(paramString1);
        paramArrayList1.append(" AND ");
        paramArrayList1 = paramArrayList1.toString();
      }
      paramString1 = new StringBuilder();
      paramString1.append(paramArrayList1);
      paramString1.append(M);
      paramString1.append(" >= Datetime('");
      paramString1.append(paramString2);
      paramString1.append("') AND ");
      paramString1.append(M);
      paramString1.append(" <= Datetime('");
      paramString1.append(paramString3);
      paramString1.append("')");
      paramString1 = paramString1.toString();
      paramArrayList1 = new StringBuilder();
      paramArrayList1.append(paramString1);
      paramArrayList1.append(" AND ");
      paramArrayList1.append(x);
      paramArrayList1.append(" = '");
      paramArrayList1.append(paramString4);
      paramArrayList1.append("';");
      paramString1 = paramArrayList1.toString();
      paramArrayList1 = new StringBuilder();
      paramArrayList1.append("query........");
      paramArrayList1.append(paramString1);
      paramArrayList1.toString();
      paramArrayList1 = new ArrayList();
      get();
      paramArrayList2 = this$0;
      try
      {
        paramArrayList2 = paramArrayList2.rawQuery(paramString1, null);
        if (paramArrayList2 != null)
        {
          boolean bool = paramArrayList2.moveToFirst();
          if (bool) {
            do
            {
              paramString2 = new C();
              paramString1 = paramArrayList2.getString(1);
              if (paramString1 == null) {
                paramString1 = "";
              } else {
                paramString1 = paramArrayList2.getString(1);
              }
              paramString2.h(paramString1);
              paramString1 = paramArrayList2.getString(2);
              if (paramString1 == null) {
                paramString1 = "";
              } else {
                paramString1 = paramArrayList2.getString(2);
              }
              paramString2.p(paramString1);
              paramString1 = paramArrayList2.getString(3);
              if (paramString1 == null) {
                paramString1 = "";
              } else {
                paramString1 = paramArrayList2.getString(3);
              }
              paramString2.e(paramString1);
              paramString1 = paramArrayList2.getString(4);
              if (paramString1 == null) {
                paramString1 = "";
              } else {
                paramString1 = paramArrayList2.getString(4);
              }
              paramString2.g(paramString1);
              paramString1 = paramArrayList2.getString(5);
              if (paramString1 == null) {
                paramString1 = "";
              } else {
                paramString1 = paramArrayList2.getString(5);
              }
              paramString2.q(paramString1);
              paramString1 = paramArrayList2.getString(6);
              if (paramString1 == null) {
                paramString1 = "";
              } else {
                paramString1 = paramArrayList2.getString(6);
              }
              paramString2.b(paramString1);
              paramString1 = paramArrayList2.getString(7);
              if (paramString1 == null) {
                paramString1 = "";
              } else {
                paramString1 = paramArrayList2.getString(7);
              }
              paramString2.o(paramString1);
              paramString1 = paramArrayList2.getString(8);
              if (paramString1 == null) {
                paramString1 = "";
              } else {
                paramString1 = paramArrayList2.getString(8);
              }
              paramString2.m(paramString1);
              paramString2.a(Boolean.parseBoolean(paramArrayList2.getString(9)));
              paramString1 = paramArrayList2.getString(10);
              if (paramString1 == null) {
                paramString1 = "";
              } else {
                paramString1 = paramArrayList2.getString(10);
              }
              paramString2.k(paramString1);
              paramString1 = paramArrayList2.getString(11);
              if (paramString1 == null) {
                paramString1 = "";
              } else {
                paramString1 = paramArrayList2.getString(11);
              }
              paramString2.a(paramString1);
              paramString1 = paramArrayList2.getString(12);
              if (paramString1 == null) {
                paramString1 = "";
              } else {
                paramString1 = paramArrayList2.getString(12);
              }
              paramString2.n(paramString1);
              paramString1 = paramArrayList2.getString(13);
              if (paramString1 == null) {
                paramString1 = "";
              } else {
                paramString1 = paramArrayList2.getString(13);
              }
              paramString2.r(paramString1);
              paramString1 = paramArrayList2.getString(14);
              if (paramString1 == null) {
                paramString1 = "";
              } else {
                paramString1 = paramArrayList2.getString(14);
              }
              paramString2.j(paramString1);
              paramString1 = paramArrayList2.getString(15);
              if (paramString1 == null) {
                paramString1 = "";
              } else {
                paramString1 = paramArrayList2.getString(15);
              }
              paramString2.i(paramString1);
              paramString1 = paramArrayList2.getString(16);
              if (paramString1 == null) {
                paramString1 = "";
              } else {
                paramString1 = paramArrayList2.getString(16);
              }
              paramString2.d(paramString1);
              paramString1 = paramArrayList2.getString(17);
              if (paramString1 == null) {
                paramString1 = "";
              } else {
                paramString1 = paramArrayList2.getString(17);
              }
              paramString2.t(paramString1);
              paramString1 = paramArrayList2.getString(18);
              if (paramString1 == null) {
                paramString1 = "";
              } else {
                paramString1 = paramArrayList2.getString(18);
              }
              paramString2.f(paramString1);
              paramString1 = paramArrayList2.getString(19);
              if (paramString1 == null) {
                paramString1 = "";
              } else {
                paramString1 = paramArrayList2.getString(19);
              }
              paramString2.s(paramString1);
              paramString1 = paramArrayList2.getString(20);
              if (paramString1 == null) {
                paramString1 = "";
              } else {
                paramString1 = paramArrayList2.getString(20);
              }
              paramString2.c(paramString1);
              paramString1 = paramArrayList2.getString(21);
              if (paramString1 == null) {
                paramString1 = "";
              } else {
                paramString1 = paramArrayList2.getString(21);
              }
              paramString2.l(paramString1);
              paramString2.b(false);
              paramArrayList1.add(paramString2);
              bool = paramArrayList2.moveToNext();
            } while (bool);
          }
          paramArrayList2.close();
        }
      }
      catch (Exception paramString1)
      {
        k.a.a.m.StringBuilder.append(paramString1);
      }
      append();
      return paramArrayList1;
    }
    catch (Throwable paramString1)
    {
      throw paramString1;
    }
  }
  
  public ArrayList a(ArrayList paramArrayList)
    throws SQLException
  {
    try
    {
      ArrayList localArrayList = new ArrayList();
      get();
      Object localObject1 = this$0;
      Object localObject2 = name;
      String str1 = c;
      String str2 = left;
      String str3 = a;
      String str4 = b;
      String str5 = directory;
      String str6 = cache;
      String str7 = logger;
      String str8 = helper;
      String str9 = this$1;
      String str10 = index;
      String str11 = key;
      String str12 = username;
      String str13 = date;
      String str14 = hash;
      String str15 = level;
      String str16 = y;
      String str17 = LOG;
      String str18 = TAG;
      String str19 = root;
      String str20 = $assertionsDisabled;
      String str21 = file;
      String str22 = type;
      String str23 = data;
      String str24 = text;
      try
      {
        Object localObject3 = new StringBuilder();
        String str25 = file;
        ((StringBuilder)localObject3).append(str25);
        ((StringBuilder)localObject3).append(" COLLATE NOCASE ASC");
        localObject3 = ((StringBuilder)localObject3).toString();
        localObject1 = ((SQLiteDatabase)localObject1).query((String)localObject2, new String[] { str1, str2, str3, str4, str5, str6, str7, str8, str9, str10, str11, str12, str13, str14, str15, str16, str17, str18, str19, str20, str21, str22, str23, str24 }, null, null, null, null, (String)localObject3);
        if (localObject1 != null)
        {
          boolean bool = ((Cursor)localObject1).moveToFirst();
          if (bool) {
            for (;;)
            {
              bool = paramArrayList.contains(((Cursor)localObject1).getString(0));
              if (bool)
              {
                localObject2 = new O();
                ((O)localObject2).j(((Cursor)localObject1).getString(0));
                ((O)localObject2).n(((Cursor)localObject1).getString(1));
                ((O)localObject2).a(((Cursor)localObject1).getString(2));
                ((O)localObject2).k(((Cursor)localObject1).getString(3));
                ((O)localObject2).b(((Cursor)localObject1).getString(4));
                ((O)localObject2).c(((Cursor)localObject1).getString(5));
                ((O)localObject2).t(((Cursor)localObject1).getString(6));
                ((O)localObject2).w(((Cursor)localObject1).getString(7));
                ((O)localObject2).i(((Cursor)localObject1).getString(8));
                ((O)localObject2).d(((Cursor)localObject1).getString(9));
                ((O)localObject2).x(((Cursor)localObject1).getString(10));
                ((O)localObject2).q(((Cursor)localObject1).getString(11));
                ((O)localObject2).o(((Cursor)localObject1).getString(12));
                ((O)localObject2).p(((Cursor)localObject1).getString(13));
                ((O)localObject2).s(((Cursor)localObject1).getString(14));
                ((O)localObject2).e(((Cursor)localObject1).getString(15));
                ((O)localObject2).g(((Cursor)localObject1).getString(16));
                ((O)localObject2).f(((Cursor)localObject1).getString(17));
                ((O)localObject2).u(((Cursor)localObject1).getString(18));
                ((O)localObject2).r(((Cursor)localObject1).getString(19));
                ((O)localObject2).h(((Cursor)localObject1).getString(20));
                ((O)localObject2).v(((Cursor)localObject1).getString(21));
                ((O)localObject2).m(((Cursor)localObject1).getString(22));
                ((O)localObject2).l(((Cursor)localObject1).getString(23));
                localArrayList.add(localObject2);
              }
              bool = ((Cursor)localObject1).moveToNext();
              if (!bool) {
                break;
              }
            }
          }
          ((Cursor)localObject1).close();
        }
      }
      catch (Exception paramArrayList)
      {
        k.a.a.m.StringBuilder.append(paramArrayList);
      }
      append();
      return localArrayList;
    }
    catch (Throwable paramArrayList)
    {
      throw paramArrayList;
    }
  }
  
  public ArrayList a(ArrayList paramArrayList, String paramString)
    throws SQLException
  {
    try
    {
      ArrayList localArrayList = new ArrayList();
      get();
      Object localObject1 = this$0;
      String str1 = name;
      String str2 = c;
      String str3 = left;
      String str4 = a;
      String str5 = b;
      String str6 = directory;
      String str7 = cache;
      String str8 = logger;
      String str9 = helper;
      String str10 = this$1;
      String str11 = index;
      String str12 = key;
      String str13 = username;
      String str14 = date;
      String str15 = hash;
      String str16 = level;
      String str17 = y;
      String str18 = LOG;
      String str19 = TAG;
      String str20 = root;
      String str21 = $assertionsDisabled;
      String str22 = file;
      String str23 = type;
      String str24 = data;
      String str25 = text;
      try
      {
        Object localObject2 = new StringBuilder();
        String str26 = root;
        ((StringBuilder)localObject2).append(str26);
        ((StringBuilder)localObject2).append("=\"");
        ((StringBuilder)localObject2).append(paramString);
        ((StringBuilder)localObject2).append("\" OR ");
        str26 = $assertionsDisabled;
        ((StringBuilder)localObject2).append(str26);
        ((StringBuilder)localObject2).append(" LIKE '%|");
        ((StringBuilder)localObject2).append(paramString);
        ((StringBuilder)localObject2).append("|%'");
        paramString = ((StringBuilder)localObject2).toString();
        localObject2 = new StringBuilder();
        str26 = file;
        ((StringBuilder)localObject2).append(str26);
        ((StringBuilder)localObject2).append(" COLLATE NOCASE ASC");
        localObject2 = ((StringBuilder)localObject2).toString();
        paramString = ((SQLiteDatabase)localObject1).query(str1, new String[] { str2, str3, str4, str5, str6, str7, str8, str9, str10, str11, str12, str13, str14, str15, str16, str17, str18, str19, str20, str21, str22, str23, str24, str25 }, paramString, null, null, null, (String)localObject2);
        if (paramString != null)
        {
          boolean bool = paramString.moveToFirst();
          if (bool) {
            for (;;)
            {
              bool = paramArrayList.contains(paramString.getString(0));
              if (bool)
              {
                localObject1 = new O();
                ((O)localObject1).j(paramString.getString(0));
                ((O)localObject1).n(paramString.getString(1));
                ((O)localObject1).a(paramString.getString(2));
                ((O)localObject1).k(paramString.getString(3));
                ((O)localObject1).b(paramString.getString(4));
                ((O)localObject1).c(paramString.getString(5));
                ((O)localObject1).t(paramString.getString(6));
                ((O)localObject1).w(paramString.getString(7));
                ((O)localObject1).i(paramString.getString(8));
                ((O)localObject1).d(paramString.getString(9));
                ((O)localObject1).x(paramString.getString(10));
                ((O)localObject1).q(paramString.getString(11));
                ((O)localObject1).o(paramString.getString(12));
                ((O)localObject1).p(paramString.getString(13));
                ((O)localObject1).s(paramString.getString(14));
                ((O)localObject1).e(paramString.getString(15));
                ((O)localObject1).g(paramString.getString(16));
                ((O)localObject1).f(paramString.getString(17));
                ((O)localObject1).u(paramString.getString(18));
                ((O)localObject1).r(paramString.getString(19));
                ((O)localObject1).h(paramString.getString(20));
                ((O)localObject1).v(paramString.getString(21));
                ((O)localObject1).m(paramString.getString(22));
                ((O)localObject1).l(paramString.getString(23));
                localArrayList.add(localObject1);
              }
              bool = paramString.moveToNext();
              if (!bool) {
                break;
              }
            }
          }
          paramString.close();
        }
      }
      catch (Exception paramArrayList)
      {
        k.a.a.m.StringBuilder.append(paramArrayList);
      }
      append();
      return localArrayList;
    }
    catch (Throwable paramArrayList)
    {
      throw paramArrayList;
    }
  }
  
  public void a(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8, String paramString9, String paramString10, String paramString11, String paramString12, String paramString13, String paramString14, String paramString15, String paramString16, String paramString17, String paramString18, String paramString19, String paramString20, String paramString21)
  {
    try
    {
      get();
      try
      {
        ContentValues localContentValues = new ContentValues();
        String str = w;
        localContentValues.put(str, paramString1);
        paramString1 = m;
        localContentValues.put(paramString1, paramString2);
        paramString1 = Q;
        localContentValues.put(paramString1, paramString3);
        paramString1 = H;
        localContentValues.put(paramString1, paramString4);
        paramString1 = n;
        localContentValues.put(paramString1, paramString5);
        paramString1 = S;
        localContentValues.put(paramString1, paramString6);
        paramString1 = G;
        localContentValues.put(paramString1, paramString7);
        paramString1 = P;
        localContentValues.put(paramString1, paramString8);
        paramString1 = TYPE;
        localContentValues.put(paramString1, paramString9);
        paramString1 = c;
        localContentValues.put(paramString1, paramString10);
        paramString1 = d;
        localContentValues.put(paramString1, paramString11);
        paramString1 = DOMAIN;
        localContentValues.put(paramString1, paramString12);
        paramString1 = B;
        localContentValues.put(paramString1, paramString13);
        paramString1 = X;
        localContentValues.put(paramString1, paramString14);
        paramString1 = M;
        localContentValues.put(paramString1, paramString15);
        paramString1 = A;
        localContentValues.put(paramString1, paramString16);
        paramString1 = C;
        localContentValues.put(paramString1, paramString17);
        paramString1 = t;
        localContentValues.put(paramString1, paramString18);
        paramString1 = x;
        localContentValues.put(paramString1, paramString19);
        paramString1 = I;
        localContentValues.put(paramString1, paramString20);
        paramString1 = width;
        localContentValues.put(paramString1, paramString21);
        paramString1 = this$0;
        paramString2 = r;
        paramString1.insert(paramString2, null, localContentValues);
      }
      catch (Exception paramString1)
      {
        k.a.a.m.StringBuilder.append(paramString1);
      }
      append();
      return;
    }
    catch (Throwable paramString1)
    {
      throw paramString1;
    }
  }
  
  public ArrayList add()
    throws SQLException
  {
    try
    {
      ArrayList localArrayList = new ArrayList();
      get();
      Object localObject1 = this$0;
      Object localObject2 = size;
      String str1 = c;
      String str2 = left;
      String str3 = a;
      String str4 = b;
      String str5 = TAG;
      String str6 = first;
      String str7 = length;
      String str8 = position;
      String str9 = root;
      String str10 = directory;
      String str11 = cache;
      String str12 = parent;
      String str13 = activity;
      String str14 = logger;
      String str15 = DEBUG;
      String str16 = helper;
      String str17 = this$1;
      String str18 = index;
      String str19 = key;
      String str20 = log;
      String str21 = queue;
      String str22 = LOG;
      String str23 = lock;
      String str24 = $assertionsDisabled;
      String str25 = level;
      String str26 = type;
      String str27 = data;
      String str28 = text;
      try
      {
        Object localObject3 = new StringBuilder();
        Object localObject4 = type;
        ((StringBuilder)localObject3).append((String)localObject4);
        ((StringBuilder)localObject3).append("=\"I\"");
        localObject3 = ((StringBuilder)localObject3).toString();
        localObject4 = new StringBuilder();
        String str29 = left;
        ((StringBuilder)localObject4).append(str29);
        ((StringBuilder)localObject4).append(" COLLATE NOCASE ASC");
        localObject4 = ((StringBuilder)localObject4).toString();
        localObject1 = ((SQLiteDatabase)localObject1).query((String)localObject2, new String[] { str1, str2, str3, str4, str5, str6, str7, str8, str9, str10, str11, str12, str13, str14, str15, str16, str17, str18, str19, str20, str21, str22, str23, str24, str25, str26, str27, str28 }, (String)localObject3, null, null, null, (String)localObject4);
        if (localObject1 != null)
        {
          boolean bool = ((Cursor)localObject1).moveToFirst();
          if (bool) {
            for (;;)
            {
              localObject2 = new Log();
              ((Log)localObject2).getName(((Cursor)localObject1).getString(0));
              ((Log)localObject2).read(((Cursor)localObject1).getString(1));
              ((Log)localObject2).size(((Cursor)localObject1).getString(2));
              ((Log)localObject2).trim(((Cursor)localObject1).getString(3));
              ((Log)localObject2).split(((Cursor)localObject1).getString(4));
              ((Log)localObject2).write(((Cursor)localObject1).getString(5));
              ((Log)localObject2).execute(((Cursor)localObject1).getString(6));
              ((Log)localObject2).v(((Cursor)localObject1).getString(7));
              ((Log)localObject2).add(((Cursor)localObject1).getString(8));
              ((Log)localObject2).log(((Cursor)localObject1).getString(9));
              ((Log)localObject2).append(((Cursor)localObject1).getString(10));
              ((Log)localObject2).valueOf(Boolean.parseBoolean(((Cursor)localObject1).getString(11)));
              ((Log)localObject2).set(Boolean.parseBoolean(((Cursor)localObject1).getString(12)));
              ((Log)localObject2).d(((Cursor)localObject1).getString(13));
              ((Log)localObject2).add(Boolean.parseBoolean(((Cursor)localObject1).getString(14)));
              ((Log)localObject2).print(((Cursor)localObject1).getString(15));
              ((Log)localObject2).get(((Cursor)localObject1).getString(16));
              ((Log)localObject2).next(((Cursor)localObject1).getString(17));
              ((Log)localObject2).equals(((Cursor)localObject1).getString(18));
              ((Log)localObject2).set(((Cursor)localObject1).getString(19));
              ((Log)localObject2).start(((Cursor)localObject1).getString(20));
              ((Log)localObject2).put(((Cursor)localObject1).getString(21));
              ((Log)localObject2).update(((Cursor)localObject1).getString(22));
              ((Log)localObject2).toString(((Cursor)localObject1).getString(23));
              ((Log)localObject2).close(((Cursor)localObject1).getString(24));
              ((Log)localObject2).w(((Cursor)localObject1).getString(25));
              ((Log)localObject2).name(((Cursor)localObject1).getString(26));
              ((Log)localObject2).format(((Cursor)localObject1).getString(27));
              localArrayList.add(localObject2);
              bool = ((Cursor)localObject1).moveToNext();
              if (!bool) {
                break;
              }
            }
          }
          ((Cursor)localObject1).close();
        }
      }
      catch (Exception localException)
      {
        k.a.a.m.StringBuilder.append(localException);
      }
      append();
      return localArrayList;
    }
    catch (Throwable localThrowable)
    {
      throw localThrowable;
    }
  }
  
  public Log add(String paramString)
    throws SQLException
  {
    try
    {
      get();
      Object localObject = this$0;
      String str1 = size;
      String str2 = c;
      String str3 = left;
      String str4 = a;
      String str5 = b;
      String str6 = TAG;
      String str7 = first;
      String str8 = length;
      String str9 = position;
      String str10 = root;
      String str11 = directory;
      String str12 = cache;
      String str13 = parent;
      String str14 = activity;
      String str15 = logger;
      String str16 = DEBUG;
      String str17 = helper;
      String str18 = this$1;
      String str19 = index;
      String str20 = key;
      String str21 = log;
      String str22 = queue;
      String str23 = LOG;
      String str24 = lock;
      String str25 = $assertionsDisabled;
      String str26 = level;
      String str27 = type;
      String str28 = data;
      String str29 = text;
      try
      {
        StringBuilder localStringBuilder = new StringBuilder();
        String str30 = c;
        localStringBuilder.append(str30);
        localStringBuilder.append("=\"");
        localStringBuilder.append(paramString);
        localStringBuilder.append("\"");
        paramString = localStringBuilder.toString();
        localObject = ((SQLiteDatabase)localObject).query(str1, new String[] { str2, str3, str4, str5, str6, str7, str8, str9, str10, str11, str12, str13, str14, str15, str16, str17, str18, str19, str20, str21, str22, str23, str24, str25, str26, str27, str28, str29 }, paramString, null, null, null, null);
        if (localObject != null)
        {
          boolean bool = ((Cursor)localObject).moveToFirst();
          if (bool)
          {
            paramString = new Log();
            try
            {
              paramString.getName(((Cursor)localObject).getString(0));
              paramString.read(((Cursor)localObject).getString(1));
              paramString.size(((Cursor)localObject).getString(2));
              paramString.trim(((Cursor)localObject).getString(3));
              paramString.split(((Cursor)localObject).getString(4));
              paramString.write(((Cursor)localObject).getString(5));
              paramString.execute(((Cursor)localObject).getString(6));
              paramString.v(((Cursor)localObject).getString(7));
              paramString.add(((Cursor)localObject).getString(8));
              paramString.log(((Cursor)localObject).getString(9));
              paramString.append(((Cursor)localObject).getString(10));
              paramString.valueOf(Boolean.parseBoolean(((Cursor)localObject).getString(11)));
              paramString.set(Boolean.parseBoolean(((Cursor)localObject).getString(12)));
              paramString.d(((Cursor)localObject).getString(13));
              paramString.add(Boolean.parseBoolean(((Cursor)localObject).getString(14)));
              paramString.print(((Cursor)localObject).getString(15));
              paramString.get(((Cursor)localObject).getString(16));
              paramString.next(((Cursor)localObject).getString(17));
              paramString.equals(((Cursor)localObject).getString(18));
              paramString.set(((Cursor)localObject).getString(19));
              paramString.start(((Cursor)localObject).getString(20));
              paramString.put(((Cursor)localObject).getString(21));
              paramString.update(((Cursor)localObject).getString(22));
              paramString.toString(((Cursor)localObject).getString(23));
              paramString.close(((Cursor)localObject).getString(24));
              paramString.w(((Cursor)localObject).getString(25));
              paramString.name(((Cursor)localObject).getString(26));
              paramString.format(((Cursor)localObject).getString(27));
            }
            catch (Exception localException1)
            {
              break label781;
            }
          }
          else
          {
            paramString = null;
          }
          try
          {
            localException1.close();
          }
          catch (Exception localException2)
          {
            break label781;
          }
        }
        else
        {
          paramString = null;
        }
      }
      catch (Exception localException3)
      {
        paramString = null;
        label781:
        k.a.a.m.StringBuilder.append(localException3);
      }
      append();
      return paramString;
    }
    catch (Throwable paramString)
    {
      throw paramString;
    }
  }
  
  public void add(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5)
  {
    try
    {
      get();
      try
      {
        ContentValues localContentValues = new ContentValues();
        String str = LOG_TAG;
        localContentValues.put(str, paramString1);
        paramString1 = g;
        localContentValues.put(paramString1, paramString2);
        paramString1 = j;
        localContentValues.put(paramString1, paramString3);
        paramString1 = l;
        localContentValues.put(paramString1, paramString4);
        paramString1 = view;
        localContentValues.put(paramString1, paramString5);
        paramString1 = this$0;
        paramString2 = table;
        paramString1.insert(paramString2, null, localContentValues);
      }
      catch (Exception paramString1)
      {
        k.a.a.m.StringBuilder.append(paramString1);
      }
      append();
      return;
    }
    catch (Throwable paramString1)
    {
      throw paramString1;
    }
  }
  
  public void add(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6)
  {
    try
    {
      get();
      try
      {
        ContentValues localContentValues = new ContentValues();
        String str = LOG_TAG;
        localContentValues.put(str, paramString1);
        paramString1 = g;
        localContentValues.put(paramString1, paramString2);
        paramString1 = j;
        localContentValues.put(paramString1, paramString3);
        paramString1 = l;
        localContentValues.put(paramString1, paramString4);
        paramString1 = view;
        localContentValues.put(paramString1, paramString5);
        paramString1 = type;
        localContentValues.put(paramString1, paramString6);
        paramString1 = this$0;
        paramString2 = mContext;
        paramString1.insert(paramString2, null, localContentValues);
      }
      catch (Exception paramString1)
      {
        k.a.a.m.StringBuilder.append(paramString1);
      }
      append();
      return;
    }
    catch (Throwable paramString1)
    {
      throw paramString1;
    }
  }
  
  public void add(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8, String paramString9, String paramString10, String paramString11, String paramString12, String paramString13, String paramString14, String paramString15, String paramString16, String paramString17, String paramString18, String paramString19, String paramString20, String paramString21, String paramString22, String paramString23, String paramString24, String paramString25, String paramString26, String paramString27, String paramString28)
  {
    try
    {
      get();
      try
      {
        ContentValues localContentValues = new ContentValues();
        String str = c;
        localContentValues.put(str, paramString1);
        paramString1 = left;
        localContentValues.put(paramString1, paramString2);
        paramString1 = a;
        localContentValues.put(paramString1, paramString3);
        paramString1 = b;
        localContentValues.put(paramString1, paramString4);
        paramString1 = TAG;
        localContentValues.put(paramString1, paramString5);
        paramString1 = first;
        localContentValues.put(paramString1, paramString6);
        paramString1 = length;
        localContentValues.put(paramString1, paramString7);
        paramString1 = position;
        localContentValues.put(paramString1, paramString8);
        paramString1 = root;
        localContentValues.put(paramString1, paramString9);
        paramString1 = directory;
        localContentValues.put(paramString1, paramString10);
        paramString1 = cache;
        localContentValues.put(paramString1, paramString11);
        paramString1 = parent;
        localContentValues.put(paramString1, paramString12);
        paramString1 = activity;
        localContentValues.put(paramString1, paramString13);
        paramString1 = logger;
        localContentValues.put(paramString1, paramString14);
        paramString1 = DEBUG;
        localContentValues.put(paramString1, paramString15);
        paramString1 = helper;
        localContentValues.put(paramString1, paramString16);
        paramString1 = this$1;
        localContentValues.put(paramString1, paramString17);
        paramString1 = index;
        localContentValues.put(paramString1, paramString18);
        paramString1 = key;
        localContentValues.put(paramString1, paramString19);
        paramString1 = log;
        localContentValues.put(paramString1, paramString20);
        paramString1 = queue;
        localContentValues.put(paramString1, paramString21);
        paramString1 = LOG;
        localContentValues.put(paramString1, paramString22);
        paramString1 = lock;
        localContentValues.put(paramString1, paramString23);
        paramString1 = $assertionsDisabled;
        localContentValues.put(paramString1, paramString24);
        paramString1 = level;
        localContentValues.put(paramString1, paramString25);
        paramString1 = type;
        localContentValues.put(paramString1, paramString26);
        paramString1 = data;
        localContentValues.put(paramString1, paramString27);
        paramString1 = text;
        localContentValues.put(paramString1, paramString28);
        paramString1 = this$0;
        paramString2 = size;
        paramString1.insert(paramString2, null, localContentValues);
      }
      catch (Exception paramString1)
      {
        k.a.a.m.StringBuilder.append(paramString1);
      }
      append();
      return;
    }
    catch (Throwable paramString1)
    {
      throw paramString1;
    }
  }
  
  public void add(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8, String paramString9, String paramString10, String paramString11, String paramString12, String paramString13, String paramString14, String paramString15, String paramString16, String paramString17, String paramString18, String paramString19, String paramString20, String paramString21, String paramString22, String paramString23, String paramString24, String paramString25, String paramString26, String paramString27, String paramString28, String paramString29)
  {
    try
    {
      get();
      try
      {
        ContentValues localContentValues = new ContentValues();
        String str = c;
        localContentValues.put(str, paramString1);
        paramString1 = left;
        localContentValues.put(paramString1, paramString2);
        paramString1 = a;
        localContentValues.put(paramString1, paramString3);
        paramString1 = b;
        localContentValues.put(paramString1, paramString4);
        paramString1 = TAG;
        localContentValues.put(paramString1, paramString5);
        paramString1 = first;
        localContentValues.put(paramString1, paramString6);
        paramString1 = length;
        localContentValues.put(paramString1, paramString7);
        paramString1 = position;
        localContentValues.put(paramString1, paramString8);
        paramString1 = root;
        localContentValues.put(paramString1, paramString9);
        paramString1 = directory;
        localContentValues.put(paramString1, paramString10);
        paramString1 = cache;
        localContentValues.put(paramString1, paramString11);
        paramString1 = parent;
        localContentValues.put(paramString1, paramString12);
        paramString1 = activity;
        localContentValues.put(paramString1, paramString13);
        paramString1 = logger;
        localContentValues.put(paramString1, paramString14);
        paramString1 = DEBUG;
        localContentValues.put(paramString1, paramString15);
        paramString1 = helper;
        localContentValues.put(paramString1, paramString16);
        paramString1 = this$1;
        localContentValues.put(paramString1, paramString17);
        paramString1 = index;
        localContentValues.put(paramString1, paramString18);
        paramString1 = key;
        localContentValues.put(paramString1, paramString19);
        paramString1 = log;
        localContentValues.put(paramString1, paramString20);
        paramString1 = queue;
        localContentValues.put(paramString1, paramString21);
        paramString1 = LOG;
        localContentValues.put(paramString1, paramString22);
        paramString1 = lock;
        localContentValues.put(paramString1, paramString23);
        paramString1 = $assertionsDisabled;
        localContentValues.put(paramString1, paramString24);
        paramString1 = level;
        localContentValues.put(paramString1, paramString25);
        paramString1 = type;
        localContentValues.put(paramString1, paramString26);
        paramString1 = file;
        localContentValues.put(paramString1, paramString27);
        paramString1 = data;
        localContentValues.put(paramString1, paramString28);
        paramString1 = text;
        localContentValues.put(paramString1, paramString29);
        paramString1 = this$0;
        paramString2 = context;
        paramString1.insert(paramString2, null, localContentValues);
      }
      catch (Exception paramString1)
      {
        k.a.a.m.StringBuilder.append(paramString1);
      }
      append();
      return;
    }
    catch (Throwable paramString1)
    {
      throw paramString1;
    }
  }
  
  public void append()
  {
    try
    {
      currentIndex -= 1;
      int k = currentIndex;
      if (k == 0)
      {
        SQLiteDatabase localSQLiteDatabase = this$0;
        try
        {
          localSQLiteDatabase.close();
        }
        catch (Exception localException)
        {
          k.a.a.m.StringBuilder.append(localException);
        }
      }
      return;
    }
    catch (Throwable localThrowable)
    {
      throw localThrowable;
    }
  }
  
  public void apply(String paramString1, String paramString2)
  {
    try
    {
      get();
      SQLiteDatabase localSQLiteDatabase = this$0;
      String str1 = map;
      try
      {
        StringBuilder localStringBuilder = new StringBuilder();
        String str2 = delegate;
        localStringBuilder.append(str2);
        localStringBuilder.append("=\"");
        localStringBuilder.append(paramString1);
        localStringBuilder.append("\" AND ");
        paramString1 = NONE;
        localStringBuilder.append(paramString1);
        localStringBuilder.append("=\"");
        localStringBuilder.append(paramString2);
        localStringBuilder.append("\"");
        localSQLiteDatabase.delete(str1, localStringBuilder.toString(), null);
      }
      catch (Exception paramString1)
      {
        k.a.a.m.StringBuilder.append(paramString1);
      }
      append();
      return;
    }
    catch (Throwable paramString1)
    {
      throw paramString1;
    }
  }
  
  public ArrayList call()
    throws SQLException
  {
    try
    {
      ArrayList localArrayList = new ArrayList();
      get();
      Object localObject1 = this$0;
      Object localObject2 = cursor;
      String str1 = path;
      String str2 = connection;
      String str3 = uri;
      String str4 = phoneNumber;
      try
      {
        localObject1 = ((SQLiteDatabase)localObject1).query((String)localObject2, new String[] { str1, str2, str3, str4 }, null, null, null, null, null);
        if (localObject1 != null)
        {
          boolean bool = ((Cursor)localObject1).moveToFirst();
          if (bool) {
            do
            {
              localObject2 = new M();
              ((M)localObject2).c(((Cursor)localObject1).getString(0));
              ((M)localObject2).b(((Cursor)localObject1).getString(1));
              ((M)localObject2).d(((Cursor)localObject1).getString(2));
              ((M)localObject2).a(((Cursor)localObject1).getString(3));
              localArrayList.add(localObject2);
              bool = ((Cursor)localObject1).moveToNext();
            } while (bool);
          }
          ((Cursor)localObject1).close();
        }
      }
      catch (Exception localException)
      {
        k.a.a.m.StringBuilder.append(localException);
      }
      append();
      return localArrayList;
    }
    catch (Throwable localThrowable)
    {
      throw localThrowable;
    }
  }
  
  public void check(String paramString)
  {
    try
    {
      get();
      SQLiteDatabase localSQLiteDatabase = this$0;
      String str1 = size;
      try
      {
        StringBuilder localStringBuilder = new StringBuilder();
        String str2 = c;
        localStringBuilder.append(str2);
        localStringBuilder.append("=\"");
        localStringBuilder.append(paramString);
        localStringBuilder.append("\"");
        localSQLiteDatabase.delete(str1, localStringBuilder.toString(), null);
      }
      catch (Exception paramString)
      {
        k.a.a.m.StringBuilder.append(paramString);
      }
      append();
      return;
    }
    catch (Throwable paramString)
    {
      throw paramString;
    }
  }
  
  public void clean()
  {
    try
    {
      get();
      SQLiteDatabase localSQLiteDatabase = this$0;
      String str = name;
      try
      {
        localSQLiteDatabase.delete(str, null, null);
      }
      catch (Exception localException)
      {
        k.a.a.m.StringBuilder.append(localException);
      }
      append();
      return;
    }
    catch (Throwable localThrowable)
    {
      throw localThrowable;
    }
  }
  
  public void clean(String paramString)
  {
    try
    {
      get();
      SQLiteDatabase localSQLiteDatabase = this$0;
      String str1 = context;
      try
      {
        StringBuilder localStringBuilder = new StringBuilder();
        String str2 = c;
        localStringBuilder.append(str2);
        localStringBuilder.append("=\"");
        localStringBuilder.append(paramString);
        localStringBuilder.append("\"");
        localSQLiteDatabase.delete(str1, localStringBuilder.toString(), null);
      }
      catch (Exception paramString)
      {
        k.a.a.m.StringBuilder.append(paramString);
      }
      append();
      return;
    }
    catch (Throwable paramString)
    {
      throw paramString;
    }
  }
  
  public void convert()
  {
    try
    {
      get();
      SQLiteDatabase localSQLiteDatabase = this$0;
      String str = adapter;
      try
      {
        localSQLiteDatabase.delete(str, null, null);
      }
      catch (Exception localException)
      {
        k.a.a.m.StringBuilder.append(localException);
      }
      append();
      return;
    }
    catch (Throwable localThrowable)
    {
      throw localThrowable;
    }
  }
  
  public int count()
    throws SQLException
  {
    int i2 = 0;
    int i1 = 0;
    try
    {
      get();
      int k = i1;
      try
      {
        Object localObject1 = new StringBuilder();
        k = i1;
        ((StringBuilder)localObject1).append("select * from ");
        Object localObject2 = context;
        k = i1;
        ((StringBuilder)localObject1).append((String)localObject2);
        k = i1;
        localObject1 = ((StringBuilder)localObject1).toString();
        localObject2 = this$0;
        k = i1;
        localObject1 = ((SQLiteDatabase)localObject2).rawQuery((String)localObject1, null);
        k = i2;
        if (localObject1 != null)
        {
          k = i1;
          i1 = ((Cursor)localObject1).getCount();
          k = i1;
          ((Cursor)localObject1).close();
          k = i1;
        }
      }
      catch (Exception localException)
      {
        k.a.a.m.StringBuilder.append(localException);
      }
      append();
      return k;
    }
    catch (Throwable localThrowable)
    {
      throw localThrowable;
    }
  }
  
  public ArrayList decode()
    throws SQLException
  {
    try
    {
      ArrayList localArrayList = new ArrayList();
      get();
      Object localObject1 = this$0;
      Object localObject2 = context;
      String str1 = c;
      String str2 = left;
      String str3 = a;
      String str4 = b;
      String str5 = TAG;
      String str6 = first;
      String str7 = length;
      String str8 = position;
      String str9 = root;
      String str10 = directory;
      String str11 = cache;
      String str12 = parent;
      String str13 = activity;
      String str14 = logger;
      String str15 = DEBUG;
      String str16 = helper;
      String str17 = this$1;
      String str18 = index;
      String str19 = key;
      String str20 = log;
      String str21 = queue;
      String str22 = LOG;
      String str23 = lock;
      String str24 = $assertionsDisabled;
      String str25 = level;
      String str26 = type;
      String str27 = file;
      String str28 = data;
      String str29 = text;
      try
      {
        Object localObject3 = new StringBuilder();
        Object localObject4 = type;
        ((StringBuilder)localObject3).append((String)localObject4);
        ((StringBuilder)localObject3).append("=\"I\"");
        localObject3 = ((StringBuilder)localObject3).toString();
        localObject4 = new StringBuilder();
        String str30 = left;
        ((StringBuilder)localObject4).append(str30);
        ((StringBuilder)localObject4).append(" COLLATE NOCASE ASC");
        localObject4 = ((StringBuilder)localObject4).toString();
        localObject1 = ((SQLiteDatabase)localObject1).query((String)localObject2, new String[] { str1, str2, str3, str4, str5, str6, str7, str8, str9, str10, str11, str12, str13, str14, str15, str16, str17, str18, str19, str20, str21, str22, str23, str24, str25, str26, str27, str28, str29 }, (String)localObject3, null, null, null, (String)localObject4);
        if (localObject1 != null)
        {
          boolean bool = ((Cursor)localObject1).moveToFirst();
          if (bool) {
            for (;;)
            {
              localObject2 = new Log();
              ((Log)localObject2).getName(((Cursor)localObject1).getString(0));
              ((Log)localObject2).read(((Cursor)localObject1).getString(1));
              ((Log)localObject2).size(((Cursor)localObject1).getString(2));
              ((Log)localObject2).trim(((Cursor)localObject1).getString(3));
              ((Log)localObject2).split(((Cursor)localObject1).getString(4));
              ((Log)localObject2).write(((Cursor)localObject1).getString(5));
              ((Log)localObject2).execute(((Cursor)localObject1).getString(6));
              ((Log)localObject2).v(((Cursor)localObject1).getString(7));
              ((Log)localObject2).add(((Cursor)localObject1).getString(8));
              ((Log)localObject2).log(((Cursor)localObject1).getString(9));
              ((Log)localObject2).append(((Cursor)localObject1).getString(10));
              ((Log)localObject2).valueOf(Boolean.parseBoolean(((Cursor)localObject1).getString(11)));
              ((Log)localObject2).set(Boolean.parseBoolean(((Cursor)localObject1).getString(12)));
              ((Log)localObject2).d(((Cursor)localObject1).getString(13));
              ((Log)localObject2).add(Boolean.parseBoolean(((Cursor)localObject1).getString(14)));
              ((Log)localObject2).print(((Cursor)localObject1).getString(15));
              ((Log)localObject2).get(((Cursor)localObject1).getString(16));
              ((Log)localObject2).next(((Cursor)localObject1).getString(17));
              ((Log)localObject2).equals(((Cursor)localObject1).getString(18));
              ((Log)localObject2).set(((Cursor)localObject1).getString(19));
              ((Log)localObject2).start(((Cursor)localObject1).getString(20));
              ((Log)localObject2).put(((Cursor)localObject1).getString(21));
              ((Log)localObject2).update(((Cursor)localObject1).getString(22));
              ((Log)localObject2).toString(((Cursor)localObject1).getString(23));
              ((Log)localObject2).close(((Cursor)localObject1).getString(24));
              ((Log)localObject2).w(((Cursor)localObject1).getString(25));
              ((Log)localObject2).e(((Cursor)localObject1).getString(26));
              ((Log)localObject2).name(((Cursor)localObject1).getString(27));
              ((Log)localObject2).format(((Cursor)localObject1).getString(28));
              localArrayList.add(localObject2);
              bool = ((Cursor)localObject1).moveToNext();
              if (!bool) {
                break;
              }
            }
          }
          ((Cursor)localObject1).close();
        }
      }
      catch (Exception localException)
      {
        k.a.a.m.StringBuilder.append(localException);
      }
      append();
      return localArrayList;
    }
    catch (Throwable localThrowable)
    {
      throw localThrowable;
    }
  }
  
  public void decode(String paramString)
  {
    try
    {
      get();
      SQLiteDatabase localSQLiteDatabase = this$0;
      String str1 = r;
      try
      {
        StringBuilder localStringBuilder = new StringBuilder();
        String str2 = w;
        localStringBuilder.append(str2);
        localStringBuilder.append("=\"");
        localStringBuilder.append(paramString);
        localStringBuilder.append("\"");
        localSQLiteDatabase.delete(str1, localStringBuilder.toString(), null);
      }
      catch (Exception paramString)
      {
        k.a.a.m.StringBuilder.append(paramString);
      }
      append();
      return;
    }
    catch (Throwable paramString)
    {
      throw paramString;
    }
  }
  
  public void delete(String paramString)
  {
    try
    {
      get();
      SQLiteDatabase localSQLiteDatabase = this$0;
      String str1 = context;
      try
      {
        localSQLiteDatabase.delete(str1, null, null);
        localSQLiteDatabase = this$0;
        str1 = name;
        localSQLiteDatabase.delete(str1, null, null);
        localSQLiteDatabase = this$0;
        str1 = cursor;
        localSQLiteDatabase.delete(str1, null, null);
        localSQLiteDatabase = this$0;
        str1 = table;
        localSQLiteDatabase.delete(str1, null, null);
        localSQLiteDatabase = this$0;
        str1 = adapter;
        localSQLiteDatabase.delete(str1, null, null);
        localSQLiteDatabase = this$0;
        str1 = app;
        localSQLiteDatabase.delete(str1, null, null);
        localSQLiteDatabase = this$0;
        str1 = CONTENT_URI;
        localSQLiteDatabase.delete(str1, null, null);
        localSQLiteDatabase = this$0;
        str1 = i;
        localSQLiteDatabase.delete(str1, null, null);
        localSQLiteDatabase = this$0;
        str1 = URI;
        localSQLiteDatabase.delete(str1, null, null);
        boolean bool = paramString.equalsIgnoreCase("DontDeleteNotif");
        if (!bool)
        {
          localSQLiteDatabase = this$0;
          str1 = r;
          StringBuilder localStringBuilder = new StringBuilder();
          String str2 = x;
          localStringBuilder.append(str2);
          localStringBuilder.append("=\"");
          localStringBuilder.append(paramString);
          localStringBuilder.append("\"");
          localSQLiteDatabase.delete(str1, localStringBuilder.toString(), null);
          localSQLiteDatabase = this$0;
          str1 = mUri;
          localStringBuilder = new StringBuilder();
          str2 = x;
          localStringBuilder.append(str2);
          localStringBuilder.append("=\"");
          localStringBuilder.append(paramString);
          localStringBuilder.append("\"");
          localSQLiteDatabase.delete(str1, localStringBuilder.toString(), null);
        }
      }
      catch (Exception paramString)
      {
        k.a.a.m.StringBuilder.append(paramString);
      }
      append();
      return;
    }
    catch (Throwable paramString)
    {
      throw paramString;
    }
  }
  
  public String doInBackground(String paramString1, String paramString2)
    throws SQLException
  {
    String str2 = "false";
    try
    {
      get();
      SQLiteDatabase localSQLiteDatabase = this$0;
      String str3 = map;
      String str4 = values;
      String str1 = str2;
      try
      {
        StringBuilder localStringBuilder = new StringBuilder();
        String str5 = delegate;
        str1 = str2;
        localStringBuilder.append(str5);
        str1 = str2;
        localStringBuilder.append("=\"");
        str1 = str2;
        localStringBuilder.append(paramString1);
        str1 = str2;
        localStringBuilder.append("\" AND ");
        paramString1 = NONE;
        str1 = str2;
        localStringBuilder.append(paramString1);
        str1 = str2;
        localStringBuilder.append("=\"");
        str1 = str2;
        localStringBuilder.append(paramString2);
        str1 = str2;
        localStringBuilder.append("\"");
        str1 = str2;
        paramString1 = localStringBuilder.toString();
        str1 = str2;
        paramString2 = localSQLiteDatabase.query(str3, new String[] { str4 }, paramString1, null, null, null, null);
        paramString1 = str2;
        if (paramString2 != null)
        {
          str1 = str2;
          boolean bool = paramString2.moveToFirst();
          paramString1 = str2;
          if (bool)
          {
            str1 = str2;
            do
            {
              paramString1 = paramString2.getString(0);
              str1 = paramString1;
              bool = paramString2.moveToNext();
              str1 = paramString1;
            } while (bool);
          }
          str1 = paramString1;
          paramString2.close();
        }
      }
      catch (Exception paramString1)
      {
        k.a.a.m.StringBuilder.append(paramString1);
        paramString1 = str1;
      }
      append();
      return paramString1;
    }
    catch (Throwable paramString1)
    {
      throw paramString1;
    }
  }
  
  public ArrayList doInBackground()
    throws SQLException
  {
    try
    {
      ArrayList localArrayList = new ArrayList();
      get();
      Object localObject1 = this$0;
      Object localObject2 = context;
      String str1 = c;
      String str2 = left;
      String str3 = a;
      String str4 = b;
      String str5 = TAG;
      String str6 = first;
      String str7 = length;
      String str8 = position;
      String str9 = root;
      String str10 = directory;
      String str11 = cache;
      String str12 = parent;
      String str13 = activity;
      String str14 = logger;
      String str15 = DEBUG;
      String str16 = helper;
      String str17 = this$1;
      String str18 = index;
      String str19 = key;
      String str20 = log;
      String str21 = queue;
      String str22 = LOG;
      String str23 = lock;
      String str24 = $assertionsDisabled;
      String str25 = level;
      String str26 = type;
      String str27 = file;
      String str28 = data;
      String str29 = text;
      try
      {
        Object localObject3 = new StringBuilder();
        Object localObject4 = type;
        ((StringBuilder)localObject3).append((String)localObject4);
        ((StringBuilder)localObject3).append("!=\"I\"");
        localObject3 = ((StringBuilder)localObject3).toString();
        localObject4 = new StringBuilder();
        String str30 = left;
        ((StringBuilder)localObject4).append(str30);
        ((StringBuilder)localObject4).append(" COLLATE NOCASE ASC");
        localObject4 = ((StringBuilder)localObject4).toString();
        localObject1 = ((SQLiteDatabase)localObject1).query((String)localObject2, new String[] { str1, str2, str3, str4, str5, str6, str7, str8, str9, str10, str11, str12, str13, str14, str15, str16, str17, str18, str19, str20, str21, str22, str23, str24, str25, str26, str27, str28, str29 }, (String)localObject3, null, null, null, (String)localObject4);
        if (localObject1 != null)
        {
          boolean bool = ((Cursor)localObject1).moveToFirst();
          if (bool) {
            for (;;)
            {
              localObject2 = new Log();
              ((Log)localObject2).getName(((Cursor)localObject1).getString(0));
              ((Log)localObject2).read(((Cursor)localObject1).getString(1));
              ((Log)localObject2).size(((Cursor)localObject1).getString(2));
              ((Log)localObject2).trim(((Cursor)localObject1).getString(3));
              ((Log)localObject2).split(((Cursor)localObject1).getString(4));
              ((Log)localObject2).write(((Cursor)localObject1).getString(5));
              ((Log)localObject2).execute(((Cursor)localObject1).getString(6));
              ((Log)localObject2).v(((Cursor)localObject1).getString(7));
              ((Log)localObject2).add(((Cursor)localObject1).getString(8));
              ((Log)localObject2).log(((Cursor)localObject1).getString(9));
              ((Log)localObject2).append(((Cursor)localObject1).getString(10));
              ((Log)localObject2).valueOf(Boolean.parseBoolean(((Cursor)localObject1).getString(11)));
              ((Log)localObject2).set(Boolean.parseBoolean(((Cursor)localObject1).getString(12)));
              ((Log)localObject2).d(((Cursor)localObject1).getString(13));
              ((Log)localObject2).add(Boolean.parseBoolean(((Cursor)localObject1).getString(14)));
              ((Log)localObject2).print(((Cursor)localObject1).getString(15));
              ((Log)localObject2).get(((Cursor)localObject1).getString(16));
              ((Log)localObject2).next(((Cursor)localObject1).getString(17));
              ((Log)localObject2).equals(((Cursor)localObject1).getString(18));
              ((Log)localObject2).set(((Cursor)localObject1).getString(19));
              ((Log)localObject2).start(((Cursor)localObject1).getString(20));
              ((Log)localObject2).put(((Cursor)localObject1).getString(21));
              ((Log)localObject2).update(((Cursor)localObject1).getString(22));
              ((Log)localObject2).toString(((Cursor)localObject1).getString(23));
              ((Log)localObject2).close(((Cursor)localObject1).getString(24));
              ((Log)localObject2).w(((Cursor)localObject1).getString(25));
              ((Log)localObject2).e(((Cursor)localObject1).getString(26));
              ((Log)localObject2).name(((Cursor)localObject1).getString(27));
              ((Log)localObject2).format(((Cursor)localObject1).getString(28));
              localArrayList.add(localObject2);
              bool = ((Cursor)localObject1).moveToNext();
              if (!bool) {
                break;
              }
            }
          }
          ((Cursor)localObject1).close();
        }
      }
      catch (Exception localException)
      {
        k.a.a.m.StringBuilder.append(localException);
      }
      append();
      return localArrayList;
    }
    catch (Throwable localThrowable)
    {
      throw localThrowable;
    }
  }
  
  public ArrayList doInBackground(String paramString)
    throws SQLException
  {
    try
    {
      ArrayList localArrayList = new ArrayList();
      get();
      Object localObject1 = this$0;
      String str1 = size;
      String str2 = c;
      String str3 = left;
      String str4 = a;
      String str5 = b;
      String str6 = TAG;
      String str7 = first;
      String str8 = length;
      String str9 = position;
      String str10 = root;
      String str11 = directory;
      String str12 = cache;
      String str13 = parent;
      String str14 = activity;
      String str15 = logger;
      String str16 = DEBUG;
      String str17 = helper;
      String str18 = this$1;
      String str19 = index;
      String str20 = key;
      String str21 = log;
      String str22 = queue;
      String str23 = LOG;
      String str24 = lock;
      String str25 = $assertionsDisabled;
      String str26 = level;
      String str27 = type;
      String str28 = data;
      String str29 = text;
      try
      {
        Object localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("(");
        String str30 = root;
        ((StringBuilder)localObject2).append(str30);
        ((StringBuilder)localObject2).append("=\"");
        ((StringBuilder)localObject2).append(paramString);
        ((StringBuilder)localObject2).append("\" OR ");
        str30 = $assertionsDisabled;
        ((StringBuilder)localObject2).append(str30);
        ((StringBuilder)localObject2).append(" LIKE '%|");
        ((StringBuilder)localObject2).append(paramString);
        ((StringBuilder)localObject2).append("|%') AND ");
        paramString = type;
        ((StringBuilder)localObject2).append(paramString);
        ((StringBuilder)localObject2).append("!=\"I\"");
        paramString = ((StringBuilder)localObject2).toString();
        localObject2 = new StringBuilder();
        str30 = left;
        ((StringBuilder)localObject2).append(str30);
        ((StringBuilder)localObject2).append(" COLLATE NOCASE ASC");
        localObject2 = ((StringBuilder)localObject2).toString();
        paramString = ((SQLiteDatabase)localObject1).query(str1, new String[] { str2, str3, str4, str5, str6, str7, str8, str9, str10, str11, str12, str13, str14, str15, str16, str17, str18, str19, str20, str21, str22, str23, str24, str25, str26, str27, str28, str29 }, paramString, null, null, null, (String)localObject2);
        if (paramString != null)
        {
          boolean bool = paramString.moveToFirst();
          if (bool) {
            for (;;)
            {
              localObject1 = new Log();
              ((Log)localObject1).getName(paramString.getString(0));
              ((Log)localObject1).read(paramString.getString(1));
              ((Log)localObject1).size(paramString.getString(2));
              ((Log)localObject1).trim(paramString.getString(3));
              ((Log)localObject1).split(paramString.getString(4));
              ((Log)localObject1).write(paramString.getString(5));
              ((Log)localObject1).execute(paramString.getString(6));
              ((Log)localObject1).v(paramString.getString(7));
              ((Log)localObject1).add(paramString.getString(8));
              ((Log)localObject1).log(paramString.getString(9));
              ((Log)localObject1).append(paramString.getString(10));
              ((Log)localObject1).valueOf(Boolean.parseBoolean(paramString.getString(11)));
              ((Log)localObject1).set(Boolean.parseBoolean(paramString.getString(12)));
              ((Log)localObject1).d(paramString.getString(13));
              ((Log)localObject1).add(Boolean.parseBoolean(paramString.getString(14)));
              ((Log)localObject1).print(paramString.getString(15));
              ((Log)localObject1).get(paramString.getString(16));
              ((Log)localObject1).next(paramString.getString(17));
              ((Log)localObject1).equals(paramString.getString(18));
              ((Log)localObject1).set(paramString.getString(19));
              ((Log)localObject1).start(paramString.getString(20));
              ((Log)localObject1).put(paramString.getString(21));
              ((Log)localObject1).update(paramString.getString(22));
              ((Log)localObject1).toString(paramString.getString(23));
              ((Log)localObject1).close(paramString.getString(24));
              ((Log)localObject1).w(paramString.getString(25));
              ((Log)localObject1).name(paramString.getString(26));
              ((Log)localObject1).format(paramString.getString(27));
              localArrayList.add(localObject1);
              bool = paramString.moveToNext();
              if (!bool) {
                break;
              }
            }
          }
          paramString.close();
        }
      }
      catch (Exception paramString)
      {
        k.a.a.m.StringBuilder.append(paramString);
      }
      append();
      return localArrayList;
    }
    catch (Throwable paramString)
    {
      throw paramString;
    }
  }
  
  public ArrayList doInBackground(ArrayList paramArrayList)
    throws SQLException
  {
    try
    {
      ArrayList localArrayList = new ArrayList();
      get();
      Object localObject1 = this$0;
      Object localObject2 = name;
      String str1 = c;
      String str2 = left;
      String str3 = a;
      String str4 = b;
      String str5 = directory;
      String str6 = cache;
      String str7 = logger;
      String str8 = helper;
      String str9 = this$1;
      String str10 = index;
      String str11 = key;
      String str12 = username;
      String str13 = date;
      String str14 = hash;
      String str15 = level;
      String str16 = y;
      String str17 = LOG;
      String str18 = TAG;
      String str19 = root;
      String str20 = $assertionsDisabled;
      String str21 = file;
      String str22 = type;
      String str23 = data;
      String str24 = text;
      try
      {
        Object localObject3 = new StringBuilder();
        String str25 = file;
        ((StringBuilder)localObject3).append(str25);
        ((StringBuilder)localObject3).append(" COLLATE NOCASE ASC");
        localObject3 = ((StringBuilder)localObject3).toString();
        localObject1 = ((SQLiteDatabase)localObject1).query((String)localObject2, new String[] { str1, str2, str3, str4, str5, str6, str7, str8, str9, str10, str11, str12, str13, str14, str15, str16, str17, str18, str19, str20, str21, str22, str23, str24 }, null, null, null, null, (String)localObject3);
        if (localObject1 != null)
        {
          boolean bool = ((Cursor)localObject1).moveToFirst();
          if (bool) {
            for (;;)
            {
              bool = paramArrayList.contains(((Cursor)localObject1).getString(0));
              if (!bool)
              {
                localObject2 = new O();
                ((O)localObject2).j(((Cursor)localObject1).getString(0));
                ((O)localObject2).n(((Cursor)localObject1).getString(1));
                ((O)localObject2).a(((Cursor)localObject1).getString(2));
                ((O)localObject2).k(((Cursor)localObject1).getString(3));
                ((O)localObject2).b(((Cursor)localObject1).getString(4));
                ((O)localObject2).c(((Cursor)localObject1).getString(5));
                ((O)localObject2).t(((Cursor)localObject1).getString(6));
                ((O)localObject2).w(((Cursor)localObject1).getString(7));
                ((O)localObject2).i(((Cursor)localObject1).getString(8));
                ((O)localObject2).d(((Cursor)localObject1).getString(9));
                ((O)localObject2).x(((Cursor)localObject1).getString(10));
                ((O)localObject2).q(((Cursor)localObject1).getString(11));
                ((O)localObject2).o(((Cursor)localObject1).getString(12));
                ((O)localObject2).p(((Cursor)localObject1).getString(13));
                ((O)localObject2).s(((Cursor)localObject1).getString(14));
                ((O)localObject2).e(((Cursor)localObject1).getString(15));
                ((O)localObject2).g(((Cursor)localObject1).getString(16));
                ((O)localObject2).f(((Cursor)localObject1).getString(17));
                ((O)localObject2).u(((Cursor)localObject1).getString(18));
                ((O)localObject2).r(((Cursor)localObject1).getString(19));
                ((O)localObject2).h(((Cursor)localObject1).getString(20));
                ((O)localObject2).v(((Cursor)localObject1).getString(21));
                ((O)localObject2).m(((Cursor)localObject1).getString(22));
                ((O)localObject2).l(((Cursor)localObject1).getString(23));
                localArrayList.add(localObject2);
              }
              bool = ((Cursor)localObject1).moveToNext();
              if (!bool) {
                break;
              }
            }
          }
          ((Cursor)localObject1).close();
        }
      }
      catch (Exception paramArrayList)
      {
        k.a.a.m.StringBuilder.append(paramArrayList);
      }
      append();
      return localArrayList;
    }
    catch (Throwable paramArrayList)
    {
      throw paramArrayList;
    }
  }
  
  public void doInBackground(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8, String paramString9, String paramString10, String paramString11, String paramString12, String paramString13, String paramString14, String paramString15, String paramString16, String paramString17, String paramString18, String paramString19, String paramString20, String paramString21, String paramString22, String paramString23, String paramString24)
  {
    try
    {
      get();
      try
      {
        ContentValues localContentValues = new ContentValues();
        String str = c;
        localContentValues.put(str, paramString1);
        paramString1 = left;
        localContentValues.put(paramString1, paramString2);
        paramString1 = a;
        localContentValues.put(paramString1, paramString3);
        paramString1 = b;
        localContentValues.put(paramString1, paramString4);
        paramString1 = directory;
        localContentValues.put(paramString1, paramString5);
        paramString1 = cache;
        localContentValues.put(paramString1, paramString6);
        paramString1 = logger;
        localContentValues.put(paramString1, paramString7);
        paramString1 = helper;
        localContentValues.put(paramString1, paramString8);
        paramString1 = this$1;
        localContentValues.put(paramString1, paramString9);
        paramString1 = index;
        localContentValues.put(paramString1, paramString10);
        paramString1 = key;
        localContentValues.put(paramString1, paramString11);
        paramString1 = username;
        localContentValues.put(paramString1, paramString12);
        paramString1 = date;
        localContentValues.put(paramString1, paramString13);
        paramString1 = hash;
        localContentValues.put(paramString1, paramString14);
        paramString1 = level;
        localContentValues.put(paramString1, paramString15);
        paramString1 = y;
        localContentValues.put(paramString1, paramString16);
        paramString1 = LOG;
        localContentValues.put(paramString1, paramString17);
        paramString1 = TAG;
        localContentValues.put(paramString1, paramString18);
        paramString1 = root;
        localContentValues.put(paramString1, paramString19);
        paramString1 = $assertionsDisabled;
        localContentValues.put(paramString1, paramString20);
        paramString1 = file;
        localContentValues.put(paramString1, paramString21);
        paramString1 = type;
        localContentValues.put(paramString1, paramString22);
        paramString1 = data;
        localContentValues.put(paramString1, paramString23);
        paramString1 = text;
        localContentValues.put(paramString1, paramString24);
        paramString1 = this$0;
        paramString2 = name;
        paramString1.insert(paramString2, null, localContentValues);
      }
      catch (Exception paramString1)
      {
        k.a.a.m.StringBuilder.append(paramString1);
      }
      append();
      return;
    }
    catch (Throwable paramString1)
    {
      throw paramString1;
    }
  }
  
  public ArrayList encode()
    throws SQLException
  {
    try
    {
      ArrayList localArrayList = new ArrayList();
      get();
      Object localObject1 = this$0;
      Object localObject2 = size;
      String str1 = c;
      String str2 = left;
      String str3 = a;
      String str4 = b;
      String str5 = TAG;
      String str6 = first;
      String str7 = length;
      String str8 = position;
      String str9 = root;
      String str10 = directory;
      String str11 = cache;
      String str12 = parent;
      String str13 = activity;
      String str14 = logger;
      String str15 = DEBUG;
      String str16 = helper;
      String str17 = this$1;
      String str18 = index;
      String str19 = key;
      String str20 = log;
      String str21 = queue;
      String str22 = LOG;
      String str23 = lock;
      String str24 = $assertionsDisabled;
      String str25 = level;
      String str26 = type;
      String str27 = data;
      String str28 = text;
      try
      {
        Object localObject3 = new StringBuilder();
        ((StringBuilder)localObject3).append("(");
        Object localObject4 = root;
        ((StringBuilder)localObject3).append((String)localObject4);
        ((StringBuilder)localObject3).append("!=\"99\" OR ");
        localObject4 = $assertionsDisabled;
        ((StringBuilder)localObject3).append((String)localObject4);
        ((StringBuilder)localObject3).append("!=\"\") AND ");
        localObject4 = type;
        ((StringBuilder)localObject3).append((String)localObject4);
        ((StringBuilder)localObject3).append("!=\"I\"");
        localObject3 = ((StringBuilder)localObject3).toString();
        localObject4 = new StringBuilder();
        String str29 = left;
        ((StringBuilder)localObject4).append(str29);
        ((StringBuilder)localObject4).append(" COLLATE NOCASE ASC");
        localObject4 = ((StringBuilder)localObject4).toString();
        localObject1 = ((SQLiteDatabase)localObject1).query((String)localObject2, new String[] { str1, str2, str3, str4, str5, str6, str7, str8, str9, str10, str11, str12, str13, str14, str15, str16, str17, str18, str19, str20, str21, str22, str23, str24, str25, str26, str27, str28 }, (String)localObject3, null, null, null, (String)localObject4);
        if (localObject1 != null)
        {
          boolean bool = ((Cursor)localObject1).moveToFirst();
          if (bool) {
            for (;;)
            {
              localObject2 = new Log();
              ((Log)localObject2).getName(((Cursor)localObject1).getString(0));
              ((Log)localObject2).read(((Cursor)localObject1).getString(1));
              ((Log)localObject2).size(((Cursor)localObject1).getString(2));
              ((Log)localObject2).trim(((Cursor)localObject1).getString(3));
              ((Log)localObject2).split(((Cursor)localObject1).getString(4));
              ((Log)localObject2).write(((Cursor)localObject1).getString(5));
              ((Log)localObject2).execute(((Cursor)localObject1).getString(6));
              ((Log)localObject2).v(((Cursor)localObject1).getString(7));
              ((Log)localObject2).add(((Cursor)localObject1).getString(8));
              ((Log)localObject2).log(((Cursor)localObject1).getString(9));
              ((Log)localObject2).append(((Cursor)localObject1).getString(10));
              ((Log)localObject2).valueOf(Boolean.parseBoolean(((Cursor)localObject1).getString(11)));
              ((Log)localObject2).set(Boolean.parseBoolean(((Cursor)localObject1).getString(12)));
              ((Log)localObject2).d(((Cursor)localObject1).getString(13));
              ((Log)localObject2).add(Boolean.parseBoolean(((Cursor)localObject1).getString(14)));
              ((Log)localObject2).print(((Cursor)localObject1).getString(15));
              ((Log)localObject2).get(((Cursor)localObject1).getString(16));
              ((Log)localObject2).next(((Cursor)localObject1).getString(17));
              ((Log)localObject2).equals(((Cursor)localObject1).getString(18));
              ((Log)localObject2).set(((Cursor)localObject1).getString(19));
              ((Log)localObject2).start(((Cursor)localObject1).getString(20));
              ((Log)localObject2).put(((Cursor)localObject1).getString(21));
              ((Log)localObject2).update(((Cursor)localObject1).getString(22));
              ((Log)localObject2).toString(((Cursor)localObject1).getString(23));
              ((Log)localObject2).close(((Cursor)localObject1).getString(24));
              ((Log)localObject2).w(((Cursor)localObject1).getString(25));
              ((Log)localObject2).name(((Cursor)localObject1).getString(26));
              ((Log)localObject2).format(((Cursor)localObject1).getString(27));
              localArrayList.add(localObject2);
              bool = ((Cursor)localObject1).moveToNext();
              if (!bool) {
                break;
              }
            }
          }
          ((Cursor)localObject1).close();
        }
      }
      catch (Exception localException)
      {
        k.a.a.m.StringBuilder.append(localException);
      }
      append();
      return localArrayList;
    }
    catch (Throwable localThrowable)
    {
      throw localThrowable;
    }
  }
  
  public String exec(String paramString)
    throws SQLException
  {
    String str2 = "";
    try
    {
      get();
      Object localObject = this$0;
      String str3 = URI;
      String str4 = out;
      String str1 = str2;
      try
      {
        StringBuilder localStringBuilder = new StringBuilder();
        String str5 = filter;
        str1 = str2;
        localStringBuilder.append(str5);
        str1 = str2;
        localStringBuilder.append("=\"");
        str1 = str2;
        localStringBuilder.append(paramString);
        str1 = str2;
        localStringBuilder.append("\"");
        str1 = str2;
        paramString = localStringBuilder.toString();
        str1 = str2;
        localObject = ((SQLiteDatabase)localObject).query(str3, new String[] { str4 }, paramString, null, null, null, null);
        paramString = str2;
        if (localObject != null)
        {
          str1 = str2;
          boolean bool = ((Cursor)localObject).moveToLast();
          paramString = str2;
          if (bool)
          {
            str1 = str2;
            paramString = ((Cursor)localObject).getString(0);
          }
          str1 = paramString;
          ((Cursor)localObject).close();
        }
      }
      catch (Exception paramString)
      {
        k.a.a.m.StringBuilder.append(paramString);
        paramString = str1;
      }
      append();
      return paramString;
    }
    catch (Throwable paramString)
    {
      throw paramString;
    }
  }
  
  public void exec()
  {
    try
    {
      get();
      SQLiteDatabase localSQLiteDatabase = this$0;
      String str = app;
      try
      {
        localSQLiteDatabase.delete(str, null, null);
      }
      catch (Exception localException)
      {
        k.a.a.m.StringBuilder.append(localException);
      }
      append();
      return;
    }
    catch (Throwable localThrowable)
    {
      throw localThrowable;
    }
  }
  
  public void execute(String paramString1, String paramString2)
  {
    try
    {
      get();
      try
      {
        ContentValues localContentValues = new ContentValues();
        String str1 = DEBUG;
        localContentValues.put(str1, paramString2);
        paramString2 = this$0;
        str1 = context;
        StringBuilder localStringBuilder = new StringBuilder();
        String str2 = c;
        localStringBuilder.append(str2);
        localStringBuilder.append("=\"");
        localStringBuilder.append(paramString1);
        localStringBuilder.append("\"");
        paramString2.update(str1, localContentValues, localStringBuilder.toString(), null);
      }
      catch (Exception paramString1)
      {
        k.a.a.m.StringBuilder.append(paramString1);
      }
      append();
      return;
    }
    catch (Throwable paramString1)
    {
      throw paramString1;
    }
  }
  
  public void exists(String paramString)
  {
    try
    {
      get();
      SQLiteDatabase localSQLiteDatabase = this$0;
      String str1 = name;
      try
      {
        StringBuilder localStringBuilder = new StringBuilder();
        String str2 = c;
        localStringBuilder.append(str2);
        localStringBuilder.append("=\"");
        localStringBuilder.append(paramString);
        localStringBuilder.append("\"");
        localSQLiteDatabase.delete(str1, localStringBuilder.toString(), null);
      }
      catch (Exception paramString)
      {
        k.a.a.m.StringBuilder.append(paramString);
      }
      append();
      return;
    }
    catch (Throwable paramString)
    {
      throw paramString;
    }
  }
  
  public ArrayList export()
    throws SQLException
  {
    try
    {
      ArrayList localArrayList = new ArrayList();
      get();
      Object localObject1 = this$0;
      Object localObject2 = adapter;
      String str1 = LOG_TAG;
      String str2 = g;
      String str3 = j;
      String str4 = l;
      String str5 = view;
      try
      {
        localObject1 = ((SQLiteDatabase)localObject1).query((String)localObject2, new String[] { str1, str2, str3, str4, str5 }, null, null, null, null, null);
        if (localObject1 != null)
        {
          boolean bool = ((Cursor)localObject1).moveToFirst();
          if (bool) {
            do
            {
              localObject2 = new d();
              ((d)localObject2).e(((Cursor)localObject1).getString(0));
              ((d)localObject2).a(((Cursor)localObject1).getString(1));
              ((d)localObject2).b(((Cursor)localObject1).getString(2));
              ((d)localObject2).d(((Cursor)localObject1).getString(3));
              ((d)localObject2).c(((Cursor)localObject1).getString(4));
              localArrayList.add(localObject2);
              bool = ((Cursor)localObject1).moveToNext();
            } while (bool);
          }
          ((Cursor)localObject1).close();
        }
      }
      catch (Exception localException)
      {
        k.a.a.m.StringBuilder.append(localException);
      }
      append();
      return localArrayList;
    }
    catch (Throwable localThrowable)
    {
      throw localThrowable;
    }
  }
  
  public ArrayList export(String paramString1, String paramString2)
    throws SQLException
  {
    try
    {
      ArrayList localArrayList = new ArrayList();
      get();
      SQLiteDatabase localSQLiteDatabase = this$0;
      String str1 = p;
      String str2 = h;
      try
      {
        StringBuilder localStringBuilder = new StringBuilder();
        String str3 = x;
        localStringBuilder.append(str3);
        localStringBuilder.append("=\"");
        localStringBuilder.append(paramString1);
        localStringBuilder.append("\" AND ");
        paramString1 = q;
        localStringBuilder.append(paramString1);
        localStringBuilder.append("=\"");
        localStringBuilder.append(paramString2);
        localStringBuilder.append("\"");
        paramString1 = localStringBuilder.toString();
        paramString1 = localSQLiteDatabase.query(str1, new String[] { str2 }, paramString1, null, null, null, null);
        if (paramString1 != null)
        {
          boolean bool = paramString1.moveToFirst();
          if (bool) {
            do
            {
              localArrayList.add(paramString1.getString(0));
              bool = paramString1.moveToNext();
            } while (bool);
          }
          paramString1.close();
        }
      }
      catch (Exception paramString1)
      {
        k.a.a.m.StringBuilder.append(paramString1);
      }
      append();
      return localArrayList;
    }
    catch (Throwable paramString1)
    {
      throw paramString1;
    }
  }
  
  public void export(String paramString)
  {
    try
    {
      get();
      try
      {
        Object localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("keywordName......");
        ((StringBuilder)localObject1).append(paramString);
        ((StringBuilder)localObject1).toString();
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("select * from ");
        Object localObject2 = app;
        ((StringBuilder)localObject1).append((String)localObject2);
        localObject1 = ((StringBuilder)localObject1).toString();
        localObject2 = this$0;
        localObject1 = ((SQLiteDatabase)localObject2).rawQuery((String)localObject1, null);
        if (localObject1 != null)
        {
          boolean bool = ((Cursor)localObject1).moveToFirst();
          Object localObject3;
          Object localObject4;
          Object localObject5;
          if (bool) {
            do
            {
              bool = ((Cursor)localObject1).getString(1).equalsIgnoreCase(paramString);
              if (bool)
              {
                localObject2 = this$0;
                localObject3 = app;
                localObject4 = new StringBuilder();
                localObject5 = title;
                ((StringBuilder)localObject4).append((String)localObject5);
                ((StringBuilder)localObject4).append("=\"");
                ((StringBuilder)localObject4).append(paramString);
                ((StringBuilder)localObject4).append("\"");
                ((SQLiteDatabase)localObject2).delete((String)localObject3, ((StringBuilder)localObject4).toString(), null);
              }
              bool = ((Cursor)localObject1).moveToNext();
            } while (bool);
          }
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("COUNT : ");
          ((StringBuilder)localObject2).append(((Cursor)localObject1).getCount());
          ((StringBuilder)localObject2).toString();
          int k = ((Cursor)localObject1).getCount();
          if (k < 5)
          {
            localObject2 = new ContentValues();
            localObject3 = title;
            ((ContentValues)localObject2).put((String)localObject3, paramString);
            paramString = this$0;
            localObject3 = app;
            paramString.insert((String)localObject3, null, (ContentValues)localObject2);
          }
          else
          {
            bool = ((Cursor)localObject1).moveToFirst();
            if (bool)
            {
              localObject2 = ((Cursor)localObject1).getString(1);
              localObject3 = this$0;
              localObject4 = app;
              localObject5 = new StringBuilder();
              String str = title;
              ((StringBuilder)localObject5).append(str);
              ((StringBuilder)localObject5).append("=\"");
              ((StringBuilder)localObject5).append((String)localObject2);
              ((StringBuilder)localObject5).append("\"");
              ((SQLiteDatabase)localObject3).delete((String)localObject4, ((StringBuilder)localObject5).toString(), null);
              localObject2 = new ContentValues();
              localObject3 = title;
              ((ContentValues)localObject2).put((String)localObject3, paramString);
              paramString = this$0;
              localObject3 = app;
              paramString.insert((String)localObject3, null, (ContentValues)localObject2);
            }
          }
          ((Cursor)localObject1).close();
        }
      }
      catch (Exception paramString)
      {
        k.a.a.m.StringBuilder.append(paramString);
      }
      append();
      return;
    }
    catch (Throwable paramString)
    {
      throw paramString;
    }
  }
  
  public void flush(String paramString1, String paramString2)
  {
    try
    {
      get();
      try
      {
        ContentValues localContentValues = new ContentValues();
        String str1 = parent;
        localContentValues.put(str1, paramString2);
        paramString2 = this$0;
        str1 = context;
        StringBuilder localStringBuilder = new StringBuilder();
        String str2 = c;
        localStringBuilder.append(str2);
        localStringBuilder.append("=\"");
        localStringBuilder.append(paramString1);
        localStringBuilder.append("\"");
        paramString2.update(str1, localContentValues, localStringBuilder.toString(), null);
      }
      catch (Exception paramString1)
      {
        k.a.a.m.StringBuilder.append(paramString1);
      }
      append();
      return;
    }
    catch (Throwable paramString1)
    {
      throw paramString1;
    }
  }
  
  public void generate()
  {
    try
    {
      get();
      SQLiteDatabase localSQLiteDatabase = this$0;
      String str = i;
      try
      {
        localSQLiteDatabase.delete(str, null, null);
      }
      catch (Exception localException)
      {
        k.a.a.m.StringBuilder.append(localException);
      }
      append();
      return;
    }
    catch (Throwable localThrowable)
    {
      throw localThrowable;
    }
  }
  
  public SQLiteDatabase get()
  {
    try
    {
      currentIndex += 1;
      int k = currentIndex;
      if (k == 1)
      {
        Object localObject = instance;
        try
        {
          localObject = ((SQLiteOpenHelper)localObject).getWritableDatabase();
          this$0 = ((SQLiteDatabase)localObject);
        }
        catch (Exception localException)
        {
          k.a.a.m.StringBuilder.append(localException);
        }
      }
      SQLiteDatabase localSQLiteDatabase = this$0;
      return localSQLiteDatabase;
    }
    catch (Throwable localThrowable)
    {
      throw localThrowable;
    }
  }
  
  public String get(String paramString)
    throws SQLException
  {
    String str2 = "en";
    try
    {
      get();
      Object localObject = this$0;
      String str3 = context;
      String str4 = log;
      String str1 = str2;
      try
      {
        StringBuilder localStringBuilder = new StringBuilder();
        String str5 = c;
        str1 = str2;
        localStringBuilder.append(str5);
        str1 = str2;
        localStringBuilder.append("=\"");
        str1 = str2;
        localStringBuilder.append(paramString);
        str1 = str2;
        localStringBuilder.append("\"");
        str1 = str2;
        paramString = localStringBuilder.toString();
        str1 = str2;
        localObject = ((SQLiteDatabase)localObject).query(str3, new String[] { str4 }, paramString, null, null, null, null);
        paramString = str2;
        if (localObject != null)
        {
          str1 = str2;
          boolean bool = ((Cursor)localObject).moveToFirst();
          paramString = str2;
          if (bool)
          {
            str1 = str2;
            paramString = ((Cursor)localObject).getString(0);
          }
          str1 = paramString;
          ((Cursor)localObject).close();
        }
      }
      catch (Exception paramString)
      {
        k.a.a.m.StringBuilder.append(paramString);
        paramString = str1;
      }
      append();
      return paramString;
    }
    catch (Throwable paramString)
    {
      throw paramString;
    }
  }
  
  public ArrayList getAllSms()
    throws SQLException
  {
    try
    {
      ArrayList localArrayList = new ArrayList();
      get();
      Object localObject = this$0;
      String str1 = CONTENT_URI;
      String str2 = title;
      try
      {
        localObject = ((SQLiteDatabase)localObject).query(str1, new String[] { str2 }, null, null, null, null, null);
        if (localObject != null)
        {
          boolean bool = ((Cursor)localObject).moveToLast();
          if (bool) {
            do
            {
              localArrayList.add(((Cursor)localObject).getString(0));
              bool = ((Cursor)localObject).moveToPrevious();
            } while (bool);
          }
          ((Cursor)localObject).close();
        }
      }
      catch (Exception localException)
      {
        k.a.a.m.StringBuilder.append(localException);
      }
      append();
      return localArrayList;
    }
    catch (Throwable localThrowable)
    {
      throw localThrowable;
    }
  }
  
  public void getContext()
  {
    try
    {
      get();
      SQLiteDatabase localSQLiteDatabase = this$0;
      String str = context;
      try
      {
        localSQLiteDatabase.delete(str, null, null);
      }
      catch (Exception localException)
      {
        k.a.a.m.StringBuilder.append(localException);
      }
      append();
      return;
    }
    catch (Throwable localThrowable)
    {
      throw localThrowable;
    }
  }
  
  public ArrayList getHistory()
    throws SQLException
  {
    try
    {
      ArrayList localArrayList = new ArrayList();
      get();
      Object localObject1 = this$0;
      Object localObject2 = context;
      String str1 = c;
      String str2 = left;
      String str3 = b;
      String str4 = DEBUG;
      try
      {
        Object localObject3 = new StringBuilder();
        String str5 = left;
        ((StringBuilder)localObject3).append(str5);
        ((StringBuilder)localObject3).append(" COLLATE NOCASE ASC");
        localObject3 = ((StringBuilder)localObject3).toString();
        localObject1 = ((SQLiteDatabase)localObject1).query((String)localObject2, new String[] { str1, str2, str3, str4 }, null, null, null, null, (String)localObject3);
        if (localObject1 != null)
        {
          boolean bool = ((Cursor)localObject1).moveToFirst();
          if (bool) {
            do
            {
              localObject2 = new A();
              ((A)localObject2).a(((Cursor)localObject1).getString(0));
              ((A)localObject2).c(((Cursor)localObject1).getString(1));
              ((A)localObject2).b(((Cursor)localObject1).getString(2));
              ((A)localObject2).a(Boolean.parseBoolean(((Cursor)localObject1).getString(3)));
              localArrayList.add(localObject2);
              bool = ((Cursor)localObject1).moveToNext();
            } while (bool);
          }
          ((Cursor)localObject1).close();
        }
      }
      catch (Exception localException)
      {
        k.a.a.m.StringBuilder.append(localException);
      }
      append();
      return localArrayList;
    }
    catch (Throwable localThrowable)
    {
      throw localThrowable;
    }
  }
  
  public ArrayList getItems()
    throws SQLException
  {
    try
    {
      ArrayList localArrayList = new ArrayList();
      get();
      Object localObject = this$0;
      String str1 = context;
      String str2 = c;
      try
      {
        localObject = ((SQLiteDatabase)localObject).query(str1, new String[] { str2 }, null, null, null, null, null);
        if (localObject != null)
        {
          boolean bool = ((Cursor)localObject).moveToFirst();
          if (bool) {
            do
            {
              localArrayList.add(((Cursor)localObject).getString(0));
              bool = ((Cursor)localObject).moveToNext();
            } while (bool);
          }
          ((Cursor)localObject).close();
        }
      }
      catch (Exception localException)
      {
        k.a.a.m.StringBuilder.append(localException);
      }
      append();
      return localArrayList;
    }
    catch (Throwable localThrowable)
    {
      throw localThrowable;
    }
  }
  
  public ArrayList getList()
    throws SQLException
  {
    try
    {
      ArrayList localArrayList = new ArrayList();
      get();
      Object localObject1 = this$0;
      Object localObject2 = size;
      Object localObject3 = text;
      Object localObject4 = data;
      Object localObject5 = text;
      try
      {
        Object localObject6 = new StringBuilder();
        String str = text;
        ((StringBuilder)localObject6).append(str);
        ((StringBuilder)localObject6).append(" COLLATE NOCASE ASC");
        localObject6 = ((StringBuilder)localObject6).toString();
        localObject1 = ((SQLiteDatabase)localObject1).query(true, (String)localObject2, new String[] { localObject3, localObject4 }, null, null, (String)localObject5, null, (String)localObject6, null);
        if (localObject1 != null)
        {
          boolean bool = ((Cursor)localObject1).moveToFirst();
          if (bool)
          {
            localObject2 = new ArrayList();
            do
            {
              localObject3 = ((Cursor)localObject1).getString(0).split(",");
              localObject4 = ((Cursor)localObject1).getString(1).split(",");
              if (localObject4.length == localObject3.length)
              {
                int k = 0;
                while (k < localObject4.length)
                {
                  localObject5 = localObject4[k];
                  bool = ((ArrayList)localObject2).contains(localObject5);
                  if (!bool)
                  {
                    localObject5 = localObject4[k];
                    ((ArrayList)localObject2).add(localObject5);
                    localObject5 = new N();
                    localObject6 = localObject3[k];
                    ((N)localObject5).b((String)localObject6);
                    localObject6 = localObject4[k];
                    ((N)localObject5).a((String)localObject6);
                    localArrayList.add(localObject5);
                  }
                  k += 1;
                }
              }
              bool = ((Cursor)localObject1).moveToNext();
            } while (bool);
          }
          ((Cursor)localObject1).close();
        }
      }
      catch (Exception localException)
      {
        k.a.a.m.StringBuilder.append(localException);
      }
      append();
      return localArrayList;
    }
    catch (Throwable localThrowable)
    {
      throw localThrowable;
    }
  }
  
  public String getPath(String paramString)
    throws SQLException
  {
    String str2 = "";
    try
    {
      get();
      Object localObject = this$0;
      String str3 = cursor;
      String str4 = uri;
      String str1 = str2;
      try
      {
        StringBuilder localStringBuilder = new StringBuilder();
        String str5 = path;
        str1 = str2;
        localStringBuilder.append(str5);
        str1 = str2;
        localStringBuilder.append("=\"");
        str1 = str2;
        localStringBuilder.append(paramString);
        str1 = str2;
        localStringBuilder.append("\"");
        str1 = str2;
        paramString = localStringBuilder.toString();
        str1 = str2;
        localObject = ((SQLiteDatabase)localObject).query(str3, new String[] { str4 }, paramString, null, null, null, null);
        paramString = str2;
        if (localObject != null)
        {
          str1 = str2;
          boolean bool = ((Cursor)localObject).moveToFirst();
          paramString = str2;
          if (bool)
          {
            str1 = str2;
            paramString = ((Cursor)localObject).getString(0);
          }
          str1 = paramString;
          ((Cursor)localObject).close();
        }
      }
      catch (Exception paramString)
      {
        k.a.a.m.StringBuilder.append(paramString);
        paramString = str1;
      }
      append();
      return paramString;
    }
    catch (Throwable paramString)
    {
      throw paramString;
    }
  }
  
  public ArrayList getPlaylists()
    throws SQLException
  {
    try
    {
      ArrayList localArrayList = new ArrayList();
      get();
      Object localObject1 = this$0;
      Object localObject2 = size;
      String str1 = TAG;
      String str2 = LOG;
      String str3 = TAG;
      try
      {
        Object localObject3 = new StringBuilder();
        String str4 = TAG;
        ((StringBuilder)localObject3).append(str4);
        ((StringBuilder)localObject3).append(" COLLATE NOCASE ASC");
        localObject3 = ((StringBuilder)localObject3).toString();
        localObject1 = ((SQLiteDatabase)localObject1).query(true, (String)localObject2, new String[] { str1, str2 }, null, null, str3, null, (String)localObject3, null);
        if (localObject1 != null)
        {
          boolean bool = ((Cursor)localObject1).moveToFirst();
          if (bool) {
            do
            {
              localObject2 = new N();
              ((N)localObject2).b(((Cursor)localObject1).getString(0));
              ((N)localObject2).a(((Cursor)localObject1).getString(1));
              localArrayList.add(localObject2);
              bool = ((Cursor)localObject1).moveToNext();
            } while (bool);
          }
          ((Cursor)localObject1).close();
        }
      }
      catch (Exception localException)
      {
        k.a.a.m.StringBuilder.append(localException);
      }
      append();
      return localArrayList;
    }
    catch (Throwable localThrowable)
    {
      throw localThrowable;
    }
  }
  
  public void getProxy()
  {
    try
    {
      get();
      SQLiteDatabase localSQLiteDatabase = this$0;
      String str = size;
      try
      {
        localSQLiteDatabase.delete(str, null, null);
      }
      catch (Exception localException)
      {
        k.a.a.m.StringBuilder.append(localException);
      }
      append();
      return;
    }
    catch (Throwable localThrowable)
    {
      throw localThrowable;
    }
  }
  
  public String getServer(String paramString)
    throws SQLException
  {
    String str2 = "en";
    try
    {
      get();
      Object localObject = this$0;
      String str3 = context;
      String str4 = position;
      String str1 = str2;
      try
      {
        StringBuilder localStringBuilder = new StringBuilder();
        String str5 = c;
        str1 = str2;
        localStringBuilder.append(str5);
        str1 = str2;
        localStringBuilder.append("=\"");
        str1 = str2;
        localStringBuilder.append(paramString);
        str1 = str2;
        localStringBuilder.append("\"");
        str1 = str2;
        paramString = localStringBuilder.toString();
        str1 = str2;
        localObject = ((SQLiteDatabase)localObject).query(str3, new String[] { str4 }, paramString, null, null, null, null);
        paramString = str2;
        if (localObject != null)
        {
          str1 = str2;
          boolean bool = ((Cursor)localObject).moveToFirst();
          paramString = str2;
          if (bool)
          {
            str1 = str2;
            paramString = ((Cursor)localObject).getString(0);
          }
          str1 = paramString;
          ((Cursor)localObject).close();
        }
      }
      catch (Exception paramString)
      {
        k.a.a.m.StringBuilder.append(paramString);
        paramString = str1;
      }
      append();
      return paramString;
    }
    catch (Throwable paramString)
    {
      throw paramString;
    }
  }
  
  public void getServer()
  {
    try
    {
      get();
      SQLiteDatabase localSQLiteDatabase = this$0;
      String str = context;
      try
      {
        localSQLiteDatabase.delete(str, null, null);
      }
      catch (Exception localException)
      {
        k.a.a.m.StringBuilder.append(localException);
      }
      append();
      return;
    }
    catch (Throwable localThrowable)
    {
      throw localThrowable;
    }
  }
  
  public void getSettings()
  {
    try
    {
      get();
      try
      {
        ContentValues localContentValues = new ContentValues();
        Object localObject = parent;
        localContentValues.put((String)localObject, "false");
        localObject = this$0;
        String str1 = context;
        StringBuilder localStringBuilder = new StringBuilder();
        String str2 = parent;
        localStringBuilder.append(str2);
        localStringBuilder.append("=\"true\"");
        ((SQLiteDatabase)localObject).update(str1, localContentValues, localStringBuilder.toString(), null);
      }
      catch (Exception localException)
      {
        k.a.a.m.StringBuilder.append(localException);
      }
      append();
      return;
    }
    catch (Throwable localThrowable)
    {
      throw localThrowable;
    }
  }
  
  public ArrayList getSongs()
    throws SQLException
  {
    try
    {
      ArrayList localArrayList = new ArrayList();
      get();
      Object localObject = this$0;
      String str1 = size;
      String str2 = c;
      try
      {
        localObject = ((SQLiteDatabase)localObject).query(str1, new String[] { str2 }, null, null, null, null, null);
        if (localObject != null)
        {
          boolean bool = ((Cursor)localObject).moveToFirst();
          if (bool) {
            do
            {
              localArrayList.add(((Cursor)localObject).getString(0));
              bool = ((Cursor)localObject).moveToNext();
            } while (bool);
          }
          ((Cursor)localObject).close();
        }
      }
      catch (Exception localException)
      {
        k.a.a.m.StringBuilder.append(localException);
      }
      append();
      return localArrayList;
    }
    catch (Throwable localThrowable)
    {
      throw localThrowable;
    }
  }
  
  public String getStatus(String paramString)
    throws SQLException
  {
    String str2 = "";
    try
    {
      get();
      String str1 = str2;
      try
      {
        Object localObject = new StringBuilder();
        str1 = str2;
        ((StringBuilder)localObject).append("select * from ");
        String str3 = r;
        str1 = str2;
        ((StringBuilder)localObject).append(str3);
        str1 = str2;
        ((StringBuilder)localObject).append(" where ");
        str3 = t;
        str1 = str2;
        ((StringBuilder)localObject).append(str3);
        str1 = str2;
        ((StringBuilder)localObject).append(" = 'false' AND ");
        str3 = x;
        str1 = str2;
        ((StringBuilder)localObject).append(str3);
        str1 = str2;
        ((StringBuilder)localObject).append(" = '");
        str1 = str2;
        ((StringBuilder)localObject).append(paramString);
        str1 = str2;
        ((StringBuilder)localObject).append("'");
        str1 = str2;
        paramString = ((StringBuilder)localObject).toString();
        localObject = this$0;
        str1 = str2;
        localObject = ((SQLiteDatabase)localObject).rawQuery(paramString, null);
        paramString = str2;
        if (localObject != null)
        {
          str1 = str2;
          paramString = new StringBuilder();
          str1 = str2;
          paramString.append("");
          str1 = str2;
          paramString.append(((Cursor)localObject).getCount());
          str1 = str2;
          paramString = paramString.toString();
          str1 = paramString;
          ((Cursor)localObject).close();
        }
      }
      catch (Exception paramString)
      {
        k.a.a.m.StringBuilder.append(paramString);
        paramString = str1;
      }
      append();
      return paramString;
    }
    catch (Throwable paramString)
    {
      throw paramString;
    }
  }
  
  public ArrayList getValue()
    throws SQLException
  {
    try
    {
      ArrayList localArrayList = new ArrayList();
      get();
      Object localObject1 = this$0;
      Object localObject2 = context;
      Object localObject3 = text;
      Object localObject4 = data;
      Object localObject5 = text;
      try
      {
        Object localObject6 = new StringBuilder();
        String str = text;
        ((StringBuilder)localObject6).append(str);
        ((StringBuilder)localObject6).append(" COLLATE NOCASE ASC");
        localObject6 = ((StringBuilder)localObject6).toString();
        localObject1 = ((SQLiteDatabase)localObject1).query(true, (String)localObject2, new String[] { localObject3, localObject4 }, null, null, (String)localObject5, null, (String)localObject6, null);
        if (localObject1 != null)
        {
          boolean bool = ((Cursor)localObject1).moveToFirst();
          if (bool)
          {
            localObject2 = new ArrayList();
            do
            {
              localObject3 = new StringBuilder();
              ((StringBuilder)localObject3).append("c.getString(0)............");
              ((StringBuilder)localObject3).append(((Cursor)localObject1).getString(0));
              ((StringBuilder)localObject3).toString();
              localObject3 = new StringBuilder();
              ((StringBuilder)localObject3).append("c.getString(1)............");
              ((StringBuilder)localObject3).append(((Cursor)localObject1).getString(1));
              ((StringBuilder)localObject3).toString();
              localObject3 = ((Cursor)localObject1).getString(0).split(",");
              localObject4 = ((Cursor)localObject1).getString(1).split(",");
              if (localObject4.length == localObject3.length)
              {
                int k = 0;
                while (k < localObject4.length)
                {
                  localObject5 = localObject4[k];
                  bool = ((ArrayList)localObject2).contains(localObject5);
                  if (!bool)
                  {
                    localObject5 = localObject4[k];
                    ((ArrayList)localObject2).add(localObject5);
                    localObject5 = new N();
                    localObject6 = localObject3[k];
                    ((N)localObject5).b((String)localObject6);
                    localObject6 = localObject4[k];
                    ((N)localObject5).a((String)localObject6);
                    localArrayList.add(localObject5);
                  }
                  k += 1;
                }
              }
              bool = ((Cursor)localObject1).moveToNext();
            } while (bool);
          }
          ((Cursor)localObject1).close();
          localObject1 = new a(this);
          localObject1 = (Comparator)localObject1;
          Collections.sort(localArrayList, (Comparator)localObject1);
        }
      }
      catch (Exception localException)
      {
        k.a.a.m.StringBuilder.append(localException);
      }
      append();
      return localArrayList;
    }
    catch (Throwable localThrowable)
    {
      throw localThrowable;
    }
  }
  
  public String init(String paramString)
    throws SQLException
  {
    String str2 = "";
    try
    {
      get();
      Object localObject1 = this$0;
      String str3 = context;
      String str4 = c;
      String str5 = left;
      String str6 = a;
      String str7 = b;
      String str8 = TAG;
      String str9 = first;
      String str10 = length;
      String str11 = position;
      String str12 = root;
      String str13 = directory;
      String str14 = cache;
      String str15 = parent;
      String str16 = activity;
      String str17 = logger;
      String str18 = DEBUG;
      String str19 = helper;
      String str20 = this$1;
      String str21 = index;
      String str22 = key;
      String str23 = log;
      String str24 = queue;
      String str25 = LOG;
      String str26 = lock;
      String str27 = $assertionsDisabled;
      String str28 = level;
      String str29 = type;
      String str30 = file;
      String str31 = data;
      String str32 = text;
      String str1 = str2;
      try
      {
        Object localObject2 = new StringBuilder();
        str1 = str2;
        ((StringBuilder)localObject2).append("(");
        String str33 = root;
        str1 = str2;
        ((StringBuilder)localObject2).append(str33);
        str1 = str2;
        ((StringBuilder)localObject2).append("=\"");
        str1 = str2;
        ((StringBuilder)localObject2).append(paramString);
        str1 = str2;
        ((StringBuilder)localObject2).append("\" OR ");
        str33 = $assertionsDisabled;
        str1 = str2;
        ((StringBuilder)localObject2).append(str33);
        str1 = str2;
        ((StringBuilder)localObject2).append(" LIKE '%|");
        str1 = str2;
        ((StringBuilder)localObject2).append(paramString);
        str1 = str2;
        ((StringBuilder)localObject2).append("|%') AND ");
        paramString = type;
        str1 = str2;
        ((StringBuilder)localObject2).append(paramString);
        str1 = str2;
        ((StringBuilder)localObject2).append("!=\"I\"");
        str1 = str2;
        paramString = ((StringBuilder)localObject2).toString();
        str1 = str2;
        localObject2 = new StringBuilder();
        str33 = left;
        str1 = str2;
        ((StringBuilder)localObject2).append(str33);
        str1 = str2;
        ((StringBuilder)localObject2).append(" COLLATE NOCASE ASC");
        str1 = str2;
        localObject2 = ((StringBuilder)localObject2).toString();
        str1 = str2;
        localObject1 = ((SQLiteDatabase)localObject1).query(str3, new String[] { str4, str5, str6, str7, str8, str9, str10, str11, str12, str13, str14, str15, str16, str17, str18, str19, str20, str21, str22, str23, str24, str25, str26, str27, str28, str29, str30, str31, str32 }, paramString, null, null, null, (String)localObject2);
        paramString = str2;
        if (localObject1 != null)
        {
          str1 = str2;
          paramString = new StringBuilder();
          str1 = str2;
          paramString.append("");
          str1 = str2;
          paramString.append(((Cursor)localObject1).getCount());
          str1 = str2;
          paramString = paramString.toString();
          str1 = paramString;
          ((Cursor)localObject1).close();
        }
      }
      catch (Exception paramString)
      {
        k.a.a.m.StringBuilder.append(paramString);
        paramString = str1;
      }
      append();
      return paramString;
    }
    catch (Throwable paramString)
    {
      throw paramString;
    }
  }
  
  public ArrayList init()
    throws SQLException
  {
    try
    {
      ArrayList localArrayList = new ArrayList();
      get();
      Object localObject1 = this$0;
      Object localObject2 = context;
      String str1 = c;
      String str2 = left;
      String str3 = a;
      String str4 = b;
      String str5 = TAG;
      String str6 = first;
      String str7 = length;
      String str8 = position;
      String str9 = root;
      String str10 = directory;
      String str11 = cache;
      String str12 = parent;
      String str13 = activity;
      String str14 = logger;
      String str15 = DEBUG;
      String str16 = helper;
      String str17 = this$1;
      String str18 = index;
      String str19 = key;
      String str20 = log;
      String str21 = queue;
      String str22 = LOG;
      String str23 = lock;
      String str24 = $assertionsDisabled;
      String str25 = level;
      String str26 = type;
      String str27 = file;
      String str28 = data;
      String str29 = text;
      try
      {
        Object localObject3 = new StringBuilder();
        ((StringBuilder)localObject3).append("(");
        Object localObject4 = root;
        ((StringBuilder)localObject3).append((String)localObject4);
        ((StringBuilder)localObject3).append("!=\"99\" OR ");
        localObject4 = $assertionsDisabled;
        ((StringBuilder)localObject3).append((String)localObject4);
        ((StringBuilder)localObject3).append("!=\"\") AND ");
        localObject4 = type;
        ((StringBuilder)localObject3).append((String)localObject4);
        ((StringBuilder)localObject3).append("!=\"I\"");
        localObject3 = ((StringBuilder)localObject3).toString();
        localObject4 = new StringBuilder();
        String str30 = left;
        ((StringBuilder)localObject4).append(str30);
        ((StringBuilder)localObject4).append(" COLLATE NOCASE ASC");
        localObject4 = ((StringBuilder)localObject4).toString();
        localObject1 = ((SQLiteDatabase)localObject1).query((String)localObject2, new String[] { str1, str2, str3, str4, str5, str6, str7, str8, str9, str10, str11, str12, str13, str14, str15, str16, str17, str18, str19, str20, str21, str22, str23, str24, str25, str26, str27, str28, str29 }, (String)localObject3, null, null, null, (String)localObject4);
        if (localObject1 != null)
        {
          boolean bool = ((Cursor)localObject1).moveToFirst();
          if (bool) {
            for (;;)
            {
              localObject2 = new Log();
              ((Log)localObject2).getName(((Cursor)localObject1).getString(0));
              ((Log)localObject2).read(((Cursor)localObject1).getString(1));
              ((Log)localObject2).size(((Cursor)localObject1).getString(2));
              ((Log)localObject2).trim(((Cursor)localObject1).getString(3));
              ((Log)localObject2).split(((Cursor)localObject1).getString(4));
              ((Log)localObject2).write(((Cursor)localObject1).getString(5));
              ((Log)localObject2).execute(((Cursor)localObject1).getString(6));
              ((Log)localObject2).v(((Cursor)localObject1).getString(7));
              ((Log)localObject2).add(((Cursor)localObject1).getString(8));
              ((Log)localObject2).log(((Cursor)localObject1).getString(9));
              ((Log)localObject2).append(((Cursor)localObject1).getString(10));
              ((Log)localObject2).valueOf(Boolean.parseBoolean(((Cursor)localObject1).getString(11)));
              ((Log)localObject2).set(Boolean.parseBoolean(((Cursor)localObject1).getString(12)));
              ((Log)localObject2).d(((Cursor)localObject1).getString(13));
              ((Log)localObject2).add(Boolean.parseBoolean(((Cursor)localObject1).getString(14)));
              ((Log)localObject2).print(((Cursor)localObject1).getString(15));
              ((Log)localObject2).get(((Cursor)localObject1).getString(16));
              ((Log)localObject2).next(((Cursor)localObject1).getString(17));
              ((Log)localObject2).equals(((Cursor)localObject1).getString(18));
              ((Log)localObject2).set(((Cursor)localObject1).getString(19));
              ((Log)localObject2).start(((Cursor)localObject1).getString(20));
              ((Log)localObject2).put(((Cursor)localObject1).getString(21));
              ((Log)localObject2).update(((Cursor)localObject1).getString(22));
              ((Log)localObject2).toString(((Cursor)localObject1).getString(23));
              ((Log)localObject2).close(((Cursor)localObject1).getString(24));
              ((Log)localObject2).w(((Cursor)localObject1).getString(25));
              ((Log)localObject2).e(((Cursor)localObject1).getString(26));
              ((Log)localObject2).name(((Cursor)localObject1).getString(27));
              ((Log)localObject2).format(((Cursor)localObject1).getString(28));
              localArrayList.add(localObject2);
              bool = ((Cursor)localObject1).moveToNext();
              if (!bool) {
                break;
              }
            }
          }
          ((Cursor)localObject1).close();
        }
      }
      catch (Exception localException)
      {
        k.a.a.m.StringBuilder.append(localException);
      }
      append();
      return localArrayList;
    }
    catch (Throwable localThrowable)
    {
      throw localThrowable;
    }
  }
  
  public void init(String paramString1, String paramString2)
  {
    try
    {
      get();
      try
      {
        ContentValues localContentValues = new ContentValues();
        String str1 = TYPE;
        localContentValues.put(str1, paramString2);
        paramString2 = this$0;
        str1 = r;
        StringBuilder localStringBuilder = new StringBuilder();
        String str2 = w;
        localStringBuilder.append(str2);
        localStringBuilder.append("=\"");
        localStringBuilder.append(paramString1);
        localStringBuilder.append("\"");
        paramString2.update(str1, localContentValues, localStringBuilder.toString(), null);
      }
      catch (Exception paramString1)
      {
        k.a.a.m.StringBuilder.append(paramString1);
      }
      append();
      return;
    }
    catch (Throwable paramString1)
    {
      throw paramString1;
    }
  }
  
  public void init(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7)
  {
    try
    {
      get();
      try
      {
        ContentValues localContentValues = new ContentValues();
        String str = db;
        localContentValues.put(str, paramString2);
        paramString2 = url;
        localContentValues.put(paramString2, paramString3);
        paramString2 = contentType;
        localContentValues.put(paramString2, paramString4);
        paramString2 = filename;
        localContentValues.put(paramString2, paramString5);
        paramString2 = separator;
        localContentValues.put(paramString2, paramString6);
        paramString2 = INSTANCE;
        localContentValues.put(paramString2, paramString7);
        paramString2 = this$0;
        paramString3 = URI;
        paramString4 = new StringBuilder();
        paramString5 = out;
        paramString4.append(paramString5);
        paramString4.append("=\"");
        paramString4.append(paramString1);
        paramString4.append("\"");
        paramString2.update(paramString3, localContentValues, paramString4.toString(), null);
      }
      catch (Exception paramString1)
      {
        k.a.a.m.StringBuilder.append(paramString1);
      }
      append();
      return;
    }
    catch (Throwable paramString1)
    {
      throw paramString1;
    }
  }
  
  public ArrayList initialize()
    throws SQLException
  {
    try
    {
      ArrayList localArrayList = new ArrayList();
      get();
      Object localObject1 = this$0;
      Object localObject2 = context;
      String str1 = c;
      String str2 = left;
      String str3 = a;
      String str4 = b;
      String str5 = TAG;
      String str6 = first;
      String str7 = length;
      String str8 = position;
      String str9 = root;
      String str10 = directory;
      String str11 = cache;
      String str12 = parent;
      String str13 = activity;
      String str14 = logger;
      String str15 = DEBUG;
      String str16 = helper;
      String str17 = this$1;
      String str18 = index;
      String str19 = key;
      String str20 = log;
      String str21 = queue;
      String str22 = LOG;
      String str23 = lock;
      String str24 = $assertionsDisabled;
      String str25 = level;
      String str26 = type;
      String str27 = file;
      String str28 = data;
      String str29 = text;
      try
      {
        Object localObject3 = new StringBuilder();
        Object localObject4 = type;
        ((StringBuilder)localObject3).append((String)localObject4);
        ((StringBuilder)localObject3).append("!=\"I\"");
        localObject3 = ((StringBuilder)localObject3).toString();
        localObject4 = new StringBuilder();
        String str30 = file;
        ((StringBuilder)localObject4).append(str30);
        ((StringBuilder)localObject4).append(" COLLATE NOCASE ASC");
        localObject4 = ((StringBuilder)localObject4).toString();
        localObject1 = ((SQLiteDatabase)localObject1).query((String)localObject2, new String[] { str1, str2, str3, str4, str5, str6, str7, str8, str9, str10, str11, str12, str13, str14, str15, str16, str17, str18, str19, str20, str21, str22, str23, str24, str25, str26, str27, str28, str29 }, (String)localObject3, null, null, null, (String)localObject4);
        if (localObject1 != null)
        {
          boolean bool = ((Cursor)localObject1).moveToFirst();
          if (bool) {
            for (;;)
            {
              localObject2 = new Log();
              ((Log)localObject2).getName(((Cursor)localObject1).getString(0));
              ((Log)localObject2).read(((Cursor)localObject1).getString(1));
              ((Log)localObject2).size(((Cursor)localObject1).getString(2));
              ((Log)localObject2).trim(((Cursor)localObject1).getString(3));
              ((Log)localObject2).split(((Cursor)localObject1).getString(4));
              ((Log)localObject2).write(((Cursor)localObject1).getString(5));
              ((Log)localObject2).execute(((Cursor)localObject1).getString(6));
              ((Log)localObject2).v(((Cursor)localObject1).getString(7));
              ((Log)localObject2).add(((Cursor)localObject1).getString(8));
              ((Log)localObject2).log(((Cursor)localObject1).getString(9));
              ((Log)localObject2).append(((Cursor)localObject1).getString(10));
              ((Log)localObject2).valueOf(Boolean.parseBoolean(((Cursor)localObject1).getString(11)));
              ((Log)localObject2).set(Boolean.parseBoolean(((Cursor)localObject1).getString(12)));
              ((Log)localObject2).d(((Cursor)localObject1).getString(13));
              ((Log)localObject2).add(Boolean.parseBoolean(((Cursor)localObject1).getString(14)));
              ((Log)localObject2).print(((Cursor)localObject1).getString(15));
              ((Log)localObject2).get(((Cursor)localObject1).getString(16));
              ((Log)localObject2).next(((Cursor)localObject1).getString(17));
              ((Log)localObject2).equals(((Cursor)localObject1).getString(18));
              ((Log)localObject2).set(((Cursor)localObject1).getString(19));
              ((Log)localObject2).start(((Cursor)localObject1).getString(20));
              ((Log)localObject2).put(((Cursor)localObject1).getString(21));
              ((Log)localObject2).update(((Cursor)localObject1).getString(22));
              ((Log)localObject2).toString(((Cursor)localObject1).getString(23));
              ((Log)localObject2).close(((Cursor)localObject1).getString(24));
              ((Log)localObject2).w(((Cursor)localObject1).getString(25));
              ((Log)localObject2).e(((Cursor)localObject1).getString(26));
              ((Log)localObject2).name(((Cursor)localObject1).getString(27));
              ((Log)localObject2).format(((Cursor)localObject1).getString(28));
              localArrayList.add(localObject2);
              bool = ((Cursor)localObject1).moveToNext();
              if (!bool) {
                break;
              }
            }
          }
          ((Cursor)localObject1).close();
        }
      }
      catch (Exception localException)
      {
        k.a.a.m.StringBuilder.append(localException);
      }
      append();
      return localArrayList;
    }
    catch (Throwable localThrowable)
    {
      throw localThrowable;
    }
  }
  
  public ArrayList initialize(String paramString)
    throws SQLException
  {
    try
    {
      ArrayList localArrayList = new ArrayList();
      get();
      Object localObject = this$0;
      String str1 = p;
      String str2 = q;
      String str3 = s;
      String str4 = e;
      String str5 = port;
      String str6 = realm;
      String str7 = query;
      String str8 = h;
      String str9 = board;
      String str10 = start;
      String str11 = server;
      String str12 = to;
      String str13 = from;
      String str14 = time;
      String str15 = thread;
      String str16 = host;
      String str17 = packageName;
      String str18 = image;
      String str19 = CENTER;
      try
      {
        StringBuilder localStringBuilder = new StringBuilder();
        String str20 = x;
        localStringBuilder.append(str20);
        localStringBuilder.append("=\"");
        localStringBuilder.append(paramString);
        localStringBuilder.append("\"");
        paramString = localStringBuilder.toString();
        paramString = ((SQLiteDatabase)localObject).query(str1, new String[] { str2, str3, str4, str5, str6, str7, str8, str9, str10, str11, str12, str13, str14, str15, str16, str17, str18, str19 }, paramString, null, null, null, null);
        if (paramString != null)
        {
          boolean bool = paramString.moveToFirst();
          if (bool) {
            for (;;)
            {
              localObject = new k.a.a.c.f();
              ((k.a.a.c.f)localObject).c(paramString.getString(0));
              ((k.a.a.c.f)localObject).b(paramString.getString(1));
              ((k.a.a.c.f)localObject).d(paramString.getString(2));
              ((k.a.a.c.f)localObject).e(paramString.getString(3));
              ((k.a.a.c.f)localObject).f(paramString.getString(4));
              ((k.a.a.c.f)localObject).g(paramString.getString(5));
              ((k.a.a.c.f)localObject).o(paramString.getString(6));
              ((k.a.a.c.f)localObject).j(paramString.getString(7));
              ((k.a.a.c.f)localObject).m(paramString.getString(8));
              ((k.a.a.c.f)localObject).r(paramString.getString(9));
              ((k.a.a.c.f)localObject).p(paramString.getString(10));
              ((k.a.a.c.f)localObject).k(paramString.getString(11));
              ((k.a.a.c.f)localObject).i(paramString.getString(12));
              ((k.a.a.c.f)localObject).l(paramString.getString(13));
              ((k.a.a.c.f)localObject).n(paramString.getString(14));
              ((k.a.a.c.f)localObject).q(paramString.getString(15));
              ((k.a.a.c.f)localObject).a(paramString.getString(16));
              ((k.a.a.c.f)localObject).h(paramString.getString(17));
              localArrayList.add(localObject);
              bool = paramString.moveToNext();
              if (!bool) {
                break;
              }
            }
          }
          paramString.close();
        }
      }
      catch (Exception paramString)
      {
        k.a.a.m.StringBuilder.append(paramString);
      }
      append();
      return localArrayList;
    }
    catch (Throwable paramString)
    {
      throw paramString;
    }
  }
  
  public ArrayList initialize(ArrayList paramArrayList)
    throws SQLException
  {
    try
    {
      ArrayList localArrayList = new ArrayList();
      get();
      Object localObject1 = this$0;
      Object localObject2 = name;
      String str1 = c;
      String str2 = left;
      String str3 = a;
      String str4 = b;
      String str5 = directory;
      String str6 = cache;
      String str7 = logger;
      String str8 = helper;
      String str9 = this$1;
      String str10 = index;
      String str11 = key;
      String str12 = username;
      String str13 = date;
      String str14 = hash;
      String str15 = level;
      String str16 = y;
      String str17 = LOG;
      String str18 = TAG;
      String str19 = root;
      String str20 = $assertionsDisabled;
      String str21 = file;
      String str22 = type;
      String str23 = data;
      String str24 = text;
      try
      {
        Object localObject3 = new StringBuilder();
        Object localObject4 = root;
        ((StringBuilder)localObject3).append((String)localObject4);
        ((StringBuilder)localObject3).append("!=\"99\" OR ");
        localObject4 = $assertionsDisabled;
        ((StringBuilder)localObject3).append((String)localObject4);
        ((StringBuilder)localObject3).append("!=\"\"");
        localObject3 = ((StringBuilder)localObject3).toString();
        localObject4 = new StringBuilder();
        String str25 = left;
        ((StringBuilder)localObject4).append(str25);
        ((StringBuilder)localObject4).append(" COLLATE NOCASE ASC");
        localObject4 = ((StringBuilder)localObject4).toString();
        localObject1 = ((SQLiteDatabase)localObject1).query((String)localObject2, new String[] { str1, str2, str3, str4, str5, str6, str7, str8, str9, str10, str11, str12, str13, str14, str15, str16, str17, str18, str19, str20, str21, str22, str23, str24 }, (String)localObject3, null, null, null, (String)localObject4);
        if (localObject1 != null)
        {
          boolean bool = ((Cursor)localObject1).moveToFirst();
          if (bool) {
            for (;;)
            {
              bool = paramArrayList.contains(((Cursor)localObject1).getString(0));
              if (bool)
              {
                localObject2 = new O();
                ((O)localObject2).j(((Cursor)localObject1).getString(0));
                ((O)localObject2).n(((Cursor)localObject1).getString(1));
                ((O)localObject2).a(((Cursor)localObject1).getString(2));
                ((O)localObject2).k(((Cursor)localObject1).getString(3));
                ((O)localObject2).b(((Cursor)localObject1).getString(4));
                ((O)localObject2).c(((Cursor)localObject1).getString(5));
                ((O)localObject2).t(((Cursor)localObject1).getString(6));
                ((O)localObject2).w(((Cursor)localObject1).getString(7));
                ((O)localObject2).i(((Cursor)localObject1).getString(8));
                ((O)localObject2).d(((Cursor)localObject1).getString(9));
                ((O)localObject2).x(((Cursor)localObject1).getString(10));
                ((O)localObject2).q(((Cursor)localObject1).getString(11));
                ((O)localObject2).o(((Cursor)localObject1).getString(12));
                ((O)localObject2).p(((Cursor)localObject1).getString(13));
                ((O)localObject2).s(((Cursor)localObject1).getString(14));
                ((O)localObject2).e(((Cursor)localObject1).getString(15));
                ((O)localObject2).g(((Cursor)localObject1).getString(16));
                ((O)localObject2).f(((Cursor)localObject1).getString(17));
                ((O)localObject2).u(((Cursor)localObject1).getString(18));
                ((O)localObject2).r(((Cursor)localObject1).getString(19));
                ((O)localObject2).h(((Cursor)localObject1).getString(20));
                ((O)localObject2).v(((Cursor)localObject1).getString(21));
                ((O)localObject2).m(((Cursor)localObject1).getString(22));
                ((O)localObject2).l(((Cursor)localObject1).getString(23));
                localArrayList.add(localObject2);
              }
              bool = ((Cursor)localObject1).moveToNext();
              if (!bool) {
                break;
              }
            }
          }
          ((Cursor)localObject1).close();
        }
      }
      catch (Exception paramArrayList)
      {
        k.a.a.m.StringBuilder.append(paramArrayList);
      }
      append();
      return localArrayList;
    }
    catch (Throwable paramArrayList)
    {
      throw paramArrayList;
    }
  }
  
  public k.a.a.c.f initialize(String paramString1, String paramString2)
    throws SQLException
  {
    try
    {
      get();
      SQLiteDatabase localSQLiteDatabase = this$0;
      String str1 = p;
      String str2 = q;
      String str3 = s;
      String str4 = e;
      String str5 = port;
      String str6 = realm;
      String str7 = query;
      String str8 = h;
      String str9 = board;
      String str10 = start;
      String str11 = server;
      String str12 = to;
      String str13 = from;
      String str14 = time;
      String str15 = thread;
      String str16 = host;
      String str17 = packageName;
      String str18 = image;
      String str19 = CENTER;
      try
      {
        StringBuilder localStringBuilder = new StringBuilder();
        String str20 = x;
        localStringBuilder.append(str20);
        localStringBuilder.append("=\"");
        localStringBuilder.append(paramString1);
        localStringBuilder.append("\" AND ");
        paramString1 = h;
        localStringBuilder.append(paramString1);
        localStringBuilder.append("=\"");
        localStringBuilder.append(paramString2);
        localStringBuilder.append("\"");
        paramString1 = localStringBuilder.toString();
        paramString2 = localSQLiteDatabase.query(str1, new String[] { str2, str3, str4, str5, str6, str7, str8, str9, str10, str11, str12, str13, str14, str15, str16, str17, str18, str19 }, paramString1, null, null, null, null);
        if (paramString2 != null)
        {
          boolean bool = paramString2.moveToFirst();
          if (bool)
          {
            paramString1 = new k.a.a.c.f();
            try
            {
              paramString1.c(paramString2.getString(0));
              paramString1.b(paramString2.getString(1));
              paramString1.d(paramString2.getString(2));
              paramString1.e(paramString2.getString(3));
              paramString1.f(paramString2.getString(4));
              paramString1.g(paramString2.getString(5));
              paramString1.o(paramString2.getString(6));
              paramString1.j(paramString2.getString(7));
              paramString1.m(paramString2.getString(8));
              paramString1.r(paramString2.getString(9));
              paramString1.p(paramString2.getString(10));
              paramString1.k(paramString2.getString(11));
              paramString1.i(paramString2.getString(12));
              paramString1.l(paramString2.getString(13));
              paramString1.n(paramString2.getString(14));
              paramString1.q(paramString2.getString(15));
              paramString1.a(paramString2.getString(16));
              paramString1.h(paramString2.getString(17));
            }
            catch (Exception paramString2)
            {
              break label580;
            }
          }
          else
          {
            paramString1 = null;
          }
          try
          {
            paramString2.close();
          }
          catch (Exception paramString2)
          {
            break label580;
          }
        }
        else
        {
          paramString1 = null;
        }
      }
      catch (Exception paramString2)
      {
        paramString1 = null;
        label580:
        k.a.a.m.StringBuilder.append(paramString2);
      }
      append();
      return paramString1;
    }
    catch (Throwable paramString1)
    {
      throw paramString1;
    }
  }
  
  public void initialize(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8, String paramString9, String paramString10, String paramString11, String paramString12, String paramString13, String paramString14, String paramString15, String paramString16, String paramString17, String paramString18, String paramString19)
  {
    try
    {
      get();
      try
      {
        ContentValues localContentValues = new ContentValues();
        String str = x;
        localContentValues.put(str, paramString1);
        paramString1 = q;
        localContentValues.put(paramString1, paramString2);
        paramString1 = s;
        localContentValues.put(paramString1, paramString3);
        paramString1 = e;
        localContentValues.put(paramString1, paramString4);
        paramString1 = port;
        localContentValues.put(paramString1, paramString5);
        paramString1 = realm;
        localContentValues.put(paramString1, paramString6);
        paramString1 = query;
        localContentValues.put(paramString1, paramString7);
        paramString1 = h;
        localContentValues.put(paramString1, paramString8);
        paramString1 = board;
        localContentValues.put(paramString1, paramString9);
        paramString1 = start;
        localContentValues.put(paramString1, paramString10);
        paramString1 = server;
        localContentValues.put(paramString1, paramString11);
        paramString1 = to;
        localContentValues.put(paramString1, paramString12);
        paramString1 = from;
        localContentValues.put(paramString1, paramString13);
        paramString1 = time;
        localContentValues.put(paramString1, paramString14);
        paramString1 = thread;
        localContentValues.put(paramString1, paramString15);
        paramString1 = host;
        localContentValues.put(paramString1, paramString16);
        paramString1 = packageName;
        localContentValues.put(paramString1, paramString17);
        paramString1 = image;
        localContentValues.put(paramString1, paramString18);
        paramString1 = CENTER;
        localContentValues.put(paramString1, paramString19);
        paramString1 = this$0;
        paramString2 = p;
        paramString1.insert(paramString2, null, localContentValues);
      }
      catch (Exception paramString1)
      {
        k.a.a.m.StringBuilder.append(paramString1);
      }
      append();
      return;
    }
    catch (Throwable paramString1)
    {
      throw paramString1;
    }
  }
  
  public ArrayList load()
    throws SQLException
  {
    try
    {
      ArrayList localArrayList = new ArrayList();
      get();
      Object localObject1 = this$0;
      Object localObject2 = context;
      String str1 = c;
      String str2 = left;
      String str3 = a;
      String str4 = b;
      String str5 = TAG;
      String str6 = first;
      String str7 = length;
      String str8 = position;
      String str9 = root;
      String str10 = directory;
      String str11 = cache;
      String str12 = parent;
      String str13 = activity;
      String str14 = logger;
      String str15 = DEBUG;
      String str16 = helper;
      String str17 = this$1;
      String str18 = index;
      String str19 = key;
      String str20 = log;
      String str21 = queue;
      String str22 = LOG;
      String str23 = lock;
      String str24 = $assertionsDisabled;
      String str25 = level;
      String str26 = type;
      String str27 = file;
      String str28 = data;
      String str29 = text;
      try
      {
        Object localObject3 = new StringBuilder();
        Object localObject4 = root;
        ((StringBuilder)localObject3).append((String)localObject4);
        ((StringBuilder)localObject3).append("=\"99\" AND ");
        localObject4 = type;
        ((StringBuilder)localObject3).append((String)localObject4);
        ((StringBuilder)localObject3).append("!=\"I\"");
        localObject3 = ((StringBuilder)localObject3).toString();
        localObject4 = new StringBuilder();
        String str30 = left;
        ((StringBuilder)localObject4).append(str30);
        ((StringBuilder)localObject4).append(" COLLATE NOCASE ASC");
        localObject4 = ((StringBuilder)localObject4).toString();
        localObject1 = ((SQLiteDatabase)localObject1).query((String)localObject2, new String[] { str1, str2, str3, str4, str5, str6, str7, str8, str9, str10, str11, str12, str13, str14, str15, str16, str17, str18, str19, str20, str21, str22, str23, str24, str25, str26, str27, str28, str29 }, (String)localObject3, null, null, null, (String)localObject4);
        if (localObject1 != null)
        {
          boolean bool = ((Cursor)localObject1).moveToFirst();
          if (bool) {
            for (;;)
            {
              localObject2 = new Log();
              ((Log)localObject2).getName(((Cursor)localObject1).getString(0));
              ((Log)localObject2).read(((Cursor)localObject1).getString(1));
              ((Log)localObject2).size(((Cursor)localObject1).getString(2));
              ((Log)localObject2).trim(((Cursor)localObject1).getString(3));
              ((Log)localObject2).split(((Cursor)localObject1).getString(4));
              ((Log)localObject2).write(((Cursor)localObject1).getString(5));
              ((Log)localObject2).execute(((Cursor)localObject1).getString(6));
              ((Log)localObject2).v(((Cursor)localObject1).getString(7));
              ((Log)localObject2).add(((Cursor)localObject1).getString(8));
              ((Log)localObject2).log(((Cursor)localObject1).getString(9));
              ((Log)localObject2).append(((Cursor)localObject1).getString(10));
              ((Log)localObject2).valueOf(Boolean.parseBoolean(((Cursor)localObject1).getString(11)));
              ((Log)localObject2).set(Boolean.parseBoolean(((Cursor)localObject1).getString(12)));
              ((Log)localObject2).d(((Cursor)localObject1).getString(13));
              ((Log)localObject2).add(Boolean.parseBoolean(((Cursor)localObject1).getString(14)));
              ((Log)localObject2).print(((Cursor)localObject1).getString(15));
              ((Log)localObject2).get(((Cursor)localObject1).getString(16));
              ((Log)localObject2).next(((Cursor)localObject1).getString(17));
              ((Log)localObject2).equals(((Cursor)localObject1).getString(18));
              ((Log)localObject2).set(((Cursor)localObject1).getString(19));
              ((Log)localObject2).start(((Cursor)localObject1).getString(20));
              ((Log)localObject2).put(((Cursor)localObject1).getString(21));
              ((Log)localObject2).update(((Cursor)localObject1).getString(22));
              ((Log)localObject2).toString(((Cursor)localObject1).getString(23));
              ((Log)localObject2).close(((Cursor)localObject1).getString(24));
              ((Log)localObject2).w(((Cursor)localObject1).getString(25));
              ((Log)localObject2).e(((Cursor)localObject1).getString(26));
              ((Log)localObject2).name(((Cursor)localObject1).getString(27));
              ((Log)localObject2).format(((Cursor)localObject1).getString(28));
              localArrayList.add(localObject2);
              bool = ((Cursor)localObject1).moveToNext();
              if (!bool) {
                break;
              }
            }
          }
          ((Cursor)localObject1).close();
        }
      }
      catch (Exception localException)
      {
        k.a.a.m.StringBuilder.append(localException);
      }
      append();
      return localArrayList;
    }
    catch (Throwable localThrowable)
    {
      throw localThrowable;
    }
  }
  
  public ArrayList load(String paramString)
    throws SQLException
  {
    try
    {
      ArrayList localArrayList = new ArrayList();
      get();
      Object localObject1 = this$0;
      String str1 = context;
      String str2 = c;
      String str3 = left;
      String str4 = a;
      String str5 = b;
      String str6 = TAG;
      String str7 = first;
      String str8 = length;
      String str9 = position;
      String str10 = root;
      String str11 = directory;
      String str12 = cache;
      String str13 = parent;
      String str14 = activity;
      String str15 = logger;
      String str16 = DEBUG;
      String str17 = helper;
      String str18 = this$1;
      String str19 = index;
      String str20 = key;
      String str21 = log;
      String str22 = queue;
      String str23 = LOG;
      String str24 = lock;
      String str25 = $assertionsDisabled;
      String str26 = level;
      String str27 = type;
      String str28 = file;
      String str29 = data;
      String str30 = text;
      try
      {
        Object localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("(");
        String str31 = root;
        ((StringBuilder)localObject2).append(str31);
        ((StringBuilder)localObject2).append("=\"");
        ((StringBuilder)localObject2).append(paramString);
        ((StringBuilder)localObject2).append("\" OR ");
        str31 = $assertionsDisabled;
        ((StringBuilder)localObject2).append(str31);
        ((StringBuilder)localObject2).append(" LIKE '%|");
        ((StringBuilder)localObject2).append(paramString);
        ((StringBuilder)localObject2).append("|%') AND ");
        paramString = type;
        ((StringBuilder)localObject2).append(paramString);
        ((StringBuilder)localObject2).append("!=\"I\"");
        paramString = ((StringBuilder)localObject2).toString();
        localObject2 = new StringBuilder();
        str31 = left;
        ((StringBuilder)localObject2).append(str31);
        ((StringBuilder)localObject2).append(" COLLATE NOCASE ASC");
        localObject2 = ((StringBuilder)localObject2).toString();
        paramString = ((SQLiteDatabase)localObject1).query(str1, new String[] { str2, str3, str4, str5, str6, str7, str8, str9, str10, str11, str12, str13, str14, str15, str16, str17, str18, str19, str20, str21, str22, str23, str24, str25, str26, str27, str28, str29, str30 }, paramString, null, null, null, (String)localObject2);
        if (paramString != null)
        {
          boolean bool = paramString.moveToFirst();
          if (bool) {
            for (;;)
            {
              localObject1 = new Log();
              ((Log)localObject1).getName(paramString.getString(0));
              ((Log)localObject1).read(paramString.getString(1));
              ((Log)localObject1).size(paramString.getString(2));
              ((Log)localObject1).trim(paramString.getString(3));
              ((Log)localObject1).split(paramString.getString(4));
              ((Log)localObject1).write(paramString.getString(5));
              ((Log)localObject1).execute(paramString.getString(6));
              ((Log)localObject1).v(paramString.getString(7));
              ((Log)localObject1).add(paramString.getString(8));
              ((Log)localObject1).log(paramString.getString(9));
              ((Log)localObject1).append(paramString.getString(10));
              ((Log)localObject1).valueOf(Boolean.parseBoolean(paramString.getString(11)));
              ((Log)localObject1).set(Boolean.parseBoolean(paramString.getString(12)));
              ((Log)localObject1).d(paramString.getString(13));
              ((Log)localObject1).add(Boolean.parseBoolean(paramString.getString(14)));
              ((Log)localObject1).print(paramString.getString(15));
              ((Log)localObject1).get(paramString.getString(16));
              ((Log)localObject1).next(paramString.getString(17));
              ((Log)localObject1).equals(paramString.getString(18));
              ((Log)localObject1).set(paramString.getString(19));
              ((Log)localObject1).start(paramString.getString(20));
              ((Log)localObject1).put(paramString.getString(21));
              ((Log)localObject1).update(paramString.getString(22));
              ((Log)localObject1).toString(paramString.getString(23));
              ((Log)localObject1).close(paramString.getString(24));
              ((Log)localObject1).w(paramString.getString(25));
              ((Log)localObject1).e(paramString.getString(26));
              ((Log)localObject1).name(paramString.getString(27));
              ((Log)localObject1).format(paramString.getString(28));
              localArrayList.add(localObject1);
              bool = paramString.moveToNext();
              if (!bool) {
                break;
              }
            }
          }
          paramString.close();
        }
      }
      catch (Exception paramString)
      {
        k.a.a.m.StringBuilder.append(paramString);
      }
      append();
      return localArrayList;
    }
    catch (Throwable paramString)
    {
      throw paramString;
    }
  }
  
  public ArrayList loadInBackground()
    throws SQLException
  {
    try
    {
      ArrayList localArrayList = new ArrayList();
      get();
      Object localObject1 = this$0;
      Object localObject2 = context;
      String str1 = TAG;
      String str2 = LOG;
      String str3 = TAG;
      try
      {
        Object localObject3 = new StringBuilder();
        String str4 = TAG;
        ((StringBuilder)localObject3).append(str4);
        ((StringBuilder)localObject3).append(" COLLATE NOCASE ASC");
        localObject3 = ((StringBuilder)localObject3).toString();
        localObject1 = ((SQLiteDatabase)localObject1).query(true, (String)localObject2, new String[] { str1, str2 }, null, null, str3, null, (String)localObject3, null);
        if (localObject1 != null)
        {
          boolean bool = ((Cursor)localObject1).moveToFirst();
          if (bool) {
            do
            {
              localObject2 = new N();
              ((N)localObject2).b(((Cursor)localObject1).getString(0));
              ((N)localObject2).a(((Cursor)localObject1).getString(1));
              localArrayList.add(localObject2);
              bool = ((Cursor)localObject1).moveToNext();
            } while (bool);
          }
          ((Cursor)localObject1).close();
        }
      }
      catch (Exception localException)
      {
        k.a.a.m.StringBuilder.append(localException);
      }
      append();
      return localArrayList;
    }
    catch (Throwable localThrowable)
    {
      throw localThrowable;
    }
  }
  
  public void loadSession()
  {
    try
    {
      get();
      SQLiteDatabase localSQLiteDatabase = this$0;
      String str = mContext;
      try
      {
        localSQLiteDatabase.delete(str, null, null);
      }
      catch (Exception localException)
      {
        k.a.a.m.StringBuilder.append(localException);
      }
      append();
      return;
    }
    catch (Throwable localThrowable)
    {
      throw localThrowable;
    }
  }
  
  public ArrayList next()
    throws SQLException
  {
    try
    {
      ArrayList localArrayList = new ArrayList();
      get();
      Object localObject1 = this$0;
      Object localObject2 = table;
      String str1 = LOG_TAG;
      String str2 = g;
      String str3 = j;
      String str4 = l;
      String str5 = view;
      try
      {
        localObject1 = ((SQLiteDatabase)localObject1).query((String)localObject2, new String[] { str1, str2, str3, str4, str5 }, null, null, null, null, null);
        if (localObject1 != null)
        {
          boolean bool = ((Cursor)localObject1).moveToFirst();
          if (bool) {
            do
            {
              localObject2 = new d();
              ((d)localObject2).e(((Cursor)localObject1).getString(0));
              ((d)localObject2).a(((Cursor)localObject1).getString(1));
              ((d)localObject2).b(((Cursor)localObject1).getString(2));
              ((d)localObject2).d(((Cursor)localObject1).getString(3));
              ((d)localObject2).c(((Cursor)localObject1).getString(4));
              localArrayList.add(localObject2);
              bool = ((Cursor)localObject1).moveToNext();
            } while (bool);
          }
          ((Cursor)localObject1).close();
        }
      }
      catch (Exception localException)
      {
        k.a.a.m.StringBuilder.append(localException);
      }
      append();
      return localArrayList;
    }
    catch (Throwable localThrowable)
    {
      throw localThrowable;
    }
  }
  
  public ArrayList next(String paramString)
    throws SQLException
  {
    try
    {
      ArrayList localArrayList = new ArrayList();
      get();
      Object localObject = this$0;
      String str1 = map;
      String str2 = NONE;
      String str3 = URL;
      String str4 = ADD;
      String str5 = pos;
      String str6 = content;
      String str7 = tag;
      String str8 = values;
      String str9 = pointer;
      String str10 = current;
      String str11 = handler;
      String str12 = id;
      try
      {
        StringBuilder localStringBuilder = new StringBuilder();
        String str13 = delegate;
        localStringBuilder.append(str13);
        localStringBuilder.append("=\"");
        localStringBuilder.append(paramString);
        localStringBuilder.append("\"");
        paramString = localStringBuilder.toString();
        paramString = ((SQLiteDatabase)localObject).query(str1, new String[] { str2, str3, str4, str5, str6, str7, str8, str9, str10, str11, str12 }, paramString, null, null, null, null);
        if (paramString != null)
        {
          boolean bool = paramString.moveToFirst();
          if (bool) {
            do
            {
              localObject = new z();
              ((z)localObject).e(paramString.getString(0));
              ((z)localObject).f(paramString.getString(1));
              ((z)localObject).j(paramString.getString(2));
              ((z)localObject).a(paramString.getString(3));
              ((z)localObject).g(paramString.getString(4));
              ((z)localObject).i(paramString.getString(5));
              ((z)localObject).h(paramString.getString(6));
              ((z)localObject).k(paramString.getString(7));
              ((z)localObject).b(paramString.getString(8));
              ((z)localObject).c(paramString.getString(9));
              ((z)localObject).d(paramString.getString(10));
              localArrayList.add(localObject);
              bool = paramString.moveToNext();
            } while (bool);
          }
          paramString.close();
        }
      }
      catch (Exception paramString)
      {
        k.a.a.m.StringBuilder.append(paramString);
      }
      append();
      return localArrayList;
    }
    catch (Throwable paramString)
    {
      throw paramString;
    }
  }
  
  public void onCreate(SQLiteDatabase paramSQLiteDatabase)
  {
    StringBuilder localStringBuilder = f.sufficientlysecure.rootcommands.util.StringBuilder.append("create table ");
    localStringBuilder.append(r);
    localStringBuilder.append(" ( ");
    localStringBuilder.append(out);
    localStringBuilder.append(" integer primary key autoincrement not null,");
    localStringBuilder.append(w);
    localStringBuilder.append(" text not null unique,");
    localStringBuilder.append(m);
    localStringBuilder.append(" text,");
    localStringBuilder.append(Q);
    localStringBuilder.append(" text,");
    localStringBuilder.append(H);
    localStringBuilder.append(" text,");
    localStringBuilder.append(n);
    localStringBuilder.append(" text,");
    localStringBuilder.append(S);
    localStringBuilder.append(" text,");
    localStringBuilder.append(G);
    localStringBuilder.append(" text,");
    localStringBuilder.append(P);
    localStringBuilder.append(" text,");
    localStringBuilder.append(TYPE);
    localStringBuilder.append(" text,");
    localStringBuilder.append(c);
    localStringBuilder.append(" text,");
    localStringBuilder.append(d);
    localStringBuilder.append(" text,");
    localStringBuilder.append(DOMAIN);
    localStringBuilder.append(" text,");
    localStringBuilder.append(B);
    localStringBuilder.append(" text,");
    localStringBuilder.append(X);
    localStringBuilder.append(" text,");
    localStringBuilder.append(M);
    localStringBuilder.append(" text,");
    localStringBuilder.append(A);
    localStringBuilder.append(" text,");
    localStringBuilder.append(C);
    localStringBuilder.append(" text,");
    localStringBuilder.append(t);
    localStringBuilder.append(" text,");
    localStringBuilder.append(x);
    localStringBuilder.append(" text,");
    localStringBuilder.append(I);
    localStringBuilder.append(" text,");
    localStringBuilder = f.sufficientlysecure.rootcommands.util.StringBuilder.append(localStringBuilder, width, " text );", paramSQLiteDatabase, "create table ");
    localStringBuilder.append(context);
    localStringBuilder.append(" ( ");
    localStringBuilder.append(out);
    localStringBuilder.append(" integer primary key autoincrement not null,");
    localStringBuilder.append(c);
    localStringBuilder.append(" text not null unique,");
    localStringBuilder.append(left);
    localStringBuilder.append(" text,");
    localStringBuilder.append(a);
    localStringBuilder.append(" text,");
    localStringBuilder.append(b);
    localStringBuilder.append(" text,");
    localStringBuilder.append(TAG);
    localStringBuilder.append(" text,");
    localStringBuilder.append(first);
    localStringBuilder.append(" text,");
    localStringBuilder.append(length);
    localStringBuilder.append(" text,");
    localStringBuilder.append(position);
    localStringBuilder.append(" text,");
    localStringBuilder.append(root);
    localStringBuilder.append(" text,");
    localStringBuilder.append(directory);
    localStringBuilder.append(" text,");
    localStringBuilder.append(cache);
    localStringBuilder.append(" text,");
    localStringBuilder.append(parent);
    localStringBuilder.append(" text,");
    localStringBuilder.append(activity);
    localStringBuilder.append(" text,");
    localStringBuilder.append(logger);
    localStringBuilder.append(" text,");
    localStringBuilder.append(DEBUG);
    localStringBuilder.append(" text,");
    localStringBuilder.append(helper);
    localStringBuilder.append(" text,");
    localStringBuilder.append(this$1);
    localStringBuilder.append(" text,");
    localStringBuilder.append(index);
    localStringBuilder.append(" text,");
    localStringBuilder.append(key);
    localStringBuilder.append(" text,");
    localStringBuilder.append(log);
    localStringBuilder.append(" text,");
    localStringBuilder.append(queue);
    localStringBuilder.append(" text,");
    localStringBuilder.append(LOG);
    localStringBuilder.append(" text,");
    localStringBuilder.append(lock);
    localStringBuilder.append(" text,");
    localStringBuilder.append($assertionsDisabled);
    localStringBuilder.append(" text,");
    localStringBuilder.append(level);
    localStringBuilder.append(" text,");
    localStringBuilder.append(type);
    localStringBuilder.append(" text,");
    localStringBuilder.append(file);
    localStringBuilder.append(" text,");
    localStringBuilder.append(data);
    localStringBuilder.append(" text,");
    localStringBuilder = f.sufficientlysecure.rootcommands.util.StringBuilder.append(localStringBuilder, text, " text );", paramSQLiteDatabase, "create table ");
    localStringBuilder.append(size);
    localStringBuilder.append(" ( ");
    localStringBuilder.append(out);
    localStringBuilder.append(" integer primary key autoincrement not null,");
    localStringBuilder.append(c);
    localStringBuilder.append(" text not null unique,");
    localStringBuilder.append(left);
    localStringBuilder.append(" text,");
    localStringBuilder.append(a);
    localStringBuilder.append(" text,");
    localStringBuilder.append(b);
    localStringBuilder.append(" text,");
    localStringBuilder.append(TAG);
    localStringBuilder.append(" text,");
    localStringBuilder.append(first);
    localStringBuilder.append(" text,");
    localStringBuilder.append(length);
    localStringBuilder.append(" text,");
    localStringBuilder.append(position);
    localStringBuilder.append(" text,");
    localStringBuilder.append(root);
    localStringBuilder.append(" text,");
    localStringBuilder.append(directory);
    localStringBuilder.append(" text,");
    localStringBuilder.append(cache);
    localStringBuilder.append(" text,");
    localStringBuilder.append(parent);
    localStringBuilder.append(" text,");
    localStringBuilder.append(activity);
    localStringBuilder.append(" text,");
    localStringBuilder.append(logger);
    localStringBuilder.append(" text,");
    localStringBuilder.append(DEBUG);
    localStringBuilder.append(" text,");
    localStringBuilder.append(helper);
    localStringBuilder.append(" text,");
    localStringBuilder.append(this$1);
    localStringBuilder.append(" text,");
    localStringBuilder.append(index);
    localStringBuilder.append(" text,");
    localStringBuilder.append(key);
    localStringBuilder.append(" text,");
    localStringBuilder.append(log);
    localStringBuilder.append(" text,");
    localStringBuilder.append(queue);
    localStringBuilder.append(" text,");
    localStringBuilder.append(LOG);
    localStringBuilder.append(" text,");
    localStringBuilder.append(lock);
    localStringBuilder.append(" text,");
    localStringBuilder.append($assertionsDisabled);
    localStringBuilder.append(" text,");
    localStringBuilder.append(level);
    localStringBuilder.append(" text,");
    localStringBuilder.append(type);
    localStringBuilder.append(" text,");
    localStringBuilder.append(data);
    localStringBuilder.append(" text,");
    localStringBuilder = f.sufficientlysecure.rootcommands.util.StringBuilder.append(localStringBuilder, text, " text );", paramSQLiteDatabase, "create table ");
    localStringBuilder.append(name);
    localStringBuilder.append(" ( ");
    localStringBuilder.append(out);
    localStringBuilder.append(" integer primary key autoincrement not null,");
    localStringBuilder.append(c);
    localStringBuilder.append(" text not null unique,");
    localStringBuilder.append(left);
    localStringBuilder.append(" text,");
    localStringBuilder.append(a);
    localStringBuilder.append(" text,");
    localStringBuilder.append(b);
    localStringBuilder.append(" text,");
    localStringBuilder.append(directory);
    localStringBuilder.append(" text,");
    localStringBuilder.append(cache);
    localStringBuilder.append(" text,");
    localStringBuilder.append(logger);
    localStringBuilder.append(" text,");
    localStringBuilder.append(helper);
    localStringBuilder.append(" text,");
    localStringBuilder.append(this$1);
    localStringBuilder.append(" text,");
    localStringBuilder.append(index);
    localStringBuilder.append(" text,");
    localStringBuilder.append(key);
    localStringBuilder.append(" text,");
    localStringBuilder.append(username);
    localStringBuilder.append(" text,");
    localStringBuilder.append(date);
    localStringBuilder.append(" text,");
    localStringBuilder.append(hash);
    localStringBuilder.append(" text,");
    localStringBuilder.append(level);
    localStringBuilder.append(" text,");
    localStringBuilder.append(y);
    localStringBuilder.append(" text,");
    localStringBuilder.append(LOG);
    localStringBuilder.append(" text,");
    localStringBuilder.append(TAG);
    localStringBuilder.append(" text,");
    localStringBuilder.append(root);
    localStringBuilder.append(" text,");
    localStringBuilder.append($assertionsDisabled);
    localStringBuilder.append(" text,");
    localStringBuilder.append(file);
    localStringBuilder.append(" text,");
    localStringBuilder.append(type);
    localStringBuilder.append(" text,");
    localStringBuilder.append(data);
    localStringBuilder.append(" text,");
    localStringBuilder = f.sufficientlysecure.rootcommands.util.StringBuilder.append(localStringBuilder, text, " text );", paramSQLiteDatabase, "create table ");
    localStringBuilder.append(cursor);
    localStringBuilder.append(" ( ");
    localStringBuilder.append(out);
    localStringBuilder.append(" integer primary key autoincrement not null,");
    localStringBuilder.append(path);
    localStringBuilder.append(" text,");
    localStringBuilder.append(connection);
    localStringBuilder.append(" text,");
    localStringBuilder.append(uri);
    localStringBuilder.append(" text,");
    localStringBuilder = f.sufficientlysecure.rootcommands.util.StringBuilder.append(localStringBuilder, phoneNumber, " text );", paramSQLiteDatabase, "create table ");
    localStringBuilder.append(table);
    localStringBuilder.append(" ( ");
    localStringBuilder.append(out);
    localStringBuilder.append(" integer primary key autoincrement not null,");
    localStringBuilder.append(LOG_TAG);
    localStringBuilder.append(" text,");
    localStringBuilder.append(g);
    localStringBuilder.append(" text,");
    localStringBuilder.append(j);
    localStringBuilder.append(" text,");
    localStringBuilder.append(l);
    localStringBuilder.append(" text,");
    localStringBuilder = f.sufficientlysecure.rootcommands.util.StringBuilder.append(localStringBuilder, view, " text );", paramSQLiteDatabase, "create table ");
    localStringBuilder.append(mContext);
    localStringBuilder.append(" ( ");
    localStringBuilder.append(out);
    localStringBuilder.append(" integer primary key autoincrement not null,");
    localStringBuilder.append(LOG_TAG);
    localStringBuilder.append(" text,");
    localStringBuilder.append(g);
    localStringBuilder.append(" text,");
    localStringBuilder.append(j);
    localStringBuilder.append(" text,");
    localStringBuilder.append(l);
    localStringBuilder.append(" text,");
    localStringBuilder.append(view);
    localStringBuilder.append(" text,");
    localStringBuilder = f.sufficientlysecure.rootcommands.util.StringBuilder.append(localStringBuilder, type, " text );", paramSQLiteDatabase, "create table ");
    localStringBuilder.append(adapter);
    localStringBuilder.append(" ( ");
    localStringBuilder.append(out);
    localStringBuilder.append(" integer primary key autoincrement not null,");
    localStringBuilder.append(LOG_TAG);
    localStringBuilder.append(" text,");
    localStringBuilder.append(g);
    localStringBuilder.append(" text,");
    localStringBuilder.append(j);
    localStringBuilder.append(" text,");
    localStringBuilder.append(l);
    localStringBuilder.append(" text,");
    localStringBuilder = f.sufficientlysecure.rootcommands.util.StringBuilder.append(localStringBuilder, view, " text );", paramSQLiteDatabase, "create table ");
    localStringBuilder.append(res);
    localStringBuilder.append(" ( ");
    localStringBuilder.append(out);
    localStringBuilder.append(" integer primary key autoincrement not null,");
    localStringBuilder = f.sufficientlysecure.rootcommands.util.StringBuilder.append(localStringBuilder, c, " text not null unique );", paramSQLiteDatabase, "create table ");
    localStringBuilder.append(app);
    localStringBuilder.append(" ( ");
    localStringBuilder.append(out);
    localStringBuilder.append(" integer primary key autoincrement not null,");
    localStringBuilder = f.sufficientlysecure.rootcommands.util.StringBuilder.append(localStringBuilder, title, " text not null unique );", paramSQLiteDatabase, "create table ");
    localStringBuilder.append(CONTENT_URI);
    localStringBuilder.append(" ( ");
    localStringBuilder.append(out);
    localStringBuilder.append(" integer primary key autoincrement not null,");
    localStringBuilder = f.sufficientlysecure.rootcommands.util.StringBuilder.append(localStringBuilder, title, " text not null );", paramSQLiteDatabase, "create table ");
    localStringBuilder.append(mUri);
    localStringBuilder.append(" ( ");
    localStringBuilder.append(out);
    localStringBuilder.append(" integer primary key autoincrement not null,");
    localStringBuilder.append(x);
    localStringBuilder.append(" text not null,");
    localStringBuilder = f.sufficientlysecure.rootcommands.util.StringBuilder.append(localStringBuilder, c, " text not null );", paramSQLiteDatabase, "create table ");
    localStringBuilder.append(i);
    localStringBuilder.append(" ( ");
    localStringBuilder.append(out);
    localStringBuilder.append(" integer primary key autoincrement not null,");
    localStringBuilder.append(NULL);
    localStringBuilder.append(" text,");
    localStringBuilder.append(mode);
    localStringBuilder.append(" text,");
    localStringBuilder.append(filePath);
    localStringBuilder.append(" text,");
    localStringBuilder.append(mimeType);
    localStringBuilder.append(" text,");
    localStringBuilder.append(header);
    localStringBuilder.append(" text,");
    localStringBuilder.append(command);
    localStringBuilder.append(" text,");
    localStringBuilder.append(version);
    localStringBuilder.append(" text,");
    localStringBuilder.append(description);
    localStringBuilder.append(" text,");
    localStringBuilder.append(score);
    localStringBuilder.append(" text,");
    localStringBuilder.append(lang);
    localStringBuilder.append(" text,");
    localStringBuilder.append(geocode);
    localStringBuilder.append(" text,");
    localStringBuilder.append(ligneId);
    localStringBuilder.append(" text,");
    localStringBuilder = f.sufficientlysecure.rootcommands.util.StringBuilder.append(localStringBuilder, arretId, " text );", paramSQLiteDatabase, "create table ");
    localStringBuilder.append(p);
    localStringBuilder.append(" ( ");
    localStringBuilder.append(out);
    localStringBuilder.append(" integer primary key autoincrement not null,");
    localStringBuilder.append(x);
    localStringBuilder.append(" text not null,");
    localStringBuilder.append(q);
    localStringBuilder.append(" text not null,");
    localStringBuilder.append(s);
    localStringBuilder.append(" text,");
    localStringBuilder.append(e);
    localStringBuilder.append(" text,");
    localStringBuilder.append(port);
    localStringBuilder.append(" text,");
    localStringBuilder.append(realm);
    localStringBuilder.append(" text,");
    localStringBuilder.append(query);
    localStringBuilder.append(" text,");
    localStringBuilder.append(h);
    localStringBuilder.append(" text not null,");
    localStringBuilder.append(board);
    localStringBuilder.append(" text,");
    localStringBuilder.append(start);
    localStringBuilder.append(" text,");
    localStringBuilder.append(server);
    localStringBuilder.append(" text,");
    localStringBuilder.append(to);
    localStringBuilder.append(" text,");
    localStringBuilder.append(from);
    localStringBuilder.append(" text,");
    localStringBuilder.append(time);
    localStringBuilder.append(" text,");
    localStringBuilder.append(thread);
    localStringBuilder.append(" text,");
    localStringBuilder.append(host);
    localStringBuilder.append(" text,");
    localStringBuilder.append(packageName);
    localStringBuilder.append(" text,");
    localStringBuilder.append(image);
    localStringBuilder.append(" text,");
    localStringBuilder = f.sufficientlysecure.rootcommands.util.StringBuilder.append(localStringBuilder, CENTER, " text );", paramSQLiteDatabase, "create table ");
    localStringBuilder.append(map);
    localStringBuilder.append(" ( ");
    localStringBuilder.append(out);
    localStringBuilder.append(" integer primary key autoincrement not null,");
    localStringBuilder.append(delegate);
    localStringBuilder.append(" text not null,");
    localStringBuilder.append(NONE);
    localStringBuilder.append(" text not null unique,");
    localStringBuilder.append(URL);
    localStringBuilder.append(" text,");
    localStringBuilder.append(ADD);
    localStringBuilder.append(" text,");
    localStringBuilder.append(pos);
    localStringBuilder.append(" text,");
    localStringBuilder.append(content);
    localStringBuilder.append(" text,");
    localStringBuilder.append(tag);
    localStringBuilder.append(" text,");
    localStringBuilder.append(values);
    localStringBuilder.append(" text,");
    localStringBuilder.append(pointer);
    localStringBuilder.append(" text,");
    localStringBuilder.append(current);
    localStringBuilder.append(" text,");
    localStringBuilder.append(handler);
    localStringBuilder.append(" text,");
    localStringBuilder = f.sufficientlysecure.rootcommands.util.StringBuilder.append(localStringBuilder, id, " text );", paramSQLiteDatabase, "create table ");
    localStringBuilder.append(URI);
    localStringBuilder.append(" ( ");
    localStringBuilder.append(out);
    localStringBuilder.append(" integer primary key autoincrement not null,");
    localStringBuilder.append(filter);
    localStringBuilder.append(" text,");
    localStringBuilder.append(LOGGER);
    localStringBuilder.append(" text,");
    localStringBuilder.append(separator);
    localStringBuilder.append(" text,");
    localStringBuilder.append(user);
    localStringBuilder.append(" text,");
    localStringBuilder.append(status);
    localStringBuilder.append(" text,");
    localStringBuilder.append(mName);
    localStringBuilder.append(" text,");
    localStringBuilder.append(FALSE);
    localStringBuilder.append(" text,");
    localStringBuilder.append(args);
    localStringBuilder.append(" text,");
    localStringBuilder.append(params);
    localStringBuilder.append(" text,");
    localStringBuilder.append(longitude);
    localStringBuilder.append(" text,");
    localStringBuilder.append(latitude);
    localStringBuilder.append(" text,");
    localStringBuilder.append(authors);
    localStringBuilder.append(" text,");
    localStringBuilder.append(hour);
    localStringBuilder.append(" text,");
    localStringBuilder.append(minute);
    localStringBuilder.append(" text,");
    localStringBuilder.append(message);
    localStringBuilder.append(" text,");
    localStringBuilder.append(login);
    localStringBuilder.append(" text,");
    localStringBuilder.append(offset);
    localStringBuilder.append(" text,");
    localStringBuilder.append(payload);
    localStringBuilder.append(" text,");
    localStringBuilder.append(min);
    localStringBuilder.append(" text,");
    localStringBuilder.append(next);
    localStringBuilder.append(" text,");
    localStringBuilder.append(token);
    localStringBuilder.append(" text,");
    localStringBuilder.append(comment);
    localStringBuilder.append(" text,");
    localStringBuilder.append(buf);
    localStringBuilder.append(" text,");
    localStringBuilder.append(count);
    localStringBuilder.append(" text,");
    localStringBuilder.append(value);
    localStringBuilder.append(" text,");
    localStringBuilder.append(line);
    localStringBuilder.append(" text,");
    localStringBuilder.append(names);
    localStringBuilder.append(" text,");
    localStringBuilder.append(format);
    localStringBuilder.append(" text,");
    localStringBuilder.append(language);
    localStringBuilder.append(" text,");
    localStringBuilder.append(country);
    localStringBuilder.append(" text,");
    localStringBuilder.append(state);
    localStringBuilder.append(" text,");
    localStringBuilder.append(input);
    localStringBuilder.append(" text,");
    localStringBuilder.append(source);
    localStringBuilder.append(" text,");
    localStringBuilder.append(element);
    localStringBuilder.append(" text,");
    localStringBuilder.append(START);
    localStringBuilder.append(" text,");
    localStringBuilder.append(ROOT);
    localStringBuilder.append(" text,");
    localStringBuilder.append(max);
    localStringBuilder.append(" text,");
    localStringBuilder.append(INSTANCE);
    localStringBuilder.append(" text,");
    localStringBuilder.append(db);
    localStringBuilder.append(" text,");
    localStringBuilder.append(sql);
    localStringBuilder.append(" text,");
    localStringBuilder.append(contentType);
    localStringBuilder.append(" text,");
    localStringBuilder.append(filename);
    localStringBuilder.append(" text,");
    localStringBuilder.append(url);
    localStringBuilder.append(" text,");
    localStringBuilder.append(top);
    localStringBuilder.append(" text );");
    paramSQLiteDatabase.execSQL(localStringBuilder.toString());
  }
  
  public void onCreate(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8, String paramString9, String paramString10, String paramString11, String paramString12, String paramString13)
  {
    try
    {
      get();
      try
      {
        ContentValues localContentValues = new ContentValues();
        String str = NULL;
        localContentValues.put(str, paramString1);
        paramString1 = mode;
        localContentValues.put(paramString1, paramString2);
        paramString1 = filePath;
        localContentValues.put(paramString1, paramString3);
        paramString1 = mimeType;
        localContentValues.put(paramString1, paramString4);
        paramString1 = header;
        localContentValues.put(paramString1, paramString5);
        paramString1 = command;
        localContentValues.put(paramString1, paramString6);
        paramString1 = version;
        localContentValues.put(paramString1, paramString7);
        paramString1 = description;
        localContentValues.put(paramString1, paramString8);
        paramString1 = score;
        localContentValues.put(paramString1, paramString9);
        paramString1 = lang;
        localContentValues.put(paramString1, paramString10);
        paramString1 = geocode;
        localContentValues.put(paramString1, paramString11);
        paramString1 = arretId;
        localContentValues.put(paramString1, paramString13);
        paramString1 = ligneId;
        localContentValues.put(paramString1, paramString12);
        paramString1 = this$0;
        paramString2 = i;
        paramString1.insert(paramString2, null, localContentValues);
      }
      catch (Exception paramString1)
      {
        k.a.a.m.StringBuilder.append(paramString1);
      }
      append();
      return;
    }
    catch (Throwable paramString1)
    {
      throw paramString1;
    }
  }
  
  public O onItemClick(String paramString)
    throws SQLException
  {
    try
    {
      get();
      Object localObject = this$0;
      String str1 = name;
      String str2 = c;
      String str3 = left;
      String str4 = a;
      String str5 = b;
      String str6 = directory;
      String str7 = cache;
      String str8 = logger;
      String str9 = helper;
      String str10 = this$1;
      String str11 = index;
      String str12 = key;
      String str13 = username;
      String str14 = date;
      String str15 = hash;
      String str16 = level;
      String str17 = y;
      String str18 = LOG;
      String str19 = TAG;
      String str20 = root;
      String str21 = $assertionsDisabled;
      String str22 = file;
      String str23 = type;
      String str24 = data;
      String str25 = text;
      try
      {
        StringBuilder localStringBuilder = new StringBuilder();
        String str26 = c;
        localStringBuilder.append(str26);
        localStringBuilder.append("=\"");
        localStringBuilder.append(paramString);
        localStringBuilder.append("\"");
        paramString = localStringBuilder.toString();
        localObject = ((SQLiteDatabase)localObject).query(str1, new String[] { str2, str3, str4, str5, str6, str7, str8, str9, str10, str11, str12, str13, str14, str15, str16, str17, str18, str19, str20, str21, str22, str23, str24, str25 }, paramString, null, null, null, null);
        if (localObject != null)
        {
          boolean bool = ((Cursor)localObject).moveToFirst();
          if (bool)
          {
            paramString = new O();
            try
            {
              paramString.j(((Cursor)localObject).getString(0));
              paramString.n(((Cursor)localObject).getString(1));
              paramString.a(((Cursor)localObject).getString(2));
              paramString.k(((Cursor)localObject).getString(3));
              paramString.b(((Cursor)localObject).getString(4));
              paramString.c(((Cursor)localObject).getString(5));
              paramString.t(((Cursor)localObject).getString(6));
              paramString.w(((Cursor)localObject).getString(7));
              paramString.i(((Cursor)localObject).getString(8));
              paramString.d(((Cursor)localObject).getString(9));
              paramString.x(((Cursor)localObject).getString(10));
              paramString.q(((Cursor)localObject).getString(11));
              paramString.o(((Cursor)localObject).getString(12));
              paramString.p(((Cursor)localObject).getString(13));
              paramString.s(((Cursor)localObject).getString(14));
              paramString.e(((Cursor)localObject).getString(15));
              paramString.g(((Cursor)localObject).getString(16));
              paramString.f(((Cursor)localObject).getString(17));
              paramString.u(((Cursor)localObject).getString(18));
              paramString.r(((Cursor)localObject).getString(19));
              paramString.h(((Cursor)localObject).getString(20));
              paramString.v(((Cursor)localObject).getString(21));
              paramString.m(((Cursor)localObject).getString(22));
              paramString.l(((Cursor)localObject).getString(23));
            }
            catch (Exception localException1)
            {
              break label680;
            }
          }
          else
          {
            paramString = null;
          }
          try
          {
            localException1.close();
          }
          catch (Exception localException2)
          {
            break label680;
          }
        }
        else
        {
          paramString = null;
        }
      }
      catch (Exception localException3)
      {
        paramString = null;
        label680:
        k.a.a.m.StringBuilder.append(localException3);
      }
      append();
      return paramString;
    }
    catch (Throwable paramString)
    {
      throw paramString;
    }
  }
  
  public void onUpgrade(SQLiteDatabase paramSQLiteDatabase, int paramInt1, int paramInt2)
  {
    Object localObject;
    switch (paramInt1)
    {
    default: 
      throw new IllegalStateException(f.sufficientlysecure.rootcommands.util.StringBuilder.toString("onUpgrade() with unknown oldVersion ", paramInt1));
    case 1: 
      localObject = f.sufficientlysecure.rootcommands.util.StringBuilder.append("create table ");
      ((StringBuilder)localObject).append(name);
      ((StringBuilder)localObject).append(" ( ");
      ((StringBuilder)localObject).append(out);
      ((StringBuilder)localObject).append(" integer primary key autoincrement not null,");
      ((StringBuilder)localObject).append(c);
      ((StringBuilder)localObject).append(" text not null unique,");
      ((StringBuilder)localObject).append(left);
      ((StringBuilder)localObject).append(" text,");
      ((StringBuilder)localObject).append(a);
      ((StringBuilder)localObject).append(" text,");
      ((StringBuilder)localObject).append(b);
      ((StringBuilder)localObject).append(" text,");
      ((StringBuilder)localObject).append(directory);
      ((StringBuilder)localObject).append(" text,");
      ((StringBuilder)localObject).append(cache);
      ((StringBuilder)localObject).append(" text,");
      ((StringBuilder)localObject).append(logger);
      ((StringBuilder)localObject).append(" text,");
      ((StringBuilder)localObject).append(helper);
      ((StringBuilder)localObject).append(" text,");
      ((StringBuilder)localObject).append(this$1);
      ((StringBuilder)localObject).append(" text,");
      ((StringBuilder)localObject).append(index);
      ((StringBuilder)localObject).append(" text,");
      ((StringBuilder)localObject).append(key);
      ((StringBuilder)localObject).append(" text,");
      ((StringBuilder)localObject).append(username);
      ((StringBuilder)localObject).append(" text,");
      ((StringBuilder)localObject).append(date);
      ((StringBuilder)localObject).append(" text,");
      ((StringBuilder)localObject).append(hash);
      ((StringBuilder)localObject).append(" text );");
      paramSQLiteDatabase.execSQL(((StringBuilder)localObject).toString());
    case 2: 
      localObject = f.sufficientlysecure.rootcommands.util.StringBuilder.append("ALTER TABLE ");
      ((StringBuilder)localObject).append(context);
      ((StringBuilder)localObject).append(" ADD COLUMN ");
      ((StringBuilder)localObject).append($assertionsDisabled);
      ((StringBuilder)localObject).append(" TEXT DEFAULT ''");
      paramSQLiteDatabase.execSQL(((StringBuilder)localObject).toString());
    case 3: 
      localObject = f.sufficientlysecure.rootcommands.util.StringBuilder.append("ALTER TABLE ");
      ((StringBuilder)localObject).append(p);
      ((StringBuilder)localObject).append(" ADD COLUMN ");
      ((StringBuilder)localObject).append(image);
      ((StringBuilder)localObject).append(" TEXT DEFAULT ''");
      paramSQLiteDatabase.execSQL(((StringBuilder)localObject).toString());
    case 4: 
      localObject = f.sufficientlysecure.rootcommands.util.StringBuilder.append("ALTER TABLE ");
      ((StringBuilder)localObject).append(context);
      ((StringBuilder)localObject).append(" ADD COLUMN ");
      localObject = f.sufficientlysecure.rootcommands.util.StringBuilder.append((StringBuilder)localObject, level, " TEXT DEFAULT ''", paramSQLiteDatabase, "ALTER TABLE ");
      ((StringBuilder)localObject).append(name);
      ((StringBuilder)localObject).append(" ADD COLUMN ");
      localObject = f.sufficientlysecure.rootcommands.util.StringBuilder.append((StringBuilder)localObject, level, " TEXT DEFAULT ''", paramSQLiteDatabase, "ALTER TABLE ");
      ((StringBuilder)localObject).append(name);
      ((StringBuilder)localObject).append(" ADD COLUMN ");
      ((StringBuilder)localObject).append(y);
      ((StringBuilder)localObject).append(" TEXT DEFAULT ''");
      paramSQLiteDatabase.execSQL(((StringBuilder)localObject).toString());
    case 5: 
      localObject = f.sufficientlysecure.rootcommands.util.StringBuilder.append("ALTER TABLE ");
      ((StringBuilder)localObject).append(p);
      ((StringBuilder)localObject).append(" ADD COLUMN ");
      localObject = f.sufficientlysecure.rootcommands.util.StringBuilder.append((StringBuilder)localObject, CENTER, " TEXT DEFAULT ''", paramSQLiteDatabase, "ALTER TABLE ");
      ((StringBuilder)localObject).append(name);
      ((StringBuilder)localObject).append(" ADD COLUMN ");
      localObject = f.sufficientlysecure.rootcommands.util.StringBuilder.append((StringBuilder)localObject, LOG, " TEXT DEFAULT ''", paramSQLiteDatabase, "ALTER TABLE ");
      ((StringBuilder)localObject).append(name);
      ((StringBuilder)localObject).append(" ADD COLUMN ");
      localObject = f.sufficientlysecure.rootcommands.util.StringBuilder.append((StringBuilder)localObject, TAG, " TEXT DEFAULT ''", paramSQLiteDatabase, "ALTER TABLE ");
      ((StringBuilder)localObject).append(name);
      ((StringBuilder)localObject).append(" ADD COLUMN ");
      localObject = f.sufficientlysecure.rootcommands.util.StringBuilder.append((StringBuilder)localObject, root, " TEXT DEFAULT ''", paramSQLiteDatabase, "ALTER TABLE ");
      ((StringBuilder)localObject).append(name);
      ((StringBuilder)localObject).append(" ADD COLUMN ");
      ((StringBuilder)localObject).append($assertionsDisabled);
      ((StringBuilder)localObject).append(" TEXT DEFAULT ''");
      paramSQLiteDatabase.execSQL(((StringBuilder)localObject).toString());
    case 6: 
      localObject = f.sufficientlysecure.rootcommands.util.StringBuilder.append("create table ");
      ((StringBuilder)localObject).append(map);
      ((StringBuilder)localObject).append(" ( ");
      ((StringBuilder)localObject).append(out);
      ((StringBuilder)localObject).append(" integer primary key autoincrement not null,");
      ((StringBuilder)localObject).append(delegate);
      ((StringBuilder)localObject).append(" text not null,");
      ((StringBuilder)localObject).append(NONE);
      ((StringBuilder)localObject).append(" text not null unique,");
      ((StringBuilder)localObject).append(URL);
      ((StringBuilder)localObject).append(" text,");
      ((StringBuilder)localObject).append(ADD);
      ((StringBuilder)localObject).append(" text,");
      ((StringBuilder)localObject).append(pos);
      ((StringBuilder)localObject).append(" text,");
      ((StringBuilder)localObject).append(content);
      ((StringBuilder)localObject).append(" text,");
      ((StringBuilder)localObject).append(tag);
      ((StringBuilder)localObject).append(" text,");
      ((StringBuilder)localObject).append(values);
      ((StringBuilder)localObject).append(" text,");
      ((StringBuilder)localObject).append(pointer);
      ((StringBuilder)localObject).append(" text,");
      ((StringBuilder)localObject).append(current);
      ((StringBuilder)localObject).append(" text,");
      ((StringBuilder)localObject).append(handler);
      ((StringBuilder)localObject).append(" text,");
      ((StringBuilder)localObject).append(id);
      ((StringBuilder)localObject).append(" text );");
      paramSQLiteDatabase.execSQL(((StringBuilder)localObject).toString());
    case 7: 
      localObject = f.sufficientlysecure.rootcommands.util.StringBuilder.append("create table ");
      ((StringBuilder)localObject).append(URI);
      ((StringBuilder)localObject).append(" ( ");
      ((StringBuilder)localObject).append(out);
      ((StringBuilder)localObject).append(" integer primary key autoincrement not null,");
      ((StringBuilder)localObject).append(filter);
      ((StringBuilder)localObject).append(" text,");
      ((StringBuilder)localObject).append(LOGGER);
      ((StringBuilder)localObject).append(" text,");
      ((StringBuilder)localObject).append(separator);
      ((StringBuilder)localObject).append(" text,");
      ((StringBuilder)localObject).append(user);
      ((StringBuilder)localObject).append(" text,");
      ((StringBuilder)localObject).append(status);
      ((StringBuilder)localObject).append(" text,");
      ((StringBuilder)localObject).append(mName);
      ((StringBuilder)localObject).append(" text,");
      ((StringBuilder)localObject).append(FALSE);
      ((StringBuilder)localObject).append(" text,");
      ((StringBuilder)localObject).append(args);
      ((StringBuilder)localObject).append(" text,");
      ((StringBuilder)localObject).append(params);
      ((StringBuilder)localObject).append(" text,");
      ((StringBuilder)localObject).append(longitude);
      ((StringBuilder)localObject).append(" text,");
      ((StringBuilder)localObject).append(latitude);
      ((StringBuilder)localObject).append(" text,");
      ((StringBuilder)localObject).append(authors);
      ((StringBuilder)localObject).append(" text,");
      ((StringBuilder)localObject).append(hour);
      ((StringBuilder)localObject).append(" text,");
      ((StringBuilder)localObject).append(minute);
      ((StringBuilder)localObject).append(" text,");
      ((StringBuilder)localObject).append(message);
      ((StringBuilder)localObject).append(" text,");
      ((StringBuilder)localObject).append(login);
      ((StringBuilder)localObject).append(" text,");
      ((StringBuilder)localObject).append(offset);
      ((StringBuilder)localObject).append(" text,");
      ((StringBuilder)localObject).append(payload);
      ((StringBuilder)localObject).append(" text,");
      ((StringBuilder)localObject).append(min);
      ((StringBuilder)localObject).append(" text,");
      ((StringBuilder)localObject).append(next);
      ((StringBuilder)localObject).append(" text,");
      ((StringBuilder)localObject).append(token);
      ((StringBuilder)localObject).append(" text,");
      ((StringBuilder)localObject).append(comment);
      ((StringBuilder)localObject).append(" text,");
      ((StringBuilder)localObject).append(buf);
      ((StringBuilder)localObject).append(" text,");
      ((StringBuilder)localObject).append(count);
      ((StringBuilder)localObject).append(" text,");
      ((StringBuilder)localObject).append(value);
      ((StringBuilder)localObject).append(" text,");
      ((StringBuilder)localObject).append(line);
      ((StringBuilder)localObject).append(" text,");
      ((StringBuilder)localObject).append(names);
      ((StringBuilder)localObject).append(" text,");
      ((StringBuilder)localObject).append(format);
      ((StringBuilder)localObject).append(" text,");
      ((StringBuilder)localObject).append(language);
      ((StringBuilder)localObject).append(" text,");
      ((StringBuilder)localObject).append(country);
      ((StringBuilder)localObject).append(" text,");
      ((StringBuilder)localObject).append(state);
      ((StringBuilder)localObject).append(" text,");
      ((StringBuilder)localObject).append(input);
      ((StringBuilder)localObject).append(" text,");
      ((StringBuilder)localObject).append(source);
      ((StringBuilder)localObject).append(" text,");
      ((StringBuilder)localObject).append(element);
      ((StringBuilder)localObject).append(" text,");
      ((StringBuilder)localObject).append(START);
      ((StringBuilder)localObject).append(" text,");
      ((StringBuilder)localObject).append(ROOT);
      ((StringBuilder)localObject).append(" text,");
      ((StringBuilder)localObject).append(max);
      ((StringBuilder)localObject).append(" text,");
      ((StringBuilder)localObject).append(INSTANCE);
      ((StringBuilder)localObject).append(" text,");
      ((StringBuilder)localObject).append(db);
      ((StringBuilder)localObject).append(" text,");
      ((StringBuilder)localObject).append(sql);
      ((StringBuilder)localObject).append(" text,");
      ((StringBuilder)localObject).append(contentType);
      ((StringBuilder)localObject).append(" text,");
      ((StringBuilder)localObject).append(filename);
      ((StringBuilder)localObject).append(" text,");
      ((StringBuilder)localObject).append(url);
      ((StringBuilder)localObject).append(" text,");
      ((StringBuilder)localObject).append(top);
      ((StringBuilder)localObject).append(" text );");
      paramSQLiteDatabase.execSQL(((StringBuilder)localObject).toString());
    case 8: 
      localObject = f.sufficientlysecure.rootcommands.util.StringBuilder.append("ALTER TABLE ");
      ((StringBuilder)localObject).append(cursor);
      ((StringBuilder)localObject).append(" ADD COLUMN ");
      ((StringBuilder)localObject).append(phoneNumber);
      ((StringBuilder)localObject).append(" TEXT DEFAULT ''");
      paramSQLiteDatabase.execSQL(((StringBuilder)localObject).toString());
    case 9: 
      localObject = f.sufficientlysecure.rootcommands.util.StringBuilder.append("ALTER TABLE ");
      ((StringBuilder)localObject).append(table);
      ((StringBuilder)localObject).append(" ADD COLUMN ");
      localObject = f.sufficientlysecure.rootcommands.util.StringBuilder.append((StringBuilder)localObject, view, " TEXT DEFAULT ''", paramSQLiteDatabase, "ALTER TABLE ");
      ((StringBuilder)localObject).append(adapter);
      ((StringBuilder)localObject).append(" ADD COLUMN ");
      ((StringBuilder)localObject).append(view);
      ((StringBuilder)localObject).append(" TEXT DEFAULT ''");
      paramSQLiteDatabase.execSQL(((StringBuilder)localObject).toString());
    case 10: 
      localObject = ctx;
      try
      {
        localObject = new k.a.a.m.f((Context)localObject);
        String str = k.a.a.m.f.TAG;
        ((k.a.a.m.f)localObject).append(str, "");
      }
      catch (Exception localException)
      {
        k.a.a.m.StringBuilder.append(localException);
      }
      paramSQLiteDatabase.delete(name, null, null);
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("ALTER TABLE ");
      localStringBuilder.append(name);
      localStringBuilder.append(" ADD COLUMN ");
      localStringBuilder.append(file);
      localStringBuilder.append(" TEXT DEFAULT ''");
      paramSQLiteDatabase.execSQL(localStringBuilder.toString());
    case 11: 
      localStringBuilder = f.sufficientlysecure.rootcommands.util.StringBuilder.append("create table ");
      localStringBuilder.append(size);
      localStringBuilder.append(" ( ");
      localStringBuilder.append(out);
      localStringBuilder.append(" integer primary key autoincrement not null,");
      localStringBuilder.append(c);
      localStringBuilder.append(" text not null unique,");
      localStringBuilder.append(left);
      localStringBuilder.append(" text,");
      localStringBuilder.append(a);
      localStringBuilder.append(" text,");
      localStringBuilder.append(b);
      localStringBuilder.append(" text,");
      localStringBuilder.append(TAG);
      localStringBuilder.append(" text,");
      localStringBuilder.append(first);
      localStringBuilder.append(" text,");
      localStringBuilder.append(length);
      localStringBuilder.append(" text,");
      localStringBuilder.append(position);
      localStringBuilder.append(" text,");
      localStringBuilder.append(root);
      localStringBuilder.append(" text,");
      localStringBuilder.append(directory);
      localStringBuilder.append(" text,");
      localStringBuilder.append(cache);
      localStringBuilder.append(" text,");
      localStringBuilder.append(parent);
      localStringBuilder.append(" text,");
      localStringBuilder.append(activity);
      localStringBuilder.append(" text,");
      localStringBuilder.append(logger);
      localStringBuilder.append(" text,");
      localStringBuilder.append(DEBUG);
      localStringBuilder.append(" text,");
      localStringBuilder.append(helper);
      localStringBuilder.append(" text,");
      localStringBuilder.append(this$1);
      localStringBuilder.append(" text,");
      localStringBuilder.append(index);
      localStringBuilder.append(" text,");
      localStringBuilder.append(key);
      localStringBuilder.append(" text,");
      localStringBuilder.append(log);
      localStringBuilder.append(" text,");
      localStringBuilder.append(queue);
      localStringBuilder.append(" text,");
      localStringBuilder.append(LOG);
      localStringBuilder.append(" text,");
      localStringBuilder.append(lock);
      localStringBuilder.append(" text,");
      localStringBuilder.append($assertionsDisabled);
      localStringBuilder.append(" text,");
      localStringBuilder.append(level);
      localStringBuilder.append(" text,");
      localStringBuilder = f.sufficientlysecure.rootcommands.util.StringBuilder.append(localStringBuilder, type, " text );", paramSQLiteDatabase, "create table ");
      localStringBuilder.append(mContext);
      localStringBuilder.append(" ( ");
      localStringBuilder.append(out);
      localStringBuilder.append(" integer primary key autoincrement not null,");
      localStringBuilder.append(LOG_TAG);
      localStringBuilder.append(" text,");
      localStringBuilder.append(g);
      localStringBuilder.append(" text,");
      localStringBuilder.append(j);
      localStringBuilder.append(" text,");
      localStringBuilder.append(l);
      localStringBuilder.append(" text,");
      localStringBuilder.append(view);
      localStringBuilder.append(" text );");
      paramSQLiteDatabase.execSQL(localStringBuilder.toString());
    case 12: 
      localStringBuilder = f.sufficientlysecure.rootcommands.util.StringBuilder.append("ALTER TABLE ");
      localStringBuilder.append(context);
      localStringBuilder.append(" ADD COLUMN ");
      localStringBuilder = f.sufficientlysecure.rootcommands.util.StringBuilder.append(localStringBuilder, type, " TEXT DEFAULT ''", paramSQLiteDatabase, "ALTER TABLE ");
      localStringBuilder.append(name);
      localStringBuilder.append(" ADD COLUMN ");
      localStringBuilder = f.sufficientlysecure.rootcommands.util.StringBuilder.append(localStringBuilder, type, " TEXT DEFAULT ''", paramSQLiteDatabase, "ALTER TABLE ");
      localStringBuilder.append(mContext);
      localStringBuilder.append(" ADD COLUMN ");
      localStringBuilder.append(type);
      localStringBuilder.append(" TEXT DEFAULT ''");
      paramSQLiteDatabase.execSQL(localStringBuilder.toString());
    case 13: 
      localStringBuilder = f.sufficientlysecure.rootcommands.util.StringBuilder.append("ALTER TABLE ");
      localStringBuilder.append(context);
      localStringBuilder.append(" ADD COLUMN ");
      localStringBuilder.append(file);
      localStringBuilder.append(" TEXT DEFAULT ''");
      paramSQLiteDatabase.execSQL(localStringBuilder.toString());
    }
    StringBuilder localStringBuilder = f.sufficientlysecure.rootcommands.util.StringBuilder.append("ALTER TABLE ");
    localStringBuilder.append(context);
    localStringBuilder.append(" ADD COLUMN ");
    localStringBuilder = f.sufficientlysecure.rootcommands.util.StringBuilder.append(localStringBuilder, data, " TEXT DEFAULT ''", paramSQLiteDatabase, "ALTER TABLE ");
    localStringBuilder.append(context);
    localStringBuilder.append(" ADD COLUMN ");
    localStringBuilder = f.sufficientlysecure.rootcommands.util.StringBuilder.append(localStringBuilder, text, " TEXT DEFAULT ''", paramSQLiteDatabase, "ALTER TABLE ");
    localStringBuilder.append(name);
    localStringBuilder.append(" ADD COLUMN ");
    localStringBuilder = f.sufficientlysecure.rootcommands.util.StringBuilder.append(localStringBuilder, data, " TEXT DEFAULT ''", paramSQLiteDatabase, "ALTER TABLE ");
    localStringBuilder.append(name);
    localStringBuilder.append(" ADD COLUMN ");
    localStringBuilder = f.sufficientlysecure.rootcommands.util.StringBuilder.append(localStringBuilder, text, " TEXT DEFAULT ''", paramSQLiteDatabase, "ALTER TABLE ");
    localStringBuilder.append(size);
    localStringBuilder.append(" ADD COLUMN ");
    localStringBuilder = f.sufficientlysecure.rootcommands.util.StringBuilder.append(localStringBuilder, data, " TEXT DEFAULT ''", paramSQLiteDatabase, "ALTER TABLE ");
    localStringBuilder.append(size);
    localStringBuilder.append(" ADD COLUMN ");
    localStringBuilder.append(text);
    localStringBuilder.append(" TEXT DEFAULT ''");
    paramSQLiteDatabase.execSQL(localStringBuilder.toString());
  }
  
  public ArrayList open(String paramString)
    throws SQLException
  {
    try
    {
      ArrayList localArrayList = new ArrayList();
      get();
      SQLiteDatabase localSQLiteDatabase = this$0;
      String str1 = mUri;
      String str2 = c;
      try
      {
        StringBuilder localStringBuilder = new StringBuilder();
        String str3 = x;
        localStringBuilder.append(str3);
        localStringBuilder.append("=\"");
        localStringBuilder.append(paramString);
        localStringBuilder.append("\"");
        paramString = localStringBuilder.toString();
        paramString = localSQLiteDatabase.query(str1, new String[] { str2 }, paramString, null, null, null, null);
        if (paramString != null)
        {
          boolean bool = paramString.moveToLast();
          if (bool) {
            do
            {
              localArrayList.add(paramString.getString(0));
              bool = paramString.moveToPrevious();
            } while (bool);
          }
          paramString.close();
        }
      }
      catch (Exception paramString)
      {
        k.a.a.m.StringBuilder.append(paramString);
      }
      append();
      return localArrayList;
    }
    catch (Throwable paramString)
    {
      throw paramString;
    }
  }
  
  public void open(String paramString1, String paramString2)
  {
    try
    {
      get();
      SQLiteDatabase localSQLiteDatabase = this$0;
      String str1 = mUri;
      try
      {
        StringBuilder localStringBuilder = new StringBuilder();
        String str2 = x;
        localStringBuilder.append(str2);
        localStringBuilder.append("=\"");
        localStringBuilder.append(paramString1);
        localStringBuilder.append("\" AND ");
        paramString1 = c;
        localStringBuilder.append(paramString1);
        localStringBuilder.append("=\"");
        localStringBuilder.append(paramString2);
        localStringBuilder.append("\"");
        localSQLiteDatabase.delete(str1, localStringBuilder.toString(), null);
      }
      catch (Exception paramString1)
      {
        k.a.a.m.StringBuilder.append(paramString1);
      }
      append();
      return;
    }
    catch (Throwable paramString1)
    {
      throw paramString1;
    }
  }
  
  public ArrayList parse()
    throws SQLException
  {
    try
    {
      ArrayList localArrayList = new ArrayList();
      get();
      Object localObject1 = this$0;
      Object localObject2 = URI;
      String str1 = out;
      String str2 = filter;
      String str3 = LOGGER;
      String str4 = separator;
      String str5 = user;
      String str6 = status;
      String str7 = mName;
      String str8 = FALSE;
      String str9 = args;
      String str10 = params;
      String str11 = longitude;
      String str12 = latitude;
      String str13 = authors;
      String str14 = hour;
      String str15 = minute;
      String str16 = message;
      String str17 = login;
      String str18 = offset;
      String str19 = payload;
      String str20 = min;
      String str21 = next;
      String str22 = token;
      String str23 = comment;
      String str24 = buf;
      String str25 = count;
      String str26 = value;
      String str27 = line;
      String str28 = names;
      String str29 = format;
      String str30 = language;
      String str31 = country;
      String str32 = state;
      String str33 = input;
      String str34 = source;
      String str35 = element;
      String str36 = START;
      String str37 = ROOT;
      String str38 = max;
      String str39 = INSTANCE;
      String str40 = db;
      String str41 = sql;
      String str42 = contentType;
      String str43 = filename;
      String str44 = url;
      String str45 = top;
      try
      {
        Object localObject3 = new StringBuilder();
        String str46 = separator;
        ((StringBuilder)localObject3).append(str46);
        ((StringBuilder)localObject3).append("=\"false\" AND ");
        str46 = db;
        ((StringBuilder)localObject3).append(str46);
        ((StringBuilder)localObject3).append("!=\"\"");
        localObject3 = ((StringBuilder)localObject3).toString();
        localObject1 = ((SQLiteDatabase)localObject1).query((String)localObject2, new String[] { str1, str2, str3, str4, str5, str6, str7, str8, str9, str10, str11, str12, str13, str14, str15, str16, str17, str18, str19, str20, str21, str22, str23, str24, str25, str26, str27, str28, str29, str30, str31, str32, str33, str34, str35, str36, str37, str38, str39, str40, str41, str42, str43, str44, str45 }, (String)localObject3, null, null, null, null);
        if (localObject1 != null)
        {
          boolean bool = ((Cursor)localObject1).moveToFirst();
          if (bool) {
            for (;;)
            {
              localObject2 = new S();
              ((S)localObject2).f(((Cursor)localObject1).getString(0));
              ((S)localObject2).B(((Cursor)localObject1).getString(1));
              ((S)localObject2).g(((Cursor)localObject1).getString(2));
              ((S)localObject2).y(((Cursor)localObject1).getString(3));
              ((S)localObject2).F(((Cursor)localObject1).getString(4));
              ((S)localObject2).i(((Cursor)localObject1).getString(5));
              ((S)localObject2).L(((Cursor)localObject1).getString(6));
              ((S)localObject2).M(((Cursor)localObject1).getString(7));
              ((S)localObject2).p(((Cursor)localObject1).getString(8));
              ((S)localObject2).q(((Cursor)localObject1).getString(9));
              ((S)localObject2).H(((Cursor)localObject1).getString(10));
              ((S)localObject2).k(((Cursor)localObject1).getString(11));
              ((S)localObject2).O(((Cursor)localObject1).getString(12));
              ((S)localObject2).N(((Cursor)localObject1).getString(13));
              ((S)localObject2).s(((Cursor)localObject1).getString(14));
              ((S)localObject2).r(((Cursor)localObject1).getString(15));
              ((S)localObject2).P(((Cursor)localObject1).getString(16));
              ((S)localObject2).t(((Cursor)localObject1).getString(17));
              ((S)localObject2).c(((Cursor)localObject1).getString(18));
              ((S)localObject2).C(((Cursor)localObject1).getString(19));
              ((S)localObject2).e(((Cursor)localObject1).getString(20));
              ((S)localObject2).A(((Cursor)localObject1).getString(21));
              ((S)localObject2).G(((Cursor)localObject1).getString(22));
              ((S)localObject2).j(((Cursor)localObject1).getString(23));
              ((S)localObject2).Q(((Cursor)localObject1).getString(24));
              ((S)localObject2).u(((Cursor)localObject1).getString(25));
              ((S)localObject2).R(((Cursor)localObject1).getString(26));
              ((S)localObject2).I(((Cursor)localObject1).getString(27));
              ((S)localObject2).n(((Cursor)localObject1).getString(28));
              ((S)localObject2).l(((Cursor)localObject1).getString(29));
              ((S)localObject2).K(((Cursor)localObject1).getString(30));
              ((S)localObject2).n(((Cursor)localObject1).getString(31));
              ((S)localObject2).J(((Cursor)localObject1).getString(32));
              ((S)localObject2).m(((Cursor)localObject1).getString(33));
              ((S)localObject2).E(((Cursor)localObject1).getString(34));
              ((S)localObject2).b(((Cursor)localObject1).getString(35));
              ((S)localObject2).x(((Cursor)localObject1).getString(36));
              ((S)localObject2).w(((Cursor)localObject1).getString(37));
              ((S)localObject2).d(((Cursor)localObject1).getString(38));
              ((S)localObject2).D(((Cursor)localObject1).getString(39));
              ((S)localObject2).S(((Cursor)localObject1).getString(40));
              ((S)localObject2).a(((Cursor)localObject1).getString(41));
              ((S)localObject2).h(((Cursor)localObject1).getString(42));
              ((S)localObject2).v(((Cursor)localObject1).getString(43));
              ((S)localObject2).z(((Cursor)localObject1).getString(44));
              localArrayList.add(localObject2);
              bool = ((Cursor)localObject1).moveToNext();
              if (!bool) {
                break;
              }
            }
          }
          ((Cursor)localObject1).close();
        }
      }
      catch (Exception localException)
      {
        k.a.a.m.StringBuilder.append(localException);
      }
      append();
      return localArrayList;
    }
    catch (Throwable localThrowable)
    {
      throw localThrowable;
    }
  }
  
  public ArrayList parse(String paramString1, String paramString2)
    throws SQLException
  {
    try
    {
      ArrayList localArrayList = new ArrayList();
      get();
      SQLiteDatabase localSQLiteDatabase = this$0;
      String str1 = URI;
      String str2 = out;
      String str3 = filter;
      String str4 = LOGGER;
      String str5 = separator;
      String str6 = user;
      String str7 = status;
      String str8 = mName;
      String str9 = FALSE;
      String str10 = args;
      String str11 = params;
      String str12 = longitude;
      String str13 = latitude;
      String str14 = authors;
      String str15 = hour;
      String str16 = minute;
      String str17 = message;
      String str18 = login;
      String str19 = offset;
      String str20 = payload;
      String str21 = min;
      String str22 = next;
      String str23 = token;
      String str24 = comment;
      String str25 = buf;
      String str26 = count;
      String str27 = value;
      String str28 = line;
      String str29 = names;
      String str30 = format;
      String str31 = language;
      String str32 = country;
      String str33 = state;
      String str34 = input;
      String str35 = source;
      String str36 = element;
      String str37 = START;
      String str38 = ROOT;
      String str39 = max;
      String str40 = INSTANCE;
      String str41 = db;
      String str42 = sql;
      String str43 = contentType;
      String str44 = filename;
      String str45 = url;
      String str46 = top;
      try
      {
        Object localObject1 = new StringBuilder();
        Object localObject2 = count;
        ((StringBuilder)localObject1).append((String)localObject2);
        ((StringBuilder)localObject1).append(">=? and ");
        localObject2 = count;
        ((StringBuilder)localObject1).append((String)localObject2);
        ((StringBuilder)localObject1).append("<=?");
        localObject1 = ((StringBuilder)localObject1).toString();
        localObject2 = new StringBuilder();
        String str47 = out;
        ((StringBuilder)localObject2).append(str47);
        ((StringBuilder)localObject2).append(" DESC");
        localObject2 = ((StringBuilder)localObject2).toString();
        paramString1 = localSQLiteDatabase.query(str1, new String[] { str2, str3, str4, str5, str6, str7, str8, str9, str10, str11, str12, str13, str14, str15, str16, str17, str18, str19, str20, str21, str22, str23, str24, str25, str26, str27, str28, str29, str30, str31, str32, str33, str34, str35, str36, str37, str38, str39, str40, str41, str42, str43, str44, str45, str46 }, (String)localObject1, new String[] { paramString1, paramString2 }, null, null, (String)localObject2);
        if (paramString1 != null)
        {
          boolean bool = paramString1.moveToFirst();
          if (bool) {
            for (;;)
            {
              paramString2 = new S();
              paramString2.f(paramString1.getString(0));
              paramString2.B(paramString1.getString(1));
              paramString2.g(paramString1.getString(2));
              paramString2.y(paramString1.getString(3));
              paramString2.F(paramString1.getString(4));
              paramString2.i(paramString1.getString(5));
              paramString2.L(paramString1.getString(6));
              paramString2.M(paramString1.getString(7));
              paramString2.p(paramString1.getString(8));
              paramString2.q(paramString1.getString(9));
              paramString2.H(paramString1.getString(10));
              paramString2.k(paramString1.getString(11));
              paramString2.O(paramString1.getString(12));
              paramString2.N(paramString1.getString(13));
              paramString2.s(paramString1.getString(14));
              paramString2.r(paramString1.getString(15));
              paramString2.P(paramString1.getString(16));
              paramString2.t(paramString1.getString(17));
              paramString2.c(paramString1.getString(18));
              paramString2.C(paramString1.getString(19));
              paramString2.e(paramString1.getString(20));
              paramString2.A(paramString1.getString(21));
              paramString2.G(paramString1.getString(22));
              paramString2.j(paramString1.getString(23));
              paramString2.Q(paramString1.getString(24));
              paramString2.u(paramString1.getString(25));
              paramString2.R(paramString1.getString(26));
              paramString2.I(paramString1.getString(27));
              paramString2.n(paramString1.getString(28));
              paramString2.l(paramString1.getString(29));
              paramString2.K(paramString1.getString(30));
              paramString2.n(paramString1.getString(31));
              paramString2.J(paramString1.getString(32));
              paramString2.m(paramString1.getString(33));
              paramString2.E(paramString1.getString(34));
              paramString2.b(paramString1.getString(35));
              paramString2.x(paramString1.getString(36));
              paramString2.w(paramString1.getString(37));
              paramString2.d(paramString1.getString(38));
              paramString2.D(paramString1.getString(39));
              paramString2.S(paramString1.getString(40));
              paramString2.a(paramString1.getString(41));
              paramString2.h(paramString1.getString(42));
              paramString2.v(paramString1.getString(43));
              paramString2.z(paramString1.getString(44));
              localArrayList.add(paramString2);
              bool = paramString1.moveToNext();
              if (!bool) {
                break;
              }
            }
          }
          paramString1.close();
        }
      }
      catch (Exception paramString1)
      {
        k.a.a.m.StringBuilder.append(paramString1);
      }
      append();
      return localArrayList;
    }
    catch (Throwable paramString1)
    {
      throw paramString1;
    }
  }
  
  public S parse(String paramString)
    throws SQLException
  {
    try
    {
      get();
      Object localObject = this$0;
      String str1 = URI;
      String str2 = out;
      String str3 = filter;
      String str4 = LOGGER;
      String str5 = separator;
      String str6 = user;
      String str7 = status;
      String str8 = mName;
      String str9 = FALSE;
      String str10 = args;
      String str11 = params;
      String str12 = longitude;
      String str13 = latitude;
      String str14 = authors;
      String str15 = hour;
      String str16 = minute;
      String str17 = message;
      String str18 = login;
      String str19 = offset;
      String str20 = payload;
      String str21 = min;
      String str22 = next;
      String str23 = token;
      String str24 = comment;
      String str25 = buf;
      String str26 = count;
      String str27 = value;
      String str28 = line;
      String str29 = names;
      String str30 = format;
      String str31 = language;
      String str32 = country;
      String str33 = state;
      String str34 = input;
      String str35 = source;
      String str36 = element;
      String str37 = START;
      String str38 = ROOT;
      String str39 = max;
      String str40 = INSTANCE;
      String str41 = db;
      String str42 = sql;
      String str43 = contentType;
      String str44 = filename;
      String str45 = url;
      String str46 = top;
      try
      {
        StringBuilder localStringBuilder = new StringBuilder();
        String str47 = out;
        localStringBuilder.append(str47);
        localStringBuilder.append("=\"");
        localStringBuilder.append(paramString);
        localStringBuilder.append("\"");
        paramString = localStringBuilder.toString();
        localObject = ((SQLiteDatabase)localObject).query(str1, new String[] { str2, str3, str4, str5, str6, str7, str8, str9, str10, str11, str12, str13, str14, str15, str16, str17, str18, str19, str20, str21, str22, str23, str24, str25, str26, str27, str28, str29, str30, str31, str32, str33, str34, str35, str36, str37, str38, str39, str40, str41, str42, str43, str44, str45, str46 }, paramString, null, null, null, null);
        if (localObject != null)
        {
          boolean bool = ((Cursor)localObject).moveToFirst();
          if (bool)
          {
            paramString = new S();
            try
            {
              paramString.f(((Cursor)localObject).getString(0));
              paramString.B(((Cursor)localObject).getString(1));
              paramString.g(((Cursor)localObject).getString(2));
              paramString.y(((Cursor)localObject).getString(3));
              paramString.F(((Cursor)localObject).getString(4));
              paramString.i(((Cursor)localObject).getString(5));
              paramString.L(((Cursor)localObject).getString(6));
              paramString.M(((Cursor)localObject).getString(7));
              paramString.p(((Cursor)localObject).getString(8));
              paramString.q(((Cursor)localObject).getString(9));
              paramString.H(((Cursor)localObject).getString(10));
              paramString.k(((Cursor)localObject).getString(11));
              paramString.O(((Cursor)localObject).getString(12));
              paramString.N(((Cursor)localObject).getString(13));
              paramString.s(((Cursor)localObject).getString(14));
              paramString.r(((Cursor)localObject).getString(15));
              paramString.P(((Cursor)localObject).getString(16));
              paramString.t(((Cursor)localObject).getString(17));
              paramString.c(((Cursor)localObject).getString(18));
              paramString.C(((Cursor)localObject).getString(19));
              paramString.e(((Cursor)localObject).getString(20));
              paramString.A(((Cursor)localObject).getString(21));
              paramString.G(((Cursor)localObject).getString(22));
              paramString.j(((Cursor)localObject).getString(23));
              paramString.Q(((Cursor)localObject).getString(24));
              paramString.u(((Cursor)localObject).getString(25));
              paramString.R(((Cursor)localObject).getString(26));
              paramString.I(((Cursor)localObject).getString(27));
              paramString.n(((Cursor)localObject).getString(28));
              paramString.l(((Cursor)localObject).getString(29));
              paramString.K(((Cursor)localObject).getString(30));
              paramString.n(((Cursor)localObject).getString(31));
              paramString.J(((Cursor)localObject).getString(32));
              paramString.m(((Cursor)localObject).getString(33));
              paramString.E(((Cursor)localObject).getString(34));
              paramString.b(((Cursor)localObject).getString(35));
              paramString.x(((Cursor)localObject).getString(36));
              paramString.w(((Cursor)localObject).getString(37));
              paramString.d(((Cursor)localObject).getString(38));
              paramString.D(((Cursor)localObject).getString(39));
              paramString.S(((Cursor)localObject).getString(40));
              paramString.a(((Cursor)localObject).getString(41));
              paramString.h(((Cursor)localObject).getString(42));
              paramString.v(((Cursor)localObject).getString(43));
              paramString.z(((Cursor)localObject).getString(44));
            }
            catch (Exception localException1)
            {
              break label1163;
            }
          }
          else
          {
            paramString = null;
          }
          try
          {
            localException1.close();
          }
          catch (Exception localException2)
          {
            break label1163;
          }
        }
        else
        {
          paramString = null;
        }
      }
      catch (Exception localException3)
      {
        paramString = null;
        label1163:
        k.a.a.m.StringBuilder.append(localException3);
      }
      append();
      return paramString;
    }
    catch (Throwable paramString)
    {
      throw paramString;
    }
  }
  
  public void parse(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8, String paramString9, String paramString10, String paramString11, String paramString12, String paramString13, String paramString14, String paramString15, String paramString16, String paramString17, String paramString18, String paramString19, String paramString20, String paramString21)
  {
    try
    {
      paramString1 = exec(paramString1);
      if (!paramString1.isEmpty())
      {
        get();
        try
        {
          ContentValues localContentValues = new ContentValues();
          String str = status;
          localContentValues.put(str, paramString2);
          paramString2 = args;
          localContentValues.put(paramString2, paramString3);
          paramString2 = params;
          localContentValues.put(paramString2, paramString4);
          paramString2 = latitude;
          localContentValues.put(paramString2, paramString5);
          paramString2 = minute;
          localContentValues.put(paramString2, paramString6);
          paramString2 = message;
          localContentValues.put(paramString2, paramString7);
          paramString2 = offset;
          localContentValues.put(paramString2, paramString8);
          paramString2 = payload;
          localContentValues.put(paramString2, paramString9);
          paramString2 = next;
          localContentValues.put(paramString2, paramString10);
          paramString2 = buf;
          localContentValues.put(paramString2, paramString11);
          paramString2 = value;
          localContentValues.put(paramString2, paramString12);
          paramString2 = format;
          localContentValues.put(paramString2, paramString13);
          paramString2 = language;
          localContentValues.put(paramString2, paramString14);
          paramString2 = state;
          localContentValues.put(paramString2, paramString15);
          paramString2 = source;
          localContentValues.put(paramString2, paramString16);
          paramString2 = element;
          localContentValues.put(paramString2, paramString17);
          paramString2 = START;
          localContentValues.put(paramString2, paramString18);
          paramString2 = ROOT;
          localContentValues.put(paramString2, paramString19);
          paramString2 = max;
          localContentValues.put(paramString2, paramString20);
          paramString2 = sql;
          localContentValues.put(paramString2, paramString21);
          paramString2 = this$0;
          paramString3 = URI;
          paramString4 = new StringBuilder();
          paramString5 = out;
          paramString4.append(paramString5);
          paramString4.append("=\"");
          paramString4.append(paramString1);
          paramString4.append("\"");
          paramString2.update(paramString3, localContentValues, paramString4.toString(), null);
        }
        catch (Exception paramString1)
        {
          k.a.a.m.StringBuilder.append(paramString1);
        }
        append();
      }
      return;
    }
    catch (Throwable paramString1)
    {
      throw paramString1;
    }
  }
  
  public void parse(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8, String paramString9, String paramString10, String paramString11, String paramString12, String paramString13, String paramString14, String paramString15, String paramString16, String paramString17, String paramString18, String paramString19, String paramString20, String paramString21, String paramString22, String paramString23, String paramString24, String paramString25, String paramString26, String paramString27, String paramString28, String paramString29, String paramString30, String paramString31, String paramString32, String paramString33, String paramString34, String paramString35, String paramString36, String paramString37, String paramString38, String paramString39, String paramString40, String paramString41, String paramString42, String paramString43, String paramString44)
  {
    try
    {
      get();
      try
      {
        ContentValues localContentValues = new ContentValues();
        String str = filter;
        localContentValues.put(str, paramString1);
        paramString1 = LOGGER;
        localContentValues.put(paramString1, paramString2);
        paramString1 = separator;
        localContentValues.put(paramString1, paramString3);
        paramString1 = user;
        localContentValues.put(paramString1, paramString4);
        paramString1 = status;
        localContentValues.put(paramString1, paramString5);
        paramString1 = mName;
        localContentValues.put(paramString1, paramString6);
        paramString1 = FALSE;
        localContentValues.put(paramString1, paramString7);
        paramString1 = args;
        localContentValues.put(paramString1, paramString8);
        paramString1 = params;
        localContentValues.put(paramString1, paramString9);
        paramString1 = longitude;
        localContentValues.put(paramString1, paramString10);
        paramString1 = latitude;
        localContentValues.put(paramString1, paramString11);
        paramString1 = authors;
        localContentValues.put(paramString1, paramString12);
        paramString1 = hour;
        localContentValues.put(paramString1, paramString13);
        paramString1 = minute;
        localContentValues.put(paramString1, paramString14);
        paramString1 = message;
        localContentValues.put(paramString1, paramString15);
        paramString1 = login;
        localContentValues.put(paramString1, paramString16);
        paramString1 = offset;
        localContentValues.put(paramString1, paramString17);
        paramString1 = payload;
        localContentValues.put(paramString1, paramString18);
        paramString1 = min;
        localContentValues.put(paramString1, paramString19);
        paramString1 = next;
        localContentValues.put(paramString1, paramString20);
        paramString1 = token;
        localContentValues.put(paramString1, paramString21);
        paramString1 = comment;
        localContentValues.put(paramString1, paramString22);
        paramString1 = buf;
        localContentValues.put(paramString1, paramString23);
        paramString1 = count;
        localContentValues.put(paramString1, paramString24);
        paramString1 = value;
        localContentValues.put(paramString1, paramString25);
        paramString1 = line;
        localContentValues.put(paramString1, paramString26);
        paramString1 = names;
        localContentValues.put(paramString1, paramString27);
        paramString1 = format;
        localContentValues.put(paramString1, paramString28);
        paramString1 = language;
        localContentValues.put(paramString1, paramString29);
        paramString1 = country;
        localContentValues.put(paramString1, paramString30);
        paramString1 = state;
        localContentValues.put(paramString1, paramString31);
        paramString1 = input;
        localContentValues.put(paramString1, paramString32);
        paramString1 = source;
        localContentValues.put(paramString1, paramString33);
        paramString1 = element;
        localContentValues.put(paramString1, paramString34);
        paramString1 = START;
        localContentValues.put(paramString1, paramString35);
        paramString1 = ROOT;
        localContentValues.put(paramString1, paramString36);
        paramString1 = max;
        localContentValues.put(paramString1, paramString37);
        paramString1 = INSTANCE;
        localContentValues.put(paramString1, paramString38);
        paramString1 = db;
        localContentValues.put(paramString1, paramString39);
        paramString1 = sql;
        localContentValues.put(paramString1, paramString40);
        paramString1 = contentType;
        localContentValues.put(paramString1, paramString41);
        paramString1 = filename;
        localContentValues.put(paramString1, paramString42);
        paramString1 = url;
        localContentValues.put(paramString1, paramString43);
        paramString1 = top;
        localContentValues.put(paramString1, paramString44);
        paramString1 = this$0;
        paramString2 = URI;
        paramString1.insert(paramString2, null, localContentValues);
      }
      catch (Exception paramString1)
      {
        k.a.a.m.StringBuilder.append(paramString1);
      }
      append();
      return;
    }
    catch (Throwable paramString1)
    {
      throw paramString1;
    }
  }
  
  public void parseAndAdd()
  {
    try
    {
      get();
      SQLiteDatabase localSQLiteDatabase = this$0;
      String str = table;
      try
      {
        localSQLiteDatabase.delete(str, null, null);
      }
      catch (Exception localException)
      {
        k.a.a.m.StringBuilder.append(localException);
      }
      append();
      return;
    }
    catch (Throwable localThrowable)
    {
      throw localThrowable;
    }
  }
  
  public ArrayList process()
    throws SQLException
  {
    try
    {
      ArrayList localArrayList = new ArrayList();
      get();
      Object localObject1 = this$0;
      Object localObject2 = size;
      String str1 = c;
      String str2 = left;
      String str3 = a;
      String str4 = b;
      String str5 = TAG;
      String str6 = first;
      String str7 = length;
      String str8 = position;
      String str9 = root;
      String str10 = directory;
      String str11 = cache;
      String str12 = parent;
      String str13 = activity;
      String str14 = logger;
      String str15 = DEBUG;
      String str16 = helper;
      String str17 = this$1;
      String str18 = index;
      String str19 = key;
      String str20 = log;
      String str21 = queue;
      String str22 = LOG;
      String str23 = lock;
      String str24 = $assertionsDisabled;
      String str25 = level;
      String str26 = type;
      String str27 = data;
      String str28 = text;
      try
      {
        Object localObject3 = new StringBuilder();
        Object localObject4 = type;
        ((StringBuilder)localObject3).append((String)localObject4);
        ((StringBuilder)localObject3).append("!=\"I\"");
        localObject3 = ((StringBuilder)localObject3).toString();
        localObject4 = new StringBuilder();
        String str29 = left;
        ((StringBuilder)localObject4).append(str29);
        ((StringBuilder)localObject4).append(" COLLATE NOCASE ASC");
        localObject4 = ((StringBuilder)localObject4).toString();
        localObject1 = ((SQLiteDatabase)localObject1).query((String)localObject2, new String[] { str1, str2, str3, str4, str5, str6, str7, str8, str9, str10, str11, str12, str13, str14, str15, str16, str17, str18, str19, str20, str21, str22, str23, str24, str25, str26, str27, str28 }, (String)localObject3, null, null, null, (String)localObject4);
        if (localObject1 != null)
        {
          boolean bool = ((Cursor)localObject1).moveToFirst();
          if (bool) {
            for (;;)
            {
              localObject2 = new Log();
              ((Log)localObject2).getName(((Cursor)localObject1).getString(0));
              ((Log)localObject2).read(((Cursor)localObject1).getString(1));
              ((Log)localObject2).size(((Cursor)localObject1).getString(2));
              ((Log)localObject2).trim(((Cursor)localObject1).getString(3));
              ((Log)localObject2).split(((Cursor)localObject1).getString(4));
              ((Log)localObject2).write(((Cursor)localObject1).getString(5));
              ((Log)localObject2).execute(((Cursor)localObject1).getString(6));
              ((Log)localObject2).v(((Cursor)localObject1).getString(7));
              ((Log)localObject2).add(((Cursor)localObject1).getString(8));
              ((Log)localObject2).log(((Cursor)localObject1).getString(9));
              ((Log)localObject2).append(((Cursor)localObject1).getString(10));
              ((Log)localObject2).valueOf(Boolean.parseBoolean(((Cursor)localObject1).getString(11)));
              ((Log)localObject2).set(Boolean.parseBoolean(((Cursor)localObject1).getString(12)));
              ((Log)localObject2).d(((Cursor)localObject1).getString(13));
              ((Log)localObject2).add(Boolean.parseBoolean(((Cursor)localObject1).getString(14)));
              ((Log)localObject2).print(((Cursor)localObject1).getString(15));
              ((Log)localObject2).get(((Cursor)localObject1).getString(16));
              ((Log)localObject2).next(((Cursor)localObject1).getString(17));
              ((Log)localObject2).equals(((Cursor)localObject1).getString(18));
              ((Log)localObject2).set(((Cursor)localObject1).getString(19));
              ((Log)localObject2).start(((Cursor)localObject1).getString(20));
              ((Log)localObject2).put(((Cursor)localObject1).getString(21));
              ((Log)localObject2).update(((Cursor)localObject1).getString(22));
              ((Log)localObject2).toString(((Cursor)localObject1).getString(23));
              ((Log)localObject2).close(((Cursor)localObject1).getString(24));
              ((Log)localObject2).w(((Cursor)localObject1).getString(25));
              ((Log)localObject2).name(((Cursor)localObject1).getString(26));
              ((Log)localObject2).format(((Cursor)localObject1).getString(27));
              localArrayList.add(localObject2);
              bool = ((Cursor)localObject1).moveToNext();
              if (!bool) {
                break;
              }
            }
          }
          ((Cursor)localObject1).close();
        }
      }
      catch (Exception localException)
      {
        k.a.a.m.StringBuilder.append(localException);
      }
      append();
      return localArrayList;
    }
    catch (Throwable localThrowable)
    {
      throw localThrowable;
    }
  }
  
  public ArrayList read()
    throws SQLException
  {
    try
    {
      ArrayList localArrayList = new ArrayList();
      get();
      Object localObject1 = this$0;
      Object localObject2 = context;
      String str1 = c;
      String str2 = left;
      String str3 = a;
      String str4 = b;
      String str5 = TAG;
      String str6 = first;
      String str7 = length;
      String str8 = position;
      String str9 = root;
      String str10 = directory;
      String str11 = cache;
      String str12 = parent;
      String str13 = activity;
      String str14 = logger;
      String str15 = DEBUG;
      String str16 = helper;
      String str17 = this$1;
      String str18 = index;
      String str19 = key;
      String str20 = log;
      String str21 = queue;
      String str22 = LOG;
      String str23 = lock;
      String str24 = $assertionsDisabled;
      String str25 = level;
      String str26 = type;
      String str27 = file;
      String str28 = data;
      String str29 = text;
      try
      {
        Object localObject3 = new StringBuilder();
        Object localObject4 = parent;
        ((StringBuilder)localObject3).append((String)localObject4);
        ((StringBuilder)localObject3).append("=\"true\"");
        localObject3 = ((StringBuilder)localObject3).toString();
        localObject4 = new StringBuilder();
        String str30 = left;
        ((StringBuilder)localObject4).append(str30);
        ((StringBuilder)localObject4).append(" COLLATE NOCASE ASC");
        localObject4 = ((StringBuilder)localObject4).toString();
        localObject1 = ((SQLiteDatabase)localObject1).query((String)localObject2, new String[] { str1, str2, str3, str4, str5, str6, str7, str8, str9, str10, str11, str12, str13, str14, str15, str16, str17, str18, str19, str20, str21, str22, str23, str24, str25, str26, str27, str28, str29 }, (String)localObject3, null, null, null, (String)localObject4);
        if (localObject1 != null)
        {
          boolean bool = ((Cursor)localObject1).moveToFirst();
          if (bool) {
            for (;;)
            {
              localObject2 = new Log();
              ((Log)localObject2).getName(((Cursor)localObject1).getString(0));
              ((Log)localObject2).read(((Cursor)localObject1).getString(1));
              ((Log)localObject2).size(((Cursor)localObject1).getString(2));
              ((Log)localObject2).trim(((Cursor)localObject1).getString(3));
              ((Log)localObject2).split(((Cursor)localObject1).getString(4));
              ((Log)localObject2).write(((Cursor)localObject1).getString(5));
              ((Log)localObject2).execute(((Cursor)localObject1).getString(6));
              ((Log)localObject2).v(((Cursor)localObject1).getString(7));
              ((Log)localObject2).add(((Cursor)localObject1).getString(8));
              ((Log)localObject2).log(((Cursor)localObject1).getString(9));
              ((Log)localObject2).append(((Cursor)localObject1).getString(10));
              ((Log)localObject2).valueOf(Boolean.parseBoolean(((Cursor)localObject1).getString(11)));
              ((Log)localObject2).set(Boolean.parseBoolean(((Cursor)localObject1).getString(12)));
              ((Log)localObject2).d(((Cursor)localObject1).getString(13));
              ((Log)localObject2).add(Boolean.parseBoolean(((Cursor)localObject1).getString(14)));
              ((Log)localObject2).print(((Cursor)localObject1).getString(15));
              ((Log)localObject2).get(((Cursor)localObject1).getString(16));
              ((Log)localObject2).next(((Cursor)localObject1).getString(17));
              ((Log)localObject2).equals(((Cursor)localObject1).getString(18));
              ((Log)localObject2).set(((Cursor)localObject1).getString(19));
              ((Log)localObject2).start(((Cursor)localObject1).getString(20));
              ((Log)localObject2).put(((Cursor)localObject1).getString(21));
              ((Log)localObject2).update(((Cursor)localObject1).getString(22));
              ((Log)localObject2).toString(((Cursor)localObject1).getString(23));
              ((Log)localObject2).close(((Cursor)localObject1).getString(24));
              ((Log)localObject2).w(((Cursor)localObject1).getString(25));
              ((Log)localObject2).e(((Cursor)localObject1).getString(26));
              ((Log)localObject2).name(((Cursor)localObject1).getString(27));
              ((Log)localObject2).format(((Cursor)localObject1).getString(28));
              localArrayList.add(localObject2);
              bool = ((Cursor)localObject1).moveToNext();
              if (!bool) {
                break;
              }
            }
          }
          ((Cursor)localObject1).close();
        }
      }
      catch (Exception localException)
      {
        k.a.a.m.StringBuilder.append(localException);
      }
      append();
      return localArrayList;
    }
    catch (Throwable localThrowable)
    {
      throw localThrowable;
    }
  }
  
  public Log read(String paramString)
    throws SQLException
  {
    try
    {
      get();
      Object localObject = this$0;
      String str1 = context;
      String str2 = c;
      String str3 = left;
      String str4 = a;
      String str5 = b;
      String str6 = TAG;
      String str7 = first;
      String str8 = length;
      String str9 = position;
      String str10 = root;
      String str11 = directory;
      String str12 = cache;
      String str13 = parent;
      String str14 = activity;
      String str15 = logger;
      String str16 = DEBUG;
      String str17 = helper;
      String str18 = this$1;
      String str19 = index;
      String str20 = key;
      String str21 = log;
      String str22 = queue;
      String str23 = LOG;
      String str24 = lock;
      String str25 = $assertionsDisabled;
      String str26 = level;
      String str27 = type;
      String str28 = file;
      String str29 = data;
      String str30 = text;
      try
      {
        StringBuilder localStringBuilder = new StringBuilder();
        String str31 = c;
        localStringBuilder.append(str31);
        localStringBuilder.append("=\"");
        localStringBuilder.append(paramString);
        localStringBuilder.append("\"");
        paramString = localStringBuilder.toString();
        localObject = ((SQLiteDatabase)localObject).query(str1, new String[] { str2, str3, str4, str5, str6, str7, str8, str9, str10, str11, str12, str13, str14, str15, str16, str17, str18, str19, str20, str21, str22, str23, str24, str25, str26, str27, str28, str29, str30 }, paramString, null, null, null, null);
        if (localObject != null)
        {
          boolean bool = ((Cursor)localObject).moveToFirst();
          if (bool)
          {
            paramString = new Log();
            try
            {
              paramString.getName(((Cursor)localObject).getString(0));
              paramString.read(((Cursor)localObject).getString(1));
              paramString.size(((Cursor)localObject).getString(2));
              paramString.trim(((Cursor)localObject).getString(3));
              paramString.split(((Cursor)localObject).getString(4));
              paramString.write(((Cursor)localObject).getString(5));
              paramString.execute(((Cursor)localObject).getString(6));
              paramString.v(((Cursor)localObject).getString(7));
              paramString.add(((Cursor)localObject).getString(8));
              paramString.log(((Cursor)localObject).getString(9));
              paramString.append(((Cursor)localObject).getString(10));
              paramString.valueOf(Boolean.parseBoolean(((Cursor)localObject).getString(11)));
              paramString.set(Boolean.parseBoolean(((Cursor)localObject).getString(12)));
              paramString.d(((Cursor)localObject).getString(13));
              paramString.add(Boolean.parseBoolean(((Cursor)localObject).getString(14)));
              paramString.print(((Cursor)localObject).getString(15));
              paramString.get(((Cursor)localObject).getString(16));
              paramString.next(((Cursor)localObject).getString(17));
              paramString.equals(((Cursor)localObject).getString(18));
              paramString.set(((Cursor)localObject).getString(19));
              paramString.start(((Cursor)localObject).getString(20));
              paramString.put(((Cursor)localObject).getString(21));
              paramString.update(((Cursor)localObject).getString(22));
              paramString.toString(((Cursor)localObject).getString(23));
              paramString.close(((Cursor)localObject).getString(24));
              paramString.w(((Cursor)localObject).getString(25));
              paramString.e(((Cursor)localObject).getString(26));
              paramString.name(((Cursor)localObject).getString(27));
              paramString.format(((Cursor)localObject).getString(28));
            }
            catch (Exception localException1)
            {
              break label804;
            }
          }
          else
          {
            paramString = null;
          }
          try
          {
            localException1.close();
          }
          catch (Exception localException2)
          {
            break label804;
          }
        }
        else
        {
          paramString = null;
        }
      }
      catch (Exception localException3)
      {
        paramString = null;
        label804:
        k.a.a.m.StringBuilder.append(localException3);
      }
      append();
      return paramString;
    }
    catch (Throwable paramString)
    {
      throw paramString;
    }
  }
  
  public void read(String paramString1, String paramString2)
  {
    try
    {
      get();
      try
      {
        ContentValues localContentValues = new ContentValues();
        String str1 = arretId;
        localContentValues.put(str1, paramString2);
        paramString2 = this$0;
        str1 = i;
        StringBuilder localStringBuilder = new StringBuilder();
        String str2 = NULL;
        localStringBuilder.append(str2);
        localStringBuilder.append("=\"");
        localStringBuilder.append(paramString1);
        localStringBuilder.append("\"");
        paramString2.update(str1, localContentValues, localStringBuilder.toString(), null);
      }
      catch (Exception paramString1)
      {
        k.a.a.m.StringBuilder.append(paramString1);
      }
      append();
      return;
    }
    catch (Throwable paramString1)
    {
      throw paramString1;
    }
  }
  
  public String remove(String paramString)
    throws SQLException
  {
    String str2 = "en";
    try
    {
      get();
      Object localObject = this$0;
      String str3 = size;
      String str4 = log;
      String str1 = str2;
      try
      {
        StringBuilder localStringBuilder = new StringBuilder();
        String str5 = c;
        str1 = str2;
        localStringBuilder.append(str5);
        str1 = str2;
        localStringBuilder.append("=\"");
        str1 = str2;
        localStringBuilder.append(paramString);
        str1 = str2;
        localStringBuilder.append("\"");
        str1 = str2;
        paramString = localStringBuilder.toString();
        str1 = str2;
        localObject = ((SQLiteDatabase)localObject).query(str3, new String[] { str4 }, paramString, null, null, null, null);
        paramString = str2;
        if (localObject != null)
        {
          str1 = str2;
          boolean bool = ((Cursor)localObject).moveToFirst();
          paramString = str2;
          if (bool)
          {
            str1 = str2;
            paramString = ((Cursor)localObject).getString(0);
          }
          str1 = paramString;
          ((Cursor)localObject).close();
        }
      }
      catch (Exception paramString)
      {
        k.a.a.m.StringBuilder.append(paramString);
        paramString = str1;
      }
      append();
      return paramString;
    }
    catch (Throwable paramString)
    {
      throw paramString;
    }
  }
  
  public void remove()
  {
    try
    {
      get();
      SQLiteDatabase localSQLiteDatabase = this$0;
      String str = cursor;
      try
      {
        localSQLiteDatabase.delete(str, null, null);
      }
      catch (Exception localException)
      {
        k.a.a.m.StringBuilder.append(localException);
      }
      append();
      return;
    }
    catch (Throwable localThrowable)
    {
      throw localThrowable;
    }
  }
  
  public void reset()
  {
    try
    {
      get();
      SQLiteDatabase localSQLiteDatabase = this$0;
      String str = CONTENT_URI;
      try
      {
        localSQLiteDatabase.delete(str, null, null);
      }
      catch (Exception localException)
      {
        k.a.a.m.StringBuilder.append(localException);
      }
      append();
      return;
    }
    catch (Throwable localThrowable)
    {
      throw localThrowable;
    }
  }
  
  public void reset(String paramString)
  {
    try
    {
      get();
      try
      {
        ContentValues localContentValues = new ContentValues();
        String str = title;
        localContentValues.put(str, paramString);
        paramString = this$0;
        str = CONTENT_URI;
        paramString.insert(str, null, localContentValues);
      }
      catch (Exception paramString)
      {
        k.a.a.m.StringBuilder.append(paramString);
      }
      append();
      return;
    }
    catch (Throwable paramString)
    {
      throw paramString;
    }
  }
  
  public void reset(String paramString1, String paramString2)
  {
    try
    {
      get();
      try
      {
        ContentValues localContentValues = new ContentValues();
        String str1 = queue;
        localContentValues.put(str1, paramString2);
        paramString2 = this$0;
        str1 = context;
        StringBuilder localStringBuilder = new StringBuilder();
        String str2 = c;
        localStringBuilder.append(str2);
        localStringBuilder.append("=\"");
        localStringBuilder.append(paramString1);
        localStringBuilder.append("\"");
        paramString2.update(str1, localContentValues, localStringBuilder.toString(), null);
      }
      catch (Exception paramString1)
      {
        k.a.a.m.StringBuilder.append(paramString1);
      }
      append();
      return;
    }
    catch (Throwable paramString1)
    {
      throw paramString1;
    }
  }
  
  public ArrayList run()
    throws SQLException
  {
    try
    {
      ArrayList localArrayList = new ArrayList();
      get();
      Object localObject1 = this$0;
      Object localObject2 = mContext;
      String str1 = LOG_TAG;
      String str2 = g;
      String str3 = j;
      String str4 = l;
      String str5 = view;
      String str6 = type;
      try
      {
        localObject1 = ((SQLiteDatabase)localObject1).query((String)localObject2, new String[] { str1, str2, str3, str4, str5, str6 }, null, null, null, null, null);
        if (localObject1 != null)
        {
          boolean bool = ((Cursor)localObject1).moveToFirst();
          if (bool) {
            do
            {
              localObject2 = new d();
              ((d)localObject2).e(((Cursor)localObject1).getString(0));
              ((d)localObject2).a(((Cursor)localObject1).getString(1));
              ((d)localObject2).b(((Cursor)localObject1).getString(2));
              ((d)localObject2).d(((Cursor)localObject1).getString(3));
              ((d)localObject2).c(((Cursor)localObject1).getString(4));
              ((d)localObject2).f(((Cursor)localObject1).getString(5));
              localArrayList.add(localObject2);
              bool = ((Cursor)localObject1).moveToNext();
            } while (bool);
          }
          ((Cursor)localObject1).close();
        }
      }
      catch (Exception localException)
      {
        k.a.a.m.StringBuilder.append(localException);
      }
      append();
      return localArrayList;
    }
    catch (Throwable localThrowable)
    {
      throw localThrowable;
    }
  }
  
  public ArrayList run(String paramString)
    throws SQLException
  {
    try
    {
      ArrayList localArrayList = new ArrayList();
      get();
      Object localObject1 = this$0;
      String str1 = p;
      String str2 = q;
      String str3 = s;
      String str4 = e;
      String str5 = port;
      String str6 = realm;
      String str7 = query;
      String str8 = h;
      String str9 = board;
      String str10 = start;
      String str11 = server;
      String str12 = to;
      String str13 = from;
      String str14 = time;
      String str15 = thread;
      String str16 = host;
      String str17 = packageName;
      String str18 = image;
      String str19 = CENTER;
      try
      {
        Object localObject2 = new StringBuilder();
        String str20 = x;
        ((StringBuilder)localObject2).append(str20);
        ((StringBuilder)localObject2).append("=\"");
        ((StringBuilder)localObject2).append(paramString);
        ((StringBuilder)localObject2).append("\"");
        paramString = ((StringBuilder)localObject2).toString();
        localObject2 = q;
        paramString = ((SQLiteDatabase)localObject1).query(str1, new String[] { str2, str3, str4, str5, str6, str7, str8, str9, str10, str11, str12, str13, str14, str15, str16, str17, str18, str19 }, paramString, null, (String)localObject2, null, null);
        if (paramString != null)
        {
          boolean bool = paramString.moveToFirst();
          if (bool) {
            for (;;)
            {
              localObject1 = new k.a.a.c.f();
              ((k.a.a.c.f)localObject1).c(paramString.getString(0));
              ((k.a.a.c.f)localObject1).b(paramString.getString(1));
              ((k.a.a.c.f)localObject1).d(paramString.getString(2));
              ((k.a.a.c.f)localObject1).e(paramString.getString(3));
              ((k.a.a.c.f)localObject1).f(paramString.getString(4));
              ((k.a.a.c.f)localObject1).g(paramString.getString(5));
              ((k.a.a.c.f)localObject1).o(paramString.getString(6));
              ((k.a.a.c.f)localObject1).j(paramString.getString(7));
              ((k.a.a.c.f)localObject1).m(paramString.getString(8));
              ((k.a.a.c.f)localObject1).r(paramString.getString(9));
              ((k.a.a.c.f)localObject1).p(paramString.getString(10));
              ((k.a.a.c.f)localObject1).k(paramString.getString(11));
              ((k.a.a.c.f)localObject1).i(paramString.getString(12));
              ((k.a.a.c.f)localObject1).l(paramString.getString(13));
              ((k.a.a.c.f)localObject1).n(paramString.getString(14));
              ((k.a.a.c.f)localObject1).q(paramString.getString(15));
              ((k.a.a.c.f)localObject1).a(paramString.getString(16));
              ((k.a.a.c.f)localObject1).h(paramString.getString(17));
              localArrayList.add(localObject1);
              bool = paramString.moveToNext();
              if (!bool) {
                break;
              }
            }
          }
          paramString.close();
        }
      }
      catch (Exception paramString)
      {
        k.a.a.m.StringBuilder.append(paramString);
      }
      append();
      return localArrayList;
    }
    catch (Throwable paramString)
    {
      throw paramString;
    }
  }
  
  public void save(String paramString)
  {
    try
    {
      get();
      try
      {
        ContentValues localContentValues = new ContentValues();
        Object localObject = separator;
        localContentValues.put((String)localObject, "true");
        localObject = this$0;
        String str1 = URI;
        StringBuilder localStringBuilder = new StringBuilder();
        String str2 = out;
        localStringBuilder.append(str2);
        localStringBuilder.append("=\"");
        localStringBuilder.append(paramString);
        localStringBuilder.append("\"");
        ((SQLiteDatabase)localObject).update(str1, localContentValues, localStringBuilder.toString(), null);
      }
      catch (Exception paramString)
      {
        k.a.a.m.StringBuilder.append(paramString);
      }
      append();
      return;
    }
    catch (Throwable paramString)
    {
      throw paramString;
    }
  }
  
  public ArrayList search()
    throws SQLException
  {
    try
    {
      ArrayList localArrayList = new ArrayList();
      get();
      Object localObject = this$0;
      String str1 = res;
      String str2 = c;
      try
      {
        localObject = ((SQLiteDatabase)localObject).query(str1, new String[] { str2 }, null, null, null, null, null);
        if (localObject != null)
        {
          boolean bool = ((Cursor)localObject).moveToLast();
          if (bool) {
            do
            {
              localArrayList.add(((Cursor)localObject).getString(0));
              bool = ((Cursor)localObject).moveToPrevious();
            } while (bool);
          }
          ((Cursor)localObject).close();
        }
      }
      catch (Exception localException)
      {
        k.a.a.m.StringBuilder.append(localException);
      }
      append();
      return localArrayList;
    }
    catch (Throwable localThrowable)
    {
      throw localThrowable;
    }
  }
  
  public void search(String paramString)
  {
    try
    {
      get();
      try
      {
        Object localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("SERVICE ID : ");
        ((StringBuilder)localObject1).append(paramString);
        ((StringBuilder)localObject1).toString();
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("select * from ");
        Object localObject2 = res;
        ((StringBuilder)localObject1).append((String)localObject2);
        localObject2 = ((StringBuilder)localObject1).toString();
        localObject1 = this$0;
        localObject1 = ((SQLiteDatabase)localObject1).rawQuery((String)localObject2, null);
        if (localObject1 != null)
        {
          boolean bool = ((Cursor)localObject1).moveToFirst();
          Object localObject4;
          Object localObject5;
          Object localObject6;
          if (bool) {
            do
            {
              bool = ((Cursor)localObject1).getString(1).equalsIgnoreCase(paramString);
              if (bool)
              {
                localObject3 = this$0;
                localObject4 = res;
                localObject5 = new StringBuilder();
                localObject6 = c;
                ((StringBuilder)localObject5).append((String)localObject6);
                ((StringBuilder)localObject5).append("=\"");
                ((StringBuilder)localObject5).append(paramString);
                ((StringBuilder)localObject5).append("\"");
                ((SQLiteDatabase)localObject3).delete((String)localObject4, ((StringBuilder)localObject5).toString(), null);
              }
              bool = ((Cursor)localObject1).moveToNext();
            } while (bool);
          }
          Object localObject3 = this$0;
          localObject2 = ((SQLiteDatabase)localObject3).rawQuery((String)localObject2, null);
          localObject3 = new StringBuilder();
          ((StringBuilder)localObject3).append("COUNT : ");
          ((StringBuilder)localObject3).append(((Cursor)localObject2).getCount());
          ((StringBuilder)localObject3).toString();
          int k = ((Cursor)localObject2).getCount();
          if (k < 5)
          {
            localObject3 = new ContentValues();
            localObject4 = c;
            ((ContentValues)localObject3).put((String)localObject4, paramString);
            paramString = this$0;
            localObject4 = res;
            paramString.insert((String)localObject4, null, (ContentValues)localObject3);
          }
          else
          {
            bool = ((Cursor)localObject2).moveToFirst();
            if (bool)
            {
              localObject3 = ((Cursor)localObject2).getString(1);
              localObject4 = this$0;
              localObject5 = res;
              localObject6 = new StringBuilder();
              String str = c;
              ((StringBuilder)localObject6).append(str);
              ((StringBuilder)localObject6).append("=\"");
              ((StringBuilder)localObject6).append((String)localObject3);
              ((StringBuilder)localObject6).append("\"");
              ((SQLiteDatabase)localObject4).delete((String)localObject5, ((StringBuilder)localObject6).toString(), null);
              localObject3 = new ContentValues();
              localObject4 = c;
              ((ContentValues)localObject3).put((String)localObject4, paramString);
              paramString = this$0;
              localObject4 = res;
              paramString.insert((String)localObject4, null, (ContentValues)localObject3);
            }
          }
          ((Cursor)localObject2).close();
          ((Cursor)localObject1).close();
        }
      }
      catch (Exception paramString)
      {
        k.a.a.m.StringBuilder.append(paramString);
      }
      append();
      return;
    }
    catch (Throwable paramString)
    {
      throw paramString;
    }
  }
  
  public String serialize(String paramString)
    throws SQLException
  {
    String str2 = "en";
    try
    {
      get();
      Object localObject = this$0;
      String str3 = size;
      String str4 = position;
      String str1 = str2;
      try
      {
        StringBuilder localStringBuilder = new StringBuilder();
        String str5 = c;
        str1 = str2;
        localStringBuilder.append(str5);
        str1 = str2;
        localStringBuilder.append("=\"");
        str1 = str2;
        localStringBuilder.append(paramString);
        str1 = str2;
        localStringBuilder.append("\"");
        str1 = str2;
        paramString = localStringBuilder.toString();
        str1 = str2;
        localObject = ((SQLiteDatabase)localObject).query(str3, new String[] { str4 }, paramString, null, null, null, null);
        paramString = str2;
        if (localObject != null)
        {
          str1 = str2;
          boolean bool = ((Cursor)localObject).moveToFirst();
          paramString = str2;
          if (bool)
          {
            str1 = str2;
            paramString = ((Cursor)localObject).getString(0);
          }
          str1 = paramString;
          ((Cursor)localObject).close();
        }
      }
      catch (Exception paramString)
      {
        k.a.a.m.StringBuilder.append(paramString);
        paramString = str1;
      }
      append();
      return paramString;
    }
    catch (Throwable paramString)
    {
      throw paramString;
    }
  }
  
  public void set(String paramString)
  {
    try
    {
      get();
      try
      {
        ContentValues localContentValues = new ContentValues();
        Object localObject = t;
        localContentValues.put((String)localObject, "true");
        localObject = this$0;
        String str1 = r;
        StringBuilder localStringBuilder = new StringBuilder();
        String str2 = w;
        localStringBuilder.append(str2);
        localStringBuilder.append("=\"");
        localStringBuilder.append(paramString);
        localStringBuilder.append("\"");
        ((SQLiteDatabase)localObject).update(str1, localContentValues, localStringBuilder.toString(), null);
      }
      catch (Exception paramString)
      {
        k.a.a.m.StringBuilder.append(paramString);
      }
      append();
      return;
    }
    catch (Throwable paramString)
    {
      throw paramString;
    }
  }
  
  public void toString(String paramString)
  {
    try
    {
      get();
      SQLiteDatabase localSQLiteDatabase = this$0;
      String str1 = r;
      try
      {
        StringBuilder localStringBuilder = new StringBuilder();
        String str2 = x;
        localStringBuilder.append(str2);
        localStringBuilder.append("=\"");
        localStringBuilder.append(paramString);
        localStringBuilder.append("\"");
        localSQLiteDatabase.delete(str1, localStringBuilder.toString(), null);
      }
      catch (Exception paramString)
      {
        k.a.a.m.StringBuilder.append(paramString);
      }
      append();
      return;
    }
    catch (Throwable paramString)
    {
      throw paramString;
    }
  }
  
  public void toString(String paramString1, String paramString2)
  {
    try
    {
      get();
      SQLiteDatabase localSQLiteDatabase = this$0;
      String str1 = p;
      try
      {
        StringBuilder localStringBuilder = new StringBuilder();
        String str2 = x;
        localStringBuilder.append(str2);
        localStringBuilder.append("=\"");
        localStringBuilder.append(paramString1);
        localStringBuilder.append("\" AND ");
        paramString1 = h;
        localStringBuilder.append(paramString1);
        localStringBuilder.append("=\"");
        localStringBuilder.append(paramString2);
        localStringBuilder.append("\"");
        localSQLiteDatabase.delete(str1, localStringBuilder.toString(), null);
      }
      catch (Exception paramString1)
      {
        k.a.a.m.StringBuilder.append(paramString1);
      }
      append();
      return;
    }
    catch (Throwable paramString1)
    {
      throw paramString1;
    }
  }
  
  public ArrayList update()
    throws SQLException
  {
    try
    {
      ArrayList localArrayList = new ArrayList();
      get();
      Object localObject1 = this$0;
      Object localObject2 = URI;
      String str1 = out;
      String str2 = filter;
      String str3 = LOGGER;
      String str4 = separator;
      String str5 = user;
      String str6 = status;
      String str7 = mName;
      String str8 = FALSE;
      String str9 = args;
      String str10 = params;
      String str11 = longitude;
      String str12 = latitude;
      String str13 = authors;
      String str14 = hour;
      String str15 = minute;
      String str16 = message;
      String str17 = login;
      String str18 = offset;
      String str19 = payload;
      String str20 = min;
      String str21 = next;
      String str22 = token;
      String str23 = comment;
      String str24 = buf;
      String str25 = count;
      String str26 = value;
      String str27 = line;
      String str28 = names;
      String str29 = format;
      String str30 = language;
      String str31 = country;
      String str32 = state;
      String str33 = input;
      String str34 = source;
      String str35 = element;
      String str36 = START;
      String str37 = ROOT;
      String str38 = max;
      String str39 = INSTANCE;
      String str40 = db;
      String str41 = sql;
      String str42 = contentType;
      String str43 = filename;
      String str44 = url;
      String str45 = top;
      try
      {
        Object localObject3 = new StringBuilder();
        String str46 = out;
        ((StringBuilder)localObject3).append(str46);
        ((StringBuilder)localObject3).append(" DESC");
        localObject3 = ((StringBuilder)localObject3).toString();
        localObject1 = ((SQLiteDatabase)localObject1).query((String)localObject2, new String[] { str1, str2, str3, str4, str5, str6, str7, str8, str9, str10, str11, str12, str13, str14, str15, str16, str17, str18, str19, str20, str21, str22, str23, str24, str25, str26, str27, str28, str29, str30, str31, str32, str33, str34, str35, str36, str37, str38, str39, str40, str41, str42, str43, str44, str45 }, null, null, null, null, (String)localObject3);
        if (localObject1 != null)
        {
          boolean bool = ((Cursor)localObject1).moveToFirst();
          if (bool) {
            for (;;)
            {
              localObject2 = new S();
              ((S)localObject2).f(((Cursor)localObject1).getString(0));
              ((S)localObject2).B(((Cursor)localObject1).getString(1));
              ((S)localObject2).g(((Cursor)localObject1).getString(2));
              ((S)localObject2).y(((Cursor)localObject1).getString(3));
              ((S)localObject2).F(((Cursor)localObject1).getString(4));
              ((S)localObject2).i(((Cursor)localObject1).getString(5));
              ((S)localObject2).L(((Cursor)localObject1).getString(6));
              ((S)localObject2).M(((Cursor)localObject1).getString(7));
              ((S)localObject2).p(((Cursor)localObject1).getString(8));
              ((S)localObject2).q(((Cursor)localObject1).getString(9));
              ((S)localObject2).H(((Cursor)localObject1).getString(10));
              ((S)localObject2).k(((Cursor)localObject1).getString(11));
              ((S)localObject2).O(((Cursor)localObject1).getString(12));
              ((S)localObject2).N(((Cursor)localObject1).getString(13));
              ((S)localObject2).s(((Cursor)localObject1).getString(14));
              ((S)localObject2).r(((Cursor)localObject1).getString(15));
              ((S)localObject2).P(((Cursor)localObject1).getString(16));
              ((S)localObject2).t(((Cursor)localObject1).getString(17));
              ((S)localObject2).c(((Cursor)localObject1).getString(18));
              ((S)localObject2).C(((Cursor)localObject1).getString(19));
              ((S)localObject2).e(((Cursor)localObject1).getString(20));
              ((S)localObject2).A(((Cursor)localObject1).getString(21));
              ((S)localObject2).G(((Cursor)localObject1).getString(22));
              ((S)localObject2).j(((Cursor)localObject1).getString(23));
              ((S)localObject2).Q(((Cursor)localObject1).getString(24));
              ((S)localObject2).u(((Cursor)localObject1).getString(25));
              ((S)localObject2).R(((Cursor)localObject1).getString(26));
              ((S)localObject2).I(((Cursor)localObject1).getString(27));
              ((S)localObject2).n(((Cursor)localObject1).getString(28));
              ((S)localObject2).l(((Cursor)localObject1).getString(29));
              ((S)localObject2).K(((Cursor)localObject1).getString(30));
              ((S)localObject2).n(((Cursor)localObject1).getString(31));
              ((S)localObject2).J(((Cursor)localObject1).getString(32));
              ((S)localObject2).m(((Cursor)localObject1).getString(33));
              ((S)localObject2).E(((Cursor)localObject1).getString(34));
              ((S)localObject2).b(((Cursor)localObject1).getString(35));
              ((S)localObject2).x(((Cursor)localObject1).getString(36));
              ((S)localObject2).w(((Cursor)localObject1).getString(37));
              ((S)localObject2).d(((Cursor)localObject1).getString(38));
              ((S)localObject2).D(((Cursor)localObject1).getString(39));
              ((S)localObject2).S(((Cursor)localObject1).getString(40));
              ((S)localObject2).a(((Cursor)localObject1).getString(41));
              ((S)localObject2).h(((Cursor)localObject1).getString(42));
              ((S)localObject2).v(((Cursor)localObject1).getString(43));
              ((S)localObject2).z(((Cursor)localObject1).getString(44));
              localArrayList.add(localObject2);
              bool = ((Cursor)localObject1).moveToNext();
              if (!bool) {
                break;
              }
            }
          }
          ((Cursor)localObject1).close();
        }
      }
      catch (Exception localException)
      {
        k.a.a.m.StringBuilder.append(localException);
      }
      append();
      return localArrayList;
    }
    catch (Throwable localThrowable)
    {
      throw localThrowable;
    }
  }
  
  public void update(String paramString)
  {
    try
    {
      get();
      try
      {
        ContentValues localContentValues = new ContentValues();
        Object localObject = t;
        localContentValues.put((String)localObject, "true");
        localObject = this$0;
        String str1 = r;
        StringBuilder localStringBuilder = new StringBuilder();
        String str2 = t;
        localStringBuilder.append(str2);
        localStringBuilder.append("=\"false\" AND ");
        str2 = x;
        localStringBuilder.append(str2);
        localStringBuilder.append("=\"");
        localStringBuilder.append(paramString);
        localStringBuilder.append("\"");
        ((SQLiteDatabase)localObject).update(str1, localContentValues, localStringBuilder.toString(), null);
      }
      catch (Exception paramString)
      {
        k.a.a.m.StringBuilder.append(paramString);
      }
      append();
      return;
    }
    catch (Throwable paramString)
    {
      throw paramString;
    }
  }
  
  public void update(String paramString1, String paramString2)
  {
    try
    {
      get();
      try
      {
        ContentValues localContentValues = new ContentValues();
        String str = x;
        localContentValues.put(str, paramString1);
        paramString1 = c;
        localContentValues.put(paramString1, paramString2);
        paramString1 = this$0;
        paramString2 = mUri;
        paramString1.insert(paramString2, null, localContentValues);
      }
      catch (Exception paramString1)
      {
        k.a.a.m.StringBuilder.append(paramString1);
      }
      append();
      return;
    }
    catch (Throwable paramString1)
    {
      throw paramString1;
    }
  }
  
  public void update(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    try
    {
      get();
      try
      {
        ContentValues localContentValues = new ContentValues();
        String str = path;
        localContentValues.put(str, paramString1);
        paramString1 = connection;
        localContentValues.put(paramString1, paramString2);
        paramString1 = uri;
        localContentValues.put(paramString1, paramString3);
        paramString1 = phoneNumber;
        localContentValues.put(paramString1, paramString4);
        paramString1 = this$0;
        paramString2 = cursor;
        paramString1.insert(paramString2, null, localContentValues);
      }
      catch (Exception paramString1)
      {
        k.a.a.m.StringBuilder.append(paramString1);
      }
      append();
      return;
    }
    catch (Throwable paramString1)
    {
      throw paramString1;
    }
  }
  
  public void update(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5)
  {
    try
    {
      get();
      try
      {
        ContentValues localContentValues = new ContentValues();
        String str = LOG_TAG;
        localContentValues.put(str, paramString1);
        paramString1 = g;
        localContentValues.put(paramString1, paramString2);
        paramString1 = j;
        localContentValues.put(paramString1, paramString3);
        paramString1 = l;
        localContentValues.put(paramString1, paramString4);
        paramString1 = view;
        localContentValues.put(paramString1, paramString5);
        paramString1 = this$0;
        paramString2 = adapter;
        paramString1.insert(paramString2, null, localContentValues);
      }
      catch (Exception paramString1)
      {
        k.a.a.m.StringBuilder.append(paramString1);
      }
      append();
      return;
    }
    catch (Throwable paramString1)
    {
      throw paramString1;
    }
  }
  
  public ArrayList validate()
    throws SQLException
  {
    try
    {
      ArrayList localArrayList = new ArrayList();
      get();
      Object localObject = this$0;
      String str1 = app;
      String str2 = title;
      try
      {
        localObject = ((SQLiteDatabase)localObject).query(str1, new String[] { str2 }, null, null, null, null, null);
        if (localObject != null)
        {
          boolean bool = ((Cursor)localObject).moveToLast();
          if (bool) {
            do
            {
              localArrayList.add(((Cursor)localObject).getString(0));
              bool = ((Cursor)localObject).moveToPrevious();
            } while (bool);
          }
          ((Cursor)localObject).close();
        }
      }
      catch (Exception localException)
      {
        k.a.a.m.StringBuilder.append(localException);
      }
      append();
      return localArrayList;
    }
    catch (Throwable localThrowable)
    {
      throw localThrowable;
    }
  }
  
  public String write(String paramString)
    throws SQLException
  {
    String str2 = "";
    try
    {
      get();
      Object localObject1 = this$0;
      String str3 = size;
      String str4 = c;
      String str5 = left;
      String str6 = a;
      String str7 = b;
      String str8 = TAG;
      String str9 = first;
      String str10 = length;
      String str11 = position;
      String str12 = root;
      String str13 = directory;
      String str14 = cache;
      String str15 = parent;
      String str16 = activity;
      String str17 = logger;
      String str18 = DEBUG;
      String str19 = helper;
      String str20 = this$1;
      String str21 = index;
      String str22 = key;
      String str23 = log;
      String str24 = queue;
      String str25 = LOG;
      String str26 = lock;
      String str27 = $assertionsDisabled;
      String str28 = level;
      String str29 = data;
      String str30 = text;
      String str1 = str2;
      try
      {
        Object localObject2 = new StringBuilder();
        str1 = str2;
        ((StringBuilder)localObject2).append("(");
        String str31 = root;
        str1 = str2;
        ((StringBuilder)localObject2).append(str31);
        str1 = str2;
        ((StringBuilder)localObject2).append("=\"");
        str1 = str2;
        ((StringBuilder)localObject2).append(paramString);
        str1 = str2;
        ((StringBuilder)localObject2).append("\" OR ");
        str31 = $assertionsDisabled;
        str1 = str2;
        ((StringBuilder)localObject2).append(str31);
        str1 = str2;
        ((StringBuilder)localObject2).append(" LIKE '%|");
        str1 = str2;
        ((StringBuilder)localObject2).append(paramString);
        str1 = str2;
        ((StringBuilder)localObject2).append("|%') AND ");
        paramString = type;
        str1 = str2;
        ((StringBuilder)localObject2).append(paramString);
        str1 = str2;
        ((StringBuilder)localObject2).append("!=\"I\"");
        str1 = str2;
        paramString = ((StringBuilder)localObject2).toString();
        str1 = str2;
        localObject2 = new StringBuilder();
        str31 = left;
        str1 = str2;
        ((StringBuilder)localObject2).append(str31);
        str1 = str2;
        ((StringBuilder)localObject2).append(" COLLATE NOCASE ASC");
        str1 = str2;
        localObject2 = ((StringBuilder)localObject2).toString();
        str1 = str2;
        localObject1 = ((SQLiteDatabase)localObject1).query(str3, new String[] { str4, str5, str6, str7, str8, str9, str10, str11, str12, str13, str14, str15, str16, str17, str18, str19, str20, str21, str22, str23, str24, str25, str26, str27, str28, str29, str30 }, paramString, null, null, null, (String)localObject2);
        paramString = str2;
        if (localObject1 != null)
        {
          str1 = str2;
          paramString = new StringBuilder();
          str1 = str2;
          paramString.append("");
          str1 = str2;
          paramString.append(((Cursor)localObject1).getCount());
          str1 = str2;
          paramString = paramString.toString();
          str1 = paramString;
          ((Cursor)localObject1).close();
        }
      }
      catch (Exception paramString)
      {
        k.a.a.m.StringBuilder.append(paramString);
        paramString = str1;
      }
      append();
      return paramString;
    }
    catch (Throwable paramString)
    {
      throw paramString;
    }
  }
  
  public ArrayList write()
    throws SQLException
  {
    try
    {
      ArrayList localArrayList = new ArrayList();
      get();
      Object localObject1 = this$0;
      Object localObject2 = size;
      String str1 = c;
      String str2 = left;
      String str3 = a;
      String str4 = b;
      String str5 = TAG;
      String str6 = first;
      String str7 = length;
      String str8 = position;
      String str9 = root;
      String str10 = directory;
      String str11 = cache;
      String str12 = parent;
      String str13 = activity;
      String str14 = logger;
      String str15 = DEBUG;
      String str16 = helper;
      String str17 = this$1;
      String str18 = index;
      String str19 = key;
      String str20 = log;
      String str21 = queue;
      String str22 = LOG;
      String str23 = lock;
      String str24 = $assertionsDisabled;
      String str25 = level;
      String str26 = type;
      String str27 = data;
      String str28 = text;
      try
      {
        Object localObject3 = new StringBuilder();
        Object localObject4 = root;
        ((StringBuilder)localObject3).append((String)localObject4);
        ((StringBuilder)localObject3).append("=\"99\" AND ");
        localObject4 = type;
        ((StringBuilder)localObject3).append((String)localObject4);
        ((StringBuilder)localObject3).append("!=\"I\"");
        localObject3 = ((StringBuilder)localObject3).toString();
        localObject4 = new StringBuilder();
        String str29 = left;
        ((StringBuilder)localObject4).append(str29);
        ((StringBuilder)localObject4).append(" COLLATE NOCASE ASC");
        localObject4 = ((StringBuilder)localObject4).toString();
        localObject1 = ((SQLiteDatabase)localObject1).query((String)localObject2, new String[] { str1, str2, str3, str4, str5, str6, str7, str8, str9, str10, str11, str12, str13, str14, str15, str16, str17, str18, str19, str20, str21, str22, str23, str24, str25, str26, str27, str28 }, (String)localObject3, null, null, null, (String)localObject4);
        if (localObject1 != null)
        {
          boolean bool = ((Cursor)localObject1).moveToFirst();
          if (bool) {
            for (;;)
            {
              localObject2 = new Log();
              ((Log)localObject2).getName(((Cursor)localObject1).getString(0));
              ((Log)localObject2).read(((Cursor)localObject1).getString(1));
              ((Log)localObject2).size(((Cursor)localObject1).getString(2));
              ((Log)localObject2).trim(((Cursor)localObject1).getString(3));
              ((Log)localObject2).split(((Cursor)localObject1).getString(4));
              ((Log)localObject2).write(((Cursor)localObject1).getString(5));
              ((Log)localObject2).execute(((Cursor)localObject1).getString(6));
              ((Log)localObject2).v(((Cursor)localObject1).getString(7));
              ((Log)localObject2).add(((Cursor)localObject1).getString(8));
              ((Log)localObject2).log(((Cursor)localObject1).getString(9));
              ((Log)localObject2).append(((Cursor)localObject1).getString(10));
              ((Log)localObject2).valueOf(Boolean.parseBoolean(((Cursor)localObject1).getString(11)));
              ((Log)localObject2).set(Boolean.parseBoolean(((Cursor)localObject1).getString(12)));
              ((Log)localObject2).d(((Cursor)localObject1).getString(13));
              ((Log)localObject2).add(Boolean.parseBoolean(((Cursor)localObject1).getString(14)));
              ((Log)localObject2).print(((Cursor)localObject1).getString(15));
              ((Log)localObject2).get(((Cursor)localObject1).getString(16));
              ((Log)localObject2).next(((Cursor)localObject1).getString(17));
              ((Log)localObject2).equals(((Cursor)localObject1).getString(18));
              ((Log)localObject2).set(((Cursor)localObject1).getString(19));
              ((Log)localObject2).start(((Cursor)localObject1).getString(20));
              ((Log)localObject2).put(((Cursor)localObject1).getString(21));
              ((Log)localObject2).update(((Cursor)localObject1).getString(22));
              ((Log)localObject2).toString(((Cursor)localObject1).getString(23));
              ((Log)localObject2).close(((Cursor)localObject1).getString(24));
              ((Log)localObject2).w(((Cursor)localObject1).getString(25));
              ((Log)localObject2).name(((Cursor)localObject1).getString(26));
              ((Log)localObject2).format(((Cursor)localObject1).getString(27));
              localArrayList.add(localObject2);
              bool = ((Cursor)localObject1).moveToNext();
              if (!bool) {
                break;
              }
            }
          }
          ((Cursor)localObject1).close();
        }
      }
      catch (Exception localException)
      {
        k.a.a.m.StringBuilder.append(localException);
      }
      append();
      return localArrayList;
    }
    catch (Throwable localThrowable)
    {
      throw localThrowable;
    }
  }
  
  public z write(String paramString1, String paramString2)
    throws SQLException
  {
    try
    {
      get();
      SQLiteDatabase localSQLiteDatabase = this$0;
      String str1 = map;
      String str2 = NONE;
      String str3 = URL;
      String str4 = ADD;
      String str5 = pos;
      String str6 = content;
      String str7 = tag;
      String str8 = values;
      String str9 = pointer;
      String str10 = current;
      String str11 = handler;
      String str12 = id;
      try
      {
        StringBuilder localStringBuilder = new StringBuilder();
        String str13 = delegate;
        localStringBuilder.append(str13);
        localStringBuilder.append("=\"");
        localStringBuilder.append(paramString1);
        localStringBuilder.append("\" AND ");
        paramString1 = NONE;
        localStringBuilder.append(paramString1);
        localStringBuilder.append("=\"");
        localStringBuilder.append(paramString2);
        localStringBuilder.append("\"");
        paramString1 = localStringBuilder.toString();
        paramString2 = localSQLiteDatabase.query(str1, new String[] { str2, str3, str4, str5, str6, str7, str8, str9, str10, str11, str12 }, paramString1, null, null, null, null);
        if (paramString2 != null)
        {
          boolean bool = paramString2.moveToFirst();
          if (bool)
          {
            paramString1 = new z();
            try
            {
              paramString1.e(paramString2.getString(0));
              paramString1.f(paramString2.getString(1));
              paramString1.j(paramString2.getString(2));
              paramString1.a(paramString2.getString(3));
              paramString1.g(paramString2.getString(4));
              paramString1.i(paramString2.getString(5));
              paramString1.h(paramString2.getString(6));
              paramString1.k(paramString2.getString(7));
              paramString1.b(paramString2.getString(8));
              paramString1.c(paramString2.getString(9));
              paramString1.d(paramString2.getString(10));
            }
            catch (Exception paramString2)
            {
              break label419;
            }
          }
          else
          {
            paramString1 = null;
          }
          try
          {
            paramString2.close();
          }
          catch (Exception paramString2)
          {
            break label419;
          }
        }
        else
        {
          paramString1 = null;
        }
      }
      catch (Exception paramString2)
      {
        paramString1 = null;
        label419:
        k.a.a.m.StringBuilder.append(paramString2);
      }
      append();
      return paramString1;
    }
    catch (Throwable paramString1)
    {
      throw paramString1;
    }
  }
  
  public void write(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8, String paramString9, String paramString10, String paramString11, String paramString12)
  {
    try
    {
      get();
      try
      {
        ContentValues localContentValues = new ContentValues();
        String str = delegate;
        localContentValues.put(str, paramString1);
        paramString1 = NONE;
        localContentValues.put(paramString1, paramString2);
        paramString1 = URL;
        localContentValues.put(paramString1, paramString3);
        paramString1 = ADD;
        localContentValues.put(paramString1, paramString4);
        paramString1 = pos;
        localContentValues.put(paramString1, paramString5);
        paramString1 = content;
        localContentValues.put(paramString1, paramString6);
        paramString1 = tag;
        localContentValues.put(paramString1, paramString7);
        paramString1 = values;
        localContentValues.put(paramString1, paramString8);
        paramString1 = pointer;
        localContentValues.put(paramString1, paramString9);
        paramString1 = current;
        localContentValues.put(paramString1, paramString10);
        paramString1 = handler;
        localContentValues.put(paramString1, paramString11);
        paramString1 = id;
        localContentValues.put(paramString1, paramString12);
        paramString1 = this$0;
        paramString2 = map;
        paramString1.insert(paramString2, null, localContentValues);
      }
      catch (Exception paramString1)
      {
        k.a.a.m.StringBuilder.append(paramString1);
      }
      append();
      return;
    }
    catch (Throwable paramString1)
    {
      throw paramString1;
    }
  }
  
  public void write(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8, String paramString9, String paramString10, String paramString11, String paramString12, String paramString13, String paramString14, String paramString15, String paramString16, String paramString17, String paramString18, String paramString19, String paramString20, String paramString21, String paramString22, String paramString23, String paramString24)
  {
    try
    {
      get();
      try
      {
        ContentValues localContentValues = new ContentValues();
        String str = left;
        localContentValues.put(str, paramString2);
        paramString2 = a;
        localContentValues.put(paramString2, paramString3);
        paramString2 = b;
        localContentValues.put(paramString2, paramString4);
        paramString2 = directory;
        localContentValues.put(paramString2, paramString5);
        paramString2 = cache;
        localContentValues.put(paramString2, paramString6);
        paramString2 = logger;
        localContentValues.put(paramString2, paramString7);
        paramString2 = helper;
        localContentValues.put(paramString2, paramString8);
        paramString2 = this$1;
        localContentValues.put(paramString2, paramString9);
        paramString2 = index;
        localContentValues.put(paramString2, paramString10);
        paramString2 = key;
        localContentValues.put(paramString2, paramString11);
        paramString2 = username;
        localContentValues.put(paramString2, paramString12);
        paramString2 = date;
        localContentValues.put(paramString2, paramString13);
        paramString2 = hash;
        localContentValues.put(paramString2, paramString14);
        paramString2 = level;
        localContentValues.put(paramString2, paramString15);
        paramString2 = y;
        localContentValues.put(paramString2, paramString16);
        paramString2 = LOG;
        localContentValues.put(paramString2, paramString17);
        paramString2 = TAG;
        localContentValues.put(paramString2, paramString18);
        paramString2 = root;
        localContentValues.put(paramString2, paramString19);
        paramString2 = $assertionsDisabled;
        localContentValues.put(paramString2, paramString20);
        paramString2 = file;
        localContentValues.put(paramString2, paramString21);
        paramString2 = type;
        localContentValues.put(paramString2, paramString22);
        paramString2 = data;
        localContentValues.put(paramString2, paramString23);
        paramString2 = text;
        localContentValues.put(paramString2, paramString24);
        paramString2 = this$0;
        paramString3 = name;
        paramString4 = new StringBuilder();
        paramString5 = c;
        paramString4.append(paramString5);
        paramString4.append("=\"");
        paramString4.append(paramString1);
        paramString4.append("\"");
        paramString2.update(paramString3, localContentValues, paramString4.toString(), null);
      }
      catch (Exception paramString1)
      {
        k.a.a.m.StringBuilder.append(paramString1);
      }
      append();
      return;
    }
    catch (Throwable paramString1)
    {
      throw paramString1;
    }
  }
  
  public void write(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8, String paramString9, String paramString10, String paramString11, String paramString12, String paramString13, String paramString14, String paramString15, String paramString16, String paramString17, String paramString18, String paramString19, String paramString20, String paramString21, String paramString22, String paramString23, String paramString24, String paramString25, String paramString26, String paramString27, String paramString28)
  {
    try
    {
      get();
      try
      {
        ContentValues localContentValues = new ContentValues();
        String str = left;
        localContentValues.put(str, paramString2);
        paramString2 = a;
        localContentValues.put(paramString2, paramString3);
        paramString2 = b;
        localContentValues.put(paramString2, paramString4);
        paramString2 = TAG;
        localContentValues.put(paramString2, paramString5);
        paramString2 = first;
        localContentValues.put(paramString2, paramString6);
        paramString2 = length;
        localContentValues.put(paramString2, paramString7);
        paramString2 = position;
        localContentValues.put(paramString2, paramString8);
        paramString2 = root;
        localContentValues.put(paramString2, paramString9);
        paramString2 = directory;
        localContentValues.put(paramString2, paramString10);
        paramString2 = cache;
        localContentValues.put(paramString2, paramString11);
        paramString2 = parent;
        localContentValues.put(paramString2, paramString12);
        paramString2 = activity;
        localContentValues.put(paramString2, paramString13);
        paramString2 = logger;
        localContentValues.put(paramString2, paramString14);
        paramString2 = DEBUG;
        localContentValues.put(paramString2, paramString15);
        paramString2 = helper;
        localContentValues.put(paramString2, paramString16);
        paramString2 = this$1;
        localContentValues.put(paramString2, paramString17);
        paramString2 = index;
        localContentValues.put(paramString2, paramString18);
        paramString2 = key;
        localContentValues.put(paramString2, paramString19);
        paramString2 = log;
        localContentValues.put(paramString2, paramString20);
        paramString2 = queue;
        localContentValues.put(paramString2, paramString21);
        paramString2 = LOG;
        localContentValues.put(paramString2, paramString22);
        paramString2 = lock;
        localContentValues.put(paramString2, paramString23);
        paramString2 = $assertionsDisabled;
        localContentValues.put(paramString2, paramString24);
        paramString2 = level;
        localContentValues.put(paramString2, paramString25);
        paramString2 = type;
        localContentValues.put(paramString2, paramString26);
        paramString2 = data;
        localContentValues.put(paramString2, paramString27);
        paramString2 = text;
        localContentValues.put(paramString2, paramString28);
        paramString2 = this$0;
        paramString3 = size;
        paramString4 = new StringBuilder();
        paramString5 = c;
        paramString4.append(paramString5);
        paramString4.append("=\"");
        paramString4.append(paramString1);
        paramString4.append("\"");
        paramString2.update(paramString3, localContentValues, paramString4.toString(), null);
      }
      catch (Exception paramString1)
      {
        k.a.a.m.StringBuilder.append(paramString1);
      }
      append();
      return;
    }
    catch (Throwable paramString1)
    {
      throw paramString1;
    }
  }
  
  public void write(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8, String paramString9, String paramString10, String paramString11, String paramString12, String paramString13, String paramString14, String paramString15, String paramString16, String paramString17, String paramString18, String paramString19, String paramString20, String paramString21, String paramString22, String paramString23, String paramString24, String paramString25, String paramString26, String paramString27, String paramString28, String paramString29)
  {
    try
    {
      get();
      try
      {
        ContentValues localContentValues = new ContentValues();
        String str = left;
        localContentValues.put(str, paramString2);
        paramString2 = a;
        localContentValues.put(paramString2, paramString3);
        paramString2 = b;
        localContentValues.put(paramString2, paramString4);
        paramString2 = TAG;
        localContentValues.put(paramString2, paramString5);
        paramString2 = first;
        localContentValues.put(paramString2, paramString6);
        paramString2 = length;
        localContentValues.put(paramString2, paramString7);
        paramString2 = position;
        localContentValues.put(paramString2, paramString8);
        paramString2 = root;
        localContentValues.put(paramString2, paramString9);
        paramString2 = directory;
        localContentValues.put(paramString2, paramString10);
        paramString2 = cache;
        localContentValues.put(paramString2, paramString11);
        paramString2 = parent;
        localContentValues.put(paramString2, paramString12);
        paramString2 = activity;
        localContentValues.put(paramString2, paramString13);
        paramString2 = logger;
        localContentValues.put(paramString2, paramString14);
        paramString2 = DEBUG;
        localContentValues.put(paramString2, paramString15);
        paramString2 = helper;
        localContentValues.put(paramString2, paramString16);
        paramString2 = this$1;
        localContentValues.put(paramString2, paramString17);
        paramString2 = index;
        localContentValues.put(paramString2, paramString18);
        paramString2 = key;
        localContentValues.put(paramString2, paramString19);
        paramString2 = log;
        localContentValues.put(paramString2, paramString20);
        paramString2 = queue;
        localContentValues.put(paramString2, paramString21);
        paramString2 = LOG;
        localContentValues.put(paramString2, paramString22);
        paramString2 = lock;
        localContentValues.put(paramString2, paramString23);
        paramString2 = $assertionsDisabled;
        localContentValues.put(paramString2, paramString24);
        paramString2 = level;
        localContentValues.put(paramString2, paramString25);
        paramString2 = type;
        localContentValues.put(paramString2, paramString26);
        paramString2 = file;
        localContentValues.put(paramString2, paramString27);
        paramString2 = data;
        localContentValues.put(paramString2, paramString28);
        paramString2 = text;
        localContentValues.put(paramString2, paramString29);
        paramString2 = this$0;
        paramString3 = context;
        paramString4 = new StringBuilder();
        paramString5 = c;
        paramString4.append(paramString5);
        paramString4.append("=\"");
        paramString4.append(paramString1);
        paramString4.append("\"");
        paramString2.update(paramString3, localContentValues, paramString4.toString(), null);
      }
      catch (Exception paramString1)
      {
        k.a.a.m.StringBuilder.append(paramString1);
      }
      append();
      return;
    }
    catch (Throwable paramString1)
    {
      throw paramString1;
    }
  }
}
