package com.cybercat.user.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class EditByAndTimeStamp {
    private Date createdDate;
    private String createdBy;
    private String modifyBy;
    private Date modifyDate;
}
