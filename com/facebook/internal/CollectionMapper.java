package com.facebook.internal;

import com.facebook.FacebookException;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class CollectionMapper
{
  public CollectionMapper() {}
  
  public static void iterate(Collection paramCollection, ValueMapper paramValueMapper, final OnMapperCompleteListener paramOnMapperCompleteListener)
  {
    Object localObject1 = new Mutable(Boolean.valueOf(false));
    final Mutable localMutable = new Mutable(Integer.valueOf(1));
    paramOnMapperCompleteListener = new OnMapperCompleteListener()
    {
      public void onComplete()
      {
        if (((Boolean)val$didReturnError.value).booleanValue()) {
          return;
        }
        Mutable localMutable = localMutable;
        Integer localInteger = Integer.valueOf(((Integer)value).intValue() - 1);
        value = localInteger;
        if (localInteger.intValue() == 0) {
          paramOnMapperCompleteListener.onComplete();
        }
      }
      
      public void onError(FacebookException paramAnonymousFacebookException)
      {
        if (((Boolean)val$didReturnError.value).booleanValue()) {
          return;
        }
        val$didReturnError.value = Boolean.valueOf(true);
        paramOnMapperCompleteListener.onError(paramAnonymousFacebookException);
      }
    };
    localObject1 = paramCollection.keyIterator();
    Object localObject2 = new LinkedList();
    while (((Iterator)localObject1).hasNext()) {
      ((List)localObject2).add(((Iterator)localObject1).next());
    }
    localObject1 = ((List)localObject2).iterator();
    while (((Iterator)localObject1).hasNext())
    {
      final Object localObject3 = ((Iterator)localObject1).next();
      localObject2 = paramCollection.get(localObject3);
      localObject3 = new OnMapValueCompleteListener()
      {
        public void onComplete(Object paramAnonymousObject)
        {
          val$collection.putEntry(localObject3, paramAnonymousObject, paramOnMapperCompleteListener);
          paramOnMapperCompleteListener.onComplete();
        }
        
        public void onError(FacebookException paramAnonymousFacebookException)
        {
          paramOnMapperCompleteListener.onError(paramAnonymousFacebookException);
        }
      };
      Object localObject4 = value;
      Integer localInteger = (Integer)localObject4;
      value = Integer.valueOf(((Integer)localObject4).intValue() + 1);
      paramValueMapper.mapValue(localObject2, (OnMapValueCompleteListener)localObject3);
    }
    paramOnMapperCompleteListener.onComplete();
  }
  
  public static abstract interface Collection<T>
  {
    public abstract Object get(Object paramObject);
    
    public abstract Iterator keyIterator();
    
    public abstract void putEntry(Object paramObject1, Object paramObject2, CollectionMapper.OnErrorListener paramOnErrorListener);
  }
  
  public static abstract interface OnErrorListener
  {
    public abstract void onError(FacebookException paramFacebookException);
  }
  
  public static abstract interface OnMapValueCompleteListener
    extends CollectionMapper.OnErrorListener
  {
    public abstract void onComplete(Object paramObject);
  }
  
  public static abstract interface OnMapperCompleteListener
    extends CollectionMapper.OnErrorListener
  {
    public abstract void onComplete();
  }
  
  public static abstract interface ValueMapper
  {
    public abstract void mapValue(Object paramObject, CollectionMapper.OnMapValueCompleteListener paramOnMapValueCompleteListener);
  }
}
