package com.interview.theater;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class MovieRequest {
    String title;
    String genre;
    long durationMinutes;
    String rating;
    String langugae;
}
