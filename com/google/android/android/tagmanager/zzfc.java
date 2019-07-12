package com.google.android.android.tagmanager;

import android.content.Context;
import com.google.android.android.internal.zzbe;
import com.google.android.android.internal.zzdbo;
import com.google.android.android.internal.zzdbs;
import com.google.android.android.internal.zzeyn;
import com.google.android.gms.tagmanager.zzp;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public final class zzfc
{
  public static final com.google.android.gms.tagmanager.zzea<com.google.android.gms.internal.zzbp> zzjuh = new zzea(zzgk.zzjwp, true);
  public final DataLayer zzjpa;
  public final zzdbs zzjui;
  public final zzbo zzjuj;
  public final Map<String, com.google.android.gms.tagmanager.zzbr> zzjuk;
  public final Map<String, com.google.android.gms.tagmanager.zzbr> zzjul;
  public final Map<String, com.google.android.gms.tagmanager.zzbr> zzjum;
  public final zzp<com.google.android.gms.internal.zzdbq, com.google.android.gms.tagmanager.zzea<com.google.android.gms.internal.zzbp>> zzjun;
  public final zzp<String, com.google.android.gms.tagmanager.zzfi> zzjuo;
  public final Set<com.google.android.gms.internal.zzdbu> zzjup;
  public final Map<String, com.google.android.gms.tagmanager.zzfj> zzjuq;
  public volatile String zzjur;
  public int zzjus;
  
  public zzfc(Context paramContext, zzdbs paramZzdbs, DataLayer paramDataLayer, zzan paramZzan1, zzan paramZzan2, zzbo paramZzbo)
  {
    if (paramZzdbs != null)
    {
      zzjui = paramZzdbs;
      zzjup = new HashSet(paramZzdbs.zzbhb());
      zzjpa = paramDataLayer;
      zzjuj = paramZzbo;
      paramZzdbs = new zzfd(this);
      new TileCache();
      zzjun = TileCache.createCache(1048576, paramZzdbs);
      paramZzdbs = new zzfe(this);
      new TileCache();
      zzjuo = TileCache.createCache(1048576, paramZzdbs);
      zzjuk = new HashMap();
      paramZzdbs = new DatabaseAdapter(paramContext);
      compile(zzjuk, paramZzdbs);
      paramZzdbs = new zzam(paramZzan2);
      compile(zzjuk, paramZzdbs);
      paramZzdbs = new zzaz(paramDataLayer);
      compile(zzjuk, paramZzdbs);
      paramZzdbs = new zzgl(paramContext, paramDataLayer);
      compile(zzjuk, paramZzdbs);
      zzjul = new HashMap();
      paramZzdbs = new zzak();
      compile(zzjul, paramZzdbs);
      paramZzdbs = new zzbl();
      compile(zzjul, paramZzdbs);
      paramZzdbs = new zzbm();
      compile(zzjul, paramZzdbs);
      paramZzdbs = new zzbt();
      compile(zzjul, paramZzdbs);
      paramZzdbs = new zzbu();
      compile(zzjul, paramZzdbs);
      paramZzdbs = new zzdf();
      compile(zzjul, paramZzdbs);
      paramZzdbs = new zzdg();
      compile(zzjul, paramZzdbs);
      paramZzdbs = new zzem();
      compile(zzjul, paramZzdbs);
      paramZzdbs = new zzfz();
      compile(zzjul, paramZzdbs);
      zzjum = new HashMap();
      paramZzdbs = new Tokenizer(paramContext);
      compile(zzjum, paramZzdbs);
      paramZzdbs = new SimpleNode(paramContext);
      compile(zzjum, paramZzdbs);
      paramZzdbs = new Predicate(paramContext);
      compile(zzjum, paramZzdbs);
      paramZzdbs = new Contact(paramContext);
      compile(zzjum, paramZzdbs);
      paramZzdbs = new Transform(paramContext);
      compile(zzjum, paramZzdbs);
      paramZzdbs = new Node(paramContext);
      compile(zzjum, paramZzdbs);
      paramZzdbs = new Machine(paramContext);
      compile(zzjum, paramZzdbs);
      paramZzdbs = new Way();
      compile(zzjum, paramZzdbs);
      paramZzdbs = new zzaj(zzjui.getVersion());
      compile(zzjum, paramZzdbs);
      paramZzdbs = new zzam(paramZzan1);
      compile(zzjum, paramZzdbs);
      paramZzdbs = new zzas(paramDataLayer);
      compile(zzjum, paramZzdbs);
      paramZzdbs = new zzbc(paramContext);
      compile(zzjum, paramZzdbs);
      paramZzdbs = new zzbd();
      compile(zzjum, paramZzdbs);
      paramZzdbs = new zzbk();
      compile(zzjum, paramZzdbs);
      paramZzdbs = new zzbp(this);
      compile(zzjum, paramZzdbs);
      paramZzdbs = new zzbv();
      compile(zzjum, paramZzdbs);
      paramZzdbs = new zzbw();
      compile(zzjum, paramZzdbs);
      paramZzdbs = new zzcw(paramContext);
      compile(zzjum, paramZzdbs);
      paramZzdbs = new zzcy();
      compile(zzjum, paramZzdbs);
      paramZzdbs = new zzde();
      compile(zzjum, paramZzdbs);
      paramZzdbs = new zzdl();
      compile(zzjum, paramZzdbs);
      paramZzdbs = new zzdn(paramContext);
      compile(zzjum, paramZzdbs);
      paramZzdbs = new zzeb();
      compile(zzjum, paramZzdbs);
      paramZzdbs = new zzef();
      compile(zzjum, paramZzdbs);
      paramZzdbs = new zzej();
      compile(zzjum, paramZzdbs);
      paramZzdbs = new zzel();
      compile(zzjum, paramZzdbs);
      paramContext = new zzen(paramContext);
      compile(zzjum, paramContext);
      paramContext = new zzfk();
      compile(zzjum, paramContext);
      paramContext = new zzfl();
      compile(zzjum, paramContext);
      paramContext = new zzgf();
      compile(zzjum, paramContext);
      paramContext = new zzgm();
      compile(zzjum, paramContext);
      zzjuq = new HashMap();
      paramContext = zzjup.iterator();
      while (paramContext.hasNext())
      {
        paramZzdbs = (com.google.android.android.internal.zzdbu)paramContext.next();
        int k = 0;
        int i = 0;
        int j;
        for (;;)
        {
          j = k;
          if (i >= paramZzdbs.zzbia().size()) {
            break;
          }
          paramDataLayer = (com.google.android.android.internal.zzdbq)paramZzdbs.zzbia().get(i);
          paramZzan1 = get(zzjuq, getParameters(paramDataLayer));
          paramZzan1.split(paramZzdbs);
          paramZzan1.split(paramZzdbs, paramDataLayer);
          paramZzan1.split(paramZzdbs, "Unknown");
          i += 1;
        }
        while (j < paramZzdbs.zzbib().size())
        {
          paramDataLayer = (com.google.android.android.internal.zzdbq)paramZzdbs.zzbib().get(j);
          paramZzan1 = get(zzjuq, getParameters(paramDataLayer));
          paramZzan1.split(paramZzdbs);
          paramZzan1.normalize(paramZzdbs, paramDataLayer);
          paramZzan1.normalize(paramZzdbs, "Unknown");
          j += 1;
        }
      }
      paramContext = zzjui.zzbhy().entrySet().iterator();
      while (paramContext.hasNext())
      {
        paramZzdbs = (Map.Entry)paramContext.next();
        paramDataLayer = ((List)paramZzdbs.getValue()).iterator();
        while (paramDataLayer.hasNext())
        {
          paramZzan1 = (com.google.android.android.internal.zzdbq)paramDataLayer.next();
          if (!zzgk.valueOf((com.google.android.android.internal.zzbp)paramZzan1.zzbhd().get(zzbe.zzrt.toString())).booleanValue()) {
            get(zzjuq, (String)paramZzdbs.getKey()).split(paramZzan1);
          }
        }
      }
      return;
    }
    paramContext = new NullPointerException("resource cannot be null");
    throw paramContext;
  }
  
  private final void addPattern(zzbr paramZzbr)
  {
    compile(zzjuk, paramZzbr);
  }
  
  public static void compile(Map paramMap, zzbr paramZzbr)
  {
    if (paramMap.containsKey(paramZzbr.zzbdp()))
    {
      paramMap = String.valueOf(paramZzbr.zzbdp());
      if (paramMap.length() != 0) {
        paramMap = "Duplicate function type name: ".concat(paramMap);
      } else {
        paramMap = new String("Duplicate function type name: ");
      }
      throw new IllegalArgumentException(paramMap);
    }
    paramMap.put(paramZzbr.zzbdp(), paramZzbr);
  }
  
  private final void deletePage(zzbr paramZzbr)
  {
    compile(zzjum, paramZzbr);
  }
  
  private final zzea executeFunction(com.google.android.android.internal.zzdbu paramZzdbu, Set paramSet, zzer paramZzer)
  {
    Object localObject = paramZzdbu.zzbhg().iterator();
    Boolean localBoolean = Boolean.valueOf(true);
    for (boolean bool = true;; bool = false)
    {
      if (!((Iterator)localObject).hasNext()) {
        break label114;
      }
      zzea localZzea = getObject((com.google.android.android.internal.zzdbq)((Iterator)localObject).next(), paramSet, paramZzer.zzbdv());
      if (((Boolean)localZzea.getObject()).booleanValue())
      {
        zzgk.zzah(Boolean.valueOf(false));
        return new zzea(Boolean.valueOf(false), localZzea.zzbed());
      }
      if ((bool) && (localZzea.zzbed())) {
        break;
      }
    }
    label114:
    paramZzdbu = paramZzdbu.zzbhf().iterator();
    while (paramZzdbu.hasNext())
    {
      localObject = getObject((com.google.android.android.internal.zzdbq)paramZzdbu.next(), paramSet, paramZzer.zzbdw());
      if (!((Boolean)((zzea)localObject).getObject()).booleanValue())
      {
        zzgk.zzah(Boolean.valueOf(false));
        return new zzea(Boolean.valueOf(false), ((zzea)localObject).zzbed());
      }
      if ((bool) && (((zzea)localObject).zzbed())) {
        bool = true;
      } else {
        bool = false;
      }
    }
    zzgk.zzah(localBoolean);
    return new zzea(localBoolean, bool);
  }
  
  private final zzea executeFunction(String paramString, Set paramSet, zzdm paramZzdm)
  {
    zzjus += 1;
    Object localObject = (zzfi)zzjuo.get(paramString);
    if (localObject != null)
    {
      writeAttributes(((zzfi)localObject).zzber(), paramSet);
      zzjus -= 1;
      return ((zzfi)localObject).zzbeq();
    }
    localObject = (zzfj)zzjuq.get(paramString);
    if (localObject == null)
    {
      paramSet = zzbep();
      paramString = f.sufficientlysecure.rootcommands.util.StringBuilder.append(f.sufficientlysecure.rootcommands.util.StringBuilder.append(paramString, f.sufficientlysecure.rootcommands.util.StringBuilder.append(paramSet, 15)), paramSet, "Invalid macro: ", paramString);
      zzdj.zzjss.get(paramString);
      zzjus -= 1;
      return zzjuh;
    }
    zzea localZzea1 = forEach(paramString, ((zzfj)localObject).zzbes(), ((zzfj)localObject).zzbet(), ((zzfj)localObject).zzbeu(), ((zzfj)localObject).zzbew(), ((zzfj)localObject).zzbev(), paramSet, paramZzdm.zzbde());
    if (((Set)localZzea1.getObject()).isEmpty())
    {
      localObject = ((zzfj)localObject).zzbex();
    }
    else
    {
      if (((Set)localZzea1.getObject()).size() > 1)
      {
        localObject = zzbep();
        localObject = f.sufficientlysecure.rootcommands.util.StringBuilder.append(f.sufficientlysecure.rootcommands.util.StringBuilder.append(paramString, f.sufficientlysecure.rootcommands.util.StringBuilder.append(localObject, 37)), (String)localObject, "Multiple macros active for macroName ", paramString);
        zzdj.zzjss.zzcr((String)localObject);
      }
      localObject = (com.google.android.android.internal.zzdbq)((Set)localZzea1.getObject()).iterator().next();
    }
    if (localObject == null)
    {
      zzjus -= 1;
      return zzjuh;
    }
    zzea localZzea2 = executeFunction(zzjum, (com.google.android.android.internal.zzdbq)localObject, paramSet, paramZzdm.zzbdu());
    boolean bool;
    if ((localZzea1.zzbed()) && (localZzea2.zzbed())) {
      bool = true;
    } else {
      bool = false;
    }
    paramZzdm = zzjuh;
    if (localZzea2 != paramZzdm) {
      paramZzdm = new zzea((com.google.android.android.internal.zzbp)localZzea2.getObject(), bool);
    }
    localObject = ((com.google.android.android.internal.zzdbq)localObject).zzber();
    if (paramZzdm.zzbed()) {
      zzjuo.put(paramString, new zzfi(paramZzdm, (com.google.android.android.internal.zzbp)localObject));
    }
    writeAttributes((com.google.android.android.internal.zzbp)localObject, paramSet);
    zzjus -= 1;
    return paramZzdm;
  }
  
  private final zzea executeFunction(Map paramMap, com.google.android.android.internal.zzdbq paramZzdbq, Set paramSet, zzeo paramZzeo)
  {
    Object localObject1 = (com.google.android.android.internal.zzbp)paramZzdbq.zzbhd().get(zzbe.zzqc.toString());
    if (localObject1 == null)
    {
      zzdj.zzjss.get("No function id in properties");
      return zzjuh;
    }
    localObject1 = zzye;
    paramMap = (zzbr)paramMap.get(localObject1);
    if (paramMap == null) {}
    Object localObject2;
    boolean bool;
    int i;
    for (paramMap = String.valueOf(localObject1).concat(" has no backing implementation.");; paramMap = f.sufficientlysecure.rootcommands.util.StringBuilder.append(paramSet, " had ", paramZzdbq))
    {
      zzdj.zzjss.get(paramMap);
      break;
      localObject2 = (zzea)zzjun.get(paramZzdbq);
      if (localObject2 != null) {
        return localObject2;
      }
      localObject2 = new HashMap();
      Iterator localIterator = paramZzdbq.zzbhd().entrySet().iterator();
      bool = true;
      i = 1;
      while (localIterator.hasNext())
      {
        Map.Entry localEntry = (Map.Entry)localIterator.next();
        Object localObject3 = paramZzeo.zzlw((String)localEntry.getKey());
        localObject3 = multiply((com.google.android.android.internal.zzbp)localEntry.getValue(), paramSet, ((zzeq)localObject3).getObject((com.google.android.android.internal.zzbp)localEntry.getValue()));
        zzea localZzea = zzjuh;
        if (localObject3 == localZzea) {
          return localZzea;
        }
        if (((zzea)localObject3).zzbed()) {
          paramZzdbq.put((String)localEntry.getKey(), (com.google.android.android.internal.zzbp)((zzea)localObject3).getObject());
        } else {
          i = 0;
        }
        ((Map)localObject2).put((String)localEntry.getKey(), (com.google.android.android.internal.zzbp)((zzea)localObject3).getObject());
      }
      if (paramMap.containsAll(((Map)localObject2).keySet())) {
        break label403;
      }
      paramMap = String.valueOf(paramMap.zzbdq());
      paramZzdbq = String.valueOf(((Map)localObject2).keySet());
      i = f.sufficientlysecure.rootcommands.util.StringBuilder.append(localObject1, 43);
      int j = paramMap.length();
      paramSet = new StringBuilder(paramZzdbq.length() + (j + i));
      paramSet.append("Incorrect keys for function ");
      paramSet.append((String)localObject1);
      paramSet.append(" required ");
      paramSet.append(paramMap);
    }
    label403:
    if ((i == 0) || (!paramMap.zzbcj())) {
      bool = false;
    }
    paramMap = new zzea(paramMap.evaluate((Map)localObject2), bool);
    if (bool) {
      zzjun.put(paramZzdbq, paramMap);
    }
    return paramMap;
  }
  
  private final zzea forEach(String paramString, Set paramSet1, Map paramMap1, Map paramMap2, Map paramMap3, Map paramMap4, Set paramSet2, zzfb paramZzfb)
  {
    return forEach(paramSet1, paramSet2, new zzff(this, paramMap1, paramMap2, paramMap3, paramMap4), paramZzfb);
  }
  
  private final zzea forEach(Set paramSet1, Set paramSet2, zzfh paramZzfh, zzfb paramZzfb)
  {
    HashSet localHashSet1 = new HashSet();
    HashSet localHashSet2 = new HashSet();
    paramSet1 = paramSet1.iterator();
    for (boolean bool = true;; bool = false)
    {
      if (!paramSet1.hasNext()) {
        break label118;
      }
      com.google.android.android.internal.zzdbu localZzdbu = (com.google.android.android.internal.zzdbu)paramSet1.next();
      zzer localZzer = paramZzfb.zzbeb();
      zzea localZzea = executeFunction(localZzdbu, paramSet2, localZzer);
      if (((Boolean)localZzea.getObject()).booleanValue()) {
        paramZzfh.putAll(localZzdbu, localHashSet1, localHashSet2, localZzer);
      }
      if ((bool) && (localZzea.zzbed())) {
        break;
      }
    }
    label118:
    localHashSet1.removeAll(localHashSet2);
    return new zzea(localHashSet1, bool);
  }
  
  public static zzfj get(Map paramMap, String paramString)
  {
    zzfj localZzfj2 = (zzfj)paramMap.get(paramString);
    zzfj localZzfj1 = localZzfj2;
    if (localZzfj2 == null)
    {
      localZzfj1 = new zzfj();
      paramMap.put(paramString, localZzfj1);
    }
    return localZzfj1;
  }
  
  private final zzea getObject(com.google.android.android.internal.zzdbq paramZzdbq, Set paramSet, zzeo paramZzeo)
  {
    paramZzdbq = executeFunction(zzjul, paramZzdbq, paramSet, paramZzeo);
    paramSet = zzgk.valueOf((com.google.android.android.internal.zzbp)paramZzdbq.getObject());
    zzgk.zzah(paramSet);
    return new zzea(paramSet, paramZzdbq.zzbed());
  }
  
  public static String getParameters(com.google.android.android.internal.zzdbq paramZzdbq)
  {
    return zzgk.toString((com.google.android.android.internal.zzbp)paramZzdbq.zzbhd().get(zzbe.zzqo.toString()));
  }
  
  private final zzea multiply(com.google.android.android.internal.zzbp paramZzbp, Set paramSet, zzgn paramZzgn)
  {
    if (!zzyj) {
      return new zzea(paramZzbp, true);
    }
    int i = type;
    Object localObject;
    zzea localZzea1;
    if (i != 2)
    {
      if (i != 3)
      {
        if (i != 4)
        {
          if (i != 7)
          {
            paramZzbp = f.sufficientlysecure.rootcommands.util.StringBuilder.add(25, "Unknown type: ", i);
            zzdj.zzjss.get(paramZzbp);
            return zzjuh;
          }
          localZzbp = zzdbo.multiply(paramZzbp);
          zzyh = new com.google.android.android.internal.zzbp[zzyh.length];
          i = 0;
          for (;;)
          {
            localObject = zzyh;
            if (i >= localObject.length) {
              break;
            }
            localObject = multiply(localObject[i], paramSet, paramZzgn.zzej(i));
            localZzea1 = zzjuh;
            if (localObject == localZzea1) {
              return localZzea1;
            }
            zzyh[i] = ((com.google.android.android.internal.zzbp)((zzea)localObject).getObject());
            i += 1;
          }
          return new zzea(localZzbp, false);
        }
        if (paramSet.contains(zzyd))
        {
          paramZzbp = zzyd;
          paramSet = paramSet.toString();
          paramZzgn = new StringBuilder(f.sufficientlysecure.rootcommands.util.StringBuilder.append(paramSet, f.sufficientlysecure.rootcommands.util.StringBuilder.append(paramZzbp, 79)));
          paramZzgn.append("Macro cycle detected.  Current macro reference: ");
          paramZzgn.append(paramZzbp);
          paramZzgn.append(".  Previous macro references: ");
          paramZzgn.append(paramSet);
          paramZzgn.append(".");
          paramZzbp = paramZzgn.toString();
          zzdj.zzjss.get(paramZzbp);
          return zzjuh;
        }
        paramSet.add(zzyd);
        paramZzgn = zzgo.evaluate(executeFunction(zzyd, paramSet, paramZzgn.zzbec()), zzyi);
        paramSet.remove(zzyd);
        return paramZzgn;
      }
      localZzbp = zzdbo.multiply(paramZzbp);
      localObject = zzyb;
      if (localObject.length != zzyc.length)
      {
        paramZzbp = String.valueOf(paramZzbp.toString());
        if (paramZzbp.length() != 0) {
          paramZzbp = "Invalid serving value: ".concat(paramZzbp);
        } else {
          paramZzbp = new String("Invalid serving value: ");
        }
        zzdj.zzjss.get(paramZzbp);
        return zzjuh;
      }
      zzyb = new com.google.android.android.internal.zzbp[localObject.length];
      zzyc = new com.google.android.android.internal.zzbp[zzyb.length];
      i = 0;
      for (;;)
      {
        localObject = zzyb;
        if (i >= localObject.length) {
          break label544;
        }
        localObject = multiply(localObject[i], paramSet, paramZzgn.zzeh(i));
        localZzea1 = multiply(zzyc[i], paramSet, paramZzgn.zzei(i));
        zzea localZzea2 = zzjuh;
        if ((localObject == localZzea2) || (localZzea1 == localZzea2)) {
          break;
        }
        zzyb[i] = ((com.google.android.android.internal.zzbp)((zzea)localObject).getObject());
        zzyc[i] = ((com.google.android.android.internal.zzbp)localZzea1.getObject());
        i += 1;
      }
      return zzjuh;
      label544:
      return new zzea(localZzbp, false);
    }
    com.google.android.android.internal.zzbp localZzbp = zzdbo.multiply(paramZzbp);
    zzya = new com.google.android.android.internal.zzbp[zzya.length];
    i = 0;
    for (;;)
    {
      localObject = zzya;
      if (i >= localObject.length) {
        break;
      }
      localObject = multiply(localObject[i], paramSet, paramZzgn.zzeg(i));
      localZzea1 = zzjuh;
      if (localObject == localZzea1) {
        return localZzea1;
      }
      zzya[i] = ((com.google.android.android.internal.zzbp)((zzea)localObject).getObject());
      i += 1;
    }
    return new zzea(localZzbp, false);
  }
  
  private final void rewrite(zzbr paramZzbr)
  {
    compile(zzjul, paramZzbr);
  }
  
  private final void writeAttributes(com.google.android.android.internal.zzbp paramZzbp, Set paramSet)
  {
    if (paramZzbp == null) {
      return;
    }
    paramZzbp = multiply(paramZzbp, paramSet, new zzdy());
    if (paramZzbp == zzjuh) {
      return;
    }
    paramZzbp = zzgk.get((com.google.android.android.internal.zzbp)paramZzbp.getObject());
    if ((paramZzbp instanceof Map))
    {
      paramZzbp = (Map)paramZzbp;
      zzjpa.push(paramZzbp);
      return;
    }
    if ((paramZzbp instanceof List))
    {
      paramZzbp = ((List)paramZzbp).iterator();
      while (paramZzbp.hasNext())
      {
        paramSet = paramZzbp.next();
        if ((paramSet instanceof Map))
        {
          paramSet = (Map)paramSet;
          zzjpa.push(paramSet);
        }
        else
        {
          zzdj.zzjss.zzcr("pushAfterEvaluate: value not a Map");
        }
      }
      return;
    }
    zzdj.zzjss.zzcr("pushAfterEvaluate: value not a Map or List");
  }
  
  private final String zzbep()
  {
    if (zzjus <= 1) {
      return "";
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(Integer.toString(zzjus));
    int i = 2;
    while (i < zzjus)
    {
      localStringBuilder.append(' ');
      i += 1;
    }
    localStringBuilder.append(": ");
    return localStringBuilder.toString();
  }
  
  private final void zzma(String paramString)
  {
    try
    {
      zzjur = paramString;
      return;
    }
    catch (Throwable paramString)
    {
      throw paramString;
    }
  }
  
  public final void zzaj(List paramList)
  {
    try
    {
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        Object localObject = (com.google.android.android.internal.zzbn)paramList.next();
        if ((name != null) && (name.startsWith("gaExperiment:")))
        {
          zzbq.parseString(zzjpa, (com.google.android.android.internal.zzbn)localObject);
        }
        else
        {
          localObject = String.valueOf(localObject);
          StringBuilder localStringBuilder = new StringBuilder(((String)localObject).length() + 22);
          localStringBuilder.append("Ignored supplemental: ");
          localStringBuilder.append((String)localObject);
          localObject = localStringBuilder.toString();
          zzdj.zzjss.append((String)localObject);
        }
      }
      return;
    }
    catch (Throwable paramList)
    {
      throw paramList;
    }
  }
  
  public final String zzbeo()
  {
    try
    {
      String str = zzjur;
      return str;
    }
    catch (Throwable localThrowable)
    {
      throw localThrowable;
    }
  }
  
  public final void zzlg(String paramString)
  {
    for (;;)
    {
      try
      {
        zzma(paramString);
        paramString = zzjuj.zzlq(paramString).zzbdo();
        localObject3 = zzjup;
        localObject1 = paramString.zzbde();
        localObject2 = new HashSet();
        localHashSet1 = new HashSet();
        localHashSet2 = new HashSet();
        localObject3 = ((Set)localObject3).iterator();
      }
      catch (Throwable paramString)
      {
        Object localObject3;
        Object localObject1;
        Object localObject2;
        HashSet localHashSet1;
        HashSet localHashSet2;
        com.google.android.android.internal.zzdbu localZzdbu;
        zzer localZzer;
        zzea localZzea;
        throw paramString;
      }
      if (((Iterator)localObject3).hasNext())
      {
        localZzdbu = (com.google.android.android.internal.zzdbu)((Iterator)localObject3).next();
        localZzer = ((zzfb)localObject1).zzbeb();
        localZzea = executeFunction(localZzdbu, (Set)localObject2, localZzer);
        if (((Boolean)localZzea.getObject()).booleanValue())
        {
          localHashSet1.addAll(localZzdbu.zzbhh());
          localHashSet2.addAll(localZzdbu.zzbhi());
          localZzer.zzbdz();
          localZzer.zzbea();
        }
        if ((!bool) || (!localZzea.zzbed())) {
          break label288;
        }
      }
      else
      {
        localHashSet1.removeAll(localHashSet2);
        localObject1 = ((Set)new zzea(localHashSet1, bool).getObject()).iterator();
        if (((Iterator)localObject1).hasNext())
        {
          localObject2 = (com.google.android.android.internal.zzdbq)((Iterator)localObject1).next();
          executeFunction(zzjuk, (com.google.android.android.internal.zzdbq)localObject2, new HashSet(), paramString.zzbdd());
          continue;
        }
        zzma(null);
        return;
      }
      boolean bool = true;
      continue;
      label288:
      bool = false;
    }
  }
  
  public final zzea zzlz(String paramString)
  {
    zzjus = 0;
    zzbn localZzbn = zzjuj.zzlp(paramString);
    return executeFunction(paramString, new HashSet(), localZzbn.zzbdn());
  }
}
