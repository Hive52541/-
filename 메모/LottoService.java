package io8;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Random;
import java.util.Set;
import java.util.TreeSet;

public class LottoService {

    private LottoRepository lottoRepo = new LottoRepository();
    private OrderRepository orderRepo = new OrderRepository();

    public Order buy(int orderAmount) {
        
        public Order buy(int orderAmount){
            int lottoNo = this.getLottoNo();    
            long orderNo = System.currentTimeMillis();
            
          int count = orderAmount/1000;

          List<Set<Integer>> numbers = new ArrayList<>();
          for (int i = 1; i <= count; i++) {
            numbers.add(generateSet());
            
          }

        }

        Order order = new Order();
        order.setLottoNo(lottoNo);
        order.setOrderNo(orderNo);
        order.setNumbers(numbers);

        order.Repo.save(order);


        return order;
    }

    private int getLottoNo(){
        LocalDate today = LocalDate.now();
        String todayText = today.format(DateTimeFormatter.ofPattern("yyyyMMdd"));
        return Integer.parseInt(todayText);
    }

    private Set<Integer> generateSet(){
        Set<Integer> set = new TreeSet<Integer>();

        Random random = new Random();
        while (true) {
            int num = random.nextInt(45)+1;
            set.add(num);
            if (set.size()==6) {
                break;
                
            }

            
        }return set;
    }
    
}
