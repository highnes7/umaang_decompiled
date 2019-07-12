package com.google.android.android.tagmanager;

import android.content.Context;
import com.google.android.android.analytics.HitBuilders.HitBuilder;
import com.google.android.android.analytics.HitBuilders.ScreenViewBuilder;
import com.google.android.android.analytics.Tracker;
import com.google.android.android.analytics.ecommerce.Product;
import com.google.android.android.analytics.ecommerce.ProductAction;
import com.google.android.android.analytics.ecommerce.Promotion;
import com.google.android.android.internal.zzbd;
import com.google.android.android.internal.zzbe;
import com.google.android.android.internal.zzbp;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class zzgl
  extends zzgi
{
  public static final String cachePath = zzbd.zzkr.toString();
  public static final String zzjwq = zzbe.zzlx.toString();
  public static final String zzjwr = zzbe.zzmi.toString();
  public static final String zzjws = zzbe.zzpi.toString();
  public static final String zzjwt = zzbe.zzpb.toString();
  public static final String zzjwu = zzbe.zzpa.toString();
  public static final String zzjwv = zzbe.zzmh.toString();
  public static final String zzjww = zzbe.zzuq.toString();
  public static final String zzjwx = zzbe.zzut.toString();
  public static final String zzjwy = zzbe.zzuv.toString();
  public static final List<String> zzjwz = Arrays.asList(new String[] { "detail", "checkout", "checkout_option", "click", "add", "remove", "purchase", "refund" });
  public static final Pattern zzjxa = Pattern.compile("dimension(\\d+)");
  public static final Pattern zzjxb = Pattern.compile("metric(\\d+)");
  public static Map<String, String> zzjxc;
  public static Map<String, String> zzjxd;
  public final DataLayer zzjpa;
  public final Set<String> zzjxe;
  public final zzgg zzjxf;
  
  public zzgl(Context paramContext, DataLayer paramDataLayer)
  {
    this(paramContext, paramDataLayer, new zzgg(paramContext));
  }
  
  public zzgl(Context paramContext, DataLayer paramDataLayer, zzgg paramZzgg)
  {
    super(cachePath, new String[0]);
    zzjpa = paramDataLayer;
    zzjxf = paramZzgg;
    zzjxe = new HashSet();
    zzjxe.add("");
    zzjxe.add("0");
    zzjxe.add("false");
  }
  
  public static Product calculate(Map paramMap)
  {
    Product localProduct = new Product();
    Object localObject1 = paramMap.get("id");
    if (localObject1 != null) {
      localProduct.setId(String.valueOf(localObject1));
    }
    localObject1 = paramMap.get("name");
    if (localObject1 != null) {
      localProduct.setName(String.valueOf(localObject1));
    }
    localObject1 = paramMap.get("brand");
    if (localObject1 != null) {
      localProduct.setBrand(String.valueOf(localObject1));
    }
    localObject1 = paramMap.get("category");
    if (localObject1 != null) {
      localProduct.setCategory(String.valueOf(localObject1));
    }
    localObject1 = paramMap.get("variant");
    if (localObject1 != null) {
      localProduct.setVariant(String.valueOf(localObject1));
    }
    localObject1 = paramMap.get("coupon");
    if (localObject1 != null) {
      localProduct.setCouponCode(String.valueOf(localObject1));
    }
    localObject1 = paramMap.get("position");
    if (localObject1 != null) {
      localProduct.setPosition(zzam(localObject1).intValue());
    }
    localObject1 = paramMap.get("price");
    if (localObject1 != null) {
      localProduct.setPrice(zzal(localObject1).doubleValue());
    }
    localObject1 = paramMap.get("quantity");
    if (localObject1 != null) {
      localProduct.setQuantity(zzam(localObject1).intValue());
    }
    Iterator localIterator = paramMap.keySet().iterator();
    for (;;)
    {
      if (!localIterator.hasNext()) {
        break label441;
      }
      localObject1 = (String)localIterator.next();
      Object localObject2 = zzjxa.matcher((CharSequence)localObject1);
      if (!((Matcher)localObject2).matches()) {
        break label356;
      }
      try
      {
        i = Integer.parseInt(((Matcher)localObject2).group(1));
        localProduct.setCustomDimension(i, String.valueOf(paramMap.get(localObject1)));
      }
      catch (NumberFormatException localNumberFormatException1)
      {
        int i;
        String str;
        label324:
        label356:
        label441:
        for (;;) {}
      }
    }
    localObject2 = "illegal number in custom dimension value: ";
    str = String.valueOf(localObject1);
    localObject1 = str;
    if (str.length() != 0) {
      localObject1 = ((String)localObject2).concat((String)localObject1);
    }
    for (localObject1 = new String("illegal number in custom dimension value: ");; localObject1 = new String("illegal number in custom metric value: "))
    {
      zzdj.zzjss.zzcr((String)localObject1);
      break;
      localObject2 = zzjxb.matcher((CharSequence)localObject1);
      if (!((Matcher)localObject2).matches()) {
        break;
      }
      try
      {
        i = Integer.parseInt(((Matcher)localObject2).group(1));
        localProduct.setCustomMetric(i, zzam(paramMap.get(localObject1)).intValue());
      }
      catch (NumberFormatException localNumberFormatException2)
      {
        for (;;) {}
      }
      localObject2 = "illegal number in custom metric value: ";
      str = String.valueOf(localObject1);
      localObject1 = str;
      if (str.length() != 0) {
        break label324;
      }
    }
    return localProduct;
  }
  
  public static void discoverAccessibleMethods(Map paramMap, String paramString1, String paramString2)
  {
    if (paramString2 != null) {
      paramMap.put(paramString1, paramString2);
    }
  }
  
  private final Map get(zzbp paramZzbp)
  {
    if (paramZzbp == null) {
      return new HashMap();
    }
    paramZzbp = getValue(paramZzbp);
    if (paramZzbp == null) {
      return new HashMap();
    }
    String str = (String)paramZzbp.get("&aip");
    if ((str != null) && (zzjxe.contains(str.toLowerCase()))) {
      paramZzbp.remove("&aip");
    }
    return paramZzbp;
  }
  
  public static Map getValue(zzbp paramZzbp)
  {
    paramZzbp = zzgk.get(paramZzbp);
    if (!(paramZzbp instanceof Map)) {
      return null;
    }
    Object localObject = (Map)paramZzbp;
    paramZzbp = new LinkedHashMap();
    localObject = ((Map)localObject).entrySet().iterator();
    while (((Iterator)localObject).hasNext())
    {
      Map.Entry localEntry = (Map.Entry)((Iterator)localObject).next();
      paramZzbp.put(localEntry.getKey().toString(), localEntry.getValue().toString());
    }
    return paramZzbp;
  }
  
  public static boolean saveData(Map paramMap, String paramString)
  {
    paramMap = (zzbp)paramMap.get(paramString);
    if (paramMap == null) {
      return false;
    }
    return zzgk.valueOf(paramMap).booleanValue();
  }
  
  private final void sendTransaction(Tracker paramTracker, Map paramMap)
  {
    String str = zzmh("transactionId");
    if (str == null)
    {
      zzdj.zzjss.get("Cannot find transactionId in data layer.");
      return;
    }
    LinkedList localLinkedList = new LinkedList();
    Object localObject1 = zzjwv;
    try
    {
      localObject1 = paramMap.get(localObject1);
      localObject1 = (zzbp)localObject1;
      Object localObject2 = get((zzbp)localObject1);
      ((Map)localObject2).put("&t", "transaction");
      localObject1 = zzjwx;
      localObject1 = paramMap.get(localObject1);
      localObject1 = (zzbp)localObject1;
      if (localObject1 != null)
      {
        localObject1 = getValue((zzbp)localObject1);
      }
      else
      {
        if (zzjxc == null)
        {
          localObject1 = new HashMap();
          ((HashMap)localObject1).put("transactionId", "&ti");
          ((HashMap)localObject1).put("transactionAffiliation", "&ta");
          ((HashMap)localObject1).put("transactionTax", "&tt");
          ((HashMap)localObject1).put("transactionShipping", "&ts");
          ((HashMap)localObject1).put("transactionTotal", "&tr");
          ((HashMap)localObject1).put("transactionCurrency", "&cu");
          zzjxc = (Map)localObject1;
        }
        localObject1 = zzjxc;
      }
      localObject1 = ((Map)localObject1).entrySet().iterator();
      boolean bool;
      Object localObject3;
      Object localObject4;
      for (;;)
      {
        bool = ((Iterator)localObject1).hasNext();
        if (!bool) {
          break;
        }
        localObject3 = ((Iterator)localObject1).next();
        localObject4 = (Map.Entry)localObject3;
        localObject3 = ((Map.Entry)localObject4).getValue();
        localObject3 = (String)localObject3;
        localObject4 = ((Map.Entry)localObject4).getKey();
        localObject4 = (String)localObject4;
        localObject4 = zzmh((String)localObject4);
        if (localObject4 != null) {
          ((Map)localObject2).put(localObject3, localObject4);
        }
      }
      Object localObject5;
      Object localObject6;
      label755:
      return;
    }
    catch (IllegalArgumentException paramTracker)
    {
      break label755;
      localLinkedList.add(localObject2);
      localObject1 = zzmi("transactionProducts");
      if (localObject1 != null)
      {
        localObject2 = ((List)localObject1).iterator();
        for (;;)
        {
          bool = ((Iterator)localObject2).hasNext();
          if (!bool) {
            break;
          }
          localObject1 = ((Iterator)localObject2).next();
          localObject3 = (Map)localObject1;
          localObject1 = ((Map)localObject3).get("name");
          if (localObject1 == null)
          {
            paramTracker = zzdj.zzjss;
            paramTracker.get("Unable to send transaction item hit due to missing 'name' field.");
            return;
          }
          localObject1 = zzjwv;
          localObject1 = paramMap.get(localObject1);
          localObject1 = (zzbp)localObject1;
          localObject4 = get((zzbp)localObject1);
          ((Map)localObject4).put("&t", "item");
          ((Map)localObject4).put("&ti", str);
          localObject1 = zzjwy;
          localObject1 = paramMap.get(localObject1);
          localObject1 = (zzbp)localObject1;
          if (localObject1 != null)
          {
            localObject1 = getValue((zzbp)localObject1);
          }
          else
          {
            if (zzjxd == null)
            {
              localObject1 = new HashMap();
              ((HashMap)localObject1).put("name", "&in");
              ((HashMap)localObject1).put("sku", "&ic");
              ((HashMap)localObject1).put("category", "&iv");
              ((HashMap)localObject1).put("price", "&ip");
              ((HashMap)localObject1).put("quantity", "&iq");
              ((HashMap)localObject1).put("currency", "&cu");
              zzjxd = (Map)localObject1;
            }
            localObject1 = zzjxd;
          }
          localObject1 = ((Map)localObject1).entrySet().iterator();
          for (;;)
          {
            bool = ((Iterator)localObject1).hasNext();
            if (!bool) {
              break;
            }
            localObject5 = ((Iterator)localObject1).next();
            localObject6 = (Map.Entry)localObject5;
            localObject5 = ((Map.Entry)localObject6).getValue();
            localObject5 = (String)localObject5;
            localObject6 = ((Map)localObject3).get(((Map.Entry)localObject6).getKey());
            localObject6 = (String)localObject6;
            if (localObject6 != null) {
              ((Map)localObject4).put(localObject5, localObject6);
            }
          }
          localLinkedList.add(localObject4);
        }
      }
      paramMap = localLinkedList.iterator();
      for (;;)
      {
        bool = paramMap.hasNext();
        if (!bool) {
          break;
        }
        localObject1 = paramMap.next();
        localObject1 = (Map)localObject1;
        paramTracker.send((Map)localObject1);
      }
      return;
      zzdj.zzjss.e("Unable to send transaction", paramTracker);
    }
  }
  
  public static Double zzal(Object paramObject)
  {
    if ((paramObject instanceof String))
    {
      paramObject = (String)paramObject;
      try
      {
        paramObject = Double.valueOf(paramObject);
        return paramObject;
      }
      catch (NumberFormatException paramObject)
      {
        paramObject = String.valueOf(paramObject.getMessage());
        if (paramObject.length() != 0) {
          paramObject = "Cannot convert the object to Double: ".concat(paramObject);
        } else {
          paramObject = new String("Cannot convert the object to Double: ");
        }
        throw new RuntimeException(paramObject);
      }
    }
    if ((paramObject instanceof Integer)) {
      return Double.valueOf(((Integer)paramObject).doubleValue());
    }
    if ((paramObject instanceof Double)) {
      return (Double)paramObject;
    }
    paramObject = String.valueOf(paramObject.toString());
    if (paramObject.length() != 0) {
      paramObject = "Cannot convert the object to Double: ".concat(paramObject);
    } else {
      paramObject = new String("Cannot convert the object to Double: ");
    }
    throw new RuntimeException(paramObject);
  }
  
  public static Integer zzam(Object paramObject)
  {
    if ((paramObject instanceof String))
    {
      paramObject = (String)paramObject;
      try
      {
        paramObject = Integer.valueOf(paramObject);
        return paramObject;
      }
      catch (NumberFormatException paramObject)
      {
        paramObject = String.valueOf(paramObject.getMessage());
        if (paramObject.length() != 0) {
          paramObject = "Cannot convert the object to Integer: ".concat(paramObject);
        } else {
          paramObject = new String("Cannot convert the object to Integer: ");
        }
        throw new RuntimeException(paramObject);
      }
    }
    if ((paramObject instanceof Double)) {
      return Integer.valueOf(((Double)paramObject).intValue());
    }
    if ((paramObject instanceof Integer)) {
      return (Integer)paramObject;
    }
    paramObject = String.valueOf(paramObject.toString());
    if (paramObject.length() != 0) {
      paramObject = "Cannot convert the object to Integer: ".concat(paramObject);
    } else {
      paramObject = new String("Cannot convert the object to Integer: ");
    }
    throw new RuntimeException(paramObject);
  }
  
  private final String zzmh(String paramString)
  {
    paramString = zzjpa.getValue(paramString);
    if (paramString == null) {
      return null;
    }
    return paramString.toString();
  }
  
  private final List zzmi(String paramString)
  {
    paramString = zzjpa.getValue(paramString);
    if (paramString == null) {
      return null;
    }
    if ((paramString instanceof List))
    {
      paramString = (List)paramString;
      Iterator localIterator = paramString.iterator();
      do
      {
        if (!localIterator.hasNext()) {
          break;
        }
      } while ((localIterator.next() instanceof Map));
      throw new IllegalArgumentException("Each element of transactionProducts should be of type Map.");
    }
    paramString = new IllegalArgumentException("transactionProducts should be of type List.");
    throw paramString;
    return paramString;
  }
  
  public final void doInBackground(Map paramMap)
  {
    Tracker localTracker = zzjxf.zzmc("_GTM_DEFAULT_TRACKER_");
    localTracker.enableAdvertisingIdCollection(saveData(paramMap, "collect_adid"));
    HitBuilders.ScreenViewBuilder localScreenViewBuilder;
    if (saveData(paramMap, zzjws))
    {
      localScreenViewBuilder = new HitBuilders.ScreenViewBuilder();
      Object localObject5 = get((zzbp)paramMap.get(zzjwv));
      localScreenViewBuilder.setAll((Map)localObject5);
      boolean bool = saveData(paramMap, zzjwt);
      Object localObject4 = null;
      Object localObject1;
      if (bool)
      {
        localObject1 = zzjpa.getValue("ecommerce");
        paramMap = (Map)localObject1;
        if (!(localObject1 instanceof Map)) {
          break label148;
        }
      }
      else
      {
        localObject1 = zzgk.get((zzbp)paramMap.get(zzjwu));
        paramMap = (Map)localObject1;
        if (!(localObject1 instanceof Map)) {
          break label148;
        }
      }
      paramMap = (Map)paramMap;
      break label150;
      label148:
      paramMap = null;
      label150:
      if (paramMap != null)
      {
        localObject5 = (String)((Map)localObject5).get("&cu");
        localObject1 = localObject5;
        if (localObject5 == null) {
          localObject1 = (String)paramMap.get("currencyCode");
        }
        if (localObject1 != null) {
          localScreenViewBuilder.set("&cu", (String)localObject1);
        }
        localObject1 = paramMap.get("impressions");
        if ((localObject1 instanceof List))
        {
          localObject5 = ((List)localObject1).iterator();
          while (((Iterator)localObject5).hasNext())
          {
            localObject1 = (Map)((Iterator)localObject5).next();
            try
            {
              localScreenViewBuilder.addImpression(calculate((Map)localObject1), (String)((Map)localObject1).get("list"));
            }
            catch (RuntimeException localRuntimeException1)
            {
              localObject2 = String.valueOf(localRuntimeException1.getMessage());
              if (((String)localObject2).length() != 0) {
                localObject2 = "Failed to extract a product from DataLayer. ".concat((String)localObject2);
              } else {
                localObject2 = new String("Failed to extract a product from DataLayer. ");
              }
              zzdj.zzjss.get((String)localObject2);
            }
          }
        }
        if (paramMap.containsKey("promoClick")) {}
        for (Object localObject2 = paramMap.get("promoClick");; localObject2 = paramMap.get("promoView"))
        {
          localObject2 = (List)((Map)localObject2).get("promotions");
          break;
          localObject2 = localObject4;
          if (!paramMap.containsKey("promoView")) {
            break;
          }
        }
        int j = 1;
        int i = j;
        Object localObject3;
        if (localObject2 != null)
        {
          localObject4 = ((List)localObject2).iterator();
          while (((Iterator)localObject4).hasNext())
          {
            localObject5 = (Map)((Iterator)localObject4).next();
            try
            {
              localObject2 = new Promotion();
              String str = (String)((Map)localObject5).get("id");
              if (str != null) {
                ((Promotion)localObject2).setId(str);
              }
              str = (String)((Map)localObject5).get("name");
              if (str != null) {
                ((Promotion)localObject2).setName(str);
              }
              str = (String)((Map)localObject5).get("creative");
              if (str != null) {
                ((Promotion)localObject2).setCreative(str);
              }
              localObject5 = (String)((Map)localObject5).get("position");
              if (localObject5 != null) {
                ((Promotion)localObject2).setPosition((String)localObject5);
              }
              localScreenViewBuilder.addPromotion((Promotion)localObject2);
            }
            catch (RuntimeException localRuntimeException2)
            {
              localObject3 = String.valueOf(localRuntimeException2.getMessage());
              if (((String)localObject3).length() != 0) {
                localObject3 = "Failed to extract a promotion from DataLayer. ".concat((String)localObject3);
              } else {
                localObject3 = new String("Failed to extract a promotion from DataLayer. ");
              }
              zzdj.zzjss.get((String)localObject3);
            }
          }
          if (paramMap.containsKey("promoClick"))
          {
            localScreenViewBuilder.set("&promoa", "click");
            i = 0;
          }
          else
          {
            localScreenViewBuilder.set("&promoa", "view");
            i = j;
          }
        }
        if (i != 0)
        {
          localObject4 = zzjwz.iterator();
          while (((Iterator)localObject4).hasNext())
          {
            localObject3 = (String)((Iterator)localObject4).next();
            if (paramMap.containsKey(localObject3))
            {
              localObject4 = (Map)paramMap.get(localObject3);
              paramMap = (List)((Map)localObject4).get("products");
              if (paramMap != null)
              {
                localObject5 = paramMap.iterator();
                while (((Iterator)localObject5).hasNext())
                {
                  paramMap = (Map)((Iterator)localObject5).next();
                  try
                  {
                    localScreenViewBuilder.addProduct(calculate(paramMap));
                  }
                  catch (RuntimeException paramMap)
                  {
                    paramMap = String.valueOf(paramMap.getMessage());
                    if (paramMap.length() != 0) {
                      paramMap = "Failed to extract a product from DataLayer. ".concat(paramMap);
                    } else {
                      paramMap = new String("Failed to extract a product from DataLayer. ");
                    }
                    zzdj.zzjss.get(paramMap);
                  }
                }
              }
              try
              {
                bool = ((Map)localObject4).containsKey("actionField");
                if (bool)
                {
                  paramMap = (Map)((Map)localObject4).get("actionField");
                  localObject3 = new ProductAction((String)localObject3);
                  localObject4 = paramMap.get("id");
                  if (localObject4 != null) {
                    ((ProductAction)localObject3).setTransactionId(String.valueOf(localObject4));
                  }
                  localObject4 = paramMap.get("affiliation");
                  if (localObject4 != null) {
                    ((ProductAction)localObject3).setTransactionAffiliation(String.valueOf(localObject4));
                  }
                  localObject4 = paramMap.get("coupon");
                  if (localObject4 != null) {
                    ((ProductAction)localObject3).setTransactionCouponCode(String.valueOf(localObject4));
                  }
                  localObject4 = paramMap.get("list");
                  if (localObject4 != null) {
                    ((ProductAction)localObject3).setProductActionList(String.valueOf(localObject4));
                  }
                  localObject4 = paramMap.get("option");
                  if (localObject4 != null) {
                    ((ProductAction)localObject3).setCheckoutOptions(String.valueOf(localObject4));
                  }
                  localObject4 = paramMap.get("revenue");
                  if (localObject4 != null) {
                    ((ProductAction)localObject3).setTransactionRevenue(zzal(localObject4).doubleValue());
                  }
                  localObject4 = paramMap.get("tax");
                  if (localObject4 != null) {
                    ((ProductAction)localObject3).setTransactionTax(zzal(localObject4).doubleValue());
                  }
                  localObject4 = paramMap.get("shipping");
                  if (localObject4 != null) {
                    ((ProductAction)localObject3).setTransactionShipping(zzal(localObject4).doubleValue());
                  }
                  localObject4 = paramMap.get("step");
                  paramMap = (Map)localObject3;
                  if (localObject4 != null)
                  {
                    ((ProductAction)localObject3).setCheckoutStep(zzam(localObject4).intValue());
                    paramMap = (Map)localObject3;
                  }
                }
                else
                {
                  paramMap = new ProductAction((String)localObject3);
                }
                localScreenViewBuilder.setProductAction(paramMap);
              }
              catch (RuntimeException paramMap)
              {
                paramMap = String.valueOf(paramMap.getMessage());
                if (paramMap.length() != 0) {
                  paramMap = "Failed to extract a product action from DataLayer. ".concat(paramMap);
                } else {
                  paramMap = new String("Failed to extract a product action from DataLayer. ");
                }
                zzdj.zzjss.get(paramMap);
              }
            }
          }
        }
      }
    }
    for (paramMap = localScreenViewBuilder.build();; paramMap = get((zzbp)paramMap.get(zzjwv)))
    {
      localTracker.send(paramMap);
      return;
      if (!saveData(paramMap, zzjwr)) {
        break;
      }
    }
    if (saveData(paramMap, zzjww))
    {
      sendTransaction(localTracker, paramMap);
      return;
    }
    zzdj.zzjss.zzcr("Ignoring unknown tag.");
  }
  
  public final zzbp evaluate(Map paramMap)
  {
    doInBackground(paramMap);
    return zzgk.zzjwp;
  }
  
  public final boolean zzbcj()
  {
    return false;
  }
  
  public final String zzbdp()
  {
    return zzjrp;
  }
  
  public final Set zzbdq()
  {
    return zzjro;
  }
}
