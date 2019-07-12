package com.google.android.android.internal;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeSet;

public final class zzewo
{
  public static void parse(zzewl paramZzewl, StringBuilder paramStringBuilder, int paramInt)
  {
    HashMap localHashMap1 = new HashMap();
    HashMap localHashMap2 = new HashMap();
    Object localObject1 = new TreeSet();
    Object localObject2 = paramZzewl.getClass().getDeclaredMethods();
    int j = localObject2.length;
    int i = 0;
    while (i < j)
    {
      localObject3 = localObject2[i];
      localHashMap2.put(((Method)localObject3).getName(), localObject3);
      if (((Method)localObject3).getParameterTypes().length == 0)
      {
        localHashMap1.put(((Method)localObject3).getName(), localObject3);
        if (((Method)localObject3).getName().startsWith("get")) {
          ((Set)localObject1).add(((Method)localObject3).getName());
        }
      }
      i += 1;
    }
    Object localObject3 = ((Set)localObject1).iterator();
    while (((Iterator)localObject3).hasNext())
    {
      Object localObject4 = ((String)((Iterator)localObject3).next()).replaceFirst("get", "");
      if ((((String)localObject4).endsWith("List")) && (!((String)localObject4).endsWith("OrBuilderList")))
      {
        localObject1 = String.valueOf(((String)localObject4).substring(0, 1).toLowerCase());
        localObject2 = String.valueOf(((String)localObject4).substring(1, ((String)localObject4).length() - 4));
        if (((String)localObject2).length() != 0) {
          localObject1 = ((String)localObject1).concat((String)localObject2);
        } else {
          localObject1 = new String((String)localObject1);
        }
        if (((String)localObject4).length() != 0) {
          localObject2 = "get".concat((String)localObject4);
        } else {
          localObject2 = new String("get");
        }
        localObject2 = (Method)localHashMap1.get(localObject2);
        if ((localObject2 != null) && (((Method)localObject2).getReturnType().equals(List.class)))
        {
          write(paramStringBuilder, paramInt, zztm((String)localObject1), zzevh.get((Method)localObject2, paramZzewl, new Object[0]));
          continue;
        }
      }
      if (((String)localObject4).length() != 0) {
        localObject1 = "set".concat((String)localObject4);
      } else {
        localObject1 = new String("set");
      }
      if ((Method)localHashMap2.get(localObject1) != null) {
        if (((String)localObject4).endsWith("Bytes"))
        {
          localObject1 = String.valueOf(((String)localObject4).substring(0, ((String)localObject4).length() - 5));
          if (((String)localObject1).length() != 0) {
            localObject1 = "get".concat((String)localObject1);
          } else {
            localObject1 = new String("get");
          }
          if (localHashMap1.containsKey(localObject1)) {}
        }
        else
        {
          localObject1 = String.valueOf(((String)localObject4).substring(0, 1).toLowerCase());
          localObject2 = String.valueOf(((String)localObject4).substring(1));
          if (((String)localObject2).length() != 0) {
            localObject1 = ((String)localObject1).concat((String)localObject2);
          } else {
            localObject1 = new String((String)localObject1);
          }
          if (((String)localObject4).length() != 0) {
            localObject2 = "get".concat((String)localObject4);
          } else {
            localObject2 = new String("get");
          }
          Method localMethod = (Method)localHashMap1.get(localObject2);
          if (((String)localObject4).length() != 0) {
            localObject2 = "has".concat((String)localObject4);
          } else {
            localObject2 = new String("has");
          }
          localObject2 = (Method)localHashMap1.get(localObject2);
          if (localMethod != null)
          {
            localObject4 = zzevh.get(localMethod, paramZzewl, new Object[0]);
            boolean bool;
            if (localObject2 == null)
            {
              if ((localObject4 instanceof Boolean)) {
                if (((Boolean)localObject4).booleanValue()) {}
              }
              for (;;)
              {
                bool = true;
                break;
                label698:
                label722:
                label789:
                do
                {
                  do
                  {
                    do
                    {
                      do
                      {
                        do
                        {
                          bool = false;
                          break label811;
                          if (!(localObject4 instanceof Integer)) {
                            break;
                          }
                        } while (((Integer)localObject4).intValue() != 0);
                        break;
                        if (!(localObject4 instanceof Float)) {
                          break label698;
                        }
                      } while (((Float)localObject4).floatValue() != 0.0F);
                      break;
                      if (!(localObject4 instanceof Double)) {
                        break label722;
                      }
                    } while (((Double)localObject4).doubleValue() != 0.0D);
                    break;
                    if ((localObject4 instanceof String))
                    {
                      bool = localObject4.equals("");
                      break label811;
                    }
                    if ((localObject4 instanceof zzeuk))
                    {
                      bool = localObject4.equals(zzeuk.zzomx);
                      break label811;
                    }
                    if (!(localObject4 instanceof zzewl)) {
                      break label789;
                    }
                  } while (localObject4 != ((zzewl)localObject4).zzcuc());
                  break;
                } while ((!(localObject4 instanceof Enum)) || (((Enum)localObject4).ordinal() != 0));
              }
              label811:
              if (!bool) {
                bool = true;
              } else {
                bool = false;
              }
            }
            else
            {
              bool = ((Boolean)zzevh.get((Method)localObject2, paramZzewl, new Object[0])).booleanValue();
            }
            if (bool) {
              write(paramStringBuilder, paramInt, zztm((String)localObject1), localObject4);
            }
          }
        }
      }
    }
    if ((paramZzewl instanceof zzevm))
    {
      localObject1 = zzool.iterator();
      if (((Iterator)localObject1).hasNext())
      {
        ((Map.Entry)((Iterator)localObject1).next()).getKey();
        throw new NoSuchMethodError();
      }
    }
    paramZzewl = zzooe;
    if (paramZzewl != null) {
      paramZzewl.index(paramStringBuilder, paramInt);
    }
  }
  
