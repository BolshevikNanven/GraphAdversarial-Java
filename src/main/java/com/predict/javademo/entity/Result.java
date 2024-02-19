package com.predict.javademo.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Result implements Serializable {
    String originalPredict;
    String attackedPredict;
    String attackedImage;
}
