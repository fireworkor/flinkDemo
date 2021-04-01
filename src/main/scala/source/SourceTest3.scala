package source

import org.apache.flink.streaming.api.scala._

object SourceTest3 {
  def main(args: Array[String]): Unit = {
    val env = StreamExecutionEnvironment.getExecutionEnvironment

    //3.元素集中获取数据
    val stream3 = env.fromElements(132, 12321, "21313")
    stream3.print()

    env.execute("source test")
  }
}

