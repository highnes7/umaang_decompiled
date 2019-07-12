package com.facebook.share.internal;

import com.facebook.share.model.ShareOpenGraphAction;
import com.facebook.share.model.ShareOpenGraphObject;
import com.facebook.share.model.ShareOpenGraphValueContainer;
import com.facebook.share.model.SharePhoto;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class OpenGraphJSONUtility
{
  public OpenGraphJSONUtility() {}
  
  public static JSONArray toJSONArray(List paramList, PhotoJSONProcessor paramPhotoJSONProcessor)
    throws JSONException
  {
    JSONArray localJSONArray = new JSONArray();
    paramList = paramList.iterator();
    while (paramList.hasNext()) {
      localJSONArray.put(toJSONValue(paramList.next(), paramPhotoJSONProcessor));
    }
    return localJSONArray;
  }
  
  public static JSONObject toJSONObject(ShareOpenGraphAction paramShareOpenGraphAction, PhotoJSONProcessor paramPhotoJSONProcessor)
    throws JSONException
  {
    JSONObject localJSONObject = new JSONObject();
    Iterator localIterator = paramShareOpenGraphAction.keySet().iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      localJSONObject.put(str, toJSONValue(paramShareOpenGraphAction.getProperty(str), paramPhotoJSONProcessor));
    }
    return localJSONObject;
  }
  
  public static JSONObject toJSONObject(ShareOpenGraphObject paramShareOpenGraphObject, PhotoJSONProcessor paramPhotoJSONProcessor)
    throws JSONException
  {
    JSONObject localJSONObject = new JSONObject();
    Iterator localIterator = paramShareOpenGraphObject.keySet().iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      localJSONObject.put(str, toJSONValue(paramShareOpenGraphObject.getProperty(str), paramPhotoJSONProcessor));
    }
    return localJSONObject;
  }
  
  public static Object toJSONValue(Object paramObject, PhotoJSONProcessor paramPhotoJSONProcessor)
    throws JSONException
  {
    if (paramObject == null) {
      return JSONObject.NULL;
    }
    if ((!(paramObject instanceof String)) && (!(paramObject instanceof Boolean)) && (!(paramObject instanceof Double)) && (!(paramObject instanceof Float)) && (!(paramObject instanceof Integer)))
    {
      if ((paramObject instanceof Long)) {
        return paramObject;
      }
      if ((paramObject instanceof SharePhoto))
      {
        if (paramPhotoJSONProcessor != null) {
          return paramPhotoJSONProcessor.toJSONObject((SharePhoto)paramObject);
        }
        return null;
      }
      if ((paramObject instanceof ShareOpenGraphObject)) {
        return toJSONObject((ShareOpenGraphObject)paramObject, paramPhotoJSONProcessor);
      }
      if ((paramObject instanceof List)) {
        return toJSONArray((List)paramObject, paramPhotoJSONProcessor);
      }
      paramPhotoJSONProcessor = f.sufficientlysecure.rootcommands.util.StringBuilder.append("Invalid object found for JSON serialization: ");
      paramPhotoJSONProcessor.append(paramObject.toString());
      throw new IllegalArgumentException(paramPhotoJSONProcessor.toString());
    }
    return paramObject;
  }
  
  public static abstract interface PhotoJSONProcessor
  {
    public abstract JSONObject toJSONObject(SharePhoto paramSharePhoto);
  }
}
