package objektwerks.chart

import java.awt.BorderLayout
import java.awt.EventQueue

import javax.swing.BorderFactory
import javax.swing.JFrame
import javax.swing.WindowConstants

object App {
  val centerWindow = null
  def main(args: Array[String]): Unit = {
    EventQueue.invokeLater( new Runnable() {
      override def run(): Unit = {
        val chart = GlucoseMedsChart(glucoseCsvPath = "./data/glucose/glucose.txt",
                                     medsCsvPath = "./data/meds/meds.txt")
        chart.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15))
        val frame = new JFrame()
        frame.getContentPane.add(chart, BorderLayout.CENTER)
        frame.setTitle("MedCharts")
        frame.setSize(900, 600)
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE)
        frame.setLocationRelativeTo(centerWindow)
        frame.setVisible(true);
      }
    })
  }
}