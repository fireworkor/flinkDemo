//package source
//
//import java.util.{Properties, Random}
//
//import org.apache.flink.api.common.serialization.SimpleStringSchema
//import org.apache.flink.streaming.api.functions.source.SourceFunction
//import org.apache.flink.streaming.api.scala._
//import org.apache.flink.streaming.connectors.kafka.{FlinkKafkaConsumer, FlinkKafkaProducer}
//
//case class InputTest(id: String, t1: Long, t2: Double)
//
//object SourceTest {
//  def main(args: Array[String]): Unit = {
//    val env = StreamExecutionEnvironment.getExecutionEnvironment
//
//    //1.从集合中获取数据
//    //    var dataList=List(
//    //      source.InputTest("test1",12344543,34),
//    //      source.InputTest("test3",12344543,34),
//    //      source.InputTest("test2",12344543,34),
//    //      source.InputTest("test4",12344543,34)
//    //    )
//    //    val stream1 = env.fromCollection(dataList)
//    //    stream1.print()
//    //2.从文件中获取数据
////        val stream2 = env.readTextFile("data/input/1.txt")
////        stream2.print()
//    //3.从socket中获取数据
//    //    val stream3 = env.fromElements(132,12321,"21313")
//    //    stream3.print()
//    //4.从kafka中获取数据  nc -lk 7777
//    //    val stream4 = env.socketTextStream("localhost",7777)
//    //    stream4.print()
//    //5.从kafka中读取数据
//        val props = new Properties();
//        props.setProperty("bootstrap.servers", "192.168.0.200:9092")
//        //每个消费者分配独立的组号
//        props.setProperty("group.id", "test4")
//        //如果value合法，则自动提交偏移量
//        props.setProperty("enable.auto.commit", "true")
//        //设置多久一次更新被消费消息的偏移量
//        props.setProperty("auto.commit.interval.ms", "1000")
//        //设置会话响应的时间，超过这个时间kafka可以选择放弃消费或者消费下一条消息
//        props.setProperty("session.timeout.ms", "30000")
//        //自动重置offset
//        props.setProperty("auto.offset.reset", "earliest")
//        props.setProperty("key.deserializer", "org.apache.kafka.common.serialization.StringDeserializer")
//        props.setProperty("value.deserializer", "org.apache.kafka.common.serialization.StringDeserializer")
//        var stream5 = env.addSource(new FlinkKafkaConsumer[String]("example", new SimpleStringSchema(), props))
////        stream5.print()
//
//    stream5.addSink(new FlinkKafkaProducer[String]("leobin_sink_test", new SimpleStringSchema(), props) {})
//
////    var stream6 = env.addSource(new source.MySource())
//
//    //自定义sourceFunction
////    stream6.print()
//
//    env.execute("source test")
//  }
//}
//
////定义一个自定义source
//class MySource() extends SourceFunction[InputTest] {
//  //定义给一个标识flag 数据源是否正常运行
//  var running: Boolean = true
//
//  override def cancel(): Unit = running = false
//
//  override def run(sourceContext: SourceFunction.SourceContext[InputTest]): Unit = {
//    val rand = new Random()
//    var i = 0
//    while (running) {
//      sourceContext.collect(InputTest("test", i, rand.nextDouble()))
//      i = i + 1
//      Thread.sleep(1000)
//    }
//  }
//}
//
