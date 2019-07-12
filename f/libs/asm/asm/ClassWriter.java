package f.libs.asm.asm;

import android.os.Bundle;
import f.sufficientlysecure.rootcommands.util.StringBuilder;
import java.math.BigDecimal;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import l.a.a.a.Log;
import l.a.a.a.f;

public class ClassWriter
{
  public static final String EXTRA_SUCCESS_FLAG = "success";
  public static final String b = "level_name";
  public static final String d = "method";
  public static final String i = "rating";
  public static final Set<String> s = new HashSet(Arrays.asList(new String[] { "app_clear_data", "app_exception", "app_remove", "app_upgrade", "app_install", "app_update", "firebase_campaign", "error", "first_open", "first_visit", "in_app_purchase", "notification_dismiss", "notification_foreground", "notification_open", "notification_receive", "os_update", "session_start", "user_engagement", "ad_exposure", "adunit_exposure", "ad_query", "ad_activeview", "ad_impression", "ad_click", "screen_view", "firebase_extra_parameter" }));
  
  public ClassWriter() {}
  
  private Bundle a(Label paramLabel)
  {
    Bundle localBundle = new Bundle();
    if ("purchase".equals(a))
    {
      put(localBundle, "item_id", (String)c.get("itemId"));
      put(localBundle, "item_name", (String)c.get("itemName"));
      put(localBundle, "item_category", (String)c.get("itemType"));
      put(localBundle, "value", visit(c.get("itemPrice")));
      put(localBundle, "currency", (String)c.get("currency"));
    }
    else if ("addToCart".equals(a))
    {
      put(localBundle, "item_id", (String)c.get("itemId"));
      put(localBundle, "item_name", (String)c.get("itemName"));
      put(localBundle, "item_category", (String)c.get("itemType"));
      put(localBundle, "price", visit(c.get("itemPrice")));
      put(localBundle, "value", visit(c.get("itemPrice")));
      put(localBundle, "currency", (String)c.get("currency"));
      localBundle.putLong("quantity", 1L);
    }
    else if ("startCheckout".equals(a))
    {
      put(localBundle, "quantity", Long.valueOf(((Integer)c.get("itemCount")).intValue()));
      put(localBundle, "value", visit(c.get("totalPrice")));
      put(localBundle, "currency", (String)c.get("currency"));
    }
    else if ("contentView".equals(a))
    {
      put(localBundle, "content_type", (String)c.get("contentType"));
      put(localBundle, "item_id", (String)c.get("contentId"));
      put(localBundle, "item_name", (String)c.get("contentName"));
    }
    else if ("search".equals(a))
    {
      put(localBundle, "search_term", (String)c.get("query"));
    }
    else if ("share".equals(a))
    {
      put(localBundle, "method", (String)c.get("method"));
      put(localBundle, "content_type", (String)c.get("contentType"));
      put(localBundle, "item_id", (String)c.get("contentId"));
      put(localBundle, "item_name", (String)c.get("contentName"));
    }
    else if ("rating".equals(a))
    {
      put(localBundle, "rating", String.valueOf(c.get("rating")));
      put(localBundle, "content_type", (String)c.get("contentType"));
      put(localBundle, "item_id", (String)c.get("contentId"));
      put(localBundle, "item_name", (String)c.get("contentName"));
    }
    else if ("signUp".equals(a))
    {
      put(localBundle, "method", (String)c.get("method"));
    }
    else if ("login".equals(a))
    {
      put(localBundle, "method", (String)c.get("method"));
    }
    else if ("invite".equals(a))
    {
      put(localBundle, "method", (String)c.get("method"));
    }
    else if ("levelStart".equals(a))
    {
      put(localBundle, "level_name", (String)c.get("levelName"));
    }
    else if ("levelEnd".equals(a))
    {
      put(localBundle, "score", get(c.get("score")));
      put(localBundle, "level_name", (String)c.get("levelName"));
      put(localBundle, "success", get((String)c.get("success")));
    }
    put(localBundle, k);
    return localBundle;
  }
  
  private String format(String paramString)
  {
    if ((paramString != null) && (paramString.length() != 0))
    {
      if (s.contains(paramString)) {
        return StringBuilder.toString("fabric_", paramString);
      }
      String str = paramString.replaceAll("[^\\p{Alnum}_]+", "_");
      paramString = str;
      if ((str.startsWith("ga_")) || (str.startsWith("google_")) || (str.startsWith("firebase_")) || (!Character.isLetter(str.charAt(0)))) {
        paramString = StringBuilder.toString("fabric_", str);
      }
      if (paramString.length() > 40) {
        return paramString.substring(0, 40);
      }
    }
    else
    {
      return "fabric_unnamed_event";
    }
    return paramString;
  }
  
  private Double get(Object paramObject)
  {
    return Double.valueOf(String.valueOf(paramObject));
  }
  
