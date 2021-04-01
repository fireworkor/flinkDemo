package source

import org.apache.flink.streaming.api.scala._


object SourceTest4 {
  def main(args: Array[String]): Unit = {
    val env = StreamExecutionEnvironment.getExecutionEnvironment

    //4.从socket中获取数据  nc -lk 7777
        val stream4 = env.socketTextStream("localhost",7777)
        stream4.print()

    env.execute("source test")
  }
}

