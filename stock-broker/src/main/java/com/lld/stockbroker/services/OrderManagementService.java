package com.lld.stockbroker.services;

import com.lld.stockbroker.Order.*;

public class OrderManagementService {
    private final AccountManagementService accountManagementService;
    private final TradeExecutionService tradeExecutionService;
    private final PortfolioManagementService portfolioManagementService;
    private final MarketDataService marketDataService;
    public OrderManagementService(AccountManagementService accountManagementService,
                                  TradeExecutionService tradeExecutionService,
                                  PortfolioManagementService portfolioManagementService,
                                  MarketDataService marketDataService){
        this.accountManagementService = accountManagementService;
        this.portfolioManagementService = portfolioManagementService;
        this.tradeExecutionService = tradeExecutionService;
        this.marketDataService = marketDataService;
    }
    public Order placeOrder(Order order){
        if(order.isValid()){
            //add validation logic if fund is present
            accountManagementService.updateAccount(order);
            portfolioManagementService.updatePortfolio(order);
            order.setOrderStatus(OrderStatus.PROCESSING);
            tradeExecutionService.process(order);
        }
        return order;
    }
}
