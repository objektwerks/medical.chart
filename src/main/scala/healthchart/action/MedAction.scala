package healthchart.action

import java.awt.event.ActionEvent
import java.util.concurrent.atomic.AtomicInteger

import javax.swing.AbstractAction

import healthchart.Conf
import healthchart.chart.MedChart
import healthchart.entity.Transformer._
import healthchart.entity._
import healthchart.panel.ChartPanelBuilder
import healthchart.ui.{Frame, PathDialog}

class MedAction(name: String, frame: Frame) extends AbstractAction(name) {
  protected val counter = new AtomicInteger(1)

  def actionPerformed(event: ActionEvent): Unit = {
    val path = new PathDialog(frame, Conf.labelMedCsv).view
    path match {
      case Some( medCsvPath ) =>
        val meds = transformEntities[Med](medCsvPath)
        val chart = MedChart.build(meds)
        val chartPanel = ChartPanelBuilder.build(chart, meds)
        frame.addCompositeChartPanel(s"${Conf.titleMed}-${counter.getAndIncrement}", chartPanel)
      case None =>
    }
  }
}