package sg.ctx.market.listener;

import com.alibaba.fastjson.JSONObject;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.annotation.KafkaListeners;
import org.springframework.kafka.annotation.TopicPartition;
import org.springframework.stereotype.Component;
import sg.ctx.market.domain.Order;
import sg.ctx.market.message.itch.MessageType;
import sg.ctx.market.message.itch.total.AddOrder;
import sg.ctx.market.message.itch.total.OrderExecuted;
import sg.ctx.market.service.OrderService;
import sg.ctx.market.service.TradeService;

@Component
public class OrderListener {
    private static final Logger LOGGER = LoggerFactory.getLogger(OrderListener.class);

    @Autowired
    private TradeService tradeService;

    @Autowired
    private OrderService orderService;

    @KafkaListeners(value = {@KafkaListener(topicPartitions = {@TopicPartition(topic = "itch-order", partitions = {"0"})}, groupId = "ctx-market-service")})
    public void listener(ConsumerRecord<?, ?> cr) {

        LOGGER.debug("ConsumerRecord topic:{}, offset:{}, partition: {}, timestamp:{}, pavalue:{}", cr.topic(), cr.offset(), cr.partition(), cr.timestamp(), cr.value());

        var content = cr.value().toString();
        var jsonObject = JSONObject.parseObject(content);
        var messageId = jsonObject.getByte("messageId");

        switch (messageId) {
            case MessageType.AddOrder: {
                var addOrder = jsonObject.toJavaObject(sg.ctx.market.message.itch.total.AddOrder.class);
                var number = addOrder.getOrderNumber();
                var orderBookIndex = addOrder.getOrderBook();
                var price = addOrder.getPrice();
                var quantity = addOrder.getQuantity();
                var orderVerb = addOrder.getOrderVerb();

                this.orderService.addOrder(number, orderBookIndex, orderVerb, price, quantity);
            }
            break;
            case MessageType.OrderDelete: {
                var orderDelete = jsonObject.toJavaObject(sg.ctx.market.message.itch.total.OrderDelete.class);
                var orderNumber = orderDelete.getOrderNumber();
                this.orderService.deleteOrder(orderNumber);
            }
            break;
            case MessageType.OrderReplace: {
                var orderReplace = jsonObject.toJavaObject(sg.ctx.market.message.itch.total.OrderReplace.class);
                var orderNumber = orderReplace.getNewOrderNumber();
                var originalOrderNumber = orderReplace.getOriginalOrderNumber();
                var quantity = orderReplace.getQuantity();
                var price = orderReplace.getPrice();
                this.orderService.updateOrder(orderNumber, originalOrderNumber, price, quantity);
            }
            break;
            case MessageType.OrderExecuted: {
                var orderExecuted = jsonObject.toJavaObject(OrderExecuted.class);
                var orderNumber = orderExecuted.getOrderNumber();
                var executedQuantity = orderExecuted.getExecutedQuantity();
                this.tradeService.saveRecentTrade(orderNumber, executedQuantity);
            }
            break;
        }

    }
}
