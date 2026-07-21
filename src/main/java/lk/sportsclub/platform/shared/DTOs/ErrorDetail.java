package lk.sportsclub.platform.shared.DTOs;

import java.time.LocalDateTime;

public record ErrorDetail(
        String code,
        String message,
        LocalDateTime timestamp
) {}
