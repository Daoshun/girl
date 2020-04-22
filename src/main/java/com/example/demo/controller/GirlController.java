package com.example.demo.controller;

import com.example.demo.aspect.HttpAspect;
import com.example.demo.domain.Girl;
import com.example.demo.domain.Result;
import com.example.demo.service.GirlService;
import com.example.demo.utils.ResultUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.bind.BindResult;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class GirlController {

    private final static Logger logger = LoggerFactory.getLogger(GirlController.class);

    //查询所有女列表
    @Autowired
    private com.example.demo.repository.IGirlRepository IGirlRepository;
    @Autowired
    private GirlService girlService;

    @RequestMapping(value = "/hello1", method = RequestMethod.GET)
    public String say() {
        return "Hello!";
    }

    @GetMapping(value = "/girls")
    public List<Girl> girlList() {

        logger.info("GirlList");
        System.out.println(222);
        return IGirlRepository.findAll();
    }

    /**
     * 添加一个女生
     * @param girl
     * @return girl
     * */
//    @PostMapping(value = "/girls")
//    public Girl girlAdd(@RequestParam("cupSize") String cupSize,
//                          @RequestParam("age") Integer age) {
//        Girl girl = new Girl();
//        girl.setCupSize(cupSize);
//        girl.setAge(age);
//
//        return  IGirlRepository.save(girl);
//    }
    // @valid 验证girl 结果返回到bindingResult
//    @PostMapping(value = "/girls")
//    public Girl girlAdd(@Valid Girl girl, BindingResult bindingResult ) {
//        if (bindingResult.hasErrors()){
//            System.out.println(bindingResult.getFieldError().getDefaultMessage());
//            return null;
//        }
//        girl.setCupSize(girl.getCupSize());
//        girl.setAge(girl.getAge());
//
//        return  IGirlRepository.save(girl);
//    }
    /** 统一异常处理 */
    @PostMapping(value = "/girls")
    public Result<Girl> girlAdd(@Valid Girl girl, BindingResult bindingResult ) {
        if (bindingResult.hasErrors()){

            // 获取错误信息
            return ResultUtil.error(0, bindingResult.getFieldError().getDefaultMessage());
        }

        girl.setCupSize(girl.getCupSize());
        girl.setAge(girl.getAge());

//        Result result = new Result();
//        result.setCode(1);
//        result.setMsg("成功");
//        result.setData(IGirlRepository.save(girl));
    return ResultUtil.success(girl);
    }
    // 查询一个
    @GetMapping(value = "/girls/{id}")
    public Girl girlFindOne(@PathVariable("id") Integer id) {
        return  IGirlRepository.findById(id).get();

    }

    // 更新
    @PutMapping(value = "/girls/{id}")
    public Girl girlUpdate(@PathVariable("id") Integer id,
                           @RequestParam("cupSize") String cupSize,
                           @RequestParam("age") Integer age) {
        Girl girl =new Girl();
        girl.setAge(id);
        girl.setAge(age);
        girl.setCupSize(cupSize);

        return IGirlRepository.save(girl);
    }
    // 删除
    @GetMapping(value = "/girls/delete/{id}")
    public void girlDelete(@PathVariable("id") Integer id) {
        IGirlRepository.deleteById(id);
    }
    // 根据年龄查询
    @GetMapping(value = "/girls/age/{age}")
    public List<Girl> girlFindByAge(@PathVariable("age") Integer age) {

        return IGirlRepository.findByAge(age);
    }

    // 事物管理
    @PostMapping(value = "/girls/two")
    public void girlTwo() {

        girlService.insertTwo();
    }

    /** 查询年龄*/
    @GetMapping(value = "girls/getMoney/{id}")
    public Result<Girl> getMoney(@PathVariable("id") Integer id) {

        return girlService.getMoney(id);
    }

    /** 查询年龄统一处理异常*/
    @GetMapping(value = "girls/getAge/{id}")
    public void getAge(@PathVariable("id") Integer id) throws Exception {
        girlService.getAge(id);
    }
}
