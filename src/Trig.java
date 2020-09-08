import java.math.BigDecimal;
 
public class Trig
{
         int scale;
  BigDecimal ebsilon;
 
  public Trig ( int sc)
  {
    scale   = sc;
    ebsilon = BigDecimal.ONE.divide( BigDecimal.TEN.pow( scale));
  }
 
  private BigDecimal calc ( BigDecimal angle
                          , BigDecimal firstPower
                          , BigDecimal firstTerm)
  {
    BigDecimal delta;
    BigDecimal angSqrd   = angle.multiply( angle);
    BigDecimal sum       = BigDecimal.ZERO;
    BigDecimal power     = firstPower;
    BigDecimal factorial = BigDecimal.ONE;
    BigDecimal sign      = BigDecimal.ONE;
    BigDecimal term      = firstTerm;
    for (; ; )
    { delta = power.divide( factorial, scale, BigDecimal.ROUND_HALF_UP);
      if (delta.compareTo( ebsilon) < 0)
      { return sum;
      }
      sum   = sum.add( delta.multiply( sign));
      power = power.multiply( angSqrd);
      factorial
        = factorial.multiply( term = term.add( BigDecimal.ONE))
                   .multiply( term = term.add( BigDecimal.ONE));
      sign = sign.negate();
    }
  }
 
  public BigDecimal sin ( BigDecimal angle)
  {
    return calc( angle, angle, BigDecimal.ONE);
  }
 
  public BigDecimal cos ( BigDecimal angle)
  {
    return calc( angle, BigDecimal.ONE, BigDecimal.ZERO);
  }
 
  public BigDecimal tan ( BigDecimal angle)
  {
    return sin( angle).divide( cos( angle), scale, BigDecimal.ROUND_HALF_UP);
  }
}
