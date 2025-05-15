package org.example;

public record Transaction(
        @FixedWidth(size = 10) String _id,
        @FixedWidth(size = 12) String date,
        @FixedWidth(size = 10) double amount,
        @FixedWidth(size = 10) String type,
        @FixedWidth(size = 10) String account
)
{}
