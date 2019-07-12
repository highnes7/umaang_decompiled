package f.fasterxml.jackson.core;

import f.d.a.a.s;
import java.io.Serializable;

public class Version
  implements Comparable<s>, Serializable
{
  public static final Version UNKNOWN_VERSION = new Version(0, 0, 0, null, null, null);
  public static final long serialVersionUID = 1L;
  public final String _artifactId;
  public final String _groupId;
  public final int _majorVersion;
  public final int _minorVersion;
  public final int _patchLevel;
  public final String _snapshotInfo;
  
  public Version(int paramInt1, int paramInt2, int paramInt3, String paramString)
  {
    this(paramInt1, paramInt2, paramInt3, paramString, null, null);
  }
  
  public Version(int paramInt1, int paramInt2, int paramInt3, String paramString1, String paramString2, String paramString3)
  {
    _majorVersion = paramInt1;
    _minorVersion = paramInt2;
    _patchLevel = paramInt3;
    _snapshotInfo = paramString1;
    String str = "";
    paramString1 = paramString2;
    if (paramString2 == null) {
      paramString1 = "";
    }
    _artifactId = paramString1;
    if (paramString3 == null) {
      paramString3 = str;
    }
    _groupId = paramString3;
  }
  
  public static Version unknownVersion()
  {
    return UNKNOWN_VERSION;
  }
  
  public int compareTo(Version paramVersion)
  {
    if (paramVersion == this) {
      return 0;
    }
    int j = _artifactId.compareTo(_artifactId);
    int i = j;
    if (j == 0)
    {
      j = _groupId.compareTo(_groupId);
      i = j;
      if (j == 0)
      {
        j = _majorVersion - _majorVersion;
        i = j;
        if (j == 0)
        {
          j = _minorVersion - _minorVersion;
          i = j;
          if (j == 0) {
            i = _patchLevel - _patchLevel;
          }
        }
      }
    }
    return i;
  }
  
  public boolean equals(Object paramObject)
  {
    if (paramObject == this) {
      return true;
    }
    if (paramObject == null) {
      return false;
    }
    if (paramObject.getClass() != s.class) {
      return false;
    }
    paramObject = (Version)paramObject;
    return (_majorVersion == _majorVersion) && (_minorVersion == _minorVersion) && (_patchLevel == _patchLevel) && (_groupId.equals(_groupId)) && (_artifactId.equals(_artifactId));
  }
  
  public String getArtifactId()
  {
    return _artifactId;
  }
  
  public String getGroupId()
  {
    return _groupId;
  }
  
  public int getMajorVersion()
  {
    return _majorVersion;
  }
  
  public int getMinorVersion()
  {
    return _minorVersion;
  }
  
  public int getPatchLevel()
  {
    return _patchLevel;
  }
  
  public int hashCode()
  {
    return _groupId.hashCode() ^ _artifactId.hashCode() + _majorVersion - _minorVersion + _patchLevel;
  }
  
  public boolean isSnapshot()
  {
    String str = _snapshotInfo;
    return (str != null) && (str.length() > 0);
  }
  
  public boolean isUknownVersion()
  {
    return this == UNKNOWN_VERSION;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(_majorVersion);
    localStringBuilder.append('.');
    localStringBuilder.append(_minorVersion);
    localStringBuilder.append('.');
    localStringBuilder.append(_patchLevel);
    if (isSnapshot())
    {
      localStringBuilder.append('-');
      localStringBuilder.append(_snapshotInfo);
    }
    return localStringBuilder.toString();
  }
}
