package org.jiang.unit.serivce;

import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.Objects;
import java.util.regex.Pattern;

/**
 * 校验服务
 */
@Service
public class VerifyService {
    static final Pattern NAME_PATTERN = Pattern.compile("^[\\u4e00-\\u9fa5]{0,20}$");
    static final Pattern EMAIL_PATTERN = Pattern.compile("^\\w+([-+.]\\w+)*@\\w+([-.]\\w+)*\\.\\w+([-.]\\w+)*$");
    static final Pattern PHONE_PATTERN = Pattern.compile("^(13[0-9]|14[01456879]|15[0-35-9]|16[2567]|17[0-8]|18[0-9]|19[0-35-9])\\d{8}$");

    /**
     * 是否是合法的id
     *
     * @param id id
     * @return 结果
     */
    public boolean isId(Long id) {
        return Objects.nonNull(id) && id > 0;
    }

    /**
     * 是否是正常的年龄
     *
     * @param age 年龄
     * @return 结果
     */
    public boolean isAge(Integer age) {
        return Objects.nonNull(age) && age >= 0 && age <= 100;
    }

    /**
     * 是否是合法的姓名
     *
     * @param name 姓名
     * @return 结果
     */
    public boolean isName(String name) {
        return !StringUtils.isEmpty(name) && NAME_PATTERN.matcher(name).matches();
    }

    /**
     * 是否是合法的邮箱
     *
     * @param email 邮箱
     * @return 结果
     */
    public boolean isEmail(String email) {
        return !StringUtils.isEmpty(email) && EMAIL_PATTERN.matcher(email).matches();
    }

    /**
     * 是否是合法的手机
     *
     * @param phone 手机
     * @return 结果
     */
    public boolean isPhone(String phone) {
        return !StringUtils.isEmpty(phone) && PHONE_PATTERN.matcher(phone).matches();
    }
}
