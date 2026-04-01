package com.interview.theater;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Movie {
    private String id;
    private String title;
    private String genre;
    private long durationMinutes;
    private String rating;
    private String langugae;

}
