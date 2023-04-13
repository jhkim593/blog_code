package com.example.jpa.service;

import com.example.jpa.entity.Item;
import com.example.jpa.repository.ItemRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.cglib.proxy.Enhancer;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class ItemService {
    private final ItemRepository itemRepository;

    /**
     * DB insert 메소드
     **/
    @Transactional
    public void insertItem(Item item) {
        item.setStatus("CREATED");
        itemRepository.save(item);
    }


    public void createItem1() {
        for (int i = 0; i < 4; i++) {
            Item item = new Item();
            item.setName("item"+i);
            item.setCount(10);
            item.setCode("test");

            insertItem(item);
        }
        throw new RuntimeException("insert exception");

    }

    @Transactional
    public void createItem2() {
        for (int i = 0; i < 4; i++) {
            Item item = new Item();
            item.setName("item"+i);
            item.setCount(10);
            item.setCode("test");

            insertItem(item);
        }

        throw new RuntimeException("insert exception");

    }
}
