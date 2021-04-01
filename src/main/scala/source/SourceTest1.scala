package source

import org.apache.flink.streaming.api.scala._

case class InputTest(id: String, t1: Long, t2: Double)
object SourceTest1 {
  def main(args: Array[String]): Unit = {
    val env = StreamExecutionEnvironment.getExecutionEnvironment

    //    1.从集合中获取数据
    var dataList = List(
      source.InputTest("test1", 12344543, 34),
      source.InputTest("test3", 12344543, 34),
      source.InputTest("test2", 12344543, 34),
      source.InputTest("test4", 12344543, 34)
    )
    val stream1 = env.fromCollection(dataList)
    stream1.print()

    env.execute("source test")
  }
}

