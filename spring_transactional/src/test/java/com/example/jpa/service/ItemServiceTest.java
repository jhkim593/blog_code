package com.example.jpa.service;

import com.example.jpa.repository.ItemRepository;
import org.assertj.core.api.Assertions;
import org.assertj.core.internal.bytebuddy.build.ToStringPlugin;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ItemServiceTest {

    @Autowired
    ItemService itemService;

    @Autowired
    ItemRepository itemRepository;

    /**
     * createItem1 메소드 테스트
     **/
    @Test
    public void createItem1() {

        assertThatThrownBy(() -> itemService.createItem1()).isInstanceOf(RuntimeException.class).hasMessage("insert exception");
        assertThat(itemRepository.findAll().size()).isEqualTo(4);
    }

    /**
     * createItem2 메소드 테스트
     **/
    @Test
    public void createItem2() {
        assertThatThrownBy(() -> itemService.createItem2()).isInstanceOf(RuntimeException.class).hasMessage("insert exception");
        assertThat(itemRepository.findAll().size()).isEqualTo(4);

    }
}