  private Integer get(String paramString)
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.provideAs(TypeTransformer.java:780)\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:659)\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:698)\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.s1stmt(TypeTransformer.java:810)\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.sxStmt(TypeTransformer.java:840)\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:206)\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\n");
  }
  
  private String get(String paramString, boolean paramBoolean)
  {
    int k = 0;
    if (paramBoolean)
    {
      j = paramString.hashCode();
      if (j != -902468296)
      {
        if (j != 103149417)
        {
          if ((j == 1743324417) && (paramString.equals("purchase")))
          {
            j = 0;
            break label80;
          }
        }
        else if (paramString.equals("login"))
        {
          j = 2;
          break label80;
        }
      }
      else if (paramString.equals("signUp"))
      {
        j = 1;
        break label80;
      }
      j = -1;
      label80:
      if (j != 0)
      {
        if (j != 1)
        {
          if (j == 2) {
            return "failed_login";
          }
        }
        else {
          return "failed_sign_up";
        }
      }
      else {
        return "failed_ecommerce_purchase";
      }
    }
    switch (paramString.hashCode())
    {
    default: 
      break;
    case 1743324417: 
      if (paramString.equals("purchase")) {
        j = k;
      }
      break;
    case 1664021448: 
      if (paramString.equals("startCheckout")) {
        j = 2;
      }
      break;
    case 196004670: 
      if (paramString.equals("levelStart")) {
        j = 10;
      }
      break;
    case 109400031: 
      if (paramString.equals("share")) {
        j = 5;
      }
      break;
    case 103149417: 
      if (paramString.equals("login")) {
        j = 8;
      }
      break;
    case 23457852: 
      if (paramString.equals("addToCart")) {
        j = 1;
      }
      break;
    case -389087554: 
      if (paramString.equals("contentView")) {
        j = 3;
      }
      break;
    case -902468296: 
      if (paramString.equals("signUp")) {
        j = 7;
      }
      break;
    case -906336856: 
      if (paramString.equals("search")) {
        j = 4;
      }
      break;
    case -938102371: 
      if (paramString.equals("rating")) {
        j = 6;
      }
      break;
    case -1183699191: 
      if (paramString.equals("invite")) {
        j = 9;
      }
      break;
    case -2131650889: 
      if (paramString.equals("levelEnd")) {
        j = 11;
      }
      break;
    }
    int j = -1;
    switch (j)
    {
    default: 
      return format(paramString);
    case 11: 
      return "level_end";
    case 10: 
      return "level_start";
    case 9: 
      return "invite";
    case 8: 
      return "login";
    case 7: 
      return "sign_up";
    case 6: 
      return "rate_content";
    case 5: 
      return "share";
    case 4: 
      return "search";
    case 3: 
      return "select_content";
    case 2: 
      return "begin_checkout";
    case 1: 
      return "add_to_cart";
    }
    return "ecommerce_purchase";
  }
  
  private String getKey(String paramString)
  {
    if ((paramString != null) && (paramString.length() != 0))
    {
      String str = paramString.replaceAll("[^\\p{Alnum}_]+", "_");
      paramString = str;
      if ((str.startsWith("ga_")) || (str.startsWith("google_")) || (str.startsWith("firebase_")) || (!Character.isLetter(str.charAt(0)))) {
        paramString = StringBuilder.toString("fabric_", str);
      }
      if (paramString.length() > 40) {
        return paramString.substring(0, 40);
      }
    }
    else
    {
      return "fabric_unnamed_parameter";
    }
    return paramString;
  }
  
  private void put(Bundle paramBundle, String paramString, Double paramDouble)
  {
    paramDouble = get(paramDouble);
    if (paramDouble == null) {
      return;
    }
    paramBundle.putDouble(paramString, paramDouble.doubleValue());
  }
  
  private void put(Bundle paramBundle, String paramString, Integer paramInteger)
  {
    if (paramInteger == null) {
      return;
    }
    paramBundle.putInt(paramString, paramInteger.intValue());
  }
  
  private void put(Bundle paramBundle, String paramString, Long paramLong)
  {
    if (paramLong == null) {
      return;
    }
    paramBundle.putLong(paramString, paramLong.longValue());
  }
  
  private void put(Bundle paramBundle, String paramString1, String paramString2)
  {
    if (paramString2 == null) {
      return;
    }
    paramBundle.putString(paramString1, paramString2);
  }
  
  private void put(Bundle paramBundle, Map paramMap)
  {
    paramMap = paramMap.entrySet().iterator();
    while (paramMap.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)paramMap.next();
      Object localObject = localEntry.getValue();
      String str = getKey((String)localEntry.getKey());
      if ((localObject instanceof String)) {
        paramBundle.putString(str, localEntry.getValue().toString());
      } else if ((localObject instanceof Double)) {
        paramBundle.putDouble(str, ((Double)localEntry.getValue()).doubleValue());
      } else if ((localObject instanceof Long)) {
        paramBundle.putLong(str, ((Long)localEntry.getValue()).longValue());
      } else if ((localObject instanceof Integer)) {
        paramBundle.putInt(str, ((Integer)localEntry.getValue()).intValue());
      }
    }
  }
  
  private Double visit(Object paramObject)
  {
    paramObject = (Long)paramObject;
    if (paramObject == null) {
      return null;
    }
    return Double.valueOf(new BigDecimal(paramObject.longValue()).divide(Item.d).doubleValue());
  }
  
  public e.a b(Label paramLabel)
  {
    boolean bool2 = TextOrientationType.a.equals(b);
    boolean bool1 = true;
    int j;
    if ((bool2) && (f != null)) {
      j = 1;
    } else {
      j = 0;
    }
    int k;
    if ((TextOrientationType.e.equals(b)) && (a != null)) {
      k = 1;
    } else {
      k = 0;
    }
    if ((j == 0) && (k == 0)) {
      return null;
    }
    Object localObject1;
    Object localObject2;
    if (k != 0)
    {
      localObject1 = a(paramLabel);
    }
    else
    {
      localObject2 = new Bundle();
      Map localMap = k;
      localObject1 = localObject2;
      if (localMap != null)
      {
        put((Bundle)localObject2, localMap);
        localObject1 = localObject2;
      }
    }
    if (k != 0)
    {
      localObject2 = (String)c.get("success");
      if ((localObject2 == null) || (Boolean.parseBoolean((String)localObject2))) {
        bool1 = false;
      }
      paramLabel = get(a, bool1);
    }
    else
    {
      paramLabel = format(f);
    }
    f.get().d("Answers", "Logging event into firebase...");
    return new e.a(paramLabel, (Bundle)localObject1);
  }
}
