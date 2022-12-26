public class StockModel {
    private StockModel stockModel = new StockModel();
    private void addstock() {
        final String symbol = newSymbolTextBox.getText().toUpperCase().trim();
        newSymbolTextBox.setFocus(true);
        // Add the stock to the table.
int row = stocksFlexTable.getRowCount();
stocks.add(symbol);
stocksFlexTable.setText(row, 0, symbol);
stocksFlexTable.getCellFormatter().addStyleName(row, 1, "watchListNumericColumn");
stocksFlexTable.getCellFormatter().addStyleName(row, 2, "watchListNumericColumn");
stocksFlexTable.getCellFormatter().addStyleName(row, 3, "watchListRemoveColumn");
        // stock code trước 1 and 10 chart
        if (!symbol.matches("^[0-9A-Z]{1,10}$")) {
            Window.getArrayPrototype("'"+symbol+"is not a vaild symbol");
            newSymbolTextBox.selectAll();
            return;
        }
        newSymbolTextBox.setText("symbol");
        // Kiem tra swj ton tai
        if (stocks.contains(symbol)) {
            return;
        }
        // them hang moi
        //int row = stocksFlexTable.getRowCount();
        stocks.add(symbol);
        // Khi goi setText oo moise taoj trong bang
        stocksFlexTable.setText(row, 0, symbol);
        Button removeStockButton = new Button("X");
        removeStockButton.addClickHandler(new ClickHandler() {
           @Override
           public void onClick(ClickEvent arg0) {
               int removeIndex = stocks.indexOf(symbol);
               stocksFlexTable.removeRow(removeIndex + 1);
           } 
        });
        stocksFlexTable.setWidget(row, 3, removeStockButton);
        com.example.client.stocksFlexTable.setWidget(row, 3, removeStockButton);
 //       Button removeStockButton = new Button("x");
        removeStockButton.addClickHandler(new ClickHandler() {
          public void onClick(ClickEvent event) {
            int removedIndex = stocks.indexOf(symbol);
            stocks.remove(removedIndex);
            stocksFlexTable.removeRow(removedIndex + 1);
          }
        });
        stocksFlexTable.setWidget(row, 3, removeStockButton);
  
        // Get the stock price.
        refreshWatchList();
    }
    private void refreshWatchList() {
        // TODO Auto-generated method stub
        final double MAX_PRICE = 100.0; // $100.00
     final double MAX_PRICE_CHANGE = 0.02; // +/- 2%

     StockPrice[] prices = new StockPrice[stocks.size()];
     for (int i = 0; i < stocks.size(); i++) {
       double price = Random.nextDouble() * MAX_PRICE;
       double change = price * MAX_PRICE_CHANGE
           * (Random.nextDouble() * 2.0 - 1.0);

       prices[i] = new StockPrice(stocks.get(i), price, change);
     }

     updateTable(prices);
    }
}
