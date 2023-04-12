package com.example.jpa.service;


import com.example.jpa.dto.OrderCreateDto;
import com.example.jpa.dto.OrderDto;
import com.example.jpa.dto.OrderItemCreateDto;
import com.example.jpa.entity.*;
import com.example.jpa.repository.ItemRepository;
import com.example.jpa.repository.MemberRepository;
import com.example.jpa.repository.OrderRepository;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.annotations.BatchSize;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.util.ArrayList;
import java.util.List;

import static com.example.jpa.entity.QDelivery.delivery;
import static com.example.jpa.entity.QMember.member;
import static com.example.jpa.entity.QOrder.order;

@Service
@RequiredArgsConstructor
@Slf4j
public class OrderService {
    private final MemberRepository memberRepository;
    private final ItemRepository itemRepository;
    private final OrderRepository orderRepository;
    private JPAQueryFactory jpaQueryFactory;
    private final EntityManager em;

    @Transactional
    public Long createOrder(OrderCreateDto createDto) {

        //엔티티 조회
        Member member = memberRepository.findById(createDto.getMemberId()).orElse(null);
        //배송정보 생성
        Delivery delivery = new Delivery();
        delivery.setAddress(member.getAddress());
        delivery.setStatus(DeliveryStatus.READY);

        List<OrderItem> orderItems = new ArrayList<>();
        for (OrderItemCreateDto orderItemCreateDto : createDto.getOrderItems()) {
            //주문상품 생성
            Item item = itemRepository.findById(orderItemCreateDto.getItemId()).orElse(null);
            OrderItem orderItem = OrderItem.createOrderItem(item, item.getPrice(), orderItemCreateDto.getCount());
            orderItems.add(orderItem);
        }

        //주문 생성
        Order order = Order.createOrder(member, delivery, orderItems);

        //주문 저장
        orderRepository.save(order);

        return order.getId();

    }

    /**
     * fetch join
     **/
    public List<OrderDto> getOrder1() {
        jpaQueryFactory = new JPAQueryFactory(em);
        List<Order> orders = jpaQueryFactory.select(order).from(order)
                .join(order.delivery, delivery)
                .join(order.member, member)
                .fetch();
        return null;
    }


    /**
     * order 조회
     **/
    public List<OrderDto> getOrder0() {
        List<Order> orders = em.createQuery("select o from Order o", Order.class).getResultList();
        for (Order order1 : orders) {
            order1.getMember().getName();
            order1.getDelivery().getAddress();
            for (OrderItem orderItem : order1.getOrderItems()) {
                orderItem.getItem().getName();
            }
        }
        return null;
    }

    /**
     * 컬렉션 포함 페치조인
     **/
    public List<Order> getOrder2() {
        List<Order> orders = em.createQuery(
                "select distinct o from  Order o " +
                        "join fetch o.member m " +
                        "join fetch o.delivery d " +
                        "join fetch o.orderItems oi", Order.class)
                .getResultList();

        for (Order order : orders) {
            log.info("{}, id  : {}", order, order.getId());
        }
        return orders;
    }

    /**
     * 컬렉션 포함 페치조인 페이징
     **/
    public List<Order> getOrder3(int offset, int limit) {
        List<Order> orders = em.createQuery(
                "select distinct o from  Order o " +
                        "join fetch o.member m " +
                        "join fetch o.delivery d " +
                        "join fetch o.orderItems oi", Order.class)
                .setFirstResult(offset)
                .setMaxResults(limit)
                .getResultList();

        for (Order order : orders) {
            log.info("{}, id  : {}", order, order.getId());
        }
        return orders;
    }

    /**
     * 배치 페치 사이즈로 조회
     **/
    public List<Order> getOrder4() {
        List<Order> orders = em.createQuery(
                "select o from  Order o " +
                        "join fetch o.member m " +
                        "join fetch o.delivery d", Order.class)
                .getResultList();

        for (Order order1 : orders) {
            for (OrderItem orderItem : order1.getOrderItems()) {
                orderItem.getItem().getPrice();
            }
        }
        return orders;
    }

    /**
     * 배치 페치 사이즈로 처리
     * 페이징
     **/
    public List<Order> getOrder5(int offset , int limit) {
        List<Order> orders = em.createQuery(
                "select distinct o from  Order o " +
                        "join fetch o.member m " +
                        "join fetch o.delivery d", Order.class)
                .setFirstResult(offset)
                .setMaxResults(limit)
                .getResultList();

        for (Order order1 : orders) {
            for (OrderItem orderItem : order1.getOrderItems()) {
                orderItem.getItem().getPrice();
            }
        }
        return orders;
    }
}
