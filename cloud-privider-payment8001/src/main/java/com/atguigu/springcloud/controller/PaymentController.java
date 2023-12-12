package com.atguigu.springcloud.controller;

import com.atguigu.springcloud.entities.CommonResult;
import com.atguigu.springcloud.entities.Payment;
import com.atguigu.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@RequestMapping("payment")
@Slf4j
public class PaymentController {
    @Resource
    private PaymentService paymentService;

    @Value("${server.port}")
    private String serverPort;

    @PostMapping("create")
    public CommonResult create(@RequestBody Payment payment) {
        // 不用request是表单默认请求application/x-www-form-urlencoded,添加后处理json格式
        int result = paymentService.create(payment);
        log.info("插入结果:{}", result);
        if (result > 0) {
            return new CommonResult(CommonResult.CODE_SUCCESS, "插入数据库成功" + serverPort, result);
        } else {
            return new CommonResult(CommonResult.CODE_FAIL, "插入数据库失败", null);
        }
    }

    @GetMapping("get/{id}")
    public CommonResult getPaymentById(@PathVariable("id") Long id) {
        Payment payment = paymentService.getPaymentById(id);
        log.info("查询结果:{}", payment);
        if (payment != null) {
            return new CommonResult(CommonResult.CODE_SUCCESS, "查询成功" + serverPort, payment);
        } else {
            return new CommonResult(CommonResult.CODE_FAIL, "没有记录, 查询id", id);
        }
    }
}
