package com.wzj.mapper;

import com.wzj.domain.Order;

import java.io.IOException;
import java.util.List;

public interface OrderMapper {
    public List<Order> findAll() throws IOException;
}
