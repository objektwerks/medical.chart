package medcharts.domain

import medcharts.domain.Logger._
import medcharts.domain.Validator._

import scala.collection.mutable
import scala.io.{Codec, Source}
import scala.reflect.ClassTag
import scala.util.{Failure, Success, Try}

object Transformer {
  private val utf8 = Codec.UTF8.name

  def transform[E: ClassTag](path: String,
                             delimiter: String = ",")(implicit validator: Validator[E]): Try[Entities[E]] =
    Try {
      val entities = mutable.ArrayBuilder.make[E]
      val invalidLines = mutable.ArrayBuilder.make[InvalidLine]
      val source = Source.fromFile(path, utf8)
      for (line <- source.getLines) {
        val columns = line.split(delimiter).map(_.trim)
        validate[E](columns) match {
          case Success(entity) => entities += entity
          case Failure(error) => invalidLines += InvalidLine(line, error)
        }
      }
      source.close()
      val (entitiesResult, invalidLinesResult) = (entities.result(), invalidLines.result())
      logEntitiesAndInvalidLines(entitiesResult, invalidLinesResult)
      new Entities[E](entitiesResult, invalidLinesResult)
    }
}