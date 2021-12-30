package sg.ctx.market.service;

import sg.ctx.market.domain.Order;

public interface OrderService {
    void addOrder(Long number, Integer orderBookIndex, Character verb, Long price, Long quantity );

    void deleteOrder(Long number);

    void updateOrder(Long number, Long originalOrderNumber, Long price, Long quantity);
}
