package com.thaopx.demoCRUD.models;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class TodoException {
    private String title;
    private String detail;
}


