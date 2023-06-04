package org.jiang.unit.model;

import lombok.Data;
import lombok.experimental.Accessors;

/**
 * 实体类
 */
@Data
@Accessors(chain = true)
public class Account {
    /**
     * 编号
     */
    private Long id;

    /**
     * 姓名
     */
    private String name;

    /**
     * 年龄
     */
    private Integer age;

    /**
     * 手机
     */
    private String phone;

    /**
     * 邮箱
     */
    private String email;
}
