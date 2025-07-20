package com.prime.ebp.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Event {
    private Integer id;
    private String name;
    private String description;
}