  public static String safeString(zzewl paramZzewl, String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("# ");
    localStringBuilder.append(paramString);
    parse(paramZzewl, localStringBuilder, 0);
    return localStringBuilder.toString();
  }
  
  public static final void write(StringBuilder paramStringBuilder, int paramInt, String paramString, Object paramObject)
  {
    if ((paramObject instanceof List))
    {
      paramObject = ((List)paramObject).iterator();
      while (paramObject.hasNext()) {
        write(paramStringBuilder, paramInt, paramString, paramObject.next());
      }
      return;
    }
    paramStringBuilder.append('\n');
    int j = 0;
    int i = 0;
    while (i < paramInt)
    {
      paramStringBuilder.append(' ');
      i += 1;
    }
    paramStringBuilder.append(paramString);
    if ((paramObject instanceof String))
    {
      paramStringBuilder.append(": \"");
      paramStringBuilder.append(zzexf.zzaq(zzeuk.zzti((String)paramObject)));
      paramStringBuilder.append('"');
      return;
    }
    if ((paramObject instanceof zzeuk))
    {
      paramStringBuilder.append(": \"");
      paramStringBuilder.append(zzexf.zzaq((zzeuk)paramObject));
      paramStringBuilder.append('"');
      return;
    }
    if ((paramObject instanceof zzevh))
    {
      paramStringBuilder.append(" {");
      parse((zzevh)paramObject, paramStringBuilder, paramInt + 2);
      paramStringBuilder.append("\n");
      i = j;
      while (i < paramInt)
      {
        paramStringBuilder.append(' ');
        i += 1;
      }
      paramStringBuilder.append("}");
      return;
    }
    paramStringBuilder.append(": ");
    paramStringBuilder.append(paramObject.toString());
  }
  
  public static final String zztm(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    int i = 0;
    while (i < paramString.length())
    {
      char c = paramString.charAt(i);
      if (Character.isUpperCase(c)) {
        localStringBuilder.append("_");
      }
      localStringBuilder.append(Character.toLowerCase(c));
      i += 1;
    }
    return localStringBuilder.toString();
  }
}
