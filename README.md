Medical Chart
-------------
>Medical chart.

Model
-----
1. Glucose: datetime, level (1)
2. Med: datetime, type (2), dosage (3)

1. 0 - 300, 70 - 100 is normal
2. insulin, steroids
3. 1 - 100 

Chart
-----
1. X-Axis : DateTime - 72-hour range with 5-hour splits, bounded by min/max datetimes, displayed in 'd,hh:mm a' format.
2. Y-Axis : Measurement - Line (Glucose), Scatter(Med)

Test
----
sbt clean test

Run
---
sbt run