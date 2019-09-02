package com.ecjtu.mapper;

import com.ecjtu.entity.AdoptAnimal;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;

/**
 * @author Mr Wu
 * @create: 2019-08-20 14:41
 */
public interface AdoptAnimalMapper {

    /**
     * 新增的领养
     * @param animal 新增的领养
     * @return int
     * */
    int addAdoptAnimal(AdoptAnimal animal);

    /**
     * 删除领养信息
     * @param id 领养的的id
     * @return int
     * */
    int deleteAdoptAnimal(Integer id);

    /**
     * 更新领养表的信息
     * @param animal 更新的领养表信息
     * @return int
     * */
    int updateAdoptAnimal(AdoptAnimal animal);

    /**
     * 更新领养表中动物的状态
     * @param animal 要领养宠物的id
     * @return int
     * */
    int updateAdoptState(AdoptAnimal animal);
    /**
     * 破除用户表外键关系
     * @param user_id 领养表的外键
     * */
    void  updateRelationUser(Integer user_id);

    /**
     * 破除宠物表的外键
     * @param pet_id 领养表的主键
     * */
    void  updateRelationPet(Integer pet_id);
    /**
     * 查询所有的领养信息
     * @return list
     * */
    List<AdoptAnimal> getAdoptAnimals();

    /**
    * 查询不同状态的动物
     * @param state  动物的状态
     * @return list
    * */
    List<AdoptAnimal> findByState(Integer state);
    /**
     * 根据领养id查询信息
     * @param id 用户id
     * @return adoptAnimal
     * */
    AdoptAnimal findById(Integer id);

    /**
     * 根据领养id查询信息
     * @param adoptTime 领养时间
     * @return adoptAnimal
     * */
     List<AdoptAnimal> findByAdoptTime(Date adoptTime);


    /**
     * 批量删除
     * @param ids id的集合
     * */
    void deleteBatch(@Param("ids")List<Integer>ids);
}
