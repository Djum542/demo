import com.gargoylesoftware.htmlunit.javascript.host.Window;
import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.KeyCodes;
import com.google.gwt.event.dom.client.KeyDownEvent;
import com.google.gwt.event.dom.client.KeyDownHandler;
import com.google.gwt.user.client.ui.RootPanel;
import cern.colt.Timer;
import java_cup.symbol;
public class StockWatcher implements EntryPoint {
    
          // Chi dinh toc do lam moi
    private static final int REFRESH_INTERVAL = 5000;
   // private VerticalPanel mainPanel = new VerticalPanel();
    /**
     * Entry point method.
     */
    public void onModuleLoad() {
      // TODO Create table for stock data.
      // TODO Assemble Add Stock panel.
      // TODO Assemble Main panel.
      // TODO Associate the Main panel with the HTML host page.
      // TODO Move cursor focus to the input box.
      // create table data
      stocksFlexTable.setText(0, 0, "Symbol");
    stocksFlexTable.setText(0, 1, "Price");
    stocksFlexTable.setText(0, 2, "Change");
    stocksFlexTable.setText(0, 3, "Remove");
    // add stock panel
    addPanel.add(newSymbolTextBox);
    addPanel.add(addStockButton);
    // Liên kêt với bản gốc
    mainPanel.add(newSymbolTextBox);
    mainPanel.add(addPanel);
    mainPanel.add(lastUpdatedLabel);
    // Gắn rootpanel đề xuât khai báo nhập chính xác.
    RootPanel.get("stocklist").add(mainPanel);
    RootPanel.get(stocklist).add(stocksFlexTable);
    // di chuyển con trỏ đến hộp nhập liệu để khi người dùng nhập hiển thị dữ liệu 
    newSymbolTextBox.setFocus(true);
    // Bắt sự kiện click
    addStockButton.addClickHandler(new ClickHandler() {
      public void onClick(ClickEvent event) {
        addstock();
      }  
    });
    // Listen mouse and add button 
    // listen keyboard events
    newSymbolTextBox.addKeyDownHandlerHandler(new KeyDownHandler() {
        public void onKeyDownHandler(KeyDownEvent event) {
            if (event.getNativeKeyCode() == KeyCodes.KEY_ENTER) {
                addstock();
            }
        }
    });
    refresherTimer.scheduleRepeating(REFRESH_INTERVAL);
    }
  }
