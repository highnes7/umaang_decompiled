package com.google.android.android.internal;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.Resources.NotFoundException;
import android.content.res.XmlResourceParser;
import android.text.TextUtils;
import java.io.IOException;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

public class zzant<T extends com.google.android.gms.internal.zzans>
  extends com.google.android.gms.internal.zzamr
{
  public com.google.android.gms.internal.zzanu<T> zzdqn;
  
  public zzant(zzamu paramZzamu, zzanu paramZzanu)
  {
    super(paramZzamu);
    zzdqn = paramZzanu;
  }
  
  private final zzans parse(XmlResourceParser paramXmlResourceParser)
  {
    try
    {
      paramXmlResourceParser.next();
      int i = paramXmlResourceParser.getEventType();
      while (i != 1)
      {
        i = paramXmlResourceParser.getEventType();
        if (i == 2)
        {
          Object localObject1 = paramXmlResourceParser.getName().toLowerCase();
          boolean bool = ((String)localObject1).equals("screenname");
          Object localObject2;
          Object localObject3;
          if (bool)
          {
            localObject1 = paramXmlResourceParser.getAttributeValue(null, "name");
            localObject2 = paramXmlResourceParser.nextText().trim();
            bool = TextUtils.isEmpty((CharSequence)localObject1);
            if (!bool)
            {
              bool = TextUtils.isEmpty((CharSequence)localObject2);
              if (!bool)
              {
                localObject3 = zzdqn;
                ((zzanu)localObject3).setPrivacyList((String)localObject1, (String)localObject2);
              }
            }
          }
          else
          {
            bool = ((String)localObject1).equals("string");
            if (bool)
            {
              localObject1 = paramXmlResourceParser.getAttributeValue(null, "name");
              localObject2 = paramXmlResourceParser.nextText().trim();
              bool = TextUtils.isEmpty((CharSequence)localObject1);
              if ((!bool) && (localObject2 != null))
              {
                localObject3 = zzdqn;
                ((zzanu)localObject3).tryParse((String)localObject1, (String)localObject2);
              }
            }
            else
            {
              bool = ((String)localObject1).equals("bool");
              if (bool)
              {
                localObject3 = paramXmlResourceParser.getAttributeValue(null, "name");
                localObject2 = paramXmlResourceParser.nextText().trim();
                localObject1 = localObject2;
                bool = TextUtils.isEmpty((CharSequence)localObject3);
                if (!bool)
                {
                  bool = TextUtils.isEmpty((CharSequence)localObject2);
                  if (!bool) {
                    try
                    {
                      bool = Boolean.parseBoolean((String)localObject2);
                      localObject2 = zzdqn;
                      ((zzanu)localObject2).toFile((String)localObject3, bool);
                    }
                    catch (NumberFormatException localNumberFormatException1)
                    {
                      localObject2 = "Error parsing bool configuration value";
                    }
                  }
                }
              }
              else
              {
                for (;;)
                {
                  append((String)localObject2, localObject1, localNumberFormatException1);
                  break;
                  bool = ((String)localObject1).equals("integer");
                  if (!bool) {
                    break;
                  }
                  String str = paramXmlResourceParser.getAttributeValue(null, "name");
                  localObject2 = paramXmlResourceParser.nextText().trim();
                  localObject1 = localObject2;
                  bool = TextUtils.isEmpty(str);
                  if (bool) {
                    break;
                  }
                  bool = TextUtils.isEmpty((CharSequence)localObject2);
                  if (bool) {
                    break;
                  }
                  try
                  {
                    i = Integer.parseInt((String)localObject2);
                    localObject2 = zzdqn;
                    ((zzanu)localObject2).toFile(str, i);
                  }
                  catch (NumberFormatException localNumberFormatException2)
                  {
                    localObject2 = "Error parsing int configuration value";
                  }
                }
              }
            }
          }
        }
        i = paramXmlResourceParser.next();
        continue;
        toString("Error parsing tracker configuration file", paramXmlResourceParser);
      }
    }
    catch (IOException paramXmlResourceParser) {}catch (XmlPullParserException paramXmlResourceParser) {}
    return zzdqn.zzxt();
  }
  
  public final zzans zzat(int paramInt)
  {
    try
    {
      zzans localZzans = parse(zzvw().zzwl().getResources().getXml(paramInt));
      return localZzans;
    }
    catch (Resources.NotFoundException localNotFoundException)
    {
      append("inflate() called with unknown resourceId", localNotFoundException);
    }
    return null;
  }
}
