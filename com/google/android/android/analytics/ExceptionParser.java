package com.google.android.android.analytics;

public abstract interface ExceptionParser
{
  public abstract String getDescription(String paramString, Throwable paramThrowable);
}
