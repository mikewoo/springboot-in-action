package com.mikewoo.study.domain;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

/**
 * @author Eric Gui
 * @date 2019/1/3
 */
@Data
@Document("ay_device")
public class Device {

    @Field("_id")
    private String objectId;

    @Field("device_id")
    private Long id;

    @Field("device_number")
    private String deviceNumber;

    private String status;
}
