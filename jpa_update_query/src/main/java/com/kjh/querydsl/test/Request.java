package com.kjh.querydsl.test;

import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.DynamicUpdate;

import java.sql.Timestamp;

@Entity
@Getter
@Setter
@DynamicUpdate
public class Request {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String type;

    @Convert(converter = RequestTextConverter.class)
    @Column(columnDefinition="TEXT")
    private RequestText requestText;

    @Column(updatable = false)
    @CreationTimestamp
    private Timestamp insertTime;


    @Getter
    @Setter
    @EqualsAndHashCode
    public static class RequestText{
        private String type;
        private String target;
    }
}
