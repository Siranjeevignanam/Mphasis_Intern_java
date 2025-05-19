package pojo;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
@JsonIgnoreProperties(ignoreUnknown = true)

public record Transaction(String cus_id, String trans_id, double amount, String timestamp) {}
