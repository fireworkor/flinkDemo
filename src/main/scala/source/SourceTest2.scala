package source

import org.apache.flink.streaming.api.scala._


object SourceTest2 {
  def main(args: Array[String]): Unit = {
    val env = StreamExecutionEnvironment.getExecutionEnvironment

    //2.从文件中获取数据
    val stream2 = env.readTextFile("data/input/1.txt")
    stream2.print()

    env.execute("source test")
  }
}
