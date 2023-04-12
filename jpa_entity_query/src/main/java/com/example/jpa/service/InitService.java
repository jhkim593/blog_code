package com.example.jpa.service;

import com.example.jpa.dto.OrderCreateDto;
import com.example.jpa.dto.OrderItemCreateDto;
import com.example.jpa.entity.Address;
import com.example.jpa.entity.Item;
import com.example.jpa.entity.Member;
import com.example.jpa.entity.OrderItem;
import com.example.jpa.repository.ItemRepository;
import com.example.jpa.repository.MemberRepository;
import com.example.jpa.repository.OrderRepository;
import com.github.javafaker.Faker;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Service
@RequiredArgsConstructor
public class InitService {

    private final MemberRepository memberRepository;
    private final ItemRepository itemRepository;
    private final OrderService orderService;

    @Transactional
    public void init(){
        Faker faker = new Faker();
        Random random = new Random();
        for(int i=0; i<1000;i++) {
            Item item = new Item();
            item.setName(faker.name().firstName());
            item.setPrice(faker.random().nextInt(1,100000));
            item.setStockQuantity(faker.random().nextInt(1,1000));
            itemRepository.save(item);

            Member member =new Member();
            Address address = new Address(faker.address().city(),faker.address().streetName(),faker.address().zipCode());
            member.setName(faker.name().firstName());
            member.setAddress(address);
            memberRepository.save(member);
        }

        for(int i=0;i<30000;i++){
            OrderCreateDto orderCreateDto = new OrderCreateDto();

            List<OrderItemCreateDto> orderItemCreateDtos = new ArrayList<>();

            int orderItemCount = random.nextInt(2) + 1;

            for (int j=0; j<orderItemCount;j++){

                OrderItemCreateDto orderItemCreateDto = new OrderItemCreateDto();
                orderItemCreateDto.setCount(1);
                orderItemCreateDto.setItemId(Long.valueOf(random.nextInt(990)+1));
                orderItemCreateDtos.add(orderItemCreateDto);
            }


            orderCreateDto.setMemberId(Long.valueOf(random.nextInt(990)+1));
            orderCreateDto.setOrderItems(orderItemCreateDtos);
            orderService.createOrder(orderCreateDto);
        }
    }

}
