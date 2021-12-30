package sg.ctx.market.service.Impl;

import sg.ctx.market.domain.Order;
import sg.ctx.market.service.OrderService;

import java.util.concurrent.ConcurrentHashMap;

public class OrderServiceImpl implements OrderService {
    private ConcurrentHashMap<Long, Order> cacheOrderMap = new ConcurrentHashMap<>();

    @Override
    public void addOrder(Long number, Integer orderBookIndex, Character verb, Long price, Long quantity) {
        var order = new Order();
        order.setNumber(number);
        order.setOrderBookIndex(orderBookIndex);
        order.setOrderVerb(verb);
        order.setPrice(price);
        order.setQuantity(quantity);
        this.cacheOrderMap.put(number, order);
    }

    @Override
    public void deleteOrder(Long number) {
        this.cacheOrderMap.remove(number);
    }

    @Override
    public void updateOrder(Long number, Long originalOrderNumber, Long quantity, Long price) {
        // 获取原来Order
        var originalOrder = this.cacheOrderMap.get(originalOrderNumber);

        var orderBookIndex = originalOrder.getOrderBookIndex();
        var order = new Order();
        order.setNumber(number);
        order.setPrice(price);
        order.setQuantity(quantity);
        // 使用原来 order的 order book 和 verb
        order.setOrderVerb(originalOrder.getOrderVerb());
        order.setOrderBookIndex(orderBookIndex);
        this.cacheOrderMap.put(number, order);
    }
}
