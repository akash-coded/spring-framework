package github.io.truongbn.paymentservice.model;

import lombok.Data;

@Data
public class Success implements Type {
    private final String msg;
}
