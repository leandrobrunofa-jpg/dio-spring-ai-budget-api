package com.dio.budget.domain;

import java.math.BigDecimal;

public record Transaction(String description, BigDecimal amount, String type) {}
