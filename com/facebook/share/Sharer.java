package com.facebook.share;

public abstract interface Sharer
{
  public abstract boolean getShouldFailOnDataError();
  
  public abstract void setShouldFailOnDataError(boolean paramBoolean);
  
  public static class Result
  {
    public final String postId;
    
    public Result(String paramString)
    {
      postId = paramString;
    }
    
    public String getPostId()
    {
      return postId;
    }
  }
}
