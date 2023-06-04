package org.jiang.unit.mapper;

import org.apache.ibatis.annotations.*;
import org.jiang.unit.model.Account;

import java.util.List;

@Mapper
public interface AccountMapper {
    /**
     * 新增
     *
     * @param account 实体
     * @return 影响行数
     */
    int insert(Account account);

    /**
     * 根据ID删除
     *
     * @param id id
     * @return 影响行数
     */
    int deleteById(Long id);

    /**
     * 更新
     *
     * @param account 实体
     * @return 影响行数
     */
    int update(Account account);

    /**
     * 根据ID查询
     *
     * @param id id
     * @return 实体
     */
    Account queryById(Long id);

    /**
     * 查询全部
     *
     * @return 全部数据
     */
    List<Account> queryAll();
}
