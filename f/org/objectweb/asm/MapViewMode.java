package f.org.objectweb.asm;

import f.q.a.c.f;
import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;

@XmlEnum
@XmlType(name="gender")
public enum MapViewMode
{
  MAPNIK_TILE_DOWNLOAD,  OPENCYCLEMAP_TILE_DOWNLOAD,  OSMARENDER_TILE_DOWNLOAD;
  
  public static MapViewMode js_lastIndexOf(String paramString)
  {
    return valueOf(paramString);
  }
  
  public String doBackward()
  {
    return name();
  }
}
