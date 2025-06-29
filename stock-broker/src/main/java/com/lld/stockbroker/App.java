package com.lld.stockbroker;

import com.lld.stockbroker.Account.Account;
import com.lld.stockbroker.Account.AccountType;
import com.lld.stockbroker.Order.LimitOrder;
import com.lld.stockbroker.Order.Order;
import com.lld.stockbroker.Order.OrderSide;
import com.lld.stockbroker.Stock.Stock;
import com.lld.stockbroker.Stock.StockPosition;
import com.lld.stockbroker.services.*;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
        MarketDataService marketDataService = new MarketDataService();
        AccountManagementService accountManagementService = new AccountManagementService(marketDataService);
        TradeExecutionService tradeExecutionService = new TradeExecutionService(marketDataService);
        WatchListService watchListService = new WatchListService();
        PortfolioManagementService portfolioManagementService = new PortfolioManagementService(marketDataService);
        OrderManagementService orderManagementService = new OrderManagementService(
                accountManagementService,
                tradeExecutionService,
                portfolioManagementService,
                marketDataService);
        Account account = accountManagementService.createAccount(AccountType.INVESTOR);
        Stock stock = new Stock("AAPL","APPLE","NASDAQ", BigDecimal.valueOf(17_186));
        marketDataService.updateStockCache("AAPL",stock);
        Order order = new LimitOrder(account.getID(),"AAPL", OrderSide.BUY,10,BigDecimal.valueOf(10_000));
        orderManagementService.placeOrder(order);
        System.out.println(accountManagementService.getAccountById(account.getID()).getCashBalance().intValue());
        Map<String, StockPosition> stockPositionMap = portfolioManagementService.getStockPositions(account.getID());
        for(StockPosition stockPosition : stockPositionMap.values()){
            System.out.println(stockPosition);
        }
    }
}
