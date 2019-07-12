package f.org.objectweb.asm;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.XmlValue;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name="Bio", propOrder={"value"})
public class TlsProtocolHandler
{
  @XmlAttribute(required=true)
  public MathArrays.OrderDirection closed;
  @XmlValue
  public byte[] data;
  @XmlAttribute(required=true)
  public WeatherConditionType rs;
  
  public TlsProtocolHandler() {}
  
  public WeatherConditionType failWithError()
  {
    return rs;
  }
  
  public void processAlert(MathArrays.OrderDirection paramOrderDirection)
  {
    closed = paramOrderDirection;
  }
  
  public void processAlert(WeatherConditionType paramWeatherConditionType)
  {
    rs = paramWeatherConditionType;
  }
  
  public void processChangeCipherSpec(byte[] paramArrayOfByte)
  {
    data = paramArrayOfByte;
  }
  
  public MathArrays.OrderDirection readApplicationData()
  {
    return closed;
  }
  
  public byte[] writeData()
  {
    return data;
  }
}
