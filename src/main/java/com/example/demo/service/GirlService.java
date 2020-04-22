package com.example.demo.service;

import com.example.demo.domain.Girl;
import com.example.demo.domain.Result;
import com.example.demo.enums.ResultEnum;
import com.example.demo.exception.GirlException;
import com.example.demo.repository.IGirlRepository;
import com.example.demo.utils.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

/**
 * Created by Daoshun
 * 2020/4/8 22:42
 */
@Service
public class GirlService {

    @Autowired
    private IGirlRepository iGirlRepository;

    /** 添加事物*/
    @Transactional
    public void insertTwo() {
        Girl girlA = new Girl();
        girlA.setCupSize("A");
        girlA.setAge(21);
        iGirlRepository.save(girlA);

        Girl girlB = new Girl();
        girlB.setCupSize("B");
        girlB.setAge(22);
        iGirlRepository.save(girlB);
    }

    /** 检测贵还是便宜*/
    public Result<Girl> getMoney(Integer id) {
        Girl girl = iGirlRepository.findById(id).orElse(null);
        if (girl != null) {
            Integer Money = girl.getMoney();
            if (Money < 500) {
                //
                return ResultUtil.moneyCheap(girl);
            } else if (Money >= 500) {
                return ResultUtil.moneyExpensive(girl);
            }

            return ResultUtil.error(0, "该金额不在判断范围内");
        }
        return ResultUtil.error(0, "查询不到该ID");

    }

    /** 判断该年龄*/
    public void getAge(Integer id) throws Exception {
        Girl girl = iGirlRepository.findById(id).orElse(null);
        if (girl != null) {
            Integer age = girl.getAge();
            if (age < 10) {
                //返回“该女生正在上小学”
                throw new GirlException(ResultEnum.PRIMARY_SCHOOL);
            } else if (age >= 10 && age < 20) {
                //返回“该女生正在上中学”
                throw new GirlException(ResultEnum.JUNIOR_SCHOOL);
            }
            throw new GirlException(ResultEnum.UNKNOW_AGE);
        }

        throw new GirlException(ResultEnum.UNKNOW_ID);

    }

}
