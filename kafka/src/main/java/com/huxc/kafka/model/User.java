package com.huxc.kafka.model;

import lombok.*;

@Data
@Builder
@AllArgsConstructor
@RequiredArgsConstructor
@NoArgsConstructor
public class User {
    @NonNull
    private String username;
    private int age;
}
