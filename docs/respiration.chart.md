Chart
-----
1. X-Axis : Day,Hour ( d,H )
2. Y-Axis : Respiration ( breathesPerMinute )
3. Tooltip ( breathesPerMinute, delta )
4. Legend : Respiration
5. Title : Respiration : (y.m.d - y.m.d)

Model
-----
1. Respiration: datetime, breathesPerMinute (1)

Constraints
-----------
1. breathesPerMinute >= 12 && breathesPerMinute <= 25

Respiration
-----------
```scala
final case class Respiration(datetime: Minute, breathesPerMinute: Int)
```

Respiration CSV
---------------
>See data/respiration/respiration.txt
1. datetime - yyyy-MM-ddThh:mm:ss
2. breathesPerMinute - nn