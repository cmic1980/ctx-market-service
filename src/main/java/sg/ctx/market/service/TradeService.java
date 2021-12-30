package sg.ctx.market.service;

import java.util.Date;

public interface TradeService {
    void saveRecentTrade(Long orderNumber, Long executedQuantity);
}
