package sink

import java.util.Properties;
import org.apache.flink.api.common.serialization.SimpleStringSchema
import org.apache.flink.streaming.api.scala._
import org.apache.flink.streaming.connectors.kafka.{FlinkKafkaConsumer, FlinkKafkaProducer}

object KafkaSinkTest {
  def main(args: Array[String]): Unit = {
    val env = StreamExecutionEnvironment.getExecutionEnvironment

    //从kafka中读取数据
        val props = new Properties();
        props.setProperty("bootstrap.servers", "192.168.0.200:9092")
        //每个消费者分配独立的组号
        props.setProperty("group.id", "test1")
        //如果value合法，则自动提交偏移量
        props.setProperty("enable.auto.commit", "true")
        //设置多久一次更新被消费消息的偏移量
        props.setProperty("auto.commit.interval.ms", "1000")
        //设置会话响应的时间，超过这个时间kafka可以选择放弃消费或者消费下一条消息
        props.setProperty("session.timeout.ms", "30000")
        //自动重置offset
        props.setProperty("auto.offset.reset", "earliest")
        props.setProperty("key.deserializer", "org.apache.kafka.common.serialization.StringDeserializer")
        props.setProperty("value.deserializer", "org.apache.kafka.common.serialization.StringDeserializer")
        var stream5 = env.addSource(new FlinkKafkaConsumer[String]("example", new SimpleStringSchema(), props))
//        stream5.print()

    stream5.addSink(new FlinkKafkaProducer[String]("leobin_sink_test", new SimpleStringSchema(), props) {})

    env.execute("source test")
  }
}

