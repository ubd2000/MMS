package jpabook.jpashop.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jpabook.jpashop.domain.item.Item;
import lombok.Getter;
import lombok.Setter;

/**
 * @author DongMin Kim
 */
@Entity
@Getter
@Setter
public class OrderItem {

    @Id @GeneratedValue
    @Column(name = "order_item_id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "item_id")
    private Item item;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "order_id")
    @JsonIgnore //양방향 연관관계에서 한쪽을 JsonIgnore로 설정해야 한다.
    private Order order;

    //주문 가격
    private int orderPrice;
    //주문 수량
    private int count;

    /**
     * 생성 메서드
     * @param item
     * @param orderPrice
     * @param count
     * @return
     */
    public static OrderItem createOrderItem(Item item, int orderPrice, int count) {
        OrderItem orderItem = new OrderItem();
        orderItem.setItem(item);
        orderItem.setOrderPrice(orderPrice);
        orderItem.setCount(count);

        item.removeStock(count);
        return orderItem;
    }

    /**
     * 비즈니스 로직
     */
    public void cancel() {
        getItem().addStock(count);
    }

    /**
     * 주문 상품 전체 가격 조회
     * @return
     */
    public int getTotalPrice() {
        return getOrderPrice() * getCount();
    }
}
