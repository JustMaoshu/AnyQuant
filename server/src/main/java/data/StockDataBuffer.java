package data;

import observer.Observable;
import observer.Observer;
import po.StockPO;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by user on 2016/3/9.
 */
public class StockDataBuffer {
    public static List<StockPO> stockPOs_sh = new ArrayList<StockPO>();
    public static List<StockPO> stockPOs_sz = new ArrayList<StockPO>();


    public List<StockPO> getStockData_today_sh_buffer(){
        return stockPOs_sh;
    }


}
